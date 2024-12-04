package src;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Evento implements IReceita {

    private String nome;
    private Date data;
    private String hora;
    private String local;
    private int capacidade;
    private float precoIngresso;
    protected List<Ingresso> ingressosVendidos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Evento(String nome, String data, String hora, String local, float precoIngresso) {

        this.nome = nome;
        try{
            this.data = sdf.parse(data);
        }catch (Exception e){
            System.out.println("Erro na data");
        }
        this.hora = hora;
        this.local = local;
        this.precoIngresso = precoIngresso;
        this.ingressosVendidos = new ArrayList<>();
    }

    public int disponibilidade() {
        return this.capacidade - ingressosVendidos.size();
    }

    public abstract boolean taDisponivel(String tipo);

    public abstract boolean venderIngresso(Ingresso novoIngresso);

    @Override
    public float cauculaReceita() {

        float total = 0;
        for (Ingresso atual : ingressosVendidos) {
            total += atual.getValor();
        }
        return total;
    }

    @Override
    public void extratoReceita() {

        System.out.println("=== Extrato Evento " + this.nome + " ===\n");

        for(Ingresso atual : ingressosVendidos) {
            atual.extratoReceita();
        }

        System.out.println("Total: " +cauculaReceita());
        System.out.println("=================================");
    }

    @Override
    public String toString() {

        return  "Nome: " + nome + '\n' +
                "Data: " + data + '\n' +
                "Hora: " + hora + '\n' +
                "Local: " + local + '\n' +
                "Capacidade: " + capacidade + '\n' +
                "PrecoIngresso: " + precoIngresso + '\n' +
                "Receita: " +cauculaReceita() + '\n';
    }

    public String getNome() { return nome; }

    public Date getData() { return data; }

    public String getHora() { return hora; }

    public String getLocal() { return local; }

    public int getCapacidade() { return capacidade; }

    public float getPrecoIngresso() { return precoIngresso; }


    public void setNome(String nome) { this.nome = nome; }

    public void setData(Date data) { this.data = data; }

    public void setHora(String hora) { this.hora = hora; }

    public void setLocal(String local) { this.local = local; }

    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public void setPrecoIngresso(float precoIngresso) { this.precoIngresso = precoIngresso; }
}
