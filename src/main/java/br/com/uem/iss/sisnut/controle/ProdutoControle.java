package br.com.uem.iss.sisnut.controle;

import java.util.List;

import javax.faces.model.DataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.servico.ProdutoServico;
import br.com.uem.iss.sisnut.view.ProdutoBean;

@Component("produtoControle")
public class ProdutoControle {
	
	@Autowired
	private ProdutoServico produtoservico;
	
	private DataModel produtos;
	
	 public ProdutoBean newProdutoBean(){
	    	Produto produto = new Produto();
	    	return new ProdutoBean(produto, new EventFactorySupport().success(this));
	    }
	
	public List<Produto> findAll(){
		List<Produto> newp = null;
		//System.out.print
		//ProdutoBean produtobean = null;
		
		newp = produtoservico.findAll();
		//produtobean.setProduto(newp.get(1));
		return newp;
	}
	 
	public Event salveProduto(ProdutoBean produtobean,MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			Produto produto = produtobean.getProduto();
			produto.setAtivo(1);
			produtoservico.save(produto);
		}catch (Throwable ex3){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.produto.salve");
			  messageBuilder.arg(ex3);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
	}
	
	public Event deleteProduto(MessageContext messageContext){
		MessageBuilder messageBuilder = null;
		try{
			
			Produto produto = produtoservico.getById(produtoservico.findAll().size());
			produto.setAtivo(0);
			produtoservico.save(produto);
		} catch (Throwable ex4){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.produto.delete");
			  messageBuilder.arg(ex4);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
		
	}
}
