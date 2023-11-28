import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutaciones {

    private static List<String> calcularPermutaciones(String conjunto) {
        List<String> permutaciones = new ArrayList<>();
        permutacionesRecursivas("", conjunto, permutaciones);
        return permutaciones;
    }

    private static void permutacionesRecursivas(String prefijo, String sufijo, List<String> permutaciones) {
        int n = sufijo.length();
        if (n == 0) {
            permutaciones.add(prefijo);
        } else {
            for (int i = 0; i < n; i++) {
                permutacionesRecursivas(prefijo + sufijo.charAt(i), sufijo.substring(0, i) + sufijo.substring(i + 1, n), permutaciones);
            }
        }
    }

    public static void main(String[] args) {

        String conjunto = "ABCDEE";

        List<String> permutaciones = calcularPermutaciones(conjunto);
        for (String permutacion : permutaciones) {
            System.out.println(permutacion);
        }

        System.out.println(permutaciones.size());

        if (!permutaciones.isEmpty()) {
            double probabilidad = 1.0 / permutaciones.size();
            System.out.println("probabilidad " + probabilidad);
        }
    }
}
