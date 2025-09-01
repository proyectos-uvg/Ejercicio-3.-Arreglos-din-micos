public class GimnasioController {
    private SistemaGimnasio sistema;
    private GimnasioView vista;
    private GimnasioViewGUI viewGUI;
    
    public GimnasioController() {
        this.sistema = new SistemaGimnasio();
        this.vista = new GimnasioView();
    }
    
    public void setViewGUI(GimnasioViewGUI viewGUI) {
        this.viewGUI = viewGUI;
    }
    
    public SistemaGimnasio getSistema() {
        return sistema;
    }
    
    public void iniciarSistema() {
        int opcion;
        
        do {
            opcion = vista.mostrarMenuPrincipal();
            procesarOpcionPrincipal(opcion);
        } while (opcion != 7);
        
        vista.mostrarMensajeDespedida();
    }
    
    public void procesarOpcionPrincipal(int opcion) {
        switch (opcion) {
            case 1:
                procesarRegistroMiembro();
                break;
            case 2:
                procesarRegistroEntrenador();
                break;
            case 3:
                procesarRegistroRutina();
                break;
            case 4:
                procesarAsignacionEntrenador();
                break;
            case 5:
                procesarAsignacionRutina();
                break;
            case 6:
                procesarGeneracionReportes();
                break;
            case 7:
                break;
        }
    }
    
    public void procesarRegistroMiembro() {
        try {
            String[] datos = vista.solicitarDatosMiembro();
            int id = Integer.parseInt(datos[0]);
            
            if (sistema.buscarMiembroPorId(id) != null) {
                vista.mostrarMensajeError("Ya existe un miembro con ese ID.");
                return;
            }
            
            Miembro nuevoMiembro = new Miembro(id, datos[1], datos[2]);
            sistema.agregarMiembro(nuevoMiembro);
            vista.mostrarMensajeExito("Miembro registrado exitosamente.");
            
        } catch (Exception e) {
            vista.mostrarMensajeError("Error al registrar el miembro.");
        }
    }
    
    public void procesarRegistroEntrenador() {
        try {
            String[] datos = vista.solicitarDatosEntrenador();
            int id = Integer.parseInt(datos[0]);
            
            if (sistema.buscarEntrenadorPorId(id) != null) {
                vista.mostrarMensajeError("Ya existe un entrenador con ese ID.");
                return;
            }
            
            Entrenador nuevoEntrenador = new Entrenador(id, datos[1], datos[2]);
            sistema.agregarEntrenador(nuevoEntrenador);
            vista.mostrarMensajeExito("Entrenador registrado exitosamente.");
            
        } catch (Exception e) {
            vista.mostrarMensajeError("Error al registrar el entrenador.");
        }
    }
    
    public void procesarRegistroRutina() {
        try {
            String[] datos = vista.solicitarDatosRutina();
            int id = Integer.parseInt(datos[0]);
            
            if (sistema.buscarRutinaPorId(id) != null) {
                vista.mostrarMensajeError("Ya existe una rutina con ese ID.");
                return;
            }
            
            Rutina nuevaRutina = new Rutina(id, datos[1], datos[2], datos[3]);
            sistema.agregarRutina(nuevaRutina);
            vista.mostrarMensajeExito("Rutina registrada exitosamente.");
            
        } catch (Exception e) {
            vista.mostrarMensajeError("Error al registrar la rutina.");
        }
    }
    
    public void procesarAsignacionEntrenador() {
        try {
            int idMiembro = vista.solicitarIdMiembro();
            int idEntrenador = vista.solicitarIdEntrenador();
            
            if (sistema.asignarEntrenadorAMiembro(idMiembro, idEntrenador)) {
                vista.mostrarMensajeExito("Entrenador asignado exitosamente al miembro.");
            } else {
                vista.mostrarMensajeError("No se pudo realizar la asignación. Verifique que el miembro y entrenador existan.");
            }
            
        } catch (Exception e) {
            vista.mostrarMensajeError("Error al asignar entrenador.");
        }
    }
    
    public void procesarAsignacionRutina() {
        try {
            int idMiembro = vista.solicitarIdMiembro();
            int idRutina = vista.solicitarIdRutina();
            
            if (sistema.asignarRutinaAMiembro(idMiembro, idRutina)) {
                vista.mostrarMensajeExito("Rutina asignada exitosamente al miembro.");
            } else {
                vista.mostrarMensajeError("No se pudo realizar la asignación. Verifique que el miembro y rutina existan.");
            }
            
        } catch (Exception e) {
            vista.mostrarMensajeError("Error al asignar rutina.");
        }
    }
    
    public void procesarGeneracionReportes() {
        int opcionReporte;
        
        do {
            opcionReporte = vista.mostrarMenuReportes();
            
            switch (opcionReporte) {
                case 1:
                    procesarReporteRutinaMasPopular();
                    break;
                case 2:
                    procesarReporteTotalRutinasActivas();
                    break;
                case 3:
                    procesarReporteEntrenadorConMasAlumnos();
                    break;
                case 4:
                    break;
            }
        } while (opcionReporte != 4);
    }
    
    public void procesarReporteRutinaMasPopular() {
        Rutina rutinaMasPopular = sistema.getRutinaMasPopular();
        vista.mostrarRutinaMasPopular(rutinaMasPopular);
    }
    
    public void procesarReporteTotalRutinasActivas() {
        int totalRutinasActivas = sistema.getTotalRutinasActivas();
        vista.mostrarTotalRutinasActivas(totalRutinasActivas);
    }
    
    public void procesarReporteEntrenadorConMasAlumnos() {
        Entrenador entrenadorConMasAlumnos = sistema.getEntrenadorConMasAlumnos();
        vista.mostrarEntrenadorConMasAlumnos(entrenadorConMasAlumnos);
    }
}