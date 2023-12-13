package ShieldDatabase;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MissionDisplay extends JFrame
{
	JPanel missionPanel;
	private JTextArea missionDisplay = new JTextArea();
	private JLabel jugLabel;
	private JLabel redLabel;
	private JLabel thorLabel, ironManLabel, captainAmericaLabel, hulkLabel;
	private JButton back, readChecks;
	private JCheckBox thorCheck, ironManCheck, captainAmericaCheck, hulkCheck;
	boolean clearOne, clearTwo, thorChecked, ironManChecked,
			captainAmericaChecked, hulkChecked;
	Scanner missionReader = null;
	public String missionFinal = "no mission";
	private String mission = "no mission";
	public Jarvis jarvis = new Jarvis();


	/**
	 * MissionDisplay constructor holds all sizing for the GUI as well
	 * as implementation and all images used in program.
	 */
	public MissionDisplay()
	{
		// box title
		super("Mission Loadout");

		final int WINDOW_WIDTH = 1400;
		final int WINDOW_HEIGHT = 500;
		// Juggernaut image sizing
		ImageIcon juggernautImage = new ImageIcon("jugImage.jpeg");
		Image jugImage = juggernautImage.getImage();
		Image newJugImage = jugImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		juggernautImage = new ImageIcon(newJugImage);
		jugLabel = new JLabel(juggernautImage);

		// red skull image sizing
		ImageIcon redSkullImage = new ImageIcon("RedSkullimage.jpeg");
		Image redImage = redSkullImage.getImage();
		Image newRedImage = redImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		redSkullImage = new ImageIcon(newRedImage);
		redLabel = new JLabel(redSkullImage);
		// thor image sizing
		ImageIcon thor = new ImageIcon("ThorImage.jpg");
		Image thorImage = thor.getImage();
		Image newThorImage = thorImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		thor = new ImageIcon(newThorImage);
		thorLabel = new JLabel(thor);
		thorCheck = new JCheckBox("Thor Option");

		// iron man image sizing
		ImageIcon ironMan = new ImageIcon("download2.jpeg");
		Image ironImage = ironMan.getImage();
		Image newIronImage = ironImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		ironMan = new ImageIcon(newIronImage);
		ironManLabel = new JLabel(ironMan);
		ironManCheck = new JCheckBox("Iron Man Option");

		// hulk image
		ImageIcon hulk = new ImageIcon("hulkImage.jpeg");
		Image hulkImage = hulk.getImage();
		Image newHulkImage = hulkImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		hulk = new ImageIcon(newHulkImage);
		hulkLabel = new JLabel(hulk);
		hulkCheck = new JCheckBox("Hulk Option");

		// captain america
		ImageIcon captainAmerica = new ImageIcon("CaptainAmericaImage.jpeg");
		Image captainImage = captainAmerica.getImage();
		Image newCaptainImage = captainImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		captainAmerica = new ImageIcon(newCaptainImage);
		captainAmericaLabel = new JLabel(captainAmerica);
		captainAmericaCheck = new JCheckBox(" Captain America Option");
		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// close pop-up
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel implementation
		missionPanel = new JPanel(new FlowLayout());
		heroes();

		backButton();
		setCheck();

		add(missionPanel);

	}

	/**
	 * heroes() adds all images and check boxes to the GUI
	 */
	public void heroes()
	{
		missionPanel.add(thorLabel, FlowLayout.LEFT);
		missionPanel.add(hulkLabel, FlowLayout.LEFT);
		missionPanel.add(captainAmericaLabel, FlowLayout.LEFT);
		missionPanel.add(ironManLabel, FlowLayout.LEFT);
		missionPanel.add(thorCheck);
		missionPanel.add(hulkCheck, FlowLayout.RIGHT);
		missionPanel.add(captainAmericaCheck, FlowLayout.CENTER);
		missionPanel.add(ironManCheck, FlowLayout.LEFT);
	}

	/**
	 * backButton() adds the back button functionality to go back to
	 * mission selection
	 */
	public void backButton()
	{
		back = new JButton(new AbstractAction("Back")
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (clearOne == true)
				{
					missionPanel.remove(jugLabel);
				}
				if (clearTwo == true)
				{
					missionPanel.remove(redLabel);

				}

				missionDisplay.setText("");
				setVisible(false);
			}

		});
		missionPanel.add(back);

	}

	/**
	 * setMission() reads the mission files to the GUI and adds the
	 * images for both mission one and two.
	 * 
	 * @param newMission gets what mission user is on
	 */
	public void setMission(String newMission)
	{
		// get mission to execute
		this.missionFinal = newMission;

		// mission one code
		if (missionFinal.equals("one"))
		{
			clearTwo = true;

			// file reading for mission one
			File jugMission = new File("JuggerMission.txt");
			try
			{
				missionReader = new Scanner(jugMission);
			}
			catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (missionReader.hasNextLine())
			{

				mission = missionReader.nextLine();

				// setting text in text area
				missionDisplay
						.setText(missionDisplay.getText() + "\n" + mission);

			}
			// adding components to the main panel
			missionPanel.add(missionDisplay);
			missionPanel.add(jugLabel);
		}
		//Mission Two code
		if (missionFinal.equals("two"))
		{
			clearOne = true;
			// file reading for mission one
			File jugMission = new File("RedSkullMission.txt");
			try
			{
				missionReader = new Scanner(jugMission);
			}
			catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (missionReader.hasNextLine())
			{

				mission = missionReader.nextLine();

				// setting text in text area
				missionDisplay
						.setText(missionDisplay.getText() + "\n" + mission);

			}
			// adding components to the main panel
			missionPanel.add(missionDisplay);
			missionPanel.add(redLabel);

		}

	}

	/**
	 * setCheck() adds the option to validate the users selection.
	 */
	public void setCheck()
	{

		readChecks = new JButton(new AbstractAction("Lock Selection")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// action for user selection
				if (thorCheck.isSelected())
				{
					missionOne();
					missionTwo();

					thorChecked = true;
				}
				if (ironManCheck.isSelected())
				{
					missionOne();
					missionTwo();

					ironManChecked = true;
				}
				if (hulkCheck.isSelected())
				{
					missionOne();
					missionTwo();
					hulkChecked = true;
				}
				if (captainAmericaCheck.isSelected())
				{
					missionOne();
					missionTwo();

					captainAmericaChecked = true;
				}
			}

		});
		// adding component
		missionPanel.add(readChecks);

	}

	/**
	 * 
	 * @return the boolean for thor
	 */
	public boolean getThorCheck()
	{

		return thorChecked;

	}

	/**
	 * 
	 * @return the boolean for iron man
	 */
	public boolean getironManCheck()
	{
		return ironManChecked;
	}

	/**
	 * 
	 * @return the boolean for hulk
	 */
	public boolean getHulkCheck()
	{
		return hulkChecked;

	}

	/**
	 * 
	 * @return the boolean for captain america
	 */
	public boolean getCaptainAmericaCheck()
	{
		return captainAmericaChecked;
	}

	/**
	 * mission one checks for user pass
	 */
	public void missionOne()
	{
		if (getThorCheck() == true && getironManCheck() == true)
		{
			if (clearOne == true)
			{
				missionPanel.remove(jugLabel);
			}
			if (clearTwo == true)
			{
				missionPanel.remove(redLabel);

			}
			missionDisplay.setText("");
			jarvis.setVisible(true);
			setVisible(false);
			
		}

	}

	/**
	 * mission two checks for user pass
	 */
	public void missionTwo()
	{
		

		if (getCaptainAmericaCheck() == true && getHulkCheck() == true)
		{
			if (clearOne == true)
			{
				missionPanel.remove(jugLabel);
			}
			if (clearTwo == true)
			{
				missionPanel.remove(redLabel);

			}
			
			missionDisplay.setText("");
			jarvis.setVisible(true);
			setVisible(false);
			
		}
	}

}
