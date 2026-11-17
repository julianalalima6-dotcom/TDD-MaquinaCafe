/**
 * Máquina dispensadora de café.
 * Coordina Vasos, Cafetera y Azucarero siguiendo el diagrama de secuencia:
 * 1) ¿hay vasos?  2) ¿hay café?  3) ¿hay azúcar?  4) entregar.
 */
public class MaquinaDeCafe {

    public static final String NO_HAY_VASOS = "No hay Vasos";
    public static final String NO_HAY_CAFE = "No hay Cafe";
    public static final String NO_HAY_AZUCAR = "No hay Azucar";
    public static final String EXITO = "Felicitaciones";

    // Visibilidad de paquete: los tests acceden directamente a estos campos.
    Cafetera cafetera;
    Vaso vasosPequeno;   // 3 oz
    Vaso vasosMediano;   // 5 oz
    Vaso vasosGrande;    // 7 oz
    Azucarero azucarero;

    public Vaso getTipoDeVaso(String tipoDeVaso) {
        if (tipoDeVaso == null) {
            return null;
        }
        switch (tipoDeVaso.trim().toLowerCase()) {
            case "pequeno":
            case "pequeño":
                return vasosPequeno;
            case "mediano":
                return vasosMediano;
            case "grande":
                return vasosGrande;
            default:
                return null;
        }
    }

    public String getVasoDeCafe(Vaso vaso, int cantidadDeVasos, int cantidadDeAzucar) {
        if (vaso == null || !vaso.hasVasos(cantidadDeVasos)) {
            return NO_HAY_VASOS;
        }

        int cafeNecesario = vaso.getContenido() * cantidadDeVasos;
        if (cafetera == null || !cafetera.hasCafe(cafeNecesario)) {
            return NO_HAY_CAFE;
        }

        int azucarNecesaria = cantidadDeAzucar * cantidadDeVasos;
        if (azucarero == null || !azucarero.hasAzucar(azucarNecesaria)) {
            return NO_HAY_AZUCAR;
        }

        // Solo se descuenta cuando las tres validaciones pasaron.
        vaso.giveVasos(cantidadDeVasos);
        cafetera.giveCafe(cafeNecesario);
        azucarero.giveAzucar(azucarNecesaria);
        return EXITO;
    }

    public Cafetera getCafetera() { return cafetera; }
    public void setCafetera(Cafetera cafetera) { this.cafetera = cafetera; }

    public Vaso getVasosPequeno() { return vasosPequeno; }
    public void setVasosPequeno(Vaso vasosPequeno) { this.vasosPequeno = vasosPequeno; }

    public Vaso getVasosMediano() { return vasosMediano; }
    public void setVasosMediano(Vaso vasosMediano) { this.vasosMediano = vasosMediano; }

    public Vaso getVasosGrande() { return vasosGrande; }
    public void setVasosGrande(Vaso vasosGrande) { this.vasosGrande = vasosGrande; }

    public Azucarero getAzucarero() { return azucarero; }
    public void setAzucarero(Azucarero azucarero) { this.azucarero = azucarero; }
}
