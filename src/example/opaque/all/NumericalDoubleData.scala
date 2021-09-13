package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   NumericalDoubleData = NumericalDoubleData.TYPE.DEF

object NumericalDoubleData extends Double.Opaque.Data.Numerical[NumericalDoubleData]("NumericalDoubleData"):
  inline   def apply(inline v: Double)            : NumericalDoubleData = v.toOpaque                          // Base type constructor
  override def value_tag   (v:NumericalDoubleData): String              = v.toString + ".NumericalDoubleData" // Custom tag
  override def value_isVoid(v:NumericalDoubleData): Boolean             = v.real == 0                         // Optional void definition

  implicit inline def implicitFrom(v: \/)         : NumericalDoubleData = apply(0.toDouble)                   // Optional void request

  extension (inline x: NumericalDoubleData)                                                                   // Custom methods
    inline def nextRound : NumericalDoubleData = (x.real + 1).toLong.toDouble.toOpaque
    inline def priorRound: NumericalDoubleData = (x.real - 1).toLong.toDouble.toOpaque

  object TYPE:
    opaque type DEF <: Double.Opaque = Double.Opaque

