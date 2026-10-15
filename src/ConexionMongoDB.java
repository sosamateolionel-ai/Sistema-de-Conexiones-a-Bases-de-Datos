public class ConexionMongoDB extends ConexionBase {

    private String coleccion;

    public ConexionMongoDB(String coleccion) {
        super("MongoDB");
        this.coleccion = coleccion;
    }

    @Override
    protected String detalleConexion() {
        return "colección \"" + coleccion + "\", NoSQL orientado a documentos";
    }

    @Override
    protected String procesar(String consulta) {
        System.out.println("[MongoDB] Traduciendo la consulta a find() sobre " + coleccion + ": " + consulta);
        return "Resultado MongoDB: 2 documentos";
    }
}