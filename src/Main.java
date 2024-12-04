package src;

import javax.swing.*;

public class Main {

    public static void main(String args[]) {

        Bilheteria bilheteria = null;
        Tela tela = new Tela();
        String opcao;

        bilheteria = tela.criaBilheteria(bilheteria);

        do {
            opcao = tela.menu();

            switch (opcao) {
                case "Cadastrar evento" :
                    tela.criaEvento(bilheteria);
                    break;
                case "Vender ingresso" :
                    tela.venderIngresso(bilheteria);
                    break;
                case "Listar eventos" :
                    tela.listarEventos(bilheteria);
                    break;
                case "Extrato e receita de um evento" :
                    break;
                case "Fechar" :
                    tela.fechar(bilheteria);
                    break;
                default:
                    break;
            }

        } while(!opcao.equals("Fechar"));
    }
}
