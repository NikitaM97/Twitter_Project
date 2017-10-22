import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by nikitamokhov on 31/01/2017.
 */
public class commodities extends Generic implements Industry {
    private ArrayList<String> accounts=new ArrayList<>();
    static Scanner input=new Scanner(System.in);
    private LinkedList<String> com_terms=new LinkedList<>();
    commodities (){
        com_terms.addAll(Arrays.asList("OPEC","rise","fall","currency","emerging","sugar","gold","silver","mining","drilling","ban","deal","markets","index"));
        accounts.addAll(Arrays.asList("CommodityHQ","ETCommodities","ArgusMedia","EIAGov","UpStreamOnline","ftcommodities","ReutersCommods","BNCommodities","EIU_Commodities","CommoditiesNow","commodityonline","littlewern","CraigKarmin"));

    }
    public void viewSearch(){
        for (int i=0;i<com_terms.size();i++){
            System.out.print(com_terms.get(i)+" : ");
        }
    }
    public ArrayList<String> getAccount(){
        return accounts;
    }
    public LinkedList getTerms(){
        return com_terms;
    }
    public void removeWords() {
        for (int i = 0; i < com_terms.size(); i++) {
            System.out.print(com_terms.get(i) + " : ");
        }
        while (true){
            System.out.println("\n"+"Enter a word you would like to remove. Enter 123Done if finished removing.");
            String user=input.next();
            if (user.equals("123Done"))
                break;
            else {
                for (int i = 0; i < com_terms.size(); i++) {
                    if (user.equals(com_terms.get(i)))
                        com_terms.remove(i);
                }
            }
        }
    }
    public void addWords(){
        for (int i = 0; i < com_terms.size(); i++) {
            System.out.print(com_terms.get(i) + " : ");
        }
        while (true){
            System.out.println("\n"+"Enter a word you would like to add. Enter 123Done if finished removing.");
            String user=input.next();
            if (user.equals("123Done"))
                break;
            else {
                com_terms.add(user);

            }
        }
    }
}

