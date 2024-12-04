package src.bilheteria;

import src.eventos.Evento;

import javax.swing.*;

public class Tela {

    String nomeBilheteiro = "Bilheteiro";
    String nomeBilheteria = "Bilheteria";

    public Tela() {}

    //Se a pessoa clicar em cancelar no menu ou antes encerra a bilheteria
    public void clicouCancelar() {
        mensagemFechar(nomeBilheteria);
        System.out.println("Encerrando a bilheteria.");
        System.exit(0);
    }

    public Bilheteria criaBilheteria() {

        Bilheteria bilheteria;

        JOptionPane.showMessageDialog(null,
                "Caro bilheteiro(a), vamos trabalhar!",
                "Bem vindo!!",
                JOptionPane.PLAIN_MESSAGE);

        nomeBilheteiro = JOptionPane.showInputDialog("Qual é o seu nome?");
        if (nomeBilheteiro == null) {
            nomeBilheteiro = "Bilheteiro";
            clicouCancelar();
        }

        nomeBilheteria = JOptionPane.showInputDialog(nomeBilheteiro + ", qual o nome da bilheteria?");
        if (nomeBilheteria == null) clicouCancelar();

        bilheteria = new Bilheteria(nomeBilheteria);

        JOptionPane.showMessageDialog(null,
                nomeBilheteiro + ", vamos abrir a " + bilheteria.getNome() + "!!");

        return bilheteria;
    }

    public String exibeMenu() {

        String opcao;

        String[] possibilities = {"Cadastrar evento",
                "Vender ingresso",
                "Listar eventos",
                "Extrato e receita de um evento",
                "Receita total da bilheteria",
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

        if (tipo == null) return; //Se apertou em cancelar volta para o menu

        nome = JOptionPane.showInputDialog("Qual o nome do evento?");
        if (nome == null) return; //Se apertou em cancelar volta para o menu

        data = JOptionPane.showInputDialog("Qual a data do evento? (dd/MM/yyyy)");
        if (data == null) return; //Se apertou em cancelar volta para o menu

        hora = JOptionPane.showInputDialog("Qual a hora do evento?");
        if (hora == null) return; //Se apertou em cancelar volta para o menu

        local = JOptionPane.showInputDialog("Qual o local do evento ?");
        if (local == null) return; //Se apertou em cancelar volta para o menu

        buffer = JOptionPane.showInputDialog("Qual o preco do ingresso do evento? (float)");
        if (buffer == null) return; //Se apertou em cancelar volta para o menu

        //Passa o preco de String para float
        try {
            precoIngresso = Float.parseFloat(buffer);
        } catch (NumberFormatException e) {
            System.out.println("Erro na entrada");
        }

        bilheteria.criarEvento(tipo, nome, data, hora, local, precoIngresso);

        //Se a data for invalida nao cadastra o evento
        if(bilheteria.getEventos().get(bilheteria.getEventos().size() - 1).getData() == null) {

            bilheteria.getEventos().remove(bilheteria.getEventos().size() - 1);

            JOptionPane.showMessageDialog(null,
                    "Evento nao cadastrado, data invalida",
                    "Cadastrando evento",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Evento cadastrado com sucesso!",
                    "Cadastrando evento",
                    JOptionPane.PLAIN_MESSAGE);

        }
    }

    //Quando o usuario precisa escolher entre eventos ja existentes
    public Evento achaEvento(Bilheteria bilheteria, String fazendo) {

        if(bilheteria.getEventos().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nao ha nenhum evento cadastrado",
                    fazendo,
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String[] possibilities = new String[bilheteria.getEventos().size()];
        String nomeEvento;

        for (int i = 0; i < bilheteria.getEventos().size(); i++) {
            possibilities[i] = bilheteria.getEventos().get(i).getNome();
        }

        nomeEvento = (String) JOptionPane.showInputDialog(
                null,
                "Qual o evento?",
                fazendo,
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Escolha");

        if (nomeEvento == null) return null;

        return bilheteria.procuraEvento(nomeEvento);
    }


    public void venderIngresso(Bilheteria bilheteria) {

        Evento evento = achaEvento(bilheteria, "Vendendo ingressos");
        if(evento == null) return;

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

        if (tipo == null) return; //Clicou em cancelar

        //Verifica se a venda foi possivel e informa o usuario
        if (bilheteria.venderIngresso(tipo, evento)) {
            JOptionPane.showMessageDialog(null,
                    "Venda realizada com sucesso! \nValor: " +
                            evento.getIngressosVendidos().get(evento.getIngressosVendidos().size() - 1).getValor(),
                    "Sucesso",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Venda não pode ser realizada, sem ingressos desse tipo disponiveis.",
                    "Erro na venda",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mensagemListarEventos(boolean listou) {

        if(!listou) {
            JOptionPane.showMessageDialog(null,
                    "Nao ha nenhum evento cadastrado",
                    "Listando eventos",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    nomeBilheteiro + ", a lista foi impresa no terminal.",
                    "Lista de eventos",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }


    public void extratoReceitaEvento(Bilheteria bilheteria) {

        Evento evento = achaEvento(bilheteria, "Obtendo extrato e receita de evento");
        if (evento != null) {
            evento.extratoReceita();

            JOptionPane.showMessageDialog(null,
                    nomeBilheteiro + ", o extrato e receita de "
                            + evento.getNome() + " foi impreso no terminal.",
                    "Obtendo extrato e receita de evento",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }


    public void mensagemReceitaTotal(String nomeBilheteria) {

        JOptionPane.showMessageDialog(null,
                nomeBilheteiro + ", a receita de "
                        + nomeBilheteria + " foi impressa no terminal.",
                "Obtendo a receita da bilheteria",
                JOptionPane.PLAIN_MESSAGE);
    }


    public void mensagemFechar(String nomeBilheteria) {
        JOptionPane.showMessageDialog(null,
                "Até mais " + nomeBilheteiro + ", caro bilheteiro(a). Tenha um otimo dia!",
                "Fechando a " + nomeBilheteria,
                JOptionPane.PLAIN_MESSAGE);
    }


    public String getNomeBilheteiro() { return nomeBilheteiro; }

    public String getNomeBilheteria() { return nomeBilheteria; }

    public void setNomeBilheteiro(String nomeBilheteiro) { this.nomeBilheteiro = nomeBilheteiro; }

    public void setNomeBilheteria(String nomeBilheteria) { this.nomeBilheteria = nomeBilheteria; }
}
