package exam3.exam3_2235;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        Function<Integer, String> function = (string) -> Integer.toBinaryString(string); //1
        System.out.printf("Binary representation of %s is %s%n", 7, function.apply(7));

        Supplier<List<Integer>> supplier = LinkedList::new;                              //2
        System.out.println(supplier.get().add(1));

        Predicate<List> predicate = l -> l.isEmpty();                                    //3
        System.out.println(predicate.test(supplier.get()));

    }
}


// 1. Write the equivalent method reference to the statement with in-line comment "1"
//Function<Integer, String> function = Integer::toBinaryString;                    //1

// 2. Write the equivalent lambda expression to the statement with in-line comment "2"
//Supplier<List<Integer>> supplier = () -> new LinkedList<>();                      //2

// 3. Write the equivalent anonymous class expression to the statement with in-line comments "3" and "4"
//Predicate<List> predicate = new Predicate<>() {
//    public boolean test(List list) { return list.isEmpty(); } };
