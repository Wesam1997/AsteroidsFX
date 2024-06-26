package dk.sdu.mmmi.cbse.main;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import static java.util.stream.Collectors.toList;

public class Game extends Application {
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();
    private final Pane gameWindow = new Pane();

    private List<IGamePluginService> pluginServices;

    private List<IEntityProcessingService> entityProcessingServices;
    private List<IPostEntityProcessingService> postEntityProcessingServices;


    public Game(List<IGamePluginService> iGamePluginServices,
                List<IEntityProcessingService> iEntityProcessingServices,
                List<IPostEntityProcessingService> iPostEntityProcessingServices)
    {
        pluginServices = iGamePluginServices;
        entityProcessingServices = iEntityProcessingServices;
        postEntityProcessingServices = iPostEntityProcessingServices;
    }


    @Override
    public void start(Stage primaryStage) {
        loadPlugins();
        Scene scene = new Scene(gameWindow, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ASTEROIDS");
        primaryStage.show();
        render();
    }

    private void loadPlugins() {
        for (IGamePluginService pluginService : pluginServices) {
            pluginService.start(gameData, world);
        }
    }

    public void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
                gameData.getKeys().update();
            }
        }.start();
    }

    private void update() {
        for (IEntityProcessingService entityProcessorService : entityProcessingServices ) {
            entityProcessorService.process(gameData, world);
        }

        for (IPostEntityProcessingService postEntityProcessorService : postEntityProcessingServices) {
            postEntityProcessorService.process(gameData, world);
        }
    }

    private void draw() {
        for (Entity polygonEntity : polygons.keySet()) {
            if (!world.getEntities().contains(polygonEntity)) {
                Polygon removedPolygon = polygons.get(polygonEntity);
                polygons.remove(polygonEntity);
                gameWindow.getChildren().remove(removedPolygon);
            }
        }
        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            if (polygon == null) {
                polygon = new Polygon(entity.getPolygonCoordinates());
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());
        }
    }

}
