
public class Test {

	public static void main(String[] args) {
		Animal d = new Dog();
		f(d);
	/*	d.eat();
		d.walk();
		//d.print("Tom");
		d.Test();*/
	}
	
	static void f(Animal a) {
		a.eat();
		a.walk();
		a.print("Tom");
	}

}
