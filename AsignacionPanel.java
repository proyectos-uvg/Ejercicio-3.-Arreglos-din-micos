import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsignacionPanel extends JPanel {
    private GimnasioController controller;
    
    private JComboBox<String> miembrosComboEntrenador, entrenadoresCombo;
    private JComboBox<String> miembrosComboRutina, rutinasCombo;
    private JButton asignarEntrenadorBtn, asignarRutinaBtn;
    private JButton actualizarBtn;
    
    public AsignacionPanel(GimnasioController controller) {
        this.controller = controller;
        initializeComponents();
        setupLayout();
        setupEventListeners();
    }
    
    private void initializeComponents() {
        setBackground(new Color(245, 245, 245));
        
        miembrosComboEntrenador = new JComboBox<>();
        entrenadoresCombo = new JComboBox<>();
        miembrosComboRutina = new JComboBox<>();
        rutinasCombo = new JComboBox<>();
        
        asignarEntrenadorBtn = new JButton("Asignar Entrenador");
        asignarRutinaBtn = new JButton("Asignar Rutina");
        actualizarBtn = new JButton("Actualizar Listas");
        
        styleButtons();
        
        miembrosComboEntrenador.setPreferredSize(new Dimension(250, 25));
        entrenadoresCombo.setPreferredSize(new Dimension(250, 25));
        miembrosComboRutina.setPreferredSize(new Dimension(250, 25));
        rutinasCombo.setPreferredSize(new Dimension(250, 25));
    }
    
    private void styleButtons() {
        asignarEntrenadorBtn.setBackground(new Color(34, 139, 34));
        asignarEntrenadorBtn.setForeground(Color.WHITE);
        asignarEntrenadorBtn.setFocusPainted(false);
        asignarEntrenadorBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        asignarRutinaBtn.setBackground(new Color(30, 144, 255));
        asignarRutinaBtn.setForeground(Color.WHITE);
        asignarRutinaBtn.setFocusPainted(false);
        asignarRutinaBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        actualizarBtn.setBackground(new Color(255, 165, 0));
        actualizarBtn.setForeground(Color.WHITE);
        actualizarBtn.setFocusPainted(false);
        actualizarBtn.setFont(new Font("Arial", Font.BOLD, 12));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel titleLabel = new JLabel("Gestión de Asignaciones", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(25, 25, 112));
        mainPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        mainPanel.add(createEntrenadorPanel(), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(createRutinaPanel(), gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(actualizarBtn);
        mainPanel.add(buttonPanel, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private JPanel createEntrenadorPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(new TitledBorder("Asignar Entrenador a Miembro"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Seleccionar Miembro:"), gbc);
        gbc.gridy = 1;
        panel.add(miembrosComboEntrenador, gbc);
        
        gbc.gridy = 2;
        panel.add(new JLabel("Seleccionar Entrenador:"), gbc);
        gbc.gridy = 3;
        panel.add(entrenadoresCombo, gbc);
        
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(asignarEntrenadorBtn, gbc);
        
        return panel;
    }
    
    private JPanel createRutinaPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(new TitledBorder("Asignar Rutina a Miembro"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Seleccionar Miembro:"), gbc);
        gbc.gridy = 1;
        panel.add(miembrosComboRutina, gbc);
        
        gbc.gridy = 2;
        panel.add(new JLabel("Seleccionar Rutina:"), gbc);
        gbc.gridy = 3;
        panel.add(rutinasCombo, gbc);
        
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(asignarRutinaBtn, gbc);
        
        return panel;
    }
    
    private void setupEventListeners() {
        asignarEntrenadorBtn.addActionListener(e -> asignarEntrenador());
        asignarRutinaBtn.addActionListener(e -> asignarRutina());
        actualizarBtn.addActionListener(e -> actualizarComboBoxes());
    }
    
    public void actualizarComboBoxes() {
        actualizarComboMiembros();
        actualizarComboEntrenadores();
        actualizarComboRutinas();
    }
    
    private void actualizarComboMiembros() {
        miembrosComboEntrenador.removeAllItems();
        miembrosComboRutina.removeAllItems();
        
        for (Miembro miembro : controller.getSistema().getMiembros()) {
            String item = miembro.getId() + " - " + miembro.getNombre();
            miembrosComboEntrenador.addItem(item);
            miembrosComboRutina.addItem(item);
        }
        
        if (miembrosComboEntrenador.getItemCount() == 0) {
            miembrosComboEntrenador.addItem("No hay miembros registrados");
            miembrosComboRutina.addItem("No hay miembros registrados");
        }
    }
    
    private void actualizarComboEntrenadores() {
        entrenadoresCombo.removeAllItems();
        
        for (Entrenador entrenador : controller.getSistema().getEntrenadores()) {
            String item = entrenador.getId() + " - " + entrenador.getNombre() + " (" + entrenador.getEspecialidad() + ")";
            entrenadoresCombo.addItem(item);
        }
        
        if (entrenadoresCombo.getItemCount() == 0) {
            entrenadoresCombo.addItem("No hay entrenadores registrados");
        }
    }
    
    private void actualizarComboRutinas() {
        rutinasCombo.removeAllItems();
        
        for (Rutina rutina : controller.getSistema().getRutinas()) {
            String item = rutina.getId() + " - " + rutina.getNombre() + " (" + rutina.getTipo() + ")";
            rutinasCombo.addItem(item);
        }
        
        if (rutinasCombo.getItemCount() == 0) {
            rutinasCombo.addItem("No hay rutinas registradas");
        }
    }
    
    private void asignarEntrenador() {
        try {
            String miembroSeleccionado = (String) miembrosComboEntrenador.getSelectedItem();
            String entrenadorSeleccionado = (String) entrenadoresCombo.getSelectedItem();
            
            if (miembroSeleccionado == null || entrenadorSeleccionado == null ||
                miembroSeleccionado.contains("No hay") || entrenadorSeleccionado.contains("No hay")) {
                JOptionPane.showMessageDialog(this, "Debe haber miembros y entrenadores registrados para realizar asignaciones", 
                                            "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int idMiembro = Integer.parseInt(miembroSeleccionado.split(" - ")[0]);
            int idEntrenador = Integer.parseInt(entrenadorSeleccionado.split(" - ")[0]);
            
            if (controller.getSistema().asignarEntrenadorAMiembro(idMiembro, idEntrenador)) {
                JOptionPane.showMessageDialog(this, "Entrenador asignado exitosamente al miembro", 
                                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo realizar la asignación", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar la asignación: " + ex.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void asignarRutina() {
        try {
            String miembroSeleccionado = (String) miembrosComboRutina.getSelectedItem();
            String rutinaSeleccionada = (String) rutinasCombo.getSelectedItem();
            
            if (miembroSeleccionado == null || rutinaSeleccionada == null ||
                miembroSeleccionado.contains("No hay") || rutinaSeleccionada.contains("No hay")) {
                JOptionPane.showMessageDialog(this, "Debe haber miembros y rutinas registrados para realizar asignaciones", 
                                            "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int idMiembro = Integer.parseInt(miembroSeleccionado.split(" - ")[0]);
            int idRutina = Integer.parseInt(rutinaSeleccionada.split(" - ")[0]);
            
            if (controller.getSistema().asignarRutinaAMiembro(idMiembro, idRutina)) {
                JOptionPane.showMessageDialog(this, "Rutina asignada exitosamente al miembro", 
                                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo realizar la asignación", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar la asignación: " + ex.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}