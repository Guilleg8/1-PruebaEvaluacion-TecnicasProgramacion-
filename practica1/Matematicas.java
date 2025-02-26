package practica1;
import java.util.Random;

public class Matematicas {
    public static double generarNumeroPi(int puntosTotales){
        double aciertos = 0;
        double areaCuadrado = 4;
        Random random = new Random();
        for (int i = 0; i < puntosTotales; i++) {
            double x = -1 + (2 * random.nextDouble());
            double y = -1 + (2 * random.nextDouble());
            if((x*x)+(y*y)<=1){
                aciertos++;
            }
        }
        return areaCuadrado*(aciertos /puntosTotales);
    }
}
