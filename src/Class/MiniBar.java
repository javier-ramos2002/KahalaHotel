package Class;

public class MiniBar {
    public enum TiposProductos {
        AGUA, CERVEZA, GOMINOLAS, PATATAS_FRITAS, RON, CHOCOLATE
    }

    private float precio;
    private TiposProductos tiposProductos;
/**
 * Constructor del objeto minibar
 * @param precio
 * @param tiposProductos
 */
    public MiniBar(float precio, TiposProductos tiposProductos) {
        super();
        this.precio = precio;
        this.tiposProductos = tiposProductos;
    }
/**
 * Metodo que obtione el Precio del objeto minibar
 * @return precio (float)
 */
    public float getPrecio() {
        return precio;
    }
/**
 * Metodo que establece el precio del objeto minibar
 * @param precio (float)
 */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
/**
 * Metodo que obtione el tipo de productos del objeto minibar
 * @return  tipo de producto (TiposProductos enumeracion)
 */
    public TiposProductos getTiposProductos() {
        return tiposProductos;
    }
/**
 * Metodo que establece el tipo de producto del objeto minibar
 * @param tiposProductos (TiposProductos enumeracion)
 */
    public void setTiposProductos(TiposProductos tiposProductos) {
        this.tiposProductos = tiposProductos;
    }
/**
 * Metodo to String que devuelve los datos del obejeto Minib
 * @return string del precio y el tipo de producto de objeto Minibar
 */
    @Override
    public String toString() {
        String toString = String.format("%2f, %s",precio, tiposProductos);
        return toString;
    }

}
