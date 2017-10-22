/**
 * Created by nikitamokhov on 21/02/2017.
 */
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;


import java.util.Properties;

public class NLP {
    static StanfordCoreNLP pipeline;
    public static void init(){
        Properties props=new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref, sentiment");
        pipeline=new StanfordCoreNLP(props);
    }
    public static int Sentiment(String tweet){
        int sent=0;
        if (tweet!=null&&tweet.length()>0){
            int longest=0;
            Annotation annotation= pipeline.process(tweet);
            for (CoreMap sentence: annotation.get(CoreAnnotations.SentencesAnnotation.class)){
                Tree tree=sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int sentiment=RNNCoreAnnotations.getPredictedClass(tree);
                String part_text=sentence.toString();
                if (part_text.length()>longest){
                    sent=sentiment;
                    longest=part_text.length();
                }
            }
        }
        return sent;
    }
}
