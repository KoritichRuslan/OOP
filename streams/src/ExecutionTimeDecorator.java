import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ExecutionTimeDecorator<T> {
    private final Stream<T> stream;

    public ExecutionTimeDecorator(Stream<T> stream) {
        this.stream = stream;
    }

    public Stream<T> streamElTimeMonitoring() {
        Spliterator<T> originalSpliterator = stream.spliterator();

        Spliterator<T> timingSpliterator = new Spliterators.AbstractSpliterator<>(
                originalSpliterator.estimateSize(), originalSpliterator.characteristics()) {

            private void logExecutionTime(Consumer<? super T> action, T item) {
                long startTime = System.nanoTime();
                try {
                    action.accept(item);
                } finally {
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Час виконання обробки: " + duration + " ns");
                }
            }

            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                return originalSpliterator.tryAdvance(item -> logExecutionTime(action, item));
            }
        };

        return StreamSupport.stream(timingSpliterator, false);
    }
}