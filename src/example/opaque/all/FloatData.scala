package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   FloatData = FloatData.TYPE.DEF

object FloatData extends Float.Opaque.Data[FloatData]("FloatData"):
  inline   def apply(inline v: Float)    : FloatData = v.toOpaque                  // Base type constructor
  override def value_tag   (v:FloatData) : String    = v.toString + ".FloatData"   // Custom tag
  override def value_isVoid(v:FloatData) : Boolean   = v.real == 0                 // Optional void definition

  implicit inline def implicitFrom(v: \/): FloatData = apply(0.toFloat)            // Optional void request

  extension (inline x: FloatData)                                                  // Custom methods
    inline def nextRound : FloatData = (x.real + 1).toLong.toFloat.toOpaque
    inline def priorRound: FloatData = (x.real - 1).toLong.toFloat.toOpaque

  object TYPE:
    opaque type DEF <: Float.Opaque = Float.Opaque

