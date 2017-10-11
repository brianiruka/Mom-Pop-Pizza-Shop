
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tabs");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.WHITE);

        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();

        String[] tabNames = {"Create New Order","Create New Customer","Modify Customer Info","Menu Look-Up"};
        //creates array that holds names of tabs
        String[] buttonNames = {"Size","Crust","Cheese","Meat","Sauce","Veggies"};
        //creates array that holds name of buttons for 'create new order' tab
        for (int i = 0; i < 4; i++) {
            //creates tabs, based on tab index #
            Tab tab = new Tab();
            tab.setText(tabNames[i]);
            
            if( i == 0){
            GridPane grid= new GridPane();    
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setPercentWidth(25);
            ColumnConstraints col2 = new ColumnConstraints();
            col2.setPercentWidth(50);
            ColumnConstraints col3 = new ColumnConstraints();
            col3.setPercentWidth(25);
            grid.getColumnConstraints().addAll(col1,col2,col3);
            
            grid.setHgap(10);
            grid.setVgap(10);    
            //sets up grid pane for tab 0
            Label label1 = new Label("Customer Phone #");
            TextField textField = new TextField ();
            Button button = new Button("Lookup");
            Label label2 = new Label("Please enter Customer ID...");
            button.setOnAction((event) -> {
             label2.setText("[Customer info will be displayed here from database]");
             //GridPane.setColumnSpan(label2,2);
             label2.setTextFill(Color.web("#0076a3"));
             //changes label2 when 'lookup' button is clicked
             
            });
            grid.add(label1, 0, 0, 1, 1);
            grid.add(textField, 1, 0, 1, 1);
            grid.add(button, 2, 0, 1, 1);
            grid.add(label2, 0, 1, 2, 2);
            //adds buttons, labels to grid. parameters:(item,column,row,columns spanned, rows spanned)
            grid.setPadding(new Insets(50, 50, 50, 50)); //(top/right/bottom/left)
            tab.setContent(grid);

            FlowPane flowPane = new FlowPane();
            flowPane.setPadding(new Insets(10, 10, 10, 10));
            flowPane.setVgap(10);
            flowPane.setHgap(10);
            flowPane.setPrefWrapLength(210);
            //modifies spacing for flowPane
            Button btn = new Button();
        
            for (int j = 0; j < 6; j++) {
            //adds topping option buttons
                btn = new Button(buttonNames[j]);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //pops up dialog box based off which button is pressed
                        if(event.toString().contains("Size")){
                            Stage dialogStage = new Stage();

                            Button closeBtn = new Button("ok");
                            VBox vbox = new VBox(closeBtn);
                            vbox.setAlignment(Pos.CENTER);
                            vbox.setPadding(new Insets(15));
                        
                            dialogStage.setScene(new Scene(vbox));
                            dialogStage.show();
                        }
                        else if(event.toString().contains("Crust")){
                            System.out.println("You clicked Crust");
                            //used print statement for debugging, will open dialog box
                        }
                        else if(event.toString().contains("Sauce")){
                            System.out.println("You clicked Sauce");
                        }
                        else if(event.toString().contains("Cheese")){
                            System.out.println("You clicked Cheese");
                        }
                        else if(event.toString().contains("Meat")){
                            System.out.println("You clicked Meat");
                        }
                        else if(event.toString().contains("Veggies")){
                            System.out.println("You clicked Veggies");

                        }
                        
                    }

                });
                
                
                btn.setPrefSize(100, 100);
                flowPane.getChildren().add(btn);
            
            }
            //tab.setContent(flowPane);
            grid.add(flowPane, 0, 4);
            GridPane.setColumnSpan(flowPane,2);
            
            primaryStage.setScene(scene);
            primaryStage.show();
            }
            
            
            tabPane.getTabs().add(tab);
        
        }

        //create new order tab

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

   
}
