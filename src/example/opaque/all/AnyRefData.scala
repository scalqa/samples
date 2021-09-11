package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   AnyRefData = AnyRefData.TYPE.DEF

object AnyRefData extends AnyRef.Opaque.Data[AnyRefData,String]("AnyRefData"):
  inline   def apply(inline v: String)   : AnyRefData = v.toOpaque                     // Base type constructor
  override def value_tag   (v:AnyRefData): String     = v.toString + ".AnyRefData"     // Custom tag
  override def value_isVoid(v:AnyRefData): Boolean    = v.real.length ==  0            // Optional void definition

  implicit inline def implicitFrom(v: \/): AnyRefData = apply("")                      // Optional void request

  extension (inline x: AnyRefData)                                                     // Custom methods
    inline def append(v: AnyRefData): AnyRefData = (x.real + v.real).toOpaque

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = AnyRef.Opaque

