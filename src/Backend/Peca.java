package Backend;
import cores.StringColorida;
import mecanicas.Carta;

public class Peca extends Carta {
    
    public Peca() {
        super(new StringColorida("0", getCor(0)));
    }
    
    public Peca(StringColorida frente) {
        super(frente);
    }
    
    public Peca(int v) {
        super(new StringColorida(String.valueOf(v), getCor(v)));
    }
    
    public int getValor() {
        return Integer.parseInt(getFrente().getString().trim());
    }
    
    // deixa como padrão as cores dos numeros entre 2 e 8192
    private static String getCor(int v) {
        String resultado = "PRETO";
        
        if (v == 0){
            resultado = "BRANCO";
        }
        return resultado;
    }

    public StringColorida getTexto() {
        int v = getValor();
        return new StringColorida(String.format("%4d", v), getCor(v), getCorFundo(v));
  }
    
// define as cores dos numeros entre 2 e 8192
      private static String getCorFundo(int v) {
        String resultado = "FUNDO_BRANCO";
        switch(v) {
            case 2 -> resultado = "BRANCO";
            case 4 -> resultado = "CINZA";
            case 8 -> resultado = "BEGE";
            case 16 -> resultado = "CIANO_CLARO";
            case 32 -> resultado = "CIANO";
            case 64 -> resultado = "AZUL_CLARO";
            case 128 -> resultado = "AZUL";
            case 256 -> resultado = "VERDE_CLARO";
            case 512 -> resultado = "FUNDO_VERDE";
            case 1024 -> resultado = "BEGE";
            case 2048 -> resultado = "AMARELO";
            case 4096 -> resultado = "ROSA";
            case 8192 -> resultado = "VERMELHO";
        }
        return resultado;
      }
}
            
    
    
    

