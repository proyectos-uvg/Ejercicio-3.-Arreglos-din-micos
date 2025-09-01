public class Rutina {
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int cantidadPracticantes;
    
    public Rutina(int id, String nombre, String descripcion, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidadPracticantes = 0;
    }
    
    public void incrementarPracticantes() {
        this.cantidadPracticantes++;
    }
    
    public void decrementarPracticantes() {
        if (this.cantidadPracticantes > 0) {
            this.cantidadPracticantes--;
        }
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public int getCantidadPracticantes() {
        return cantidadPracticantes;
    }
}