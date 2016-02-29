package br.com.uem.iss.sisnut.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;

import br.com.uem.iss.sisnut.modelo.Alimento;
import br.com.uem.iss.sisnut.modelo.Avaliacao;
import br.com.uem.iss.sisnut.modelo.Cardapio;
import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.modelo.Refeicao;
import br.com.uem.iss.sisnut.modelo.TipoRefeicao;
import br.com.uem.iss.sisnut.repositorio.PerfilRepositorio;
import br.com.uem.iss.sisnut.view.CardapioBean;

@Component("cardapioControle")
public class CardapioControle {
	//WILLIANS Gerar Cardapios
	
	
	
	private Avaliacao avaliacaoSelecionado;

	public CardapioBean gerarCardapio(){
		float peso = avaliacaoSelecionado.getPeso();
		float altura = avaliacaoSelecionado.getAltura();
		float imc = peso / (altura*altura);
		
		Cardapio cardapio = gerarCardapioTemplate();
		
		if(imc<18.5){
			
			
			return new CardapioBean(cardapio, new EventFactorySupport().success(this));
		}else{
			if(imc<25){
				return new CardapioBean(cardapio, new EventFactorySupport().success(this));
			}else{
				return new CardapioBean(cardapio, new EventFactorySupport().success(this));
			}
		}
		
		
		
		
	}
	
	private Cardapio gerarCardapioTemplate(){
		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		Refeicao cafedaManha = new Refeicao();
		TipoRefeicao tipoRefeicao = new TipoRefeicao();
		tipoRefeicao.setTiporefeicao("Café da Manhã");
		
		cafedaManha.setTipoRefeicao(tipoRefeicao);
		
		List<Alimento> alimentos = new ArrayList<Alimento>();
		Alimento cafe = new Alimento();
		Produto cafeP = new Produto();
		cafeP.setProduto("Café");
		cafe.setProduto(cafeP);
		
		
		cafe.setQuantidade(1);
		Alimento pao = new Alimento();
		Produto paoP = new Produto();
		paoP.setProduto("Pâo");
		pao.setQuantidade(1);
		pao.setProduto(paoP);
		
		alimentos.add(pao);
		alimentos.add(cafe);
		
		cafedaManha.setAlimentos(alimentos);
		refeicoes.add(cafedaManha);
		
		Cardapio cardapio = new Cardapio();
		cardapio.setRefeicao(refeicoes);
		
		return cardapio;
		
		
	}
	
	public Avaliacao getAvaliacaoSelecionado() {
		return avaliacaoSelecionado;
	}

	public void setAvaliacaoSelecionado(Avaliacao avaliacaoSelecionado) {
		this.avaliacaoSelecionado = avaliacaoSelecionado;
	}

	
}
