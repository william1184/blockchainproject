package br.com.william;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import com.google.common.hash.Hashing;

public class Bloco {
	
	private long indice;
	private String hash;
	private String hashAnterior;
	private String dados;
	private LocalDateTime timestamp;
	private long versao;
	
	public Bloco(long indice, String hashAnterior, String dados, long versao) {
		this.indice = indice;
		this.hashAnterior = hashAnterior;
		this.dados = dados;
		this.timestamp = LocalDateTime.now();
		this.versao = versao;
		this.hash = this.gerarHash();
	}
	
	public String gerarHash() {
		StringBuilder hash = new StringBuilder();
		
		hash.append( this.indice )
			.append( this.hashAnterior )
			.append( this.dados )
			.append( this.timestamp )
			.append( this.versao );
		
		return Hashing.sha256().hashString(hash, StandardCharsets.UTF_8).toString();
	}

	@Override
	public String toString() {
		return "\n Block [indice=" + indice + ", hash=" + hash + ", hashAnterior=" + hashAnterior + ", dados=" + dados
				+ ", timestamp=" + timestamp + ", versao=" + versao + "]";
	}

	public long getIndice() {
		return indice;
	}

	public String getHash() {
		return hash;
	}

	public String getHashAnterior() {
		return hashAnterior;
	}

	public String getDados() {
		return dados;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public long getVersao() {
		return versao;
	};
	
	
}
