package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   FloatOpaque = FloatOpaque.TYPE.DEF

object FloatOpaque extends Float.Opaque.Base[FloatOpaque]("FloatOpaque"):
  inline   def apply(inline v: Float)     : FloatOpaque = v.toOpaque                   // Base type constructor
  override def value_tag   (v:FloatOpaque): String      = v.toString + ".FloatOpaque"  // Custom tag
  override def value_isVoid(v:FloatOpaque): Boolean     = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v: \/) : FloatOpaque = apply(0.toFloat)             // Optional void request

  extension (inline x: FloatOpaque)                                                    // Custom methods
    inline def nextRound : FloatOpaque = (x.real + 1).toLong.toFloat.toOpaque
    inline def priorRound: FloatOpaque = (x.real - 1).toLong.toFloat.toOpaque

  object TYPE:
    opaque type DEF <: Float.Opaque = Float.Opaque

