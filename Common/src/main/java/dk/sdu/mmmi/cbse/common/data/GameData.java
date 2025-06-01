package dk.sdu.mmmi.cbse.common.data;

public class GameData {

    private int displayWidth  = 800 ;
    private int displayHeight = 800;
    private int worldWidth  = displayWidth +200 ;
    private int worldHeight = displayHeight +200 ;
    private int fireRate = 5;
    private long lastFiredBullet;
    private long lastFiredEnemyBullet;
    private int bulletCooldown = 1000;
    private int EnemyBulletCooldown = 1000;
    private long lastEnemyMove;
    private int enemyMoveCooldown = 100;
    private long lastSpawnedAstroid;
    private long lastSpawnedEnemy;
    private int enemySpawnCooldown = 5000;
    private int astroidCooldown = 4000;
    private final GameKeys keys = new GameKeys();
    private int Score = 0;


    public GameKeys getKeys() {
        return keys;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getFireRate() {
        return fireRate;
    }

    public long getLastFiredBullet() {
        return lastFiredBullet;
    }

    public void setLastFiredBullet(long lastFiredBullet) {
        this.lastFiredBullet = lastFiredBullet;
    }

    public int getBulletCooldown() {
        return bulletCooldown;
    }

    public long getLastSpawnedAstroid() {
        return lastSpawnedAstroid;
    }

    public void setLastSpawnedAstroid(long lastSpawnedAstroid) {
        this.lastSpawnedAstroid = lastSpawnedAstroid;
    }

    public int getAstroidCooldown() {
        return astroidCooldown;
    }

    public long getLastSpawnedEnemy() {
        return lastSpawnedEnemy;
    }

    public void setLastSpawnedEnemy(long lastSpawnedEnemy) {
        this.lastSpawnedEnemy = lastSpawnedEnemy;
    }

    public int getEnemySpawnCooldown() {
        return enemySpawnCooldown;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
