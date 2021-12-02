package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   CalculableLongData = CalculableLongData.TYPE.DEF

object CalculableLongData extends Long.Opaque.Data.Calculable[CalculableLongData]("CalculableLongData"):
  inline   def apply(inline v: Long)             : CalculableLongData = v.toOpaque                         // Base type constructor
  override def value_tag   (v:CalculableLongData): String             = v.toString + ".CalculableLongData" // Custom tag
  override def value_isVoid(v:CalculableLongData): Boolean            = v.real == 0                        // Optional void definition

  implicit inline def implicitFrom(v:VOID)        : CalculableLongData = apply(0.toLong)                    // Optional void request

  extension (inline x: CalculableLongData)                                                                 // Custom methods
    inline def next : CalculableLongData = (x.real + 1).toOpaque
    inline def prior: CalculableLongData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque

