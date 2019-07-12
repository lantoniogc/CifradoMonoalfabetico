import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Monoalfabetico {

    private int b;
    private static final int n = 26;
    private static final String alfabeto = "abcdefghijklmnopqrstuvwxyz";
    private ArrayList<String> listMatch = new ArrayList<>();
    String arrayMatch[];

    public Monoalfabetico(int b) {
        this.b = b;
    }

    public String cifrar(String M) {
        String C = "";
        int move = (b % n);
        M = M.toLowerCase();

        for (int i=0; i<M.length();i++){
            if (alfabeto.contains(M.charAt(i) + "")) {
                int pos = alfabeto.indexOf(M.charAt(i));
                if (pos + move < alfabeto.length()) {
                    C += alfabeto.charAt(pos + move);
                } else {
                    C += alfabeto.charAt((pos + move) - alfabeto.length());
                }
            }
        }

        return C;
    }

    public String descifrar(String M) {
        String D = "";

        for (int i=0; i<M.length();i++){
            if (alfabeto.contains(M.charAt(i) + "")) {
                int pos = (int) ((double) alfabeto.indexOf(M.charAt(i)) - (double) b % n);
                if (pos < 0) {
                    pos += alfabeto.length();
                }
                D += alfabeto.charAt(pos);
            }
        }
        return D;
    }
}
