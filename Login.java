import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
  public static boolean logarUsuario(String email, String senha) {
    Connection conexao = ConexaoBD.conectar();
    if (conexao != null) {
      try {
        PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND senha = ?");
        pstmt.setString(1, email);
        pstmt.setString(2, senha);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
          System.out.println("Usuário logado com sucesso!");
          return true;
        } else {
          System.out.println("E-mail ou senha incorretos!");
          return false;
        }
      } catch (SQLException e) {
        System.out.println("Erro ao logar usuário: " + e.getMessage());
        return false;
      } finally {
        try {
          conexao.close();
        } catch (SQLException e) {
          System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
      }
    }
    return false;
  }
}
