package src.ingresso;

import src.interfaces.IReceita;

import java.util.Date;

public class Ingresso implements IReceita {

    private Date dataVenda;
    private float valor;
    private String tipo;

    public Ingresso(float valor) {

        this.dataVenda = new Date();
        this.valor = valor;
        this.tipo = "Normal";
    }

    @Override
    public float cauculaReceita() {
        return this.valor;
    }

    @Override
    public void extratoReceita() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Data: " + dataVenda +
                "\t\tTipo: " + tipo +
                "\t\tReceita: " + cauculaReceita();
    }

    public Date getDataVenda() { return dataVenda; }

    public float getValor() { return valor; }

    public String getTipo() { return tipo; }


    public void setDataVenda(Date dataVenda) { this.dataVenda = dataVenda; }

    public void setValor(float valor) { this.valor = valor; }

    public void setTipo(String tipo) { this.tipo = tipo; }
}
