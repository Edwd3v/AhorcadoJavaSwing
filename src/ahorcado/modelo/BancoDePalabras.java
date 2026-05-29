package ahorcado.modelo;

import java.util.ArrayList;
import java.util.Random;

public class BancoDePalabras {

    // Lista principal del banco.
    // Cada FichaPalabra representa una palabra jugable completa:
    // palabra a adivinar, categoría y pista escrita.
    // Por eso el ArrayList no guarda String sueltos, sino objetos FichaPalabra.
    private ArrayList<FichaPalabra> fichasPalabra;

    // Generador de números aleatorios.
    // Se usa en obtenerFichaAleatoria() para elegir una posición al azar
    // dentro del ArrayList fichasPalabra.
    private Random random;

    // Constructor del banco.
    // Al crear un BancoDePalabras, se inicializa la lista donde se guardarán
    // las fichas, se prepara el generador aleatorio y se cargan las palabras iniciales.
    public BancoDePalabras() {
        fichasPalabra = new ArrayList<>();
        random = new Random();

        cargarFichasPorCategoria();
    }    


    // Devuelve una ficha aleatoria para iniciar una partida.
    public FichaPalabra obtenerFichaAleatoria() {
        int posicion = random.nextInt(fichasPalabra.size());
        return fichasPalabra.get(posicion);
    }

    // Carga un conjunto inicial de palabras con varias categorias.
    private void cargarFichasPorCategoria() {
        cargarAnimales();
        cargarComidas();
        cargarPaises();
        cargarDeportes();
        cargarInstrumentos();
        cargarFrutas();
        cargarProfesiones();
        cargarColores();
        cargarObjetos();
        cargarMediosDeTransporte();
    }

    // Agrega una ficha al banco con palabra, categoria y pista escrita.
    private void agregarFicha(String palabra, String categoria, String pistaEscrita) {
        fichasPalabra.add(new FichaPalabra(palabra, categoria, pistaEscrita));
    }

    private void cargarAnimales() {
        agregarFicha("perro", "Animales", "Es una mascota comun");
        agregarFicha("gato", "Animales", "Le gusta maullar");
        agregarFicha("tigre", "Animales", "Es un felino salvaje");
        agregarFicha("leon", "Animales", "Es llamado rey de la selva");
        agregarFicha("cebra", "Animales", "Tiene rayas blancas y negras");
        agregarFicha("jirafa", "Animales", "Tiene el cuello muy largo");
        agregarFicha("conejo", "Animales", "Le gustan las zanahorias");
        agregarFicha("caballo", "Animales", "Se puede montar");
        agregarFicha("oveja", "Animales", "Produce lana");
        agregarFicha("vaca", "Animales", "Da leche");
        agregarFicha("pollo", "Animales", "Tiene plumas y pico");
        agregarFicha("pato", "Animales", "Nada en el agua");
        agregarFicha("delfin", "Animales", "Es un mamifero marino");
        agregarFicha("ballena", "Animales", "Es enorme y vive en el mar");
        agregarFicha("tiburon", "Animales", "Tiene muchos dientes");
        agregarFicha("aguila", "Animales", "Vuela a gran altura");
        agregarFicha("lobo", "Animales", "Se parece a un perro salvaje");
        agregarFicha("zorro", "Animales", "Es conocido por ser astuto");
        agregarFicha("mono", "Animales", "Trepa arboles");
        agregarFicha("raton", "Animales", "Es pequeno y le gusta el queso");
    }

    private void cargarComidas() {
        agregarFicha("pizza", "Comidas", "Tiene queso y salsa");
        agregarFicha("sopa", "Comidas", "Se sirve caliente");
        agregarFicha("ensalada", "Comidas", "Lleva verduras");
        agregarFicha("hamburguesa", "Comidas", "Va dentro de un pan");
        agregarFicha("arroz", "Comidas", "Acompana muchos platos");
        agregarFicha("pasta", "Comidas", "Se cocina en agua");
        agregarFicha("pan", "Comidas", "Se hornea con harina");
        agregarFicha("queso", "Comidas", "Se hace con leche");
        agregarFicha("tamal", "Comidas", "Se envuelve en hojas");
        agregarFicha("arepa", "Comidas", "Es muy comun en colombia");
        agregarFicha("empanada", "Comidas", "Se rellena y se frie");
        agregarFicha("burrito", "Comidas", "Se envuelve en tortilla");
        agregarFicha("sanduche", "Comidas", "Va entre dos panes");
        agregarFicha("lasagna", "Comidas", "Tiene capas de pasta");
        agregarFicha("sushi", "Comidas", "Lleva arroz enrollado");
        agregarFicha("galleta", "Comidas", "Es pequena y dulce");
        agregarFicha("helado", "Comidas", "Es frio y dulce");
        agregarFicha("pastel", "Comidas", "Se come en fiestas");
        agregarFicha("cereal", "Comidas", "Se come con leche");
        agregarFicha("yogur", "Comidas", "Es un lacteo cremoso");
    }

    private void cargarPaises() {
        agregarFicha("colombia", "Paises", "Esta en sudamerica");
        agregarFicha("mexico", "Paises", "Es famoso por sus tacos");
        agregarFicha("argentina", "Paises", "Es conocida por el tango");
        agregarFicha("brasil", "Paises", "Es famoso por el carnaval");
        agregarFicha("chile", "Paises", "Es un pais largo y angosto");
        agregarFicha("peru", "Paises", "Tiene machupicchu");
        agregarFicha("ecuador", "Paises", "Su nombre viene de la linea ecuatorial");
        agregarFicha("uruguay", "Paises", "Esta al sur de brasil");
        agregarFicha("paraguay", "Paises", "Es un pais sin costa");
        agregarFicha("bolivia", "Paises", "Tiene el salar de uyuni");
        agregarFicha("canada", "Paises", "Esta en america del norte");
        agregarFicha("espana", "Paises", "Su capital es madrid");
        agregarFicha("francia", "Paises", "Tiene la torre eiffel");
        agregarFicha("italia", "Paises", "Tiene forma de bota");
        agregarFicha("alemania", "Paises", "Su capital es berlin");
        agregarFicha("portugal", "Paises", "Esta al lado de espana");
        agregarFicha("japon", "Paises", "Es famoso por el sushi");
        agregarFicha("china", "Paises", "Tiene una gran muralla");
        agregarFicha("india", "Paises", "Tiene el taj mahal");
        agregarFicha("egipto", "Paises", "Tiene piramides antiguas");
    }

    private void cargarDeportes() {
        agregarFicha("futbol", "Deportes", "Se juega con un balon");
        agregarFicha("tenis", "Deportes", "Se juega con raqueta");
        agregarFicha("natacion", "Deportes", "Se practica en piscina");
        agregarFicha("ciclismo", "Deportes", "Se practica en bicicleta");
        agregarFicha("beisbol", "Deportes", "Se juega con bate");
        agregarFicha("baloncesto", "Deportes", "Se encesta un balon");
        agregarFicha("voleibol", "Deportes", "La pelota no debe tocar el suelo");
        agregarFicha("boxeo", "Deportes", "Se pelea con guantes");
        agregarFicha("ajedrez", "Deportes", "Se juega en un tablero");
        agregarFicha("karate", "Deportes", "Usa golpes y defensa");
        agregarFicha("patinaje", "Deportes", "Se usan patines");
        agregarFicha("atletismo", "Deportes", "Incluye carreras y saltos");
        agregarFicha("golf", "Deportes", "Se usa palo y bola pequena");
        agregarFicha("rugby", "Deportes", "Se juega con balon ovalado");
        agregarFicha("esgrima", "Deportes", "Se usa espada");
        agregarFicha("taekwondo", "Deportes", "Destacan las patadas");
        agregarFicha("judo", "Deportes", "Usa llaves y agarres");
        agregarFicha("surf", "Deportes", "Se practica sobre olas");
        agregarFicha("remo", "Deportes", "Se impulsa una embarcacion");
        agregarFicha("handbol", "Deportes", "Se juega con las manos");
    }

    private void cargarInstrumentos() {
        agregarFicha("guitarra", "Instrumentos", "Tiene cuerdas");
        agregarFicha("piano", "Instrumentos", "Tiene teclas");
        agregarFicha("violin", "Instrumentos", "Se toca con arco");
        agregarFicha("flauta", "Instrumentos", "Es de viento");
        agregarFicha("tambor", "Instrumentos", "Se golpea con baquetas");
        agregarFicha("trompeta", "Instrumentos", "Es metalica y suena fuerte");
        agregarFicha("arpa", "Instrumentos", "Tiene muchas cuerdas");
        agregarFicha("maracas", "Instrumentos", "Se agitan con las manos");
        agregarFicha("bateria", "Instrumentos", "Tiene varios tambores");
        agregarFicha("clarinete", "Instrumentos", "Es de viento y madera");
        agregarFicha("saxofon", "Instrumentos", "Se usa mucho en jazz");
        agregarFicha("acordeon", "Instrumentos", "Se abre y se cierra");
        agregarFicha("ukelele", "Instrumentos", "Es pequeno y tiene cuerdas");
        agregarFicha("xilofono", "Instrumentos", "Tiene barras de madera");
        agregarFicha("tuba", "Instrumentos", "Es grande y de metal");
        agregarFicha("oboe", "Instrumentos", "Es de viento y suena agudo");
        agregarFicha("chelo", "Instrumentos", "Es mas grande que un violin");
        agregarFicha("triangulo", "Instrumentos", "Es metalico y pequeno");
        agregarFicha("banjo", "Instrumentos", "Tiene cuerdas y caja redonda");
        agregarFicha("mandolina", "Instrumentos", "Se parece a una guitarra pequena");
    }

    private void cargarFrutas() {
        agregarFicha("manzana", "Frutas", "Puede ser roja o verde");
        agregarFicha("pera", "Frutas", "Es dulce y jugosa");
        agregarFicha("banano", "Frutas", "Es amarillo y alargado");
        agregarFicha("mango", "Frutas", "Es tropical y dulce");
        agregarFicha("uva", "Frutas", "Crece en racimos");
        agregarFicha("naranja", "Frutas", "Es citrica y redonda");
        agregarFicha("limon", "Frutas", "Es muy acido");
        agregarFicha("papaya", "Frutas", "Es grande y anaranjada");
        agregarFicha("guayaba", "Frutas", "Tiene muchas semillas pequenas");
        agregarFicha("fresa", "Frutas", "Es roja y pequena");
        agregarFicha("cereza", "Frutas", "Es roja y tiene hueso");
        agregarFicha("melon", "Frutas", "Es grande y refrescante");
        agregarFicha("sandia", "Frutas", "Es grande y tiene mucha agua");
        agregarFicha("pina", "Frutas", "Tiene corona y cascara rugosa");
        agregarFicha("coco", "Frutas", "Tiene agua por dentro");
        agregarFicha("kiwi", "Frutas", "Es marron por fuera y verde por dentro");
        agregarFicha("durazno", "Frutas", "Tiene piel suave");
        agregarFicha("ciruela", "Frutas", "Puede ser morada");
        agregarFicha("mora", "Frutas", "Es oscura y pequena");
        agregarFicha("maracuya", "Frutas", "Es aromatica y acida");
    }

    private void cargarProfesiones() {
        agregarFicha("medico", "Profesiones", "Atiende pacientes");
        agregarFicha("profesor", "Profesiones", "Enseña en clase");
        agregarFicha("ingeniero", "Profesiones", "Disena y resuelve problemas");
        agregarFicha("abogado", "Profesiones", "Trabaja con leyes");
        agregarFicha("arquitecto", "Profesiones", "Disena edificios");
        agregarFicha("contador", "Profesiones", "Lleva cuentas");
        agregarFicha("carpintero", "Profesiones", "Trabaja con madera");
        agregarFicha("cocinero", "Profesiones", "Prepara alimentos");
        agregarFicha("bombero", "Profesiones", "Apaga incendios");
        agregarFicha("policia", "Profesiones", "Cuida el orden");
        agregarFicha("piloto", "Profesiones", "Conduce aviones");
        agregarFicha("enfermero", "Profesiones", "Ayuda en el cuidado medico");
        agregarFicha("dentista", "Profesiones", "Cuida los dientes");
        agregarFicha("panadero", "Profesiones", "Hace pan");
        agregarFicha("mecanico", "Profesiones", "Repara motores");
        agregarFicha("soldador", "Profesiones", "Une piezas de metal");
        agregarFicha("pintor", "Profesiones", "Pinta superficies o cuadros");
        agregarFicha("jardinero", "Profesiones", "Cuida plantas");
        agregarFicha("periodista", "Profesiones", "Informa noticias");
        agregarFicha("programador", "Profesiones", "Escribe codigo");
    }

    private void cargarColores() {
        agregarFicha("rojo", "Colores", "Se parece al color de la sangre");
        agregarFicha("azul", "Colores", "Se parece al cielo");
        agregarFicha("verde", "Colores", "Es comun en la naturaleza");
        agregarFicha("amarillo", "Colores", "Se parece al sol");
        agregarFicha("negro", "Colores", "Es ausencia de luz");
        agregarFicha("blanco", "Colores", "Se asocia con la nieve");
        agregarFicha("morado", "Colores", "Se parece a algunas flores");
        agregarFicha("rosado", "Colores", "Es un tono suave");
        agregarFicha("naranja", "Colores", "Tambien es nombre de una fruta");
        agregarFicha("gris", "Colores", "Se parece al humo");
        agregarFicha("marron", "Colores", "Se parece a la madera");
        agregarFicha("dorado", "Colores", "Se parece al oro");
        agregarFicha("plateado", "Colores", "Se parece a la plata");
        agregarFicha("turquesa", "Colores", "Es entre azul y verde");
        agregarFicha("violeta", "Colores", "Es similar al morado");
        agregarFicha("beige", "Colores", "Es un tono claro y neutro");
        agregarFicha("cian", "Colores", "Es un azul claro");
        agregarFicha("magenta", "Colores", "Es usado en impresion");
        agregarFicha("ocre", "Colores", "Es un tono terroso");
        agregarFicha("lila", "Colores", "Es un tono suave de violeta");
    }

    private void cargarObjetos() {
        agregarFicha("mesa", "Objetos", "Tiene patas y superficie");
        agregarFicha("silla", "Objetos", "Sirve para sentarse");
        agregarFicha("puerta", "Objetos", "Permite entrar o salir");
        agregarFicha("ventana", "Objetos", "Deja pasar la luz");
        agregarFicha("lapiz", "Objetos", "Sirve para escribir");
        agregarFicha("cuaderno", "Objetos", "Tiene hojas para anotar");
        agregarFicha("mochila", "Objetos", "Sirve para cargar cosas");
        agregarFicha("reloj", "Objetos", "Marca la hora");
        agregarFicha("llave", "Objetos", "Abre una cerradura");
        agregarFicha("espejo", "Objetos", "Refleja la imagen");
        agregarFicha("televisor", "Objetos", "Muestra imagen y sonido");
        agregarFicha("lampara", "Objetos", "Da iluminacion");
        agregarFicha("telefono", "Objetos", "Sirve para llamar");
        agregarFicha("botella", "Objetos", "Guarda liquidos");
        agregarFicha("vaso", "Objetos", "Se usa para beber");
        agregarFicha("cuchara", "Objetos", "Se usa para comer sopa");
        agregarFicha("tenedor", "Objetos", "Tiene puntas");
        agregarFicha("cuchillo", "Objetos", "Sirve para cortar");
        agregarFicha("almohada", "Objetos", "Se usa para dormir");
        agregarFicha("cepillo", "Objetos", "Sirve para peinar o limpiar");
    }

    private void cargarMediosDeTransporte() {
        agregarFicha("carro", "Transporte", "Tiene cuatro ruedas");
        agregarFicha("moto", "Transporte", "Tiene dos ruedas");
        agregarFicha("bicicleta", "Transporte", "Se mueve con pedales");
        agregarFicha("avion", "Transporte", "Vuela por el aire");
        agregarFicha("barco", "Transporte", "Navega en el agua");
        agregarFicha("tren", "Transporte", "Se mueve por rieles");
        agregarFicha("bus", "Transporte", "Transporta muchos pasajeros");
        agregarFicha("taxi", "Transporte", "Es un servicio publico");
        agregarFicha("camion", "Transporte", "Lleva carga pesada");
        agregarFicha("helicoptero", "Transporte", "Tiene helices");
        agregarFicha("submarino", "Transporte", "Va bajo el agua");
        agregarFicha("patineta", "Transporte", "Tiene tabla y ruedas");
        agregarFicha("tranvia", "Transporte", "Circula por la ciudad");
        agregarFicha("lancha", "Transporte", "Es pequeña y va por agua");
        agregarFicha("cohete", "Transporte", "Viaja al espacio");
        agregarFicha("globo", "Transporte", "Vuela con aire caliente");
        agregarFicha("ferrocarril", "Transporte", "Es un sistema de trenes");
        agregarFicha("ambulancia", "Transporte", "Traslada heridos");
        agregarFicha("tractor", "Transporte", "Se usa en el campo");
        agregarFicha("metro", "Transporte", "Es un tren urbano");
    }
}
