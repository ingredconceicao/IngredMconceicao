let login = []
function entrar(){
    // usuario
    let user = document.getElementById('user').value

    // senha
    let senha = document.getElementById('senha').value

    let logar = {
        user: user,
        senha: senha
    }
}
console.log(login)


// nome
let nome = document.getElementById('nome')

// usuario
let usuario = document.getElementById('user')

// email
let email = document.getElementById('email')

// senha
let senha = document.getElementById('senha')

// confirme a senha
let confirmSenha = document.getElementById('confirmSenha')


function cadastrar(){
    // metodo que vai enviar os dados e acessar nossa api
    fetch("http://localhost:8098/cadastrar", //enpoint de acesso 
    {       // cabeçalho dizendo que vou enviar o tipo json
        method:'POST',
        headers:{
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },

        body: JSON.stringify({
            nome : nome.value,
            usuario : usuario.value,
            email : email.value,
            senha : senha.value
        }) //conversor para json
    })
    .then(function(res) {console.log(res)})
    .catch(function(res) {console.log(res)})

}