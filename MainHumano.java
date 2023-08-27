abstract class Humano{
    public abstract void categoriaHumano();
}

class Estudiante extends Humano{
	public void categoriaHumano(){
		System.out.println("Soy un estudiante");
	}
}

class Docente extends Humano{
	public void categoriaHumano(){
		System.out.println("Soy un docente");
	}
}

class MainHumano{
	public static void main(String[] args){
		Humano estudiante = new Estudiante();
		Humano docente = new Docente();

		estudiante.categoriaHumano();
		docente.categoriaHumano();
	}
}