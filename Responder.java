import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random aleatorio;
    ArrayList <String> respuestas;
    private HashMap <String, String> answers;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        answers = new HashMap<>();

        answers.put("Ayuda", "Porfavor, vaya al menú de preguntas frecuentes");
        answers.put("Salir", "Para salir introduzca la palabra -bye-");
        answers.put("Linux", "Este programa no soporta ese sistema operativo");

        respuestas.add("El equipo no funciona");
        respuestas.add("Pruebe a explicarme el problema de nuevo");
        respuestas.add("En estos momentos no podemos solucionar el problema, pruebe más tarde");
        respuestas.add("No conseguimos identificar el error que esta ocurriendo");
        respuestas.add("El problema ya está solucionado");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> specificResponse)
    {
        String respuesta = null;
        Iterator<String> iterator = specificResponse.iterator();
        String word = iterator.next();
        respuesta = answers.get(word);

        if(respuesta == null){
            int numeroAleatorio = aleatorio.nextInt(respuestas.size());
            respuesta = respuestas.get(numeroAleatorio);
        }
        return respuesta;
    }

}
