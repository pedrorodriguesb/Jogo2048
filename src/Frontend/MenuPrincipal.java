package Frontend;
import Backend.CarregarJogo;
import Backend.Jogador;
import Backend.Jogo2048;
import Backend.Peca;
import Backend.Tabuleiro2048;
import Backend.Pcontroles;
import static Frontend.Carregados.mostrarCarregados;
import Frontend.Ptela;
import static Frontend.Records.melhores;
import console.Console;
import console.Tecla;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;




public class MenuPrincipal {
    //mostra o menu inicial
    public static void menu(){
        while (true)  {
                    Console.println("╔═══════════════════════════════════╗");
                    Console.println("║             JOGO 2048             ║");
                    Console.println("╚═══════════════════════════════════╝");
                    
                    Console.println("╔═══════════════════════════════════╗");
                    Console.println("║ 1 - INICIAR NOVO JOGO             ║");
                    Console.println("║ 2 - CONTINUAR JOGO                ║");
                    Console.println("║ 3 - CARREGAR JOGO                 ║");
                    Console.println("║ 4 - RECORDS                       ║");
                    Console.println("║ 5 - CREDITOS                      ║");
                    Console.println("║ 6 - SAIR DO JOGO                  ║");
                    Console.println("╚═══════════════════════════════════╝");
            
                    
                    Tecla escolha = Console.getTecla();
                        switch (escolha){
                            case escolha.NUM_1:
                                // inicia um novo jogo
                                new Jogo2048().iniciarJogo(new Tabuleiro2048(4,4, new Peca(), pedirNome()));
                            break;

                            case escolha.NUM_2:
                                //continua o jogo do ultimo save automatico
                                Console.limpaTela();
                                CarregarJogo.carregar("saveAutomatico.txt");
                            break;

                            case escolha.NUM_3:
                                mostrarCarregados();
                                //Saves.mostraSave();
                            break;
                            
                            case escolha.NUM_4:
                                //n ta prestando
                                melhores();
                            break;

                            case escolha.NUM_5:
                                //CREDITOS DO CRIADOR DO JOGO funcionando
                                credito();
                            break;

                            case escolha.NUM_6:
                                //sair do programa funcionando
                                sair();
                            break;
                            
                            default:
                                Console.limpaTela();
                           
                        }
        } 
    }
    

    // mostra os creditos do jogo, funcionando perfeitamente
    public static void credito(){
            
                        Console.limpaTela();
                        Console.println("╔═══════════════════════════════════╗");
                        Console.println("║                                   ║");
                        Console.println("║            CRÉDITOS               ║");
                        Console.println("║                                   ║");
                        Console.println("╠═══════════════════════════════════╣");
                        Console.println("║ Aluno: Pedro Rodrigues Barreto    ║");
                        Console.println("║ CPF: 162.096.907-69               ║");
                        Console.println("║ RA: 127189611025                  ║");
                        Console.println("╠═══════════════════════════════════╣");
                        Console.println("║ APERTE ESC PARA VOLTAR            ║");
                        Console.println("╚═══════════════════════════════════╝");
                        
                        Tecla voltar = Console.getTecla();
                        
                        if (voltar.equals(Tecla.ESC)){
                            Console.limpaTela();
                            menu();
                        }else{
                            credito();
                        }
            
        }
    

    // sair esta funcionando
    public static void sair(){
       boolean sla = false;
       while(true) {
            Console.limpaTela();
            Console.println(" ╔═══════════════════════════╗");
            Console.println(" ║  DESEJA SAIR DO JOGO?     ║");
            Console.println(" ╚═══════════════════════════╝");

            Console.println("   ╔═════════╗   ╔═════════╗");
            Console.println("   ║ 1 - SIM ║   ║ 2 - NÃO ║");
            Console.println("   ╚═════════╝   ╚═════════╝");
            if (sla){
                Console.println("INSIRA UM NÚMERO INTEIRO ENTRRE 1 E 2");
            }

            Tecla sair = Console.getTecla();


                switch (sair){
                    case sair.NUM_1:
                       //fecharConsoleWindows();
                        Console.limpaTela();
                        Console.saiDoPrograma();
                    break;

                    case sair.NUM_2:
                        Console.limpaTela();
                        menu();
                    break;

                    default:
                      sla = true;
                    break;
                }

           }
    }


//funcionando perfeitamente 
public static String pedirNome() {
        Console.limpaTela();
        StringBuilder nome = new StringBuilder();
         
        while (true) {
            Console.limpaTela();
            Console.println("╔═════════════════════════════════════════╗");
            Console.println("║ Digite seu nome: " + Ptela.imprimirNome(nome.toString(),23) +      "║");
            Console.println("╠═════════════════════════════════════════╣");
            Console.println("║      ULTILIZE CTRL PAGA APAGAR          ║");
            Console.println("╚═════════════════════════════════════════╝");
            Tecla tecla = Console.getTecla();
            if (tecla == Tecla.ENTER) {
                break;
            } else if (tecla == Tecla.CTRL) {
                if (nome.length() > 0) {
                    nome.deleteCharAt(nome.length() - 1);
                }
            } else if(tecla == tecla.ESPACO){
                 nome.append(" ");
            }else {
                if(tecla.name().length() == 1){
                    nome.append(tecla.name());
                }
            }
        }

        Console.limpaTela();
        return nome.toString();
        
    }
}
 


