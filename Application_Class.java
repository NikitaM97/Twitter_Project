/**
 * Created by nikitamokhov on 28/01/2017.
 */
import twitter4j.*;
import java.util.Scanner;
public class Application_Class {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws TwitterException {
        Generic Noil=new oil();
        Generic Nhealthcare=new healthcare();
        Generic NCrypto=new Crypto();
        user usermenu=new user();
        Generic Cmod=new commodities();
        while (true) {

            System.out.println("\n" + "What industry/markets would you like to examine (Enter corresponding numbers):" + "\n" + "1: Oil" + "\n" + "2: Health care" + "\n" + "3: Cryptocurrency" + "\n" + "4: Commodities"+"\n"+"If you are finished enter 5");
            int user = input.nextInt();
            if (user==1){
                usermenu.options(Noil);
            }
            if (user==2){
                usermenu.options(Nhealthcare);
            }
            if (user==3){
                usermenu.options(NCrypto);
            }
            if (user==4)
                usermenu.options(Cmod);
            if (user==5){
                break;
            }
        }

    }
}
