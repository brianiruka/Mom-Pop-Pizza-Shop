import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import javafx.scene.control.Label;


public class Receipt {
    public void printReceipt(Label pdelivOp, Label psize, Label pCrust, Label pCheese, Label pMeat, Label pSauce, Label pVeggies, Label pDrink, double total, String pType) {
        try {
            //Whatever the file path is.
            File file = new File("Pizza Shop Receipt.txt");
            FileOutputStream is = new FileOutputStream(file);
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(is));
    w.write(pdelivOp.getText());
    w.newLine();
    w.write(psize.getText());
    w.newLine();
    w.write(pCrust.getText());
    w.newLine();
    w.write(pCheese.getText());
    w.newLine();
    
    w.write(pMeat.getText());
    w.newLine();
    
    w.write(pSauce.getText());
    w.newLine();
    
    w.write(pVeggies.getText());
    w.newLine();
    

    w.newLine();
    w.write(pDrink.getText());
    w.newLine();
    w.write("--------------------------------");
    w.newLine();
    w.write("Total:" + "                           " + (String.format("$%-10.2f", total)));
    w.newLine();
    w.newLine();
    w.newLine();
    w.write("Payment Type" + "                     " + pType);
    w.newLine();
    if (pType == "Card"){
        w.newLine();
        w.write("Signature:");
        w.newLine();
        w.newLine();
        w.write("X______________________________");
    }



    w.close();
    java.awt.Desktop.getDesktop().edit(file);
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }

    }

}