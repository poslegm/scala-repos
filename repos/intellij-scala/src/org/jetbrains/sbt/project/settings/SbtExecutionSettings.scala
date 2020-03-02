package org.jetbrains.sbt
package project.settings

import java.io.File

import com.intellij.openapi.externalSystem.model.settings.ExternalSystemExecutionSettings

/**
  * @author Pavel Fatin
  */
class SbtExecutionSettings(
    val realProjectPath: String,
    val vmExecutable: File,
    val vmOptions: Seq[String],
    val environment: Map[String, String],
    val customLauncher: Option[File],
    val customSbtStructureFile: Option[File],
    val jdk: Option[String],
    val resolveClassifiers: Boolean,
    val resolveJavadocs: Boolean,
    val resolveSbtClassifiers: Boolean
) extends ExternalSystemExecutionSettings
