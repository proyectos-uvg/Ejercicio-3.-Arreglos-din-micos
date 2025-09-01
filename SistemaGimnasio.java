import java.util.ArrayList;

public class SistemaGimnasio {
    private ArrayList<Miembro> miembros;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Rutina> rutinas;
    
    public SistemaGimnasio() {
        this.miembros = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }
    
    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }
    
    public void agregarEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }
    
    public void agregarRutina(Rutina rutina) {
        rutinas.add(rutina);
    }
    
    public Miembro buscarMiembroPorId(int id) {
        for (Miembro miembro : miembros) {
            if (miembro.getId() == id) {
                return miembro;
            }
        }
        return null;
    }
    
    public Entrenador buscarEntrenadorPorId(int id) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getId() == id) {
                return entrenador;
            }
        }
        return null;
    }
    
    public Rutina buscarRutinaPorId(int id) {
        for (Rutina rutina : rutinas) {
            if (rutina.getId() == id) {
                return rutina;
            }
        }
        return null;
    }
    
    public boolean asignarEntrenadorAMiembro(int idMiembro, int idEntrenador) {
        Miembro miembro = buscarMiembroPorId(idMiembro);
        Entrenador entrenador = buscarEntrenadorPorId(idEntrenador);
        
        if (miembro != null && entrenador != null) {
            Entrenador entrenadorAnterior = miembro.getEntrenadorAsignado();
            if (entrenadorAnterior != null) {
                entrenadorAnterior.removerMiembro(miembro);
            }
            
            miembro.setEntrenadorAsignado(entrenador);
            entrenador.agregarMiembro(miembro);
            return true;
        }
        return false;
    }
    
    public boolean asignarRutinaAMiembro(int idMiembro, int idRutina) {
        Miembro miembro = buscarMiembroPorId(idMiembro);
        Rutina rutina = buscarRutinaPorId(idRutina);
        
        if (miembro != null && rutina != null) {
            miembro.agregarRutina(rutina);
            return true;
        }
        return false;
    }
    
    public Rutina getRutinaMasPopular() {
        Rutina rutinaMasPopular = null;
        int maxPracticantes = -1;
        
        for (Rutina rutina : rutinas) {
            if (rutina.getCantidadPracticantes() > maxPracticantes) {
                maxPracticantes = rutina.getCantidadPracticantes();
                rutinaMasPopular = rutina;
            }
        }
        
        return rutinaMasPopular;
    }
    
    public int getTotalRutinasActivas() {
        int contador = 0;
        for (Rutina rutina : rutinas) {
            if (rutina.getCantidadPracticantes() > 0) {
                contador++;
            }
        }
        return contador;
    }
    
    public Entrenador getEntrenadorConMasAlumnos() {
        Entrenador entrenadorConMasAlumnos = null;
        int maxAlumnos = -1;
        
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getCantidadMiembros() > maxAlumnos) {
                maxAlumnos = entrenador.getCantidadMiembros();
                entrenadorConMasAlumnos = entrenador;
            }
        }
        
        return entrenadorConMasAlumnos;
    }
    
    public ArrayList<Miembro> getMiembros() {
        return new ArrayList<>(miembros);
    }
    
    public ArrayList<Entrenador> getEntrenadores() {
        return new ArrayList<>(entrenadores);
    }
    
    public ArrayList<Rutina> getRutinas() {
        return new ArrayList<>(rutinas);
    }
}