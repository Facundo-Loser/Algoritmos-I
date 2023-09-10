public class ColaCircular{
    public static final int MAX_NUM  = 100;
	int[] array;
	int cantElems;
	int principio;
	int fin;


	public ColaCircular(int capacidad) throws IllegalArgumentException {
		if(capacidad <= 0){
			throw new IllegalArgumentException("La capacidad debe ser mayor a cero"); 
		}
		array = new int[capacidad];
		cantElems = 0;
		principio = 0;
		fin = 0;
	}

	public void agregar(int elem) throws IllegalArgumentException {
		if(cantElems == (array.length-1)){
			throw new IllegalArgumentException("Cola llena");
		}

		array[fin] = elem;
		if(fin == (array.length) - 1){
			fin = 0;
		}
		else{
			fin++;
		}
		cantElems++;
	}

	public void eliminar() throws IllegalArgumentException {
		if(cantElems == 0){
			throw new IllegalArgumentException("Cola vacía");
		}

		if(principio == (array.length) - 1){
			principio = 0;
		}
		else{
			principio++;
		}
		cantElems--;
	}

	@Override
	public String toString(){ //hay que arreglar el método para que muestre el string al revés
        String res = "[";
		int i = principio;

		while(i != fin){
			res += array[i] + ",";

			if(i == (array.length - 1)){
				i = 0;
			}else{
				i++;
			}
		}

		res += "]";
		return res;
	}

    public static void main(String[] args){
    	ColaCircular cola = new ColaCircular(4);

    	System.out.println(cola.toString());

    	cola.agregar(1);
    	cola.agregar(2);
    	cola.agregar(3);

    	System.out.println(cola.toString());

    	cola.eliminar();
    	System.out.println(cola.toString());

    	cola.agregar(4);
    	System.out.println(cola.toString());

    	cola.eliminar();
    	System.out.println(cola.toString());

    	cola.agregar(5);
    	System.out.println(cola.toString());
    	
    	//cola.eliminar();

    	//System.out.println(cola.toString());
    }

}