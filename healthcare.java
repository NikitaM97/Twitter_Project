
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by nikitamokhov on 28/01/2017.
 */
import java.util.LinkedList;
public class healthcare extends Generic implements Industry{
    private ArrayList<String> accounts=new ArrayList<>();
    static Scanner input=new Scanner(System.in);
    private LinkedList<String> health=new LinkedList<>();
    healthcare (){
        health.addAll(Arrays.asList("testing","cure","surgery","research", "deal","expiremental","expirements", "procedure","cancer ", "study ","coverage", "researchers ", "growth"+"new"));
        accounts.addAll(Arrays.asList("PartnersNews","HealthCareGov","modrnhealthcr","GEHealthcare","PhilipsHealthNA","SiemensHealth","bmsnews","cnnbrk","SkyNewsBreak","BBCWorld","DeloitteHealth","HealthITNews","forbeshealth","healthcarebiz","JM_Healthcare","EINHealthcare","KHNews","WSJhealth","AHCJ","cnnhealth","bbchealth","NPRHealth","USNewsHealth"));
    }
    public void viewSearch(){
        for (int i=0;i<health.size();i++){
            System.out.print(health.get(i)+" - ");
        }
    }
    public ArrayList getAccount(){
        return accounts;
    }
    public LinkedList getTerms(){
        return health;
    }
    public void removeWords() {
        for (int i = 0; i < health.size(); i++) {
            System.out.print(health.get(i) + " : ");
        }
        while (true){
            System.out.println("\n"+"Enter a word you would like to remove. Enter 123Done if finished removing.");
            String user=input.next();
            if (user.equals("123Done"))
                break;
            else {
                for (int i = 0; i < health.size(); i++) {
                    if (user.equals(health.get(i)))
                        health.remove(i);
                }
            }
        }
    }
    public void addWords(){
        for (int i = 0; i < health.size(); i++) {
            System.out.print(health.get(i) + " : ");
        }
        while (true){
            System.out.println("\n"+"Enter a word you would like to add. Enter 123Done if finished removing.");
            String user=input.next();
            if (user.equals("123Done"))
                break;
            else {
                health.add(user);

            }
        }
    }
}
