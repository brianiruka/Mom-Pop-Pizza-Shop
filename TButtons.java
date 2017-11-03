
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import java.lang.Integer;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



public class TButtons {
    public static int pizzaAmt = 0;
    public static int toppingCounter = 0; 
    public static int toppingCounterV = 0;
    public static double sizeTotal = 0;     
    public static double meatTotal = 0;        
    public static double crustTotal = 0;
    public static double cheeseTotal = 0;        
    public static double runningTotal = 0;     
    public static String meatString ="Meat      ($0.50 each)\n     ";
    public static String veggieString ="Veggies\n     ";
    Label rSize = new Label("Size\n     -");
    Label rCrust = new Label("Crust\n     -");
    Label rCheese = new Label("Cheese\n     -");
    Label rMeat = new Label(meatString +"-");
    Label rSauce = new Label("Sauce\n     -");
    Label rVeggies = new Label(veggieString +"-");
    Label pizzaCost = new Label("");
    Label extraMeat = new Label("");
    Label extraMeat2 = new Label("");
    Label extraMeat3 = new Label("");
    Label extraVeggies = new Label("");
    Label extraVeggies2 = new Label("");
    Label extraVeggies3 = new Label("");
    Label totalLabel = new Label("");
    
      
    Button btn = new Button();
    String[] buttonNames = {"Size","Crust","Cheese","Meat","Sauce","Veggies"};
    //array of topping button names
    Grid newGridT = new Grid();
   // Pizza newPizza = new Pizza();
   RadioButton chk = new RadioButton();
    String size = "";
    
    public Grid createButtons(Grid buttonGrid)  {

        for (int j = 0; j < 6; j++) {
            btn = new Button(buttonNames[j]);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        totalLabel.setFont(new Font("Actor", 30));
                        totalLabel.setTextFill(Color.web("#006400"));
                    if(event.toString().contains("Size")){
                        //new window if button pressed
                        Stage dialogStage = new Stage();
                        ToggleGroup sizes = new ToggleGroup();
                        CheckBox slice = new CheckBox("Slice");
                        slice.setText("Slice");
                        RadioButton smallSize = new RadioButton("Small");
                        smallSize.setToggleGroup(sizes);
                        smallSize.setSelected(true);                        
                        RadioButton mediumSize = new RadioButton("Medium");
                        mediumSize.setToggleGroup(sizes);
                        RadioButton largeSize = new RadioButton("Large");
                        largeSize.setToggleGroup(sizes);
                        Label qField = new Label("Quantity:");
                        TextField quantity = new TextField("1");
                        quantity.setPrefColumnCount(10);
                        quantity.getText();
                        Button okButton = new Button("ok");
                        //ok button exits popup, saves choices
                        okButton.setOnAction(e ->{
                        chk = (RadioButton)sizes.getSelectedToggle();
                        //cast to radio button in order to gettext()
                        size = chk.getText();
                        
                        pizzaAmt = Integer.parseInt(quantity.getText());
                        //rSize.setText("Size\n     +" +  pizzaAmt + " x "+size+" Pizza(s)");

                        
                        double sizeCost = 0;
                        
                        switch(size) {
                            case "Small" :
                            sizeCost = 5.99;
                            break;
                            case "Medium" :
                            sizeCost = 7.99;
                            break;
                            case "Large" :
                            sizeCost = 9.99;
                            break;
                            default :
                         }
                        //newGridT.gridInGrid.add(pizzaCost,0,13);
                        if(slice.isSelected() == true){
                            sizeTotal = ((sizeCost/8) * pizzaAmt);
                            GridPane.setRowIndex(pizzaCost,13);
                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal;
                            rSize.setText("Size\n     +" +  pizzaAmt + " x "+size+" Slice(s)" + String.format("     $%-10.2f",(sizeCost/8) * pizzaAmt));
                            totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            dialogStage.close();
                        }
                        else{                        
                            sizeTotal = (sizeCost * pizzaAmt);
                            GridPane.setRowIndex(pizzaCost,13);
                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal;
                            rSize.setText("Size\n     +" +  pizzaAmt + " x "+size+" Pizza(s)" + String.format("     $%-10.2f", (sizeCost * pizzaAmt)));
                            totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            dialogStage.close();
                            }
                        

                        });

                        VBox vbox = new VBox(slice,smallSize,mediumSize,largeSize,qField, quantity,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(10);
                        dialogStage.setScene(new Scene(vbox));
                        dialogStage.show();
                    }
                    else if(event.toString().contains("Crust")){
                        Stage crustStage = new Stage();
                        ToggleGroup crusts = new ToggleGroup();
                        RadioButton panPizza = new RadioButton("Pan Pizza");
                        panPizza.setToggleGroup(crusts);
                        panPizza.setSelected(true);
                        RadioButton handTossed = new RadioButton("Hand Tossed");
                        handTossed.setToggleGroup(crusts);
                        RadioButton nyStyle = new RadioButton("New York Style");
                        nyStyle.setToggleGroup(crusts);
                        RadioButton thin = new RadioButton("Thin");
                        thin.setToggleGroup(crusts);
                        RadioButton stuffedCrust = new RadioButton("Stuffed Crust\n(+$1.00 extra)");
                        stuffedCrust.setToggleGroup(crusts);
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                              
                            stuffedCrust.setText("Stuffed Crust\n         (+$1.00 extra)");
                            RadioButton chk = (RadioButton)crusts.getSelectedToggle();
                            //cast to radio button in order to gettext()
                            String crust = chk.getText();
                            rCrust.setText("Crust\n     +"+crust);
                            crustTotal = 0;                            
                            if (crust.contains("Stuffed")== true){
                              crustTotal = 1;  
                            }
                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal;                            
                            totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            
                            crustStage.close();
                            });
                        VBox vbox = new VBox(panPizza,handTossed,nyStyle,thin,stuffedCrust,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(10);                                                
                        crustStage.setScene(new Scene(vbox));
                        crustStage.show();
                    }
                    else if(event.toString().contains("Sauce")){
                        Stage sauceStage = new Stage();
                        ToggleGroup sauces = new ToggleGroup();
                        RadioButton pizzaSauce = new RadioButton("Pizza Sauce");
                        pizzaSauce.setToggleGroup(sauces);
                        pizzaSauce.setSelected(true);
                        RadioButton bbqSauce = new RadioButton("BBQ Sauce");
                        bbqSauce.setToggleGroup(sauces);
                        RadioButton ranchSauce = new RadioButton("Ranch Sauce");
                        ranchSauce.setToggleGroup(sauces);
                        RadioButton noSauce = new RadioButton("None");
                        noSauce.setToggleGroup(sauces);
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                            RadioButton chk = (RadioButton)sauces.getSelectedToggle();
                            //cast to radio button in order to gettext()
                            String sauce = chk.getText();
                            rSauce.setText("Sauce\n     +"+sauce);
                            sauceStage.close();
                            });
                        VBox vbox = new VBox(pizzaSauce,bbqSauce,ranchSauce,noSauce,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(10);                        
                        sauceStage.setScene(new Scene(vbox));
                        sauceStage.show();
                    }
                    else if(event.toString().contains("Cheese")){
                        Stage cheeseStage = new Stage();
                        ToggleGroup cheeses = new ToggleGroup();
                        RadioButton mozzarella = new RadioButton("Mozzarella");
                        mozzarella.setToggleGroup(cheeses);
                        mozzarella.setSelected(true);
                        RadioButton cheddar = new RadioButton("Cheddar");
                        cheddar.setToggleGroup(cheeses);
                        RadioButton shreddedParm = new RadioButton("Shredded Parmesan");
                        shreddedParm.setToggleGroup(cheeses);
                        RadioButton noCheese = new RadioButton("None");
                        noCheese.setToggleGroup(cheeses);
                        CheckBox extraCheese = new CheckBox("Extra Cheese");
                        noCheese.setOnAction(e ->{
                            extraCheese.setSelected(false);
                            extraCheese.setDisable(true);                            
                        });   
                        mozzarella.setOnAction(e ->{
                            extraCheese.setDisable(false);                            
                        });   
                        cheddar.setOnAction(e ->{
                            extraCheese.setDisable(false);                            
                        });   
                        shreddedParm.setOnAction(e ->{
                            extraCheese.setDisable(false);                            
                        });   
                        
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                            RadioButton chk = (RadioButton)cheeses.getSelectedToggle();
                            //cast to radio button in order to gettext()
                            String cheese = chk.getText();
                            rCheese.setText("Cheese\n     +"+cheese);

                            cheeseTotal = 0;
                            if(extraCheese.isSelected() == true){
                                switch(size) {
                                    case "Small" :
                                    cheeseTotal = 1.00;
                                    break;
                                    case "Medium" :
                                    cheeseTotal = 1.25;
                                    break;
                                    case "Large" :
                                    cheeseTotal = 1.50;
                                    break;
                                    default :
                                       System.out.println(size);
                                 }                                
                                runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal;
                                rCheese.setText("Cheese\n     +"+cheese+ "\n         (+"+ String.format("$%-3.2f", cheeseTotal)+" extra)");          
                                totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            }
                            else{                        
                                rCheese.setText("Cheese\n     +"+cheese);
                                cheeseTotal = 0;                                
                                runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal;
                                totalLabel.setText(String.format("$%-10.2f", runningTotal));                                
                                }

                            cheeseStage.close();

                            });
                        VBox vbox = new VBox(mozzarella,cheddar,shreddedParm,noCheese,extraCheese,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(10);                                                
                        cheeseStage.setScene(new Scene(vbox));
                        cheeseStage.show();
                    }
                    else if(event.toString().contains("Meat")){
                        toppingCounter = 0;
                        Stage meatStage = new Stage();
                        CheckBox pepperoni = new CheckBox("Pepperoni");
                        CheckBox ham = new CheckBox("Ham");
                        CheckBox sausage = new CheckBox("Sausage");
                        CheckBox gChicken = new CheckBox("Grilled Chicken");
                        CheckBox salami = new CheckBox("Salami");
                        CheckBox beef = new CheckBox("Beef");
                        Button okButton = new Button("ok");

                        okButton.setOnAction(e ->{
                            String meatString = "Meat      ($0.50 each)";   
                            rMeat.setText("Meat\n     -");                            
                            toppingCounter = 0;   

                            if (pepperoni.isSelected()){
                                meatString = meatString + "\n     +Pepperoni";
                                rMeat.setText(meatString);
                                toppingCounter++;
                            }
                            if (ham.isSelected()){
                                meatString = meatString + "\n     +Ham";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (sausage.isSelected()){
                                meatString = meatString + "\n     +Sausage";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (gChicken.isSelected()){
                                meatString = meatString + "\n     +Grilled Chicken";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (salami.isSelected()){
                                meatString = meatString + "\n     +Salami";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (beef.isSelected()){
                                meatString = meatString + "\n     +Beef";
                                rMeat.setText(meatString);
                                toppingCounter++;                                
                            }

                            

                            meatTotal = (.5 * (toppingCounter));

                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal;                            
                            totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            meatStage.close();

                        });
                        VBox vbox = new VBox(pepperoni,ham,sausage,gChicken,salami,beef,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(10);                                                                        
                        meatStage.setScene(new Scene(vbox));
                        meatStage.show();
                    }
                    else if(event.toString().contains("Veggies")){
                        Stage veggieStage = new Stage();
                        CheckBox blackOlives = new CheckBox("Black Olives");
                        CheckBox greenPeppers = new CheckBox("Green Bell Peppers");
                        CheckBox mushrooms = new CheckBox("Mushrooms");
                        CheckBox pineapple = new CheckBox("Pineapple");
                        CheckBox cherryPeppers = new CheckBox("Cherry Peppers");
                        CheckBox onions = new CheckBox("Onions");
                        CheckBox tomato = new CheckBox("Tomato");
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                            String veggieString = "Veggies     ";
                            rVeggies.setText("Veggies\n     -");                            
                            if (blackOlives.isSelected()){
                                veggieString = veggieString + "\n     +Black Olives";
                                rVeggies.setText(veggieString);
                                System.out.println("black olives checked");
                            }
                            if (greenPeppers.isSelected()){
                                veggieString = veggieString + "\n     +Green Bell Peppers";
                                    rVeggies.setText(veggieString);
                            }
                            if (mushrooms.isSelected()){
                                veggieString = veggieString + "\n     +Mushrooms";
                                    rVeggies.setText(veggieString);
                            }
                            if (pineapple.isSelected()){
                                veggieString = veggieString + "\n     +Pineapple";
                                    rVeggies.setText(veggieString);
                                    
                            }
                            if (cherryPeppers.isSelected()){
                                veggieString = veggieString + "\n     +Cherry Peppers";
                                    rVeggies.setText(veggieString);
                            }
                            if (onions.isSelected()){
                                veggieString = veggieString + "\n     +Onions";
                                    rVeggies.setText(veggieString);
                            }
                            if (tomato.isSelected()){
                                veggieString = veggieString + "\n     +Tomato";
                                    rVeggies.setText(veggieString);
                                    
                            }
                                                     
                            veggieStage.close();
                            });
                        VBox vbox = new VBox(blackOlives,greenPeppers,mushrooms,pineapple,cherryPeppers,onions,tomato,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(10);                                                                                                
                        veggieStage.setScene(new Scene(vbox));
                        veggieStage.show();
                    }
        
                }

            });
            btn.setPrefSize(100, 100);
            buttonGrid.flowPane.getChildren().add(btn);
            
        }//end topping buttons
    return buttonGrid;
    }
    public void restoreTButtons(){

    }
}

