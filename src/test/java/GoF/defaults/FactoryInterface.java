package GoF.defaults;

public interface FactoryInterface {
    String testMethod();

    default String factoryTest(String n) {
        return n + testMethod();
    }
}
