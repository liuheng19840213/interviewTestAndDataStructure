package Cooper.Jmockit.jmockit_easy_application;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetServiceForBook1Test1 {
    private GetServiceForBook1 getServiceForBook1 = new GetServiceForBook1();

    @Test
    public void testBookService() {

        int test = getServiceForBook1.getService("novel");

        assertEquals(1,test);
    }
}
