package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   SequentialIntData = SequentialIntData.TYPE.DEF

object SequentialIntData extends Int.Opaque.Data.Sequential[SequentialIntData]("SequentialIntData"):
  inline   def apply(inline v: Int)             : SequentialIntData = v.toOpaque                        // Base type constructor
  override def value_tag   (v:SequentialIntData): String            = v.toString + ".SequentialIntData" // Custom tag
  override def value_isVoid(v:SequentialIntData): Boolean           = v.real == 0                       // Optional void definition

  implicit inline def implicitFrom(v:VOID)       : SequentialIntData = apply(0.toInt)                    // Optional void request

  extension (inline x: SequentialIntData)                                                               // Custom methods
    inline def multiplyBy10 : SequentialIntData = (x.real * 10).toOpaque

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

