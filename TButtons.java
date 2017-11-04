
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
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;



public class TButtons {
    public static int pizzaAmt = 0;
    public static int toppingCounter = 0; 
    public static int toppingCounterV = 0;
    public static double sizeTotal = 0;     
    public static double meatTotal = 0;        
    public static double crustTotal = 0;
    public static double cheeseTotal = 0;      
    public static double drinkSizeCost = 0;      
    public static double runningTotal = 0;     
    public static String meatString ="Meat     ($0.50 each)\r\n     ";
    public static String veggieString ="Veggies\r\n     ";
    public static String cheese ="";    
    public static Boolean isDelivery = true;
    Label rSize = new Label("Size\r\n     -");
    Label rCrust = new Label("Crust\r\n     -");
    Label rCheese = new Label("Cheese\r\n     -");
    Label rMeat = new Label(meatString +"-");
    Label rSauce = new Label("Sauce\r\n     -");
    Label rVeggies = new Label(veggieString +"-");
    Label rDrink = new Label("Drink\r\n     -");
    Label pizzaCost = new Label("");
    Label extraMeat = new Label("");
    Label extraMeat2 = new Label("");
    Label extraMeat3 = new Label("");
    Label extraVeggies = new Label("");
    Label extraVeggies2 = new Label("");
    Label extraVeggies3 = new Label("");
    Label totalLabel = new Label("");
    public static String deliveryOption ="Order for: Delivery\r\n";    
    Label delivOp = new Label(deliveryOption);
    CheckBox extraCheese = new CheckBox("Extra Cheese");

    
      
    Button btn = new Button();
    String[] buttonNames = {"Size","Crust","Cheese","Meat","Sauce","Veggies", "Drinks","Delivery"};
    //array of topping button names
    Grid newGridT = new Grid();
   // Pizza newPizza = new Pizza();
   RadioButton chk = new RadioButton();
    String size = "";
    
    public Grid createButtons(Grid buttonGrid)  {
        
        for (int j = 0; j < 8; j++) {
            btn = new Button(buttonNames[j]);
            if (j ==3){
            buttonGrid.flowPane.getChildren().get(j-1).setDisable(true);
            }
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
                            if (cheeseTotal !=0){
                            cheeseTotal = 1.00;     
                            }                       
                            break;
                            case "Medium" :
                            sizeCost = 7.99;
                            if (cheeseTotal !=0){
                            cheeseTotal = 1.25;     
                            }                       
                            break;
                            case "Large" :
                            sizeCost = 9.99;
                            if (cheeseTotal !=0){
                            cheeseTotal = 1.50;
                            }
                            break;
                            default :
                         }
                        //newGridT.gridInGrid.add(pizzaCost,0,13);
                        if(slice.isSelected() == true){
                            sizeTotal = ((sizeCost/8) * pizzaAmt);
                            GridPane.setRowIndex(pizzaCost,13);
                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal + drinkSizeCost;
                            rSize.setText("Size\r\n     +" +  pizzaAmt + " x "+size+" Slice(s)" + String.format("     $%-10.2f",(sizeCost/8) * pizzaAmt));
                            totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            dialogStage.close();
                        }
                        else{                        
                            sizeTotal = (sizeCost * pizzaAmt);
                            GridPane.setRowIndex(pizzaCost,13);
                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal + drinkSizeCost;
                            rSize.setText("Size\r\n     +" +  pizzaAmt + " x "+size+" Pizza(s)" + String.format("     $%-10.2f", (sizeCost * pizzaAmt)));
                            totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            dialogStage.close();
                            }
                            if (extraCheese.isSelected() == true && sizeTotal != 0){
                                rCheese.setText("Cheese\r\n     +"+cheese+ "\r\n         (+"+ String.format("$%-3.2f", cheeseTotal)+" extra cheese)");          
                            }
                            buttonGrid.flowPane.getChildren().get(2).setDisable(false);
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
                        RadioButton stuffedCrust = new RadioButton("Stuffed Crust\r\n(+$1.00 extra)");
                        stuffedCrust.setToggleGroup(crusts);
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                              
                            stuffedCrust.setText("Stuffed Crust\r\n         (+$1.00 extra)");
                            RadioButton chk = (RadioButton)crusts.getSelectedToggle();
                            //cast to radio button in order to gettext()
                            String crust = chk.getText();
                            rCrust.setText("Crust\r\n     +"+crust);
                            crustTotal = 0;                            
                            if (crust.contains("Stuffed")== true){
                              crustTotal = 1;  
                            }
                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal + drinkSizeCost;                            
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
                            rSauce.setText("Sauce\r\n     +"+sauce);
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
                            cheese = chk.getText();
                            rCheese.setText("Cheese\r\n     +"+cheese);

                            cheeseTotal = 0;
                            if(extraCheese.isSelected() == true && sizeTotal != 0){
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
                                runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal + drinkSizeCost;
                                rCheese.setText("Cheese\r\n     +"+cheese+ "\r\n         (+"+ String.format("$%-3.2f", cheeseTotal)+" extra cheese)");          
                                totalLabel.setText(String.format("$%-10.2f", runningTotal));
                            }
                            else{                        
                                rCheese.setText("Cheese\r\n     +"+cheese);
                                cheeseTotal = 0;                                
                                runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal + drinkSizeCost;
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
                            rMeat.setText("Meat\r\n     -");                            
                            toppingCounter = 0;   

                            if (pepperoni.isSelected()){
                                meatString = meatString + "\r\n     +Pepperoni";
                                rMeat.setText(meatString);
                                toppingCounter++;
                            }
                            if (ham.isSelected()){
                                meatString = meatString + "\n     +Ham";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (sausage.isSelected()){
                                meatString = meatString + "\r\n     +Sausage";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (gChicken.isSelected()){
                                meatString = meatString + "\r\n     +Grilled Chicken";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (salami.isSelected()){
                                meatString = meatString + "\r\n     +Salami";
                                rMeat.setText(meatString);
                                toppingCounter++;
                                
                            }
                            if (beef.isSelected()){
                                meatString = meatString + "\r\n     +Beef";
                                rMeat.setText(meatString);
                                toppingCounter++;                                
                            }

                            

                            meatTotal = (.5 * (toppingCounter));

                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal + drinkSizeCost;                            
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
                            rVeggies.setText("Veggies\r\n     -");                            
                            if (blackOlives.isSelected()){
                                veggieString = veggieString + "\r\n     +Black Olives";
                                rVeggies.setText(veggieString);
                            }
                            if (greenPeppers.isSelected()){
                                veggieString = veggieString + "\r\n     +Green Bell Peppers";
                                    rVeggies.setText(veggieString);
                            }
                            if (mushrooms.isSelected()){
                                veggieString = veggieString + "\r\n     +Mushrooms";
                                    rVeggies.setText(veggieString);
                            }
                            if (pineapple.isSelected()){
                                veggieString = veggieString + "\r\n     +Pineapple";
                                    rVeggies.setText(veggieString);
                                    
                            }
                            if (cherryPeppers.isSelected()){
                                veggieString = veggieString + "\r\n     +Cherry Peppers";
                                    rVeggies.setText(veggieString);
                            }
                            if (onions.isSelected()){
                                veggieString = veggieString + "\r\n     +Onions";
                                    rVeggies.setText(veggieString);
                            }
                            if (tomato.isSelected()){
                                veggieString = veggieString + "\r\n     +Tomato";
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
                    else if(event.toString().contains("Drink")){
                        Stage drinkStage = new Stage();
                        ToggleGroup drinks = new ToggleGroup();
                        ToggleGroup drinkSize = new ToggleGroup();
                        RadioButton coke = new RadioButton("Coke");
                        coke.setToggleGroup(drinks);
                        coke.setSelected(true);
                        RadioButton sprite = new RadioButton("Sprite");
                        sprite.setToggleGroup(drinks);
                        RadioButton dietCoke = new RadioButton("Diet Coke");
                        dietCoke.setToggleGroup(drinks);
                        RadioButton fanta = new RadioButton("Fanta");
                        fanta.setToggleGroup(drinks);
                        RadioButton drPepper = new RadioButton("Dr. Pepper");
                        drPepper.setToggleGroup(drinks);
                        RadioButton dietDrPepper = new RadioButton("Diet Dr. Pepper");
                        dietDrPepper.setToggleGroup(drinks);
                        RadioButton lemonade = new RadioButton("Minute Maid Lemonade");
                        lemonade.setToggleGroup(drinks);
                        RadioButton noDrink = new RadioButton("None");
                        noDrink.setToggleGroup(drinks);
                        Label drinkSizeLabel = new Label("Size:");
                        Button okButton = new Button("ok");    
                        RadioButton twentyOz = new RadioButton("20 Oz");
                        twentyOz.setToggleGroup(drinkSize);
                        twentyOz.setSelected(true);
                        RadioButton twoLiters = new RadioButton("2 Liters");
                        twoLiters.setToggleGroup(drinkSize);  
                        
                        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                twentyOz.setDisable(false);
                                twoLiters.setDisable(false);
                            }
                        };
                        
                        coke.setOnAction(handler);
                        sprite.setOnAction(handler);
                        dietCoke.setOnAction(handler);
                        fanta.setOnAction(handler);             
                        drPepper.setOnAction(handler);                
                        dietDrPepper.setOnAction(handler);    
                        lemonade.setOnAction(handler);
                  
                        noDrink.setOnAction((e) -> {
                            rDrink.setText("Drink\r\n     -");
                            twentyOz.setDisable(true);
                            twoLiters.setDisable(true);
                        });
                        okButton.setOnAction(e ->{
                            rDrink.setText("Drink\r\n     -");                            
                            if (coke.isSelected()){
                                rDrink.setText("Drink\r\n     +Coke");
                            }
                            if (sprite.isSelected()){
                                rDrink.setText("Drink\r\n     +Sprite");
                            }
                            if (dietCoke.isSelected()){
                                rDrink.setText("Drink\r\n     +Diet Coke");
                            }
                            if (fanta.isSelected()){
                                rDrink.setText("Drink\r\n     +Fanta");
                                    
                            }
                            if (drPepper.isSelected()){
                                rDrink.setText("Drink\r\n     +Dr. Pepper");
                            }
                            if (dietDrPepper.isSelected()){
                                rDrink.setText("Drink\r\n     +Diet Dr. Pepper");
                            }
                            if (lemonade.isSelected()){
                                rDrink.setText("Drink\r\n     +Minute Maid Lemonade");
                            } 

                            RadioButton chk2 = (RadioButton)drinkSize.getSelectedToggle();
                            //cast to radio button in order to gettext()
                            String drinkSizes = chk2.getText();

                            
                            switch(drinkSizes) {
                                case "20 Oz" :
                                drinkSizeCost = .99;
                                break;
                                case "2 Liters" :
                                drinkSizeCost = 2.49;
                                break;
                                default :
                             }

                            if (noDrink.isSelected()){
                                drinkSizeCost = 0;
                            }else
                            {                       
                            rDrink.setText(rDrink.getText() + "\r\n          +" + drinkSizes + " ($" + drinkSizeCost + ")"  );
                            }
                            runningTotal = sizeTotal + meatTotal + cheeseTotal + crustTotal + drinkSizeCost;                            
                            totalLabel.setText(String.format("$%-10.2f", runningTotal));

                            drinkStage.close();
                            });
                        VBox vbox = new VBox(coke,dietCoke,sprite,fanta,drPepper,dietDrPepper,lemonade,noDrink,drinkSizeLabel, twentyOz, twoLiters,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(10);                                                                                                
                        drinkStage.setScene(new Scene(vbox));
                        drinkStage.show();
                    }


                    
                }

            });
            btn.setPrefSize(100, 100);
            buttonGrid.flowPane.getChildren().add(btn);
            

        }//end topping buttons
    return buttonGrid;
    }
    
}

