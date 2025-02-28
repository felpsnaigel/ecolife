import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro {
  public static void cadastrarUsuario(Usuario usuario) {
    Connection conexao = ConexaoBD.conectar();
    if (conexao != null) {
      try {
        PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)");
        pstmt.setString(1, usuario.getNome());
        pstmt.setString(2, usuario.getEmail());
        pstmt.setString(3, usuario.getSenha());
        pstmt.executeUpdate();
        System.out.println("Usuário cadastrado com sucesso!");
      } catch (SQLException e) {
        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
      } finally {
        try {
          conexao.close();
        } catch (SQLException e) {
          System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
      }
    }
  }
}
