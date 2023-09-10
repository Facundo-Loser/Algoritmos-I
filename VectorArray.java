package Vectores;

import java.util.Scanner;

public class VectorArray implements Vector{
	private static final Integer MAX_NUM = 10;

	private Integer[] vector;


	public VectorArray(Integer dimension){
		vector = new Integer[dimension];
		Scanner entrada = new Scanner(System.in);
		Integer componente;

		for(int i = 0; i < dimension; i++){
			System.out.println("Ingrese el componente " + (i+1) + " del vector:");
			componente = entrada.nextInt();
			vector[i] = componente;
		}
	}

	public VectorArray(Integer[] numeros) {
		vector = new Integer[numeros.length];
		vector = numeros;
	}

	public int dimension(){
		return vector.length;
	}

	public Integer getComponente(int k) throws IndexOutOfBoundsException {
		if(k < 0 || k > vector.length){
			throw new IndexOutOfBoundsException("No existe el componente " + k);
		}
		return vector[k];
	}


	public void multEscalar(int k){
		for(int i = 0; i < vector.length; i++){
			vector[i] = vector[i] * k;
		}
	}

	public void suma(Vector u) throws IllegalArgumentException {
		if(u.dimension() != vector.length){
			throw new IllegalArgumentException("Vectores de distinta dimensión");
		}

		for(int i = 0; i < vector.length; i++){
			vector[i] = vector[i] + u.getComponente(i);
		}
	}

	public Integer prodEscalar(Vector u) throws IllegalArgumentException {
		if(u.dimension() != vector.length){
			throw new IllegalArgumentException("Vectores de distinta dimensión");
		}

		Integer resultado = 0;

		for(int i = 0; i < vector.length; i++){
			resultado += vector[i] * u.getComponente(i);
		}

		return resultado;
	}

	@Override
	public String toString(){
		String resultado = "(";

		for(int i = 0; i < vector.length; i++){
			resultado += vector[i] + ",";
		}
		resultado = resultado.substring(0, resultado.length() - 1) + ")";

		return resultado;
	}

	@Override
	public boolean equals(Object otroVector){
		if(otroVector == null){
		    return false;
		}
		if(otroVector == this){
		    return true;
		}
		if(!(otroVector instanceof Vector)){
		    return false;
		}

		Vector vectorAux = (VectorArray) otroVector;

		if(vector.length != vectorAux.dimension()){
			return false;
		}

        int i = 0;
        while((i < vector.length) && (vector[i] == vectorAux.getComponente(i))){
        	i++;
        }

        if(i != vector.length){
        	return false;
        }else{
        	return true;
        }
	}

	public static void main(String[] args){
		Integer[] nums = {2, 4};
		Integer[] nums2 = {2, 4};

		Vector u = new VectorArray(nums);
		Vector v = new VectorArray(nums2);

		System.out.println(u.prodEscalar(v));

		System.out.println(u.equals(v));
	}
}