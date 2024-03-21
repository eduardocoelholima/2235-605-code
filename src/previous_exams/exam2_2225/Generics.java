package exam2;

public class Generics<T> {

    T value;
    Generics<T> next;

    public Generics(T value) { this.value = value; }
    public void setNext(Generics<T> next) { this.next = next; }
    public String toString() { return value.toString(); }

    public static void main(String[] args)	{
        Generics<? super String> instance = new Generics<String>("nothing here"); //1
        instance.setNext(new Generics("nothing there")); //2
        System.out.println(instance);
        System.out.println(instance.next);
    }
}


// 1. What is the output of this program?
//nothing here
//nothing there

// 2. Explain in detail if a type checking is done in the line marked with the in-line comment "1".
// The <? super String> in a variable requires a String or superclass to be
// the type parameter, this is checked at compile time

// 3. Is the line marked with the in-line comment "2" valid java syntax? Is there any problem with this line?
// yes

