package br.com.william;

public class BlockchainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CadeiaDeBlocos blockChain = new CadeiaDeBlocos();
		
		blockChain.inserirBloco("Dados a incluir");
		blockChain.inserirBloco("Dados a incluir");
		blockChain.inserirBloco("Dados a incluir");
		System.out.println( blockChain.toString() );
	}

}
