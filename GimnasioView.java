public class GimnasioView {
    private MenuHandler menuHandler;
    
    public GimnasioView() {
        this.menuHandler = new MenuHandler();
    }
    
    public int mostrarMenuPrincipal() {
        return menuHandler.leerEnteroEnRango("Seleccione una opción (1-7): ", 1, 7);
    }
    
    public int mostrarMenuReportes() {
        return menuHandler.leerEnteroEnRango("Seleccione un reporte (1-4): ", 1, 4);
    }
    
    public String[] solicitarDatosMiembro() {
        String[] datos = new String[3];
        
        datos[0] = String.valueOf(menuHandler.leerEntero("ID del miembro: "));
        datos[1] = menuHandler.leerTexto("Nombre del miembro: ");
        datos[2] = menuHandler.leerTexto("Tipo de membresía: ");
        
        return datos;
    }
    
    public String[] solicitarDatosEntrenador() {
        String[] datos = new String[3];
        
        datos[0] = String.valueOf(menuHandler.leerEntero("ID del entrenador: "));
        datos[1] = menuHandler.leerTexto("Nombre del entrenador: ");
        datos[2] = menuHandler.leerTexto("Especialidad: ");
        
        return datos;
    }
    
    public String[] solicitarDatosRutina() {
        String[] datos = new String[4];
        
        datos[0] = String.valueOf(menuHandler.leerEntero("ID de la rutina: "));
        datos[1] = menuHandler.leerTexto("Nombre de la rutina: ");
        datos[2] = menuHandler.leerTexto("Descripción: ");
        datos[3] = menuHandler.leerTexto("Tipo de rutina: ");
        
        return datos;
    }
    
    public int solicitarIdMiembro() {
        return menuHandler.leerEntero("Ingrese el ID del miembro: ");
    }
    
    public int solicitarIdEntrenador() {
        return menuHandler.leerEntero("Ingrese el ID del entrenador: ");
    }
    
    public int solicitarIdRutina() {
        return menuHandler.leerEntero("Ingrese el ID de la rutina: ");
    }
    
    public void mostrarMensajeExito(String mensaje) {
        // GUI handles success messages
    }
    
    public void mostrarMensajeError(String mensaje) {
        // GUI handles error messages
    }
    
    public void mostrarRutinaMasPopular(Rutina rutina) {
        // GUI handles report display
    }
    
    public void mostrarTotalRutinasActivas(int total) {
        // GUI handles report display
    }
    
    public void mostrarEntrenadorConMasAlumnos(Entrenador entrenador) {
        // GUI handles report display
    }
    
    public void mostrarMensajeDespedida() {
        menuHandler.cerrarScanner();
    }
}