package principal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar por título");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    biblioteca.adicionarLivro(titulo, autor);
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    biblioteca.buscarPorTitulo(sc.nextLine());
                    break;

                case 4:
                    System.out.print("ID do livro: ");
                    biblioteca.emprestar(sc.nextInt());
                    break;

                case 5:
                    System.out.print("ID do livro: ");
                    biblioteca.devolver(sc.nextInt());
                    break;
            }
        } while (opcao != 0);

        sc.close();
        System.out.println("Sistema encerrado.");
    }
}
