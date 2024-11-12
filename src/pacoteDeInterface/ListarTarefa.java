package pacoteDeInterface;

import java.util.List;
import pacoteDeNegocios.Tarefa;

public class ListarTarefa {

    // Método para listar todas as tarefas
    public void listarTarefas(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas a serem listadas.");
        } else {
            System.out.println("\n| Lista de Tarefas:\n");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa.exibirDetalhes());
            }
        }
    }

    // Método para listar tarefas concluídas
    public void listarTarefasConcluidas(List<Tarefa> tarefas) {
        System.out.println("\n| Tarefas Concluídas:\n");
        boolean encontrouConcluidas = false;
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                System.out.println(tarefa.exibirDetalhes());
                encontrouConcluidas = true;
            }
        }
        
        if (!encontrouConcluidas) {
            System.out.println("Não há tarefas concluídas.");
        }
        
    }

    // Método para listar tarefas pendentes
    public void listarTarefasPendentes(List<Tarefa> tarefas) {
        System.out.println("\n| Tarefas Pendentes:");
        boolean encontrouPendentes = false;

        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                System.out.println(tarefa.exibirDetalhes());
                encontrouPendentes = true;
            }
        }

        if (!encontrouPendentes) {
            System.out.println("Não há tarefas pendentes.");
        }

    }
}
