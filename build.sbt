import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtAspectj._

import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

aspectjSettings

name := "kamon-newrelic-example"
 
version := "1.0"
 
scalaVersion := "2.10.3"

resolvers += "Kamon repo" at "http://repo.kamon.io"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies += "io.kamon" %%  "kamon-core" % "0.3.2"

libraryDependencies += "io.kamon" %%  "kamon-spray" % "0.3.2"

libraryDependencies += "io.kamon" %%  "kamon-newrelic" % "0.3.2"

libraryDependencies += "io.spray" %  "spray-can"  % "1.2.2"

libraryDependencies += "com.newrelic.agent.java" % "newrelic-agent" % "3.5.0"

javaOptions <++= AspectjKeys.weaverOptions in Aspectj

packageArchetype.java_application
