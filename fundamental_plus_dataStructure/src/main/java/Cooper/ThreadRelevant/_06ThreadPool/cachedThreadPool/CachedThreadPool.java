package Cooper.ThreadRelevant._06ThreadPool.cachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
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
    //从结果看, 执行几次,创建几个线程
//    pool-1-thread-1正在執行..
//    pool-1-thread-3正在執行..
//    pool-1-thread-2正在執行..
//    pool-1-thread-4正在執行..
//    pool-1-thread-5正在執行..
}
