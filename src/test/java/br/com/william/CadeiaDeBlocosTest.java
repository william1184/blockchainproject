package br.com.william;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CadeiaDeBlocosTest {
	CadeiaDeBlocos blockchain;
	
	@Before
	public void init() {
		blockchain = new CadeiaDeBlocos();
	}
	
	@Test
	public void deveExistirBlocoGenesis() {
		Optional<Bloco> ultimoBloco = Optional.ofNullable( blockchain.getUltimoBloco() );
		
		Assert.assertTrue("N�o iniciado o blockchain", ultimoBloco.isPresent());
		
		Assert.assertEquals("N�o inserido bloco genesis", "Genesis block", ultimoBloco.get().getDados() );
	}
	
	@Test
	public void deveInserirBloco() {
		
		blockchain.inserirBloco( "Novo bloco" );
		
		Assert.assertEquals("Bloco n�o inserido", 2 , blockchain.getListaBlocos().size());
		
		Assert.assertEquals("Bloco n�o inserido", "Novo bloco" , blockchain.getUltimoBloco().getDados());
		
	}
	
	@Test
	public void deveEstarValido() {
		
		blockchain.inserirBloco( "Novo bloco valido 1" );
		
		blockchain.inserirBloco( "Novo bloco valido 2" );
		
		Assert.assertEquals("Bloco n�o inserido", 3 , blockchain.getListaBlocos().size());

		Assert.assertTrue("Blockchain est� invalido", blockchain.isBlockchainValido() );
		
	}
	
	
}
