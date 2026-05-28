package ahorcado.modelo;

import java.util.ArrayList;
import java.util.Random;

public class BancoPalabras {

    // Guarda las palabras disponibles para jugar.
    private ArrayList<Palabra> bancoDePalabras;

    // Permite elegir una palabra al azar del banco.
    private Random random;

    // Crea el banco y carga las primeras palabras de prueba.
    public BancoPalabras() {
        bancoDePalabras = new ArrayList<>();
        random = new Random();

        cargarPalabrasIniciales();
    }

    // Devuelve una palabra aleatoria para iniciar una partida.
    public Palabra obtenerPalabraAleatoria() {
        int posicion = random.nextInt(bancoDePalabras.size());
        return bancoDePalabras.get(posicion);
    }

    // Carga un conjunto inicial de palabras con varias categorias.
    private void cargarPalabrasIniciales() {
        cargarAnimales();
        cargarComidas();
        cargarPaises();
        cargarDeportes();
        cargarInstrumentos();
        cargarFrutas();
        cargarProfesiones();
        cargarColores();
        cargarObjetos();
        cargarTransporte();
    }

    // Agrega una palabra al banco con su categoria y pista.
    private void agregarPalabra(String texto, String categoria, String pista) {
        bancoDePalabras.add(new Palabra(texto, categoria, pista));
    }

    private void cargarAnimales() {
        agregarPalabra("perro", "Animales", "Es una mascota comun");
        agregarPalabra("gato", "Animales", "Le gusta maullar");
        agregarPalabra("tigre", "Animales", "Es un felino salvaje");
        agregarPalabra("leon", "Animales", "Es llamado rey de la selva");
        agregarPalabra("cebra", "Animales", "Tiene rayas blancas y negras");
        agregarPalabra("jirafa", "Animales", "Tiene el cuello muy largo");
        agregarPalabra("conejo", "Animales", "Le gustan las zanahorias");
        agregarPalabra("caballo", "Animales", "Se puede montar");
        agregarPalabra("oveja", "Animales", "Produce lana");
        agregarPalabra("vaca", "Animales", "Da leche");
        agregarPalabra("pollo", "Animales", "Tiene plumas y pico");
        agregarPalabra("pato", "Animales", "Nada en el agua");
        agregarPalabra("delfin", "Animales", "Es un mamifero marino");
        agregarPalabra("ballena", "Animales", "Es enorme y vive en el mar");
        agregarPalabra("tiburon", "Animales", "Tiene muchos dientes");
        agregarPalabra("aguila", "Animales", "Vuela a gran altura");
        agregarPalabra("lobo", "Animales", "Se parece a un perro salvaje");
        agregarPalabra("zorro", "Animales", "Es conocido por ser astuto");
        agregarPalabra("mono", "Animales", "Trepa arboles");
        agregarPalabra("raton", "Animales", "Es pequeno y le gusta el queso");
    }

    private void cargarComidas() {
        agregarPalabra("pizza", "Comidas", "Tiene queso y salsa");
        agregarPalabra("sopa", "Comidas", "Se sirve caliente");
        agregarPalabra("ensalada", "Comidas", "Lleva verduras");
        agregarPalabra("hamburguesa", "Comidas", "Va dentro de un pan");
        agregarPalabra("arroz", "Comidas", "Acompana muchos platos");
        agregarPalabra("pasta", "Comidas", "Se cocina en agua");
        agregarPalabra("pan", "Comidas", "Se hornea con harina");
        agregarPalabra("queso", "Comidas", "Se hace con leche");
        agregarPalabra("tamal", "Comidas", "Se envuelve en hojas");
        agregarPalabra("arepa", "Comidas", "Es muy comun en colombia");
        agregarPalabra("empanada", "Comidas", "Se rellena y se frie");
        agregarPalabra("burrito", "Comidas", "Se envuelve en tortilla");
        agregarPalabra("sanduche", "Comidas", "Va entre dos panes");
        agregarPalabra("lasagna", "Comidas", "Tiene capas de pasta");
        agregarPalabra("sushi", "Comidas", "Lleva arroz enrollado");
        agregarPalabra("galleta", "Comidas", "Es pequena y dulce");
        agregarPalabra("helado", "Comidas", "Es frio y dulce");
        agregarPalabra("pastel", "Comidas", "Se come en fiestas");
        agregarPalabra("cereal", "Comidas", "Se come con leche");
        agregarPalabra("yogur", "Comidas", "Es un lacteo cremoso");
    }

    private void cargarPaises() {
        agregarPalabra("colombia", "Paises", "Esta en sudamerica");
        agregarPalabra("mexico", "Paises", "Es famoso por sus tacos");
        agregarPalabra("argentina", "Paises", "Es conocida por el tango");
        agregarPalabra("brasil", "Paises", "Es famoso por el carnaval");
        agregarPalabra("chile", "Paises", "Es un pais largo y angosto");
        agregarPalabra("peru", "Paises", "Tiene machupicchu");
        agregarPalabra("ecuador", "Paises", "Su nombre viene de la linea ecuatorial");
        agregarPalabra("uruguay", "Paises", "Esta al sur de brasil");
        agregarPalabra("paraguay", "Paises", "Es un pais sin costa");
        agregarPalabra("bolivia", "Paises", "Tiene el salar de uyuni");
        agregarPalabra("canada", "Paises", "Esta en america del norte");
        agregarPalabra("espana", "Paises", "Su capital es madrid");
        agregarPalabra("francia", "Paises", "Tiene la torre eiffel");
        agregarPalabra("italia", "Paises", "Tiene forma de bota");
        agregarPalabra("alemania", "Paises", "Su capital es berlin");
        agregarPalabra("portugal", "Paises", "Esta al lado de espana");
        agregarPalabra("japon", "Paises", "Es famoso por el sushi");
        agregarPalabra("china", "Paises", "Tiene una gran muralla");
        agregarPalabra("india", "Paises", "Tiene el taj mahal");
        agregarPalabra("egipto", "Paises", "Tiene piramides antiguas");
    }

    private void cargarDeportes() {
        agregarPalabra("futbol", "Deportes", "Se juega con un balon");
        agregarPalabra("tenis", "Deportes", "Se juega con raqueta");
        agregarPalabra("natacion", "Deportes", "Se practica en piscina");
        agregarPalabra("ciclismo", "Deportes", "Se practica en bicicleta");
        agregarPalabra("beisbol", "Deportes", "Se juega con bate");
        agregarPalabra("baloncesto", "Deportes", "Se encesta un balon");
        agregarPalabra("voleibol", "Deportes", "La pelota no debe tocar el suelo");
        agregarPalabra("boxeo", "Deportes", "Se pelea con guantes");
        agregarPalabra("ajedrez", "Deportes", "Se juega en un tablero");
        agregarPalabra("karate", "Deportes", "Usa golpes y defensa");
        agregarPalabra("patinaje", "Deportes", "Se usan patines");
        agregarPalabra("atletismo", "Deportes", "Incluye carreras y saltos");
        agregarPalabra("golf", "Deportes", "Se usa palo y bola pequena");
        agregarPalabra("rugby", "Deportes", "Se juega con balon ovalado");
        agregarPalabra("esgrima", "Deportes", "Se usa espada");
        agregarPalabra("taekwondo", "Deportes", "Destacan las patadas");
        agregarPalabra("judo", "Deportes", "Usa llaves y agarres");
        agregarPalabra("surf", "Deportes", "Se practica sobre olas");
        agregarPalabra("remo", "Deportes", "Se impulsa una embarcacion");
        agregarPalabra("handbol", "Deportes", "Se juega con las manos");
    }

    private void cargarInstrumentos() {
        agregarPalabra("guitarra", "Instrumentos", "Tiene cuerdas");
        agregarPalabra("piano", "Instrumentos", "Tiene teclas");
        agregarPalabra("violin", "Instrumentos", "Se toca con arco");
        agregarPalabra("flauta", "Instrumentos", "Es de viento");
        agregarPalabra("tambor", "Instrumentos", "Se golpea con baquetas");
        agregarPalabra("trompeta", "Instrumentos", "Es metalica y suena fuerte");
        agregarPalabra("arpa", "Instrumentos", "Tiene muchas cuerdas");
        agregarPalabra("maracas", "Instrumentos", "Se agitan con las manos");
        agregarPalabra("bateria", "Instrumentos", "Tiene varios tambores");
        agregarPalabra("clarinete", "Instrumentos", "Es de viento y madera");
        agregarPalabra("saxofon", "Instrumentos", "Se usa mucho en jazz");
        agregarPalabra("acordeon", "Instrumentos", "Se abre y se cierra");
        agregarPalabra("ukelele", "Instrumentos", "Es pequeno y tiene cuerdas");
        agregarPalabra("xilofono", "Instrumentos", "Tiene barras de madera");
        agregarPalabra("tuba", "Instrumentos", "Es grande y de metal");
        agregarPalabra("oboe", "Instrumentos", "Es de viento y suena agudo");
        agregarPalabra("chelo", "Instrumentos", "Es mas grande que un violin");
        agregarPalabra("triangulo", "Instrumentos", "Es metalico y pequeno");
        agregarPalabra("banjo", "Instrumentos", "Tiene cuerdas y caja redonda");
        agregarPalabra("mandolina", "Instrumentos", "Se parece a una guitarra pequena");
    }

    private void cargarFrutas() {
        agregarPalabra("manzana", "Frutas", "Puede ser roja o verde");
        agregarPalabra("pera", "Frutas", "Es dulce y jugosa");
        agregarPalabra("banano", "Frutas", "Es amarillo y alargado");
        agregarPalabra("mango", "Frutas", "Es tropical y dulce");
        agregarPalabra("uva", "Frutas", "Crece en racimos");
        agregarPalabra("naranja", "Frutas", "Es citrica y redonda");
        agregarPalabra("limon", "Frutas", "Es muy acido");
        agregarPalabra("papaya", "Frutas", "Es grande y anaranjada");
        agregarPalabra("guayaba", "Frutas", "Tiene muchas semillas pequenas");
        agregarPalabra("fresa", "Frutas", "Es roja y pequena");
        agregarPalabra("cereza", "Frutas", "Es roja y tiene hueso");
        agregarPalabra("melon", "Frutas", "Es grande y refrescante");
        agregarPalabra("sandia", "Frutas", "Es grande y tiene mucha agua");
        agregarPalabra("pina", "Frutas", "Tiene corona y cascara rugosa");
        agregarPalabra("coco", "Frutas", "Tiene agua por dentro");
        agregarPalabra("kiwi", "Frutas", "Es marron por fuera y verde por dentro");
        agregarPalabra("durazno", "Frutas", "Tiene piel suave");
        agregarPalabra("ciruela", "Frutas", "Puede ser morada");
        agregarPalabra("mora", "Frutas", "Es oscura y pequena");
        agregarPalabra("maracuya", "Frutas", "Es aromatica y acida");
    }

    private void cargarProfesiones() {
        agregarPalabra("medico", "Profesiones", "Atiende pacientes");
        agregarPalabra("profesor", "Profesiones", "Enseña en clase");
        agregarPalabra("ingeniero", "Profesiones", "Disena y resuelve problemas");
        agregarPalabra("abogado", "Profesiones", "Trabaja con leyes");
        agregarPalabra("arquitecto", "Profesiones", "Disena edificios");
        agregarPalabra("contador", "Profesiones", "Lleva cuentas");
        agregarPalabra("carpintero", "Profesiones", "Trabaja con madera");
        agregarPalabra("cocinero", "Profesiones", "Prepara alimentos");
        agregarPalabra("bombero", "Profesiones", "Apaga incendios");
        agregarPalabra("policia", "Profesiones", "Cuida el orden");
        agregarPalabra("piloto", "Profesiones", "Conduce aviones");
        agregarPalabra("enfermero", "Profesiones", "Ayuda en el cuidado medico");
        agregarPalabra("dentista", "Profesiones", "Cuida los dientes");
        agregarPalabra("panadero", "Profesiones", "Hace pan");
        agregarPalabra("mecanico", "Profesiones", "Repara motores");
        agregarPalabra("soldador", "Profesiones", "Une piezas de metal");
        agregarPalabra("pintor", "Profesiones", "Pinta superficies o cuadros");
        agregarPalabra("jardinero", "Profesiones", "Cuida plantas");
        agregarPalabra("periodista", "Profesiones", "Informa noticias");
        agregarPalabra("programador", "Profesiones", "Escribe codigo");
    }

    private void cargarColores() {
        agregarPalabra("rojo", "Colores", "Se parece al color de la sangre");
        agregarPalabra("azul", "Colores", "Se parece al cielo");
        agregarPalabra("verde", "Colores", "Es comun en la naturaleza");
        agregarPalabra("amarillo", "Colores", "Se parece al sol");
        agregarPalabra("negro", "Colores", "Es ausencia de luz");
        agregarPalabra("blanco", "Colores", "Se asocia con la nieve");
        agregarPalabra("morado", "Colores", "Se parece a algunas flores");
        agregarPalabra("rosado", "Colores", "Es un tono suave");
        agregarPalabra("naranja", "Colores", "Tambien es nombre de una fruta");
        agregarPalabra("gris", "Colores", "Se parece al humo");
        agregarPalabra("marron", "Colores", "Se parece a la madera");
        agregarPalabra("dorado", "Colores", "Se parece al oro");
        agregarPalabra("plateado", "Colores", "Se parece a la plata");
        agregarPalabra("turquesa", "Colores", "Es entre azul y verde");
        agregarPalabra("violeta", "Colores", "Es similar al morado");
        agregarPalabra("beige", "Colores", "Es un tono claro y neutro");
        agregarPalabra("cian", "Colores", "Es un azul claro");
        agregarPalabra("magenta", "Colores", "Es usado en impresion");
        agregarPalabra("ocre", "Colores", "Es un tono terroso");
        agregarPalabra("lila", "Colores", "Es un tono suave de violeta");
    }

    private void cargarObjetos() {
        agregarPalabra("mesa", "Objetos", "Tiene patas y superficie");
        agregarPalabra("silla", "Objetos", "Sirve para sentarse");
        agregarPalabra("puerta", "Objetos", "Permite entrar o salir");
        agregarPalabra("ventana", "Objetos", "Deja pasar la luz");
        agregarPalabra("lapiz", "Objetos", "Sirve para escribir");
        agregarPalabra("cuaderno", "Objetos", "Tiene hojas para anotar");
        agregarPalabra("mochila", "Objetos", "Sirve para cargar cosas");
        agregarPalabra("reloj", "Objetos", "Marca la hora");
        agregarPalabra("llave", "Objetos", "Abre una cerradura");
        agregarPalabra("espejo", "Objetos", "Refleja la imagen");
        agregarPalabra("televisor", "Objetos", "Muestra imagen y sonido");
        agregarPalabra("lampara", "Objetos", "Da iluminacion");
        agregarPalabra("telefono", "Objetos", "Sirve para llamar");
        agregarPalabra("botella", "Objetos", "Guarda liquidos");
        agregarPalabra("vaso", "Objetos", "Se usa para beber");
        agregarPalabra("cuchara", "Objetos", "Se usa para comer sopa");
        agregarPalabra("tenedor", "Objetos", "Tiene puntas");
        agregarPalabra("cuchillo", "Objetos", "Sirve para cortar");
        agregarPalabra("almohada", "Objetos", "Se usa para dormir");
        agregarPalabra("cepillo", "Objetos", "Sirve para peinar o limpiar");
    }

    private void cargarTransporte() {
        agregarPalabra("carro", "Transporte", "Tiene cuatro ruedas");
        agregarPalabra("moto", "Transporte", "Tiene dos ruedas");
        agregarPalabra("bicicleta", "Transporte", "Se mueve con pedales");
        agregarPalabra("avion", "Transporte", "Vuela por el aire");
        agregarPalabra("barco", "Transporte", "Navega en el agua");
        agregarPalabra("tren", "Transporte", "Se mueve por rieles");
        agregarPalabra("bus", "Transporte", "Transporta muchos pasajeros");
        agregarPalabra("taxi", "Transporte", "Es un servicio publico");
        agregarPalabra("camion", "Transporte", "Lleva carga pesada");
        agregarPalabra("helicoptero", "Transporte", "Tiene helices");
        agregarPalabra("submarino", "Transporte", "Va bajo el agua");
        agregarPalabra("patineta", "Transporte", "Tiene tabla y ruedas");
        agregarPalabra("tranvia", "Transporte", "Circula por la ciudad");
        agregarPalabra("lancha", "Transporte", "Es pequeña y va por agua");
        agregarPalabra("cohete", "Transporte", "Viaja al espacio");
        agregarPalabra("globo", "Transporte", "Vuela con aire caliente");
        agregarPalabra("ferrocarril", "Transporte", "Es un sistema de trenes");
        agregarPalabra("ambulancia", "Transporte", "Traslada heridos");
        agregarPalabra("tractor", "Transporte", "Se usa en el campo");
        agregarPalabra("metro", "Transporte", "Es un tren urbano");
    }
}
