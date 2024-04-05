package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


/*
Interface for services representing game plugins.
 * Game plugins can be started and stopped, affecting the game state
 */
public interface IGamePluginService {

    void start(GameData gameData, World world);
    /*
    @param: GameData repræsenterer dataene, der er relevante for spillets aktuelle tilstand og konfiguration.(game state)
    @param : world includes the all entities, when we add entity we use world.add

     */

    void stop(GameData gameData, World world);
}
