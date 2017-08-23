import java.util.Random;

public class RunnableTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread mThread=new Thread(new Task(),"第"+i);
            mThread.start();
        }
    }

    static class  Task implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 个任务已完成");
        }
    }

}
