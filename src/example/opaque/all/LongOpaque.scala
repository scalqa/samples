package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   LongOpaque = LongOpaque.TYPE.DEF

object LongOpaque extends Long.Opaque.Base[LongOpaque]("LongOpaque"):
  inline   def apply(inline v: Long)     : LongOpaque = v.toOpaque                  // Base type constructor
  override def value_tag   (v:LongOpaque): String     = v.toString + ".LongOpaque"  // Custom tag
  override def value_isVoid(v:LongOpaque): Boolean    = v.real == 0                 // Optional void definition

  implicit inline def implicitFrom(v: \/): LongOpaque = apply(0.toLong)             // Optional void request

  extension (inline x: LongOpaque)                                                  // Custom methods
    inline def next : LongOpaque = (x.real + 1).toOpaque
    inline def prior: LongOpaque = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque

