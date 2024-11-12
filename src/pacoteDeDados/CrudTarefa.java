package pacoteDeDados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pacoteDeNegocios.Tarefa;
import pacoteDeNegocios.TarefaDeTrabalho;
import pacoteDeNegocios.TarefaPessoal;

public class CrudTarefa {
    private List<Tarefa> tarefas;
    Scanner scanner = new Scanner(System.in);

    public CrudTarefa() {
        this.tarefas = new ArrayList<>();
    }

    // Método para marcar uma tarefa como concluída
    public boolean marcarComoConcluida(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                tarefa.marcarComoConcluida();
                return true;
            }
        }
        return false;
    }

    // Método para buscar e exibir detalhes de uma tarefa pelo título
    public boolean buscarTarefa(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                System.out.println(tarefa.exibirDetalhes());
                return true;
            }
        }
        return false;
    }

    // Método para criar uma nova TarefaDeTrabalho
    public void criarTarefaDeTrabalho(String titulo, String descricao, LocalDate dataEntrega, String colaborador, int prioridade, String status) {
        Tarefa novaTarefa = new TarefaDeTrabalho(titulo, descricao, dataEntrega, colaborador, prioridade, status);
        tarefas.add(novaTarefa);
    }

    // Método para criar uma nova TarefaPessoal
    public void criarTarefaPessoal(String titulo, String descricao, LocalDate dataEntrega, String categoria, int prioridade) {
        Tarefa novaTarefa = new TarefaPessoal(titulo, descricao, dataEntrega, categoria, prioridade);
        tarefas.add(novaTarefa);
    }

    // Método para editar uma tarefa
    public boolean editarTarefa(String tituloExistente, String novoTitulo, String novaDescricao, LocalDate novaDataEntrega, String novaCategoria, int novaPrioridade, String novoLocal) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para serem editadas.");
            return false;
        } else {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getTitulo().equals(tituloExistente)) {
                    // Remover a tarefa existente e adicionar uma nova
                    tarefas.remove(tarefa);
                    tarefas.add(new TarefaPessoal(novoTitulo, novaDescricao, novaDataEntrega, novaCategoria, novaPrioridade));
                    System.out.println("Tarefa editada: " + novoTitulo);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean editarTarefaDeTrabalho(String tituloExistente, String novoTitulo, String novaDescricao, LocalDate novaDataEntrega, int novaPrioridade, String novoColaborador, String novoStatus) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para serem editadas.");
            return false;
        } else {
            for (Tarefa tarefa : tarefas) {
                if (tarefa instanceof TarefaDeTrabalho && tarefa.getTitulo().equals(tituloExistente)) {
                    // Verificar se a nova prioridade é válida
                    if (novaPrioridade < 1 || novaPrioridade > 3) {
                        System.out.println("Prioridade inválida. A prioridade deve ser 1, 2 ou 3.");
                        return false;
                    }

                    // Remover a tarefa de trabalho existente
                    tarefas.remove(tarefa);
                    // Criar e adicionar a nova tarefa de trabalho com a nova prioridade
                    tarefas.add(new TarefaDeTrabalho(novoTitulo, novaDescricao, novaDataEntrega, novoColaborador, novaPrioridade, novoStatus));
                    System.out.println("Tarefa de trabalho editada: " + novoTitulo);
                    return true;
                }
            }
        }
        return false;
    }


    public Tarefa getTarefaPorTitulo(String titulo) {
        for (Tarefa tarefa : tarefas) { 
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                return tarefa;
            }
        }
        return null; 
    }

    // Método para remover uma tarefa
    public boolean removerTarefa(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                tarefas.remove(tarefa);
                System.out.println("Tarefa removida: " + titulo);
                return true;
            }
        }
        return false;
    }

    // Getter para obter a lista de tarefas
    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
