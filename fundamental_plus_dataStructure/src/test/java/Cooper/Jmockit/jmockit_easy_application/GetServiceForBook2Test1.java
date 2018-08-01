package Cooper.Jmockit.jmockit_easy_application;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetServiceForBook2Test1 {
    @Mocked
    private GetServiceForBook2 getServiceForBook;

    @Injectable
    private JustForTest2 jft;

    @Test
    public void testBookService() {

        new Expectations(){

            {
                jft.getResult();
                result = true;
                times = 1;
            }

        };

        //里面还有两个注解一个@Tested一个是@Injectable。
        // 第一个@Tested不能变只能是这个，
        // 第二个可以写成@Mocked。
        // 如果第一个改成@Mocked的话输出结果就变成0，
        // 也就是说不过你的参数是什么结果都是输出0。
        // 这是因为在你使用Mocked注解时，如果没有进行“修改”，那
        // 系统就会自己帮你把这个类里的所有方法都Mock掉，
        // 而mock的内容就是返回默认值。（int的默认值是0）。
        int test = getServiceForBook.getService("novel");
        assertEquals(1,test);
    }
}
