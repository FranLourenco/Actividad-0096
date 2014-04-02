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
    private HashMap <HashSet<String>, String> answers;
    private HashSet <String> coincidence2;
    private HashSet <String> coincidence;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        answers = new HashMap<>();
        coincidence = new HashSet<>();
        coincidence2 = new HashSet<>();
        
        
        coincidence.add("crash");
        coincidence.add("linux");
        coincidence.add("problem");
        
        coincidence2.add("app");
        coincidence2.add("free");
        coincidence2.add("not");
        
        answers.put(coincidence, "the application does not allow linux");

        answers.put(coincidence2, "This application is not free");

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
        respuesta = answers.get(specificResponse);

        if(respuesta == null){
            int numeroAleatorio = aleatorio.nextInt(respuestas.size());
            respuesta = respuestas.get(numeroAleatorio);
        }
        return respuesta;
    }

}
