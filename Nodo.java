package lista;

public class Nodo<T>{
	private T elem;
	private Nodo<T> siguiente;
    
    //Constructor de la clase (Construye un nodo)
	public Nodo(){
		elem = null;
		siguiente = null;
	}

	//Setters:
	public void setElem(T elem){
		this.elem = elem;
	}

	public void setSig(Nodo<T> siguiente){
		this.siguiente = siguiente;
	}

	//Getters:
	public T elemento(){
		return elem;
	}

	public Nodo<T> siguiente(){
		return siguiente;
	}
}