/**
 * Created by nikitamokhov on 30/01/2017.
 */
import twitter4j.*;
import java.util.Scanner;
public class user {
    user() {};
    private static Scanner input = new Scanner(System.in);
    Spider scroll=new Spider();
    //gives the users the options to select what they wish to do with the tweets they retrieved and the corresponding object commands
    public void options(Generic gen) throws TwitterException {
        while (true) {
            System.out.println("\n"+"What would you like to do (enter corresponding number):" + "\n" + "1: See words used with the highest frequency and associated tweets" + "\n" + "2: View all words and tweets associated with them" + "\n" + "3: See which words you are searching for" + "\n" + "4: Add words to your search parameter" + "\n" + "5: Remove words from your search parameter."+"\n"+"6: Exit"+"\n");
            int user = input.nextInt();
            scroll.Timelinesearch(gen);
            if (user==1)
                scroll.Highestfrequency();
            if (user==2)
                scroll.viewAll();
            if (user==3)
                gen.viewSearch();
            if (user==4)
                gen.addWords();
            if (user==5)
                gen.removeWords();
            if (user==6)
                break;
        }
    }
}
