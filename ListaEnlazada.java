package lista;

public class ListaEnlazada<T> implements Lista<T>{
    private Nodo<T> cabeza;
    private int cantElems;

    //Constructor de la clase
    public ListaEnlazada(){
    	cabeza = null;
    	cantElems = 0;
    }

    public Nodo<T> cabeza(){
    	return cabeza;
    }

	public boolean agregar(T elem){
		if(cabeza == null){            //si la lista está vacía
			Nodo<T> aux = new Nodo<>();
			aux.setElem(elem);
			aux.setSig(null);
			cabeza = aux;
			cantElems++;
			return true;
		}

		Nodo<T> aux = new Nodo<>(); //nodo auxiliar para recorrer
		aux = cabeza;

		for(int i = 1; i < cantElems; i++){
			aux = aux.siguiente();
		} 

		Nodo<T> aux2 = new Nodo<>();
		aux2.setElem(elem);
		aux2.setSig(null);

		aux.setSig(aux2);
		cantElems++;
		return true;
	}

	public boolean agregarTodos(Lista<T> otraLista){
		/*Listas<T> auxList = new ListaEnlazada<>();
		if(!(otraLista instanceof ListaEnlazada)){  //Copio la otra lista en una lista enlazada
		  
		  for(int i = 0; i < otraLista.elementos(); i++){
		  	auxList.insertar(otraLista.obtener(i), i);
		  }

		}

		  Nodo<T> aux = new Nodo<>(); //Nodo auxiliar para recorrer
		  aux = cabeza;

		  for(int i = 1; i < cantElems; i++){
		  	aux = aux.siguiente();
		  }

		  aux.setSig(auxList.cabeza());
		  cantElems = cantElems + otraLista.elementos();
		  return true;*/
		  throw new UnsupportedOperationException("Debe implementar este método");
	}

	public boolean insertar(T elem, int indice) throws IndexOutOfBoundsException {
		if(indice < 0 || indice > cantElems){
			throw new IndexOutOfBoundsException("Indice no válido");
		}

		if(indice == 0){//Inserción a la cabeza
			Nodo<T> aux2 = new Nodo<>();
			aux2.setElem(elem);
			aux2.setSig(cabeza);
			cabeza = aux2;
			cantElems++;
			return true;
		}
        
        //Inserción normal:
		Nodo<T> aux = new Nodo<>(); //Nodo auxiliar para recorrer

		aux = cabeza;
		for(int i = 0; i < (indice-1); i++){
			aux = aux.siguiente();
		}

		Nodo<T> aux2 = new Nodo<>();
		aux2.setElem(elem);
		aux2.setSig(aux.siguiente());
		aux.setSig(aux2);
		cantElems++;
		return true;
	}

	public T eliminar(int indice) throws IndexOutOfBoundsException {
		if(indice < 0 || indice > cantElems){
			throw new IndexOutOfBoundsException("Indice no válido");
		}
        
        T elemElim;
		Nodo<T> aux = new Nodo<>(); //Nodo auxiliar para recorrer
		aux = cabeza;

		for(int i = 1; i < indice; i++){
			aux = aux.siguiente();
		}
        
        elemElim = aux.elemento();
		aux.setSig(aux.siguiente().siguiente());
		cantElems--;
		return elemElim;
	}

	public T obtener(int indice) throws IndexOutOfBoundsException {
		if(indice < 0 || indice > cantElems){
			throw new IndexOutOfBoundsException("Indice no válido");
		}

		Nodo<T> aux = new Nodo<>(); //Nodo auxiliar para recorrer
		aux = cabeza;

		for(int i = 0; i < indice; i++){
			aux = aux.siguiente();
		}
		return aux.elemento();
	}

	public Lista<T> subLista(int desdeInd, int hastaInd) throws IndexOutOfBoundsException {
		if((desdeInd > hastaInd) || (desdeInd < 0) || (hastaInd > cantElems)){
			throw new IndexOutOfBoundsException("Indices no válidos");
		}

		Lista<T> auxList = new ListaEnlazada<>();
		Nodo<T> aux = new Nodo<>(); //Nodo auxiliar para recorrer
		aux = cabeza;

		for(int i = 0; i < desdeInd; i++){
			aux = aux.siguiente();
		}
        
        int k = 0;
		for(int j = desdeInd; j <= hastaInd; j++){
			auxList.insertar(aux.elemento(), k);
			aux = aux.siguiente();
			k++;
		}

		return auxList;
	}

	public boolean contiene(T elem){
		throw new UnsupportedOperationException("Debe implementar este método");
	}

	public void vaciar(){
		cabeza = null; //El garbage collector se encarga de borrar todos los nodos
		cantElems = 0;
	}

	public int elementos(){
		return cantElems;
	}

	public boolean esVacia(){
		return (cantElems == 0);
	}

	public boolean repOK(){
		return true;
	}

	@Override
	public String toString(){
		String mensaje = "Lista: [";
		Nodo<T> aux = new Nodo<>(); //Nodo auxiliar para recorrer
		aux = cabeza;

		for(int i = 0; i < cantElems; i++){
			mensaje = mensaje + aux.elemento() + ", ";
			aux = aux.siguiente();
		}

		mensaje = mensaje + "]";

		return mensaje;
	}

	@Override
	public boolean equals(Object otro){
		if(otro == null){
		    return false;
		}
		if(otro == this){
		    return true;
		}
		if(!(otro instanceof Lista)){
		    return false;
		}
		
		Lista<T> otraLista = (Lista<T>) otro;
		
		if(cantElems != otraLista.elementos()){
		  return false;
		}
		
        Nodo<T> aux = new Nodo<>(); //Nodo auxiliar para recorrer
        aux = cabeza;

		for(int i = 0; i < cantElems; i++){
		  if(!(aux.elemento().equals(otraLista.obtener(i)))){
		    return false;
		  }
		  aux = aux.siguiente();
		}
		return true;
	}

	public static void main(String[] args){
		Lista<String> lista = new ListaEnlazada<>();

		lista.agregar("Hello");
		lista.agregar("World");
		lista.agregar("bye");
		lista.agregar("World");

		String mensaje = lista.toString();
		System.out.println(mensaje);

		System.out.println(lista.obtener(1));
		System.out.println(lista.obtener(2));

		lista.insertar("Chicken", 4);
		mensaje = lista.toString();
		System.out.println(mensaje);

		lista.insertar("Chicken", 2);
		mensaje = lista.toString();
		System.out.println(mensaje);

		lista.eliminar(3);
		mensaje = lista.toString();
		System.out.println(mensaje);

		System.out.println(lista.subLista(1, 2).toString());

		System.out.println(lista.equals(lista.subLista(1, 2)));

		Lista<String> lista2 = new ListaEnlazada<>();

		lista2.insertar("Hello", 0);
		lista2.insertar("World", 1);
		lista2.insertar("Chicken", 2);
		lista2.insertar("World", 3);
		lista2.insertar("Chicken", 4);

		mensaje = lista2.toString();
		System.out.println(mensaje);

		System.out.println(lista.equals(lista2));

	}
}