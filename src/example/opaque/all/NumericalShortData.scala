package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   NumericalShortData = NumericalShortData.TYPE.DEF

object NumericalShortData extends Short.Opaque.Data.Numerical[NumericalShortData]("NumericalShortData"):
  inline   def apply(inline v: Short)            : NumericalShortData = v.toOpaque                         // Base type constructor
  override def value_tag   (v:NumericalShortData): String             = v.toString + ".NumericalShortData" // Custom tag
  override def value_isVoid(v:NumericalShortData): Boolean            = v.real == 0                        // Optional void definition

  implicit inline def implicitFrom(v: \/)        : NumericalShortData = apply(0.toShort)                   // Optional void request

  extension (inline x: NumericalShortData)                                                                 // Custom methods
    inline def next : NumericalShortData = (x.real + 1).toShort.toOpaque
    inline def prior: NumericalShortData = (x.real - 1).toShort.toOpaque

  object TYPE:
    opaque type DEF <: Short.Opaque = Short.Opaque

