import java.util.HashMap;
import java.util.Properties;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.sequences.SeqClassifierFlags;
import edu.stanford.nlp.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class TestNER {

    static String MODEL_PATH            = "grocery.model.ser.gz";

    public static CRFClassifier getModel(String modelPath) {
        return CRFClassifier.getClassifierNoExceptions(modelPath);
    }

    static void print(Object obj){
        System.out.println(obj);
    }

    static HashMap<String, String> string2XMLDocument(String content){
        String xml = "<item>" + content+"</item>";

        HashMap<String, String> resultMap = new HashMap<String, String>();

        Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
        for (Element item : doc.select("item")) {
            Elements children = item.children();
            for (Element child : children) {
                // System.out.println(child.tag() + " : " + child.text());
                // System.out.println(child.text());

                String cTag     = ""+child.tag();
                String cValue   = child.text();

                if(resultMap.containsKey(cTag)){
                    cValue = "" + resultMap.get(cTag) + " " + cValue;
                    resultMap.put(cTag, cValue);
                } else{
                    resultMap.put(cTag, cValue);
                }

                
            }
        }

        return resultMap;
    }

    public static HashMap<String, String> getEntities2(CRFClassifier model, String input){
        
        String xmlContent = model.classifyWithInlineXML(input);

        // print(xmlContent);

        HashMap<String, String> resultMap = string2XMLDocument(xmlContent);

        return resultMap;
    }

    public static void doTagging(CRFClassifier model, String input){
        input = input.trim();
        // System.out.println(input+" ==> "+model.classifyToString(input));
        String result = model.classifyToString(input);

        // print(model.classify(input));

        print(result);
    }

    private String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }

    public static void main(String[] args) throws IOException {

        CRFClassifier model = getModel(MODEL_PATH);

        String content = "I need condiments like soy sauce and vinegar.";

        // doTagging(model, content);
        HashMap<String, String> result = getEntities2(model, content);
        print(result);
        // printMap(result);

        // string2XMLDocument("<HOUSE_NO>150</HOUSE_NO> <STREET_NAME>GLADSTONE AVE N</STREET_NAME>");

    }
}



/*
 * 

# Compiling the Java file


java -cp "./jars/*:." TestNER.java


 */