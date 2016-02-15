package testes;

public class LogMock implements GeradorDeLog {

	private String nome;
	
	@Override
	public void criaLog(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}

}
