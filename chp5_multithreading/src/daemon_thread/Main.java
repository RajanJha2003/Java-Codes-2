package daemon_thread;

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		System.out.println("Thread name:"+Thread.currentThread().getName());
		System.out.println("is daemon:"+Thread.currentThread().isDaemon());
		
	}
	
}


class MyThread2 extends Thread{
	@Override
	public void run() {
		
		System.out.println("Thread name:"+Thread.currentThread().getName());
		System.out.println("is daemon:"+Thread.currentThread().isDaemon());
			
	}
	
}

public class Main {
  public static void main(String[] args) {
	  
	  MyThread1 myThread1=new MyThread1();
	  
	  MyThread2 myThread2=new MyThread2();
	  myThread2.setDaemon(true);
	  
	  myThread1.start();
	  myThread2.start();
	
}
}
