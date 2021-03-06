/*
 * Copyright 2007-2012 WorldWide Conferencing, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.liftweb
package builtin
package snippet

import net.liftweb.http._
import scala.xml._

/**
  * Display Blueprint CSS headers
  */
object CSS extends DispatchSnippet {
  def dispatch: DispatchIt = {
    case "blueprint" =>
      _ =>
        blueprint
      case "fancyType" =>
      _ =>
        fancyType
  }

  /**
    * Add
    *
    * <pre name="code" class="xml">
    * &lt;style class="lift:CSS.blueprint"></style>
    * </pre>
    *
    * to your template and Lift will replace it with the path to the blueprint css styles
    * (screen and print media)
    */
  def blueprint: NodeSeq = {
    <xml:group>
      <link rel="stylesheet" href={"/" + LiftRules.resourceServerPath +
                                   "/blueprint/screen.css"} type="text/css"
        media="screen, projection"/>
      <link rel="stylesheet" href={"/" + LiftRules.resourceServerPath +
                                   "/blueprint/print.css"} type="text/css" media="print"/>
    </xml:group> ++ Unparsed("""
  <!--[if IE]><link rel="stylesheet" href=""" + '"' +
        S.contextPath + """/""" + LiftRules.resourceServerPath +
        """/blueprint/ie.css" type="text/css" media="screen, projection"><![endif]-->
    """)
  }

  /**
    * Add
    *
    * <pre name="code" class="xml">
    * &lt;style class="lift:CSS.fancyType"></style>
    * </pre>
    *
    * to your template and Lift will replace it with the path to the blueprint fancy-type plugin
    * css styles
    * (screen media)
    */
  def fancyType: NodeSeq = {
    <link rel="stylesheet" href={"/" + LiftRules.resourceServerPath +
                                 "/blueprint/plugins/fancy-type/screen.css"}
      type="text/css" media="screen, projection"/>
  }
}
