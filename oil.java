

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by nikitamokhov on 28/01/2017.
 */
public class oil extends Generic implements Industry{
    private ArrayList <String> accounts=new ArrayList<>();
    static Scanner input=new Scanner(System.in);
    private LinkedList<String> oil_terms=new LinkedList<>();
    oil (){
        oil_terms.addAll(Arrays.asList("pipeline","drilling","reserve","oil fields", "arctic reserve", "corruption", "leak","geothermal", "embargo", " clean energy"," exports", "growth","new","OPEC"));
        accounts.addAll(Arrays.asList("CrudeOilPrices","OGJOnline","EU_Growth","Bloomberg","OilandGasRR","WorldOil","Shell_US","BP_America","petrobrasglobal","PlattsRigData","OilandGasInvest","exxonmobil","iraqoilreport","iraqoilforum","IraqOil_Gas","Chevron","crudegusher","BloombergNRG","OilGasCanada","Can_Oilsands","ImperialOil","AlbertaOilMag","TransCanada","encana","Engbridge","cnnbrk","SkyNewsBreak","BBCWorld","PlattsOil","UpstreamOnline","EIAGov",""));

    }
    public void viewSearch(){
        for (int i=0;i<oil_terms.size();i++){
            System.out.print(oil_terms.get(i)+" : ");
        }
    }
    public ArrayList<String> getAccount(){
        return accounts;
    }
    public LinkedList getTerms(){
        return oil_terms;
    }
    public void removeWords() {
        for (int i = 0; i < oil_terms.size(); i++) {
            System.out.print(oil_terms.get(i) + " : ");
        }
        while (true){
            System.out.println("\n"+"Enter a word you would like to remove. Enter 123Done if finished removing.");
            String user=input.next();
            if (user.equals("123Done"))
                break;
            else {
                for (int i = 0; i < oil_terms.size(); i++) {
                    if (user.equals(oil_terms.get(i)))
                        oil_terms.remove(i);
                }
            }
        }
    }
    public void addWords(){
        for (int i = 0; i < oil_terms.size(); i++) {
            System.out.print(oil_terms.get(i) + " : ");
        }
        while (true){
            System.out.println("\n"+"Enter a word you would like to add. Enter 123Done if finished removing.");
            String user=input.next();
            if (user.equals("123Done"))
                break;
            else {
                oil_terms.add(user);

                }
            }
        }
    }

