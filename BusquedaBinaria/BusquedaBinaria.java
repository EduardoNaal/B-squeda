
public class BusquedaBinaria {

    public static int busquedaBinaria(int[] arr, int buscar) {
        int inicio = 0, fin = arr.length - 1, centro = (int) Math.ceil((inicio + fin) / 2);

        while (inicio <= fin) {
            centro = (int) Math.ceil((inicio + fin) / 2);

            if (arr[centro] == buscar) {
                System.out.println("inicio: " + inicio + ", fin: " + fin + ", centro: " + arr[centro] + ", valor de centro: " + centro);
                return centro;
            } else if (arr[centro] < buscar) {
                inicio = centro + 1;
            } else {
                fin = centro - 1;
            }
            System.out.println("inicio: " + inicio + ", fin: " + fin + ", centro: " + arr[centro] + ", valor de centro: " + centro);
        }
        return -1;
    }

}
