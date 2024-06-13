package Backend;
import console.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CarregarJogo {
    public static File[] listarSaves(String path){
        File file = new File(path);
        return file.listFiles();

    }
    //https://stackoverflow.com/questions/4032957/how-to-get-the-real-path-of-java-application-at-runtime
    public static String getSavesPath() {
        String[] locations = new Jogo2048().getClass().getProtectionDomain().getCodeSource().getLocation().toString().replaceAll("%20", " ").split("/");
        String savesPath = "";
        for(int i = 1; i < locations.length - 2; i++) {
            savesPath += locations[i] + "/";
        }
        return savesPath + "saves/";
    }
    
    public static void carregar(String path){
        String jogoSalvo = lerArquivo(getSavesPath() + path);
        Tabuleiro2048.carregarTabuleiro(jogoSalvo);
    }
    
    private static void salvar(String path, String texto)  {
        try {
            FileWriter myObj = new FileWriter(path);
            myObj.write(texto);
            myObj.close();
        } catch (IOException e) {
            Console.println("An error occurred.");
        }
        
    }
    
    //pega o conteudo do arq
    private static String lerArquivo(String path)  {
        String data = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            Console.println("An error occurred.");
        }
        return data;
    }
    //salvar jogo
    public static void jogoSalvo(Tabuleiro2048 tab, String path){
            String salvamente = "";
            for(int xDim = 0; xDim < tab.getTotalColunas(); xDim++) {
                for(int yDim = 0; yDim < tab.getTotalLinhas(); yDim++) {
                    salvamente += tab.getFundo(xDim, yDim).getFrente().getString();
                    
                    if(!(xDim == (tab.getTotalColunas()-1) && yDim == (tab.getTotalLinhas()-1))){
                        salvamente += ";";
                    }
                }
            
          }
        salvamente += ";" + tab.getPontos();
        salvamente += ";" + tab.getNome();
        CarregarJogo.salvar(getSavesPath() + path, salvamente);
    }
}
