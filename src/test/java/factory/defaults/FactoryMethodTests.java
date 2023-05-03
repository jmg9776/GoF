package factory.defaults;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryMethodTests {
    @Test
    void factoryInterfaceTest() {
        String conv1 = new FactoryFirst().factoryTest("hello");
        String conv2 = new FactorySecond().factoryTest("hello");
        assertEquals(conv1, conv2);
    }

    @Test
    void factoryInterfaceDITest() {
        String conv1 = factoryInterfaceDI(new FactoryFirst(), "hello");
        String conv2 = factoryInterfaceDI(new FactorySecond(), "hello");
        assertEquals(conv1, conv2);
    }

    String factoryInterfaceDI(FactoryInterface factoryInterface, String message) {
        return factoryInterface.factoryTest(message);
    }
}
