@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName() {
        System.out.println("hello");
    }

    default void printAge() {
        System.out.println("100");
    }

}