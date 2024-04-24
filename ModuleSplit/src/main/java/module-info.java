import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module ModuleSplit {

    requires Common;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.enemysystem.EnemyNewProceses;
}