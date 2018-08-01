package Cooper.Jmockit.DifferenceBetweenMocketAndInjectable;

import mockit.Mocked;
import org.junit.Test;

public class MockedAndInjectableTest2 {
    @Test
    public void test1(@Mocked final ToBeMocked instance)
    {
        System.out.println(instance.fun()); //null 所有实例都是Mocked的

        ToBeMocked newInstance = new ToBeMocked();
        System.out.println(newInstance.fun()); //null 所有实例都是Mocked的
    }

    @Test
    public void test2()
    {
        ToBeMocked newInstance = new ToBeMocked();
        System.out.println(newInstance.fun()); //call original method 没有Mocked
    }
}
