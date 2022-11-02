package Class;

public class MiniBar {
    public enum TiposProductos {
        AGUA, CERVEZA, GOMINOLAS, PATATAS_FRITAS, RON, CHOCOLATE
    }

    private float precio;
    private TiposProductos tiposProductos;

    public MiniBar(float precio, TiposProductos tiposProductos) {
        super();
        this.precio = precio;
        this.tiposProductos = tiposProductos;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public TiposProductos getTiposProductos() {
        return tiposProductos;
    }

    public void setTiposProductos(TiposProductos tiposProductos) {
        this.tiposProductos = tiposProductos;
    }

    @Override
    public String toString() {
        String toString = String.format("%2f, %s",precio, tiposProductos);
        return toString;
    }

}
