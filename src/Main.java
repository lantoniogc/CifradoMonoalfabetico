import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final List<Frecuencia> dictionary = new ArrayList<>();

    public static void main(String[] args) {

        // a = 0;
        // b = 1;
        // c = 2;
        // d = 3;
        // e = 4;
        // f = 5;
        // g = 6;
        // h = 7;
        // i = 8;
        // j = 9;
        // k = 10;
        // l = 11;
        // m = 12;
        // n = 13;
        // o = 14;
        // p = 15;
        // q = 16;
        // r = 17;
        // s = 18;
        // t = 19;
        // u = 20;
        // v = 21;
        // w = 22;
        // x = 23;
        // y = 24;
        // z = 25;

        Monoalfabetico monoalfabetico = new Monoalfabetico(6);
        // String M = "this is a secret message";
        String M = "This mess is a secret message";
        System.out.println("Plain text: " + M);
        String textoCifrado = monoalfabetico.cifrar(M);
        System.out.println("Ciphertext: " + textoCifrado);
        String textoDescifrado = monoalfabetico.descifrar(textoCifrado);
        System.out.println("Deciphertext: " + textoDescifrado);

        AtaqueFrecuencia frecuencia = new AtaqueFrecuencia();
        getDictionary();
        System.out.println("Descifrado mediante frecuencia: " + frecuencia.descifrar(textoCifrado));

    }

    private static void getDictionary() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("/Users/devnodachi/Desktop/dictionary.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray words = (JSONArray) jsonObject.get("dictionary");
            words.forEach( w -> fillDictionary((JSONObject) w));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void fillDictionary(JSONObject wordList) {
        String s = (String) wordList.get("word");
        int f = Integer.parseInt(wordList.get("freq").toString());
        dictionary.add(new Frecuencia(s, f));
    }
}
