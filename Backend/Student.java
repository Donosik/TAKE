package pl.take.akademiki;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	int id;
	String imie;
	String nazwisko;
	String dataUr;
	String kierunek;
	String adres;
	@OneToMany(fetch = FetchType.EAGER)
	List<Oplata> oplaty;
	
	public int getId()
	{
		return id;
	}
	
	public List<Oplata> getOplaty()
	{
		return oplaty;
	}
	public void setOplaty(List<Oplata> value)
	{
		oplaty=value;
	}
	public boolean addOplata(Oplata value)
	{
		for(Oplata oplata:oplaty)
		{
			if(oplata.id==value.id)
			{
				return false;
			}
		}
		oplaty.add(value);
		return true;
	}
	public boolean removeOplata(Oplata value)
	{
		return oplaty.remove(value);
	}
	
	public void setImie(String value)
	{
		imie=value;
	}
	public String getImie()
	{
		return imie;
	}
	
	public void setNazwisko(String value)
	{
		nazwisko=value;
	}
	public String getNazwisko()
	{
		return nazwisko;
	}
	
	public void setDataUr(String value)
	{
		dataUr=value;
	}
	public String getDataUr()
	{
		return dataUr;
	}
	
	public void setKierunek(String value)
	{
		kierunek=value;
	}
	public String getKierunek()
	{
		return kierunek;
	}
	
	public void setAdres(String value)
	{
		adres=value;
	}
	public String getAdres()
	{
		return adres;
	}
}
