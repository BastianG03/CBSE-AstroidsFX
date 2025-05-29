package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

import java.util.ServiceLoader;

public class CollisionDetector implements IPostEntityProcessingService {

    private static final IAsteroidSplitter splitter = ServiceLoader.load(IAsteroidSplitter.class).iterator().next();

    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;                    
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    if(entity1.getSide().equals(entity2.getSide())) {
                        continue;
                    }
                    int tempHealth1 = entity1.getHealth();
                    int tempHealth2 = entity2.getHealth();
                    entity1.setHealth(entity1.getHealth() - tempHealth2);
                    entity2.setHealth(entity2.getHealth() - tempHealth1);
                    if (entity1.getType().equals("asteroid")) {
                        if (entity1.getHealth() <= 0) {
                            splitter.createSplitAsteroid(entity1, world);
                            System.out.println("split e1 as: " + entity1.getID());
                            world.removeEntity(entity1);
                            gameData.setScore(gameData.getScore()+1);
                        } else {
                            entity1.setRotation(entity1.getRotation() + entity2.getRotation());
                        }
                    } else if (entity1.getType().equals("player") && entity1.getHealth() <= 0) {
                        System.out.println("You Died!");
                        System.exit(400);
                    } else if (entity1.getType().equals("enemy")) {
                        if (entity1.getHealth() <= 0) {
                            world.removeEntity(entity1);
                        }
                    } else if (entity1.getType().equals("bullet")) {
                        if (entity1.getHealth() <= 0) {
                            world.removeEntity(entity1);
                        }
                    }
                    if (entity2.getType().equals("asteroid")) {
                        if (entity2.getHealth() <= 0) {
                            splitter.createSplitAsteroid(entity2, world);
                            System.out.println("split e2 as: " + entity2.getID());
                            world.removeEntity(entity2);
                            gameData.setScore(gameData.getScore()+1);
                        } else {
                            entity2.setRotation(entity1.getRotation() + entity1.getRotation());
                        }
                    } else if (entity2.getType().equals("player") && entity2.getHealth() <= 0) {
                        System.out.println("You Died!");
                        System.exit(400);
                    } else if (entity2.getType().equals("enemy")) {
                        if (entity2.getHealth() <= 0) {
                            world.removeEntity(entity2);
                        }
                    } else if (entity2.getType().equals("bullet")) {
                        if (entity2.getHealth() <= 0) {
                            world.removeEntity(entity2);
                        }
                    }
                }
            }
        }

    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

}
