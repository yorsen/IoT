package Threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @author yaosen.pys
 * @date 2021/06/18
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1));
        pool.setRejectedExecutionHandler(new CallerRunsPolicy());

        List<CompletableFuture> futures = new ArrayList<>();
        for(int i=0; i<10; i++) {
            final int index = i;
            CompletableFuture future = CompletableFuture.supplyAsync(()->{
                if(index == 5) {
                    throw new RuntimeException("error!!!");
                }
                try {
                    Thread.sleep(1000, 0);
                    latch.countDown();
                } catch (Exception e) {

                }
                System.out.println("task running" + String.valueOf(index) + Thread.currentThread().getName());
                return true;
            }, pool);

            futures.add(future);
        }

        try {
            CompletableFuture[] array = new CompletableFuture[futures.size()];
            futures.toArray(array);
            CompletableFuture.allOf(array).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.shutdown();
        System.out.println("done!!!");
    }
}
