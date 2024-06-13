package Backend;
import console.Console;
import Frontend.Ptela;
import Frontend.TelaDerrota;
import java.util.ArrayList;
import mecanicas.Tabuleiro;

public class Tabuleiro2048 extends Tabuleiro {
    //tabuleiro 4x4
    public Tabuleiro2048() {
        super(4, 4, new Peca());
    }
    
    private int pontos = 0;
    

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    public static void carregarTabuleiro(String stateString)  {
        String[] state = stateString.split(";");
        Tabuleiro2048 novoTab = new Tabuleiro2048();
        int xDim = 0;
        int yDim = 0;
        for(String pecaString : state) {
            if(yDim < 4) {
                // Lendo as peças
                int pecaValor = Integer.parseInt(pecaString);
                novoTab.setValorPessa(yDim, xDim, pecaValor);
                xDim++;
                if(xDim > 3) {
                    xDim = 0;
                    yDim++;
                }
            } else {
                // Lendo a pontucação
                if (yDim == 4){
                    novoTab.setPontos(Integer.parseInt(pecaString));
                    yDim ++;
                }else if(yDim == 5){
                    novoTab.setNome(pecaString);
                }
                
            }
            
        }
        if (novoTab.verificarDerrota()){
            TelaDerrota.perdeu(novoTab);
        }else{
            new Jogo2048().iniciarJogo(novoTab);
        }
    }
    private String nome = " ";

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Tabuleiro2048(int numLinhas, int numColunas, Peca fundo, String nome) {
        super(numLinhas, numColunas, fundo);
        this.nome = nome;
        novaPeca();
        novaPeca();
    }
    
    @Override
    public Peca getFundo(int x, int y) {
        return new Peca(super.getFundo(x, y).getFrente());
    }
    
    private void novaPeca() {
        ArrayList<int[]> vazios = espacosVazios();
        if(!vazios.isEmpty()) {
            Console.println(vazios.size());
            int[] espacoAleatorio = vazios.get((int) (Math.random() * vazios.size()));
            setFundo(espacoAleatorio[0], espacoAleatorio[1], new Peca(2));
        }
    }
    //verifica a quantidade de espaços vazios do tabuleiro
    private ArrayList<int[]> espacosVazios() {
        ArrayList<int[]> resultado = new ArrayList<>();
        
        for(int xDim = 0; xDim < getTotalColunas(); xDim++) {
            for(int yDim = 0; yDim < getTotalLinhas(); yDim++) {
                
                if(getFundo(xDim, yDim).getValor() == 0) {
                    resultado.add(new int[] {xDim, yDim});
                } else {
                }
            }
        }
        return resultado;
    }
    
     private void mover() {
        novaPeca();
        CarregarJogo.jogoSalvo(this, "saveAutomatico.txt");
        if(verificarDerrota()) {
            TelaDerrota.perdeu(this);
        } else {
            Ptela.mostrarTabuleiro(this);
        }
    }
     // mover pra esquerda funcionando
     public void moverEsquerda() {
        for (int y = 0; y < getTotalLinhas(); y++) {
            for (int x = 0; x < getTotalColunas(); x++) {
                Peca peca = getFundo(x, y);
                if (peca.getValor() != 0) {
                    for (int y2 = y - 1; y2 >= 0; y2--) {
                        Peca peca2 = getFundo(x, y2);
                        if (peca.getValor() == peca2.getValor()) {
                            setValorPessa(x, y2, peca.getValor() + peca2.getValor());
                            setValorPessa(x, y, 0);
                            int novoValor = peca.getValor() + peca2.getValor();
                            this.pontos += novoValor;
                        } else if (peca2.getValor() == 0) {
                            if (y2 == 0 || 
                                (getFundo(x, y2 - 1).getValor() != 0 &&
                                 getFundo(x, y2 - 1).getValor() != peca.getValor())) {

                                setValorPessa(x, y2, peca.getValor());
                                setValorPessa(x, y, 0);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        mover();
    }
     
    //mover pra cima funcionando
     public void moverAcima() {
        for (int x = 0; x < getTotalColunas(); x++){
            for (int y = 0; y < getTotalLinhas(); y++){
                Peca pessa = getFundo(x, y);
                if(pessa.getValor() != 0){
                    for (int x2 = x - 1; x2 >= 0; x2--){
                        Peca pessa2 = getFundo(x2, y);
                        if (pessa.getValor() == pessa2.getValor()){
                            setValorPessa(x2, y, pessa.getValor() + pessa2.getValor());
                            setValorPessa(x, y , 0);
                            int novoValor = pessa.getValor() + pessa2.getValor();
                             this.pontos += novoValor;
                        }
                        else if(pessa2.getValor() == 0){
                            if( x2 == 0 || 
                                (getFundo(x2-1, y).getValor() != 0 &&
                                getFundo(x2-1, y).getValor() != pessa.getValor())) {
                                
                                setValorPessa(x2, y, pessa.getValor());
                                setValorPessa(x, y , 0);
                            }
                        }
                        else{
                            break;
                       }
                    }
                }
            }
        }
        mover();
    }
     
     // mover pra direita funcionando
    public void moverDireita() {
        for (int y = getTotalLinhas() - 1; y >= 0; y--) {
            for (int x = 0; x < getTotalColunas(); x++) {
                // peça 1
                Peca peca = getFundo(x, y);
                if (peca.getValor() != 0) {
                    for (int y2 = y + 1; y2 < getTotalLinhas(); y2++) {
                        //peça 2
                        Peca peca2 = getFundo(x, y2);
                        if (peca.getValor() == peca2.getValor()) {
                            // Atualiza o valor da peça 2
                            int novoValor = peca.getValor() + peca2.getValor();
                             this.pontos += novoValor;
                            setValorPessa(x, y2, novoValor);
                            // Atualiza a pontuação do jogo somando o valor das peças combinadas
                            
                           
                            // Zera o valor da peça 1
                            setValorPessa(x, y, 0);
                            // Sai do loop interno
                            break;
                        } else if (peca2.getValor() == 0) {
                            if (y2 == getTotalLinhas() - 1 || 
                                (getFundo(x, y2 + 1).getValor() != 0 &&
                                 getFundo(x, y2 + 1).getValor() != peca.getValor())) {
                                // Move a peça para a posição vazia
                                setValorPessa(x, y2, peca.getValor());
                                // Zera o valor da peça original
                                setValorPessa(x, y, 0);
                                
                            }
                        } else {
                            // Sai do loop interno
                            break;
                        }
                    }
                }
            }
    }
    
    mover();
}

     
     //mover pra baixo funcionando
     public void moverAbaixo() {
        for (int x = getTotalColunas() - 1; x >= 0; x--){
            for (int y = 0; y < getTotalLinhas(); y++){
                Peca pessa = getFundo(x, y);
                if(pessa.getValor() != 0){
                    for (int x2 = x + 1; x2 < getTotalColunas(); x2++){
                        Peca pessa2 = getFundo(x2, y);
                        if (pessa.getValor() == pessa2.getValor()){
                            setValorPessa(x2, y, pessa.getValor() + pessa2.getValor());
                            setValorPessa(x, y , 0);
                            int novoValor = pessa.getValor() + pessa2.getValor();
                            this.pontos += novoValor;
                            
                        }
                        else if(pessa2.getValor() == 0){
                            if( x2 == getTotalColunas() - 1 || 
                                (getFundo(x2+1, y).getValor() != 0 &&
                                getFundo(x2+1, y).getValor() != pessa.getValor())) {
                                
                                setValorPessa(x2, y, pessa.getValor());
                                setValorPessa(x, y , 0);
                            }
                        }
                        else{
                            break;
                       }
                    }
                }
            }
        }
        mover();
    }
     
     
     public Peca setValorPessa(int x,int y , int v){
         Peca novaPeca = new Peca(v);
         setFundo(x, y, new Peca(v));
         return novaPeca;    
        
    }
    // verifica se o jogador perdeu
     public boolean verificarDerrota() {
        if(espacosVazios().isEmpty()) {
            int rows = getTotalLinhas();
            int cols = getTotalColunas();

            // Check all elements in the array
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // Check above
                    if (!((i > 0 && getFundo(i, j) == getFundo(i-1, j))
                        || (i < rows - 1 && getFundo(i, j) == getFundo(i+1, j))
                        || (j > 0 && getFundo(i, j) == getFundo(i, j-1))
                        || (j < cols - 1 && getFundo(i, j) == getFundo(i, j+1)))
                    ) {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
}