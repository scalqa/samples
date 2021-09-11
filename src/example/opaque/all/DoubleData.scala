package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   DoubleData = DoubleData.TYPE.DEF

object DoubleData extends Double.Opaque.Data[DoubleData]("DoubleData"):
  inline   def apply(inline v: Double)   : DoubleData = v.toOpaque                   // Base type constructor
  override def value_tag   (v:DoubleData): String     = v.toString + ".DoubleData"   // Custom tag
  override def value_isVoid(v:DoubleData): Boolean    = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v: \/): DoubleData = apply(0.toDouble)            // Optional void request

  extension (inline x: DoubleData)                                                   // Custom methods
    inline def nextRound : DoubleData = (x.real + 1).toLong.toDouble.toOpaque
    inline def priorRound: DoubleData = (x.real - 1).toLong.toDouble.toOpaque

  object TYPE:
    opaque type DEF <: Double.Opaque = Double.Opaque

