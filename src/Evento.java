// tipo da hora

package src;

import java.util.Date;

public abstract class Evento {

    private String nome;
    private Date data;
    private String hora;
    private String local;
    private int quantIngressos;
    private float precoIngresso;

    public Evento(String nome, Date data, String hora, String local, float precoIngresso) {

        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.precoIngresso = precoIngresso;
    }

    public String getNome() { return nome; }

    public Date getData() { return data; }

    public String getHora() { return hora; }

    public String getLocal() { return local; }

    public int getQuantIngressos() { return quantIngressos; }


    public void setNome(String nome) { this.nome = nome; }

    public void setData(Date data) { this.data = data; }

    public void setHora(String hora) { this.hora = hora; }

    public void setLocal(String local) { this.local = local; }

    public void setQuantIngressos(int quantIngressos) { this.quantIngressos = quantIngressos; }
}
