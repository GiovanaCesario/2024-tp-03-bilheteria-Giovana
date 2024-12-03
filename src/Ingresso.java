package src;

import java.util.Date;

public class Ingresso {

    private Date dataVenda;
    private float valor;

    public Ingresso(float valor) {

        this.dataVenda = new Date();
        this.valor = valor;
    }

    public Date getDataVenda() { return dataVenda; }

    public float getValor() { return valor; }


    public void setDataVenda(Date dataVenda) { this.dataVenda = dataVenda; }

    public void setValor(float valor) { this.valor = valor; }
}
