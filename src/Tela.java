package src;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import static java.lang.Math.random;

public class Tela {

    String nomeBilheteiro;
    String nomeBilheteria;

    public Tela() {}

    public void clicouCancelar() {
        System.out.println("Encerrando a bilheteria.");
        System.exit(0);
    }

    public Bilheteria criaBilheteria(Bilheteria bilheteria) {

        JOptionPane.showMessageDialog(null,
                "Caro bilheteiro(a), vamos trabalhar!",
                "Bem vindo!!",
                JOptionPane.PLAIN_MESSAGE);

        nomeBilheteiro = JOptionPane.showInputDialog("Qual é o seu nome?");
        if (nomeBilheteiro == null) clicouCancelar();

        nomeBilheteria = JOptionPane.showInputDialog(nomeBilheteiro + ", qual o nome da bilheteria?");
        if (nomeBilheteria == null) clicouCancelar();

        bilheteria = new Bilheteria(nomeBilheteria);

        JOptionPane.showMessageDialog(null,
                nomeBilheteiro + ", vamos abrir a " + bilheteria.getNome() + "!!");

        return bilheteria;
    }

    public String menu() {

        String opcao;

        String[] possibilities = {"Cadastrar evento",
                "Vender ingresso",
                "Listar eventos",
                "Extrato e receita de um evento",
                "Fechar"};

        opcao = (String) JOptionPane.showInputDialog(
                null,
                "O que você quer fazer?",
                "Menu inicial",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Escolha");

        //Clicou em cancelar
        if (opcao == null) clicouCancelar();
        return opcao;
    }

    public void criaEvento(Bilheteria bilheteria) {

        String tipo;
        String nome;
        String data;
        String hora;
        String local;
        float precoIngresso = 0;
        String buffer;

        String[] possibilities = {"Filme",
                "Concerto",
                "Teatro"};

        tipo = (String) JOptionPane.showInputDialog(
                null,
                "Qual o tipo de evento?",
                "Cadastrando evento",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Escolha");

        if (tipo == null) clicouCancelar();

        nome = JOptionPane.showInputDialog("Qual o nome do evento ?");
        if (nome == null) clicouCancelar();

        data = JOptionPane.showInputDialog("Qual a data do evento ? (dd/MM/yyyy)");
        if (data == null) clicouCancelar();

        hora = JOptionPane.showInputDialog("Qual a hora do evento ? (hh:mm)");
        if (hora == null) clicouCancelar();

        local = JOptionPane.showInputDialog("Qual o local do evento ?");
        if (local == null) clicouCancelar();

        buffer = JOptionPane.showInputDialog("Qual o preco do ingresso do evento ? (float)");

        if (buffer == null) clicouCancelar();

        try {
            assert buffer != null;
            precoIngresso = Float.parseFloat(buffer);
        } catch (NumberFormatException e) {
            System.out.println("Erro na entrada");
        }

        assert tipo != null;
        bilheteria.criarEvento(tipo, nome, data, hora, local, precoIngresso);
    }

    public void venderIngresso(Bilheteria bilheteria) {

        if(bilheteria.getEventos().size() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Nao ha nenhum evento cadastrado",
                    "Vendendo ingressos",
                    JOptionPane.PLAIN_MESSAGE);

            return;
        }

        String[] possibilities = new String[bilheteria.getEventos().size()];
        String nomeEvento;

        for (int i = 0; i < bilheteria.getEventos().size(); i++) {
            possibilities[i] = bilheteria.getEventos().get(i).getNome();
        }

        nomeEvento = (String) JOptionPane.showInputDialog(
                null,
                "Ingresso de qual evento?",
                "Vendendo ingresso",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Escolha");

        if (nomeEvento == null) clicouCancelar();

        Evento evento = bilheteria.procuraEvento(nomeEvento);

        String[] possibilities2 = {"Normal",
                "Meia Entrada",
                "VIP"};

        String tipo = (String) JOptionPane.showInputDialog(
                null,
                "Qual tipo de ingresso?",
                "Vendendo ingresso",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities2,
                "Escolha");

        //Clicou em cancelar
        if (tipo == null) clicouCancelar();

        bilheteria.venderIngresso(tipo, evento);
    }

    public void listarEventos(Bilheteria bilheteria) {
        bilheteria.listarEventos();

        JOptionPane.showMessageDialog(null,
                nomeBilheteiro + ", a lista foi impresa no terminal.",
                "Lista de eventos",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void fechar(@NotNull Bilheteria bilheteria) {
        JOptionPane.showMessageDialog(null,
                "Até mais " + nomeBilheteiro + ", caro bilheteiro(a). Tenha um otimo dia!",
                "Fechando a " + bilheteria.getNome(),
                JOptionPane.PLAIN_MESSAGE);
    }

    public String getNomeBilheteiro() { return nomeBilheteiro; }

    public String getNomeBilheteria() { return nomeBilheteria; }

    public void setNomeBilheteiro(String nomeBilheteiro) { this.nomeBilheteiro = nomeBilheteiro; }

    public void setNomeBilheteria(String nomeBilheteria) { this.nomeBilheteria = nomeBilheteria; }
}
