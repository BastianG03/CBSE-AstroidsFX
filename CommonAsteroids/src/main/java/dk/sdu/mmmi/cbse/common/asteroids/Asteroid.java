package dk.sdu.mmmi.cbse.common.asteroids;

import dk.sdu.mmmi.cbse.common.data.Entity;


/**
 *
 * @author corfixen
 */
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
