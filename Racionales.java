//Actividad 3

public class Racionales {
	private long a;
	private long b; //suponemos que el denominador es siempre positivo

	public Racionales() {
		a = 1;
		b = 1;
	}

	public Racionales(long a, long b) {
		this.a = a;
		this.b = b;
	}
    
    //Devuelve el numerador de un racional
	public long numerador() {
		return this.a;
	}
    
    //Devuelve el denominador de un racional
	public long denominador() {
		return this.b;
	}

    //Modifica el valor del numerador
	public void modNumerador(long a) {
		this.a = a;
	}

	//Modifica el denominador
	public void modDenominador(long b) {
		this.b = b;
	}

	/**public Racionales sumarRacionales(Racionales x, Racionales y) {
		Racionales resultado = new Racionales();
		if(x.denominador() == y.denominador()){
			resultado.modDenominador(x.denominador());
			resultado.modNumerador(x.numerador() + y.numerador());
		}else{
			if(x.denominador() % y.denominador() == 0){}else{      //intento ver si alguno es multiplo del otro
			  if(y.denominador() % x.denominador( == 0)){}else{}
			}
		}
	}**/


	//public Racionales restarRacionales(Racionales x, Racionales y) {}
    
    //@Override
	//public boolean equals(Object otro) {}
    
    //@Override
	//public String toString() {}


	public static void main(String[] args){
		Racionales x = new Racionales();

		System.out.println(x.numerador());
		System.out.println(x.denominador());
	}
}