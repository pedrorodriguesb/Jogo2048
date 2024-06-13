package Frontend;
import Backend.Tabuleiro2048;
import console.Console;
import cores.StringColorida;
public class Ptela { 
    public static void mostrarTabuleiro(Tabuleiro2048 tab) {
        Console.limpaTela();

        Console.println("╔═══════════════════════════════════╗"); 
        Console.println("║             2048                  ║"); 
        Console.println("╠═══════════════════════════════════╣"); 

        // Obtém o nome do jogador e a pontuação
        String nome = "Nome: " + tab.getNome(); // Armazena o nome do jogador
        String scoreString = "Score: " + tab.getPontos(); // Armazena a pontuação do jogador

        // Imprime o nome e a pontuação ajustados para alinhamento
        Console.println(imprimirNome("║ " + nome, "═══════════════════════════════════".length()) + " ║"); // Imprime o nome alinhado
        Console.println(imprimirNome("║ " + scoreString, "═══════════════════════════════════".length()) + " ║"); // Imprime a pontuação alinhada
        Console.println("╠═══════════════════════════════════╣"); // Imprime a linha abaixo da pontuação

        int totalColunas = tab.getTotalColunas(); // Obtém o número total de colunas do tabuleiro

        // Imprime a borda superior do tabuleiro de jogo
        Console.print("║   ┌"); // Inicia a linha da borda superior
        for (int i = 0; i < totalColunas; i++) { // Itera sobre o número de colunas
            Console.print("──────"); // Imprime a parte superior da célula
            if (i < totalColunas - 1) { // Verifica se não é a última coluna
                Console.print("┬"); // Imprime o conector entre as colunas
            }
        }
        Console.println("┐   ║"); // Finaliza a linha da borda superior

        // Imprime as linhas do tabuleiro com os valores das células
        for (int y = 0; y < tab.getTotalLinhas(); y++) { // Itera sobre o número de linhas
            Console.print("║   │"); // Inicia a linha do tabuleiro
            for (int x = 0; x < totalColunas; x++) { // Itera sobre o número de colunas
                StringColorida texto = tab.getFundo(y, x).getTexto(); // Obtém o texto colorido de cada célula do tabuleiro
                Console.print(String.format(" %-4s ", texto.toString())); // Formata e imprime o texto da célula
                if (x < totalColunas - 1) { // Verifica se não é a última coluna
                    Console.print("│"); // Imprime o separador entre as colunas
                }
            }
            Console.println("│   ║"); // Finaliza a linha do tabuleiro

            // Imprime a borda entre as linhas do tabuleiro
            if (y < tab.getTotalLinhas() - 1) { // Verifica se não é a última linha
                Console.print("║   ├"); // Inicia a linha da borda intermediária
                for (int x = 0; x < totalColunas; x++) { // Itera sobre o número de colunas
                    Console.print("──────"); // Imprime a parte inferior da célula
                    if (x < totalColunas - 1) { // Verifica se não é a última coluna
                        Console.print("┼"); // Imprime o conector entre as células
                    }
                }
                Console.println("┤   ║"); // Finaliza a linha da borda intermediária
            }
        }

        // Imprime a borda inferior do tabuleiro de jogo
        Console.print("║   └"); // Inicia a linha da borda inferior
        for (int i = 0; i < totalColunas; i++) { // Itera sobre o número de colunas
            Console.print("──────"); // Imprime a parte inferior da célula
            if (i < totalColunas - 1) { // Verifica se não é a última coluna
                Console.print("┴"); // Imprime o conector entre as células
            }
        }
        Console.println("┘   ║"); // Finaliza a linha da borda inferior

        Console.println("╚═══════════════════════════════════╝"); // Imprime a borda inferior do cabeçalho
    }

    // Método auxiliar para ajustar o comprimento do texto para alinhamento
    public static String imprimirNome(String nome, int length) {
        int nomeLength = Math.min(nome.length(), length); // Calcula o comprimento do texto ajustado
        String nomePreenchido = nome + " ".repeat(length - nomeLength); // Adiciona espaços em branco para preencher o comprimento necessário
        return nomePreenchido; // Retorna o texto ajustado
    }
}
