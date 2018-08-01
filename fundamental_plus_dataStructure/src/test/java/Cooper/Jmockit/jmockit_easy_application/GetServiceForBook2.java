package Cooper.Jmockit.jmockit_easy_application;

public class GetServiceForBook2 {
    JustForTest2 jft = new JustForTest2();

    public GetServiceForBook2()
    {

    }

    public GetServiceForBook2(JustForTest2 jft)
    {
        this.jft = jft;
    }

    public int getService(String bookType) {

        boolean flag = jft.getResult();
        System.out.println(flag);
        if ("novel".equals(bookType)) {
            return 1;
        }
        else {
            return 2;
        }
    }
}
