import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list;
        T min = null;
        T max = null;
        list = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (list.size() != 0) {
            min = list.get(0);
            max = list.get(list.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }


    public static void main(String[] args) {

        System.out.println("//Task1");
        Stream<Integer> stream = Arrays.asList(10, 20, 31, 45).stream();
        findMinMax(stream, Integer::compareTo, (x, y) -> System.out.println("min: " + x + ", max: " + y));


        System.out.println("//task2");
        List<Integer> someList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list = someList.stream()
                .filter(Objects::nonNull)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(list);


    }
}
