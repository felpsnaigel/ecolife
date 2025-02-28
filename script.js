document.querySelector('.logo-link').addEventListener('click', function() {
    window.location.replace('index.html');
  });
  // Variáveis para armazenar os dados dos usuários
let usuarios = [];

// Função para cadastrar um novo usuário
function cadastrarUsuario(nome, email, senha) {
  // Verificar se o usuário já existe
  if (usuarios.find(usuario => usuario.email === email)) {
    alert("Usuário já existe!");
    return;
  }

  // Criar um novo usuário
  const usuario = {
    nome,
    email,
    senha
  };

  // Adicionar o usuário à lista de usuários
  usuarios.push(usuario);

  // Salvar os dados dos usuários no localStorage
  localStorage.setItem("usuarios", JSON.stringify(usuarios));

  // Redirecionar para a página de login
  window.location.href = "login.html";
}

// Função para logar um usuário
function logarUsuario(email, senha) {
  // Buscar o usuário na lista de usuários
  const usuario = usuarios.find(usuario => usuario.email === email && usuario.senha === senha);

  // Verificar se o usuário existe e a senha está correta
  if (!usuario) {
    alert("Usuário ou senha incorretos!");
    return;
  }

  // Salvar o usuário logado no localStorage
  localStorage.setItem("usuarioLogado", JSON.stringify(usuario));

  // Redirecionar para a página principal
  window.location.href = "index.html";
}

// Event listener para o botão de cadastro
document.getElementById("cadastro-form").addEventListener("submit", (e) => {
  e.preventDefault();

  const nome = document.getElementById("nome").value;
  const email = document.getElementById("E-mail").value;
  const senha = document.getElementById("senha").value;
  const confirmarSenha = document.getElementById("confirmar-senha").value;

  // Verificar se a senha e a confirmação da senha estão corretas
  if (senha !== confirmarSenha) {
    alert("Senhas não conferem!");
    return;
  }

  // Chamar a função de cadastro
  cadastrarUsuario(nome, email, senha);
});
// Event listener para o botão de login
document.getElementById("login-form").addEventListener("submit", (e) => {
  e.preventDefault();

  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;

  // Chamar a função de login
  logarUsuario(email, senha);
});

