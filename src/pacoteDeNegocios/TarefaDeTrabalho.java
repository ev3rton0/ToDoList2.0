package pacoteDeNegocios;

import java.time.LocalDate;

public class TarefaDeTrabalho extends Tarefa {
    private String colaborador;
    private int prioridade; 
    private String setorDaEmpresa; 

    public TarefaDeTrabalho(String titulo, String descricao, LocalDate dataEntrega, String colaborador, int prioridade, String setorDaEmpresa) {
        super(titulo, descricao, dataEntrega);  
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
        return exibirDetalhesBase() +
               "\n| Colaborador: " + colaborador + 
               "\n| Prioridade: " + (prioridade == 1 ? "Alta" : prioridade == 2 ? "Média" : "Baixa") + 
               "\n| Setor da Empresa: " + setorDaEmpresa + 
               "\n+------Tarefa de Trabalho------+\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TarefaDeTrabalho outraTarefa = (TarefaDeTrabalho) obj;
        return this.getTitulo().equals(outraTarefa.getTitulo());
    }
}
