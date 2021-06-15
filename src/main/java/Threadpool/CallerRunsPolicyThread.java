package Threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @author yaosen.pys
 * @date 2021/06/10
 */
public class CallerRunsPolicyThread {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(10);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1));
        pool.setRejectedExecutionHandler(new CallerRunsPolicy());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            final String index = String.valueOf(i);
            pool.submit(() -> {
                try {
                    Thread.sleep(1000, 0);
                    latch.countDown();
                } catch (Exception e) {

                }
                System.out.println("task running" + String.valueOf(index));
            });
        }

        latch.await();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("end");

        pool.shutdown();
    }
}
