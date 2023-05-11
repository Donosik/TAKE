package pl.take.akademiki;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Oplata {

	@Id
	@GeneratedValue
	int id;
	int kwota;
	String data;
	
	public int getId()
	{
		return id;
	}
	
	public void setKwota(int value)
	{
		kwota=value;
	}
	public int getKwota()
	{
		return kwota;
	}
	
	public void setData(String value)
	{
		data=value;
	}
	public String getData()
	{
		return data;
	}
}
