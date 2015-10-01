name := "spark-sandbox"

organization := "com.shzhangji"

version := "0.1.0"

scalaVersion := "2.10.5"

libraryDependencies ++= {
  val sparkVersion = "1.5.1"
  Seq(
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "com.github.scopt" %% "scopt" % "3.3.0",
    "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-graphx" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-streaming-kafka" % sparkVersion intransitive(),
    ("org.apache.kafka" %% "kafka" % "0.8.2.1").
      exclude("com.sun.jmx", "jmxri").
      exclude("com.sun.jdmk", "jmxtools").
      exclude("net.sf.jopt-simple", "jopt-simple").
      exclude("org.slf4j", "slf4j-simple").
      exclude("org.apache.zookeeper", "zookeeper")
  )
}

runMain in Compile <<= Defaults.runMainTask(fullClasspath in Compile, runner in (Compile, run))
