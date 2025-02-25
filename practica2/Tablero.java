package practica2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Tablero {

    private static final int TAMAÑO = 30;
    private int[][] estadoActual=new int[TAMAÑO][TAMAÑO];
    private int[][] estadoSiguiente=new int [TAMAÑO][TAMAÑO];

    public void leerEstadoActual() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Guille\\Documents\\GitHub\\1-PruebaEvaluacion-TecnicasProgramacion-\\practica2\\matriz"))) {
            String linea;
            int fila = 0;
            while ((linea = br.readLine()) != null && fila < TAMAÑO) {
                for(int col=0;col<TAMAÑO;col++) {
                    estadoActual[fila][col] = Character.getNumericValue(linea.charAt(col));
                }
                fila++;
            }
        }catch (IOException e){
            System.out.println("Error al leer el archivo: "+e.getMessage());
        }
    }

    public void generarEstadoActual() {
        Random random =new Random();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                double aleatorio=random.nextDouble();
                if (aleatorio<0.5){
                    estadoActual[i][j] = 1;
                }else{
                    estadoActual[i][j] = 0;
                }
            }
        }
    }

    public void leerEstadoSiguiente() {
        for(int i=0;i<TAMAÑO;i++){
            for(int j=0;j<TAMAÑO;j++){
                int vecinosVivos=contarVecinosVivos(i,j);
                if(estadoActual[i][j]==1){
                    estadoSiguiente[i][j]=(vecinosVivos==2||vecinosVivos==3)?1:0;
                }else{
                    estadoSiguiente[i][j]=(vecinosVivos==3)?1:0;
                }
            }
        }
        for(int i=0;i<TAMAÑO;i++){
            System.arraycopy(estadoSiguiente[i],0,estadoActual[i],0,TAMAÑO);
        }
    }

    public int contarVecinosVivos(int f, int c){
        int vivos=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0 && j==0) continue;{
                    int nuevaFila=f+i;
                    int nuevaColumna=c+j;
                    if(nuevaFila>=0 && nuevaFila<TAMAÑO && nuevaColumna>=0 && nuevaColumna<TAMAÑO){
                        vivos+=estadoActual[nuevaFila][nuevaColumna];
                    }
                }
            }
        }
        return vivos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<TAMAÑO;i++){
            for (int j=0;j<TAMAÑO;j++){
                sb.append(estadoActual[i][j]==1 ? "x" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
