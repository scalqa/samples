package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   AnyRefOpaque = AnyRefOpaque.TYPE.DEF

object AnyRefOpaque extends AnyRef.Opaque.Base[AnyRefOpaque,String]("AnyRefOpaque"):
  inline   def apply(inline v: String)     : AnyRefOpaque = v.toOpaque                     // Base type constructor
  override def value_tag   (v:AnyRefOpaque): String       = v.toString + ".AnyRefOpaque"   // Custom tag
  override def value_isVoid(v:AnyRefOpaque): Boolean      = v.real.length ==  0            // Optional void definition

  implicit inline def implicitFrom(v: \/)  : AnyRefOpaque = apply("")                      // Optional void request

  extension (inline x: AnyRefOpaque)                                                       // Custom methods
    inline def append(v: AnyRefOpaque): AnyRefOpaque = (x.real + v.real).toOpaque

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = AnyRef.Opaque

