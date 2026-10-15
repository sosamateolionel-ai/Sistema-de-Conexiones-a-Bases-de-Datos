public class ConexionMySQL extends ConexionBase {

    private int puerto;

    public ConexionMySQL(int puerto) {
        super("MySQL");
        this.puerto = puerto;
    }

    @Override
    protected String detalleConexion() {
        return "puerto " + puerto + ", motor relacional";
    }

    @Override
    protected String procesar(String consulta) {
        System.out.println("[MySQL] Ejecutando SQL: " + consulta);
        return "Resultado MySQL: 3 filas";
    }
}