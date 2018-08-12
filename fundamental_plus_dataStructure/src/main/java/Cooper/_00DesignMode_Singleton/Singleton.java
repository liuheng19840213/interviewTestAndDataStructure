package Cooper._00DesignMode_Singleton;


public class Singleton {
    private Singleton() {
        System.out.println("Singleton  is  create"); // 创建单例的过程可能会比较慢
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}