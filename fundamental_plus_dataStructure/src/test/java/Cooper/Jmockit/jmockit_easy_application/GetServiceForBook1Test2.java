package Cooper.Jmockit.jmockit_easy_application;

import mockit.Expectations;
import mockit.Injectable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetServiceForBook1Test2 {
    @Injectable
    private GetServiceForBook1 getServiceForBook1;

    @Test
    public void testBookService() {

        new Expectations(){
            {
                getServiceForBook1.getService(anyString);
                result = 3;
                times = 1;
            }

        };

        int test = getServiceForBook1.getService("novel");
        assertEquals(3,test);
    }
}
