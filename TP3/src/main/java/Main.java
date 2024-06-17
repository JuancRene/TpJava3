import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        List<Punto> puntos = generarPuntosAleatorios(100);
        PuntoA(puntos);
        PuntoB(puntos);
        PuntoC(puntos);
        PuntoE(puntos);
        PuntoG(puntos);
        PuntoH(puntos);
        PuntoJ(puntos);
    }

    public static List<Punto> generarPuntosAleatorios(int cantidad) {
        List<Punto> puntos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            double x = -10 + (20 * random.nextDouble());
            double y = -20 + (40 * random.nextDouble());
            puntos.add(new Punto(x, y));
        }

        return puntos;
    }

    static double F(double x) {
        return Math.pow(x, 3) + 2 * Math.pow(x, 2) - 6 * x + 2;
    }

    private static String graficar(List<Punto> listaPuntos) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Punto punto : listaPuntos) {
            sb.append(punto).append("//");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    private static void PuntoA(List<Punto> listaPunto) {
        System.out.println("\nAAAAAAAAAAA\n");

        List<Punto> listaA = listaPunto.stream().filter(punto -> (punto.getY() < 15) && (punto.getY() > -15))
                .sorted(Comparator.comparingDouble(Punto::getX)).collect(Collectors.toList());
        System.out.println(graficar(listaA));
    }

    private static void PuntoB(List<Punto> listaPunto) {
        System.out.println("\nBBBBBBBBBB\n");

        List<Punto> listaB = listaPunto.stream().map(punto -> new Punto(punto.getX(), F(punto.getX())))
                .collect(Collectors.toList());
        System.out.println(graficar(listaB));
    }

    private static void PuntoC(List<Punto> listaPunto) {
        System.out.println("\nCCCCCCCCCC\n");
        List<Punto> listaC = listaPunto.stream().filter(p -> (F(p.getX()) - p.getY()) > 0)
                .filter(p -> (F(p.getX()) - p.getY()) < 10).collect(Collectors.toList());
        System.out.println(graficar(listaC));
    }

    private static void PuntoE(List<Punto> listaPunto) {
        System.out.println("\nEEEEEEEEEEE\n");
        double avgX = listaPunto.stream().mapToDouble(Punto::getX).average().orElse(0);
        double avgY = listaPunto.stream().mapToDouble(Punto::getY).average().orElse(0);
        Punto c = new Punto(avgX, avgY);
        List<Punto> listaE = listaPunto.stream()
                .filter(p -> Math.sqrt(Math.pow(c.getX() - p.getX(), 2) + Math.pow(c.getY() - p.getY(), 2)) <= 5)
                .collect(Collectors.toList());
        System.out.println(graficar(listaE));
    }

    private static void PuntoG(List<Punto> listaPunto) {
        System.out.println("\nGGGGGGGGGGG\n");
        List<Punto> listaG = listaPunto.stream().filter(p -> Math.abs(p.getY() - F(p.getX())) < 3)
                .filter(p -> p.getY() >= F(p.getX())).collect(Collectors.toList());
        System.out.println(graficar(listaG));

    }

    private static void PuntoH(List<Punto> listaPunto) {
        System.out.println("\nHHHHHHHHHHH\n");
        List<Punto> listaH = listaPunto.stream().filter(p -> p.getX() >= 0)
                .filter(p -> p.getY() >= 0 && p.getY() <= F(p.getX())).collect(Collectors.toList());
        System.out.println(graficar(listaH));
    }

    private static void PuntoJ(List<Punto> listaPunto) {
        System.out.println("\nJJJJJJJJJJJJ\n");

        List<Punto> listaJ = listaPunto.stream().filter(punto -> punto.getX() >= -4 && punto.getX() <= 4)
                .filter(punto -> punto.getY() > F(punto.getX())).collect(Collectors.toList());

        System.out.println(graficar(listaJ));
    }

}

