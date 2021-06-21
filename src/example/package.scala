import language.implicitConversions

package object example:
  val Lang = scalqa.Lang
  val Val  = scalqa.Val
  val Gen  = scalqa.Gen
  val J    = scalqa.J
  lazy val Fx = scalqa.Fx

  export Lang.*
  export Gen.*
  export Gen.Request.*
  export Val.{ ~ as _, * }
  @scala.annotation.targetName("Stream") type ~[+A] = Val.~[A]
  @scala.annotation.targetName("Stream") val  ~~    = Val.~
  export scalqa.j.vm.Predef.given

