package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   NumericalIntData = NumericalIntData.TYPE.DEF

object NumericalIntData extends Int.Opaque.Data.Numerical[NumericalIntData]("NumericalIntData"):
  inline   def apply(inline v: Int)            : NumericalIntData = v.toOpaque                       // Base type constructor
  override def value_tag   (v:NumericalIntData): String           = v.toString + ".NumericalIntData" // Custom tag
  override def value_isVoid(v:NumericalIntData): Boolean          = v.real == 0                      // Optional void definition

  implicit inline def implicitFrom(v:VOID)      : NumericalIntData = apply(0.toInt)                   // Optional void request

  extension (inline x: NumericalIntData)                                                             // Custom methods
    inline def next : NumericalIntData = (x.real + 1).toOpaque
    inline def prior: NumericalIntData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

