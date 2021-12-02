package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   CalculableDoubleData = CalculableDoubleData.TYPE.DEF

object CalculableDoubleData extends Double.Opaque.Data.Calculable[CalculableDoubleData]("CalculableDoubleData"):
  inline   def apply(inline v: Double)             : CalculableDoubleData = v.toOpaque                           // Base type constructor
  override def value_tag   (v:CalculableDoubleData): String               = v.toString + ".CalculableDoubleData" // Custom tag
  override def value_isVoid(v:CalculableDoubleData): Boolean              = v.real == 0                          // Optional void definition

  implicit inline def implicitFrom(v:VOID)          : CalculableDoubleData = apply(0.toDouble)                    // Optional void request

  extension (inline x: CalculableDoubleData)                                                                     // Custom methods
    inline def nextRound : CalculableDoubleData = (x.real + 1).toLong.toDouble.toOpaque
    inline def priorRound: CalculableDoubleData = (x.real - 1).toLong.toDouble.toOpaque

  object TYPE:
    opaque type DEF <: Double.Opaque = Double.Opaque

