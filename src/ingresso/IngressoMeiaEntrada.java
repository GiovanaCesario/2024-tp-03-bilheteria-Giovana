package src.ingresso;

public class IngressoMeiaEntrada extends Ingresso {

    public IngressoMeiaEntrada(float valor) {

        // O valor do ingresso de meia entrada é 50% do valor do ingresso normal
        super(valor/2);
        super.setTipo("Meia Entrada");
    }
}
