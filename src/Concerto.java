package src;

import java.util.Date;

public class Concerto extends Evento {

    private int ingressoVIPvendidos;

    public Concerto(String nome, String data, String hora, String local, float precoIngresso) {

        super(nome, data, hora, local, precoIngresso);
        super.setCapacidade(150);
        ingressoVIPvendidos = 0;
    }

    @Override
    public boolean taDisponivel(String tipoIngresso) {

        if(super.disponibilidade() <= 0) return false;

        if(tipoIngresso.equals("VIP")) {
            return !(ingressoVIPvendidos >= super.getCapacidade() * 0.10);
        }
        return true;
    }

    @Override
    public boolean venderIngresso(@org.jetbrains.annotations.NotNull Ingresso novoIngresso) {

        if(taDisponivel(novoIngresso.getTipo())) {
            this.ingressosVendidos.add(novoIngresso);
            ingressoVIPvendidos++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tipo: Concerto\n" +
                super.toString();
    }
}
