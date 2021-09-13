package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   ByteData = ByteData.TYPE.DEF

object ByteData extends Byte.Opaque.Data[ByteData]("ByteData"):
  inline   def apply(inline v: Byte)   : ByteData   = v.toOpaque                   // Base type constructor
  override def value_tag   (v:ByteData): String     = v.toString + ".ByteData"     // Custom tag
  override def value_isVoid(v:ByteData): Boolean    = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v: \/): ByteData = apply(0.toByte)              // Optional void request

  extension (inline x: ByteData)                                                   // Custom methods
    inline def next : ByteData = (x.real + 1).toByte.toOpaque
    inline def prior: ByteData = (x.real - 1).toByte.toOpaque

  object TYPE:
    opaque type DEF <: Byte.Opaque = Byte.Opaque

