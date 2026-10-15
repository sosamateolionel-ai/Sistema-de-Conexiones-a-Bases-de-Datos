public abstract class ConexionBase implements ConexionBD {

    protected String motor;
    protected boolean conectado;

    public ConexionBase(String motor) {
        this.motor = motor;
        this.conectado = false;
    }

    @Override
    public boolean conectar() {

        if (conectado) {
            System.out.println("[" + motor + "] Ya existe una conexión activa.");
            return false;
        }

        conectado = true;
        System.out.println("[" + motor + "] Conexión establecida (" + detalleConexion() + ").");
        return true;
    }

    @Override
    public String ejecutarConsulta(String sql) {

        if (!conectado) {
            System.out.println("[" + motor + "] Error: no hay conexión activa, la consulta no se ejecutó.");
            return null;
        }

        if (sql == null || sql.trim().isEmpty()) {
            System.out.println("[" + motor + "] Error: consulta vacía.");
            return null;
        }

        return procesar(sql);
    }

    @Override
    public void desconectar() {

        if (!conectado) {
            System.out.println("[" + motor + "] No hay conexión que cerrar.");
            return;
        }

        conectado = false;
        System.out.println("[" + motor + "] Conexión cerrada.");
    }

    // Cada motor define lo suyo
    protected abstract String detalleConexion();

    protected abstract String procesar(String consulta);
}