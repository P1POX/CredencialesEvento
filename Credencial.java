public class Credencial implements Cloneable {
    private String nombre;
    private String rut;
    private String cargo;
    private String tipoCredencial;
    private String codigoIngreso;

    public Credencial(String nombre, String rut, String cargo, String tipoCredencial, String codigoIngreso) {
        this.nombre = nombre;
        this.rut = rut;
        this.cargo = cargo;
        this.tipoCredencial = tipoCredencial;
        this.codigoIngreso = codigoIngreso;
    }

    public Credencial clone() {
        try {
            return (Credencial) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void mostrar() {
        System.out.println("----------------------------------");
        System.out.println("Nombre:           " + nombre);
        System.out.println("RUT:              " + rut);
        System.out.println("Cargo:            " + cargo);
        System.out.println("Tipo Credencial:  " + tipoCredencial);
        System.out.println("Código Ingreso:   " + codigoIngreso);
        System.out.println("----------------------------------");
    }

    public void setDato(String clave, String valor) {
        switch (clave.toLowerCase()) {
            case "nombre": nombre = valor; break;
            case "rut": rut = valor; break;
            case "cargo": cargo = valor; break;
            case "tipocredencial": tipoCredencial = valor; break;
            case "codigoingreso": codigoIngreso = valor; break;
        }
    }
    
    public String getNombre() { return nombre; }
    public String getRut() { return rut; }
    public String getCargo() { return cargo; }
    public String getTipoCredencial() { return tipoCredencial; }
    public String getCodigoIngreso() { return codigoIngreso; }
}