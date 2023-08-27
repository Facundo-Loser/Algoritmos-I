public class Pair{
	private int x;
	private int y;
    
    /**Constructor de la clase**/
	public Pair(){
		x = 0;
		y = 0;
	}

    /**Devuelve la primer coordenada del par**/
	public int fst(){
		return this.x;
	}

    /**Devuelve la segunda coordenada del par**/
	public int snd(){
		return this.y;
	}

    /**Cambia la primer coordenada**/
	public void changeFst(int x){
		this.x = x;
	}

    /**Cambia la segunda coordenada**/
	public void changeSnd(int y){
		this.y = y;
	}

    /**Devuelve el componente más grade del par**/
	public int maxPair(){
		if(this.x > this.y){
			return this.x;
		}else{
			return this.y;
		}
	}
    
    /**Devuelve el componente más chico del par**/
	public int minPair(){
		if(this.x < this.y){
			return this.x;
		}else{
			return this.y;
		}
	}
    
    /**Devuelve el doble de la coordenada x**/
	public int doubleX(){
		return (this.x) * 2;
	}
    
    /**Devuelve el doble de la coordenada y**/
	public int doubleY(){
		return (this.y) * 2;
	}

	public static void main(String[] args){
        Pair p = new Pair();
        System.out.println("El par es: " + "(" + p.fst() + "," + p.snd() + ")");
        p.changeFst(2);
        p.changeSnd(4);
        System.out.println("El par es: " + "(" + p.fst() + "," + p.snd() + ")");
        System.out.println("El componente del par más grande es: " + p.maxPair());
        System.out.println("El componente del par más chico es: " + p.minPair());
        System.out.println("El doble de cada componente del par es: " + "(" + p.doubleX() + "," + p.doubleY() + ")");
    }	
}
