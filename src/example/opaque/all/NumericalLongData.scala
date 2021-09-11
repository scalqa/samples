package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   NumericalLongData = NumericalLongData.TYPE.DEF

object NumericalLongData extends Long.Opaque.Data.Numerical[NumericalLongData]("NumericalLongData"):
  inline   def apply(inline v: Long)            : NumericalLongData = v.toOpaque                        // Base type constructor
  override def value_tag   (v:NumericalLongData): String            = v.toString + ".NumericalLongData" // Custom tag
  override def value_isVoid(v:NumericalLongData): Boolean           = v.real == 0                       // Optional void definition

  implicit inline def implicitFrom(v: \/)       : NumericalLongData = apply(0.toLong)                   // Optional void request

  extension (inline x: NumericalLongData)                                                               // Custom methods
    inline def next : NumericalLongData = (x.real + 1).toOpaque
    inline def prior: NumericalLongData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque

