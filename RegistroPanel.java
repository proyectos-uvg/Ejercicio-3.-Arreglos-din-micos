import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroPanel extends JPanel {
    private GimnasioController controller;
    
    private JTextField miembroIdField, miembroNombreField;
    private JComboBox<String> miembroMembresiaCombo;
    private JButton registrarMiembroBtn, limpiarMiembroBtn;
    
    private JTextField entrenadorIdField, entrenadorNombreField;
    private JComboBox<String> entrenadorEspecialidadCombo;
    private JButton registrarEntrenadorBtn, limpiarEntrenadorBtn;
    
    private JTextField rutinaIdField, rutinaNombreField, rutinaTipoField;
    private JTextArea rutinaDescripcionArea;
    private JButton registrarRutinaBtn, limpiarRutinaBtn;
    
    public RegistroPanel(GimnasioController controller) {
        this.controller = controller;
        initializeComponents();
        setupLayout();
        setupEventListeners();
    }
    
    private void initializeComponents() {
        setBackground(new Color(245, 245, 245));
        
        miembroIdField = new JTextField(15);
        miembroNombreField = new JTextField(15);
        miembroMembresiaCombo = new JComboBox<>(new String[]{"Básica", "Premium", "VIP"});
        registrarMiembroBtn = new JButton("Registrar Miembro");
        limpiarMiembroBtn = new JButton("Limpiar");
        
        entrenadorIdField = new JTextField(15);
        entrenadorNombreField = new JTextField(15);
        entrenadorEspecialidadCombo = new JComboBox<>(new String[]{"Fuerza", "Cardio", "Funcional", "Rehabilitación"});
        registrarEntrenadorBtn = new JButton("Registrar Entrenador");
        limpiarEntrenadorBtn = new JButton("Limpiar");
        
        rutinaIdField = new JTextField(15);
        rutinaNombreField = new JTextField(15);
        rutinaTipoField = new JTextField(15);
        rutinaDescripcionArea = new JTextArea(4, 15);
        rutinaDescripcionArea.setLineWrap(true);
        rutinaDescripcionArea.setWrapStyleWord(true);
        registrarRutinaBtn = new JButton("Registrar Rutina");
        limpiarRutinaBtn = new JButton("Limpiar");
        
        styleButtons();
    }
    
    private void styleButtons() {
        JButton[] primaryButtons = {registrarMiembroBtn, registrarEntrenadorBtn, registrarRutinaBtn};
        JButton[] secondaryButtons = {limpiarMiembroBtn, limpiarEntrenadorBtn, limpiarRutinaBtn};
        
        for (JButton btn : primaryButtons) {
            btn.setBackground(new Color(70, 130, 180));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 12));
        }
        
        for (JButton btn : secondaryButtons) {
            btn.setBackground(new Color(176, 196, 222));
            btn.setForeground(new Color(60, 60, 60));
            btn.setFocusPainted(false);
            btn.setFont(new Font("Arial", Font.PLAIN, 12));
        }
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));
        
        tabbedPane.addTab("Miembros", createMiembroPanel());
        tabbedPane.addTab("Entrenadores", createEntrenadorPanel());
        tabbedPane.addTab("Rutinas", createRutinaPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private JPanel createMiembroPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(new TitledBorder("Registro de Miembros"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(miembroIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(miembroNombreField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Tipo de Membresía:"), gbc);
        gbc.gridx = 1;
        panel.add(miembroMembresiaCombo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(registrarMiembroBtn);
        buttonPanel.add(limpiarMiembroBtn);
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createEntrenadorPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(new TitledBorder("Registro de Entrenadores"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(entrenadorIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(entrenadorNombreField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Especialidad:"), gbc);
        gbc.gridx = 1;
        panel.add(entrenadorEspecialidadCombo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(registrarEntrenadorBtn);
        buttonPanel.add(limpiarEntrenadorBtn);
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createRutinaPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(new TitledBorder("Registro de Rutinas"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(rutinaIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(rutinaNombreField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        panel.add(rutinaTipoField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        JScrollPane scrollPane = new JScrollPane(rutinaDescripcionArea);
        panel.add(scrollPane, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(registrarRutinaBtn);
        buttonPanel.add(limpiarRutinaBtn);
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private void setupEventListeners() {
        registrarMiembroBtn.addActionListener(e -> registrarMiembro());
        limpiarMiembroBtn.addActionListener(e -> limpiarFormularioMiembro());
        
        registrarEntrenadorBtn.addActionListener(e -> registrarEntrenador());
        limpiarEntrenadorBtn.addActionListener(e -> limpiarFormularioEntrenador());
        
        registrarRutinaBtn.addActionListener(e -> registrarRutina());
        limpiarRutinaBtn.addActionListener(e -> limpiarFormularioRutina());
    }
    
    private void registrarMiembro() {
        try {
            if (miembroIdField.getText().trim().isEmpty() || miembroNombreField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int id = Integer.parseInt(miembroIdField.getText().trim());
            String nombre = miembroNombreField.getText().trim();
            String membresia = (String) miembroMembresiaCombo.getSelectedItem();
            
            if (controller.getSistema().buscarMiembroPorId(id) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un miembro con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Miembro nuevoMiembro = new Miembro(id, nombre, membresia);
            controller.getSistema().agregarMiembro(nuevoMiembro);
            
            JOptionPane.showMessageDialog(this, "Miembro registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormularioMiembro();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registrarEntrenador() {
        try {
            if (entrenadorIdField.getText().trim().isEmpty() || entrenadorNombreField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int id = Integer.parseInt(entrenadorIdField.getText().trim());
            String nombre = entrenadorNombreField.getText().trim();
            String especialidad = (String) entrenadorEspecialidadCombo.getSelectedItem();
            
            if (controller.getSistema().buscarEntrenadorPorId(id) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un entrenador con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Entrenador nuevoEntrenador = new Entrenador(id, nombre, especialidad);
            controller.getSistema().agregarEntrenador(nuevoEntrenador);
            
            JOptionPane.showMessageDialog(this, "Entrenador registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormularioEntrenador();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registrarRutina() {
        try {
            if (rutinaIdField.getText().trim().isEmpty() || rutinaNombreField.getText().trim().isEmpty() || 
                rutinaTipoField.getText().trim().isEmpty() || rutinaDescripcionArea.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int id = Integer.parseInt(rutinaIdField.getText().trim());
            String nombre = rutinaNombreField.getText().trim();
            String tipo = rutinaTipoField.getText().trim();
            String descripcion = rutinaDescripcionArea.getText().trim();
            
            if (controller.getSistema().buscarRutinaPorId(id) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe una rutina con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Rutina nuevaRutina = new Rutina(id, nombre, descripcion, tipo);
            controller.getSistema().agregarRutina(nuevaRutina);
            
            JOptionPane.showMessageDialog(this, "Rutina registrada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormularioRutina();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiarFormularioMiembro() {
        miembroIdField.setText("");
        miembroNombreField.setText("");
        miembroMembresiaCombo.setSelectedIndex(0);
    }
    
    private void limpiarFormularioEntrenador() {
        entrenadorIdField.setText("");
        entrenadorNombreField.setText("");
        entrenadorEspecialidadCombo.setSelectedIndex(0);
    }
    
    private void limpiarFormularioRutina() {
        rutinaIdField.setText("");
        rutinaNombreField.setText("");
        rutinaTipoField.setText("");
        rutinaDescripcionArea.setText("");
    }
}