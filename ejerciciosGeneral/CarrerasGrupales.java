import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CarrerasGrupales {
    static Scanner scanner = new Scanner(System.in);
        

    public static void main(String[] args) {

    List<Corredor> corredores = new ArrayList<>();
    
    Corredor c1 = new Corredor("Cavani", "Boca");
    Corredor c2 = new Corredor("Barco", "Boca");
    Corredor c3 = new Corredor("Advincula", "Boca");
    
    Corredor c4 = new Corredor("Barco", "Riber");
    Corredor c5 = new Corredor("De la Cruz", "Riber");
    Corredor c6 = new Corredor("Perez", "Riber");

    corredores.add(c1);
    corredores.add(c2);
    corredores.add(c3);
    corredores.add(c4);
    corredores.add(c5);
    corredores.add(c6);


    LocalDateTime inicioCarrera = LocalDateTime.of(2023,8,10,18,00,00);
    Carrera carrera1 = new Carrera(corredores,inicioCarrera);
    
        
        Integer opcion=0;
        do{
        System.out.println("1-Registrar corredor");
        System.out.println("2-Descalificar equipo");
        System.out.println("0-Salir");
        switch(opcion){
            case 1: registrarCorredor();
            break;
            case 2: descalificarEquipo();
            break;
            case 3: System.out.println("Fin...");;
            break;
            default: System.out.println("Opcion invalida...");
            break;
        }
        }while(opcion!=0);
    }

    private static void descalificarEquipo() {
    }

    private static void registrarCorredor() {
        Corredor corredor1 = new Corredor();
        System.out.println("Ingrese nombre del corredor:");
        corredor1.nombre = scanner.nextLine();
        System.out.println("Ingrese nombre del equipo");
        corredor1.equipo = scanner.nextLine();
        System.out.println("Hora de finalizacion de la carrera");
        corredor1.duracion = scanner.nextLine();



    }
}
