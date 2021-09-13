package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   ByteOpaque = ByteOpaque.TYPE.DEF

object ByteOpaque extends Byte.Opaque.Base[ByteOpaque]("ByteOpaque"):
  inline   def apply(inline v: Byte)     : ByteOpaque = v.toOpaque                   // Base type constructor
  override def value_tag   (v:ByteOpaque): String     = v.toString + ".ByteOpaque"   // Custom tag
  override def value_isVoid(v:ByteOpaque): Boolean    = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v: \/): ByteOpaque = apply(0.toByte)              // Optional void request

  extension (inline x: ByteOpaque)                                                   // Custom methods
    inline def next : ByteOpaque = (x.real + 1).toByte.toOpaque
    inline def prior: ByteOpaque = (x.real - 1).toByte.toOpaque

  object TYPE:
    opaque type DEF <: Byte.Opaque = Byte.Opaque

