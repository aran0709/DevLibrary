package Aran0709;

import Aran0709.Livros.Livro;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public  static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);





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
                        livro1.setNomeLivro(sc.nextLine());


                    }while(livro1.getNomeLivro().isBlank());


                    do {
                        System.out.println("Digite o nome do autor:");
                        livro1.setAutorLivro(sc.nextLine());

                    }while(livro1.getAutorLivro().isBlank());


                    do {
                        System.out.println("Digite o ano de publicação:");
                        livro1.setAnoPublicacaoLivro(sc.nextInt());



                    }while(livro1.getAnoPublicacaoLivro() < 1 || livro1.getAnoPublicacaoLivro() > java.time.Year.now().getValue());


                    do {
                        System.out.println("Digite o preço do livro:");
                        livro1.setPrecoLivro(sc.nextDouble());

                    }while(!Double.isFinite(livro1.getPrecoLivro()) || livro1.getPrecoLivro() <0);



                    do {
                        System.out.println("Qual a quantidade disponivel em estoque:");
                        livro1.setQuantidadeEstoque(sc.nextInt());

                    }while (livro1.getQuantidadeEstoque()<0);


                    do {
                        System.out.println("Digite a classificação indicativa ");
                        livro1.setClassificacaoIndicativa(sc.nextInt());


                    }while(livro1.getClassificacaoIndicativa() !=0  &&  livro1.getClassificacaoIndicativa() != 10 && livro1.getClassificacaoIndicativa() != 12
                            && livro1.getClassificacaoIndicativa() != 14 && livro1.getClassificacaoIndicativa() != 16 && livro1.getClassificacaoIndicativa() != 18);



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
                        valorEstoque = livro1.calcularValorEstoque();


                        System.out.printf("O valor do estoque é: R$ %.2f%n", valorEstoque);
                    }else{
                        System.out.println("Nenhum livro cadastrado. ");
                    }
                    break;


                case 4:

                    if(livroCadastrado) {

                        livro1.verificarClassificacao();

                    }else{
                        System.out.println("Nenhum livro cadastrado.");
                    }

                    break;


                case 5:
                    if(livroCadastrado) {
                        System.out.println("Estatísticas:");
                        valorEstoque = livro1.calcularValorEstoque();
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