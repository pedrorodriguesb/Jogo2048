package Frontend;
import Backend.CarregarJogo;
import static Backend.CarregarJogo.listarSaves;
import console.Console;
import java.io.File;

public class Saves {
    public static void mostraSave(){
    File[]arq = CarregarJogo.listarSaves("saves");
    Console.limpaTela();
    for (File arquivo : arq){
        Console.println(arquivo.getName());
    }
    Console.println("\n Escolha um save:");
    String teste = Console.input();
    }
   }
