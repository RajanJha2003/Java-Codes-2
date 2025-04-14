package renaming_thread;



class MyThread1 extends Thread{
	
	@Override
	public void run() {
		System.out.println("Thread"+Thread.currentThread().getName());		
		
	}
	
}


class MyThread2 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread"+Thread.currentThread().getName());
			
	}
	
}

public class Main {
	public static void main(String[] args) {
		MyThread1 myThread1=new MyThread1();
		myThread1.setName("First Thread");
		
		MyThread2 myThread2=new MyThread2();
		myThread2.setName("Second Thread");
		
		myThread1.start();
		myThread2.start();
	}

}
