package pacoteDeNegocios;

import java.time.LocalDate;

public class TarefaDeTrabalho extends Tarefa {
    private String colaborador;
    private int prioridade; // Alta, Média, Baixa (1, 2, 3)
    private String setorDaEmpresa; 

    public TarefaDeTrabalho(String titulo, String descricao, LocalDate dataEntrega, String colaborador, int prioridade, String setorDaEmpresa) {
        super(titulo, descricao, dataEntrega);  // Chamando o construtor da classe Tarefa
        this.colaborador = colaborador;
        this.prioridade = prioridade;
        this.setorDaEmpresa = setorDaEmpresa;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getSetorDaEmpresa() {
        return setorDaEmpresa;
    }

    public void setSetorDaEmpresa(String setorDaEmpresa) {
        this.setorDaEmpresa = setorDaEmpresa;
    }

    @Override
    public String exibirDetalhes() {
        // Utilizando o método `exibirDetalhesBase()` da classe Tarefa
        return exibirDetalhesBase() +
               "\nColaborador: " + colaborador +
               "\nPrioridade: " + (prioridade == 1 ? "Alta" : prioridade == 2 ? "Média" : "Baixa") +
               "\nSetor da Empresa: " + setorDaEmpresa +
               "\n======Tarefa de Trabalho======" +
               "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TarefaDeTrabalho outraTarefa = (TarefaDeTrabalho) obj;
        return this.getTitulo().equals(outraTarefa.getTitulo());
    }
}
