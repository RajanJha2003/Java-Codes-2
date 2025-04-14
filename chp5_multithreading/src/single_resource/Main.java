package single_resource;

class Bl {
	 void logic(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		
	}
}

class MyThread4 extends Thread {

	Bl bl;

	public MyThread4(Bl bl) {
		super();
		this.bl = bl;
	}

	@Override
	public void run() {

		bl.logic(5);
	}
}

class MyThread5 extends Thread {
	Bl bl;

	public MyThread5(Bl bl) {
		super();
		this.bl = bl;
	}

	@Override
	public void run() {

		bl.logic(5);
	}
}

class MyThread6 extends Thread {

	Bl bl;

	public MyThread6(Bl bl) {
		super();
		this.bl = bl;
	}
	@Override
	public void run() {

		bl.logic(5);
	}
}

public class Main {
	public static void main(String[] args) {
		Bl bl=new Bl();
		
		MyThread4 myThread4=new MyThread4(bl);
		myThread4.start();
		MyThread5 myThread5=new MyThread5(bl);
		myThread5.start();
		MyThread6 myThread6=new MyThread6(bl);
		
	
		
		myThread6.start();
	}

}
