package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   NumericalFloatData = NumericalFloatData.TYPE.DEF

object NumericalFloatData extends Float.Opaque.Data.Numerical[NumericalFloatData]("NumericalFloatData"):
  inline   def apply(inline v: Float)            : NumericalFloatData = v.toOpaque                         // Base type constructor
  override def value_tag   (v:NumericalFloatData): String             = v.toString + ".NumericalFloatData" // Custom tag
  override def value_isVoid(v:NumericalFloatData): Boolean            = v.real == 0                        // Optional void definition

  implicit inline def implicitFrom(v: \/)        : NumericalFloatData = apply(0.toFloat)                   // Optional void request

  extension (inline x: NumericalFloatData)                                                                 // Custom methods
    inline def nextRound : NumericalFloatData = (x.real + 1).toLong.toFloat.toOpaque
    inline def priorRound: NumericalFloatData = (x.real - 1).toLong.toFloat.toOpaque

  object TYPE:
    opaque type DEF <: Float.Opaque = Float.Opaque

