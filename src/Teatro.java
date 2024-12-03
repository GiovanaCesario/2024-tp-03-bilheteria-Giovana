package src;

import java.util.Date;

public class Teatro extends Evento {

    public Teatro(String nome, Date data, String hora, String local, float precoIngresso) {

        super(nome, data, hora, local, precoIngresso);
        super.setQuantIngressos(250);
    }
}
