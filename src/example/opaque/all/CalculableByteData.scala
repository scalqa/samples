package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   CalculableByteData = CalculableByteData.TYPE.DEF

object CalculableByteData extends Byte.Opaque.Data.Calculable[CalculableByteData]("CalculableByteData"):
  inline   def apply(inline v: Byte)             : CalculableByteData = v.toOpaque                         // Base type constructor
  override def value_tag   (v:CalculableByteData): String             = v.toString + ".CalculableByteData" // Custom tag
  override def value_isVoid(v:CalculableByteData): Boolean            = v.real == 0                        // Optional void definition

  implicit inline def implicitFrom(v: \/)        : CalculableByteData = apply(0.toByte)                    // Optional void request

  extension (inline x: CalculableByteData)                                                                 // Custom methods
    inline def next : CalculableByteData = (x.real + 1).toByte.toOpaque
    inline def prior: CalculableByteData = (x.real - 1).toByte.toOpaque

  object TYPE:
    opaque type DEF <: Byte.Opaque = Byte.Opaque

