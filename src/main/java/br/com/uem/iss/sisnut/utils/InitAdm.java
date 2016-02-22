package br.com.uem.iss.sisnut.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.uem.iss.sisnut.modelo.Alimento;
import br.com.uem.iss.sisnut.modelo.CategoriaProduto;
import br.com.uem.iss.sisnut.modelo.Perfil;
import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.modelo.Refeicao;
import br.com.uem.iss.sisnut.modelo.TipoRefeicao;
import br.com.uem.iss.sisnut.servico.CategoriaProdutoServico;
import br.com.uem.iss.sisnut.servico.PerfilServico;
import br.com.uem.iss.sisnut.servico.ProdutoServico;
import br.com.uem.iss.sisnut.servico.RefeicaoServico;
import br.com.uem.iss.sisnut.servico.TipoRefeicaoServico;
import br.com.uem.iss.sisnut.servico.jpa.CategoriaProdutoServicoImp;

public class InitAdm {
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@Autowired
	private CategoriaProdutoServico  categoriaServico;
	
	@Autowired
	private RefeicaoServico refeicaoServico;
	
	@Autowired
	private PerfilServico perfilServico;
	
	@Autowired 
	private TipoRefeicaoServico tipoServico;
	
	
	
	
	@PostConstruct
	public void init(){
		cadastrarProdutos();
		//cadastrarPerfil();
		//cadastrarPerfil2();
		//cadastrarPerfil3();
	}
	
	public void cadastrarProdutos(){
		
		CategoriaProduto categoriaAlimento = new CategoriaProduto();
		categoriaAlimento.setAtivo(1);
		categoriaAlimento.setCategoriaproduto("Alimento");
		
		CategoriaProduto categoriaFito = new CategoriaProduto();
		categoriaFito.setAtivo(1);
		categoriaFito.setCategoriaproduto("Fitoterápico");
		
		categoriaServico.save(categoriaAlimento);
		categoriaServico.save(categoriaFito);
		
		
		for(NomeProdutosBasicos n: NomeProdutosBasicos.values()){
			Produto produto = new Produto();
			produto.setProduto(n.valor);
			produto.setAtivo(1);
			produto.setCategoriaproduto(categoriaAlimento);
			produtoServico.save(produto);
			
		}
		
		Produto produto = new Produto();
		produto.setProduto("Termogênico");
		produto.setAtivo(1);
		produto.setCategoriaproduto(categoriaFito);
		produtoServico.save(produto);
		
	}
	
	public void cadastrarPerfil(){
		Perfil perfil1 = new Perfil();
		perfil1.setImc((float) 18.5);
		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		
		
		List<Produto> produto = produtoServico.findAll();
		List<Alimento> cafeP = new ArrayList<Alimento>();
		
		Refeicao cafe = new Refeicao();
		TipoRefeicao cafetipo = new TipoRefeicao();
		cafetipo.setTiporefeicao("Café da Manhã");
		tipoServico.save(cafetipo);
		cafe.setTipoRefeicao(cafetipo);
		
		Alimento cafeA = new Alimento();
		cafeA.setProduto(produto.get(0));
		cafeA.setQuantidade(1);
		cafeP.add(cafeA);
		
		
		Alimento cafeB = new Alimento();
		cafeB.setProduto(produto.get(1));
		cafeB.setQuantidade(2);
		cafeP.add(cafeB);
		
		cafe.setAlimentos(cafeP);
		
		refeicoes.add(cafe);
		
		refeicaoServico.save(cafe);
		
		
		Refeicao almoco = new Refeicao();
		
		List<Alimento> almocoP = new ArrayList<Alimento>();
		
		
		TipoRefeicao almocotipo = new TipoRefeicao();
		almocotipo.setTiporefeicao("Almoço");
		tipoServico.save(almocotipo);
		almoco.setTipoRefeicao(almocotipo);
		
		Alimento almocoA = new Alimento();
		almocoA.setProduto(produto.get(3));
		almocoA.setQuantidade(1);
		almocoP.add(almocoA);
		
		Alimento almocoB = new Alimento();
		almocoB.setProduto(produto.get(4));
		almocoB.setQuantidade(2);
		almocoP.add(almocoB);
		
		Alimento almocoC = new Alimento();
		almocoC.setProduto(produto.get(5));
		almocoC.setQuantidade(1);
		almocoP.add(almocoC);
		
		almoco.setAlimentos(almocoP);
		
		refeicoes.add(almoco);
		refeicaoServico.save(almoco);
		
		
		Refeicao janta = new Refeicao();
		
		List<Alimento> jantaP = new ArrayList<Alimento>();
		
		
		TipoRefeicao jantatipo = new TipoRefeicao();
		jantatipo.setTiporefeicao("Jantar");
		tipoServico.save(jantatipo);
		janta.setTipoRefeicao(jantatipo);
		
		Alimento jantaA = new Alimento();
		jantaA.setProduto(produto.get(3));
		jantaA.setQuantidade(1);
		jantaP.add(jantaA);
		
		Alimento jantaB = new Alimento();
		jantaB.setProduto(produto.get(7));
		jantaB.setQuantidade(2);
		jantaP.add(jantaB);
		
		Alimento jantaC = new Alimento();
		jantaC.setProduto(produto.get(5));
		jantaC.setQuantidade(1);
		jantaP.add(jantaC);
		
		janta.setAlimentos(jantaP);
		
		refeicoes.add(janta);
		refeicaoServico.save(janta);
		
		perfil1.setRefeicao(refeicoes);
		perfilServico.save(perfil1);
		
	}
	
	public void cadastrarPerfil2(){
		Perfil perfil1 = new Perfil();
		perfil1.setImc((float) 25);
		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		
		
		List<Produto> produto = produtoServico.findAll();
		List<Alimento> cafeP = new ArrayList<Alimento>();
		
		Refeicao cafe = new Refeicao();
		TipoRefeicao cafetipo = new TipoRefeicao();
		cafetipo.setTiporefeicao("Café da Manhã");
		tipoServico.save(cafetipo);
		cafe.setTipoRefeicao(cafetipo);
		
		Alimento cafeA = new Alimento();
		cafeA.setProduto(produto.get(0));
		cafeA.setQuantidade(1);
		cafeP.add(cafeA);
		
		
		Alimento cafeB = new Alimento();
		cafeB.setProduto(produto.get(1));
		cafeB.setQuantidade(4);
		cafeP.add(cafeB);
		
		cafe.setAlimentos(cafeP);
		
		refeicoes.add(cafe);
		
		
		Refeicao almoco = new Refeicao();
		
		List<Alimento> almocoP = new ArrayList<Alimento>();
		
		
		TipoRefeicao almocotipo = new TipoRefeicao();
		almocotipo.setTiporefeicao("Almoço");
		tipoServico.save(almocotipo);
		almoco.setTipoRefeicao(almocotipo);
		
		Alimento almocoA = new Alimento();
		almocoA.setProduto(produto.get(1));
		almocoA.setQuantidade(1);
		almocoP.add(almocoA);
		
		Alimento almocoB = new Alimento();
		almocoB.setProduto(produto.get(1));
		almocoB.setQuantidade(3);
		almocoP.add(almocoB);
		
		Alimento almocoC = new Alimento();
		almocoC.setProduto(produto.get(5));
		almocoC.setQuantidade(2);
		almocoP.add(almocoC);
		
		almoco.setAlimentos(almocoP);
		
		refeicoes.add(almoco);
		
		
		
		Refeicao janta = new Refeicao();
		
		List<Alimento> jantaP = new ArrayList<Alimento>();
		
		
		TipoRefeicao jantatipo = new TipoRefeicao();
		jantatipo.setTiporefeicao("Jantar");
		tipoServico.save(jantatipo);
		janta.setTipoRefeicao(jantatipo);
		
		Alimento jantaA = new Alimento();
		jantaA.setProduto(produto.get(3));
		jantaA.setQuantidade(1);
		jantaP.add(jantaA);
		
		Alimento jantaB = new Alimento();
		jantaB.setProduto(produto.get(7));
		jantaB.setQuantidade(2);
		jantaP.add(jantaB);
		
		Alimento jantaC = new Alimento();
		jantaC.setProduto(produto.get(5));
		jantaC.setQuantidade(1);
		jantaP.add(jantaC);
		
		janta.setAlimentos(jantaP);
		
		refeicoes.add(janta);
		
		perfil1.setRefeicao(refeicoes);
		perfilServico.save(perfil1);
		
	}
	
	public void cadastrarPerfil3(){
		Perfil perfil1 = new Perfil();
		perfil1.setImc((float) 99);
		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		
		
		List<Produto> produto = produtoServico.findAll();
		List<Alimento> cafeP = new ArrayList<Alimento>();
		
		Refeicao cafe = new Refeicao();
		TipoRefeicao cafetipo = new TipoRefeicao();
		cafetipo.setTiporefeicao("Café da Manhã");
		tipoServico.save(cafetipo);
		cafe.setTipoRefeicao(cafetipo);
		
		Alimento cafeA = new Alimento();
		cafeA.setProduto(produto.get(0));
		cafeA.setQuantidade(1);
		cafeP.add(cafeA);
		
		
		Alimento cafeB = new Alimento();
		cafeB.setProduto(produto.get(1));
		cafeB.setQuantidade(4);
		cafeP.add(cafeB);
		
		cafe.setAlimentos(cafeP);
		
		refeicoes.add(cafe);
		
		
		Refeicao almoco = new Refeicao();
		
		List<Alimento> almocoP = new ArrayList<Alimento>();
		
		
		TipoRefeicao almocotipo = new TipoRefeicao();
		almocotipo.setTiporefeicao("Almoço");
		tipoServico.save(almocotipo);
		almoco.setTipoRefeicao(almocotipo);
		
		Alimento almocoA = new Alimento();
		almocoA.setProduto(produto.get(1));
		almocoA.setQuantidade(9);
		almocoP.add(almocoA);
		
		Alimento almocoB = new Alimento();
		almocoB.setProduto(produto.get(1));
		almocoB.setQuantidade(3);
		almocoP.add(almocoB);
		
		Alimento almocoC = new Alimento();
		almocoC.setProduto(produto.get(2));
		almocoC.setQuantidade(0);
		almocoP.add(almocoC);
		
		almoco.setAlimentos(almocoP);
		
		refeicoes.add(almoco);
		
		
		
		Refeicao janta = new Refeicao();
		
		List<Alimento> jantaP = new ArrayList<Alimento>();
		
		
		TipoRefeicao jantatipo = new TipoRefeicao();
		jantatipo.setTiporefeicao("Jantar");
		tipoServico.save(jantatipo);
		janta.setTipoRefeicao(jantatipo);
		
		Alimento jantaA = new Alimento();
		jantaA.setProduto(produto.get(5));
		jantaA.setQuantidade(3);
		jantaP.add(jantaA);
		
		Alimento jantaB = new Alimento();
		jantaB.setProduto(produto.get(2));
		jantaB.setQuantidade(2);
		jantaP.add(jantaB);
		
		Alimento jantaC = new Alimento();
		jantaC.setProduto(produto.get(5));
		jantaC.setQuantidade(1);
		jantaP.add(jantaC);
		
		janta.setAlimentos(jantaP);
		
		refeicoes.add(janta);
		
		perfil1.setRefeicao(refeicoes);
		perfilServico.save(perfil1);
		
	}
}
