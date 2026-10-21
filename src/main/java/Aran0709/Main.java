package Aran0709;

import Aran0709.Livros.Livro;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public  static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String nomeLivro = "";
        String autorLivro = "";
        int anoPublicacaoLivro = 0 ;
        double precoLivro = 0.0;
        int quantidadeEstoque = 0;
        int classificacaoIndicativa = 0;
        double valorEstoque = 0.0;
        int idadeLivroEmAnos = 0;

        boolean livroCadastrado = false;

        Livro livro1 = new Livro();

        int opcao;
        do {


            System.out.println("============DEVLIBRARY==============" +
                    "\n 1 - Cadastrar Livro" +
                    "\n 2 - Exibir dados do livro" +
                    "\n 3 - Calcular valor do estoque " +
                    "\n 4 - Verificar faixa etária recomendada" +
                    "\n 5 - Exibir estatísticas" +
                    "\n 0 - Sair" +
                    "\n ==============================" +
                    "\n Escolha uma opção: ");
            opcao = sc.nextInt();



            switch(opcao) {
                case 0:
                    System.out.println("Encerrando o Devlibrary. Até mais!");
                    break;



                case 1:

                    sc.nextLine();


                    do {
                        System.out.println("Digite o nome do livro: ");
                        nomeLivro = sc.nextLine();
                        livro1.setNomeLivro(nomeLivro);

                    }while(nomeLivro.isBlank());


                    do {
                        System.out.println("Digite o nome do autor:");
                        autorLivro = sc.nextLine();
                        livro1.setAutorLivro(autorLivro);
                    }while(autorLivro.isBlank());


                    do {
                        System.out.println("Digite o ano de publicação:");
                        anoPublicacaoLivro = sc.nextInt();

                    }while(anoPublicacaoLivro < 1 || anoPublicacaoLivro > java.time.Year.now().getValue());
                    livro1.setAnoPublicacaoLivro(anoPublicacaoLivro);

                    do {
                        System.out.println("Digite o preço do livro:");
                        precoLivro = sc.nextDouble();

                    }while(!Double.isFinite(precoLivro) || precoLivro <0);
                    livro1.setPrecoLivro(precoLivro);


                    do {
                        System.out.println("Qual a quantidade disponivel em estoque:");
                        quantidadeEstoque = sc.nextInt();
                    }while (quantidadeEstoque<0);
                    livro1.setQuantidadeEstoque(quantidadeEstoque);

                    do {
                        System.out.println("Digite a classificação indicativa ");
                        classificacaoIndicativa = sc.nextInt();

                    }while(classificacaoIndicativa !=0  &&  classificacaoIndicativa != 10 && classificacaoIndicativa != 12
                            && classificacaoIndicativa != 14 && classificacaoIndicativa != 16 && classificacaoIndicativa != 18);
                    livro1.setClassificacaoIndicativa(classificacaoIndicativa);


                    System.out.println("\n\n CADASTRADO COM SUCESSO!\n");
                    livroCadastrado = true;
                    break;

                case 2:
                    if(livroCadastrado) {
                        System.out.println(livro1);
                    }else {
                        System.out.println("Cadastre um livro primeiro ");
                    }
                    break;



                case 3:
                    if (livroCadastrado) {
                        System.out.println("Vamos calcular o valor do estoque :");
                        valorEstoque = livro1.calcularEstoque();


                        System.out.printf("O valor do estoque é: R$ %.2f%n", valorEstoque);
                    }else{
                        System.out.println("Nenhum livro cadastrado. ");
                    };
                    break;


                case 4:

                    if(livroCadastrado) {

                        livro1.verificarClassificacao();

                    }else{
                        System.out.println("Nenhum livro cadastrado.");
                    };

                    break;


                case 5:
                    if(livroCadastrado) {
                        System.out.println("Estatísticas:");
                        valorEstoque = livro1.calcularEstoque();
                        System.out.printf("Quantidade de exemplares cadastrados em estoque: %d%n",livro1.getQuantidadeEstoque());
                        System.out.printf("Valor de estoque: R$ %.2f%n",valorEstoque);
                        idadeLivroEmAnos = livro1.calcularIdadeLivro();
                        System.out.printf("Idade do livro em anos: %d%n",idadeLivroEmAnos);
                    }else{
                        System.out.println("Nenhum livro cadastrado.");
                    }

                    break;





                default:
                    System.out.println("Opção inválida ! Tente novamente." );
                    break;

            }


        } while (opcao != 0);


        sc.close();
    }
}