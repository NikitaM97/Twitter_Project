import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Date.*;
import java.util.*;


// see how to make code more date relevant. essentially how to create one week range and see if tweet date is within that time period


public class Spider {
    static Scanner input=new Scanner(System.in);
    //a hashmap which contains all search words the tweets associated with them
    private static HashMap<String, ArrayList> hashmap=new HashMap<>();
    private static LinkedList<String> str=new LinkedList<>();
    private static LinkedHashMap<String,ArrayList> ordered=new LinkedHashMap<>();
    Spider(){}


    //allows the user to remove words from the search
   public static void RemoveTerms(Generic gen){
        gen.removeWords();
   }

   //allows the user to add words from the search
   public static void AddTerms(Generic gen) {
       gen.addWords();
   }

   //allows the user to see what words they are searching for
   public static void ViewTerms(Generic gen) {
       gen.viewSearch();
   }

    //sorts the hashmap in descending order
    private static void Hashmapsort(){
        //creates an arraylist which keeps track of the number of tweets per key word
        ArrayList <Integer> size=new ArrayList<>();
        //iterates over the hashmap and adds the size of the arraylist of tweets per word to arraylist size
        for (Map.Entry<String, ArrayList> hashmap:hashmap.entrySet()) {
            size.add(hashmap.getValue().size());
        }
        //collections sorts the arraylist
        Collections.sort(size);
        Collections.reverse(size);
        //for each int variable in size it loops through the hashmap to find the value which has the same arraylist size, and puts it in the linked hashmap which maintains order
        for (int i=0;i<size.size();i++) {
            for (Map.Entry<String, ArrayList> hashmap : hashmap.entrySet()) {
                if (size.get(i) == hashmap.getValue().size())
                    ordered.put(hashmap.getKey(), hashmap.getValue());
            }
        }

    }

    //makes sure the tweet is at least from two weeks back
    private static Boolean DateCheck(Date date){

        int noOfDays = -14; //i.e two weeks
        //creates an instance of calender
        Calendar calendar = Calendar.getInstance();
        //obj1 is the current date
        Date obj1=calendar.getTime();
        calendar.setTime(obj1);
        //.add -14 subtracts 14 days from the current days
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        Date obj = calendar.getTime();
        //checks if the date is in the specified range
        if (date.after(obj)&&date.before(obj1)){
            return true;
        }
        else{
            return false;
        }
    }

    private static Boolean DateCheck(Date date, int days){
        int noOfDays = days; //i.e two weeks
        //creates an instance of calender
        Calendar calendar = Calendar.getInstance();
        //obj1 is the current date
        Date obj1=calendar.getTime();
        calendar.setTime(obj1);
        //.add -14 subtracts 14 days from the current days
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        Date obj = calendar.getTime();
        //checks if the date is in the specified range
        if (date.after(obj)&&date.before(obj1)){
            return true;
        }
        else{
            return false;
        }
    }


    //searches through users timeline for words in arraylist
    public static void Timelinesearch(Generic gen) throws TwitterException{
        NLP.init();
        //authorizes twitter credentials
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("fTj26mbbJa6m2w0pflQgQ7J5E")
                .setOAuthConsumerSecret("38CgRDPk2O6LPPC7Yl07dbOx6YSw4q6fvxVPnSi1QWMtmF40vh")
                .setOAuthAccessToken("824628003682582528-JRZU2NwL6MGd808VDnOrj166oLO1ZVC")
                .setOAuthAccessTokenSecret("n1m8jl9KFdEtOPHtKIMjmO0YdVwzYsNKmtbaSQnK9fp4e");
        Twitter twitter= new TwitterFactory(cb.build()).getInstance();

        //sets the search terms equal to the object classes
        str=gen.getTerms();


        //creates a list of statuses and loops through each account for the relevant industry and adds their most recent 20 tweets to the list
        List<Status>statuses=new ArrayList<>();
        for (int i=0;i<gen.getAccount().size();i++){
            String user=Objects.toString(gen.getAccount().get(i));
            statuses.addAll(twitter.getUserTimeline(user));
        }

        //loops through the string array checking the statuses for the word it is searching for

        for (int i = 0; i < str.size(); i++) {

                //creates a new array for each new word to contain any statuses which may contain the word
                ArrayList<String> each_loop = new ArrayList<>();

                for (Status status : statuses) {
                    
                    //creates condition to find tweets which contain the word
                    if (status.getText().contains(str.get(i))&&DateCheck(status.getCreatedAt())==true){
                        String information=status.getCreatedAt()+"   "+status.getUser().getScreenName()+":         "+status.getText()+"  Sentiment: "+NLP.Sentiment(status.getText());
                        //adds all statuses to each loop
                        each_loop.add(information);

                    }

                }
                //puts the word and the arraylist containing tweets into the hashmap
                hashmap.put(str.get(i), each_loop);
            }
            //sorts the hashmap in descending order

        Hashmapsort();
        }

    //shows the 3 words with the highest frequency and all the tweets associated with them
    public static void Highestfrequency(){
        System.out.println("\n"+"Words with the highest frequency:");
        //accumulator to break for loop
        int accum=0;
        //loops through ordered linkedhashmap to print highest frequency
        for (Map.Entry<String,ArrayList> ordered : ordered.entrySet()){
            if (accum==3)
                break;
            System.out.println("\n"+"The word "+ordered.getKey()+" was mentioned in "+ordered.getValue().size()+" tweets."+"\n");
            for (int i=0; i<ordered.getValue().size();i++){
                System.out.println("\n"+ordered.getValue().get(i));
            }
          accum+=1;
        }
        System.out.println("End of words with highest frequency."+"\n"+"\n");

    }

   //views all tweets in relation to words
    public static void viewAll(){
        for (Map.Entry<String,ArrayList> ordered : ordered.entrySet()){
            System.out.println("\n"+"The word "+ordered.getKey()+" was mentioned in "+ordered.getValue().size()+" tweets."+"\n");
            for (int i=0; i<ordered.getValue().size();i++){
                System.out.println("\n"+ordered.getValue().get(i));
            }
        }
    }
}

