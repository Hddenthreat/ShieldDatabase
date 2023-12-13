package ShieldDatabase;

public class MissionCalculator
{
	public Jarvis jarvis = new Jarvis();
	public MissionDisplay display = new MissionDisplay();

	/**
	 * missionOne() checks to make sure the win conditions have been met
	 * 
	 */
	public void missionOne()
	{
		if (display.getThorCheck() == true && display.getironManCheck() == true)
		{
			// removes MissionDisplay class GUI
			display.setVisible(false);
		}

	}

	/**
	 * missionTwo() checks to make sure the win conditions have been met
	 */
	public void missionTwo()
	{

		if (display.getCaptainAmericaCheck() == true
				&& display.getHulkCheck() == true)
		{
			// enabling the Jarvis class GUI
			jarvis.setVisible(true);
			// Removing the MissionDisplay GUI
			display.setVisible(false);
		}
	}

}
