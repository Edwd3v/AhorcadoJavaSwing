package ahorcado.app;
import ahorcado.modelo.Palabra;

public class Main {

    public static void main(String[] args) {

        // Creamos una palabra de pueba para probar la class Palabra
        Palabra palabraPrueba = new Palabra("perro", "Animales", "Es una mascota comun");

        // Mostrar los datos usando los getters
        System.out.println("Palabra: " + palabraPrueba.getTexto());
        System.out.println("Categoría: " + palabraPrueba.getCategoria());
        System.out.println("Pista: " + palabraPrueba.getPista());

    }

}
