package Cooper.Jmockit.DifferenceBetweenMocketAndInjectable;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;

public class MockedAndInjectableTest1 {
    @Mocked
    ToBeMocked instance;

    @Before
    public void setUp(){
        new MockUp<ToBeMocked>(){
            Person p = new MockUp<Person>(){
                @Mock
                public String getName(){
                    return "cooper L";
                }
            }.getMockInstance();
        };
    }
    @Test
    public void test()
    {

        System.out.println(instance.fun()); //null 所有实例都是Mocked的

        ToBeMocked newInstance = new ToBeMocked();
        System.out.println(newInstance.fun()); //null所有实例都是Mocked的
    }
}
