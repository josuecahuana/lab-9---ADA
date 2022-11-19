package BusquedaSecuencial;

import java.util.Scanner;

public class BusquedaSecuencial {
	
	public static void main(String[] args) {
		
		int[] arreglo = {3,4,5,8,9,10};
		
		System.out.println("El elemento 9 esta en la posicion: "+busquedaSecuencial(arreglo,9));
	}
	
	public static int busquedaSecuencial(int[] arreglo, int dato) {
		for(int i=0;i<arreglo.length;i++) {
			if(arreglo[i]==dato) {
				return i;
			}
		}
		return -1;
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


