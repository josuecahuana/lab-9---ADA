package ArbolBinario;

public class Nodo<V> {
	 
    private V dato;
    private Nodo<V> izq;
    private Nodo<V> der;
     
    public Nodo(V dato, Nodo<V> izq, Nodo<V> der) {
        super();
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
 
    public V getDato() {
        return dato;
    }
 
    public void setDato(V dato) {
        this.dato = dato;
    }
 
    public Nodo<V> getIzq() {
        return izq;
    }
 
    public void setIzq(Nodo<V> izq) {
        this.izq = izq;
    }
 
    public Nodo<V> getDer() {
        return der;
    }
 
    public void setDer(Nodo<V> der) {
        this.der = der;
    }
}