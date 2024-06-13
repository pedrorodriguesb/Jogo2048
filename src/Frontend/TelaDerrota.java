package Frontend;

import Backend.Jogo2048;
import Backend.Peca;
import Backend.Tabuleiro2048;
import static Frontend.MenuPrincipal.menu;
import static Frontend.MenuPrincipal.pedirNome;
import console.Console;
import console.Tecla;

public class TelaDerrota {
    public static void perdeu(Tabuleiro2048 tab){
        boolean sla = false;
       while(true) {
            Console.limpaTela();
            Console.println(" ╔═══════════════════════════╗");
            Console.println(" ║        VOCÊ PERDEU        ║");
            //Console.println(" ║ Seu Score foi: " + tab.getPontos() + "║" );
            imprimirScore(tab);
            Console.println(" ╚═══════════════════════════╝");
            Console.println(" ╔═══════════════════════════╗");
            Console.println(" ║1 - INICIAR NOVO JOGO:     ║");
            Console.println(" ║2 - MENU INICIAL           ║");
            Console.println(" ║3 - SAIR DO JOGO:          ║");
            Console.println(" ╚═══════════════════════════╝");
            if (sla){
                Console.println("INSIRA UM NÚMERO INTEIRO ENTRRE 1, 2 ou 3");
            }

            Tecla sair = Console.getTecla();


                switch (sair){
                    case sair.NUM_1:
                        new Jogo2048().iniciarJogo(new Tabuleiro2048(4,4, new Peca(), pedirNome()));

                    break;

                    case sair.NUM_2:
                        Console.limpaTela();
                        menu();
                    break;
                    
                    case sair.NUM_3:
                        Console.saiDoPrograma();
                    break;
                    
                    default:
                      sla = true;
                    break;
                }

           }
    }
    private static void imprimirScore(Tabuleiro2048 tab) {
        // Exibe o score com colunas, ajustando o comprimento
        String scoreString = "" + tab.getPontos();
        int length = 11;
        String paddedScore = scoreString + " ".repeat(length - scoreString.length());
        Console.println(" ║ Seu Score foi: " + paddedScore + "║" );
    }
}
