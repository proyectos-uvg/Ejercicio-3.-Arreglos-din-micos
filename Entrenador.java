import java.util.ArrayList;

public class Entrenador {
    private int id;
    private String nombre;
    private String especialidad;
    private ArrayList<Miembro> miembrosAsignados;
    
    public Entrenador(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.miembrosAsignados = new ArrayList<>();
    }
    
    public void agregarMiembro(Miembro miembro) {
        if (!miembrosAsignados.contains(miembro)) {
            miembrosAsignados.add(miembro);
        }
    }
    
    public boolean removerMiembro(Miembro miembro) {
        return miembrosAsignados.remove(miembro);
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public ArrayList<Miembro> getMiembrosAsignados() {
        return new ArrayList<>(miembrosAsignados);
    }
    
    public int getCantidadMiembros() {
        return miembrosAsignados.size();
    }
}