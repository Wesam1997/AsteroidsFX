import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module ModuleSplit {

    requires Common;
    provides IGamePluginService with dk.sdu.mmmi.cbse.enemysystem.EnemyPluin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.enemysystem.EnemyControlle;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.enemysystem.EnemyNewProceses;
}