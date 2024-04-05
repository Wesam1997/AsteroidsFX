package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 This interface handles services that perform additional processing on
 entities in the game world
 *
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {
    /*
     * @Param gameData the game data containing information about the game state
     * @param world the game world containing entities to be processed
     *  * Precondition: gameData and world must not be null.

     */

    void process(GameData gameData, World world);

}
