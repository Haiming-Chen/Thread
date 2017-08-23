import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String []arg){
        List<FutureTask<String>> futureTasks=new ArrayList<>(5);
        for (int i = 0; i <5 ; i++) {
            DeliverCallable callable=new DeliverCallable();
            FutureTask<String> futureTask=new FutureTask<String>(callable);
            futureTasks.add(futureTask);
            Thread mThread=new Thread(futureTask, "第 " + i);
            mThread.start();
        }

        StringBuilder stringBuilder=new StringBuilder();
       /* futureTasks.forEach(futureTask -> {
            try {
                //获取线程返回结果，没返回就会阻塞
                stringBuilder.append(futureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });*/
        for (FutureTask<String>futureTask:futureTasks){
            try {
                stringBuilder.append(futureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() + " 得到结果：\n" + stringBuilder);
    }

    static class DeliverCallable  implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(new Random().nextInt(10000));
            System.out.println(Thread.currentThread().getName()+" 个线程");
            return Thread.currentThread().getName()+"时间为:"+System.currentTimeMillis()+"\n";
        }
    }


}
