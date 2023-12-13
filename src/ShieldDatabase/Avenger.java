package ShieldDatabase;

import java.io.File;
import java.io.FileNotFoundException;

public class Avenger extends SuperPeople
{

	private static String superPerson;

	public Avenger() throws FileNotFoundException
	{
		super(Origin(), setLocation());

	}

	public void indexUpdater(String newIndex)
	{
		// index for drop down selection
		setSuperPerson(newIndex);
	}

	public static File Origin() throws FileNotFoundException
	{

		if (getSuperPerson() == "Thor")
		{
			File ThorOrigin = new File("ThorOrigin.txt");
			return ThorOrigin;
		}

		File ThorOrigin;
		if (getSuperPerson() == "Iron Man")
		{
			File IronManOrigin = new File("IronManOrigin.txt");
			return IronManOrigin;
		}
		if (getSuperPerson() == "Hulk")
		{
			File HulkOrigin = new File("HulkOrigin.txt");
			return HulkOrigin;
		}
		if (getSuperPerson() == "Captain America")
		{
			File CaptainAmericaOrigin = new File("CaptainAmericaOrigin.txt");
			return CaptainAmericaOrigin;
		}
		else return ThorOrigin = new File("ThorOrigin.txt");

	}

	public static String setLocation()
	{

		String thorLocation, ironManLocation, hulkLocation,
				captainAmericaLocation;

		if ("Thor".equals(getSuperPerson()))
		{
			return thorLocation = "Location- Asgard";
		}
		if ("Iron Man".equals(getSuperPerson()))
		{
			ironManLocation = "Location- Manhattan, New York";
			return ironManLocation;
		}
		if ("Hulk".equals(getSuperPerson()))
		{
			hulkLocation = "Location- Dayton, Ohio";
			return hulkLocation;
		}
		if ("Captain America".equals(getSuperPerson()))
		{
			captainAmericaLocation = "Location- Brooklyn, New York";
			return captainAmericaLocation;
		}
		return null;

	}

	public static String getSuperPerson()
	{
		return superPerson;
	}

	public static void setSuperPerson(String newIndex)
	{
		Avenger.superPerson = newIndex;
	}

}
