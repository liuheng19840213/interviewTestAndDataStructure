package Cooper.lambda_java8;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class IterationReplacement {
    @Test
    public void testIteration(){
        List<String> list = Arrays.asList("lily", "lucy", "cooper");
        list.forEach(System.out::println);
        list.forEach(y -> System.out.println(y));
    }
}
