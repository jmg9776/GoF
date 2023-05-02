package Singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SingletonTests {
    @Test
    void nonSingleTonTests() {
        NonSingleton nonSingletonTest1 = new NonSingleton();
        NonSingleton nonSingletonTest2 = new NonSingleton();
        assertEquals(nonSingletonTest1, nonSingletonTest2);
        //new 를 이용해 객체를 계속해서 생성하므로 assertEquals 결과 오류가 발생하게 된다.
    }

    @Test
    void singleTonTest() {
        Singleton singletonTest1 = Singleton.getInstance();
        Singleton singletonTest2 = Singleton.getInstance();
        assertEquals(singletonTest1, singletonTest2);
        //싱글톤 패턴을 적용하여 객체를 생성하고 전달한다. 하지만 이 객체는 멀티스레드 환경에서 문제가 발생할 수 있다.
    }

    @Test
    void synchronizedInstanceTest() {
        List<MultiThreadSingleton> multiThreadSingletons = new ArrayList<>();
        for (int i=0;i<10000000;i++){
            multiThreadSingletons.add(MultiThreadSingleton.getSynchronizedInstance());
        }
        assertEquals(multiThreadSingletons.get(0), multiThreadSingletons.get(999));
        //Junit 500ms
    }

    @Test
    void doubleLockInstanceTest() {
        List<MultiThreadSingleton> multiThreadSingletons = new ArrayList<>();
        for (int i=0;i<10000000;i++){
            multiThreadSingletons.add(MultiThreadSingleton.getDoubleLockInstance());
        }
        assertEquals(multiThreadSingletons.get(0), multiThreadSingletons.get(999));
        //Junit 350ms
    }

    @Test
    void eagerInstanceTest() {
        List<MultiThreadSingleton> multiThreadSingletons = new ArrayList<>();
        for (int i=0;i<10000000;i++){
            multiThreadSingletons.add(MultiThreadSingleton.getEagerInstance());
        }
        assertEquals(multiThreadSingletons.get(0), multiThreadSingletons.get(999));
        //Junit 300ms
    }

    @Test
    void innerInstanceTest() {
        List<MultiThreadSingleton> multiThreadSingletons = new ArrayList<>();
        for (int i=0;i<10000000;i++){
            multiThreadSingletons.add(MultiThreadSingleton.getInnerInstance());
        }
        assertEquals(multiThreadSingletons.get(0), multiThreadSingletons.get(999));
        //Junit 350ms
    }
}
