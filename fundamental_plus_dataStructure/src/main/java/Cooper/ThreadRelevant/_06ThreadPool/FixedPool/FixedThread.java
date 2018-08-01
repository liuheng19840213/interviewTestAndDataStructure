package Cooper.ThreadRelevant._06ThreadPool.FixedPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThread {
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建实现了runnable接口的对象,thread对象当然也实现了runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();

    }
}


class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在執行..");
    }
    //从结果看, 不管执行几次, 都只有线程池中的两个线程执行.上述创建了5个线程但是start的只有:
    //pool-1-thread-2正在執行..
    //pool-1-thread-1正在執行..
    //pool-1-thread-2正在執行..
    //pool-1-thread-1正在執行..
    //pool-1-thread-2正在執行..
}
