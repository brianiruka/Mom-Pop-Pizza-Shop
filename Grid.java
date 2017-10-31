
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
    


    
    public void createGrid1(){
    //method that creates initial gridpane
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        grid.getColumnConstraints().addAll(col1,col2,col3);
        //sets column dimensions
        grid.setHgap(10);
        grid.setVgap(10);


        button.setOnAction((event) -> {
        label2.setText("[Customer info will be displayed here from database]");
        //when lookup button clicked
        label2.setTextFill(Color.web("#0076a3"));

        });
        grid.add(label1, 0, 0, 1, 1);
        grid.add(textField, 1, 0, 1, 1);
        grid.add(button, 2, 0, 1, 1);
        grid.add(label2, 0, 1, 2, 2);
        //adds labels,etc to grid at specific coordinates
        grid.setPadding(new Insets(50, 50, 50, 50)); //(top/right/bottom/left)

        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setPrefWrapLength(210);


        
    }

    public void createGrid2(){
        

    }
public void innerGrid(){

        for (int j = 0; j < 70; j++) {
            RowConstraints row = new RowConstraints(5);
            gridInGrid.getRowConstraints().add(row);
        }

        grid.add(gridInGrid,4,3); 
        GridPane.setRowSpan(gridInGrid,3);
        
                        //newGridP.gridInGrid.add(topBtns.pizzaCost,0,13);

        //gridInGrid.setGridLinesVisible(true);
}
    public GridPane cardScreen(){

        //sets column dimensions
        cardFlow.setHgap(10);
        cardFlow.setVgap(10);

        Label ccLabel = new Label("Credit Card:");
        Label ccnLabel = new Label("Card Number:");
        TextField ccnTF = new TextField ();
        ccnTF.setMaxWidth(200);
        Label ccNameLabel = new Label("Name on Card:");
        TextField ccNameTF = new TextField ();         
        ccNameTF.setMaxWidth(250);       
        Label ccExpiration = new Label("Expires:");
        Label ccSecCode = new Label("Security Code:");
        TextField ccSecCodeTF = new TextField ();    
        ccSecCodeTF.setMaxWidth(50); 
        Label ccAddress1 = new Label("Address (line 1):");
        TextField ccAddr1TF= new TextField ();      
        ccAddr1TF.setMaxWidth(300);       
        Label ccAddress2 = new Label("Address (line 2):");
        TextField ccAddr2TF= new TextField (); 
        ccAddr2TF.setPrefWidth(300);       
        Label ccCity = new Label("City:");
        TextField ccCityTF= new TextField (); 
        ccCityTF.setMaxWidth(100);       
        Label ccState = new Label("State:");
        TextField ccStateTF= new TextField (); 
        ccStateTF.setMaxWidth(45);       
        Label ccZip = new Label("Zipcode:");
        TextField ccZipTF= new TextField (); 
        ccZipTF.setMaxWidth(78);   
        Button button = new Button("Lookup");

        ComboBox cbCC = new ComboBox();
        cbCC.getItems().addAll("American Express","Discover","Master Card","Visa");
        ComboBox cbExpMonth = new ComboBox();
        cbExpMonth.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December");
        ComboBox cbExpYear = new ComboBox();
        cbExpYear.getItems().addAll("2017","2018","2019","2020","2021","2022","2023","2024","2025");
        
        cardFlow.add(ccLabel,0,0);
        cardFlow.add(cbCC,1,0);
        cardFlow.add(ccnLabel,0,1);
        cardFlow.add(ccnTF,1,1);
        cardFlow.add(ccNameLabel,0,2);
        cardFlow.add(ccNameTF,1,2);
        cardFlow.add(ccExpiration,0,3);
        cardFlow.add(cbExpMonth,1,3);
        cardFlow.add(cbExpYear,1,3);
        GridPane.setHalignment(cbExpYear, HPos.CENTER);
        cardFlow.add(ccSecCode,0,4);
        cardFlow.add(ccSecCodeTF,1,4);
        cardFlow.add(ccAddress1,0,5);
        cardFlow.add(ccAddr1TF,1,5);
        cardFlow.add(ccAddress2,0,6);
        cardFlow.add(ccAddr2TF,1,6);
        cardFlow.add(ccCity,0,7);
        cardFlow.add(ccCityTF,1,7);
        cardFlow.add(ccState,0,8);
        cardFlow.add(ccStateTF,1,8);
        cardFlow.add(ccZip,0,9);
        cardFlow.add(ccZipTF,1,9);

        //cardFlow.add(ccLabel,0,0);


        return cardFlow;
        }
    public void cashScreen(){
    
        }
    public void checkScreen(){
        
        }

}