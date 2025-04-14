package single_resource;



class MyThread1 extends Thread{
	
	Thread thread;
	
	
	
	
	public MyThread1(Thread thread) {
		super();
		this.thread = thread;
	}




	@Override
	public void run() {
		
		
	
		
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(i);
		}
	}
}

class MyThread2 extends Thread{
Thread thread;
	
	
	
	
	public MyThread2(Thread thread) {
		super();
		this.thread = thread;
	}

	
	
	@Override
	public void run() {
	
		
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(i);
		}
	}
}
class MyThread3 extends Thread{
	
Thread thread;
	
	
	
	
	public MyThread3(Thread thread) {
		super();
		this.thread = thread;
	}

	
	
	@Override
	public void run() {
		
		
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(i);
		}
	}
}


public class Threads {
	
	public static void main(String[] args) {
		
		Thread thread=new Thread();
		
		MyThread1 myThread1=new MyThread1(thread);
		MyThread2 myThread2=new MyThread2(thread);
		MyThread3 myThread3=new MyThread3(thread);
		
		myThread1.start();
		myThread2.start();
		myThread3.start();
		
	}

}
