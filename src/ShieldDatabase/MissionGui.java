package ShieldDatabase;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MissionGui extends JFrame
{
	private static final long serialVersionUID = 1L;
	MissionDisplay missionVisible = new MissionDisplay();
	private JPanel missionGuiPanel;
	private JButton missionOne, missionTwo, mainMenu;
	String missionFinal = "no mission";
	


	/**
	 * The MissionGui() constructor holds all of the GUI settings
	 */
	public MissionGui()
	{
		// box title
		super("Mission Loadout");

		final int WINDOW_WIDTH = 500;
		final int WINDOW_HEIGHT = 500;

		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// close pop-up
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel implementation
		missionGuiPanel = new JPanel(new GridLayout(3, 1));

		missionDisplayPanel();
		addMain();
		add(missionGuiPanel);
		
	}

	/**
	 * missionDisplayPanel()
	 * creates the code for missionOne button
	 * creates the code for missionTwo button
	 * Adds all components to the main panel
	 */
	public void missionDisplayPanel()
	{

		missionOne = new JButton(new AbstractAction("Mission One")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				missionFinal = "one";

				// moving mission final to the MissionDisplay class method
				missionVisible.setMission(missionFinal);
			
				missionGuiPanel.remove(mainMenu);
				missionGuiPanel.remove(missionOne);
				missionGuiPanel.remove(missionTwo);
				setVisible(false);
				

				// setting the MissionDisplay GUI to appear
				missionVisible.setVisible(true);

			}

		});
		missionTwo = new JButton(new AbstractAction("Mission Two")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				missionFinal = "two";

				// moving mission final to the MissionDisplay class method
				missionVisible.setMission(missionFinal);
				missionGuiPanel.remove(mainMenu);
				missionGuiPanel.remove(missionOne);
				missionGuiPanel.remove(missionTwo);
				setVisible(false);

				// setting the MissionDisplay GUI to appear
				missionVisible.setVisible(true);

			}

		});

		// adding components to the GUI
		missionGuiPanel.add(missionOne);
		missionGuiPanel.add(missionTwo);

	}

	/**
	 * addMain() is to create the button use for Main Menu in the GUI.
	 */
	public void addMain()
	{
		mainMenu = new JButton(new AbstractAction("Main Menu")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				MainMenu menu = new MainMenu();

				// Makes MainMenu GUI visible
				menu.setVisible(true);
				missionGuiPanel.remove(mainMenu);
				missionGuiPanel.remove(missionOne);
				missionGuiPanel.remove(missionTwo);

				// closes the MissionGui GUI
				setVisible(false);

			}

		});

		// adds main menu
		missionGuiPanel.add(mainMenu);
	}

}
