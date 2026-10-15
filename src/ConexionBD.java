public interface ConexionBD {

    boolean conectar();

    String ejecutarConsulta(String sql);

    void desconectar();
}