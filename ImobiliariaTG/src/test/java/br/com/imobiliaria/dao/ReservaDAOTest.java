package br.com.imobiliaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.imobiliaria.domain.Imovel;
import br.com.imobiliaria.domain.Reserva;
import br.com.imobiliaria.domain.Usuario;

public class ReservaDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoImovel = 1L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigoImovel);

		Long codigoUsuario = 4L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		Reserva reserva = new Reserva();

		reserva.setDataFinalReserva(new SimpleDateFormat("dd/MM/yyyy").parse("23/04/2022"));
		reserva.setDataInicioReserva(new SimpleDateFormat("dd/MM/yyyy").parse("18/04/2022"));
		reserva.setDataSolicitacao(new SimpleDateFormat("dd/MM/yyyy").parse("12/02/2022"));
		reserva.setImovel(imovel);
		reserva.setStatus("Aguandando");
		reserva.setUsuarioLocador(usuario);
		reserva.setValorTotal(new BigDecimal(1200.00));

		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.salvar(reserva);
	}

	@Test
	@Ignore
	public void listar() {
		ReservaDAO reservaDAO = new ReservaDAO();
		List<Reserva> resultado = reservaDAO.listar();

		for (Reserva reserva : resultado) {
			System.out.println("Código: " + reserva.getCodigo());
			System.out.println("Status: " + reserva.getStatus());
			System.out.println("Código do Imóvel: " + reserva.getImovel().getCodigo());
			System.out.println("Usuário: " + reserva.getUsuarioLocador().getPessoa().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ReservaDAO reservaDAO = new ReservaDAO();
		Reserva reserva = reservaDAO.buscar(codigo);

		System.out.println("Código: " + reserva.getCodigo());
		System.out.println("Status: " + reserva.getStatus());
		System.out.println("Código do Imóvel: " + reserva.getImovel().getCodigo());
		System.out.println("Usuário: " + reserva.getUsuarioLocador().getPessoa().getNome());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		ReservaDAO reservaDAO = new ReservaDAO();
		Reserva reserva = reservaDAO.buscar(codigo);
		
		reservaDAO.excluir(reserva);
		
		System.out.println("Reserva removido: ");
		System.out.println("Código: " + reserva.getCodigo());
		System.out.println("Status: " + reserva.getStatus());
		System.out.println("Código do Imóvel: " + reserva.getImovel().getCodigo());
		System.out.println("Usuário: " + reserva.getUsuarioLocador().getPessoa().getNome());

	}
	
	@Test
	public void editar(){
		Long codigoReserva = 1L;
		ReservaDAO reservaDAO = new ReservaDAO();
		Reserva reserva = reservaDAO.buscar(codigoReserva);
		
		Long codigoImovel = 3L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigoImovel);
		
		Long codigoUsuario = 5L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		System.out.println("Reserva a ser editada: ");
		System.out.println("Código: " + reserva.getCodigo());
		System.out.println("Status: " + reserva.getStatus());
		System.out.println("Código do Imóvel: " + reserva.getImovel().getCodigo());
		System.out.println("Usuário: " + reserva.getUsuarioLocador().getPessoa().getNome());
		
		reserva.setImovel(imovel);
		reserva.setStatus("Confirmado");
		reserva.setUsuarioLocador(usuario);
		
		reservaDAO.editar(reserva);
		
		System.out.println("Reserva editada: ");
		System.out.println("Código: " + reserva.getCodigo());
		System.out.println("Status: " + reserva.getStatus());
		System.out.println("Código do Imóvel: " + reserva.getImovel().getCodigo());
		System.out.println("Usuário: " + reserva.getUsuarioLocador().getPessoa().getNome());
		
	}
}
