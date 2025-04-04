import java.util.*;


interface Item {
    void invVendedor(List<Item> inventario, List<Integer> cantidad);
    void invLeon(List<Item> inventario, List<Integer> cantidad);
}


class Objeto implements Item {
    int dano;
    int velRecarga;
    int cadencia;
    int capacidad;
    protected String nombre;
    protected double pCompra;
    protected double pVenta;

    public Objeto(String nombre, double pCompra) {
        this.nombre = nombre;
        this.pCompra = pCompra;
        this.pVenta = pCompra * 1.25;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPCompra() {
        return pCompra;
    }
    
    public double getPVenta() {
        return pVenta;
    }
    
    @Override
public void invVendedor(List<Item> inventario, List<Integer> cantidad) {
    int indice = inventario.indexOf(this);
    if (indice == -1) {
        System.out.println("Error: No se encontró el objeto en el inventario.");
        return;
    }
    System.out.println(getNombre() + " x" + cantidad.get(indice) + " (" + getPCompra() + ")");
    // Elimina las líneas que muestran las estadísticas
}

    @Override
    public void invLeon(List<Item> inventario, List<Integer> cantidad) {
        int indice = inventario.indexOf(this);
            if (indice == -1) {
                System.out.println("Error: No se encontró el objeto en el inventario.");
                return;
            }


System.out.println(" " + 
    "|".repeat(Math.min(dano, 6)) + "-".repeat(Math.max(0, 6 - dano)) + " " +
    "|".repeat(Math.min(velRecarga, 3)) + "-".repeat(Math.max(0, 3 - velRecarga)) + " " +
    "|".repeat(Math.min(cadencia, 6)) + "-".repeat(Math.max(0, 6 - cadencia)) + " " +
    "|".repeat(Math.min(capacidad, 3)) + "-".repeat(Math.max(0, 3 - capacidad)));
        } 


 
    
    
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Objeto)) return false;
        Objeto other = (Objeto) obj;
        return this.nombre.equals(other.nombre);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}


class Arma implements Item {
    private Objeto objeto; 
    int dano;
    int velRecarga;
    int cadencia;
    int capacidad;

    public Arma(String nombre, double pCompra, int dano, int velRecarga, int cadencia, int capacidad) {
        this.objeto = new Objeto(nombre, pCompra);
        this.dano = dano;
        this.velRecarga = velRecarga;
        this.cadencia = cadencia;
        this.capacidad = capacidad;
    }
    public Arma clone() {
        return new Arma(
            this.getNombre(),
            this.getPCompra(),
            this.dano,
            this.velRecarga,
            this.cadencia,
            this.capacidad
        );
    }
    
    public String getNombre() {
        return objeto.getNombre();
    }
    
    public double getPCompra() {
        return objeto.getPCompra();
    }
    
    public double getPVenta() {
        return objeto.getPVenta();
    }
    
    @Override
    public void invVendedor(List<Item> inventario, List<Integer> cantidad) {
        int indice = inventario.indexOf(this);
        if (indice == -1) {
            System.out.println("Error: No se encontró el objeto en el inventario.");
            return;
        }
        System.out.println(getNombre() + " x" + cantidad.get(indice) + " (" + getPCompra() + ")");
        System.out.println(" Daño Vel.Recarga Cadencia Capacidad");
        System.out.println(" " + 
            "|".repeat(Math.min(dano, 6)) + "-".repeat(Math.max(0, 6 - dano)) + " " +
            "|".repeat(Math.min(velRecarga, 3)) + "-".repeat(Math.max(0, 3 - velRecarga)) + " " +
            "|".repeat(Math.min(cadencia, 6)) + "-".repeat(Math.max(0, 6 - cadencia)) + " " +
            "|".repeat(Math.min(capacidad, 3)) + "-".repeat(Math.max(0, 3 - capacidad)));
    }
    
    @Override
    public void invLeon(List<Item> inventario, List<Integer> cantidad) {
        int indice = inventario.indexOf(this);
        if (indice == -1) {
            System.out.println("Error: No se encontró el objeto en el inventario.");
            return;
        }


System.out.println(" " + 
    "|".repeat(Math.min(dano, 6)) + "-".repeat(Math.max(0, 6 - dano)) + " " +
    "|".repeat(Math.min(velRecarga, 3)) + "-".repeat(Math.max(0, 3 - velRecarga)) + " " +
    "|".repeat(Math.min(cadencia, 6)) + "-".repeat(Math.max(0, 6 - cadencia)) + " " +
    "|".repeat(Math.min(capacidad, 3)) + "-".repeat(Math.max(0, 3 - capacidad)));
    }
    
    public void invMejora() {
        System.out.println("\nMejorar " + objeto.getNombre());
        System.out.println("1. Daño " + "|".repeat(dano) + "-".repeat(6 - dano) + " " + (10000 - 8000 * (1 - dano / 6.0)) + " $");
        System.out.println("2. Vel.Recarga " + "|".repeat(velRecarga) + "-".repeat(3 - velRecarga) + " " + (10000 - 8000 * (1 - velRecarga / 3.0)) + " $");
        System.out.println("3. Cadencia " + "|".repeat(cadencia) + "-".repeat(6 - cadencia) + " " + (10000 - 8000 * (1 - cadencia / 6.0)) + " $");
        System.out.println("4. Capacidad " + "|".repeat(capacidad) + "-".repeat(3 - capacidad) + " " + (10000 - 8000 * (1 - capacidad / 3.0)) + " $");
    }
    
    @Override
public boolean equals(Object obj) {
    if (obj instanceof Arma) {
        Arma other = (Arma) obj;
        return this.getNombre().equals(other.getNombre()); 
    }
    return false;
}
    
    @Override
    public int hashCode() {
        return getNombre().hashCode();
    }
}


class Leon {
    private List<Item> inventario;
    private List<Integer> cantidad;
    private double dinero;

    public Leon(List<Item> inventario, List<Integer> cantidad, double dinero) {
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.dinero = dinero;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }


    public void vender(Vendedor vendedor) {
        boolean bandera = false;
        Scanner sc = new Scanner(System.in);
        while (!bandera) {
            System.out.println("\n----------* INVENTARIO *----------");
            System.out.println("Dinero: " + dinero);
            for (int i = 0; i < inventario.size(); i++) {
                System.out.print((i + 1) + ". ");
                inventario.get(i).invLeon(inventario, cantidad);
            }
            System.out.println((inventario.size() + 1) + ". Volver");
            System.out.print("Vender: ");
            int opcion = sc.nextInt();
            if (opcion == inventario.size() + 1) {
                bandera = true;
            } else if (opcion >= 1 && opcion <= inventario.size()) {
                Item obj = inventario.get(opcion - 1);
                int indice = opcion - 1;
                if (cantidad.get(indice) > 0) {
                    double precioVenta = (obj instanceof Objeto) ? ((Objeto)obj).getPVenta() : ((Arma)obj).getPVenta();
                    dinero += precioVenta;
                    cantidad.set(indice, cantidad.get(indice) - 1);
                    if (vendedor.getInventario().contains(obj)) {
                        int idx = vendedor.getInventario().indexOf(obj);
                        vendedor.getCantidad().set(idx, vendedor.getCantidad().get(idx) + 1);
                    } else {
                        vendedor.getInventario().add(obj);
                        vendedor.getCantidad().add(1);
                    }
                    String nombreObj = (obj instanceof Objeto) ? ((Objeto)obj).getNombre() : ((Arma)obj).getNombre();
                    System.out.println("Vendido " + nombreObj + " por " + precioVenta);
                } else {
                    String nombreObj = (obj instanceof Objeto) ? ((Objeto)obj).getNombre() : ((Arma)obj).getNombre();
                    System.out.println("No hay suficiente cantidad de " + nombreObj);
                }
            } else {
                System.out.println("Opción inválida");
            }
        }

    }
}


class Vendedor {
    private List<Item> inventario;
    private List<Integer> cantidad;
    private double dinero;

    public Vendedor(List<Item> inventario, List<Integer> cantidad, double dinero) {
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.dinero = dinero;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }

    public double getDinero() {
        return dinero;
    }

    public void vender(Leon leon) {
        
        boolean bandera = false;
        Scanner sc = new Scanner(System.in); 
        int opcion;  
    
        while (!bandera) {
            System.out.println("\n----------* TIENDA *----------");
            System.out.println("Dinero: " + leon.getDinero());
    
            for (int i = 0; i < inventario.size(); i++) {
                System.out.print((i + 1) + ". ");
                inventario.get(i).invVendedor(inventario, cantidad);  
            }
    
            System.out.println((inventario.size() + 1) + ". Volver");
            System.out.print("Comprar: ");
    
            opcion = sc.nextInt();  
    
            if (opcion == inventario.size() + 1) {
                bandera = true;
            } else if (opcion >= 1 && opcion <= inventario.size()) {
                int indice = opcion - 1;
                Item obj = inventario.get(indice);
                
              
                if (cantidad.get(indice) <= 0) {
                    System.out.println("Este objeto está agotado.");
                    continue;
                }
    
                double precioCompra;
                String nombreObj;
    
                if (obj instanceof Objeto) {
                    precioCompra = ((Objeto) obj).getPCompra();
                    nombreObj = ((Objeto) obj).getNombre();
                } else if (obj instanceof Arma) {
                    precioCompra = ((Arma) obj).getPCompra();
                    nombreObj = ((Arma) obj).getNombre();
                } else {
                    System.out.println("Error: El objeto no es válido.");
                    continue;
                }
    
                if (leon.getDinero() >= precioCompra) {
                    leon.setDinero(leon.getDinero() - precioCompra);
                    cantidad.set(indice, cantidad.get(indice) - 1);
    
                    if (leon.getInventario().contains(obj)) {
                        int idx = leon.getInventario().indexOf(obj);
                        leon.getCantidad().set(idx, leon.getCantidad().get(idx) + 1);
                    } else {
                        if (obj instanceof Arma) {
                            Arma clon = ((Arma) obj).clone();
                            leon.getInventario().add(clon);
                        } else {
                            leon.getInventario().add(obj);
                        }
                        leon.getCantidad().add(1);
                   }
    
                    System.out.println("Comprado " + nombreObj + " por " + precioCompra);
                } else {
                    System.out.println("Dinero insuficiente.");
                }
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    

    public void mejorar(Leon leon) {
        boolean bandera = false;
        Scanner sc = new Scanner(System.in);
        while (!bandera) {
            System.out.println("\n----------* MEJORAR *----------");
            System.out.println("Dinero: " + leon.getDinero());
            List<Arma> armas = new ArrayList<>();
            for (Item item : leon.getInventario()) {
                if (item instanceof Arma) {
                    armas.add((Arma)item);
                }
            }
            if (armas.isEmpty()) {
                System.out.println("No tienes armas para mejorar");
                return;
            }
            for (int i = 0; i < armas.size(); i++) {
                System.out.println((i + 1) + ". " + armas.get(i).getNombre());
            }
            System.out.println((armas.size() + 1) + ". Volver");
            System.out.print("Selección: ");
            int opcion = sc.nextInt();
            if (opcion == armas.size() + 1) {
                bandera = true;
            } else if (opcion >= 1 && opcion <= armas.size()) {
                Arma arma = armas.get(opcion - 1);
                arma.invMejora();
                System.out.print("Selección: ");
                int opcionMejora = sc.nextInt();
                if (opcionMejora == 5) {
                    return;
                } else if (opcionMejora >= 1 && opcionMejora <= 4) {
                    int atributo = 0;
                    switch (opcionMejora) {
                        case 1:
                            atributo = arma.dano;
                            break;
                        case 2:
                            atributo = arma.velRecarga;
                            break;
                        case 3:
                            atributo = arma.cadencia;
                            break;
                        case 4:
                            atributo = arma.capacidad;
                            break;
                    }
                    int maxVal = 0;
                    switch (opcionMejora) {
                        case 1:
                        case 3:
                            maxVal = 6;
                            break;
                        case 2:
                        case 4:
                            maxVal = 3;
                            break;
                    }
                    double precio = 10000 - 8000 * (1 - atributo / (double) maxVal);
                    if (atributo >= maxVal) {
                        System.out.println("Atributo al máximo");
                        return;
                    }
                    if (leon.getDinero() < precio) {
                        System.out.println("Dinero insuficiente");
                        return;
                    }
                    leon.setDinero(leon.getDinero() - precio);
                    
                    switch (opcionMejora) {
                        case 1:
                            arma.dano = Math.min(arma.dano + 1, 6); 
                            break;
                        case 2:
                            arma.velRecarga = Math.min(arma.velRecarga + 1, 3); 
                        case 3:
                            arma.cadencia = Math.min(arma.cadencia + 1, 6);
                        case 4:
                            arma.capacidad = Math.min(arma.capacidad + 1, 3); 
                            break;
                    }
                    System.out.println("¡Mejora exitosa!");
                } else {
                    System.out.println("Opción inválida");
                }
            }
        }
        
    }
}
