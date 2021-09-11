package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   BooleanOpaque = BooleanOpaque.TYPE.DEF

object BooleanOpaque extends Boolean.Opaque.Base[BooleanOpaque]("BooleanOpaque"):
  inline   def apply(inline v: Boolean)     : BooleanOpaque = v.toOpaque                   // Base type constructor
  override def value_tag   (v:BooleanOpaque): String     = v.toString + ".BooleanOpaque"   // Custom tag

  extension (inline x: BooleanOpaque)                                                   // Custom methods
    inline def reverse: BooleanOpaque = (!x.real).toOpaque

  object TYPE:
    opaque type DEF <: Boolean.Opaque = Boolean.Opaque

