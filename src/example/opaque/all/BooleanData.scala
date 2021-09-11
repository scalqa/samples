package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   BooleanData = BooleanData.TYPE.DEF

object BooleanData extends Boolean.Opaque.Data[BooleanData]("BooleanData"):
  inline   def apply(inline v: Boolean): BooleanData = v.toOpaque                    // Base type constructor
  override def value_tag(v:BooleanData): String      = v.toString + ".BooleanData"   // Custom tag

  extension (inline x: BooleanData)                                                  // Custom methods
    inline def reverse: BooleanData = (!x.real).toOpaque

  object TYPE:
    opaque type DEF <: Boolean.Opaque = Boolean.Opaque

