import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class NumberOperations {
    public static void main(String[] args) {
        // Create initial list
        List<Number> numbers = new ArrayList<>(Arrays.asList(
            10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9
        ));
        
        // Add different types numbers to list
        numbers.add((byte) 3);
        numbers.add((short)19);
        numbers.add(35L);
        numbers.add(97.7f);
        
        System.out.println("Виводимо числа на екран.");
        for (Number number : numbers) {
            System.out.println(number);
        }
        
        double average = calculateAverage(numbers);
        System.out.println("\nAverage value: " + roundNumber(average));
        
        List intOutput = formatNumbers(numbers, "%d");
        System.out.println("\nЧисла у форматі int: " + intOutput);
        
        List fractOutput = formatNumbers(numbers, "%.2f");
        System.out.println("\nЧисла у форматі fractional (2 decimal places):\n" + fractOutput);
        
        // Create HashMap to store elements by type
        Map<Class<? extends Number>, List<Number>> numberMap = new HashMap<>();
        numberMap.put(Integer.class, new ArrayList<>());
        numberMap.put(Double.class, new ArrayList<>());
        numberMap.put(Byte.class, new ArrayList<>());
        numberMap.put(Short.class, new ArrayList<>());
        numberMap.put(Long.class, new ArrayList<>());
        numberMap.put(Float.class, new ArrayList<>());
        
        // Distribution of list elements by type using loop
        for (Number number : numbers) {
            numberMap.get(number.getClass()).add(number);
        }
        
        System.out.println("\nInt: " + numberMap.get(Integer.class));
        System.out.println("Double: " + numberMap.get(Double.class));
        System.out.println("Byte: " + numberMap.get(Byte.class));
        System.out.println("Short: " + numberMap.get(Short.class));
        System.out.println("Long: " + numberMap.get(Long.class));
        System.out.println("Float: " + numberMap.get(Float.class));
    }
    
    // Create method to calculate average value in list
    private static double calculateAverage(List<Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum / numbers.size();
    }
    
    // Create method to round number
    private static double roundNumber(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    // Create method to format numbers in 2 different types (int or fractional with 2 decimal places)
    private static List formatNumbers(List<Number> numbers, String format) {
        List formattedList = new ArrayList<>();
        for (Number number : numbers) {
            if (format.equals("%d")) {
                formattedList.add(number.intValue());
            } else {
                formattedList.add(String.format(format, number.doubleValue()));
            }
        }
        return formattedList;
    }
}
