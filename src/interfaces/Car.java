package interfaces;

public class Car implements Printable {

    private String model = "no model";
    @Override
    public String repr() {
        return this.model;
    }

    public static void main(String[] args) {
        System.out.println(new Car().sayHo());
    }
}
