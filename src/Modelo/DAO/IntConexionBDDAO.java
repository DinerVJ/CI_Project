package Modelo.DAO;

public interface IntConexionBDDAO {
    // MySQL
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/ci_project";
    String user = "root";
    String password = "";
    // SQL Server
//    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    String user = "dvjsqlserver";
//    String password = "root";
//    String database = "ci_project";
//    String ip = "localhost";
//    String port = "1433";
//    String url = "jdbc:sqlserver://localhost:" + port + ";" + "databaseName="+ database;
}
