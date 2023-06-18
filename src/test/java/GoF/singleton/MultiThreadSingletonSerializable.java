package GoF.singleton;

import java.io.Serializable;

public class MultiThreadSingletonSerializable implements Serializable {

    private static MultiThreadSingletonSerializable instance;

    private static volatile MultiThreadSingletonSerializable volatileInstance;

    //eager initialization 미리 만들어 두고 반환을 하기 때문에 빠르다 하지만 미리 만든다는것이 단점으로 작용하여
    //애플리케이션을 구동할때 성능에 문제를 일으킬 수 있다.
    private static final MultiThreadSingletonSerializable finalInstance = new MultiThreadSingletonSerializable();

    private MultiThreadSingletonSerializable(){
    }

    private static class MultiThreadSingletonHolder {
        private static final MultiThreadSingletonSerializable finalInstance = new MultiThreadSingletonSerializable();
    }

    //synchronized 는 성능의 문제가 발생 할 수 있음 lock 을 사용하기 떄문에
    public static synchronized MultiThreadSingletonSerializable getSynchronizedInstance(){
        if (instance == null) {
            instance = new MultiThreadSingletonSerializable();
        }
        return instance;
    }

    public static MultiThreadSingletonSerializable getDoubleLockInstance(){
        //미리 인스턴스를 검사를 하고 싱크로나이즈를 걸기 때문에 성능적으로 더 좋다.
        if (volatileInstance == null) {
            synchronized (MultiThreadSingletonSerializable.class){
                if (volatileInstance == null) {
                    volatileInstance = new MultiThreadSingletonSerializable();
                }
            }
        }
        return volatileInstance;
    }

    public static MultiThreadSingletonSerializable getInnerInstance() {
        return MultiThreadSingletonHolder.finalInstance;
    }

    public static MultiThreadSingletonSerializable getEagerInstance() {
        return finalInstance;
    }

    protected Object readResolve() {
        //역직렬화를 사용할때 readResolve 라는 메서드를 사용하게 되는데 이때 역직렬화를 대신해서 만들어둔 메서드를 날려주면 역질렬화를 방지할 수 있다.
        return getInnerInstance();
    }
}
