package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Player extends Entity {
    @Override
    public String getType() {
        return "player";
    }

    @Override
    public String getShooterType() {
        return getType();
    }
}
