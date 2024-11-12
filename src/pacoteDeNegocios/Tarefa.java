package pacoteDeNegocios;

import java.time.LocalDate;

public abstract class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;

    // Construtor atualizado para incluir o parâmetro `dataEntrega`
    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.concluida = false;
    }

    // Método abstrato que será implementado nas subclasses
    public abstract String exibirDetalhes();

    public abstract int getPrioridade();

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public boolean isConcluida() {
        return concluida;
    }

    // Implementação do método `exibirDetalhes` padrão, para ser usado nas subclasses
    protected String exibirDetalhesBase() {
        return "Título: " + titulo +
               "\nDescrição: " + descricao +
               "\nData de Entrega: " + dataEntrega +
               "\nConcluída: " + (concluida ? "Sim" : "Não");
    }
}
