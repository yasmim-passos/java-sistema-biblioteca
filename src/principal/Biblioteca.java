package principal;

import java.io.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private final String ARQUIVO = "data/livros.txt";

    public Biblioteca() {
        livros = new ArrayList<>();
        carregar();
    }

    public void adicionarLivro(String titulo, String autor) {
        int id = livros.size() + 1;
        
        Livro novo = new Livro(id, titulo, autor, false);
        livros.add(novo);
        salvar();
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        livros.forEach(System.out::println);
    }

    public void buscarPorTitulo(String termo) {
        boolean encontrado = false;
        for (Livro l : livros) {
            if (l.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(l);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    public Livro buscarPorId(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    public void emprestar(int id) {
    	for (Livro l : livros) {
            if (l.getId() == id && !l.isEmprestado()) {
                l.setEmprestado(true);
                salvar();
                System.out.println("Livro emprestado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado ou já emprestado.");
    }

    public void devolver(int id) {
    	for (Livro l : livros) {
            if (l.getId() == id && l.isEmprestado()) {
                l.setEmprestado(false);
                salvar();
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado ou não está emprestado.");
    }

    private void salvar() {
        try {
            File pasta = new File("data");
            if (!pasta.exists()) {
                pasta.mkdir();
            }

            PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO));
            for (Livro l : livros) {
                pw.println(l.toFile());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }


    private void carregar() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                livros.add(Livro.fromFile(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo.");
        }
    }
}
