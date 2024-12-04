package src;

public class IngressoVIP extends Ingresso {

    public IngressoVIP(float valor) {

        super(valor * 2);
        super.setTipo("VIP");
    }
}
