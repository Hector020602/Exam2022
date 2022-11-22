import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // ♠, ♥, ♦, ♣.
        Scanner input = new Scanner(System.in);
        Mazo z = new Mazo(2);
        z.barajar();
        Jugador j = new Jugador("Hector");
        j.repartirCarta(z.extraerCarta());
        j.repartirCarta(z.extraerCarta());
        boolean gameOver = false;
        while (!gameOver) {
            System.out.println(j);
            System.out.println(j.getPuntuacion());
            System.out.println("¿Otra carta? (S/N)");
            String respuesta = input.next().toUpperCase();
            if (respuesta.equals("S")) {
                j.repartirCarta(z.extraerCarta());
                int puntuacion = j.getPuntuacion();
                if (puntuacion >= 21) {
                    gameOver = true;
                }
            } else {
                gameOver = true;
            }
        }
        if (j.getPuntuacion() > 21) {
            System.out.println(j);
            System.out.println(j.getPuntuacion());
            System.out.println("Pierdes !!");
        }

    }
}
