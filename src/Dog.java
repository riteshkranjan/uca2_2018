
public class Dog extends Animal {

	@Override
	void eat() {
		System.out.println("I am eating");
	}

	@Override
	void walk() {
		System.out.println("I can walk");
	}
	
	public void Test() {
		System.out.println("Testing");
	}
	
	@Override
	public void print(String name) {
		System.out.println("in my child method");
		super.print(name);
	}

}
