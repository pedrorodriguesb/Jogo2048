package Backend;
public  class Jogador {
    private String nome;
    private int pont;
    private int melhorPont;

    //construtor do jogador
    public Jogador(String nome) {
        this.nome = nome;
        this.melhorPont = 0;
        this.pont = 0;
    }

    //metodo para atualizar a melhor pontuação
    public  void atualizar(){
        if (this.getPont() > this.getMelhorPont()){
            this.setMelhorPont(this.getPont());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPont() {
        return pont;
    }

    public void setPont(int pont) {
        this.pont = pont;
    }

    public int getMelhorPont() {
        return melhorPont;
    }

    public void setMelhorPont(int melhorPont) {
        this.melhorPont = melhorPont;
    }
    
    
}
