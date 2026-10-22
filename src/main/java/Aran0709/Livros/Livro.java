package Aran0709.Livros;

public class Livro {
    private String nomeLivro;
    private String autorLivro;
    private int anoPublicacaoLivro;
    private double precoLivro;
    private int quantidadeEstoque;
    private int classificacaoIndicativa;



    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public int getAnoPublicacaoLivro() {
        return anoPublicacaoLivro;
    }

    public void setAnoPublicacaoLivro(int anoPublicacaoLivro) {
        this.anoPublicacaoLivro = anoPublicacaoLivro;
    }

    public double getPrecoLivro() {
        return precoLivro;
    }

    public void setPrecoLivro(double precoLivro) {
        this.precoLivro = precoLivro;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    @Override
    public String toString(){

        return  "Livro: " + getNomeLivro() + "\n"+
                "Autor: " + getAutorLivro() + "\n" +
                "Ano de Lançamento: " + getAnoPublicacaoLivro() + "\n"+
                "Preço: " + getPrecoLivro() + "\n" +
                "Quantidade: " + getQuantidadeEstoque() + "\n"+
                "Classificação: " + getClassificacaoIndicativa() + "\n";
    }

    public double calcularValorEstoque(){
        return precoLivro * quantidadeEstoque;
    }

    public void verificarClassificacao(){

        if (classificacaoIndicativa == 0) {
            System.out.println("Classificação livre.");

        } else if (classificacaoIndicativa == 10) {
            System.out.println("Indicação de faixa etária: não recomendado para menores de 10 anos");
        } else if (classificacaoIndicativa == 12) {
            System.out.println("Indicação de faixa etária: não recomendado para menores de 12 anos");
        } else if (classificacaoIndicativa == 14) {
            System.out.println("Indicação de faixa etária: não recomendado para menores de 14 anos");
        } else if (classificacaoIndicativa == 16) {
            System.out.println("Indicação de faixa etária: não recomendado para menores de 16 anos");
        } else if (classificacaoIndicativa == 18) {
            System.out.println("Indicação de faixa etária: não recomendado para menores de 18 anos");
        }

    }

    public int calcularIdadeLivro(){
        return java.time.Year.now().getValue() - anoPublicacaoLivro;
    }

}
