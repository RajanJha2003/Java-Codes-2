package thread_priority;


class MyThread1 extends Thread{
	
	@Override
	public void run() {
        System.out.println("Running " + Thread.currentThread().getName() 
               );
         try {
        	 Thread.sleep(5000);
        	 
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	
}
}


class MyThread2 extends Thread{
	@Override
	public void run() {
        System.out.println("Running " + Thread.currentThread().getName() 
                );
         try {
        	 Thread.sleep(5000);
        
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	
}
}



class MyThread3 extends Thread{
	@Override
	public void run() {
        System.out.println("Running " + Thread.currentThread().getName() 
                );
         try {
        	 Thread.sleep(5000);
        	
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	
}
}

public class Main {
	public static void main(String[] args) {
		MyThread1 myThread1=new MyThread1();
		myThread1.setPriority(Thread.MIN_PRIORITY);
		myThread1.start();
		
		
		MyThread2 myThread2=new MyThread2();
		myThread2.setPriority(Thread.MAX_PRIORITY);
		myThread2.start();
		
		MyThread3 myThread3=new MyThread3();
		myThread3.setPriority(Thread.NORM_PRIORITY);
		myThread3.start();
	}

}
