package Frontend;

import static Frontend.MenuPrincipal.menu;
import console.Console;
import console.Tecla;
import Backend.Tabuleiro2048;
import cores.StringColorida;
import java.util.HashMap;

public class Records {
    public static void melhores(){
            Console.limpaTela();
            while(true){
                Console.println("╔═══════════════════════════════════════════╗");
                Console.println("║         MELHORES JOGADORES                ║");
                Console.println("╚═══════════════════════════════════════════╝");
                Console.println("╔═══════════════════════════════════════════╗");
                for (int c = 1; c <= 10; c++) {
                    Console.println("║ PLAYER " + c + /* NOME */ ":");
                    Console.println("║    SCORE:");
                    Console.println("║");
                }

                
                
                Console.println("╠═══════════════════════════════════════════╣");
                
                
                Console.println("║ Pressione ESC PARA VOLTAR AO MENU INICIAL ║");
                Console.println("╚═══════════════════════════════════════════╝");
                Tecla voltar = Console.getTecla();
                if (voltar.equals(voltar.ESC)){
                    Console.limpaTela();
                    menu();
                }else {
                    Console.limpaTela();
                }
                HashMap<String, Integer> jogador = new HashMap<String, Integer>();
            }
            
        }
}
