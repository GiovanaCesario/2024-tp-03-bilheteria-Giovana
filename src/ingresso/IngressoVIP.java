package src.ingresso;

public class IngressoVIP extends Ingresso {

    public IngressoVIP(float valor) {

        //O valor do ingresso VIP é o dobro do valor do ingresso normal
        super(valor * 2);
        super.setTipo("VIP");
    }
}
