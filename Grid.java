
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.ComboBox;
import javafx.geometry.HPos;
import javafx.geometry.Pos;


public class Grid {

    GridPane grid= new GridPane();    
    FlowPane flowPane = new FlowPane();
    GridPane gridInGrid = new GridPane();
    Label label1 = new Label("Customer Phone #");
    TextField textField = new TextField ();
    Button button = new Button("Lookup");
    Label label2 = new Label("Please enter Customer ID...");
    GridPane cardFlow = new GridPane();
    FlowPane cashFlow = new FlowPane();
    FlowPane checkFlow = new FlowPane();
    Label ccLabel = new Label("Credit Card:");
    Label nameLabel = new Label("Name:");
    TextField nameTF = new TextField ();         
    Label ccAddress1 = new Label("Address (line 1):");
    TextField ccAddr1TF= new TextField ();      
    Label ccAddress2 = new Label("Address (line 2):");
    TextField ccAddr2TF= new TextField (); 
    Label ccCity = new Label("City:");
    TextField ccCityTF= new TextField (); 
    Label ccState = new Label("State:");
    TextField ccStateTF= new TextField (); 
    Label ccZip = new Label("Zipcode:");
    TextField ccZipTF= new TextField();
    ComboBox cbCC = new ComboBox();

    


    
    public GridPane createGrid1(){
    //method that creates initial gridpane
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(100);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(250);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(200);
        grid.getColumnConstraints().addAll(col1,col2,col3);
        //sets column dimensions
        grid.setHgap(10);
        grid.setVgap(20);

        button.setOnAction((event) -> {
        label2.setText("[Customer info will be displayed here from database]");
        
        //when lookup button clicked
        label2.setTextFill(Color.web("#0076a3"));

        });
        grid.add(label1, 0, 0, 1, 2);
        grid.add(textField, 1, 0, 1, 1);
        grid.add(button, 2, 0, 1, 1);
        grid.add(label2, 0, 1, 2, 2);
        //adds labels,etc to grid at specific coordinates
        grid.setPadding(new Insets(50, 0, 50, 50)); //(top/right/bottom/left)

        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setPrefWrapLength(210);

        return grid;
        
    }
    public GridPane getGrid1(){
        return grid;
    }


public void innerGrid(){

        for (int j = 0; j < 70; j++) {
            RowConstraints row = new RowConstraints(5);
            gridInGrid.getRowConstraints().add(row);
        }

        grid.add(gridInGrid,4,3); 
        GridPane.setRowSpan(gridInGrid,3);
        
        //newGrid.createGrid1().InGrid.add(topBtns.pizzaCost,0,13);

        //gridInGrid.setGridLinesVisible(true);
}
    public GridPane cardScreen(){

        //sets column dimensions
        cardFlow.setHgap(10);
        cardFlow.setVgap(10);

        nameTF.setMaxWidth(200);       
        ccAddr1TF.setMaxWidth(275);       
        ccAddr2TF.setPrefWidth(275);       
        ccCityTF.setMaxWidth(100);       
        ccStateTF.setMaxWidth(45);       
        ccZipTF.setMaxWidth(78);   
        cbCC.getItems().clear();
        cbCC.getItems().addAll("American Express","Discover","Master Card","Visa");
 
        cardFlow.add(ccLabel,0,0);
        cardFlow.add(cbCC,1,0);
        cardFlow.add(nameLabel,0,1);
        cardFlow.add(nameTF,1,1);
        cardFlow.add(ccAddress1,0,2);
        cardFlow.add(ccAddr1TF,1,2);
        cardFlow.add(ccAddress2,0,3);
        cardFlow.add(ccAddr2TF,1,3);
        cardFlow.add(ccCity,0,4);
        cardFlow.add(ccCityTF,1,4);
        cardFlow.add(ccState,0,5);
        cardFlow.add(ccStateTF,1,5);
        cardFlow.add(ccZip,0,6);
        cardFlow.add(ccZipTF,1,6);
        //cardFlow.add(ccLabel,0,0);
        //named cardFlow because it was originally a flowpane, but worked better as a grid
        return cardFlow;
        }

        public GridPane getCardFlow(){
            return cardFlow;
        }

        public GridPane cardScreenOnPickup(){
    
            //sets column dimensions
            cardFlow.setHgap(10);
            cardFlow.setVgap(10);
    
            cardFlow.getChildren().clear();
            cardFlow.add(ccLabel,0,0);
            cardFlow.add(cbCC,1,0);
            cardFlow.add(nameLabel,0,1);
            cardFlow.add(nameTF,1,1);
            //cardFlow.add(ccLabel,0,0);
            //named cardFlow because it was originally a flowpane, but worked better as a grid
            return cardFlow;
            }

        public GridPane getCSOP(){
            return cardFlow;
        }
        public GridPane notCardOnPickup(){
            
            //sets column dimensions
            cardFlow.setHgap(10);
            cardFlow.setVgap(10);
    
            cardFlow.getChildren().clear();
            cardFlow.add(nameLabel,0,1);
            cardFlow.add(nameTF,1,1);
            //cardFlow.add(ccLabel,0,0);
            //named cardFlow because it was originally a flowpane, but worked better as a grid
            return cardFlow;
            }

        public GridPane getNCOP(){
            return cardFlow;
        }
    public GridPane deliveryNotWithCard(){


        nameTF.setMaxWidth(200);       
        ccAddr1TF.setMaxWidth(275);       
        ccAddr2TF.setPrefWidth(275);       
        ccCityTF.setMaxWidth(100);       
        ccStateTF.setMaxWidth(45);       
        ccZipTF.setMaxWidth(78);   
 
        cardFlow.add(nameLabel,0,1);
        cardFlow.add(nameTF,1,1);
        cardFlow.add(ccAddress1,0,2);
        cardFlow.add(ccAddr1TF,1,2);
        cardFlow.add(ccAddress2,0,3);
        cardFlow.add(ccAddr2TF,1,3);
        cardFlow.add(ccCity,0,4);
        cardFlow.add(ccCityTF,1,4);
        cardFlow.add(ccState,0,5);
        cardFlow.add(ccStateTF,1,5);
        cardFlow.add(ccZip,0,6);
        cardFlow.add(ccZipTF,1,6);
        return cardFlow;
        }


}