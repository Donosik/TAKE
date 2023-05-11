package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class PokojEJB extends DefaultEJB<Pokoj>{
	
	@Override
	public Pokoj get(int id)
	{
		return manager.find(Pokoj.class, id);
	}
	
	@Override
	public List<Pokoj> getAll()
	{
		Query q=manager.createQuery("select p from Pokoj p");
		@SuppressWarnings("unchecked")
		List<Pokoj> list=q.getResultList();
		return list;
	}

	public boolean addObject(int id, Student object) {
		Pokoj pokoj=get(id);
		if(pokoj==null)
			return false;
		if(pokoj.addStudent(object))
		{	
			manager.persist(object);
			manager.merge(pokoj);
			return true;
		}
		else
			return false;
	}

	public boolean addObject(int id, int objectId) {
		Student student=manager.find(Student.class, objectId);
		if(student==null)
			return false;
		if(addObject(id, student))
			return true;
		else
			return false;
	}

	public boolean removeObject(int id, int objectId) {
		Pokoj pokoj=get(id);
		if(pokoj==null)
			return false;
		Student student=manager.find(Student.class, objectId);
		if(student==null)
			return false;
		if(pokoj.removeStudent(student))
		{
			manager.merge(pokoj);
			return true;
		}
		else
			return false;
	}

}
