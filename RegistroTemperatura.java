import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class RegistroTemperatura {

    private static Map<Date, Double> medidas = new HashMap<>();

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
    
    private static double calcularTemperaturaMedia() {
        return 0.0; // TODO: implementar cálculo.
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca fechas y temperaturas:");
        while (s.hasNext()) {
            try {
                Date fecha = formatter.parse(s.next());
                double temperatura = s.nextDouble();
                medidas.put(fecha, temperatura);
            } catch (Exception e) {
                System.out.println("Dato no válido.");
            }
        }
        s.close();

        System.out.println("Datos introducidos");

        for (Date d : medidas.keySet()) {
            System.out.println(d + " -> " + medidas.get(d));
        }

        System.out.println("Temperatura media: " + calcularTemperaturaMedia() + "ºC");

    }
}