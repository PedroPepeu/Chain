function Footer(){
    return(<footer>
        <div class="container">
            <div class="links acw">
                <h3>Links Úteis</h3>
                <ul>
                    <li><a href="#inicio">Início</a></li>
                    <li><a href="#sobre">Sobre nós</a></li>
                </ul>
            </div>
            <div class="contato acw">
                <h3>Contato</h3>
                <p>R. do Príncipe, 526 - Boa Vista, Recife - PE - 50050-900</p>
                <p><strong>Email:</strong> <a
                        href="mailto:flavio.00000844530@unicap.br">flavio.00000844530@unicap.br</a></p>
                <p><strong>Telefone:</strong> (81) 91234-5678</p>
            </div>
            <div class="social acw">
                <h3>Siga-nos</h3>
                <ul>
                    <li><a href="#"><i class="fa-brands fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa-brands fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa-brands fa-instagram"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="legal acw">
            <p>&copy; {new Date().getFullYear()}. Todos os direitos reservados.</p>
            <a href="politicaDePrivacidade.html">Política de
                Privacidade</a> | <a href="termosDeserviço.html">Termos de Serviço</a>
        </div>
    </footer>);
}

export default Footer