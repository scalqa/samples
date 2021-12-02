package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   CalculableFloatData = CalculableFloatData.TYPE.DEF

object CalculableFloatData extends Float.Opaque.Data.Calculable[CalculableFloatData]("CalculableFloatData"):
  inline   def apply(inline v: Float)             : CalculableFloatData = v.toOpaque                          // Base type constructor
  override def value_tag   (v:CalculableFloatData): String              = v.toString + ".CalculableFloatData" // Custom tag
  override def value_isVoid(v:CalculableFloatData): Boolean             = v.real == 0                         // Optional void definition

  implicit inline def implicitFrom(v:VOID)         : CalculableFloatData = apply(0.toFloat)                    // Optional void request

  extension (inline x: CalculableFloatData)                                                                   // Custom methods
    inline def nextRound : CalculableFloatData = (x.real + 1).toLong.toFloat.toOpaque
    inline def priorRound: CalculableFloatData = (x.real - 1).toLong.toFloat.toOpaque

  object TYPE:
    opaque type DEF <: Float.Opaque = Float.Opaque

