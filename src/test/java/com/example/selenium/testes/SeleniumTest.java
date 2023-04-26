package com.example.selenium.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.selenium.pages.TelaDeLogin;
import com.example.selenium.setup.InstanciarPagina;

public class SeleniumTest {

    /**
     * 2- Busca
     * 3- Busca Avançada
     */

    private InstanciarPagina pagina = new InstanciarPagina();
    private TelaDeLogin tela;

    @Test
    void testarLoginValido() {
        tela = new TelaDeLogin(pagina.gerarPagina("https://www.fastshop.com.br/web/checkout-v2/login"));

        tela.preencherCampoLogin("28759953080");
        tela.preencherCampoSenha("1234");
        tela.clicarNoBotao();
        tela.fecharJanela();
    }

    @Test
    void testarLoginInvalido() {
        tela = new TelaDeLogin(pagina.gerarPagina("https://www.fastshop.com.br/web/checkout-v2/login"));

        tela.preencherCampoLogin("12345678911");
        tela.preencherCampoSenha("1234");
        tela.clicarNoBotao();

        Assertions.assertEquals("Informe um CPF ou CNPJ válido", tela.obterCampoValidoDeLogin());
        tela.fecharJanela();
    }

    @Test
    void testarLoginZComDadosNaoCadastrados() {
        tela = new TelaDeLogin(pagina.gerarPagina("https://www.fastshop.com.br/web/checkout-v2/login"));

        tela.preencherCampoLogin("28759953080");
        tela.preencherCampoSenha("1234");
        tela.clicarNoBotao();

        tela.tempoDeEspera(60l);

        Assertions.assertEquals("Login ou senha inválido.", tela.obterCampoMenssagemAoEfetuarLoginInvalido());
        tela.fecharJanela();
    }

}
