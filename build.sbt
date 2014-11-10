import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtAspectj._

import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

aspectjSettings

name := "kamon-newrelic-example"
 
version := "1.0"
 
scalaVersion := "2.11.4"

resolvers += "Kamon repo" at "http://repo.kamon.io"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= {
  val akkaV = "2.3.5"
  val sprayV = "1.3.1"
  val kamonV = "0.3.4"
  Seq(
    "io.spray"            %%  "spray-can"      % sprayV,
    "io.spray"            %%  "spray-routing"  % sprayV,
    "io.spray"            %%  "spray-testkit"  % sprayV  % "test",
    "io.kamon"            %% "kamon-core"     % kamonV,
    "io.kamon"            %% "kamon-spray"    % kamonV,
    "io.kamon"            %% "kamon-newrelic" % kamonV,
    "com.newrelic.agent.java" % "newrelic-agent" % "3.11.0"
  )
}

javaOptions <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true

packageArchetype.java_application
