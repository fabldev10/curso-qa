import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    List<Corredor> corredores = new ArrayList<>();
    LocalDateTime inicio;
    public Carrera(List<Corredor> corredores, LocalDateTime inicio) {
        this.corredores = corredores;
        this.inicio = inicio;
    }
    public List<Corredor> getCorredores() {
        return corredores;
    }
    public LocalDateTime getInicio() {
        return inicio;
    }
    public void setCorredores(List<Corredor> corredores) {
        this.corredores = corredores;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }
    
    
    
}
