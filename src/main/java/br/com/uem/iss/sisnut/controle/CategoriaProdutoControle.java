package br.com.uem.iss.sisnut.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.CategoriaProduto;
import br.com.uem.iss.sisnut.modelo.TipoRefeicao;
import br.com.uem.iss.sisnut.servico.CategoriaProdutoServico;
import br.com.uem.iss.sisnut.view.CategoriaProdutoBean;
import br.com.uem.iss.sisnut.view.TipoRefeicaoBean;

@Component("categoriaprodutoControle")
public class CategoriaProdutoControle {

	@Autowired
	private CategoriaProdutoServico categoriaprodutoservico;
	
	public CategoriaProdutoBean newCategoriaProdutoBean(){
		CategoriaProduto categoriaproduto = new CategoriaProduto();
		return new CategoriaProdutoBean(categoriaproduto, new EventFactorySupport().success(this));
	}
	
	public List<CategoriaProduto> getAll(){
		return categoriaprodutoservico.getAll();
	}
	
	public Event salveCategoriaProduto(CategoriaProdutoBean categoriaprodutobean,MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			CategoriaProduto categoriaproduto = categoriaprodutobean.getCategoriaProduto();
			categoriaproduto.setAtivo(1);
			categoriaprodutoservico.save(categoriaproduto);
		}catch (Throwable ex3){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.categoriaproduto.salve");
			  messageBuilder.arg(ex3);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
	}
}
