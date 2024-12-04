package src.eventos;

import src.ingresso.Ingresso;

public class Filme extends Evento {

    public Filme(String nome, String data, String hora, String local, float precoIngresso) {

        super(nome, data, hora, local, precoIngresso);
        super.setCapacidade(200);
    }

    @Override
    public boolean taDisponivel(String tipoIngresso) {

        if(super.disponibilidade() <= 0) return false;

        // Cinema não deve permitir a compra de ingressos VIP
        return !tipoIngresso.equals("VIP");
    }

    @Override
    public boolean venderIngresso(@org.jetbrains.annotations.NotNull Ingresso novoIngresso) {

        if (taDisponivel(novoIngresso.getTipo())) {
            this.ingressosVendidos.add(novoIngresso);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tipo: Filme\n" +
                super.toString();
    }
}
