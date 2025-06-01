package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;


public class Bullet extends Entity {

    private final String shooterType;

    public Bullet(String shooterType) {
        this.shooterType = shooterType;
    }

    @Override
    public String getType() {
        return "bullet";
    }

    @Override
    public String getShooterType() {
        return shooterType;
    }
}
