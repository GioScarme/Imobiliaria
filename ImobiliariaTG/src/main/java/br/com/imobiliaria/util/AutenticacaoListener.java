//package br.com.imobiliaria.util;
//
//import javax.faces.event.PhaseEvent;
//import javax.faces.event.PhaseId;
//import javax.faces.event.PhaseListener;
//
//import org.omnifaces.util.Faces;
//
//import br.com.imobiliaria.bean.LoginBean;
//import br.com.imobiliaria.domain.Usuario;
//
//@SuppressWarnings("serial")
//public class AutenticacaoListener implements PhaseListener {
//
//	@Override
//	public void afterPhase(PhaseEvent event) {
//		String paginaAtual = Faces.getViewId();
//		
//		boolean ehPaginaDeAutenticacao = paginaAtual.contains("login.xhtml");
//	
//		if(!ehPaginaDeAutenticacao){
//			LoginBean autenticacaoBean = Faces.getSessionAttribute("loginBean");
//
//			if(autenticacaoBean == null){
//				Faces.navigate("/paginas/primeiro_acesso.xhtml");
//				return;
//			}
//			
//			Usuario usuario = autenticacaoBean.getUsuarioLogado();
//			if(usuario == null){
//				Faces.navigate("/paginas/login.xhtml");
//				return;
//			}
//		}		
//	}
//
//	@Override
//	public void beforePhase(PhaseEvent event) {
//		System.out.println("ANTES DA FASE: " + event.getPhaseId());
//	}
//
//	@Override
//	public PhaseId getPhaseId() {
//		return PhaseId.ANY_PHASE;
//	}
//
//}
