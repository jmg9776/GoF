package GoF.bridge.skins;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Skin {
    String name;
    public Skin(String name) {
        this.name = name;
    }
}
