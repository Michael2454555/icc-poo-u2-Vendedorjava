import java.util.*;
public class Tienda {
    public static void main(String[] args) {
        // Creación de objetos y armas
        Objeto granada = new Objeto("Granada", 2000);
        Objeto colgante = new Objeto("Colgante", 2500);
        Arma magnum = new Arma("Magnum", 5500, 5, 2, 1, 3);
        Arma escopeta = new Arma("Escopeta", 3200, 4, 1, 1, 3); 
        Arma pistola = new Arma("Pistola", 4000, 4, 2, 2, 3);
        Objeto spray = new Objeto("Spray", 2000);

        // Inventario del Leon (jugador)
        List<Item> inventarioLeon = new ArrayList<>();
        List<Integer> cantidadLeon = new ArrayList<>();
        inventarioLeon.add(spray);
        cantidadLeon.add(4);
        inventarioLeon.add(pistola);
        cantidadLeon.add(1);

        // Inventario de la Tienda (vendedor)
        List<Item> inventarioTienda = new ArrayList<>();
        List<Integer> cantidadTienda = new ArrayList<>();
        inventarioTienda.add(granada);
        cantidadTienda.add(3);
        inventarioTienda.add(colgante);
        cantidadTienda.add(2);
        inventarioTienda.add(magnum);
        cantidadTienda.add(2);
        inventarioTienda.add(escopeta);
        cantidadTienda.add(1);
        inventarioTienda.add(spray);
        cantidadTienda.add(3);

        Leon leon = new Leon(inventarioLeon, cantidadLeon, 200000);
        Vendedor vendedor = new Vendedor(inventarioTienda, cantidadTienda, 100000);

        Scanner sc = new Scanner(System.in);
        boolean bandera = false;
        while (!bandera) {
            System.out.println("\n----------* MENU *----------");
            System.out.println("1. Ir a la tienda");
            System.out.println("2. Mejorar armas");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    vendedor.vender(leon);
                    break;
                case 2:
                    vendedor.mejorar(leon);
                    break;
                case 3:
                    bandera = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        sc.close();
    }
}