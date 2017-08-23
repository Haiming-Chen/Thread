import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Random;

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            myThread myThread=new myThread("第"+i);
            myThread.start();
        }
    }
    static class  myThread extends Thread {
        public myThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(new Random().nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 个线程");
        }
    }
}
