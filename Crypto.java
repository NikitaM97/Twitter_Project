import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by nikitamokhov on 31/01/2017.
 */
public class Crypto extends Generic implements Industry{

        private ArrayList<String> accounts=new ArrayList<>();
        static Scanner input=new Scanner(System.in);
        private LinkedList<String> crypto_terms=new LinkedList<>();
        Crypto (){
            crypto_terms.addAll(Arrays.asList("release","feature","price","index","fall","drop","rise","increase","collapse","new"));
            accounts.addAll(Arrays.asList("Bitcoin","coindesk","blockchain","BitcoinByte","BitcoinMagazine","ErikVoorhees","LitecoinProject","maidsafe","dogecoin","monerocurrency"));

        }
        public void viewSearch(){
            for (int i=0;i<crypto_terms.size();i++){
                System.out.print(crypto_terms.get(i)+" : ");
            }
        }
        public ArrayList<String> getAccount(){
            return accounts;
        }
        public LinkedList getTerms(){return crypto_terms;}
        public void removeWords() {
            for (int i = 0; i < crypto_terms.size(); i++) {
                System.out.print(crypto_terms.get(i) + " : ");
            }
            while (true){
                System.out.println("\n"+"Enter a word you would like to remove. Enter 123Done if finished removing.");
                String user=input.next();
                if (user.equals("123Done"))
                    break;
                else {
                    for (int i = 0; i < crypto_terms.size(); i++) {
                        if (user.equals(crypto_terms.get(i)))
                            crypto_terms.remove(i);
                    }
                }
            }
        }
        public void addWords(){
            for (int i = 0; i < crypto_terms.size(); i++) {
                System.out.print(crypto_terms.get(i) + " : ");
            }
            while (true){
                System.out.println("\n"+"Enter a word you would like to add. Enter 123Done if finished removing.");
                String user=input.next();
                if (user.equals("123Done"))
                    break;
                else {
                    crypto_terms.add(user);

                }
            }
        }
}

