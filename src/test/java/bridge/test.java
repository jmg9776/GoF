package bridge;

import bridge.champions.Ahri;
import bridge.champions.Champion;
import bridge.skins.KDA;
import bridge.skins.Shadow;
import bridge.skins.Skin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class test {
    @Test
    void t() {
        Champion ahri = new Ahri(new KDA());
        Champion ahri2 = new Ahri(new Shadow());
        ahri.move();
        ahri2.move();
    }
}
