package Cooper.Jmockit.jmockit_easy_application;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetServiceForBook1Test3 {

    @Test
    public void testBookService() {
        GetServiceForBook1 getServiceForBook1 = new GetServiceForBook1();
        new MockUp<GetServiceForBook1>(){
            @Mock
            public int getService(String bookType)
            {
                return 3;
            }
        };

        int test = getServiceForBook1.getService("novel");
        assertEquals(3,test);
    }
}
