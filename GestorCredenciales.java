import java.util.ArrayList;
import java.util.List;

public class GestorCredenciales {
    // Instancia única de la clase (Singleton)
    private static GestorCredenciales instancia;

    private List<Credencial> credenciales;

    private GestorCredenciales() {
        credenciales = new ArrayList<>();
    }

    public static GestorCredenciales getInstancia() {
        if (instancia == null) {
            instancia = new GestorCredenciales();
        }
        return instancia;
    }

    public void agregarCredencial(Credencial credencial) {
        credenciales.add(credencial);
    }

    public void listarCredenciales() {
        for (Credencial credencial : credenciales) {
            credencial.mostrar();
        }
    }

    public List<Credencial> getCredenciales() {
        return credenciales;
    }
}