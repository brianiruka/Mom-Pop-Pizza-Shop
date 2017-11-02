import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Pizza extends Application {
    Group root = new Group();
    //needed to create scene
    Scene scene1 = new Scene(root, 655, 600, Color.WHITE);
    //creates/holds initial scene, including tabs
    TabPane tabPane = new TabPane();
    Tabs newTab = new Tabs();
    BorderPane borderPane = new BorderPane();
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mom & Pop Pizza Shop");
        //window title
        tabPane.getTabs().add(newTab.createTab1());
        borderPane.setCenter(tabPane);
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene1.heightProperty());
        borderPane.prefWidthProperty().bind(scene1.widthProperty());
        root.getChildren().add(borderPane);

        //initialize tabbed scene
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

   
}