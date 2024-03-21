package exam2;
import java.io.*;

public class Serialization implements Serializable {
    static Object value = Integer.parseInt("0");

    static void read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.save"));) {
            Serialization o = (Serialization) in.readObject();
            System.out.println("Value = " + o.value);
            o.value = Integer.parseInt("42");
            System.out.println("Value = " + o.value);
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    static void write() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.save"));) {
            Serialization o = new Serialization();
            out.writeObject(o);
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public static void main (String args[] ){
        write();
        read();
    }
}

// 1. What is the output of this program?

//Value = 0
//Value = 42

// 2. Is the field 'value' included in the serialization process?

// No.

// 3. Why is the value "0" printed in the first println() call?

// It is a static field initialized by the class when the program runs,
// not part of the serialization/deserialization

//4. Is is allowed by java syntax to assign an Integer instance to an Object variable,
//    as you see in the initialization of the 'value' field?

//Yes