import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear grafo");
            System.out.println("2. Mostrar grafo");
            System.out.println("3. Mostrar cantidad de nodos del grafo");
            // System.out.println("4. Recorrido en profundidad");
            System.out.println("5. Búsqueda de nodo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    grafo = crearGrafo();
                    break;
                case 2:
                    System.out.println(grafo);
                    break;
                case 3:
                    System.out.println("Cantidad de nodos: " + grafo.getCantidadNodos());
                    break;
                case 4:
                    ArrayList<Nodo> listaVisitados = new ArrayList<>();
                    listaVisitados = recorridoProfundidad(grafo);
                    for (int i = 0; i < listaVisitados.size(); i++) {
                        System.out.println("Posicion " + i + " Nodo: " + listaVisitados.get(i));
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el valor del nodo:");
                    String buscar = scanner.next();
                    int busqueda = busquedaNodo(grafo, buscar);
                    if (busqueda == -1) {
                        System.out.println("El nodo no existe");
                    } else {
                        System.out.println("La posicion del nodo en el grafo es: " + busqueda);
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    public static Grafo crearGrafo() {
        ArrayList<Nodo> listaNodos = new ArrayList<Nodo>();
        int cantidad, opcion;
        String valorNodo;
        System.out.println("Ingrese la cantidad de nodos a agregar");
        cantidad = scanner.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Indique el valor del nodo");
            valorNodo = scanner.next();
            Nodo nodo = new Nodo(valorNodo);
            listaNodos.add(nodo);
        }
        System.out.println("2. Listas de adyacencia");
        do {
            System.out.println("¿Crear conexión? \n1. Si\t2. NO");
            opcion = scanner.nextInt();
            if (opcion == 1) {
                crearConexion(listaNodos, cantidad);
            }
        } while (opcion == 1);
        Grafo grafo = new Grafo();
        for (int i = 0; i < listaNodos.size(); i++) {
            Nodo temp = listaNodos.get(i);
            grafo.agregarNodo(temp);
        }
        return grafo;
    }

    public static void crearConexion(ArrayList<Nodo> listaNodos, int cantidadNodos) {
        String valorNodo, nodoFinTemp;
        Nodo nodoInicio, nodoFin;
        boolean bandera = false;
        do {
            System.out.println("Digite el nodo incio");
            valorNodo = scanner.next();
            nodoInicio = busqueda(listaNodos, valorNodo);
            if (nodoInicio == null) {
                System.out.println("Valor NO Encontrado.\n");
            } else {
                do {
                    System.out.println("Ingrese el valor del nodo que este conecta");
                    nodoFinTemp = scanner.next();
                    nodoFin = busqueda(listaNodos, nodoFinTemp);
                    if (nodoFin == null) {
                        System.out.println("Valor NO Encontrado.\n");
                    } else {
                        System.out.println("Ingrese el peso");
                        nodoInicio.setAristas(new Arista(nodoInicio, nodoFin, scanner.nextInt()));
                        System.out.println("Conexión establecida");
                        bandera = true;
                    }
                } while (nodoFin == null);
            }
        } while (bandera == false);
    }


    public static ArrayList<Nodo> recorridoProfundidad(Grafo grafo) {

        ArrayList<Nodo> listaVisitados = new ArrayList<>();

        return listaVisitados;
    }


    public static int busquedaNodo(Grafo grafo, String valorBuscado) {
        int posicion = -1;
        List<Nodo> listaNodos = grafo.getNodos();

        for (int i = 0; i < listaNodos.size(); i++) {
            Nodo nodoTemp = listaNodos.get(i);
            if (nodoTemp.getDato().equals(valorBuscado)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static Nodo busqueda(ArrayList<Nodo> listaNodos, String valorBuscado) {
        Nodo nodoInicio = null;
        for (int i = 0; i < listaNodos.size(); i++) {
            Nodo temp = listaNodos.get(i);
            if (temp.getDato().equals(valorBuscado)) {
                nodoInicio = temp;
                return nodoInicio;
            }
        }
        return nodoInicio;
    }
}
