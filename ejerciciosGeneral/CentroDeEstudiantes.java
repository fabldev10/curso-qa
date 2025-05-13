import java.util.HashMap;
import java.util.Map;

public class CentroDeEstudiantes {

    private Map<String, String> votos;

    public CentroDeEstudiantes() {
        votos = new HashMap<>();
    }

    public void votar(String identificadorEstudiante, String candidato) {
        votos.put(identificadorEstudiante, candidato);
    }

    public static void main(String[] args) {
        CentroDeEstudiantes centro = new CentroDeEstudiantes();

        centro.votar("estudiante1", "candidatoA");
        centro.votar("estudiante2", "candidatoB");
        
        

        System.out.println("Votos registrados:");
        for (Map.Entry<String, String> entry : centro.votos.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + ", Voto: " + entry.getValue());
        }
    }
}