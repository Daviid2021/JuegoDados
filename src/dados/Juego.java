package dados;

import java.util.Scanner;

import java.util.Scanner;
public class Juego {
    private int guardar;
    private Jugador jugador;
    private Scanner escan;
    private int totalActual;
    public Juego(){
        totalActual=0;
        escan=null;
        guardar=0;
    }
    private Jugador getJugador(){
        if(jugador==null){
            jugador=new Jugador();
        }
        return jugador;
    }
    public void iniciarJuego(String nombre) {
        getJugador();
        getJugador().setNombre(nombre);
        System.out.println("\nBienvenido "+getJugador().getNombre());
        System.out.println("Juego craps");
        System.out.println("\n\tReglas:\n"+"-El primer lanzamiento de dados:\n"+" 1.Si el jugador saca 7 u 11 gana automaticamente\n 2.Si el jugador saca 12,2,3 pierde "
                + "automaticamente\n-Si saca cualquier otro numero debe volver a lanzar los dados y seguir las siguientes reglas:\n 1.Si saca 7 pierde automaticamente\n"
                + " 2.Si saca el mismo numero del primero lanzamiento gana, de no ser asi seguira lanzando hasta sacar 7 o el numero del primer lanzamiento");
        while (true) {         
            System.out.println("\nPresione:\n 1. si desea lanzar los dados\n 2. para salir");
            System.out.println("Ingrese la opción --> ");
            escan=new Scanner(System.in);
            int opc=escan.nextInt();
            if (opc==2){
                break;
            }else{
                if (getJugador().getLanzamiento()==1) {
                    totalActual=getJugador().lanzarDados();
                    System.out.println("El valor del dado #1 es: "+getJugador().dadoIndividual(0)+" Y el valor del dado #2 es: "+getJugador().dadoIndividual(1));
                    System.out.println("Para un total de: "+totalActual);
                    if (totalActual==12||totalActual==2||totalActual==3) {
                        System.out.println("Perdiste");
                        break;
                    }else if (totalActual==7||totalActual==11) {
                        System.out.println("Ganaste");
                        break;
                    }else{
                        guardar=totalActual;
                        getJugador().setLanzamiento(2);
                        totalActual=0;
                    }
                }else if(getJugador().getLanzamiento()>1){
                    getJugador().reiniciarDados();
                    totalActual=getJugador().lanzarDados();
                    System.out.println("El valor del dado 1 es: "+getJugador().dadoIndividual(0)+"   Y el valor del dado 2 es: "+getJugador().dadoIndividual(1));
                    System.out.println("Para un total de: "+totalActual);
                    if (totalActual==7) {
                        System.out.println("Perdiste");
                        break;
                    }else if (totalActual==guardar) {
                        System.out.println("GANASTE");
                        break;
                    }else{
                        continue;
                    }
                }
            } 
        }
        System.out.println("Gracias por jugar!");
    }
}
    

