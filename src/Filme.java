package src;

import java.util.Date;

public class Filme extends Evento {

    public Filme(String nome, Date data, String hora, String local, float precoIngresso) {

        super(nome, data, hora, local, precoIngresso);
        super.setQuantIngressos(200);
    }
}
