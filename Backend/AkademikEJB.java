package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class AkademikEJB extends DefaultEJB<Akademik> {

	@Override
	public Akademik get(int id)
	{
		return manager.find(Akademik.class,id);
	}
	
	@Override
	public List<Akademik> getAll()
	{
		Query q = manager.createQuery("select a from Akademik a");
		@SuppressWarnings("unchecked")
		List<Akademik> list = q.getResultList();
		return list;
	}

	public boolean addObject(int id, Pokoj object) {
		Akademik akademik=get(id);
		if(akademik==null)
			return false;
		if(akademik.addPokoj(object))
		{
			manager.persist(object);
			manager.merge(akademik);
			return true;
		}
		else
			return false;
	}

	public boolean addObject(int id, int objectId) {
		Pokoj pokoj=manager.find(Pokoj.class, objectId);
		if(pokoj==null)
			return false;
		if(addObject(id,pokoj))
			return true;
		else
			return false;
	}

	public boolean removeObject(int id, int objectId) {
		Akademik akademik=get(id);
		if(akademik==null)
			return false;
		Pokoj pokoj=manager.find(Pokoj.class, objectId);
		if(pokoj==null)
			return false;
		if(akademik.removePokoj(pokoj))
		{
			manager.merge(akademik);
			return true;
		}
		else
			return false;
	}
	
}
