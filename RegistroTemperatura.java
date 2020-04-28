import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class RegistroTemperatura {

    private static Map<Date, Double> medidas = new HashMap<>();

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private static double calcularTemperaturaMedia(Map<Date, Double> medidas) {
        double tmedia = 0.0;
        int numMuestras = 0;

        for (Double temp : medidas.values()) {
            tmedia += temp;
            numMuestras++;
        }
        if (numMuestras > 0) {
            return tmedia / numMuestras;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca fechas y temperaturas:");
        while (s.hasNext()) {
            try {
                Date fecha = formatter.parse(s.next());
                double temperatura = s.nextDouble();
                System.out.println("Dato añadido: " + fecha + " -> " + temperatura);
                medidas.put(fecha, temperatura);
            } catch (Exception e) {
                System.out.println("Dato no válido.");
            }
        }
        s.close();

        System.out.println("Datos introducidos: " + medidas.size());

        for (Date d : medidas.keySet()) {
            System.out.println(d + " -> " + medidas.get(d));
        }

        System.out.println("Temperatura media: " + calcularTemperaturaMedia(medidas) + "ºC");

    }
}