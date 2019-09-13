package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

import javax.inject.Inject;

@Repository("domicilioDao")
public class DomicilioDaoImpl implements DomicilioDao {

	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public Domicilio buscarDomicilio(Domicilio domicilio) {

		final Session session = sessionFactory.getCurrentSession();
		return (Domicilio) session.createCriteria(Domicilio.class)
				.add(Restrictions.eq("calle", domicilio.getCalle()))
				.add(Restrictions.eq("numero", domicilio.getNumero()))
				.add(Restrictions.eq("barrio", domicilio.getBarrio()))
				.add(Restrictions.eq("codigo postal", domicilio.getCodigoPostal()));

	}

	@Override
	public void guardar(Domicilio domicilio) {

		Session session = sessionFactory.getCurrentSession();
		session.save(domicilio);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Domicilio> buscarDomicilioPorCalle(String calle) {
		//
		Session session = sessionFactory.getCurrentSession();

		return (List<Domicilio>) session.createCriteria(Domicilio.class).add(Restrictions.eq("calle", calle)).list();
	}

	@Override
	public List<Domicilio> buscarSanJusto(String barrio) {

		Session session = sessionFactory.getCurrentSession();

		return (List<Domicilio>) session.createCriteria(Domicilio.class).add(Restrictions.eq("barrio", barrio)).list();

	}

	@Override
	public List<Domicilio> buscarNumeroCalle(String numero1, String numero2) {

		Session session = sessionFactory.getCurrentSession();

		return (List<Domicilio>) session.createCriteria(Domicilio.class).add(Restrictions.between("numero", numero1, numero2));

	}

	@Override
	public List<Domicilio> buscarSanjustoOrRamosMejia(String barrio1, String barrio2) {

		Session session = sessionFactory.getCurrentSession();

		return (List<Domicilio>) session.createCriteria(Domicilio.class).add(Restrictions.eq("barrio", barrio1))
				// buscarOR
				.list();

	}

}
