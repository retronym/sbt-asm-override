# Upgrade `scala-asm` used by `scalac`

## Vanilla Scala 2.12.4
```
⚡ sbt
[info] Loading settings from dirtymoney.sbt,gpg.sbt,idea.sbt ...
[info] Loading global plugins from /Users/jz/.sbt/1.0/plugins
[info] Loading project definition from /Users/jz/code/sbt-asm-override/project
[info] Loading settings from build.sbt ...
[info] Set current project to sbt-asm-override (in build file:/Users/jz/code/sbt-asm-override/)
[info] sbt server started at local:///Users/jz/.sbt/1.0/server/63789fa72b26a4016948/sock
sbt:sbt-asm-override> consoleQuick
[info] Updating ...
[info] Done updating.
[info] Starting scala interpreter...
Welcome to Scala 2.12.4 (Java HotSpot(TM) 64-Bit Server VM, Java 10).
Type in expressions for evaluation. Or try :help.

scala> classOf[scala.tools.asm.ClassReader].getProtectionDomain.getCodeSource
res0: java.security.CodeSource = (file:/Users/jz/.sbt/boot/scala-2.12.4/lib/scala-compiler.jar <no signer certificates>)

scala>
[success] Total time: 4 s, completed 5 Apr. 2018, 7:03:34 pm
sbt:sbt-asm-override> [info] shutting down server
```

## With `scalaInstance` customization herein

```
⚡ sbt
[info] Loading settings from dirtymoney.sbt,gpg.sbt,idea.sbt ...
[info] Loading global plugins from /Users/jz/.sbt/1.0/plugins
[info] Loading project definition from /Users/jz/code/sbt-asm-override/project
[info] Loading settings from build.sbt ...
[info] Set current project to sbt-asm-override (in build file:/Users/jz/code/sbt-asm-override/)
[info] sbt server started at local:///Users/jz/.sbt/1.0/server/63789fa72b26a4016948/sock
sbt:sbt-asm-override> show scalaInstance
[info] Updating ...
[info] Done updating.
[info] Scala instance { version label 2.12.4, actual version 2.12.4, library jar: /Users/jz/.sbt/boot/scala-2.12.4/lib/scala-library.jar, compiler jar: /Users/jz/.sbt/boot/scala-2.12.4/lib/scala-compiler.jar, other jars: /Users/jz/.ivy2/cache/org.scala-lang.modules/scala-asm/bundles/scala-asm-6.0.0-scala-1.jar, /Users/jz/.sbt/boot/scala-2.12.4/lib/jline.jar, /Users/jz/.sbt/boot/scala-2.12.4/lib/scala-reflect.jar, /Users/jz/.sbt/boot/scala-2.12.4/lib/scala-xml_2.12.jar }
[success] Total time: 0 s, completed 5 Apr. 2018, 7:03:52 pm
sbt:sbt-asm-override> consoleQuick
[info] Starting scala interpreter...
Welcome to Scala 2.12.4 (Java HotSpot(TM) 64-Bit Server VM, Java 10).
Type in expressions for evaluation. Or try :help.

scala> classOf[scala.tools.asm.ClassReader].getProtectionDomain.getCodeSource
res0: java.security.CodeSource = (file:/Users/jz/.ivy2/cache/org.scala-lang.modules/scala-asm/bundles/scala-asm-6.0.0-scala-1.jar <no signer certificates>)
```