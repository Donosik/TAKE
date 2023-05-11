package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class StudentEJB extends DefaultEJB<Student>{
	
	@Override
	public Student get(int id)
	{
		return manager.find(Student.class, id);
	}
	
	@Override
	public List<Student> getAll()
	{
		Query q=manager.createQuery("select s from Student s");
		@SuppressWarnings("unchecked")
		List<Student> list=q.getResultList();
		return list;
	}

	public boolean addObject(int id, Oplata object) {
		Student student=get(id);
		if(student==null)
			return false;
		if(student.addOplata(object))
		{
			manager.persist(object);
			manager.merge(student);
			return true;
		}
		else
			return false;
	}

	public boolean addObject(int id, int objectId) {
		Oplata oplata=manager.find(Oplata.class, objectId);
		if(oplata==null)
			return false;
		if(addObject(id, oplata))
			return true;
		else
			return false;
	}

	public boolean removeObject(int id, int objectId) {
		Student student=get(id);
		if(student==null)
			return false;
		Oplata oplata=manager.find(Oplata.class, objectId);
		if(oplata==null)
			return false;
		if(student.removeOplata(oplata))
		{
			manager.merge(student);
			return true;
		}
		else
			return false;
	}
}
