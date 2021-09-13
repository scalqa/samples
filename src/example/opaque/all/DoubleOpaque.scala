package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   DoubleOpaque = DoubleOpaque.TYPE.DEF

object DoubleOpaque extends Double.Opaque.Base[DoubleOpaque]("DoubleOpaque"):
  inline   def apply(inline v: Double)     : DoubleOpaque = v.toOpaque                    // Base type constructor
  override def value_tag   (v:DoubleOpaque): String       = v.toString + ".DoubleOpaque"  // Custom tag
  override def value_isVoid(v:DoubleOpaque): Boolean      = v.real == 0                   // Optional void definition

  implicit inline def implicitFrom(v: \/)  : DoubleOpaque = apply(0.toDouble)             // Optional void request

  extension (inline x: DoubleOpaque)                                                      // Custom methods
    inline def nextRound : DoubleOpaque = (x.real + 1).toLong.toDouble.toOpaque
    inline def priorRound: DoubleOpaque = (x.real - 1).toLong.toDouble.toOpaque

  object TYPE:
    opaque type DEF <: Double.Opaque = Double.Opaque

