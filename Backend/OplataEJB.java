package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class OplataEJB extends DefaultEJB<Oplata> {
	
	public Oplata get(int id)
	{
		return manager.find(Oplata.class,id);
	}
	
	public List<Oplata> getAll()
	{
		Query q=manager.createQuery("select o from Oplata o");
		@SuppressWarnings("unchecked")
		List<Oplata> list=q.getResultList();
		return list;
	}
}
