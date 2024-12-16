import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Stream<Integer> originalStream = Stream.of(1, 2, 3, 4, 5);

        ExecutionTimeDecorator<Integer> timeDecorator = new ExecutionTimeDecorator<>(originalStream);
        Stream<Integer> decoratedStream = timeDecorator.streamElTimeMonitoring();

        decoratedStream
                .map(n -> n * 10)
                .forEach(n -> {
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        logger.log(Level.SEVERE, "Потік сну перервано", e);
                    }
                    System.out.println("Processed: " + n);
                });
    }
}