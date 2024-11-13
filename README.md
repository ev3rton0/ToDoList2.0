## To-Do List em Java ✅📚

> Este projeto consiste em um aprimoramento de um gerenciador de tarefas, permitindo que o usuário registre, edite, remova, marque como concluída e liste tarefas. Ele foi desenvolvido utilizando os conceitos de Programação Orientada a Objetos em Java, com uma estrutura modular e utilizando padrões de design para melhorar a manutenção e escalabilidade.

## Funcionalidades
As funcionalidades principais do projeto são as seguintes:

- `Criar tarefas`
    - `Criar Tarefa Pessoal`
    - `Criar Tarefa de Trabalho`
- `Editar tarefas`
- `Remover tarefas`
- `Marcar como Concluída`
- `Listar Todas as Tarefas`
- `Listar Tarefas Concluídas`
- `Listar Tarefas Pendentes`

Além dessas funcionalidades principais, o projeto foi estruturado com a aplicação de conceitos como  **ocultação de informação, herança, polimorfismo e padrão de design fachada** proporcionando uma arquitetura bem organizada e fácil de entender.

## Arquitetura do Sistema
O sistema foi dividido em diferentes pacotes para organizar melhor as responsabilidades do código. A arquitetura inclui:

- `Pacote tipoDeDados`: Responsável pelas classes de dados, como a classe abstrata **Tarefa**, que representa as tarefas e sua subclasses **TarefaDeTrabalho** e **TarefaPessoal**.

- `Pacote tipoDeNegocios`: Contém as classes de lógica de negócios e regras de operação, como **CrudTarefa**.

- `Pacote tipoDeInterface`: Contém a classe responsável pela interação com o usuário via terminal, **ListarTarefa** e o **GerenciadorDeTarefasFacade** que exibe as tarefas de acordo com os critérios escolhidos.

## Padrão de Design: Fachada
A implementação do padrão Fachada tem como objetivo simplificar a interface com o sistema para os usuários. A classe `GerenciadorDeTarefasFacade` centraliza todas as operações complexas e oferece uma interface mais simples e amigável para o usuário, permitindo-lhe interagir com o sistema de maneira eficiente e sem a necessidade de conhecer a complexidade interna do código.

## Exemplo de Execução
> O programa começa com a execução da classe Main, onde o usuário pode acessar um menu interativo e escolher as operações que deseja realizar, como criar novas tarefas, editá-las, removê-las ou visualizá-las. O fluxo de execução é gerido através da fachada, que encaminha as solicitações para os componentes adequados.

## Stakeholders
O projeto permite a diferenciação de usuários, com dois tipos principais:

- `Administrador`: Tem acesso a todas as funcionalidades do sistema, incluindo criar, editar, remover e listar tarefas.
- `Leitor`: Tem acesso apenas para visualizar e listar as tarefas, sem possibilidade de modificá-las.
Essas permissões são gerenciadas de forma eficaz para garantir a segurança e a integridade dos dados.

## Diagrama das Classes
![alt text](<Diagrama de casos de uso .png>)

### Tecnologias Utilizadas
- Linguagem: Java
- Padrões de Design: Fachada, Herança, Polimorfismo
- Paradigma de Programação: Programação Orientada a Objetos (POO)


## Informações
Esse projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos no curso de Ciência da Computação da Universidade Federal do Cariri (UFCA).

Para mais detalhes sobre a implementação, o documento explicativo sobre o processo de desenvolvimento está disponível no repositório.

## Desenvolvido por:
>Arthur Ricardo Macêdo Pereira
Everton Lohan Pereira Ferreira
