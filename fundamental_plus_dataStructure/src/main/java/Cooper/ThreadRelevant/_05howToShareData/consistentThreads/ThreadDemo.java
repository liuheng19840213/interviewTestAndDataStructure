package Cooper.ThreadRelevant._05howToShareData.consistentThreads;

import org.junit.Test;

public class ThreadDemo {


    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        for (int i=0;i<4;i++){
            new Thread(new RunnableCusToInc(sharedData),"Thread"+i).start();
        }
    }
}
