public class Foo {
    public static void main(String[] args) {

        RunSomething runSomething = (int number) -> {
            System.out.println("Hello");
            return number;
        };
        runSomething.doIt(10);
    }
}
