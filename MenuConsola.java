import java.util.Scanner;

public class MenuConsola {

    private static final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("-------- Generador de Credenciales de Evento --------");
        System.out.println("1. Crear nueva credencial");
        System.out.println("2. Clonar credencial");
        System.out.println("3. Listar credenciales");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
    }

    public void ejecutar() {
        GestorCredenciales gestor = GestorCredenciales.getInstancia();

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearCredencial(gestor);
                    break;
                case 2:
                    clonarCredencial(gestor);
                    break;
                case 3:
                    listarCredenciales(gestor);
                    break;
                case 4:
                    System.out.println("¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void crearCredencial(GestorCredenciales gestor) {
        System.out.println("Ingrese los datos de la credencial:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("RUT: ");
        String rut = scanner.nextLine();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Tipo de credencial (Ej: VIP, Staff): ");
        String tipoCredencial = scanner.nextLine();

        System.out.print("Código de ingreso: ");
        String codigoIngreso = scanner.nextLine();

        Credencial nuevaCredencial = new Credencial(nombre, rut, cargo, tipoCredencial, codigoIngreso);
        gestor.agregarCredencial(nuevaCredencial);

        System.out.println("¡Credencial creada exitosamente!");
    }

    private void clonarCredencial(GestorCredenciales gestor) {
        System.out.print("Ingrese el índice de la credencial a clonar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice >= 0 && indice < gestor.getCredenciales().size()) {
            Credencial original = gestor.getCredenciales().get(indice);
            Credencial clon = original.clone();

            System.out.print("Ingrese nombre del asistente: ");
            clon.setDato("nombre", scanner.nextLine());

            System.out.print("Ingrese RUT del asistente: ");
            clon.setDato("rut", scanner.nextLine());

            gestor.agregarCredencial(clon);

            System.out.println("¡Credencial clonada exitosamente!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void listarCredenciales(GestorCredenciales gestor) {
        if (gestor.getCredenciales().isEmpty()) {
            System.out.println("No hay credenciales registradas.");
        } else {
            System.out.println("-------- Lista de Credenciales --------");
            gestor.listarCredenciales();
        }
    }
}