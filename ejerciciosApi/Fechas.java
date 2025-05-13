import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Fechas {
    Scanner scanner = new Scanner(System.in);
    String cadenaFecha = null;
    LocalDate fecha = null;
    public static void main(String[] args) {
        
        //Ejercicio 3
         Scanner scanner = new Scanner(System.in);
        /*String fecha = null;
        System.out.println("Ingrese un dia:");
        fecha = scanner.nextLine();
        System.out.println("Ingrese un mes");
        fecha = fecha + "/" + scanner.nextLine();
        System.out.println("Ingrese un año");
        fecha = fecha + "/" + scanner.nextLine();
        
        LocalDate fechaLD;
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fechaLD = LocalDate.parse(fecha,formateador);
        System.out.println("Fecha con LocalDate:" + fechaLD);

        //Ejercicio 4
        fecha = null;
        System.out.println("Ingrese un dia:");
        fecha = scanner.nextLine();
        System.out.println("Ingrese un mes");
        fecha = fecha + "." + scanner.nextLine();
        System.out.println("Ingrese un año");
        fecha = fecha + "." + scanner.nextLine();
        
        DateTimeFormatter formateador2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate fechaLD2 = LocalDate.parse(fecha,formateador2);
        DateTimeFormatter formateador3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNueva = fechaLD2.format(formateador3);
        System.out.println("Fecha con LocalDate:" + fechaNueva);
        
        String fecha= null;
        System.out.println("Ingrese una fecha(dd/mm/yyyy):");
        fecha = scanner.nextLine();

        
        DateTimeFormatter formateador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaLD2 = LocalDate.parse(fecha,formateador2);
        LocalDate nuevaFecha = fechaLD2.plusDays(15).plusYears(3).plusMonths(2);
        System.out.println("El dia de la semana de la fecha es:" + nuevaFecha.getDayOfWeek());
        

        String fecha= null;
        System.out.println("Ingrese una fecha(dd/mm/yyyy):");
        fecha = scanner.nextLine();

        
        DateTimeFormatter formateador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaLD2 = LocalDate.parse(fecha,formateador2);
        LocalDate nuevaFecha = fechaLD2.minusDays(13).minusYears(1).minusMonths(10);
        System.out.println("El dia de la semana de la fecha es:" + nuevaFecha.getDayOfWeek() + "Fecha:"+ nuevaFecha);
        
        String fecha= null;
        System.out.println("Ingrese una fecha(dd/mm/yyyy):");
        fecha = scanner.nextLine();

        
        DateTimeFormatter formateador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaLD2 = LocalDate.parse(fecha,formateador2);
        System.out.println(fechaLD2.isLeapYear());
        */
        
        /*String fecha= null;
        LocalDate fechaJuego = null;
        System.out.println("Ingrese una fecha(dd/mm/yyyy):");
        fecha = scanner.nextLine();
        

        
        DateTimeFormatter formateador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaLD2 = LocalDate.parse(fecha,formateador2);
        */
        // Crear una instancia de Random para generar números aleatorios
        LocalTime horaInicio = LocalTime.now();
        LocalTime horaFin = LocalTime.of(23,59,59);
        long h = ChronoUnit.HOURS.between(horaInicio, horaFin);
        long m = ChronoUnit.MINUTES.between(horaInicio, horaFin);
        long s = ChronoUnit.SECONDS.between(horaInicio, horaFin);
        System.out.println("Horas: "+h+" Minutos: "+m+" Segundos: "+s);
        

        
    }




    


}