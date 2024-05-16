package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CollisionDetectorTest {
    private Entity entity1;
    private Entity entity2;
    private World world1;
    private GameData gameData1;

    private CollisionDetector collisionDetector;
    @BeforeEach
    public void setUp() {
        entity1 = new Entity();
        entity1.setX(10);
        entity1.setY(20);
        entity1.setRotation(20);
        entity1.setType(entity1.getType());
        entity2.setType(entity2.getType());

        entity2 = new Entity();
        entity2.setX(10); // Different position to avoid initial collision
        entity2.setY(20);
        entity2.setRotation(30);
        collisionDetector = new CollisionDetector();
        world1=new World();
        gameData1=new GameData();


    }

    @Test
    void collides() {
        assertTrue(collisionDetector.collides(entity1, entity2));
    }
    @Test
    void process() {
        world1.addEntity(entity1);
        world1.addEntity(entity2);
        collisionDetector.process(gameData1,world1);
        assertTrue(entity1.isDied() && entity2.isDied());
    }
}
