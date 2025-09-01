import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    
    public MenuHandler() {
        this.scanner = new Scanner(System.in);
    }
    
    public int leerEntero(String mensaje) {
        int numero = 0;
        boolean esValido = false;
        
        do {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                esValido = true;
            } catch (NumberFormatException e) {
                // Error handling removed to avoid console output
            }
        } while (!esValido);
        
        return numero;
    }
    
    public int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        int numero;
        do {
            numero = leerEntero(mensaje);
        } while (numero < minimo || numero > maximo);
        
        return numero;
    }
    
    public String leerTexto(String mensaje) {
        String texto;
        do {
            texto = scanner.nextLine().trim();
        } while (texto.isEmpty());
        
        return texto;
    }
    
    public String leerTextoOpcional(String mensaje) {
        return scanner.nextLine().trim();
    }
    
    public boolean confirmarAccion(String mensaje) {
        String respuesta;
        do {
            respuesta = scanner.nextLine().trim().toLowerCase();
        } while (!respuesta.equals("s") && !respuesta.equals("n"));
        
        return respuesta.equals("s");
    }
    
    public void limpiarBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}