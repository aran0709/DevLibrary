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
        if (nomeLivro == null || nomeLivro.isBlank()) {
            throw new IllegalArgumentException(
                    "Valor nulo!"
            );
        }
        this.nomeLivro = nomeLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        if(autorLivro == null || autorLivro.isBlank()) {
            throw new IllegalArgumentException(
                    "Valor nulo!"
            );
        }
        this.autorLivro = autorLivro;
    }

    public int getAnoPublicacaoLivro() {
        return anoPublicacaoLivro;
    }

    public void setAnoPublicacaoLivro(int anoPublicacaoLivro) {
        if(anoPublicacaoLivro > java.time.Year.now().getValue() || anoPublicacaoLivro < 1) {
            throw new IllegalArgumentException(
                    "Ano informado maior que o ano atual!"
            );
        }
        this.anoPublicacaoLivro = anoPublicacaoLivro;
    }

    public double getPrecoLivro() {
        return precoLivro;
    }

    public void setPrecoLivro(double precoLivro) {
        if (!Double.isFinite(precoLivro) || precoLivro < 0  || Double.isNaN(precoLivro)) {
            throw new IllegalArgumentException(
                    "Valor invalido !!"
            );
        }
        this.precoLivro = precoLivro;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if(quantidadeEstoque < 0 ) {
            throw new IllegalArgumentException(
              "Valor invalido !!"
            );
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        if (classificacaoIndicativa  !=0 && classificacaoIndicativa !=10 && classificacaoIndicativa !=12
        && classificacaoIndicativa != 14 && classificacaoIndicativa !=16 && classificacaoIndicativa !=18) {
            throw new IllegalArgumentException(
                    "Valor invalido !!"
            );
        }
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    @Override
    public String toString(){

        return  "Livro: " + getNomeLivro() + "\n"+
                "Autor: " + getAutorLivro() + "\n" +
                "Ano de Lançamento: " + getAnoPublicacaoLivro() + "\n"+
                "Preço:  " + String.format("%.2f",getPrecoLivro()) + "\n" +
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
