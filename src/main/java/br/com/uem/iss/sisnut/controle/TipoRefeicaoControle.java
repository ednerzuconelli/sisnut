package br.com.uem.iss.sisnut.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.TipoRefeicao;
import br.com.uem.iss.sisnut.servico.TipoRefeicaoServico;
import br.com.uem.iss.sisnut.view.TipoRefeicaoBean;

@Component("tiporefeicaoControle")
public class TipoRefeicaoControle {
	
	@Autowired
	private TipoRefeicaoServico tiporefeicaoservico;
	
	public TipoRefeicaoBean newTipoRefeicaoBean(){
    	TipoRefeicao tiporefeicao = new TipoRefeicao();
    	
    	return new TipoRefeicaoBean(tiporefeicao, new EventFactorySupport().success(this));
    }

	public List<TipoRefeicao> findAll(){
		return tiporefeicaoservico.findAll();
	}
	 
	public Event salveTipoRefeicao(TipoRefeicaoBean tiporefeicaobean,MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			TipoRefeicao tiporefeicao = tiporefeicaobean.getTiporefeicao();
			tiporefeicao.setAtivo(1);
			tiporefeicaoservico.save(tiporefeicao);
		}catch (Throwable ex3){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.tiporefeicao.salve");
			  messageBuilder.arg(ex3);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
}
}
