package src;

import java.util.Date;

public class Filme extends Evento {

    public Filme(String nome, String data, String hora, String local, float precoIngresso) {

        super(nome, data, hora, local, precoIngresso);
        super.setCapacidade(200);
    }

    @Override
    public boolean taDisponivel(String tipoIngresso) {

        if(super.disponibilidade() <= 0) return false;

        return !tipoIngresso.equals("VIP");
    }

    @Override
    public float venderIngresso(@org.jetbrains.annotations.NotNull Ingresso novoIngresso) {

        if (taDisponivel(novoIngresso.getTipo())) {
            this.ingressosVendidos.add(novoIngresso);
        }
        return novoIngresso.getValor();
    }
}
