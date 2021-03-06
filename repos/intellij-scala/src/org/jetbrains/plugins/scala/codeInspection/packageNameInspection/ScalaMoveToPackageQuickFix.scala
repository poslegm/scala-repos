package org.jetbrains.plugins.scala
package codeInspection
package packageNameInspection

import com.intellij.CommonBundle
import com.intellij.codeInsight.FileModificationService
import com.intellij.ide.util.PackageUtil
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.{ProjectFileIndex, ProjectRootManager}
import com.intellij.openapi.ui.Messages
import com.intellij.psi._
import com.intellij.refactoring.PackageWrapper
import com.intellij.refactoring.move.moveClassesOrPackages.{MoveClassesOrPackagesProcessor, SingleSourceRootMoveDestination}
import com.intellij.refactoring.util.RefactoringMessageUtil
import org.jetbrains.plugins.scala.extensions._
import org.jetbrains.plugins.scala.lang.psi.api.ScalaFile
import org.jetbrains.plugins.scala.lang.refactoring.move.ScalaMoveUtil

/**
  * User: Alexander Podkhalyuzin
  * Date: 08.07.2009
  */
class ScalaMoveToPackageQuickFix(myFile: ScalaFile, packQualName: String)
    extends AbstractFixOnPsiElement(
        s"Move File ${myFile.name} To Package " + packQualName, myFile) {
  def doApplyFix(project: Project): Unit = {
    val file = getElement
    if (!file.isValid) return
    if (!FileModificationService.getInstance.prepareFileForWrite(file)) return
    val packageName = packQualName
    val fileIndex: ProjectFileIndex =
      ProjectRootManager.getInstance(project).getFileIndex
    val currentModule: Module = fileIndex.getModuleForFile(file.getVirtualFile)
    val directory = PackageUtil.findOrCreateDirectoryForPackage(
        currentModule, packageName, null, true)

    if (directory == null) {
      return
    }
    val error = RefactoringMessageUtil.checkCanCreateFile(directory, file.name)
    if (error != null) {
      Messages.showMessageDialog(
          project, error, CommonBundle.getErrorTitle, Messages.getErrorIcon)
      return
    }
    ScalaMoveUtil.saveMoveDestination(file, directory)
    new MoveClassesOrPackagesProcessor(
        project,
        Array[PsiElement](file.typeDefinitions.head),
        new SingleSourceRootMoveDestination(
            PackageWrapper.create(
                JavaDirectoryService.getInstance().getPackage(directory)),
            directory),
        false,
        false,
        null).run()
  }

  override def getFamilyName: String = "Move File To Package"
}
