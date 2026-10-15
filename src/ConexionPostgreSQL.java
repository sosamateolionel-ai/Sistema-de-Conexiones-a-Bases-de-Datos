public class ConexionPostgreSQL extends ConexionBase {

    private String esquema;

    public ConexionPostgreSQL(String esquema) {
        super("PostgreSQL");
        this.esquema = esquema;
    }

    @Override
    protected String detalleConexion() {
        return "esquema \"" + esquema + "\", motor relacional";
    }

    @Override
    protected String procesar(String consulta) {
        System.out.println("[PostgreSQL] Planificando y ejecutando SQL en esquema " + esquema + ": " + consulta);
        return "Resultado PostgreSQL: 5 filas";
    }
}