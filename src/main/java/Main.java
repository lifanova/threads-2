import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> myCallable1 = new MyCallable("1");
        Callable<Integer> myCallable2 = new MyCallable("2");
        Callable<Integer> myCallable3 = new MyCallable("3");
        Callable<Integer> myCallable4 = new MyCallable("4");

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<Integer>> listTasks = new ArrayList<>();
        listTasks.add(myCallable1);
        listTasks.add(myCallable2);
        listTasks.add(myCallable3);
        listTasks.add(myCallable4);

//        threadPool.invokeAll(listTasks);

        threadPool.invokeAny(listTasks);

        threadPool.shutdown();
    }
}
