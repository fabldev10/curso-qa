import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TurnoService {
    private ArrayList<Integer> turnosList;
    private Random random;

    public TurnoService() {
        turnosList = new ArrayList<>();
        random = new Random();
    }

    public void tomarNumero(int numero) {
        turnosList.add(numero);
    }

    public int atenderSiguiente() {
        if (!turnosList.isEmpty()) {
            int clienteAtendido = turnosList.remove(0);
            return clienteAtendido;
        }
        return -1; // Retorna -1 si no hay clientes en espera
    }

    public int sorteo() {
        if (!turnosList.isEmpty()) {
            int indiceAleatorio = random.nextInt(turnosList.size());
            int clienteSeleccionado = turnosList.remove(indiceAleatorio);
            return clienteSeleccionado;
        }
        return -1; // Retorna -1 si no hay clientes en espera
    }

    public int buscarTurno(int numero) {
        for (int i = 0; i < turnosList.size(); i++) {
            if (turnosList.get(i) == numero) {
                return i;
            }
        }
        return -1; // Retorna -1 si el número de turno no se encuentra en la lista
    }

    public void imprimirTurnosEnEspera() {
        System.out.println("Clientes en espera:");
        for (int turno : turnosList) {
            System.out.println("Turno: " + turno);
        }
    }

    public static void main(String[] args) {
        TurnoService turnoService = new TurnoService();

        turnoService.tomarNumero(1);
        turnoService.tomarNumero(2);
        turnoService.tomarNumero(3);
        turnoService.tomarNumero(4);
        turnoService.tomarNumero(5);
        turnoService.tomarNumero(6);
        turnoService.tomarNumero(7);
        turnoService.tomarNumero(8);
        turnoService.tomarNumero(9);
        turnoService.tomarNumero(10);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Menú de opciones:");
        System.out.println("1. Ingresar cliente");
        System.out.println("2. Atender proximo cliente");
        System.out.println("3. Sorteo de cliente");
        System.out.println("4. Buscar turno");
        System.out.println("5. Clientes en espera");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 
        switch (opcion) {
            case 1:
            int nuevoCliente = turnoService.size() + 1;
            turnoService.tomarNumero(nuevoCliente);
            System.out.println("Cliente " + nuevoCliente + " ingresado.");
            break;
            case 2:
                int clienteAtendido = turnoService.atenderSiguiente();
                System.out.println("Cliente atendido: " + clienteAtendido);
                break;
            case 3:
                int clienteSorteado = turnoService.sorteo();
                System.out.println("Cliente sorteado: " + clienteSorteado);
                break;
            case 4:
            System.out.println("Numero a buscar:");
            int numeroBuscado = scanner.nextInt();
            int indiceEncontrado = turnoService.buscarTurno(numeroBuscado);
            if (indiceEncontrado != -1) {
            System.out.println("Número " + numeroBuscado + " encontrado en el índice " + indiceEncontrado);
            } else {
            System.out.println("Número " + numeroBuscado + " no encontrado en la lista.");
            }
            case 5:
            turnoService.imprimirTurnosEnEspera();
            default:
                System.out.println("Opción inválida.");
                break;
    }
}

    private int size() {
        return 0;
    }


}
