package br.com.uem.iss.sisnut.utils;

public enum NomeProdutosBasicos {
	PAO("Pão Integral"),LEITE("Leite Desnatado"),MACA("Maçã"),BANANA("Banana"),ARROZ("Arroz Integral"),FEIJAO("Feijão"),CARNE("Carne Vermelha"),FRANGO("Carne de Frango"),BARRA("Barra de Cereal"),OVO("Ovo"),
	ALFACE("Alface"),TOMATE("Tomate"),IOGURTE("Iogurte");
	
	public String valor;
	
	NomeProdutosBasicos(String nome){
		valor = nome;
	}
}
