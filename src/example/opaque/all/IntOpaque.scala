package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   IntOpaque = IntOpaque.TYPE.DEF

object IntOpaque extends Int.Opaque.Base[IntOpaque]("IntOpaque"):
  inline   def apply(inline v: Int)      : IntOpaque = v.toOpaque                  // Base type constructor
  override def value_tag   (v:IntOpaque) : String    = v.toString + ".IntOpaque"   // Custom tag
  override def value_isVoid(v:IntOpaque) : Boolean   = v.real == 0                 // Optional void definition

  implicit inline def implicitFrom(v: \/): IntOpaque = apply(0.toInt)              // Optional void request

  extension (inline x: IntOpaque)                                                  // Custom methods
    inline def next : IntOpaque = (x.real + 1).toOpaque
    inline def prior: IntOpaque = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

