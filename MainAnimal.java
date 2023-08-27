class Animal{
	public void animalSound(){
		System.out.println("The animal makes a sound");
	}
}

class Cat extends Animal{
	public void animalSound(){
		System.out.println("The cat says: meow meow");
	}
}

class Dog extends Animal{
	public void animalSound(){
		System.out.println("The dog says: woof woof");
	}
}

class MainAnimal{
	public static void main(String[] args){
		Animal myAnimal = new Animal();
		Animal myCat = new Cat();
		Animal myDog = new Dog();

		myAnimal.animalSound();
		myCat.animalSound();
		myDog.animalSound();
	}	
}