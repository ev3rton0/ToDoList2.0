package pacoteDeNegocios;
import java.time.LocalDate;

public class TarefaPessoal extends Tarefa {
    private String categoria; // Lazer, Saúde , dia a dia
    private int prioridade; // Alta, Média, Baixa (1, 2, 3)
    

    public TarefaPessoal(String titulo, String descricao, LocalDate dataEntrega, String categoria, int prioridade) {
        super(titulo, descricao, dataEntrega);  // Chamando o construtor da classe Tarefa
        this.categoria = categoria;
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }

    @Override
    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String exibirDetalhes() {
        // Utilizando o método `exibirDetalhesBase()` da classe Tarefa
        return exibirDetalhesBase() +
               "\nCategoria: " + categoria +
               "\nPrioridade: " + (prioridade == 1 ? "Alta" : prioridade == 2 ? "Média" : "Baixa") +
               "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TarefaPessoal outraTarefa = (TarefaPessoal) obj;
        return this.getTitulo().equals(outraTarefa.getTitulo());
    }


}
