package GoF.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

public class BreakSingletonTest {
    @Test
    void reflectionTest()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MultiThreadSingleton m1 = MultiThreadSingleton.getInnerInstance();

        Constructor<MultiThreadSingleton> constructor = MultiThreadSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        MultiThreadSingleton m2 = constructor.newInstance();
        assertEquals(m1, m2);
    }

    @Test
    void serializableTest() {
        MultiThreadSingletonSerializable m1 = MultiThreadSingletonSerializable.getInnerInstance();
        MultiThreadSingletonSerializable m2 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("m1.obj"))) {
            out.writeObject(m1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("m1.obj"))) {
            m2 = (MultiThreadSingletonSerializable) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertEquals(m1, m2);
    }

    @Test
    void enumTest()
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        EnumSingleton m1 = EnumSingleton.INSTANCE;
        EnumSingleton m2 = null;

        Constructor<?>[] constructor = EnumSingleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor1 : constructor) {
            constructor1.setAccessible(true);
            m2 = (EnumSingleton) constructor1.newInstance("INSTANCE");
        }
        assertEquals(m1, m2);
    }
}
