package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueByte = OpaqueByte.TYPE.DEF

object OpaqueByte extends Byte.Opaque.Base[OpaqueByte]("OpaqueByte"):
  inline   def apply(inline v: Byte)     : OpaqueByte = v.toOpaque                   // Base type constructor
  override def value_tag   (v:OpaqueByte): String     = v.toString + ".OpaqueByte"   // Custom tag
  override def value_isVoid(v:OpaqueByte): Boolean    = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v: \/): OpaqueByte = apply(0.toByte)              // Optional void request

  extension (inline x: OpaqueByte)                                                   // Custom methods
    inline def next : OpaqueByte = (x.real + 1).toByte.toOpaque
    inline def prior: OpaqueByte = (x.real - 1).toByte.toOpaque

  object TYPE:
    opaque type DEF <: Byte.Opaque = Byte.Opaque

