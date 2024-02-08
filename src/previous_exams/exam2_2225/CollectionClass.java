package exam2;
import java.util.*;

public class CollectionClass<T> {

    static String countWithList(List array, Collection<Integer> a, Collection<Integer> b) {
        array.addAll(a);
        array.addAll(b);
        return array.toString();
    }

    static String countWithMap(Map map, Collection<Integer> a, Collection<Integer> b) {
        for (Integer i:a) map.put(i,map.get(i)==null?1:(Integer)map.get(i)+1); //5
        for (Integer i:b) map.put(i,map.get(i)==null?1:(Integer)map.get(i)+1);
        return map.toString();
    }

    public static void main(String[] args)	{
        Collection<Integer> fastLookUp = new ArrayList<>();
        Collection<Integer> slowLookUp = new HashSet<>();
        for (int i=0; i<1000; i++) fastLookUp.add(i);
        for (int i=0; i<1000; i++) slowLookUp.add(i);

        System.out.println(slowLookUp.contains(999)); //1
        System.out.println(fastLookUp.contains(999)); //2

        HashMap<Integer,Integer> slowCounter = new HashMap<>();
        ArrayList<Integer> fastCounter = new ArrayList<>(1000);
        System.out.println(countWithList(fastCounter, slowLookUp, fastLookUp)); //3
        System.out.println(countWithMap(slowCounter, slowLookUp, fastLookUp)); //4
    }
}

// 1. Between the two lines of code marked with in-line comments "1" and "2", which one is faster? Why?

// 2. Between the two lines of code marked with in-line comments "3" and "4", which one is faster? Why?

// 3. Explain what the line marked with in-line comment "5" is performing.