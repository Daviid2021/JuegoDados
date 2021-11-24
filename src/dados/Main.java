package dados;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String nombreJugador;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        nombreJugador=entrada.nextLine();
        Juego juego=new Juego();
        juego.iniciarJuego(nombreJugador);
    }
}
