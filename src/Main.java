import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Integer[] nList = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        final int JOB = 1;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future> operationInPool = new ArrayList<>();

        for (int i = 0; i < nList.length; i++) {
            int number = nList[i];
            Future<Integer> operation = executor.submit(() -> {
                int square = number * number;
                System.out.println("[NUMERO RECIBIDO]: " + number);
                System.out.println("[RESULTADO]: " + square);
                System.out.println("[HILO]: " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                    return square;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return 0;
                }
            });

                operationInPool.add(operation);
        }

        List<Integer> resultList = new ArrayList<>();

        try {
            for (Future<Integer> operation : operationInPool) {
                resultList.add(operation.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("========== RESULTADO FINAL ============");
        System.out.println(resultList);
    }
}