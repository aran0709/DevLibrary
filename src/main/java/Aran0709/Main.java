package Aran0709;

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
        int qtExemplaresCadastrados = 0;
        double valorEstoque = 0.0;
        int idadeLivro = 0;

        boolean livroCadastrado = false;

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



                case 1:

                    sc.nextLine();
                    System.out.println("Digite o nome do livro: ");
                     nomeLivro = sc.nextLine();

                    System.out.println("Digite o nome do autor:");
                    autorLivro = sc.nextLine();

                    System.out.println("Digite o ano de publicação:");
                    anoPublicacaoLivro = sc.nextInt();

                    System.out.println("Digite o preço do livro:");
                    precoLivro = sc.nextDouble();

                    System.out.println("Qual a quantidade disponivel em estoque:");
                    quantidadeEstoque = sc.nextInt();

                    System.out.println("Digite a classificação indicativa ");
                    classificacaoIndicativa = sc.nextInt();

                    qtExemplaresCadastrados++;
                    System.out.println("\n\n CADASTRADO COM SUCESSO!\n");
                    livroCadastrado = true;
                    break;

                case 2:
                    if(livroCadastrado == true) {
                        System.out.printf("O  nome do livro: %s%n", nomeLivro);
                        System.out.printf("O nome do autor: %s%n", autorLivro);
                        System.out.printf("Ano: %d%n", anoPublicacaoLivro);
                        System.out.printf("Preço: R$ %.2f%n", precoLivro);
                        System.out.printf("Quantidade: %d%n", quantidadeEstoque);
                        System.out.printf("Classificação indicativa: %d%n", classificacaoIndicativa);
                    }else {
                        System.out.println("Cadastre um livro primeiro ");
                    }
                    break;



                case 3:
                    System.out.println("Vamos calcular o valor do estoque :");
                    valorEstoque = precoLivro * quantidadeEstoque;

                    System.out.printf("O valor do estoque é: R$ %.2f%n",valorEstoque);
                    break;


                case 4:

                    if(classificacaoIndicativa == 0){
                        System.out.println("Classificação livre.");

                    }else if(classificacaoIndicativa == 10){
                        System.out.println("Indecação de faixa etária: não recomendado para menores de 10 anos");
                    }else if(classificacaoIndicativa == 12){
                        System.out.println("Indecação de faixa etária: não recomendado para menores de 12 anos");
                    }else if(classificacaoIndicativa == 14){
                        System.out.println("Indecação de faixa etária: não recomendado para menores de 14 anos");
                    }else if(classificacaoIndicativa == 16){
                        System.out.println("Indecação de faixa etária: não recomendado para menores de 16 anos");
                    }else if(classificacaoIndicativa == 18){
                        System.out.println("Indecação de faixa etária: não recomendado para menores de 18 anos");
                    }else {
                        System.out.println("CLASSIFICAÇÃO INVALIDA!");
                    }
                    break;


                case 5:
                    System.out.println("Estatísticas:");
                    valorEstoque = precoLivro * quantidadeEstoque;
                    System.out.printf("Quantidade de exemplares cadastrados em estoque: %d%n",qtExemplaresCadastrados);
                    System.out.printf("Valor de estoque: R$ %.2f%n",valorEstoque);
                    idadeLivro = 2026 - anoPublicacaoLivro;
                    System.out.printf("Idade do livre em comparação a o ano atual: %d%n",idadeLivro);





                default:
                    System.out.println("Opção inválida ! Tente novamente." );
                    break;

            }


        } while (opcao != 0);


        sc.close();
    }
}