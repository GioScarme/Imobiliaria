package br.com.imobiliaria.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.imobiliaria.domain.Imovel;
import br.com.imobiliaria.util.HibernateUtil;

public class ImovelDAO extends GenericDAO<Imovel>{
	@SuppressWarnings("unchecked")
	public List<Imovel> buscarImovelCidade(Imovel imovelSelecionado) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
		Imovel imovel = new Imovel();
		
			Criteria consulta = sessao.createCriteria(Imovel.class);
			consulta.add(Restrictions.idEq(imovel.getCidade())); //serve para restringir o que eu quero buscar, no caso vai buscar através do código
			
			return consulta.list();
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}

