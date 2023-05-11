package pl.take.akademiki;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Akademik {
	
	@Id
	@GeneratedValue
	int id;
	int numer;
	String adres;
	String nazwa;
	@OneToMany(fetch = FetchType.EAGER)
	List<Pokoj> pokoje;
	
	public int getId()
	{
		return id;
	}
	
	public List<Pokoj> getPokoje()
	{
		return pokoje;
	}
	public void setPokoje(List<Pokoj> value)
	{
		pokoje=value;
	}
	public boolean addPokoj(Pokoj value)
	{
		for(Pokoj pokoj:pokoje)
		{
			if(pokoj.id==value.id)
			{
				return false;
			}
		}
		pokoje.add(value);
		return true;
	}
	public boolean removePokoj(Pokoj value)
	{
		return pokoje.remove(value);
	}
	
	public int getNumer()
	{
		return numer;
	}
	public void setNumer(int value)
	{
		numer=value;
	}
	
	public String getAdres()
	{
		return adres;
	}
	public void setAdres(String value)
	{
		adres=value;
	}
	
	public String getNazwa()
	{
		return nazwa;
	}
	public void setNazwa(String value)
	{
		nazwa=value;
	}
	
}
