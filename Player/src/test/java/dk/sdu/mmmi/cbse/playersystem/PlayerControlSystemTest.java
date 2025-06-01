package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;

import mockit.*;

import java.util.Collections;
import static org.junit.Assert.*;


public class PlayerControlSystemTest {

    //Tested system
    @Tested
    PlayerControlSystem playerControlSystem;

    //dependencies
    @Mocked
    GameData gameData;

    @Mocked
    GameKeys gameKeys;

    @Mocked
    World world;

    @Mocked
    Player player;


    @org.junit.Test
    public void testPlayerMoveForward() {
        //setup
        new Expectations() {{
            gameData.getKeys(); result = gameKeys;
            gameKeys.isDown(GameKeys.UP); result = true;

            world.getEntities(Player.class); result = Collections.singletonList(player);

            player.getX(); result = 100;
            player.getY(); result = 100;
            player.getRotation(); result = 0;
        }};
        //act
        playerControlSystem.process(gameData, world);

        //Asserts
        new Verifications() {{
            double expectedX = 100 + Math.cos(Math.toRadians(player.getRotation()));
            double expectedY = 100 + Math.sin(Math.toRadians(player.getRotation()));

            player.setX(expectedX); times = 1;
            player.setY(expectedY);
        }};
    }
}