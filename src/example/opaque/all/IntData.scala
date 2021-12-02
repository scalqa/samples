package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   IntData = IntData.TYPE.DEF

object IntData extends Int.Opaque.Data[IntData]("IntData"):
  inline   def apply(inline v: Int)      : IntData  = v.toOpaque                  // Base type constructor
  override def value_tag   (v:IntData)   : String   = v.toString + ".IntData"     // Custom tag
  override def value_isVoid(v:IntData)   : Boolean  = v.real == 0                 // Optional void definition

  implicit inline def implicitFrom(v:VOID): IntData  = apply(0.toInt)              // Optional void request

  extension (inline x: IntData)                                                   // Custom methods
    inline def next : IntData = (x.real + 1).toOpaque
    inline def prior: IntData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

