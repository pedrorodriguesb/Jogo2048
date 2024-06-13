package Backend;
import Frontend.MenuPrincipal;
import Frontend.Ptela;
import Frontend.Saves;
import Frontend.TelaDerrota;
import console.Console;
import console.Tecla;

public class Jogo2048 {
    public static void main(String[] args) {
        //chama o menu
        MenuPrincipal.menu();
        
        
    }
    //lop do jogo
    public void iniciarJogo(Tabuleiro2048 tab) {
        
        Ptela.mostrarTabuleiro(tab);
        // loop do jogo
        
            while(true) {
                //chechando os movimentos possiveis
                Pcontroles.checarMovimentos(tab);
            }
    }
}