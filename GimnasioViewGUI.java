public class GimnasioViewGUI {
    private GimnasioController controller;
    private RegistroPanel registroPanel;
    private AsignacionPanel asignacionPanel;
    private ReportesPanel reportesPanel;
    
    public GimnasioViewGUI(GimnasioController controller) {
        this.controller = controller;
        initializePanels();
    }
    
    private void initializePanels() {
        registroPanel = new RegistroPanel(controller);
        asignacionPanel = new AsignacionPanel(controller);
        reportesPanel = new ReportesPanel(controller);
    }
    
    public RegistroPanel getRegistroPanel() {
        return registroPanel;
    }
    
    public AsignacionPanel getAsignacionPanel() {
        return asignacionPanel;
    }
    
    public ReportesPanel getReportesPanel() {
        return reportesPanel;
    }
    
    public void actualizarComboBoxes() {
        asignacionPanel.actualizarComboBoxes();
    }
}