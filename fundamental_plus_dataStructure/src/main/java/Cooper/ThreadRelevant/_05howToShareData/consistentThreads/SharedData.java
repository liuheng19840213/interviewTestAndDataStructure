package Cooper.ThreadRelevant._05howToShareData.consistentThreads;

/**
 * shared data class
 */
public class SharedData {
    private int num = 10;

    public synchronized void inc() {
        num++;
        System.out.println(Thread.currentThread().getName() + ":invoke inc method num = " + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

