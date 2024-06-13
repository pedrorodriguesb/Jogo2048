package Frontend;

import Backend.CarregarJogo;
import Backend.Jogo2048;
import Backend.Peca;
import Backend.Tabuleiro2048;
import Frontend.MenuPrincipal;
import console.Console;
import console.Tecla;
import java.util.Scanner;
// colocar pro frontend

public class TelaPause {
    public static void mostraMenu(){
        Console.limpaTela();
                 Console.println("╔════════════════════════════════════════╗");
                 Console.println("║                 PAUSE                  ║");
                 Console.println("╠════════════════════════════════════════╣");
                 Console.println("║ PRECIONE O NúMERO PARA REALIZAR A AÇÃO ║");
                 Console.println("╠════════════════════════════════════════╣");
                 Console.println("║ 1 - VOLTAR PARA O JOGO                 ║");
                 Console.println("║ 2 - SALVAR JOGO                        ║");
                 Console.println("║ 3 - INICIAR NOVO JOGO                  ║");
                 Console.println("║ 4 - CARREGAR JOGO                      ║");
                 Console.println("║ 5 - VOLTAR PARA O MENU INICIAL         ║");
                 Console.println("║ 6 - SAIR DO JOGO                       ║");
                 Console.println("╚════════════════════════════════════════╝");
                Tecla tecl = Console.getTecla();
                switch (tecl){
                    case tecl.NUM_1:
                        Console.limpaTela();
                        CarregarJogo.carregar("saveAutomatico.txt");
                    break;
                    
                    case tecl.NUM_2:
                        Console.println("SALVAR JOGO");
                    break;
                    
                    case tecl.NUM_3:
                        //INICIAR NOVO JOGO
                        new Jogo2048().iniciarJogo(new Tabuleiro2048(4,4, new Peca(), MenuPrincipal.pedirNome()));
                        
                    break;
                    
                    case tecl.NUM_4:
                        //criar um metodo com um switch que vai carregar os jogos salvos
                        Console.println("CARREGAR JOGO");
                    break;
                    case tecl.NUM_5:
                        //funcionando
                        Console.limpaTela();
                        MenuPrincipal.menu();
                        
                    break;
                    
                    case tecl.NUM_6:
                        //funcionando
                        Console.saiDoPrograma();
                    break;
                }
    }
}
