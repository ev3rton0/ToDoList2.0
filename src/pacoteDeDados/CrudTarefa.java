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

    
    public boolean marcarComoConcluida(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                tarefa.marcarComoConcluida();
                return true;
            }
        }
        return false;
    }

   
    public boolean buscarTarefa(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                System.out.println(tarefa.exibirDetalhes());
                return true;
            }
        }
        return false;
    }

    
    public void criarTarefaDeTrabalho(String titulo, String descricao, LocalDate dataEntrega, String colaborador, int prioridade, String setorDaEmpresa) {
        Tarefa novaTarefa = new TarefaDeTrabalho(titulo, descricao, dataEntrega, colaborador, prioridade, setorDaEmpresa);
        tarefas.add(novaTarefa);
    }

    
    public void criarTarefaPessoal(String titulo, String descricao, LocalDate dataEntrega, String categoria, int prioridade) {
        Tarefa novaTarefa = new TarefaPessoal(titulo, descricao, dataEntrega, categoria, prioridade);
        tarefas.add(novaTarefa);
    }

    
    public boolean editarTarefa(String tituloExistente, String novoTitulo, String novaDescricao, LocalDate novaDataEntrega,  int prioridade, String novaCategoria) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para serem editadas.");
            return false;
        } else {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getTitulo().equals(tituloExistente)) {
                    
                    tarefas.remove(tarefa);
                    tarefas.add(new TarefaPessoal(novoTitulo, novaDescricao, novaDataEntrega, novaCategoria, prioridade));
                    System.out.println("Tarefa editada: " + novoTitulo);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean editarTarefaDeTrabalho(String tituloExistente, String novoTitulo, String novaDescricao, LocalDate novaDataEntrega, int prioridade, String novoColaborador, String novoSetorDaEmpresa) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para serem editadas.");
            return false;
        } else {
            for (Tarefa tarefa : tarefas) {
                if (tarefa instanceof TarefaDeTrabalho && tarefa.getTitulo().equals(tituloExistente)) {
                    tarefas.remove(tarefa);
                    tarefas.add(new TarefaDeTrabalho(novoTitulo, novaDescricao, novaDataEntrega, novoColaborador,prioridade, novoSetorDaEmpresa));
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
    
    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
