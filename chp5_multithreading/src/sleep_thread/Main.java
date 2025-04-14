package sleep_thread;

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is sleeping");
		
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("Thread woke up");
		
	}
	
}


class MyThread2 extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is sleeping");
		
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Thread woke up");		
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		MyThread1 myThread1=new MyThread1();
		myThread1.start();
		
		MyThread2 myThread2=new MyThread2();
		myThread2.start();


	}

}
