package Cooper.Jmockit.jmockit_easy_application;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetServiceForBook2Test2 {
    private GetServiceForBook2 getServiceForBook = new GetServiceForBook2();

    @Test
    public void testBookService() {

        new MockUp<JustForTest2>(){
            @Mock
            public boolean getResult()
            {
                return true;
            }
        };

        int test = getServiceForBook.getService("novel");
        assertEquals(1,test);
    }
}
