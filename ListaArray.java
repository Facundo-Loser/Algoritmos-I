package lista;

public class ListaArray<T> implements Lista<T> {
	private static final int MAX_NUM = 100;
	private T arreglo[];
	private int cantElems;

    //public Lista(){}

	public boolean agregar(T elem){ 
		if(cantElems != arreglo.length){
			arreglo[cantElems] = elem;
		    cantElems = cantElems + 1;
		    return true;
		}else{
			return false;
		}
	}
    
	public boolean agregarTodos(Lista<T> otraLista){
		/*if((this.cantElems != this.arreglo.length) && (otraLista.cantElems != 0)){ //Si el arreglo no esta lleno y otraLista no esta vacía
			
			int i = 0;
			while((this.cantElems != this.arreglo.length) && (i != otraLista.cantElems)){
				this.arreglo[this.cantElems] = otraLista.arreglo[i];
				this.cantElems = this.cantElems + 1;
				i = i + 1;
			}

			if(i == otraLista.cantElems){ //Si se agregaron todos los elementos a la lista
				return true;
			}else{
				return false;
			}

		}else{
			return false;
		}*/
		throw new UnsupportedOperationException("Debe implementar este método");
	}
    
	public boolean insertar(T elem, int indice) throws IndexOutOfBoundsException {
		if(indice < 0 || indice > (cantElems - 1)){
			throw new IndexOutOfBoundsException("Indice no válido");
		}else{

			if(cantElems == arreglo.length){ //Si el arreglo esta lleno
				return false;

			}else{

				if(indice == (cantElems - 1)){ //Si hay que agregarlo al final
					arreglo[indice] = elem;
				}else{
					for(int i = (cantElems - 1); i >= indice; i--){ //Desplazamiento
						arreglo[i+1] = arreglo[i];
					}
					arreglo[indice] = elem;
				}
                
                return true;     
			}
		}
	}
    
	public T eliminar(int indice) throws IndexOutOfBoundsException {
		if(indice < 0 || indice > (cantElems - 1)){
			throw new IndexOutOfBoundsException("Indice no válido");
		}else{
			T eliminado = arreglo[indice];

			if(indice == (cantElems - 1)){ //Si se elimina el último
				cantElems = cantElems - 1;
				return eliminado;
			}else{
				for(int i = indice; i < (cantElems - 1); i++){
					arreglo[i] = arreglo[i+1];
				}
				cantElems = cantElems - 1;
				return eliminado;
			}
		}
	}
    
	public T obtener(int indice) throws IndexOutOfBoundsException {
		if(indice < 0 || indice > (cantElems - 1)){
			throw new IndexOutOfBoundsException("Indice no válido");
		}else{
			return arreglo[indice];
		}
	}
    
	public Lista<T> subLista(int desdeInd, int hastaInd) throws IndexOutOfBoundsException {
		/*if((desdeInd > hastaInd) || (desdeInd < 0) || (hastaInd > (cantElems - 1))){
			throw new IndexOutOfBoundsException("Indices no válidos");
		}else{}*/
		throw new UnsupportedOperationException("Debe implementar este método");
	}
    
	public boolean contiene(T elem){
		throw new UnsupportedOperationException("Debe implementar este método");
	}
    
	public void vaciar(){
		cantElems = 0;
	} 
    
	public int elementos(){
		return cantElems;
	}
    
	public boolean esVacia(){
		return (cantElems == 0);
	}
    
	public boolean repOK(){
		throw new UnsupportedOperationException("Debe implementar este método");
	}

	@Override
	public String toString(){
		throw new UnsupportedOperationException("Debe implementar este método");
	}

	@Override
	public boolean equals(Object otro){
		throw new UnsupportedOperationException("Debe implementar este método");
	}

	public static void main(String[] args){}
}