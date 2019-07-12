import java.util.ArrayList;

public class AtaqueFrecuencia {

    private static final int n = 26;
    private static final String alfabeto = "abcdefghijklmnopqrstuvwxyz";
    private ArrayList<Frecuencia> listaFrecuencia = new ArrayList<>();

    public String descifrar(String M) {

        for(int i=0; i < n; i++){
            Frecuencia freq = new Frecuencia("", 0);
            for (int j=0; j < M.length(); j++) {
                int pos = alfabeto.indexOf(M.charAt(j));
                int move = i;
                if (pos + move < alfabeto.length()) {
                    freq.valorFrecuencia += alfabeto.charAt(pos + move);
                } else {
                    freq.valorFrecuencia += alfabeto.charAt((pos + move) - alfabeto.length());
                }
            }
            listaFrecuencia.add(freq);
        }

        for (Frecuencia i:Main.dictionary){
            for (Frecuencia j:listaFrecuencia){
                if (j.valorFrecuencia.contains(i.valorFrecuencia)) {
                    j.frecuenciaTotal++;
                }
            }
        }

        int highFreq = 0;
        int posHighFreq = 0;
        for (int i=0; i<listaFrecuencia.size(); i++) {
            if (listaFrecuencia.get(i).frecuenciaTotal > highFreq) {
                highFreq = listaFrecuencia.get(i).frecuenciaTotal;
                posHighFreq = i;
            }
        }

        return listaFrecuencia.get(posHighFreq).valorFrecuencia;
    }

}
