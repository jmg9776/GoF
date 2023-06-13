package bridge;

import bridge.champions.Ahri;
import bridge.champions.Champion;
import bridge.skins.KDA;
import bridge.skins.Shadow;
import bridge.skins.Skin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class test {
    /*
    브릿지 패턴
    추상적인 것과 구체적인 것을 분리하여 연결

    장점 : 코드를 구체적인 변경없이 독립적으로 확장 가능
    추상적인 코드와 구체적인 코드를 분리할 수 있다.

    계층구조가 늘어나 복잡도가 증가한다.
     */
    @Test
    void t() {
        Champion ahri = new Ahri(new KDA());
        Champion ahri2 = new Ahri(new Shadow());
        ahri.move();
        ahri2.move();
    }
}
