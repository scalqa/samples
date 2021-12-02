package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   NumericalByteData = NumericalByteData.TYPE.DEF

object NumericalByteData extends Byte.Opaque.Data.Numerical[NumericalByteData]("NumericalByteData"):
  inline   def apply(inline v: Byte)            : NumericalByteData = v.toOpaque                        // Base type constructor
  override def value_tag   (v:NumericalByteData): String            = v.toString + ".NumericalByteData" // Custom tag
  override def value_isVoid(v:NumericalByteData): Boolean           = v.real == 0                       // Optional void definition

  implicit inline def implicitFrom(v:VOID)       : NumericalByteData = apply(0.toByte)                   // Optional void request

  extension (inline x: NumericalByteData)                                                               // Custom methods
    inline def next : NumericalByteData = (x.real + 1).toByte.toOpaque
    inline def prior: NumericalByteData = (x.real - 1).toByte.toOpaque

  object TYPE:
    opaque type DEF <: Byte.Opaque = Byte.Opaque

