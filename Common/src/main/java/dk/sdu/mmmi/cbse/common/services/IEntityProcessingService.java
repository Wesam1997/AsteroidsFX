package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *methode  It tells that this method is used to process a single device in the game world.
     *
     *
     * @param gameData containing information about the game state
     * @param world  when the entity are in the world/containing the entity to be processed
     *
     *
     * @throws
     */
    void process(GameData gameData, World world);
}
