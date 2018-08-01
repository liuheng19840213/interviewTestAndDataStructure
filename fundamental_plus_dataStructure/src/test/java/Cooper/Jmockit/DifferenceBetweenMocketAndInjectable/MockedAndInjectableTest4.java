package Cooper.Jmockit.DifferenceBetweenMocketAndInjectable;

import mockit.Injectable;
import org.junit.Test;

public class MockedAndInjectableTest4 {
    @Test
    public void test1(@Injectable final ToBeMocked instanceA)
    {
        System.out.println(instanceA.fun()); //null

        ToBeMocked newInstance = new ToBeMocked();
        System.out.println(newInstance.fun()); //call original method
    }

    @Test
    public void test2()
    {
        ToBeMocked newInstance = new ToBeMocked();
        System.out.println(newInstance.fun()); //call original method
    }
}
