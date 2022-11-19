package ArbolBinario;


public class ArbolBinario {
 
    Nodo<Integer> raiz = null;
    private int numElementos = 0;
    
    public ArbolBinario() {
    	
    }
 
    public void insertarElemento(Integer value) {
        Nodo<Integer> nuevoNodo = new Nodo<Integer>(value, null, null);
 
        if (raiz == null) {
            raiz = nuevoNodo;
            System.out.println("Inserto la raiz");
        } 
        else {
            Nodo<Integer> aux = raiz;
 
            while (aux != null) {
                if (aux.getDer()==null && aux.getIzq()==null) {
                    if (value > aux.getDato()) {
                        System.out.println(value + " se agrega a la derecha de: " + aux.getDato());
                        aux.setDer(nuevoNodo);
                        aux = null;
                    } 
                    else {
                        System.out.println(value + " se agrega a la izquierda de: " + aux.getDato());
                        aux.setIzq(nuevoNodo);
                        aux = null;
                    }
                } 
                else if (value > aux.getDato() && aux.getDer() == null) {
                    System.out.println(value + " se agrega a la derecha de: " + aux.getDato());
                    aux.setDer(nuevoNodo);
                    aux = null;
                }
                else if (value < aux.getDato() && aux.getIzq() == null) {
                    System.out.println(value + " se agrega a la izquierda de: " + aux.getDato());
                    aux.setIzq(nuevoNodo);
                    aux = null;
                } 
                else {
                    if (value > aux.getDato()) {
                        aux = aux.getDer();
                    } 
                    else {
                        aux = aux.getIzq();
                    }
                }
            }
        }
        numElementos++;
    }
 
    private void insertarNodo(Nodo<Integer> nodo) {
        if (raiz == null) {
            raiz = nodo;
            System.out.println("Inserto la raiz");
        } 
        else {
            Nodo<Integer> aux = raiz;
 
            while (aux != null) {
                if (aux.getDer() == null && aux.getIzq() == null) {
                    if (nodo.getDato() > aux.getDato()) {
                        System.out.println(nodo.getDato() + " se agrega a la derecha de: " + aux.getDato());
                        aux.setDer(nodo);
                        aux = null;
                    } 
                    else {
                        System.out.println(nodo.getDato() + " se agrega a la izquierda de: " + aux.getDato());
                        aux.setIzq(nodo);
                        aux = null;
                    }
                } 
                else if (nodo.getDato() > aux.getDato() && aux.getDer() == null) {
                    System.out.println(nodo.getDato() + " se agrega a la derecha de: " + aux.getDato());
                    aux.setDer(nodo);
                    aux = null;
                } 
                else if (nodo.getDato() < aux.getDato() && aux.getIzq() == null) {
                    System.out.println(nodo.getDato() + " se agrega a la izquierda de: " + aux.getDato());
                    aux.setIzq(nodo);
                    aux = null;
                } 
                else {
                    if (nodo.getDato() > aux.getDato()) {
                        aux = aux.getDer();
                    } 
                    else {
                        aux = aux.getIzq();
                    }
                }
 
            }
        }
    }
 
    public Nodo<Integer> buscarNodo(Integer value) {
        Nodo<Integer> aux = raiz;
        Nodo<Integer> resultado = null;
 
        while (aux != null) {
            if (aux.getDato() == value) {
                resultado = aux;
                aux = null;
            } 
            else if (aux.getDer() == null && aux.getIzq() == null) {
                aux = null;
            } 
            else if (value > aux.getDato() && aux.getDer() != null) {
                aux = aux.getDer();
            } 
            else if (value < aux.getDato() && aux.getIzq() != null) {
                aux = aux.getIzq();
            } 
            else {
                aux = null;
            }
        }
  
        if (resultado != null) {
            return resultado;
        }else {
            return null;
        }
    }
 
    public boolean eliminarElemento(Integer value) {
        boolean resultado = false;
        Nodo<Integer> aux = raiz;
 
        while (aux != null) {
            if (aux.getDato() == value) {
                Nodo<Integer> nodoAEliminar = aux;
 
                if (aux.getDer() != null) {
                    raiz = aux.getDer();
                    if (nodoAEliminar.getIzq() != null) {
                        insertarNodo(nodoAEliminar.getIzq());
                    }
                }else if (aux.getIzq() != null) {
                    raiz = aux.getIzq();
                }else {
                    raiz = null;
                }
                 
                resultado = true;
                aux = null;
            } 
            else if (aux.getIzq() != null && aux.getIzq().getDato() == value) {
                Nodo<Integer> nodoAEliminar = aux.getIzq();
 
                if (aux.getIzq().getIzq() != null) {
                    aux.setIzq(aux.getIzq().getIzq());
                    if (nodoAEliminar.getDer() != null) {
                        insertarNodo(nodoAEliminar.getDer());
                    }
                    resultado = true;
                    aux = null;
                } 
                else{
                    aux.setIzq(null);
                    if (nodoAEliminar.getDer() != null) {
                    	insertarNodo(nodoAEliminar.getDer());
                    }
                     
                    resultado = true;
                    aux = null;
                
                }
            } 
            else if (aux.getDer() != null && aux.getDer().getDato() == value) {
                Nodo<Integer> nodoAEliminar = aux.getDer();
 
                if (aux.getDer().getDer() != null) {
                    aux.setDer(aux.getDer().getDer());
                    if (nodoAEliminar.getIzq() != null) {
                        insertarNodo(nodoAEliminar.getIzq());
                    }
                } 
                else if(aux.getDer().getIzq() != null){
                    aux.setDer(null);
                    insertarNodo(nodoAEliminar.getIzq());
                }
                else {
                    aux.setDer(null);
                } 
                resultado = true;
                aux = null;
            } 
            else {
                if (value > aux.getDato()) {
                    aux = aux.getDer();
                } 
                else {
                    aux = aux.getIzq();
                }
            }
        }
         
        if (resultado) {
            numElementos--;
        }
 
        return resultado;
 
    }
    
    public void recorrerInorden() {
    	inorden(raiz);	
    	System.out.println("");
    }
    
    private void inorden(Nodo<Integer> nodo) {
    	if(nodo.getIzq()!=null) {
    		inorden(nodo.getIzq());
    	}
    	System.out.print(nodo.getDato()+", ");
    	if(nodo.getDer()!=null) {
    		inorden(nodo.getDer());
    	}
    }

    public void recorrerPreorden() {
    	preorden(raiz);	
    	System.out.println("");
    }
    
    private void preorden(Nodo<Integer> nodo) {
    	System.out.print(nodo.getDato()+", ");
    	if(nodo.getIzq()!=null) {
    		preorden(nodo.getIzq());
    	}
    	if(nodo.getDer()!=null) {
    		preorden(nodo.getDer());
    	}
    }
    
    public void recorrerPostorden() {
    	postorden(raiz);	
    	System.out.println("");
    }
    
    private void postorden(Nodo<Integer> nodo) {
    	if(nodo.getIzq()!=null) {
    		postorden(nodo.getIzq());
    	}
    	if(nodo.getDer()!=null) {
    		postorden(nodo.getDer());
    	}
    	System.out.print(nodo.getDato()+", ");

    }
    

 
    public int size() {
        return this.numElementos;
    }
 
}