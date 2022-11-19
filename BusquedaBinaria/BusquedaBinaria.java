package BusquedaBinaria;

import java.util.Scanner;

public class BusquedaBinaria {
	
	public static void main(String[] args) {
		int[] arreglo = {2,4,6,8,10,12,14};
		System.out.println("El elemento 2 se encuentra en la posicion: "+busquedaBinaria(arreglo,2,0,arreglo.length-1));
		

	}
	
	public static int busquedaBinaria(int[] arreglo,int dato ,int inferior, int superior) {
		if(inferior>superior) {
			return -1;
		}
		else {
			int mitad = (inferior+superior)/2;
			if(arreglo[mitad]==dato) {
				return mitad;
			}
			else if(dato>arreglo[mitad]) {
				return busquedaBinaria(arreglo, dato, mitad+1, superior);
			}
			else {
				return busquedaBinaria(arreglo,dato,inferior,mitad-1);
			}
		}
	}
	
	public static int[] addElement(int[] arreglo, int dato) {
		int[] nuevoArreglo = new int[arreglo.length+1];
		int c = 0;
		
		for(int i=0;i<arreglo.length;i++) {
			if((arreglo[i]>dato||c!=0)&&c==0) {
				if(c==0) {
					nuevoArreglo[i] = dato;
					c=1;
				}
				nuevoArreglo[c+i]=arreglo[i];
			}else {
				nuevoArreglo[i+c]=arreglo[i];
			}
		}
		
		return nuevoArreglo;
	}
	
	public static int[] createArray() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese la cantidad de elementos:");
		int cantidad = sc.nextInt();
		int[] arreglo = new int[cantidad];
		
		for(int i=0;i<cantidad;i++) {
			System.out.print("Ingrese el elemento "+(i+1)+": ");
			arreglo[i] = sc.nextInt();
		}
		
		arreglo=mergeSort(arreglo);
		
		return arreglo;
	}
	
	public static int[] mergeSort(int[] array){
	    if(array.length==1){
	    	return array;
	    }else{
	    	int medio = array.length/2;
	    	int[] izq = new int[medio];
	    	int[] dere = new int[array.length-medio];
	    	for(int i=0;i<medio;i++){
	    		izq[i] = array[i];
	    	}
	    	for(int i=medio;i<array.length;i++){
	    		dere[i-medio] = array[i];
	    	}

	    	izq = mergeSort(izq);
	    	dere = mergeSort(dere);

	    	int[] res = merge(dere,izq);
	    	return res;
	    }
	}

	public static int[] merge(int[] dere, int[] izq){
	    int[] res = new int[dere.length+izq.length];
	    int i=0,j=0;

	    while(i<dere.length&&j<izq.length){
	        if(dere[i]>izq[j]){
	        	res[i+j] = izq[j];
	        	j++;
	        }else{
	        	res[i+j] = dere[i];
	        	i++;
	        }
	    }
	    
	    if(i!=dere.length) {
	    	while(i<dere.length) {
	    		res[i+j] = dere[i];
	    		i++;
	    	}
	    }else {
	    	while(j<izq.length) {
	    		res[i+j] = izq[j];
	    		j++;
	    	}
	    }
	    return res;
	  }
}
