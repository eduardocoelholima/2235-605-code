// lower bound for variable type: javac will assume the

package classes.generics;

import java.util.ArrayList;
import java.util.List;

class A2 {}
class B extends A2 {}
class C extends B {}

public class Lower2 {
    static <T extends C> void upperCheck(T something) {}
    static void upperCheck2(List<? extends Number> something) {}
    static void lowerCheck(List<? super Integer> something) {}

    public static void main(String[] args) {

        //lower bounds in variables only check the creation of the instance
        List<? super B> list = new ArrayList<B>();
        list.add( new B() );
        list.add( new C() ); //will implicitly upcast, lower bounds does not apply
//        list.add( new B() ); //can not downcast
        // curiously, if you set the bounds to ?

        //lower bounds in methods
        Lower2.lowerCheck(new ArrayList<Number>()); //ok, number is parent of Integer
//        Lower2.lowerCheck(new ArrayList<String>()); //not ok, string is not parent of Integer

        //upper bounds in methods
        Lower2.upperCheck(new C()); // upper bounded method
//        Lower2.upperCheck(new A2()); // can not do

        // upper bounds with wildcards
        Lower2.upperCheck2(new ArrayList<Integer>());
        Lower2.upperCheck2(new ArrayList<>()); // inferred by javac to be <Number>
//        Lower2.upperCheck2(new ArrayList<String>()); //upper bound not met

        //upper bounds in variables (advanced)
//        https://docs.oracle.com/javase/tutorial/java/generics/wildcardGuidelines.html
//        https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html

        // unbounded variable types (java allows them, but you should not use it)
        List<? extends B> list2 = new ArrayList<B>();
//        list2.add( new B() ); // curiously, java does not see a B instance as a fit candidate!
        // that's because the compiler type capture can not determine the type here
        // dont use unbounded wildcard for local variable types, compiler will not capture the type B in this case.

        // possible fix: bound a type to a new variable type, e.g.
        List<B> ll = (List<B>) list2;
        ll.add(new B());

        List<B> lb = new ArrayList<>();
        List<? extends A2> la = lb;
//        la.add(new A2());  // compile-time error, same problem as before

    }

}
