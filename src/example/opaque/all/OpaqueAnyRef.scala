package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueAnyRef = OpaqueAnyRef.TYPE.DEF

object OpaqueAnyRef extends AnyRef.Opaque.Base[OpaqueAnyRef,String]("OpaqueAnyRef"):
  inline   def apply(inline v: String)     : OpaqueAnyRef = v.toOpaque                     // Base type constructor
  override def value_tag   (v:OpaqueAnyRef): String       = v.toString + ".OpaqueAnyRef"   // Custom tag
  override def value_isVoid(v:OpaqueAnyRef): Boolean      = v.real.length ==  0            // Optional void definition

  implicit inline def implicitFrom(v:VOID)  : OpaqueAnyRef = apply("")                      // Optional void request

  extension (inline x: OpaqueAnyRef)                                                       // Custom methods
    inline def append(v: OpaqueAnyRef): OpaqueAnyRef = (x.real + v.real).toOpaque

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = AnyRef.Opaque

