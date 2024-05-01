package dk.sdu.mmmi.cbse.playersystem;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class PlayerControlSystemTest {
    @Mock
    private GameData gameData;
    @Mock
    private World world;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void testPlayerMovment(){
       PlayerControlSystem playerControlSystem=new PlayerControlSystem();

       Entity player=mock(Entity.class);
       when(player.getRadius()){

        }
   }
}