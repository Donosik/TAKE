package pl.take.akademiki;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pokoj {
	@Id
	@GeneratedValue
	int id;
	int pietro;
	int ileOsob;
	@OneToMany(fetch = FetchType.EAGER)
	List<Student> studenci;
	
	public int getId()
	{
		return id;
	}
	
	public List<Student> getStudenci()
	{
		return studenci;
	}
	public void setStudenci(List<Student> value)
	{
		studenci=value;
	}
	public boolean addStudent(Student value)
	{
		for(Student student:studenci)
		{
			if(student.id==value.id)
			{
				return false;
			}
		}
		studenci.add(value);
		return true;
	}
	public boolean removeStudent(Student value)
	{
		return studenci.remove(value);
	}
	
	public int getPietro()
	{
		return pietro;
	}
	public void setPietro(int value)
	{
		pietro=value;
	}
	
	public int getIleOsob()
	{
		return ileOsob;
	}
	public void setIleOsob(int value)
	{
		ileOsob=value;
	}
}
