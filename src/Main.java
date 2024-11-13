import pacoteDeInterface.GerenciadorDeTarefasFacade;

import pacoteDeInterface.AsciiArt;

public class Main {
    public static void main(String[] args) {
            AsciiArt asciiArt = new AsciiArt();
            System.out.println(asciiArt.getImprimirTitulo());
            GerenciadorDeTarefasFacade gerenciadorDeTarefas = new GerenciadorDeTarefasFacade();
            gerenciadorDeTarefas.executar();
        }
}
