package Cooper.Jmockit.jmockit_easy_application;

public class GetServiceForBook1 {
    public int getService(String bookType) {

        if ("novel".equals(bookType)){
            return 1;
        }
        else {
            return 2;
        }
    }
}
