package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   CalculableShortData = CalculableShortData.TYPE.DEF

object CalculableShortData extends Short.Opaque.Data.Calculable[CalculableShortData]("CalculableShortData"):
  inline   def apply(inline v: Short)             : CalculableShortData = v.toOpaque                          // Base type constructor
  override def value_tag   (v:CalculableShortData): String              = v.toString + ".CalculableShortData" // Custom tag
  override def value_isVoid(v:CalculableShortData): Boolean             = v.real == 0                         // Optional void definition

  implicit inline def implicitFrom(v: \/)         : CalculableShortData = apply(0.toShort)                    // Optional void request

  extension (inline x: CalculableShortData)                                                                   // Custom methods
    inline def next : CalculableShortData = (x.real + 1).toShort.toOpaque
    inline def prior: CalculableShortData = (x.real - 1).toShort.toOpaque

  object TYPE:
    opaque type DEF <: Short.Opaque = Short.Opaque

