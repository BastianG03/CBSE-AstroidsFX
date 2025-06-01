package dk.sdu.mmmi.cbse.common.asteroids;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Asteroid extends Entity {


    @Override
    public String getType() {
        return "asteroid";
    }

    @Override
    public String getShooterType() {
        return "";
    }
}
