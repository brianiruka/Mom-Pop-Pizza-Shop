import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextArea;



public class Tabs {

    public static String deliveryOption ="Delivery\n\n";
    public static boolean complete = false;
    //class containing main method
    TButtons topBtns = new TButtons();
    Grid newGrid = new Grid();
    FlowPane paymentGrid = new FlowPane();
    Label delivOp = new Label(deliveryOption);
    Label navLabel = new Label("Navigation Notes:");
    Button completeOrder = new Button("Complete Order");
    Button backBtn = new Button("Back");
    TextArea commentBox = new TextArea();
    //new scene upon button click
    ToggleGroup paymentType = new ToggleGroup();
    RadioButton cardBtn = new RadioButton("Card");
    RadioButton cashBtn = new RadioButton("Cash");
    RadioButton checkBtn = new RadioButton("Check");
    
    
    
    public Tab createTab1(){
        Tab tab = new Tab();
        tab.setText("Create Order");
        newGrid.createGrid1();
        newGrid.innerGrid();
        //uses grid class method to populate 0th tab
        tab.setContent(newGrid.getGrid1());
        completeOrder.setOnAction((event) -> {
            if (complete == true){
                System.out.println("Confirmation Page, print receipt");
            }
            else{
                newGrid.getGrid1().getChildren().remove(newGrid.flowPane);
                newGrid.getGrid1().getChildren().removeAll(navLabel,commentBox);
                completeOrder.setText("Finalize");
                //goes to review/payment scene when button clicked
                paymentGrid.setPadding(new Insets(10, 10, 10, 10));
                paymentGrid.setVgap(10);
                paymentGrid.setHgap(10);
                paymentGrid.setPrefWrapLength(210);
                newGrid.getGrid1().add(paymentGrid,0,2,2,2);

                cardBtn.setToggleGroup(paymentType);
                cardBtn.setSelected(true);
                cashBtn.setToggleGroup(paymentType);
                checkBtn.setToggleGroup(paymentType);
                paymentGrid.getChildren().addAll(cardBtn,cashBtn,checkBtn);
                checkBtn.setPrefSize(100, 50);
                newGrid.getGrid1().add(newGrid.cardScreen(),0,4);
                GridPane.setColumnSpan(newGrid.cardScreen(),2);
                GridPane.setRowSpan(newGrid.cardScreen(),5);
                newGrid.getGrid1().add(backBtn,1,7);
                GridPane.setHalignment(backBtn, HPos.RIGHT);
                GridPane.setValignment(backBtn, VPos.BOTTOM);
            
            }
            complete=true;
        });

        cardBtn.setOnAction(e ->{
            newGrid.getGrid1().add(newGrid.cardScreen(),0,4);
            GridPane.setColumnSpan(newGrid.cardScreen(),2);
        });            
        
        cashBtn.setOnAction(e ->{
            newGrid.getGrid1().getChildren().remove(newGrid.cardScreen());
        });

        checkBtn.setOnAction(e ->{
            newGrid.getGrid1().getChildren().remove(newGrid.cardScreen());
        });

        backBtn.setOnAction((event) -> {
            newGrid.getGrid1().getChildren().add(newGrid.flowPane);
            newGrid.getGrid1().getChildren().remove(backBtn);   
            completeOrder.setText("Complete Order");
            newGrid.getGrid1().getChildren().remove(newGrid.cardScreen());
            paymentGrid.getChildren().removeAll(cardBtn,cashBtn,checkBtn);
            newGrid.getGrid1().getChildren().remove(paymentGrid);
            
            
            newGrid.getGrid1().add(commentBox,1,5);
            newGrid.getGrid1().add(navLabel,0,5);        
            commentBox.setMaxHeight(80);
            commentBox.setMaxWidth(250);     
            GridPane.setColumnSpan(commentBox,1);
            GridPane.setValignment(commentBox, VPos.BOTTOM);
            GridPane.setHalignment(commentBox, HPos.CENTER);
            GridPane.setValignment(navLabel, VPos.BOTTOM);
            GridPane.setHalignment(navLabel, HPos.RIGHT);
                //goes to review/payment scene when button clicked
                complete = false;
            });


        topBtns.createButtons(newGrid);
        //tbuttons method that creates topping buttons/indivial windows, adds buttons to flowpane
        ToggleGroup orderType = new ToggleGroup();
        RadioButton deliveryBtn = new RadioButton("Delivery");
        deliveryBtn.setToggleGroup(orderType);
        deliveryBtn.setSelected(true);
        RadioButton pickupBtn = new RadioButton("Pickup");
        pickupBtn.setToggleGroup(orderType);
        newGrid.flowPane.getChildren().addAll(deliveryBtn,pickupBtn);
        pickupBtn.setPrefSize(100, 50);
        
        //delivery and pickup radio buttons

        RadioButton chk = (RadioButton)orderType.getSelectedToggle();
        //cast to radio button in order to gettext()
        deliveryOption = chk.getText();
        //string of delivery option selected


        newGrid.getGrid1().add(newGrid.flowPane, 0, 4);
        //adds flowpane to grid
        GridPane.setColumnSpan(newGrid.flowPane,2);
        GridPane.setRowSpan(newGrid.flowPane,10);
        
        
        VBox receiptPanel = new VBox();
        //creates receipt widget on stage right
        receiptPanel.getChildren().addAll(new Label("Order Summary:\n\n"),delivOp,topBtns.rSize,topBtns.rCrust,topBtns.rCheese,topBtns.rMeat,topBtns.rSauce,topBtns.rVeggies);
        //adds labels to receipt panel vbox
        newGrid.getGrid1().add(receiptPanel,2,2);
        GridPane.setRowSpan(receiptPanel,11);
        GridPane.setColumnSpan(receiptPanel,5);
        //newGrid.getGrid1().setGridLinesVisible(true);
        newGrid.getGrid1().add(commentBox,1,5);
        newGrid.getGrid1().add(navLabel,0,5);        
        commentBox.setMaxHeight(80);
        commentBox.setMaxWidth(250);     
        GridPane.setColumnSpan(commentBox,1);
        GridPane.setValignment(commentBox, VPos.BOTTOM);
        GridPane.setHalignment(commentBox, HPos.CENTER);
        GridPane.setValignment(navLabel, VPos.BOTTOM);
        GridPane.setHalignment(navLabel, HPos.RIGHT);

        newGrid.gridInGrid.add(topBtns.pizzaCost,0,13);
        newGrid.gridInGrid.add(topBtns.extraMeat,0,37);
        newGrid.gridInGrid.add(topBtns.extraMeat2,0,41);
        newGrid.gridInGrid.add(topBtns.extraMeat3,0,45);
        newGrid.gridInGrid.add(topBtns.extraVeggies,0,60);
        newGrid.gridInGrid.add(topBtns.extraVeggies2,0,60);
        newGrid.gridInGrid.add(topBtns.extraVeggies3,0,70);
        newGrid.gridInGrid.add(topBtns.totalLabel,0,70);

        


        deliveryBtn.setOnAction(e ->{
            delivOp.setText("Delivery\n\n");
            newGrid.getGrid1().getChildren().addAll(navLabel,commentBox);
            
        });            
        
        pickupBtn.setOnAction(e ->{
            delivOp.setText("Pickup\n\n");
            newGrid.getGrid1().getChildren().removeAll(navLabel,commentBox);
            
        });
        //action for when either radiobutton is selected
            
        newGrid.getGrid1().add(completeOrder,2,7);   
        GridPane.setColumnSpan(completeOrder,3);
        GridPane.setHalignment(completeOrder, HPos.LEFT);
        GridPane.setValignment(completeOrder, VPos.BOTTOM);
        return tab;


    }
       
    public Tab createTab2(){
         Tab tab2 = new Tab();
        tab2.setText("Create/Modify Customer");


        return tab2;
    }
        
    public Tab createTab3(){
        Tab tab3 = new Tab();
        tab3.setText("Menu Look-Up");
        return tab3;

    }
}