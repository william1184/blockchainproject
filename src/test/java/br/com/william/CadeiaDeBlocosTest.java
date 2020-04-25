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
		
		Assert.assertTrue("Não iniciado o blockchain", ultimoBloco.isPresent());
		
		Assert.assertEquals("Não inserido bloco genesis", "Genesis block", ultimoBloco.get().getDados() );
	}
	
	@Test
	public void deveInserirBloco() {
		
		blockchain.inserirBloco( "Novo bloco" );
		
		Assert.assertEquals("Bloco não inserido", 2 , blockchain.getListaBlocos().size());
		
		Assert.assertEquals("Bloco não inserido", "Novo bloco" , blockchain.getUltimoBloco().getDados());
		
	}
	
	@Test
	public void deveEstarValido() {
		
		blockchain.inserirBloco( "Novo bloco valido 1" );
		
		blockchain.inserirBloco( "Novo bloco valido 2" );
		
		Assert.assertEquals("Bloco não inserido", 3 , blockchain.getListaBlocos().size());

		Assert.assertTrue("Blockchain está invalido", blockchain.isBlockchainValido() );
		
	}
	
	
}
