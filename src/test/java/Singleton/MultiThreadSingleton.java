package Singleton;

public class MultiThreadSingleton {

    private static MultiThreadSingleton instance;

    //eager initialization 미리 만들어 두고 반환을 하기 때문에 빠르다 하지만 미리 만든다는것이 단점으로 작용하여
    //애플리케이션을 구동할때 성능에 문제를 일으킬 수 있다.
    private static final MultiThreadSingleton finalInstance = new MultiThreadSingleton();

    private MultiThreadSingleton (){
    }

    //synchronized 는 성능의 문제가 발생 할 수 있음 lock 을 사용하기 떄문에
    public static synchronized MultiThreadSingleton getSynchronizedInstance(){
        if (instance == null) {
            instance = new MultiThreadSingleton();
        }
        return instance;
    }

    public static MultiThreadSingleton getEagerInstance() {
        return finalInstance;
    }
}
