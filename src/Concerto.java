package src;

import java.util.Date;

public class Concerto extends Evento {

    public Concerto(String nome, Date data, String hora, String local, float precoIngresso) {

        super(nome, data, hora, local, precoIngresso);
        super.setQuantIngressos(150);
    }
}
