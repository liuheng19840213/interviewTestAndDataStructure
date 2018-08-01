package Cooper.ThreadRelevant._01startDemo;

public class ThreadStart1 {
    public static class MyThread {
        public static void main(String[] args) {
            for(int i =1;i<=100;i++){
                System.out.println("游戏开始" + i);
                if (i==10) {
                    MusicThread musicThread = new MusicThread();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    musicThread.start();
                }
            }
        }
    }
}

class MusicThread extends Thread{
    @Override
    public void run() {
        for (int i = 1;i<=100;i++){
            System.out.println("听音乐"+i);
        }
    }
}
