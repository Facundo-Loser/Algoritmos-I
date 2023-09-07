package colecciones.cola;

import java.util.Collection;
import java.util.Scanner;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	@Override
	public boolean esVacia() {
		return (elementos == 0);
	}

	@Override
	public int elementos() {
		return elementos;
	}

	@Override
	public boolean encolar(T elem) {           
		if(elementos == CAPACIDAD_POR_DEFECTO){ //El arreglo está lleno
			return false;                      
		}

		for(int i = elementos; i > 0; i--){
			arreglo[i] = arreglo[i-1];
		}

		arreglo[0] = elem;
		elementos++;
		return true;	
	}

	@Override
	public T desencolar() throws IllegalStateException {
		if(elementos == 0){
			throw new IllegalStateException("Cola vacía");
		}

		T primero = (T) arreglo[elementos-1];
		elementos--;
		return primero;
	}

	@Override
	public T primero() throws IllegalStateException {
		if(elementos == 0){
			throw new IllegalStateException("Cola vacía");
		}

		T principio = (T) arreglo[elementos-1];
		return principio;
	}

	@Override
	public void vaciar() {
		elementos = 0;
	}

	@Override
	public boolean repOK() {
		return true;
	}

	@Override
	public String toString() {
		String mensaje = "Cola: [";

		for(int i = 0; i < elementos; i++){
			mensaje += arreglo[i] + ", ";
		}

		mensaje += "]";

		return mensaje;
	}

	@Override
	public boolean equals(Object other) { //Hace lo que dice la especificación pero no esta tan bien
		if(other == null){
		    return false;
		}
		if(other == this){
		    return true;
		}
		if(!(other instanceof Cola)){
		    return false;
		}
		
        Cola<T> colaAux = (Cola<T>) other;

		if(elementos != colaAux.elementos()){
		  return false;
		}

		for(int i = elementos; i > 0; i--){
			if(arreglo[i-1] != colaAux.primero()){
				return false;
			}

			colaAux.desencolar();
		}

		return true;

	}
    
    /*public boolean palindromo(){
        boolean palindromo = true;
        int i = 0;

        while((i < (elementos-i)) & palindromo){
        	if(arreglo[i] != arreglo[elementos-i]){
        		palindromo = false;
        	}
        }

        return palindromo;
    }*/

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	private T elemento(int index) {
        	return (T) arreglo[index];
    	}

    public static void main(String[] args){
    	/*Cola<String> cola = new ColaArregloFijo<>();
    	String mensaje;

    	cola.encolar("Hello");
    	cola.encolar("World");
        
        mensaje = cola.toString();
    	System.out.println(mensaje);

    	cola.desencolar();

    	mensaje = cola.toString();
    	System.out.println(mensaje);

    	Cola<String> cola2 = new ColaArregloFijo<>();

    	//cola2.encolar("Hello");
    	cola2.encolar("World");

    	System.out.println(cola.equals(cola2));*/
        

        //Ejercicio 5-b)
    	Scanner entrada = new Scanner(System.in);
    	String cadena;

    	System.out.println("Ingrese una cadena: ");
    	cadena = entrada.next();

        Cola<Character> cola = new ColaArregloFijo<>(); //Character es el wrapper de char

    	for(int i = 0; i < cadena.length(); i++){
    		cola.encolar(cadena.charAt(i));
    	}

    	System.out.println(cola.toString());
    	




        //String palabra = "Hello";
    	//System.out.println(palabra.length());
    	//System.out.println(palabra.charAt(2));


    }	
}
