package br.com.uem.iss.sisnut.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.modelo.Usuario;
import br.com.uem.iss.sisnut.servico.UsuarioServico;
import br.com.uem.iss.sisnut.view.UsuarioBean;

@Component("usuarioControle")
public class UsuarioControle {

	@Autowired
	private UsuarioServico usuarioServico;
	
	public UsuarioBean newUsuarioBean(){
		Usuario usuario = new Usuario();
	
		return new UsuarioBean(usuario, new EventFactorySupport().success(this));
	}
	
	public List<Usuario> findAll(){
		return usuarioServico.findAll();
	}
	
	public Event salveUsuario(UsuarioBean usuarioBean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			Usuario usuario = usuarioBean.getUsuario();
			usuario.setAtivo(true);
			usuarioServico.save(usuario);
			
		}catch (Throwable ex3){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.usuario.salve");
			  messageBuilder.arg(ex3);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
	}
}
