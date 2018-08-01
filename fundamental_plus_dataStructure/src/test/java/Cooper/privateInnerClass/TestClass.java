package Cooper.privateInnerClass;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Test;

public class TestClass {

    private class InnerClass{
        @Mocked
         private Person p;

    }
    @Test
    public void readField(){
        new MockUp<Person>(){
            @Mock
            public String getName(){
                return "lily";
            }
        };
        InnerClass inner = new InnerClass();
        //String name = inner.p.getName();
        //System.out.println(name);
    }
}
