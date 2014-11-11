import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

name := "kamon-newrelic-example"
 
version := "1.0"
 
scalaVersion := "2.11.4"

resolvers += "Kamon repo" at "http://repo.kamon.io"

resolvers += "Kamon snapshot repo" at "http://snapshots.kamon.io"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= {
  val akkaV = "2.3.5"
  val sprayV = "1.3.1"
  val kamonV = "0.3.5-4b884d86c6d30cc49e195a1ff962bd92ad33d010"
  Seq(
    "io.spray"            %% "spray-can"      % sprayV,
    "io.spray"            %% "spray-routing"  % sprayV,
    "io.spray"            %% "spray-testkit"  % sprayV  % "test",
    "io.kamon"            %% "kamon-core"     % kamonV,
    "io.kamon"            %% "kamon-spray"    % kamonV,
    "io.kamon"            %% "kamon-newrelic" % kamonV,
    "io.kamon"            %% "kamon-log-reporter" % kamonV,
    "org.aspectj"         %  "aspectjweaver"  % "1.8.4",
    "com.newrelic.agent.java" % "newrelic-agent" % "3.11.0"
  )
}

packageArchetype.java_application
