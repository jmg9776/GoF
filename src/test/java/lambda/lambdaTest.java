package lambda;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@FunctionalInterface
interface LambdaFunction {
    int sum(int a, int b);
}
public class lambdaTest {
    @Test
    void firstTest() {
        LambdaFunction lambdaFunction = (int a, int b) -> a + b;
        assertEquals(lambdaFunction.sum(1,1), 2);
    }
}
