package lambda;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@FunctionalInterface
interface LambdaFunction {
    int sum(int a, int b);
}

@Slf4j
public class lambdaTest {
    @Test
    void firstTest() {
        LambdaFunction lambdaFunction = (int a, int b) -> a + b;
        assertEquals(lambdaFunction.sum(1,1), 2);
    }

    @Test
    void lambdaDefaultInterfaceTest() {
        Runnable runnable = () -> log.info("runnable");
        runnable.run();
    }

    @Test
    void streamTest() {
        String[] stringArr = {"aa","bb","cc","dd"};
        List<String> stringList = Arrays.asList(stringArr);
        Stream<String> stringStream1 = stringList.stream();
        Stream<String> stringStream2 = Arrays.stream(stringArr);
        stringStream1.sorted().forEach(System.out::println);
        stringStream2.sorted().forEach(System.out::println);
    }
}
