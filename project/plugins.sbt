resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Kamon Releases" at "http://repo.kamon.io"

addSbtPlugin("com.typesafe.sbt" % "sbt-aspectj" %  "0.10.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.8.0-RC1")
