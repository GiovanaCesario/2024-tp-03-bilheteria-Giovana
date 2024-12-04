package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bilheteria {

    private String nome;
    private List<Evento> eventos;

    public Bilheteria(String nome) {
        this.nome = nome;
        eventos = new ArrayList<>();
    }

    //Cadastro de eventos
    public void criarEvento( String tipo, String nome, String data, String hora, String local, float precoIngresso) {

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
    public void venderIngresso(String tipoIngresso, Evento evento) {

        switch (tipoIngresso) {
            case "VIP":
                evento.venderIngresso(new IngressoVIP(evento.getPrecoIngresso()));
                break;
            case "Meia Entrada" :
                evento.venderIngresso(new IngressoMeiaEntrada(evento.getPrecoIngresso()));
                break;
            case "Normal" :
                evento.venderIngresso(new Ingresso(evento.getPrecoIngresso()));
                break;
            default:
                break;
        }
    }

    public float cauculaReceitaTotal() {

        float total = 0;

        for(Evento atual : eventos) {
            total += atual.cauculaReceita();
        }
        return total;
    }

    //Exibiçao de eventos
    public void listarEventos() {

        System.out.println("=== Eventos ===");

        for(Evento atual: eventos) {
            System.out.println("-----");
            System.out.println(atual.toString());
            System.out.println("Ingressos vendidos: " + atual.ingressosVendidos.size());
            System.out.println("Ingressos disponiveis: " + atual.disponibilidade());
        }
        System.out.println();
        System.out.println("=== Receita total de " + nome + ": " +cauculaReceitaTotal());
    }

    //Relatorio de receita e exibição de ingressos
    public void extratoReceitaEvento(Evento evento) {
        evento.extratoReceita();
    }

    public Evento procuraEvento(String nome) {

        for(Evento atual : eventos) {
            if(atual.getNome().equals(nome)) {
                return atual;
            }
        }
        return null;
    }

    public String getNome() { return nome; }

    public List<Evento> getEventos() { return eventos; }


    public void setNome(String nome) { this.nome = nome; }

    public void setEventos(List<Evento> eventos) { this.eventos = eventos; }
}
