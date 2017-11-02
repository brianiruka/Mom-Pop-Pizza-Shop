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
    public static boolean isDelivery = true;
    
    TButtons topBtns = new TButtons();
    Grid newGrid = new Grid();
    FlowPane paymentGrid = new FlowPane();
    Label delivOp = new Label(deliveryOption);
    Label navLabel = new Label("Navigation \nInformation:");
    Button completeOrder = new Button("Complete Order");
    Button backBtn = new Button("Back");
    TextArea commentBox = new TextArea();
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
        
        topBtns.createButtons(newGrid);
        //tbuttons method that creates topping buttons/indivial windows, adds buttons to flowpane
                newGrid.getGrid1().add(newGrid.flowPane, 0, 4);
        //adds flowpane to grid
        GridPane.setColumnSpan(newGrid.flowPane,2);
        GridPane.setRowSpan(newGrid.flowPane,10);
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

        VBox receiptPanel = new VBox();
        //creates receipt widget on stage right
        receiptPanel.getChildren().addAll(new Label("Order Summary:\n\n"),delivOp,topBtns.rSize,topBtns.rCrust,topBtns.rCheese,topBtns.rMeat,topBtns.rSauce,topBtns.rVeggies);
        //adds labels to receipt panel vbox
        newGrid.getGrid1().add(receiptPanel,2,2);
        GridPane.setRowSpan(receiptPanel,11);
        GridPane.setColumnSpan(receiptPanel,5);
        //newGrid.getGrid1().setGridLinesVisible(true);
    
        commentBox.setMaxHeight(70);
        commentBox.setMaxWidth(250);     
        GridPane.setColumnSpan(commentBox,1);
        GridPane.setValignment(commentBox, VPos.BOTTOM);
        GridPane.setHalignment(commentBox, HPos.LEFT);
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

        newGrid.getGrid1().add(completeOrder,2,7);   
        GridPane.setColumnSpan(completeOrder,3);
        GridPane.setHalignment(completeOrder, HPos.LEFT);
        GridPane.setValignment(completeOrder, VPos.BOTTOM);
        newGrid.getGrid1().add(commentBox,1,5);
        newGrid.getGrid1().add(navLabel,0,5);
        newGrid.cardScreen();
        newGrid.getCSOP();

        completeOrder.setOnAction((event) -> {
            if (complete == true){
                System.out.println("This will reset back to main page, print receipt");
            }
            else{
                newGrid.getGrid1().getChildren().remove(newGrid.flowPane);

                if (isDelivery == true){
                    GridPane.setColumnIndex(navLabel, 0);
                    GridPane.setColumnIndex(commentBox, 1);
                    GridPane.setRowIndex(navLabel, 5);
                    GridPane.setRowIndex(commentBox, 5);
                
                    GridPane.setValignment(commentBox, VPos.BOTTOM);
                    GridPane.setHalignment(commentBox, HPos.LEFT);
                    GridPane.setValignment(navLabel, VPos.BOTTOM);
                    GridPane.setHalignment(navLabel, HPos.RIGHT);
                    newGrid.getCardFlow().getChildren().clear();                    
                    newGrid.getGrid1().add(newGrid.cardScreen(),0,4);
                    GridPane.setColumnSpan(newGrid.getCardFlow(),2);
                    GridPane.setRowSpan(newGrid.getCardFlow(),5);
                }
                else {
                    newGrid.getCardFlow().getChildren().clear();
                    newGrid.getGrid1().add(newGrid.cardScreenOnPickup(),0,4);
                    GridPane.setColumnSpan(newGrid.getCSOP(),2);
                    GridPane.setRowSpan(newGrid.getCSOP(),5);
                    backBtn.toFront(); 
                }
                completeOrder.setText("Finalize");
                //goes to review/payment scene when button clicked
                paymentGrid.setPadding(new Insets(10, 10, 10, 10));
                paymentGrid.setVgap(10);
                paymentGrid.setHgap(10);
                paymentGrid.setPrefWrapLength(210);
                //newGrid.getGrid1().setGridLinesVisible(true);
                newGrid.getGrid1().add(paymentGrid,0,2,2,2);
                cardBtn.setToggleGroup(paymentType);
                cardBtn.setSelected(true);
                cashBtn.setToggleGroup(paymentType);
                checkBtn.setToggleGroup(paymentType);
                paymentGrid.getChildren().addAll(cardBtn,cashBtn,checkBtn);
                checkBtn.setPrefSize(100, 25);

                newGrid.getGrid1().add(backBtn,1,7);
                GridPane.setHalignment(backBtn, HPos.RIGHT);
                GridPane.setValignment(backBtn, VPos.BOTTOM);
                commentBox.toFront();
                //moves comment box to front because it gets blocked when grid added
            }
            complete=true;
        });

        cardBtn.setOnAction(e ->{
            newGrid.getGrid1().getChildren().remove(newGrid.getCardFlow());                                                            
            newGrid.getCardFlow().getChildren().clear();     
            if (isDelivery == true){
                newGrid.getGrid1().add(newGrid.cardScreen(),0,4);
                GridPane.setColumnSpan(newGrid.getCardFlow(),2);
                GridPane.setRowSpan(newGrid.getCardFlow(),5);
            }
            else{
                newGrid.getGrid1().add(newGrid.cardScreenOnPickup(),0,4);
                GridPane.setColumnSpan(newGrid.getCSOP(),2);
                GridPane.setRowSpan(newGrid.getCSOP(),5);
            }
                backBtn.toFront();
                commentBox.toFront();
                
            
        });            
        
        cashBtn.setOnAction(e ->{
            newGrid.getGrid1().getChildren().remove(newGrid.getCardFlow());                                                            
            newGrid.getCardFlow().getChildren().clear();     
            if (isDelivery == true){
                newGrid.getGrid1().add(newGrid.deliveryNotWithCard(),0,4);
                GridPane.setColumnSpan(newGrid.getCardFlow(),2);
                GridPane.setRowSpan(newGrid.getCardFlow(),5);
            }
            else{
                newGrid.getGrid1().add(newGrid.notCardOnPickup(),0,4);
                GridPane.setColumnSpan(newGrid.getCardFlow(),2);
                GridPane.setRowSpan(newGrid.getCardFlow(),5);
            }
                backBtn.toFront();
                commentBox.toFront();
                
        });

        checkBtn.setOnAction(e ->{
            newGrid.getGrid1().getChildren().remove(newGrid.getCardFlow());                                                            
            newGrid.getCardFlow().getChildren().clear();     
            if (isDelivery == true){
                newGrid.getGrid1().add(newGrid.deliveryNotWithCard(),0,4);
                GridPane.setColumnSpan(newGrid.getCardFlow(),2);
                GridPane.setRowSpan(newGrid.getCardFlow(),5);
            }
            else{
                newGrid.getGrid1().add(newGrid.notCardOnPickup(),0,4);
                GridPane.setColumnSpan(newGrid.getNCOP(),2);
                GridPane.setRowSpan(newGrid.getNCOP(),5);
            }
                backBtn.toFront();
                commentBox.toFront();
                
        });

        backBtn.setOnAction((event) -> {
            newGrid.getGrid1().getChildren().add(newGrid.flowPane);
            newGrid.getGrid1().getChildren().remove(backBtn);   
            completeOrder.setText("Complete Order");
            newGrid.getGrid1().getChildren().remove(newGrid.getCardFlow());
            paymentGrid.getChildren().removeAll(cardBtn,cashBtn,checkBtn);
            newGrid.getGrid1().getChildren().remove(paymentGrid);

     
            commentBox.setMaxHeight(70);
            commentBox.setMaxWidth(250);     
            GridPane.setColumnSpan(commentBox,1);
            GridPane.setValignment(commentBox, VPos.BOTTOM);
            GridPane.setHalignment(commentBox, HPos.LEFT);
            GridPane.setValignment(navLabel, VPos.BOTTOM);
            GridPane.setHalignment(navLabel, HPos.RIGHT);
            commentBox.toFront();
            
                //goes to review/payment scene when button clicked
                complete = false;
            });

        deliveryBtn.setOnAction(e ->{
            delivOp.setText("Delivery\n\n");
            newGrid.getGrid1().getChildren().addAll(navLabel,commentBox);
            isDelivery = true;
        });            
        
        pickupBtn.setOnAction(e ->{
            delivOp.setText("Pickup\n\n");
            newGrid.getGrid1().getChildren().removeAll(navLabel,commentBox);
            isDelivery = false;
        });
        //action for when each radiobutton is selected
            

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