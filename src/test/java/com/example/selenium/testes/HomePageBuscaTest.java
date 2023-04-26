package com.example.selenium.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.selenium.pages.Busca;
import com.example.selenium.setup.InstanciarPagina;

import java.util.List;

public class HomePageBuscaTest {

    InstanciarPagina pagina = new InstanciarPagina();
    private Busca tela;

    @Test
    void preencherCampoBuscaAndPesquisar() {
        tela = new Busca(pagina.gerarPagina("https://www.fastshop.com.br/web/"));

        tela.preencherCampoBuscaAndPesquisar("lenovo");
    }

    @Test
    void validarSeBuscaRealizadaTrasProdutosSolicitados() {
        tela = new Busca(pagina.gerarPagina("https://www.fastshop.com.br/web/"));

        String pesquisa = "lenovo";
        tela.preencherCampoBuscaAndPesquisar(pesquisa);

        tela.tempoDeEspera(10l);
        List<String> lista = tela.obterTextoDasTresPrimeirasPesquisas();

        Assertions.assertTrue(lista.get(0).toLowerCase().contains(pesquisa));
        Assertions.assertTrue(lista.get(1).toLowerCase().contains(pesquisa));
        Assertions.assertTrue(lista.get(2).toLowerCase().contains(pesquisa));
    }

    @Test
    void validarSePesquisaRealizadaNaBuscaRefleteAoQueFoiEscritoNaPagina() {
        tela = new Busca(pagina.gerarPagina("https://www.fastshop.com.br/web/"));

        String pesquisa = "lenovo";
        tela.preencherCampoBuscaAndPesquisar(pesquisa);

        tela.tempoDeEspera(10l);

        Assertions.assertEquals(tela.obterTextoDoResultadoDePesquisa(), pesquisa);

    }
}
