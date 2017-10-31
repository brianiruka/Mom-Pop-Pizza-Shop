
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



public class TButtons {
    public static int pizzaAmt = 0;
    public static int toppingCounter = 0; 
    public static int toppingCounterV = 0;
    public static int sizeTotal = 0;     
    public static double meatTotal = 0;     
    public static double veggieTotal = 0;     
    public static double runningTotal = 0;     
    public static String meatString ="Meat\n     ";
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
    
    
    public Grid createButtons(Grid buttonGrid)  {

        for (int j = 0; j < 6; j++) {
            btn = new Button(buttonNames[j]);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(event.toString().contains("Size")){
                        //new window if button pressed
                        Stage dialogStage = new Stage();
                        ToggleGroup sizes = new ToggleGroup();
                        RadioButton slice = new RadioButton("Slice");
                        slice.setText("Slice");
                        slice.setToggleGroup(sizes);
                        slice.setSelected(true);
                        RadioButton smallSize = new RadioButton("Small");
                        smallSize.setToggleGroup(sizes);
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
                        RadioButton chk = (RadioButton)sizes.getSelectedToggle();
                        //cast to radio button in order to gettext()
                        String size = chk.getText();
                        pizzaAmt = Integer.parseInt(quantity.getText());
                        rSize.setText("Size\n     +" +  pizzaAmt + " x "+size+" Pizza(s)");

                        int sizeCost = 0;
                        switch(size) {
                            case "Slice" :
                               sizeCost = 1;
                               break;
                            case "Small" :
                            sizeCost = 7;
                            break;
                            case "Medium" :
                            sizeCost = 9;
                            break;
                            case "Large" :
                            sizeCost = 11;
                            break;
                            default :
                               System.out.println("Select Size");
                         }
                        //newGridT.gridInGrid.add(pizzaCost,0,13);
                        pizzaCost.setText("+$"+ Integer.toString(sizeCost * pizzaAmt) +".00");
                        sizeTotal = (sizeCost * pizzaAmt);
                        GridPane.setRowIndex(pizzaCost,13);

                        runningTotal = sizeTotal + meatTotal + veggieTotal;
                        totalLabel.setText(String.format("$%10.2f", runningTotal));
                        GridPane.setRowIndex(totalLabel,70);
                        dialogStage.close();
                        });

                        VBox vbox = new VBox(slice,smallSize,mediumSize,largeSize,qField, quantity,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        dialogStage.setScene(new Scene(vbox));
                        dialogStage.show();
                    }
                    else if(event.toString().contains("Crust")){
                        Stage crustStage = new Stage();
                        ToggleGroup crusts = new ToggleGroup();
                        RadioButton thinCrust = new RadioButton("Thin Crust");
                        thinCrust.setToggleGroup(crusts);
                        thinCrust.setSelected(true);
                        RadioButton deepDish = new RadioButton("Deep Dish");
                        deepDish.setToggleGroup(crusts);
                        RadioButton nyStyle = new RadioButton("NY Style");
                        nyStyle.setToggleGroup(crusts);
                        RadioButton glutenFree = new RadioButton("Gluten Free");
                        glutenFree.setToggleGroup(crusts);
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                            RadioButton chk = (RadioButton)crusts.getSelectedToggle();
                            //cast to radio button in order to gettext()
                            String crust = chk.getText();
                            rCrust.setText("Crust\n     +"+crust+" Crust");
                            crustStage.close();
                            });
                        VBox vbox = new VBox(thinCrust,deepDish,nyStyle,glutenFree,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
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
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                            RadioButton chk = (RadioButton)cheeses.getSelectedToggle();
                            //cast to radio button in order to gettext()
                            String cheese = chk.getText();
                            rCheese.setText("Cheese\n     +"+cheese+" Cheese");
                            cheeseStage.close();
                            });
                        VBox vbox = new VBox(mozzarella,cheddar,shreddedParm,noCheese,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        
                        cheeseStage.setScene(new Scene(vbox));
                        cheeseStage.show();
                    }
                    else if(event.toString().contains("Meat")){
                        toppingCounter = 0;
                        Stage meatStage = new Stage();
                        CheckBox pepperoni = new CheckBox("Pepperoni");
                        CheckBox ham = new CheckBox("Ham");
                        CheckBox sausage = new CheckBox("Sausage");
                        CheckBox chicken = new CheckBox("Chicken");
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                            String meatString = "Meat     ";   
                                                   
                            if (pepperoni.isSelected()){
                                meatString = meatString + "\n     +Pepperoni";
                                toppingCounter++;
                                rMeat.setText(meatString);
                            }
                            if (ham.isSelected()){
                                meatString = meatString + "\n     +Ham";
                                toppingCounter++;
                                rMeat.setText(meatString);
                            }
                            if (sausage.isSelected()){
                                meatString = meatString + "\n     +Sausage";
                                toppingCounter++;
                                rMeat.setText(meatString);
                            }
                            if (chicken.isSelected()){
                                meatString = meatString + "\n     +Chicken";
                                toppingCounter++;
                                rMeat.setText(meatString);
                            }

                            if ((chicken.isSelected()&&pepperoni.isSelected()&&sausage.isSelected()&&ham.isSelected()) == false && toppingCounter==0){
                                rMeat.setText("Meat\n     -");
                                toppingCounter=0;
                                extraMeat.setText("");
                                
                            }

                            extraMeat.setText("");
                            extraMeat2.setText("");
                            extraMeat3.setText("");
                            if (toppingCounter>1){
                                extraMeat.setText("+$0.50");
                                GridPane.setRowIndex(extraMeat,37);
                            }
                            if (toppingCounter>2){
                                extraMeat2.setText("+$0.50");
                                GridPane.setRowIndex(extraMeat2,40);
                            }
                            if (toppingCounter>3){
                                extraMeat3.setText("+$0.50");
                                GridPane.setRowIndex(extraMeat3,43);
                            }
                            

                            if (toppingCounterV>1 ){
                                extraVeggies.setText("+$0.50");
                                GridPane.setRowIndex(extraVeggies,50 + ((toppingCounter-1) * 3));
                            }
                            if (toppingCounterV>2 ){
                                extraVeggies2.setText("+$0.50");
                                GridPane.setRowIndex(extraVeggies2,54+ ((toppingCounter-1) * 3));
                            }
                            if (toppingCounterV>3 ){
                                extraVeggies3.setText("+$0.50");
                                GridPane.setRowIndex(extraVeggies3,57+ ((toppingCounter-1) * 3));
                            }
                            if (toppingCounter <= 1){
                                GridPane.setRowIndex(extraVeggies,50);
                                GridPane.setRowIndex(extraVeggies2,54);
                                GridPane.setRowIndex(extraVeggies3,57);
                            }

                            if (toppingCounter >1){
                            meatTotal = (.5 * (toppingCounter-1));
                            }
                            else {
                            meatTotal = 0;
                            }

                            runningTotal = sizeTotal + meatTotal + veggieTotal;
                            totalLabel.setText(String.format("$%10.2f", runningTotal));
                            meatStage.close();

                        });
                        VBox vbox = new VBox(pepperoni,ham,sausage,chicken,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
                        meatStage.setScene(new Scene(vbox));
                        meatStage.show();
                    }
                    else if(event.toString().contains("Veggies")){
                        toppingCounterV = 0;

                        Stage veggieStage = new Stage();
                        CheckBox blackOlives = new CheckBox("Black Olives");
                        CheckBox greenPeppers = new CheckBox("Green Peppers");
                        CheckBox mushrooms = new CheckBox("Mushrooms");
                        CheckBox pineapple = new CheckBox("Pineapple");
                        Button okButton = new Button("ok");
                        okButton.setOnAction(e ->{
                            String veggieString = "Veggies     ";                  
                            if (blackOlives.isSelected()){
                                veggieString = veggieString + "\n     +Black Olives";
                                toppingCounterV++;
                                
                                    rVeggies.setText(veggieString);
                            }
                            if (greenPeppers.isSelected()){
                                veggieString = veggieString + "\n     +Green Peppers";
                                toppingCounterV++;
                                    rVeggies.setText(veggieString);
                            }
                            if (mushrooms.isSelected()){
                                veggieString = veggieString + "\n     +Mushrooms";
                                toppingCounterV++;
                                    rVeggies.setText(veggieString);
                            }
                            if (pineapple.isSelected()){
                                veggieString = veggieString + "\n     +Pineapple";
                                toppingCounterV++;
                                    rVeggies.setText(veggieString);
                                    
                            }
                            if ((pineapple.isSelected()&&mushrooms.isSelected()&&greenPeppers.isSelected()&&blackOlives.isSelected()) == false && toppingCounterV==0){
                                rVeggies.setText("Veggies\n     -");
                                toppingCounterV=0;
                                extraVeggies.setText("");
                                
                                
                            }
                            extraVeggies.setText("");
                            extraVeggies2.setText("");
                            extraVeggies3.setText("");
                            
                            if (toppingCounterV>1 ){
                                extraVeggies.setText("+$0.50");
                                GridPane.setRowIndex(extraVeggies,50 + ((toppingCounter-1) * 3));
                            }
                            if (toppingCounterV>2 ){
                                extraVeggies2.setText("+$0.50");
                                GridPane.setRowIndex(extraVeggies2,54+ ((toppingCounter-1) * 3));
                            }
                            if (toppingCounterV>3 ){
                                extraVeggies3.setText("+$0.50");
                                GridPane.setRowIndex(extraVeggies3,57+ ((toppingCounter-1) * 3));
                            }
                            if (toppingCounter <= 1){
                                GridPane.setRowIndex(extraVeggies,50);
                                GridPane.setRowIndex(extraVeggies2,54);
                                GridPane.setRowIndex(extraVeggies3,57);
                            }

                            if (toppingCounterV > 1){
                                veggieTotal = (.5 * (toppingCounterV-1));
                            }
                            else {
                                veggieTotal = 0;
                            }
                            
                            runningTotal = sizeTotal + meatTotal + veggieTotal;
                            totalLabel.setText(String.format("$%10.2f", runningTotal));

                            
                            veggieStage.close();
                            });
                        VBox vbox = new VBox(blackOlives,greenPeppers,mushrooms,pineapple,okButton);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        vbox.setPadding(new Insets(15));
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

}

