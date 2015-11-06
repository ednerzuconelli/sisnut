package br.com.uem.iss.sisnut.controle;

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
	
	 public ProdutoBean newProdutoBean(){
	    	Produto produto = new Produto();
	    	System.out.println("teste para saber");
	    	return new ProdutoBean(produto, new EventFactorySupport().success(this));
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
}
