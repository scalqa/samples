package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   LongData = LongData.TYPE.DEF

object LongData extends Long.Opaque.Data[LongData]("LongData"):
  inline   def apply(inline v: Long)     : LongData = v.toOpaque                  // Base type constructor
  override def value_tag   (v:LongData)  : String   = v.toString + ".LongData"    // Custom tag
  override def value_isVoid(v:LongData)  : Boolean  = v.real == 0                 // Optional void definition

  implicit inline def implicitFrom(v: \/): LongData = apply(0.toLong)             // Optional void request

  extension (inline x: LongData)                                                  // Custom methods
    inline def next : LongData = (x.real + 1).toOpaque
    inline def prior: LongData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque

