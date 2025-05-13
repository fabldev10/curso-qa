
public class Corredor {
    String nombre;
    String equipo;
    String duracion;

    
    
    public Corredor() {
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public Corredor(String nombre, String equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    

    

    
}
