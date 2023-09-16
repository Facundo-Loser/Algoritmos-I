package Boolean;

/*Implementación:
  -True: naturales pares.
  -False: naturales impares.
  -Función de abstracción: [*] = (n mod 2) = 0.
*/

public class NatBool implements Bool {
	private int p;

	//Constructor:
	public NatBool(int n) throws IllegalArgumentException {
		if(n < 0){
			throw new IllegalArgumentException("n debe ser un natural!");
		}
		p = n;
	}

	public int getNatBool(){
		return p;
	}

	public Bool true0() {
		return new NatBool(2);
	}

	public Bool false0() {
		return new NatBool(1);
	}

	public Bool not() {
		return new NatBool(p+1);
	}

	public Bool or(Bool q) {
		if(q instanceof NatBool){
			return new NatBool(p * (q.getNatBool()));
		}else{
			throw new UnsupportedOperationException("Implementar");
		}
	}

	public Bool imp(Bool q) {
		Bool r = new NatBool(p+1);
		return new NatBool(r.or(q).getNatBool());
	}

    //Función de abstracción: 
	@Override
	public String toString() {
		String res = "" + ((p % 2) == 0);
		return res;
	}

	public static void main(String[] args){
		Bool p = new NatBool(2); //par
		Bool q = new NatBool(1); //impar
        
        System.out.println("p = " + p.toString());
        System.out.println("q = " + q.toString());
		System.out.println("p ^ q = " + p.not().or(q).toString());
		System.out.println("~p = " + p.not().toString());
		System.out.println("~q = " + q.not().toString());
		System.out.println("p v q = " + p.or(q).toString());
		System.out.println("p --> q = " + p.imp(q).toString());
		System.out.println("q --> p = " + q.imp(p).toString());
	}
}