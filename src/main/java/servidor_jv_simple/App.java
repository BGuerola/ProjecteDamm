/**
*Classe inicial (el titol el dona gradle). Acollix el main.
*La finalitat el iniciar el servidor i aceptar la connexió que enviar a la classe encargada 
* de la funcionalitat multithread
*@author: Bernat Guerola
* <a href="jap@bernatguerola.com">jap@bernatguerola.com </a>
*@see <a href="https://github.com/BGuerola/ProjecteDamm">Github del projecte</a>
*/

package servidor_jv_simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    /**
     * @param ServerSocket 
     */
    protected ServerSocket listener=null;
    /**
     * @param srvPort El puerto utilitza per a conectar-se
     */
    private final int srvPort=9999;

    /** 
     * @throws IOException En previsió de no poder iniciar el servidor
     * Métode que inica el servidor i rep el programa client a través d'un socket
     * cridant al metode que genera el multithread.
     */
    public void conectar() throws IOException{

        System.out.println("Iniciant el servidor");
        try {
            listener=new ServerSocket(srvPort);
            System.out.println("Listener iniciat: ServerSpcket");
        } catch (IOException e) {
            System.out.println("El port "+srvPort+" està ocupato és inaccessible.");
            return;
            }

        while(true){
            Socket socket = listener.accept();
            System.out.println("S'ha rebut la connexió 'listener.accept'. Generant resposta.");

            generadorFils generador=new generadorFils(socket);
            Thread generadorThread = new Thread(generador);
            generadorThread.start();
        }
    }
   
    /** 
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException{
        App prova = new App();
        prova.conectar();
    }
}