package bridge.champions;

import bridge.skins.Skin;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultChampion implements Champion {
    protected Skin skin;
    protected String name;

    public DefaultChampion(Skin skin, String name) {
        this.skin = skin;
        this.name = name;
    }

    @Override
    public void move() {
        System.out.printf("%s %s move\n", skin.getName(), this.name);
    }

    @Override
    public void useQ() {
        System.out.printf("%s %s move\n", skin.getName(), this.name);
    }

    @Override
    public void useW() {
        System.out.printf("%s %s move\n", skin.getName(), this.name);
    }

    @Override
    public void useE() {
        System.out.printf("%s %s move\n", skin.getName(), this.name);
    }

    @Override
    public void userR() {
        System.out.printf("%s %s move\n", skin.getName(), this.name);
    }
}
