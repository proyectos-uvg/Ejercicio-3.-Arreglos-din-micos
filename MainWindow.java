import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private GimnasioController controller;
    private GimnasioViewGUI viewGUI;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    public MainWindow() {
        controller = new GimnasioController();
        viewGUI = new GimnasioViewGUI(controller);
        controller.setViewGUI(viewGUI);
        
        initializeComponents();
        setupLayout();
        setupMenus();
    }
    
    private void initializeComponents() {
        setTitle("Sistema de Gestión de Gimnasio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        JPanel welcomePanel = createWelcomePanel();
        mainPanel.add(welcomePanel, "WELCOME");
        mainPanel.add(viewGUI.getRegistroPanel(), "REGISTRO");
        mainPanel.add(viewGUI.getAsignacionPanel(), "ASIGNACION");
        mainPanel.add(viewGUI.getReportesPanel(), "REPORTES");
        
        cardLayout.show(mainPanel, "WELCOME");
    }
    
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));
        
        JLabel titleLabel = new JLabel("Sistema de Gestión de Gimnasio", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 30, 0));
        
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        String[] features = {
            "✓ Gestión completa de miembros",
            "✓ Administración de entrenadores",
            "✓ Creación y asignación de rutinas",
            "✓ Reportes detallados del gimnasio",
            "✓ Interfaz gráfica intuitiva"
        };
        
        gbc.anchor = GridBagConstraints.WEST;
        for (int i = 0; i < features.length; i++) {
            JLabel featureLabel = new JLabel(features[i]);
            featureLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            featureLabel.setForeground(new Color(60, 60, 60));
            gbc.gridy = i;
            contentPanel.add(featureLabel, gbc);
        }
        
        JLabel instructionLabel = new JLabel("Utilice el menú superior para navegar por las diferentes secciones", SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        instructionLabel.setForeground(new Color(100, 100, 100));
        instructionLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));
        
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(instructionLabel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private void setupMenus() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(230, 230, 250));
        
        JMenu registroMenu = new JMenu("Registro");
        registroMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem registroItem = new JMenuItem("Gestionar Registros");
        registroItem.addActionListener(e -> showPanel("REGISTRO"));
        registroMenu.add(registroItem);
        
        JMenu asignacionMenu = new JMenu("Asignaciones");
        asignacionMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem asignacionItem = new JMenuItem("Gestionar Asignaciones");
        asignacionItem.addActionListener(e -> showPanel("ASIGNACION"));
        asignacionMenu.add(asignacionItem);
        
        JMenu reportesMenu = new JMenu("Reportes");
        reportesMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem reportesItem = new JMenuItem("Ver Reportes");
        reportesItem.addActionListener(e -> showPanel("REPORTES"));
        reportesMenu.add(reportesItem);
        
        JMenu inicioMenu = new JMenu("Inicio");
        inicioMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem inicioItem = new JMenuItem("Pantalla Principal");
        inicioItem.addActionListener(e -> showPanel("WELCOME"));
        inicioMenu.add(inicioItem);
        
        JMenu salirMenu = new JMenu("Salir");
        salirMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem salirItem = new JMenuItem("Cerrar Aplicación");
        salirItem.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea cerrar la aplicación?",
                "Confirmar Salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        salirMenu.add(salirItem);
        
        menuBar.add(inicioMenu);
        menuBar.add(registroMenu);
        menuBar.add(asignacionMenu);
        menuBar.add(reportesMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(salirMenu);
        
        setJMenuBar(menuBar);
    }
    
    private void showPanel(String panelName) {
        if ("ASIGNACION".equals(panelName)) {
            viewGUI.actualizarComboBoxes();
        }
        cardLayout.show(mainPanel, panelName);
    }
}