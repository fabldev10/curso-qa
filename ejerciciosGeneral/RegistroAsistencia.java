import java.util.*;

public class RegistroAsistencia {
    public static void main(String[] args) {
        Map<String, List<String>> registroAsistencia = new HashMap<>();

        // Registrar Asistencia
        registrarAsistencia(registroAsistencia, "Conferencia A", "Juan");
        registrarAsistencia(registroAsistencia, "Conferencia A", "Maria");
        registrarAsistencia(registroAsistencia, "Taller B", "Pedro");
        registrarAsistencia(registroAsistencia, "Taller B", "Laura");
        
        // Consultar Asistentes
        consultarAsistentes(registroAsistencia, "Conferencia A");
        consultarAsistentes(registroAsistencia, "Taller B");
    }

    // Registrar Asistencia
    public static void registrarAsistencia(Map<String, List<String>> registro, String evento, String persona) {
        registro.putIfAbsent(evento, new ArrayList<>());
        registro.get(evento).add(persona);
        System.out.println(persona + " ha sido registrado/a en " + evento);
    }

    // Consultar Asistentes
    public static void consultarAsistentes(Map<String, List<String>> registro, String evento) {
        List<String> asistentes = registro.get(evento);
        if (asistentes != null) {
            System.out.println("Asistentes a " + evento + ":");
            for (String persona : asistentes) {
                System.out.println(persona);
            }
        } else {
            System.out.println("No hay asistentes registrados para " + evento);
        }
    }
}