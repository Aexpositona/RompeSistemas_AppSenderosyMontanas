package RompeSistemas.Modelo;

public class Infantil extends Socio {

    private final String numSocioTutor;
    private static final int tipo = 3;

    //Métodos constructores
    /**
     * Método constructor de la clase Infantil que recibe por parámetros el nombre, el número y el numero de socio del tutor
     * @param nombre es el nombre del socio
     * @param numero es el número del socio
     * @param numSocioTutor es el número de socio del tutor
     */
    public Infantil(String nombre, String numero,String nif, String numSocioTutor){
        super(nombre,numero,nif);
        this.numSocioTutor = numSocioTutor;
        super.setTipo(tipo);
    }

    /**
     * Método constructor de copia de la clase Infantil
     * @param infantil Es el socio que se va a copiar
     */
    public Infantil(Infantil infantil){
        super(infantil);
        this.numSocioTutor = infantil.numSocioTutor;
        super.setTipo(tipo);
    }

    /**
     * Constructor vacío
     */
    public Infantil(){
        super();
        this.numSocioTutor = "";
        super.setTipo(tipo);
    }

    @Override
    public int getTipo() {
        return tipo;
    }


    //Métodos Setters

    /**
     * Método toString() de la clase Infantil que nos devuelve un String los datos del socio
     * @return El nombre, el número del socio, el tipò de socio y el número de socio del tutor
     */
    @Override
    public String toString(){
        return super.toString() +
                "Numero de socio del tutor: " + numSocioTutor + "\n";
    }
}
