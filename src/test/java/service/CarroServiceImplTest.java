package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarroServiceImplTest {

    @Test
    public void podeLigarQuandoDesligado() {
        CarroService carroService = new CarroServiceImpl();

        //QUANDO DESLIGADO, DEVE SER CAPAZ DE LIGAR:
        //EXEMPLO COM ASSERTTRUE
        // Given
        Carro carroTeste01 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste01);
        // Then
        Assert.assertTrue(carroTeste01.isLigado());
    }

    @Test
    public void deveMostrarEstadoAtual() {
        CarroService carroService = new CarroServiceImpl();

        //DEVE MOSTRAR ESTADO ATUAL:
        //EXEMPLO COM ASSERTTRUE E ASSERTEQUALS
        // Given
        Carro carroTeste02 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste02);
        carroService.acelerar(carroTeste02, 10);
        // Then
        Assert.assertTrue(carroTeste02.isLigado());
        Assert.assertEquals(10, carroTeste02.getVelocidadeAtual());
        carroService.estadoAtual(carroTeste02);
    }

    @Test
    public void podeDesligarEnquantoLigado() {
        CarroService carroService = new CarroServiceImpl();

        //ENQUANTO ESTIVER LIGADO PODE SER POSSÍVEL DESLIGAR(Teste simples)
        //EXEMPLO COM ASSERTFALSE
        // Given
        Carro carroTeste03 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste03);
        carroService.desligar(carroTeste03);
        // Then
        Assert.assertFalse(carroTeste03.isLigado());
    }

    @Test
    public void podeDesligarEnquantoLigado2() {
        CarroService carroService = new CarroServiceImpl();

        //ENQUANTO ESTIVER LIGADO PODE SER POSSÍVEL DESLIGAR(Com o limitante de velocidade 0)
        //EXEMPLO COM ASSERTTRUE
        // Given
        Carro carroTeste04 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste04);
        carroService.acelerar(carroTeste04, 30);
        carroService.desligar(carroTeste04);
        // Then
        Assert.assertTrue(carroTeste04.isLigado());
    }

    @Test
    public void podeAcelerarEnquantoLigado() {
        CarroService carroService = new CarroServiceImpl();

        //ENQUANTO ESTIVER LIGADO PODE SER POSSÍVEL ACELERAR(Teste simples):
        //EXEMPLO COM ASSERTEQUALS
        // Given
        Carro carroTeste05 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste05);
        carroService.acelerar(carroTeste05, 30);
        // Then
        Assert.assertEquals(30, carroTeste05.getVelocidadeAtual());
    }

    @Test
    public void podeAcelerarEnquantoLigado2() {
        CarroService carroService = new CarroServiceImpl();

        //ENQUANTO ESTIVER LIGADO PODE SER POSSÍVEL ACELERAR(Teste simples):
        //EXEMPLO COM ASSERTNOTEQUALS
        // Given
        Carro carroTeste06 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste06);
        carroService.acelerar(carroTeste06, 110);
        carroService.acelerar(carroTeste06, 30);
        // Then
        Assert.assertNotEquals(140, carroTeste06.getVelocidadeAtual());
    }

    @Test
    public void podeFrearEnquantoLigado() {
        CarroService carroService = new CarroServiceImpl();

        //ENQUANTO ESTIVER LIGADO PODE SER POSSÍVEL FREAR(Teste simples):
        //EXEMPLO COM ASSERTEQUALS
        // Given
        Carro carroTeste07 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste07);
        carroService.acelerar(carroTeste07, 110);
        carroService.frear(carroTeste07, 30);
        // Then
        Assert.assertEquals(80, carroTeste07.getVelocidadeAtual());
    }

    @Test
    public void podeFrearEnquantoLigado2() {
        CarroService carroService = new CarroServiceImpl();

        //ENQUANTO ESTIVER LIGADO PODE SER POSSÍVEL FREAR(Teste com limitante de velocidade negativa):
        //EXEMPLO COM ASSERNOTEQUALS
        // Given
        Carro carroTeste08 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);
        //When
        carroService.ligar(carroTeste08);
        carroService.frear(carroTeste08, 30);
        // Then
        Assert.assertEquals(0, carroTeste08.getVelocidadeAtual());
        carroService.estadoAtual(carroTeste08);
    }

    @Test
    public void iniciaDesligado() {
        CarroService carroService = new CarroServiceImpl();

        //O CARRO DEVE INICIAR DESLIGADO
        // Given
        Carro carroTeste03 = new Carro("Preto", "Volkswagen", "Fusca", 2015, 110);

        // Then
        Assert.assertFalse(carroTeste03.isLigado());
    }
}