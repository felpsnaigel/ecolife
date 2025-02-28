import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
  private static final String URL = "jdbc:mysql://localhost:3306/ecolife";
  private static final String USUARIO = "seu_usuario";
  private static final String SENHA = "sua_senha";

  public static Connection conectar() {
    try {
      return DriverManager.getConnection(URL, USUARIO, SENHA);
    } catch (SQLException e) {
      System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
      return null;
    }
  }
}
