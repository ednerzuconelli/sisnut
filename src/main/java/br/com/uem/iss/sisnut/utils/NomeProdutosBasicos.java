package br.com.uem.iss.sisnut.utils;

public enum NomeProdutosBasicos {
	PAO("P�o Integral"),LEITE("Leite Desnatado"),MACA("Ma��"),BANANA("Banana"),ARROZ("Arroz Integral"),FEIJAO("Feij�o"),CARNE("Carne Vermelha"),FRANGO("Carne de Frango"),BARRA("Barra de Cereal"),OVO("Ovo"),
	ALFACE("Alface"),TOMATE("Tomate"),IOGURTE("Iogurte");
	
	public String valor;
	
	NomeProdutosBasicos(String nome){
		valor = nome;
	}
}
