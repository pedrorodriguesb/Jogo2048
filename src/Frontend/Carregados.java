package Frontend;
import static Frontend.MenuPrincipal.menu;
import console.Console;
import console.Tecla;
public class Carregados {
    
    public static void mostrarCarregados(){
       Console.limpaTela();
            while(true){
                Console.println("╔═══════════════════════════════════════════╗");
                Console.println("║               SAVES                       ║");
                Console.println("╚═══════════════════════════════════════════╝");
                Console.println("╔═══════════════════════════════════════════╗");
                for (int c = 1; c <= 10; c++) {
                    Console.println("║ SAVES " + c + /* NOME */ ":");
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
            }
    } 
}
