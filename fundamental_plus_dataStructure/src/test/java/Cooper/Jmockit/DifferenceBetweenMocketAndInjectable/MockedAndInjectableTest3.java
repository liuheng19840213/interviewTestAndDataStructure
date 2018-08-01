package Cooper.Jmockit.DifferenceBetweenMocketAndInjectable;

import mockit.Injectable;
import org.junit.Test;

public class MockedAndInjectableTest3 {
    @Injectable
    ToBeMocked instance;

    @Test
    public void test()
    {
        System.out.println(instance.fun()); //null instance这个实例被Mocked了

        ToBeMocked newInstance = new ToBeMocked();
        System.out.println(newInstance.fun()); //call original method  这个没有被Mocked
    }
}
