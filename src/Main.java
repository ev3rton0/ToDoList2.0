import pacoteDeInterface.GerenciadorDeTarefas;

import pacoteDeInterface.AsciiArt;

public class Main {
    public static void main(String[] args) {
            AsciiArt asciiArt = new AsciiArt();
            System.out.println(asciiArt.getImprimirTitulo());
            GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas();
            gerenciadorDeTarefas.executar();
        }
}
