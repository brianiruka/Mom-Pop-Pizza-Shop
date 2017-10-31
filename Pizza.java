import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextArea;


public class Pizza extends Application {
    //class containing main method
    TButtons topBtns = new TButtons();
    //object for topping buttons class
    public static String deliveryOption ="Delivery\n\n";
    Label delivOp = new Label(deliveryOption);
    //delivery/pickup toggle option label
    Button completeOrder = new Button("Complete Order");
    Button backBtn = new Button("Back");
    //new scene upon button click
    String[] tabNames = {"Create New Order","Create New Customer","Modify Customer Info","Menu Look-Up"};
    //array holding each tab name
    Group root = new Group();
    //needed to create scene
    Scene scene1 = new Scene(root, 680, 600, Color.WHITE);
    //creates/holds initial scene, including tabs
    TabPane tabPane = new TabPane();
    BorderPane borderPane = new BorderPane();
    Grid newGridP = new Grid();
    Pane newPane = new Pane();
    FlowPane paymentGrid = new FlowPane();
    ToggleGroup paymentType = new ToggleGroup();
    RadioButton cardBtn = new RadioButton("Card");
    RadioButton cashBtn = new RadioButton("Cash");
    RadioButton checkBtn = new RadioButton("Check");
    Boolean complete = false;
    TextArea commentBox = new TextArea();
    Label navLabel = new Label("Navigation Notes:");
    
    
    
    
    

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mom & Pop Pizza Shop");
        //window title
 
        for (int i = 0; i < 4; i++) {
            //loop that creates four tabs and names tabs through tabNames array
            Tab tab = new Tab();
            tab.setText(tabNames[i]);
            
            if( i == 0){
                //populates the 0th tab
                newGridP.createGrid1();
                newGridP.innerGrid();
                //uses grid class method to populate 0th tab
                tab.setContent(newGridP.grid);

                completeOrder.setOnAction((event) -> {
                    if (complete == true){
                        System.out.println("Confirmation Page, print receipt");
                    }
                    else{
                    newGridP.grid.getChildren().remove(newGridP.flowPane);
                    newGridP.grid.getChildren().removeAll(navLabel,commentBox);
                    completeOrder.setText("Finalize");
                     //goes to review/payment scene when button clicked
                     paymentGrid.setPadding(new Insets(10, 10, 10, 10));
                     paymentGrid.setVgap(10);
                     paymentGrid.setHgap(10);
                     paymentGrid.setPrefWrapLength(210);
                     newGridP.grid.add(paymentGrid,0,2,2,2);

                     cardBtn.setToggleGroup(paymentType);
                     cardBtn.setSelected(true);
                     cashBtn.setToggleGroup(paymentType);
                     checkBtn.setToggleGroup(paymentType);
                     paymentGrid.getChildren().addAll(cardBtn,cashBtn,checkBtn);

                     checkBtn.setPrefSize(100, 50);
                     newGridP.grid.add(newGridP.cardScreen(),0,4);
                     GridPane.setColumnSpan(newGridP.cardScreen(),2);
                     GridPane.setRowSpan(newGridP.cardScreen(),5);
                    newGridP.grid.add(backBtn,1,7);
                    GridPane.setHalignment(backBtn, HPos.RIGHT);
                    GridPane.setValignment(backBtn, VPos.BOTTOM);
                    
                    }
                    complete=true;
                });

                cardBtn.setOnAction(e ->{
                    newGridP.grid.add(newGridP.cardScreen(),0,4);
                    GridPane.setColumnSpan(newGridP.cardScreen(),2);
                });            
                
                cashBtn.setOnAction(e ->{
                    newGridP.grid.getChildren().remove(newGridP.cardScreen());
                });

                checkBtn.setOnAction(e ->{
                    newGridP.grid.getChildren().remove(newGridP.cardScreen());
                });

                backBtn.setOnAction((event) -> {
                    newGridP.grid.getChildren().add(newGridP.flowPane);
                    newGridP.grid.getChildren().remove(backBtn);   
                    completeOrder.setText("Complete Order");
                    newGridP.grid.getChildren().remove(newGridP.cardScreen());
                    paymentGrid.getChildren().removeAll(cardBtn,cashBtn,checkBtn);
                    newGridP.grid.getChildren().remove(paymentGrid);
                    newGridP.grid.getChildren().addAll(navLabel,commentBox);
                    
                         //goes to review/payment scene when button clicked
                         complete = false;
                    });
    

                topBtns.createButtons(newGridP);
                //tbuttons method that creates topping buttons/indivial windows, adds buttons to flowpane
                ToggleGroup orderType = new ToggleGroup();
                RadioButton deliveryBtn = new RadioButton("Delivery");
                deliveryBtn.setToggleGroup(orderType);
                deliveryBtn.setSelected(true);
                RadioButton pickupBtn = new RadioButton("Pickup");
                pickupBtn.setToggleGroup(orderType);
                newGridP.flowPane.getChildren().addAll(deliveryBtn,pickupBtn);
                pickupBtn.setPrefSize(100, 50);
                
                //delivery and pickup radio buttons

                RadioButton chk = (RadioButton)orderType.getSelectedToggle();
                //cast to radio button in order to gettext()
                deliveryOption = chk.getText();
                //string of delivery option selected


                newGridP.grid.add(newGridP.flowPane, 0, 4);
                //adds flowpane to grid
                GridPane.setColumnSpan(newGridP.flowPane,2);
                GridPane.setRowSpan(newGridP.flowPane,10);
                
                
                VBox receiptPanel = new VBox();
                //creates receipt widget on stage right
                receiptPanel.getChildren().addAll(new Label("Order Summary:\n\n"),delivOp,topBtns.rSize,topBtns.rCrust,topBtns.rCheese,topBtns.rMeat,topBtns.rSauce,topBtns.rVeggies);
                //adds labels to receipt panel vbox
                newGridP.grid.add(receiptPanel,2,2);
                GridPane.setRowSpan(receiptPanel,11);
                GridPane.setColumnSpan(receiptPanel,5);
                //newGridP.grid.setGridLinesVisible(true);


                newGridP.gridInGrid.add(topBtns.pizzaCost,0,13);
                newGridP.gridInGrid.add(topBtns.extraMeat,0,37);
                newGridP.gridInGrid.add(topBtns.extraMeat2,0,41);
                newGridP.gridInGrid.add(topBtns.extraMeat3,0,45);
                newGridP.gridInGrid.add(topBtns.extraVeggies,0,60);
                newGridP.gridInGrid.add(topBtns.extraVeggies2,0,60);
                newGridP.gridInGrid.add(topBtns.extraVeggies3,0,70);
                newGridP.gridInGrid.add(topBtns.totalLabel,0,70);

                


                deliveryBtn.setOnAction(e ->{
                    delivOp.setText("Delivery\n\n");
                    newGridP.grid.getChildren().addAll(navLabel,commentBox);
                    
                });            
                
                pickupBtn.setOnAction(e ->{
                    delivOp.setText("Pickup\n\n");
                    newGridP.grid.getChildren().removeAll(navLabel,commentBox);
                    
                });
                //action for when either radiobutton is selected
                    
                newGridP.grid.add(completeOrder,2,7);   
                GridPane.setColumnSpan(completeOrder,3);
                GridPane.setHalignment(completeOrder, HPos.LEFT);
                GridPane.setValignment(completeOrder, VPos.BOTTOM);
                
                }
            tabPane.getTabs().add(tab);
            }
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene1.heightProperty());
        borderPane.prefWidthProperty().bind(scene1.widthProperty());
        newGridP.grid.add(commentBox,1,5);
        newGridP.grid.add(navLabel,0,5);        
        commentBox.setMaxHeight(80);
        commentBox.setMaxWidth(250);     
        GridPane.setColumnSpan(commentBox,1);
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        GridPane.setValignment(commentBox, VPos.BOTTOM);
        GridPane.setHalignment(commentBox, HPos.CENTER);
        GridPane.setValignment(navLabel, VPos.BOTTOM);
        GridPane.setHalignment(navLabel, HPos.RIGHT);
        
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

   
}