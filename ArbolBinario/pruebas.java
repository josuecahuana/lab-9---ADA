package ArbolBinario;

public class pruebas {
	
	public static void main(String[] args) {
		ArbolBinario arbol = new ArbolBinario();
		
		arbol.insertarElemento(10);
		arbol.insertarElemento(5);
		arbol.insertarElemento(8);
		arbol.insertarElemento(15);
		arbol.insertarElemento(13);
		arbol.insertarElemento(18);
		arbol.insertarElemento(3);
		
		System.out.print("\nRecorrido inorden: ");

		arbol.recorrerInorden();
		
		System.out.print("\nRecorrido preorden: ");

		arbol.recorrerPreorden();
	
		System.out.print("\nRecorrido postorden: ");

		arbol.recorrerPostorden();

	}

}
