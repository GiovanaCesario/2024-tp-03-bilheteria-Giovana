package src.bilheteria;

import src.eventos.Concerto;
import src.eventos.Evento;
import src.eventos.Filme;
import src.eventos.Teatro;
import src.ingresso.Ingresso;
import src.ingresso.IngressoMeiaEntrada;
import src.ingresso.IngressoVIP;

import java.util.ArrayList;
import java.util.List;

public class Bilheteria {

    private String nome;
    private List<Evento> eventos;

    public Bilheteria(String nome) {
        this.nome = nome;
        eventos = new ArrayList<>();
    }

    //Cadastro de eventos
    public void criarEvento(String tipo, String nome, String data, String hora, String local, float precoIngresso) {

        switch (tipo) {
            case "Filme":
                eventos.add(new Filme(nome, data, hora, local, precoIngresso));
                break;
            case "Concerto":
                eventos.add(new Concerto(nome, data, hora, local, precoIngresso));
                break;
            case "Teatro":
                eventos.add(new Teatro(nome, data, hora, local, precoIngresso));
            default:
                break;
        }
    }

    //Venda de ingressos
    public boolean venderIngresso(String tipoIngresso, Evento evento) {

        return switch (tipoIngresso) {
            case "VIP" -> evento.venderIngresso(new IngressoVIP(evento.getPrecoIngresso()));
            case "Meia Entrada" -> evento.venderIngresso(new IngressoMeiaEntrada(evento.getPrecoIngresso()));
            case "Normal" -> evento.venderIngresso(new Ingresso(evento.getPrecoIngresso()));
            default -> false;
        };
    }

    public float cauculaReceita() {

        float total = 0;

        for(Evento atual : eventos) {
            total += atual.cauculaReceita();
        }
        return total;
    }

    public void exibeReceita() {

        System.out.println("=== Receita total de " + this.nome + ":\t" + cauculaReceita() + " ===");
    }

    //Exibiçao de eventos
    public void listarEventos() {

        System.out.println("=== Eventos ===");

        for(Evento atual: eventos) {
            System.out.println("-----");
            System.out.println(atual.toString());
            System.out.println("Ingressos vendidos: " + atual.getIngressosVendidos().size());
            System.out.println("Ingressos disponiveis: " + atual.disponibilidade());
        }
        System.out.println();
        exibeReceita();
    }

    public Evento procuraEvento(String nome) {

        for(Evento atual : eventos) {
            if(atual.getNome().equals(nome)) {
                return atual;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Bilheteria bilheteria;
        Tela tela = new Tela();
        String opcao;

        bilheteria = tela.criaBilheteria();

        do {
            opcao = tela.exibeMenu();

            switch (opcao) {
                case "Cadastrar evento" :
                    tela.criaEvento(bilheteria);
                    break;

                case "Vender ingresso" :
                    tela.venderIngresso(bilheteria);
                    break;

                case "Listar eventos" :

                    if(bilheteria.getEventos().isEmpty()) {
                        tela.mensagemListarEventos(false);
                    } else {
                        bilheteria.listarEventos();
                        tela.mensagemListarEventos(true);
                    }
                    break;

                case "Extrato e receita de um evento" :
                    tela.extratoReceitaEvento(bilheteria);
                    break;

                case "Receita total da bilheteria" :
                    bilheteria.exibeReceita();
                    tela.mensagemReceitaTotal(bilheteria.getNome());
                    break;

                case "Fechar" :
                    tela.mensagemFechar(bilheteria.getNome());
                    break;
                default:
                    break;
            }
        } while(!opcao.equals("Fechar"));
    }

    public String getNome() { return nome; }

    public List<Evento> getEventos() { return eventos; }


    public void setNome(String nome) { this.nome = nome; }

    public void setEventos(List<Evento> eventos) { this.eventos = eventos; }
}
