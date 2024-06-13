package Backend;
import  Backend.Tabuleiro2048;
import Frontend.TelaPause;
import console.Console;
import console.Tecla;


public class Pcontroles {
    public static void checarMovimentos(Tabuleiro2048 tab) {
        
//tecla que vir do teclado
        Tecla tecla = Console.getTecla();
        
        switch(tecla) {
            //MOVIMENTOS PRA CIMA
            case Tecla.UP:
            case Tecla.W: 
                tab.moverAcima();
                break;
            //MOVIMENTOS PRA BAIXO
            case Tecla.DOWN:
            case Tecla.S:  
                tab.moverAbaixo();
                break;
            //MOVIMENTOS PRA ESQUERDA
            case Tecla.LEFT:
            case Tecla.A: 
                tab.moverEsquerda();
                break;
            //MOVIMENTOS PRA DIREITA
            case Tecla.RIGHT:
            case Tecla.D: 
                tab.moverDireita();
                break;
            //TELA DE MENU
            case Tecla.ESC: 
                TelaPause.mostraMenu();
                break;
            
        }
        
    }
    
   
}