
void main() {

    ConexionBD bd; // variable del tipo de la interfaz

    System.out.println("=== Uso de MySQL ===");
    bd = new ConexionMySQL(3306);
    bd.conectar();
    System.out.println(bd.ejecutarConsulta("SELECT * FROM clientes"));
    bd.desconectar();

    System.out.println("\n=== Cambio a PostgreSQL ===");
    bd = new ConexionPostgreSQL("ventas");
    bd.conectar();
    bd.conectar(); // validación: ya conectada
    System.out.println(bd.ejecutarConsulta("SELECT * FROM pedidos"));
    bd.desconectar();

    System.out.println("\n=== Cambio a MongoDB ===");
    bd = new ConexionMongoDB("productos");
    System.out.println(bd.ejecutarConsulta("SELECT * FROM productos")); // validación: sin conexión
    bd.conectar();
    System.out.println(bd.ejecutarConsulta("SELECT * FROM productos"));
    bd.desconectar();
    bd.desconectar(); // validación: ya cerrada

}
