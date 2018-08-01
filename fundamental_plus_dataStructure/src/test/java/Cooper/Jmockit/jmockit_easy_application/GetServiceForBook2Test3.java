package Cooper.Jmockit.jmockit_easy_application;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetServiceForBook2Test3 {
    private GetServiceForBook2 getServiceForBook;

    @Test
    public void testBookService() {

        JustForTest2 mock = new MockUp<JustForTest2>(){
            @Mock
            public boolean getResult()
            {
                return true;
            }
        }.getMockInstance();

        getServiceForBook = new GetServiceForBook2(mock);
        int test = getServiceForBook.getService("novel");
        assertEquals(1,test);
    }
}
