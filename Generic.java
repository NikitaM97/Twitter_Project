/**
 * Created by nikitamokhov on 30/01/2017.
 */
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

public class Generic implements Industry{
    private ArrayList <String> accounts=new ArrayList<>();
    static Scanner input=new Scanner(System.in);
    private LinkedList<String> terms=new LinkedList<>();
    Generic(){}

    public void viewSearch() {
    }
    public ArrayList getAccount(){
        return accounts;
    }
    public LinkedList getTerms(){
        return terms;
    }
    public void removeWords() {
    }
    public void addWords(){}

}



