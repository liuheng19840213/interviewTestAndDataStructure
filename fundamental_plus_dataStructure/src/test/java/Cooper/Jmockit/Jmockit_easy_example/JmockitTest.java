package Cooper.Jmockit.Jmockit_easy_example;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

public class JmockitTest {

    //@Mocked  either mocked here or new Mock<>  can be pasted
    private Constructor constructor = null;//why mocked is necessary this time

    //inorder to test getName method
    @Test
    public void t1() {
        MockUp<IStudentService> proxyStub = new MockUp<IStudentService>() {
            // 需要使用@Mock标记,否则jmockit不会处理;
            // 而且方法的签名必须与接口中方法签名一致，否则jmockit会报错
            @Mock
            public String getName(int id) {
                return "00" + id;
            }
        };

        IStudentService mockInstance = proxyStub.getMockInstance();

        Assert.assertEquals("001", mockInstance.getName(1));

        Assert.assertEquals(0, mockInstance.getAge(1));// no returns so .....

        proxyStub.tearDown();
    }

    //in order to test getAge method
    @Test
    public void t2() {
        MockUp<AbstractStudentService> proxyStub = new MockUp<AbstractStudentService>() {
            @Mock
            public int getAge(int id) {
                return 10 * id;
            }
        };

        AbstractStudentService mockInstance = proxyStub.getMockInstance();

        Assert.assertEquals("ATY", mockInstance.getName(1));

        Assert.assertEquals(10, mockInstance.getAge(1));

        proxyStub.tearDown();
    }


    @Test
    public void mockConstructor() {
        // MockUp可以对应一个类或者接口，如果它的子类中有方法被注解了@Mock，
        // 并且恰好方法的签名又和传入的泛型的类型中某个方法一样，那么对应的方法就被Mock
        new MockUp<Constructor>() {

            private String memberId;

            // $init表示构造方法
            @Mock
            public void $init(String memberId) {
                this.memberId = "mock_" + memberId;
            }

            @Mock
            public String getRealName() {
                return this.memberId;
            }

        };


        //触发构造方法的mock
        constructor = new Constructor("Constructor");

        Assert.assertEquals("mock_Constructor", constructor.getRealName());

    }

}
