package ner_work;

/*
 * 
 *
 
Source:
    https://attacomsian.com/blog/java-read-parse-csv-file

    https://medium.com/swlh/stanford-corenlp-training-your-own-custom-ner-tagger-8119cc7dfc06

 * 
 * 
 */


import java.util.Properties;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.sequences.SeqClassifierFlags;
import edu.stanford.nlp.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
// import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TrainModel {

    static String OBJ_NAME = "grocery";

    static void print(Object obj){
        System.out.println(obj);
    }

    public static HashMap<String, String> getEntities_2(CRFClassifier model, String input){

        input = input.trim();
        // System.out.println(input+" ==> "+model.classifyToString(input));
        String result = model.classifyToString(input);

        print(result);

        String result1 = model.classifyWithInlineXML(input);

        return null;
    }

    static void printMap(HashMap<String, String> map){


        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            
            if(value.toString().trim().length() == 0){
                continue;
            }

            print(key + " : " + value);
        }
    }

    // static 
    public static void trainAndWrite(String modelOutPath, String prop, String trainingFilepath) {
        Properties props = StringUtils.propFileToProperties(prop);
        props.setProperty("serializeTo", modelOutPath);
        //if input use that, else use from properties file.
        if (trainingFilepath != null) {
            props.setProperty("trainFile", trainingFilepath);
        }
        SeqClassifierFlags flags = new SeqClassifierFlags(props);
        CRFClassifier<CoreLabel> crf = new CRFClassifier<>(flags);
        crf.train();
        crf.serializeClassifier(modelOutPath);
    }

    public static void main(String[] args){
        trainAndWrite((OBJ_NAME + ".model.ser.gz"), OBJ_NAME + ".prop", OBJ_NAME+"_training.txt");
    }
}



/*
 * 

# Compiling the Java file


java -cp "./jars/*:." TrainModel.java


 */