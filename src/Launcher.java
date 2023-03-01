import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Game;
import view.MenuView;
import view.PlateauView;
import view.StatisticsView;

public class Launcher extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Game game = new Game(5);
        BorderPane root = new BorderPane();

        // Views
        MenuView menuView = new MenuView(game);
        PlateauView plateauView = new PlateauView(game);
        StatisticsView statisticsView = new StatisticsView(game);

        // Position
        root.setTop(menuView);
        root.setCenter(plateauView);
        root.setBottom(statisticsView);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
