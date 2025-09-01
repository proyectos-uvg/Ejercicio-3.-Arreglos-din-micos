import java.util.ArrayList;

public class Miembro {
    private int id;
    private String nombre;
    private String tipoMembresia;
    private Entrenador entrenadorAsignado;
    private ArrayList<Rutina> rutinasAsignadas;
    
    public Miembro(int id, String nombre, String tipoMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.tipoMembresia = tipoMembresia;
        this.entrenadorAsignado = null;
        this.rutinasAsignadas = new ArrayList<>();
    }
    
    public void agregarRutina(Rutina rutina) {
        if (!rutinasAsignadas.contains(rutina)) {
            rutinasAsignadas.add(rutina);
            rutina.incrementarPracticantes();
        }
    }
    
    public boolean removerRutina(Rutina rutina) {
        boolean removido = rutinasAsignadas.remove(rutina);
        if (removido) {
            rutina.decrementarPracticantes();
        }
        return removido;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTipoMembresia() {
        return tipoMembresia;
    }
    
    public Entrenador getEntrenadorAsignado() {
        return entrenadorAsignado;
    }
    
    public void setEntrenadorAsignado(Entrenador entrenadorAsignado) {
        this.entrenadorAsignado = entrenadorAsignado;
    }
    
    public ArrayList<Rutina> getRutinasAsignadas() {
        return new ArrayList<>(rutinasAsignadas);
    }
}