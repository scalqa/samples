package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   CalculableIntData = CalculableIntData.TYPE.DEF

object CalculableIntData extends Int.Opaque.Data.Calculable[CalculableIntData]("CalculableIntData"):
  inline   def apply(inline v: Int)             : CalculableIntData = v.toOpaque                        // Base type constructor
  override def value_tag   (v:CalculableIntData): String            = v.toString + ".CalculableIntData" // Custom tag
  override def value_isVoid(v:CalculableIntData): Boolean           = v.real == 0                       // Optional void definition

  implicit inline def implicitFrom(v: \/)       : CalculableIntData = apply(0.toInt)                    // Optional void request

  extension (inline x: CalculableIntData)                                                               // Custom methods
    inline def next : CalculableIntData = (x.real + 1).toOpaque
    inline def prior: CalculableIntData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

