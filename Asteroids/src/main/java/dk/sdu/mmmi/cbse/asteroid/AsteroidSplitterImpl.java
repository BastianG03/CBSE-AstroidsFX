package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;

import java.util.Random;

/**
 *
 * @author corfixen
 */
public class AsteroidSplitterImpl implements IAsteroidSplitter {

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        if (e.getRadius()<=5) {
            System.out.println("Too Small!!");
            return;
        }
        //int splitAmount = new Random().nextInt(2) + 1;
        int splitAmount = 2;
        for (int i = 0; i < splitAmount; i++) {
            //System.out.println(splitAmount);
            int rndSpawn = 10;
            Entity asteroid1 = new Asteroid();
            Entity asteroid2 = new Asteroid();
            Random randomRotation = new Random();
            double[] polygonCoords = new double[e.getPolygonCoordinates().length];
            for (int j = 0; j < polygonCoords.length; j++) {
                polygonCoords[j] = e.getPolygonCoordinates()[j]/2;
            }
            asteroid1.setPolygonCoordinates(polygonCoords);
            asteroid1.setX(e.getX()+rndSpawn);
            asteroid1.setY(e.getY()+rndSpawn);
            asteroid1.setRadius(e.getRadius()/2);
            asteroid1.setRotation(e.getRotation() + 60);
            asteroid1.setHealth(200);
            asteroid1.setSide(e.getSide());
            world.addEntity(asteroid1);

            asteroid2.setPolygonCoordinates(polygonCoords);
            asteroid2.setX(e.getX()-rndSpawn);
            asteroid2.setY(e.getY()-rndSpawn);
            asteroid2.setRadius(e.getRadius()/2);
            asteroid2.setRotation(e.getRotation() - 60);
            asteroid2.setHealth(200);
            asteroid2.setSide(e.getSide());
            world.addEntity(asteroid2);
        }

    }

}
