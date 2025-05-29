package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Enemy extends Entity {
    @Override
    public void setLastFiredBullet(long lastFiredBullet) {
        super.setLastFiredBullet(lastFiredBullet);
    }

    @Override
    public String getType() {
        return "enemy";
    }

    @Override
    public String getShooterType() {
        return "";
    }

    @Override
    public int getEnemyBulletCooldown() {
        return super.getEnemyBulletCooldown();
    }
}
