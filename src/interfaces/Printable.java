package interfaces;

public interface Printable {
    public String repr();
    default String sayHo() {
        return "HO!";
    }
}
