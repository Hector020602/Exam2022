public class Mazo {
    public static final int NUM_CARTAS_EN_BARAJA = 52;
    private Carta[] cartas;
    private int numCartasQuedan;

    public Mazo(int numBarajas) {
        numCartasQuedan = numBarajas * NUM_CARTAS_EN_BARAJA;
        cartas = new Carta[numCartasQuedan];
        int i = 0;
        for (int numBaraja = 1; numBaraja <= numBarajas; numBaraja++) {
            for (int palo = 0; palo < Carta.PALOS.length; palo++) {
                for (int numero = 1; numero <= 13; numero++) {
                    cartas[i] = new Carta(numero, Carta.PALOS[palo]);
                    i++;
                }
            }
        }
    }

    public void barajar() {
        for (int i = 0; i < 100000; i++) {
            int r1 = (int)(Math.random() * cartas.length);
            int r2 = (int)(Math.random() * cartas.length);
            Carta temp = cartas[r1];
            cartas[r1] = cartas[r2];
            cartas[r2] = temp;
        }
    }

    public Carta extraerCarta() {
        numCartasQuedan--;
        return cartas[numCartasQuedan];
    }

    @Override
    public String toString() {
        String s = "";
        boolean primero;
        for (int palo = 0; palo < Carta.PALOS.length; palo++) {
            primero = true;
            for (int i = 0; i < numCartasQuedan; i++) {
                if (cartas[i].getPalo().equals(Carta.PALOS[palo])) {
                    if (primero) {
                        primero = false;
                    } else {
                        s += " ";
                    }
                    s += cartas[i];
                }
            }
            s += "\n";
        }
        return s;
    }
}
