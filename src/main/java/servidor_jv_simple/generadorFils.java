/**
*Classe on està el run.
*La finalitat del progrma es activar es fer us de la funcionalitat multithread
*@author: Bernat Guerola
* <a href="jap@bernatguerola.com">jap@bernatguerola.com </a>
*@see <a href="https://github.com/BGuerola/ProjecteDamm">Github del projecte</a>
*/

package servidor_jv_simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class generadorFils implements Runnable{
    /**
     * @param MySocket El que relaciona el programa servidor amb el programa client
     */
    private Socket MySocket;

    /**
     * Constructor de la classe
     * @param socket
     */
    generadorFils (Socket socket) {
        MySocket=socket;
    }

    /**
     * @param linea Este parámetre correspon a la lectura del l'opció triada pel
     * programa client, i la seua execució per un thread.
     * @param resposta Este parametre rep el valor del resultat l'execució del programa que alberga la llògica.
     */
    public void run(){
        try {             
            InputStream is=MySocket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader bf=new BufferedReader(isr);
            String linia=bf.readLine();

            System.out.println("aci cridar a la clase que farà de hibernate");
            LogicaServei prova = new LogicaServei();
            String resposta=prova.logica(linia);

            OutputStream os=MySocket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            pw.write(resposta+"\n");
            pw.flush();
    
            pw.close();
            os.close();

        } catch (Exception e){
            System.out.println("Error -> " + e.getMessage());
        } finally {
            try {
                MySocket.close();                   
            } catch (IOException e){}

            System.out.println("Cerrados: "+ MySocket);
        }
    }

}