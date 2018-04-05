scalaVersion := "2.12.4"

libraryDependencies += ("org.scala-lang.modules" % "scala-asm" % "6.0.0-scala-1").withConfigurations(Some(Configurations.ScalaTool.name + "->default,optional(default)"))

scalaInstance := {
  val orig = scalaInstance.value
  val scalaAsmJars: List[File] = update.value.configuration(Configurations.ScalaTool).get.modules.find(x => x.module.name == "scala-asm").toList.flatMap(_.artifacts).map(_._2)
  import java.net.URLClassLoader
  if (orig.loader.getClass != classOf[URLClassLoader]) sys.error("Can't patch: " + orig.loader.getClass)
  val ucl = orig.loader.asInstanceOf[URLClassLoader]
  val newClassLoader = new URLClassLoader(scalaAsmJars.map(_.toURI.toURL).toArray ++ ucl.getURLs, ucl.getParent)
  new sbt.internal.inc.ScalaInstance(orig.version, newClassLoader, orig.loaderLibraryOnly, orig.libraryJar, orig.compilerJar, (scalaAsmJars ++ orig.allJars).toArray, orig.explicitActual)
}
