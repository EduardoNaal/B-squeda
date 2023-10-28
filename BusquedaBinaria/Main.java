
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] arr = new int[1000];

        for (int i = 0; i < 1000; i++) {
            arr[i] = (int) (Math.random() * 1000) + 1;
        }

        System.out.println("arreglo original" + Arrays.toString(arr));
        arr = QuickSort.quickSort(arr);
        System.out.println("arreglo ordenado" + Arrays.toString(arr));

        System.out.println("Ingrese el numero que deseas buscar: ");
        int buscar = leer.nextInt();

        int encontrado = BusquedaBinaria.busquedaBinaria(arr, buscar);

        if (encontrado != -1) {
            System.out.println("\nSE ENCONTRO el numero: " + buscar + ", se encuentra en la posicion: " + encontrado);
        } else {
            System.err.println("\nNO SE ENCONTRO el numero: " + buscar);
        }
    }
}
