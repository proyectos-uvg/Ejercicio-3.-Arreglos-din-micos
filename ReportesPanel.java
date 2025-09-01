import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportesPanel extends JPanel {
    private GimnasioController controller;
    
    private JButton rutinaMasPopularBtn, totalRutinasActivasBtn, entrenadorConMasAlumnosBtn;
    private JButton limpiarReporteBtn;
    private JTextArea reporteArea;
    private JScrollPane scrollPane;
    
    public ReportesPanel(GimnasioController controller) {
        this.controller = controller;
        initializeComponents();
        setupLayout();
        setupEventListeners();
    }
    
    private void initializeComponents() {
        setBackground(new Color(245, 245, 245));
        
        rutinaMasPopularBtn = new JButton("Rutina Más Popular");
        totalRutinasActivasBtn = new JButton("Total Rutinas Activas");
        entrenadorConMasAlumnosBtn = new JButton("Entrenador con Más Alumnos");
        limpiarReporteBtn = new JButton("Limpiar Reporte");
        
        reporteArea = new JTextArea(15, 50);
        reporteArea.setEditable(false);
        reporteArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        reporteArea.setBackground(new Color(248, 248, 255));
        reporteArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        scrollPane = new JScrollPane(reporteArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        styleButtons();
    }
    
    private void styleButtons() {
        rutinaMasPopularBtn.setBackground(new Color(138, 43, 226));
        rutinaMasPopularBtn.setForeground(Color.WHITE);
        rutinaMasPopularBtn.setFocusPainted(false);
        rutinaMasPopularBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        totalRutinasActivasBtn.setBackground(new Color(220, 20, 60));
        totalRutinasActivasBtn.setForeground(Color.WHITE);
        totalRutinasActivasBtn.setFocusPainted(false);
        totalRutinasActivasBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        entrenadorConMasAlumnosBtn.setBackground(new Color(255, 140, 0));
        entrenadorConMasAlumnosBtn.setForeground(Color.WHITE);
        entrenadorConMasAlumnosBtn.setFocusPainted(false);
        entrenadorConMasAlumnosBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        limpiarReporteBtn.setBackground(new Color(105, 105, 105));
        limpiarReporteBtn.setForeground(Color.WHITE);
        limpiarReporteBtn.setFocusPainted(false);
        limpiarReporteBtn.setFont(new Font("Arial", Font.PLAIN, 12));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 245, 245));
        
        JLabel titleLabel = new JLabel("Reportes del Gimnasio", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        topPanel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0;
        buttonPanel.add(rutinaMasPopularBtn, gbc);
        
        gbc.gridx = 1;
        buttonPanel.add(totalRutinasActivasBtn, gbc);
        
        gbc.gridx = 2;
        buttonPanel.add(entrenadorConMasAlumnosBtn, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        buttonPanel.add(limpiarReporteBtn, gbc);
        
        topPanel.add(buttonPanel, BorderLayout.CENTER);
        
        JPanel reportePanel = new JPanel(new BorderLayout());
        reportePanel.setBorder(new TitledBorder("Resultado del Reporte"));
        reportePanel.setBackground(new Color(245, 245, 245));
        reportePanel.add(scrollPane, BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.NORTH);
        add(reportePanel, BorderLayout.CENTER);
        
        mostrarInstrucciones();
    }
    
    private void setupEventListeners() {
        rutinaMasPopularBtn.addActionListener(e -> generarReporteRutinaMasPopular());
        totalRutinasActivasBtn.addActionListener(e -> generarReporteTotalRutinasActivas());
        entrenadorConMasAlumnosBtn.addActionListener(e -> generarReporteEntrenadorConMasAlumnos());
        limpiarReporteBtn.addActionListener(e -> limpiarReporte());
    }
    
    private void mostrarInstrucciones() {
        StringBuilder sb = new StringBuilder();
        sb.append("====================================================\n");
        sb.append("           SISTEMA DE REPORTES DEL GIMNASIO\n");
        sb.append("====================================================\n\n");
        sb.append("Instrucciones:\n");
        sb.append("• Haga clic en cualquiera de los botones de reporte\n");
        sb.append("• Los resultados se mostrarán en esta área\n");
        sb.append("• Use 'Limpiar Reporte' para borrar el contenido\n\n");
        sb.append("Reportes disponibles:\n");
        sb.append("1. Rutina Más Popular - Muestra la rutina con más practicantes\n");
        sb.append("2. Total Rutinas Activas - Cuenta rutinas con al menos 1 practicante\n");
        sb.append("3. Entrenador con Más Alumnos - Muestra el entrenador más solicitado\n\n");
        sb.append("====================================================\n");
        
        reporteArea.setText(sb.toString());
    }
    
    private void generarReporteRutinaMasPopular() {
        Rutina rutinaMasPopular = controller.getSistema().getRutinaMasPopular();
        
        StringBuilder sb = new StringBuilder();
        sb.append("====================================================\n");
        sb.append("              RUTINA MÁS POPULAR\n");
        sb.append("====================================================\n\n");
        
        if (rutinaMasPopular != null) {
            sb.append("✓ RUTINA ENCONTRADA:\n\n");
            sb.append("ID: ").append(rutinaMasPopular.getId()).append("\n");
            sb.append("Nombre: ").append(rutinaMasPopular.getNombre()).append("\n");
            sb.append("Tipo: ").append(rutinaMasPopular.getTipo()).append("\n");
            sb.append("Descripción: ").append(rutinaMasPopular.getDescripcion()).append("\n");
            sb.append("Cantidad de Practicantes: ").append(rutinaMasPopular.getCantidadPracticantes()).append("\n\n");
            
            if (rutinaMasPopular.getCantidadPracticantes() == 0) {
                sb.append("⚠️  NOTA: Esta rutina no tiene practicantes asignados aún.\n");
            } else if (rutinaMasPopular.getCantidadPracticantes() == 1) {
                sb.append("📊 Esta rutina tiene 1 practicante.\n");
            } else {
                sb.append("📊 Esta rutina tiene ").append(rutinaMasPopular.getCantidadPracticantes()).append(" practicantes.\n");
            }
        } else {
            sb.append("❌ NO HAY RUTINAS REGISTRADAS\n\n");
            sb.append("Para generar este reporte:\n");
            sb.append("1. Registre al menos una rutina\n");
            sb.append("2. Asigne la rutina a uno o más miembros\n");
        }
        
        sb.append("\n====================================================\n");
        reporteArea.setText(sb.toString());
        reporteArea.setCaretPosition(0);
    }
    
    private void generarReporteTotalRutinasActivas() {
        int totalRutinasActivas = controller.getSistema().getTotalRutinasActivas();
        int totalRutinas = controller.getSistema().getRutinas().size();
        
        StringBuilder sb = new StringBuilder();
        sb.append("====================================================\n");
        sb.append("            TOTAL DE RUTINAS ACTIVAS\n");
        sb.append("====================================================\n\n");
        
        sb.append("📊 ESTADÍSTICAS:\n\n");
        sb.append("Total de rutinas registradas: ").append(totalRutinas).append("\n");
        sb.append("Rutinas activas (con practicantes): ").append(totalRutinasActivas).append("\n");
        sb.append("Rutinas inactivas (sin practicantes): ").append(totalRutinas - totalRutinasActivas).append("\n\n");
        
        if (totalRutinasActivas == 0) {
            sb.append("❌ NO HAY RUTINAS ACTIVAS\n\n");
            sb.append("Una rutina se considera activa cuando tiene al menos\n");
            sb.append("un miembro asignado a ella.\n\n");
            sb.append("Para activar rutinas:\n");
            sb.append("1. Vaya a la sección 'Asignaciones'\n");
            sb.append("2. Asigne rutinas a los miembros registrados\n");
        } else {
            double porcentajeActivas = totalRutinas > 0 ? (totalRutinasActivas * 100.0 / totalRutinas) : 0;
            sb.append("✓ RUTINAS ACTIVAS ENCONTRADAS\n\n");
            sb.append("Porcentaje de rutinas activas: ").append(String.format("%.1f%%", porcentajeActivas)).append("\n\n");
            
            if (porcentajeActivas >= 75) {
                sb.append("🏆 ¡Excelente! La mayoría de las rutinas están siendo utilizadas.\n");
            } else if (porcentajeActivas >= 50) {
                sb.append("👍 Buen nivel de utilización de rutinas.\n");
            } else {
                sb.append("💡 Considere promover más las rutinas disponibles.\n");
            }
        }
        
        sb.append("\n====================================================\n");
        reporteArea.setText(sb.toString());
        reporteArea.setCaretPosition(0);
    }
    
    private void generarReporteEntrenadorConMasAlumnos() {
        Entrenador entrenadorConMasAlumnos = controller.getSistema().getEntrenadorConMasAlumnos();
        
        StringBuilder sb = new StringBuilder();
        sb.append("====================================================\n");
        sb.append("           ENTRENADOR CON MÁS ALUMNOS\n");
        sb.append("====================================================\n\n");
        
        if (entrenadorConMasAlumnos != null) {
            sb.append("✓ ENTRENADOR ENCONTRADO:\n\n");
            sb.append("ID: ").append(entrenadorConMasAlumnos.getId()).append("\n");
            sb.append("Nombre: ").append(entrenadorConMasAlumnos.getNombre()).append("\n");
            sb.append("Especialidad: ").append(entrenadorConMasAlumnos.getEspecialidad()).append("\n");
            sb.append("Cantidad de Alumnos: ").append(entrenadorConMasAlumnos.getCantidadMiembros()).append("\n\n");
            
            if (entrenadorConMasAlumnos.getCantidadMiembros() == 0) {
                sb.append("⚠️  NOTA: Este entrenador no tiene alumnos asignados aún.\n");
            } else if (entrenadorConMasAlumnos.getCantidadMiembros() == 1) {
                sb.append("📊 Este entrenador tiene 1 alumno asignado.\n");
            } else {
                sb.append("📊 Este entrenador tiene ").append(entrenadorConMasAlumnos.getCantidadMiembros()).append(" alumnos asignados.\n");
            }
            
            sb.append("\nLISTA DE ALUMNOS:\n");
            if (entrenadorConMasAlumnos.getMiembrosAsignados().isEmpty()) {
                sb.append("- Sin alumnos asignados\n");
            } else {
                for (Miembro miembro : entrenadorConMasAlumnos.getMiembrosAsignados()) {
                    sb.append("- ").append(miembro.getNombre()).append(" (ID: ").append(miembro.getId()).append(", Membresía: ").append(miembro.getTipoMembresia()).append(")\n");
                }
            }
        } else {
            sb.append("❌ NO HAY ENTRENADORES REGISTRADOS\n\n");
            sb.append("Para generar este reporte:\n");
            sb.append("1. Registre al menos un entrenador\n");
            sb.append("2. Asigne miembros a los entrenadores\n");
        }
        
        sb.append("\n====================================================\n");
        reporteArea.setText(sb.toString());
        reporteArea.setCaretPosition(0);
    }
    
    private void limpiarReporte() {
        mostrarInstrucciones();
    }
}