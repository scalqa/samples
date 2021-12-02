package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueInt = OpaqueInt.TYPE.DEF

object OpaqueInt extends Int.Opaque.Base[OpaqueInt]("OpaqueInt"):
  inline   def apply(inline v: Int)      : OpaqueInt = v.toOpaque                  // Base type constructor
  override def value_tag   (v:OpaqueInt) : String    = v.toString + ".OpaqueInt"   // Custom tag
  override def value_isVoid(v:OpaqueInt) : Boolean   = v.real == 0                 // Optional void definition

  implicit inline def implicitFrom(v:VOID): OpaqueInt = apply(0.toInt)              // Optional void request

  extension (inline x: OpaqueInt)                                                  // Custom methods
    inline def next : OpaqueInt = (x.real + 1).toOpaque
    inline def prior: OpaqueInt = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

