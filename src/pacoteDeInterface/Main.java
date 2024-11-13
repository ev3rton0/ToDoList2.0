package pacoteDeInterface;

import pacoteDeDados.CrudTarefa;
import pacoteDeNegocios.Tarefa;
import pacoteDeNegocios.TarefaDeTrabalho;
import pacoteDeNegocios.TarefaPessoal;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class Main {

    
    public static void main(String[] args) {
        CrudTarefa crudTarefa = new CrudTarefa();
        ListarTarefa listarTarefa = new ListarTarefa();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Supondo que AsciiArt e TipoUsuario estão implementados corretamente
        AsciiArt asciiArt = new AsciiArt();
        System.out.println(asciiArt.getImprimirTitulo());

        TipoUsuario tipoUsuario = selecionarTipoUsuario(scanner);

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu(tipoUsuario);
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();  // Limpar o buffer
        
                switch (opcao) {
                    case 1:
                        if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
                            System.out.print("\nTítulo da Tarefa: ");
                            String tituloTarefa = scanner.nextLine().trim();
                            System.out.print("Descrição da Tarefa: ");
                            String descricaoTarefa = scanner.nextLine();
                            
                            LocalDate dataEntrega = null;
                            boolean dataValida = false;
                            
                            // Loop para pedir a data até que o usuário insira no formato correto
                            while (!dataValida) {
                                System.out.print("Data de Entrega (dd/MM/yyyy): ");
                                String dataEntregaStr = scanner.nextLine();
                                try {
                                    dataEntrega = LocalDate.parse(dataEntregaStr, formatter);
                                    dataValida = true;  // A data foi inserida corretamente
                                } catch (DateTimeParseException e) {
                                    System.out.println("Formato de data inválido. Por favor, insira no formato dd/MM/yyyy.");
                                }
                            }
        
                            int prioridade = 0;
                            boolean prioridadeValida = false;
                            while (!prioridadeValida) {
                                System.out.print("Prioridade:\n1 - (Alta)\n2 - (Media)\n3 - (Baixa)\n-> ");
                                try {
                                    prioridade = scanner.nextInt();
                                    if (prioridade < 1 || prioridade > 3) {
                                        throw new IllegalArgumentException("Prioridade fora do intervalo permitido.");
                                    }
                                    prioridadeValida = true;
                                } catch (InputMismatchException | IllegalArgumentException e) {
                                    System.out.println("Prioridade inválida! Por favor, escolha um número entre 1 e 3.");
                                    scanner.nextLine();  // Limpar o buffer para evitar loop infinito
                                }
                            }
                            scanner.nextLine();  // Limpar o buffer
                            criarTarefa(crudTarefa, tituloTarefa, descricaoTarefa, dataEntrega, prioridade, scanner);
                        } else {
                            System.out.println("Opção inválida para o usuário leitor.");
                        }
                        break;
                    case 2:
                        if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
                            editarTarefa(crudTarefa, scanner, formatter);
                        } else {
                            System.out.println("Opção inválida para o usuário leitor.");
                        }
                        break;
                    case 3:
                        if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
                            removerTarefa(crudTarefa, scanner);
                        } else {
                            System.out.println("Opção inválida para o usuário leitor.");
                        }
                        break;
                    case 4:
                        marcarComoConcluida(crudTarefa, scanner);
                        break;
                    case 5:
                        listarTarefa.listarTarefas(crudTarefa.getTarefas());
                        break;
                    case 6:
                        listarTarefa.listarTarefasConcluidas(crudTarefa.getTarefas());
                        break;
                    case 7:
                        listarTarefasPendentesPorPrioridade(crudTarefa.getTarefas(), listarTarefa);
                        break;
                    case 8:
                        tipoUsuario = selecionarTipoUsuario(scanner);
                        break;
                    case 0:
                        System.out.println("Finalizando...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida! Por favor, insira um número.");
                scanner.nextLine();  // Limpar o buffer para evitar loop infinito
            }
        }
        
        scanner.close();
    }


    private static TipoUsuario selecionarTipoUsuario(Scanner scanner) {
        int escolha = -1;
        
        while (true) {
            try {
                System.out.println("| 1. Administrador");
                System.out.println("| 2. Leitor");
                System.out.println("\nSelecione o tipo de usuário:");
                
                escolha = scanner.nextInt();
                scanner.nextLine();  // Limpar o buffer
                
                if (escolha == 1) {
                    return TipoUsuario.ADMINISTRADOR;
                } else if (escolha == 2) {
                    return TipoUsuario.LEITOR;
                } else {
                    System.out.println("Opção inválida. Por favor, escolha 1 para Administrador ou 2 para Leitor.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpa a entrada inválida do scanner
            }
        }
    }

    private static void exibirMenu(TipoUsuario tipoUsuario) {
        System.out.println("\n------To-Do List------");
        if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
            System.out.println("| 1. Criar Tarefa");
            System.out.println("| 2. Editar Tarefa");
            System.out.println("| 3. Remover Tarefa");
        }
        System.out.println("| 4. Marcar Tarefa como Concluída");
        System.out.println("| 5. Listar Todas as Tarefas");
        System.out.println("| 6. Listar Tarefas Concluídas");
        System.out.println("| 7. Listar Tarefas Pendentes");
        System.out.println("| 8. Mudar Tipo de Usuário");
        System.out.println("| 0. Finalizar\n");
    }


    private static void criarTarefa(CrudTarefa crudTarefa, String titulo, String descricao, LocalDate dataEntrega, int prioridade, Scanner scanner) {
        int tipo = 0;
        boolean tipoValido = false;
    
        while (!tipoValido) {
            System.out.println("Escolha o tipo de tarefa:");
            System.out.println("1. Tarefa de Trabalho");
            System.out.println("2. Tarefa Pessoal");
    
            try {
                tipo = scanner.nextInt();
                scanner.nextLine();  // Limpar o buffer
    
                if (tipo == 1 || tipo == 2) {
                    tipoValido = true;  // Valor válido, sair do loop
                } else {
                    System.out.println("Entrada inválida! Por favor, insira um número (1 ou 2).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número (1 ou 2).\n");
                scanner.nextLine();  // Limpar o buffer para evitar loop infinito
            }
        }
    
        if (tipo == 1) {
            System.out.print("Colaborador: ");
            String colaborador = scanner.nextLine();
            System.out.print("Setor da Empresa (Ex: Administrativo): ");
            String setorDaEmpresa = scanner.nextLine();
            crudTarefa.criarTarefaDeTrabalho(titulo, descricao, dataEntrega, colaborador, prioridade, setorDaEmpresa);
        } else {
            System.out.print("Categoria: ");
            String categoria = scanner.nextLine();
            crudTarefa.criarTarefaPessoal(titulo, descricao, dataEntrega, categoria, prioridade);
        }

        System.out.println("Tarefa criada com sucesso!");

    }
    

    private static void editarTarefa(CrudTarefa crudTarefa, Scanner scanner, DateTimeFormatter formatter) {
            System.out.print("\nTítulo da Tarefa a ser editada: ");
            String titulo1 = scanner.nextLine();
            
            // Verifica se a tarefa existe
            if (crudTarefa.buscarTarefa(titulo1)) {
                Tarefa tarefa = crudTarefa.getTarefaPorTitulo(titulo1);
        
                // Pergunta os valores gerais
                System.out.print("Novo Título da Tarefa: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Nova Descrição da Tarefa: ");
                String novaDescricao = scanner.nextLine();
                System.out.print("Nova Data de Entrega (dd/MM/yyyy): ");
                String novaDataEntregaStr = scanner.nextLine();
                LocalDate novaDataEntrega = LocalDate.parse(novaDataEntregaStr, formatter);
        
                if (tarefa instanceof TarefaDeTrabalho) {
                    //TarefaDeTrabalho tarefaTrabalho = (TarefaDeTrabalho) tarefa;
        
                    System.out.print("Novo Colaborador: ");
                    String novoColaborador = scanner.nextLine();
                    System.out.print("Nova Prioridade (1 - Alta, 2 - Média, 3 - Baixa): ");
                    int novaPrioridade = scanner.nextInt();
                    scanner.nextLine(); // Consome o \n após o int
                    System.out.print("Novo Status: ");
                    String novoStatus = scanner.nextLine();
        
                    crudTarefa.editarTarefaDeTrabalho(titulo1, novoTitulo, novaDescricao, novaDataEntrega, novaPrioridade, novoColaborador, novoStatus);
        
                } else if (tarefa instanceof TarefaPessoal) {
                    //TarefaPessoal tarefaPessoal = (TarefaPessoal) tarefa;
        
                    System.out.print("Nova Categoria: ");
                    String novaCategoria = scanner.nextLine();
                    System.out.print("Nova Prioridade (1 - Alta, 2 - Média, 3 - Baixa): ");
                    int novaPrioridade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo Status: ");
                    String novoStatus = scanner.nextLine();
        
                    crudTarefa.editarTarefa(titulo1, novoTitulo, novaDescricao, novaDataEntrega, novaCategoria, novaPrioridade, novoStatus);
                }
            } else {
                System.out.println("Tarefa não encontrada.");
            }
        }

    private static void removerTarefa(CrudTarefa crudTarefa, Scanner scanner) {
        System.out.print("\nTítulo da Tarefa a ser removida: ");
        String titulo = scanner.nextLine();
        if(crudTarefa.removerTarefa(titulo)) {
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!.");
        }
    }

    private static void marcarComoConcluida(CrudTarefa crudTarefa, Scanner scanner) {
        System.out.print("\nTítulo da Tarefa a ser marcada como concluída: ");
        String titulo2 = scanner.nextLine();
        boolean marcar = crudTarefa.marcarComoConcluida(titulo2);
        if (!marcar) {
            System.out.println("Tarefa não encontrada!.");
        } else{
            System.out.println("Tarefa marcada como concluída com sucesso!");
        }
    }

    private static void listarTarefasPendentesPorPrioridade(List<Tarefa> tarefas, ListarTarefa listarTarefa) {
    // Ordenar tarefas pendentes por prioridade decrescente
    List<Tarefa> tarefasPendentes = tarefas.stream()
            .filter(t -> !t.isConcluida())  // Filtra as tarefas que ainda não foram concluídas
            .sorted(Comparator.comparingInt(Tarefa::getPrioridade).reversed())  // Ordena por prioridade decrescente
            .collect(Collectors.toList());  // Converte para uma lista

    listarTarefa.listarTarefasPendentes(tarefasPendentes);
  }
}


