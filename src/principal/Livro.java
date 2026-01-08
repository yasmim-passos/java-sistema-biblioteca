package principal;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(int id, String titulo, String autor, boolean emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.setEmprestado(emprestado);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        this.setEmprestado(true);
    }

    public void devolver() {
        this.setEmprestado(false);
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " - " + autor +
                (isEmprestado() ? " (Emprestado)" : " (Disponível)");
    }

    public String toFile() {
        return id + ";" + titulo + ";" + autor + ";" + isEmprestado();
    }

    public static Livro fromFile(String linha) {
        String[] dados = linha.split(";");
        return new Livro(
                Integer.parseInt(dados[0]),
                dados[1],
                dados[2],
                Boolean.parseBoolean(dados[3])
        );
    }

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
}
