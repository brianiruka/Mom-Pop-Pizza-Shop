import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import javafx.scene.control.Label;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Receipt {
    public void printReceipt(Label pdelivOp, Label psize, Label pCrust, Label pCheese, Label pMeat, Label pSauce, Label pVeggies, Label pDrink, double total, String pType, String cName) {
        try {
            //Whatever the file path is.
            File file = new File("Pizza Shop Receipt.txt");
            FileOutputStream is = new FileOutputStream(file);
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(is));
            Date today = Calendar.getInstance().getTime();
            
                // (2) create a date "formatter" (the date format we want)
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy hh:mm a");
            
                // (3) create a new String using the date format we want
                String dateAndTime = formatter.format(today);
                
                // (4) this prints "Folder Name = 2009-09-06-08.23.23"

            

   
   
   
    w.write("                 ___    ");
    w.newLine();
    w.write("                 |  ~~--.");
    w.newLine();
    w.write("                 |%=@%%/");
    w.newLine();
    w.write("                 |o%%%/");
    w.newLine();
    w.write("              __ |%%o/");
    w.newLine();
    w.write("        _,--~~ | |(_/ ._    ");
    w.newLine();
    w.write("     ,/'  m%%%%| |o/ /  `\\.    ");
    w.newLine();
    w.write("    /' m%%o(_)%| |/ /o%%m `\\    ");
    w.newLine();
    w.write("  /' %%@=%o%%%o|   /(_)o%%% `\\    ");
    w.newLine();
    w.write(" /  %o%%%%%=@%%|  /%%o%%@=%%  \\'");
    w.newLine();
    w.write("|  (_)%(_)%%o%%| /%%%=@(_)%%%  |");
    w.newLine();
    w.write("| %%o%%%%o%%%(_|/%o%%o%%%%o%%% |");
    w.newLine();
    w.write("| %%o%(_)%%%%%o%(_)%%%o%%o%o%% |");
    w.newLine();
    w.write("|  (_)%%=@%(_)%o%o%%(_)%o(_)%  |");
    w.newLine();
    w.write(" \\ ~%%o%%%%%o%o%=@%%o%%@%%o%~ /    ");
    w.newLine();
    w.write("  \\. ~o%%(_)%%%o%(_)%%(_)o~ ,/");
    w.newLine();
    w.write("   \\_ ~o%=@%(_)%o%%(_)%~ _/");
    w.newLine();
    w.write("      `\\_~~o%%%o%%%%%~~_/'");
    w.newLine();
    w.write("         `--..____,,--'");
    w.newLine();
    w.newLine();
    w.newLine();
    w.write("      Mom & Pop Pizza Shop");
    w.newLine();
    w.newLine();
    w.write("        " + dateAndTime);
    w.newLine();
    w.newLine();    
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
    w.write("-------------------------------");
    w.newLine();
    w.write("Total:" + "                   " + (String.format("$%-10.2f", total)));
    w.newLine();
    w.newLine();
    w.newLine();
    w.write("Customer: " + cName);
    w.newLine();
    w.newLine();
    w.write("Payment Type" + "              " + pType);
    w.newLine();
    if (pType == "Card"){
        w.newLine();
        w.write("Signature:");
        w.newLine();
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