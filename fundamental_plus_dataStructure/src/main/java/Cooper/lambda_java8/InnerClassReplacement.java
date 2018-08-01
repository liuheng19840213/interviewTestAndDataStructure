package Cooper.lambda_java8;

import org.junit.jupiter.api.Test;

public class InnerClassReplacement {

    @Test
    public void oldRunable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();
    }

    //in the way, ()->  can replace the whole inner class
    @Test
    public void newRunnable(){
        new Thread(()->System.out.println("The new runable now is using!")).start();
    }

}
