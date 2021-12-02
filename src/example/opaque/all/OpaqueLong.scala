package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueLong = OpaqueLong.TYPE.DEF

object OpaqueLong extends Long.Opaque.Base[OpaqueLong]("OpaqueLong"):
  inline   def apply(inline v: Long)     : OpaqueLong = v.toOpaque                  // Base type constructor
  override def value_tag   (v:OpaqueLong): String     = v.toString + ".OpaqueLong"  // Custom tag
  override def value_isVoid(v:OpaqueLong): Boolean    = v.real == 0                 // Optional void definition

  implicit inline def implicitFrom(v:VOID): OpaqueLong = apply(0.toLong)             // Optional void request

  extension (inline x: OpaqueLong)                                                  // Custom methods
    inline def next : OpaqueLong = (x.real + 1).toOpaque
    inline def prior: OpaqueLong = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque

