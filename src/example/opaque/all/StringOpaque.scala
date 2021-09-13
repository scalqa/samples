package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   StringOpaque = StringOpaque.TYPE.DEF

object StringOpaque extends String.Opaque.Base[StringOpaque]("StringOpaque"):
  inline   def apply(inline v: String)     : StringOpaque = v.toOpaque                     // Base type constructor
  override def value_tag   (v:StringOpaque): String       = v.toString + ".StringOpaque"   // Custom tag

  extension (inline x: StringOpaque)                                                       // Custom methods
    inline def append(v: StringOpaque): StringOpaque = (x.real + v.real).toOpaque

  object TYPE:
    opaque type DEF <: String.Opaque = String.Opaque

