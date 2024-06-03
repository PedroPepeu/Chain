document.addEventListener("DOMContentLoaded", function() {
    function exibirNotificacao(mensagem) {
        Toastify({
            text: mensagem,
            duration: 4000
        }).showToast();
    }

    document.getElementById("loginConteudo").addEventListener("submit", function(event) {
        event.preventDefault();
        var loginValido = true; // Altere para false se o login for inválido
        var senhaValida = true; // Altere para false se a senha for inválida
        
        if (loginValido && senhaValida) {
            exibirNotificacao("Login efetuado com sucesso");
            exibirNotificacao("pepeu ajusta banco para verificar se senha e login são validos"); 
            setTimeout(window.location.href = "profile", 1000);
        // Simula a verificação do banco de dados    
        } else {
            if (!loginValido) {
                exibirNotificacao("Login inválido");
            } else {
                exibirNotificacao("Senha inválida");
            }
        }
    });

    document.getElementById("RecuperarConta").addEventListener("click", function(event) {
        event.preventDefault();
        exibirNotificacao("redirecionando para area de recuperar conta");
        setTimeout(function() {
            window.location.href = "404";
        }, 1000);
    });

    document.getElementById("cadastrarConta").addEventListener("click", function(event) {
        event.preventDefault();
        exibirNotificacao("redirecionando para tela de cadastro");
        setTimeout(function() {
            window.location.href = "cadastro";
        }, 1000);
    });
});
