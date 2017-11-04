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
import javafx.scene.text.Font;



public class Tabs {

    public static boolean complete = false;
    public static boolean isDelivery = true;
    
    TButtons topBtns = new TButtons();
    Grid newGrid = new Grid();
    FlowPane paymentGrid = new FlowPane();
    Label navLabel = new Label("Navigation \nInformation:");
    Button completeOrder = new Button("Complete Order");
    Button backBtn = new Button("Back");
    TextArea commentBox = new TextArea();
    ToggleGroup paymentType = new ToggleGroup();
    RadioButton cardBtn = new RadioButton("Card");
    RadioButton cashBtn = new RadioButton("Cash");
    RadioButton checkBtn = new RadioButton("Check");
    Receipt newReceipt = new Receipt();
    String pTypes = "Card";

    public GridPane createTab1(){
        Tab tab = new Tab();
        tab.setText("Create Order");
        newGrid.createGrid1();
        newGrid.innerGrid();
        //uses grid class method to populate 0th tab
        tab.setContent(newGrid.getGrid1());
        
        topBtns.createButtons(newGrid);

        RadioButton rb1 = (RadioButton)paymentType.getSelectedToggle();
        //cast to radio button in order to gettext()
        

        //tbuttons method that creates topping buttons/indivial windows, adds buttons to flowpane
                newGrid.getGrid1().add(newGrid.flowPane, 0, 3);
        //adds flowpane to grid
        GridPane.setColumnSpan(newGrid.flowPane,2);
        GridPane.setRowSpan(newGrid.flowPane,10);

        //delivery and pickup radio buttons


        //string of delivery option selected

        VBox receiptPanel = new VBox();
        Label orderLabel = new Label("Order Summary:\n\n");
        orderLabel.setFont(new Font(20));

        //creates receipt widget on stage right
        receiptPanel.getChildren().addAll(orderLabel,topBtns.delivOp,topBtns.rSize,topBtns.rCrust,topBtns.rCheese,topBtns.rMeat,topBtns.rSauce,topBtns.rVeggies,topBtns.rDrink);
        //adds labels to receipt panel vbox
        newGrid.getGrid1().add(receiptPanel,2,2);
        GridPane.setRowSpan(receiptPanel,15);
        GridPane.setColumnSpan(receiptPanel,3);
        //newGrid.getGrid1().setGridLinesVisible(true);
        newGrid.getGrid1().add(topBtns.totalLabel,2,7);
        GridPane.setHalignment(topBtns.totalLabel, HPos.RIGHT);
    
        commentBox.setMaxHeight(70);
        commentBox.setMaxWidth(250);     
        GridPane.setColumnSpan(commentBox,1);
        GridPane.setValignment(commentBox, VPos.BOTTOM);
        GridPane.setHalignment(commentBox, HPos.LEFT);
        GridPane.setValignment(navLabel, VPos.BOTTOM);
        GridPane.setHalignment(navLabel, HPos.LEFT);


        newGrid.getGrid1().add(completeOrder,1,7);   
        GridPane.setColumnSpan(completeOrder,1);
        GridPane.setHalignment(completeOrder, HPos.RIGHT);
        GridPane.setValignment(completeOrder, VPos.TOP);
        newGrid.getGrid1().add(commentBox,1,6);
        newGrid.getGrid1().add(navLabel,0,6);
        newGrid.cardScreen();
        newGrid.getCSOP();


        completeOrder.setOnAction((event) -> {
            if (complete == true){
                newReceipt.printReceipt(topBtns.delivOp,topBtns.rSize,topBtns.rCrust,topBtns.rCheese,topBtns.rMeat,topBtns.rSauce,topBtns.rVeggies,topBtns.rDrink,topBtns.runningTotal,pTypes);
            }
            else{
                newGrid.getGrid1().getChildren().remove(newGrid.flowPane);

                if (isDelivery == true){
                    GridPane.setColumnIndex(navLabel, 0);
                    GridPane.setColumnIndex(commentBox, 1);
                    GridPane.setRowIndex(navLabel, 6);
                    GridPane.setRowIndex(commentBox, 6);
                
                    GridPane.setValignment(commentBox, VPos.BOTTOM);
                    GridPane.setHalignment(commentBox, HPos.LEFT);
                    GridPane.setValignment(navLabel, VPos.BOTTOM);
                    GridPane.setHalignment(navLabel, HPos.LEFT);
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
                paymentGrid.setVgap(20);
                paymentGrid.setHgap(10);
                paymentGrid.setPrefWrapLength(210);
                //newGrid.getGrid1().setGridLinesVisible(true);
                newGrid.getGrid1().add(paymentGrid,0,2,2,3);
                cardBtn.setToggleGroup(paymentType);
                cardBtn.setSelected(true);
                cashBtn.setToggleGroup(paymentType);
                checkBtn.setToggleGroup(paymentType);
                paymentGrid.getChildren().addAll(cardBtn,cashBtn,checkBtn);
                checkBtn.setPrefSize(100, 25);

                newGrid.getGrid1().add(backBtn,0,7);
                GridPane.setHalignment(backBtn, HPos.RIGHT);
                GridPane.setValignment(backBtn, VPos.TOP);
                commentBox.toFront();
                completeOrder.toFront();
                
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
            pTypes = "Card";
            
                backBtn.toFront();
                commentBox.toFront();
                completeOrder.toFront();
                
                
            
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
            pTypes = "Cash";
                backBtn.toFront();
                commentBox.toFront();
                completeOrder.toFront();
                
                
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
                pTypes = "Check";
                backBtn.toFront();
                commentBox.toFront();
                completeOrder.toFront();
                
                
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
            GridPane.setHalignment(navLabel, HPos.LEFT);
            commentBox.toFront();
            completeOrder.toFront();
            
            
                //goes to review/payment scene when button clicked
                complete = false;
            });

            topBtns.btn.setOnAction((event) -> {
                if(topBtns.isDelivery == false){
                    topBtns.delivOp.setText("Order for: " + "Delivery\r\n"); 
                    topBtns.btn.setText("Delivery");  
                    commentBox.setDisable(false);
                    topBtns.isDelivery = true;
                    isDelivery = true;
                                               
                    
                }
                else{
                    topBtns.delivOp.setText("Order for: " + "Pick-up\r\n");  
                    topBtns.btn.setText("Pick-up");  
                    commentBox.setDisable(true);
                    topBtns.isDelivery = false;
                    isDelivery = false;
                                              
                    
                    
                }
            });
            

        //action for when each radiobutton is selected


        return newGrid.getGrid1();


    }
    

}