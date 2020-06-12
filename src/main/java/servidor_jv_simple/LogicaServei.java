/**
*Classe on se desenvolupa la llogica de gestió de dades.
*La finalitat es fer les consultes en la base de dades i tornar els valors demandats pel programa client.
*@author: Bernat Guerola
* <a href="jap@bernatguerola.com">jap@bernatguerola.com </a>
*@see <a href="https://github.com/BGuerola/ProjecteDamm">Github del projecte</a>
*/

package servidor_jv_simple;

public class LogicaServei  {
    /** 
     * @param linia valor captat pel socket.
     * @return String Valor que retornara els metodes.
     */
    public String logica(String linia){
        // L'ordre anterior és bloquejant, quan arriba aci, ha rebut una connexio
        System.out.println("Ha entrat en la classe Servidor que iniciarà l'hibernate");

        // Ara hem de llegir qué ens envíen

        String resposta;

        System.out.println("<log> Received... " + linia);

        // Analitzem la línia, i en funció d'aquesta retornem un resultat
        switch (linia){
            case "1":
            resposta="Alta candidat";
            break;

            case "2":
            resposta="Alta empresa";
            break;

            case "3":
            resposta="Alta oferta";
            break;
            
            case "4":
            resposta="Consultar candidat";
            break;

            case "5":
            resposta="Consultar empresa";
            break;
            
            case "6":
            resposta="Consultar oferta";
            break;
            
            case "7":
            resposta="Editar candidat";
            break;
            
            case "8":
            resposta="Editar empresa";
            break;
            
            case "9":
            resposta="Editar oferta";
            break;
            
            case "10":
            resposta="Borrar candidat";
            break;
            
            case "11":
            resposta="Borrar empresa";
            break;
            
            case "12":
            resposta="Borrar oferta";
            break;

            case ("x"):
            resposta="Eixida del programa";
            break;

            case ("X"):
            resposta="Eixida del programa";
            break;

            default:
            resposta="No es reconeix el missatge...";
            break;
        }

        return resposta;
        // Escrivim el resultat a l'stream d'eixida

        }
        }