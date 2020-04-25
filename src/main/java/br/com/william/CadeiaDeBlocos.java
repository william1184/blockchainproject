package br.com.william;

import java.util.LinkedList;
import java.util.List;

public class CadeiaDeBlocos {
	
	private long indice;
	private List<Bloco> listaBlocos = new LinkedList<Bloco>();
	public static final long VERSAO_1 = 1l;
	
	public CadeiaDeBlocos() {
		listaBlocos.add( new Bloco(0, null, "Genesis block", 1) );
		this.indice = 1;
	}
	
	
	public Bloco getUltimoBloco() {
		return listaBlocos.get( listaBlocos.size() - 1 );
	}
	
	public void inserirBloco(String dados){
		inserirBloco( dados, VERSAO_1);
	}
	
	public void inserirBloco(String dados, long versao){
		String hashAnterior = this.getUltimoBloco().getHash();
		
		listaBlocos.add( new Bloco( indice++, hashAnterior, dados, versao  ) );
	}
	
	public boolean isBlockchainValido() {
		Bloco blocoAnterior = null;
		for (Bloco bloco : listaBlocos) {
			
			if(blocoAnterior != null) {
				
				if( validacoes(blocoAnterior, bloco) ) {
					return false;
				}
				
			}
			blocoAnterior = bloco;
			
		}
		return true;
	}


	private boolean validacoes(Bloco blocoAnterior, Bloco bloco) {
		return 		verificaHashAtualDiferenteHashAtualGerado(bloco) 
				&& 	verificaIndiceAtualIgualIndiceAnteriorMaisUm(blocoAnterior, bloco) 
				&& 	verificaHashAnteriorEstaCorreto(blocoAnterior, bloco);
	}


	private boolean verificaHashAnteriorEstaCorreto(Bloco blocoAnterior, Bloco bloco) {
		return !bloco.getHashAnterior().equals( blocoAnterior.getHash() );
	}


	private boolean verificaIndiceAtualIgualIndiceAnteriorMaisUm(Bloco blocoAnterior, Bloco bloco) {
		return !String.valueOf(bloco.getIndice()).equals( String.valueOf(blocoAnterior.getIndice() + 1) );
	}


	private boolean verificaHashAtualDiferenteHashAtualGerado(Bloco bloco) {
		return !bloco.getHash().equals( bloco.gerarHash() );
	}

	public List<Bloco> getListaBlocos() {
		return listaBlocos;
	}

	@Override
	public String toString() {
		return "CadeiaDeBlocos [blockchain=" + listaBlocos + "]";
	}

	
}
