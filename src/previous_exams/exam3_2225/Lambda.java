package exam3;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        Function<Integer, String> function = Integer::toBinaryString;                    //1
        System.out.printf("Binary representation of %s is %s%n", 7, function.apply(7));


        Supplier<List<Integer>> supplier = () -> new ArrayList<>();                      //2
        List<Integer> list = supplier.get();

        Predicate<List> predicate = new Predicate<>() {                                  //3
            public boolean test(List list) { return list.isEmpty(); } };                 //4
    }
}


// 1. Write the equivalent lambda expression to the statement with in-line comment "1"
//Function<Integer, String> function = (string) -> Integer.toBinaryString(string);

// 2. Write the equivalent method reference to the statement with in-line comment "2"
//Supplier<List<Integer>> supplier = ArrayList::new;

// 3. Write the equivalent lambda expression to the statement with in-line comments "3" and "4"
//Predicate<List> predicate = l -> l.isEmpty();
