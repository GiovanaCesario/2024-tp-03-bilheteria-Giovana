package src;

import java.util.Date;

public class Teatro extends Evento {

    private int ingressoMeiaVendidos;

    public Teatro(String nome, String data, String hora, String local, float precoIngresso) {

        super(nome, data, hora, local, precoIngresso);
        super.setCapacidade(250);
        ingressoMeiaVendidos = 0;
    }

    @Override
    public boolean taDisponivel(String tipoIngresso) {

        if(super.disponibilidade() <= 0) return false;

        if(tipoIngresso.equals("Meia Entrada")) {
            return !(ingressoMeiaVendidos >= super.getCapacidade() * 0.20);
        }
        return true;
    }

    @Override
    public boolean venderIngresso(@org.jetbrains.annotations.NotNull Ingresso novoIngresso) {

        if (taDisponivel(novoIngresso.getTipo())) {
            this.ingressosVendidos.add(novoIngresso);
            ingressoMeiaVendidos++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tipo: Teatro\n" +
                super.toString();
    }
}
