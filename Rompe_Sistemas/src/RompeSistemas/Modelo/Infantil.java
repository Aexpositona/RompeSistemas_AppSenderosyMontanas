package RompeSistemas.Modelo;

public class Infantil extends Socio {

    private int numSocioTutor;

    //Métodos constructores
    /**
     * Método constructor de la clase Infantil que recibe por parámetros el nombre, el número y el numero de socio del tutor
     * @param nombre es el nombre del socio
     * @param numero es el número del socio
     * @param numSocioTutor es el número de socio del tutor
     */
    public Infantil(String nombre, int numero, int numSocioTutor){
        super(nombre, numero);
        this.numSocioTutor = numSocioTutor;
    }

    /**
     * Método constructor por defecto para generar sobrecarga de constructores
     */


    @Override
    public int getTipo() {
        return 3;
    }


    //Métodos Setters

    /**
     * Método toString() de la clase Infantil que nos devuelve un String los datos del socio
     * @return El nombre, el número del socio, el tipò de socio y el número de socio del tutor
     */
    @Override
    public String toString(){
        return super.toString() + "Tipo de socio: Infantil\n" + "Numero de socio del tutor: " + numSocioTutor;
    }
}
