package singleton;

public enum EnumSingleton {
    INSTANCE;
    //enum 은 reflection 을 막을 수 있지만 클래스를 로딩하면 이미 완성을 해두는 단점이 있다.
}
