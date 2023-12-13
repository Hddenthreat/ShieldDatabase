package ShieldDatabase;

import java.io.File;

public class SuperPeople
{
	private File origin;
	private String location;
	private String status;

	public SuperPeople(File origin, String location)
	{
		this.location = location;
		this.origin = origin;

	}

	File getOrigin()
	{

		return origin;
	}

	String getLocation()
	{

		return location;
	}

	String getStatus()
	{

		return status;
	}

}
