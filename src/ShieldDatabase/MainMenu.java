package ShieldDatabase;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JFrame
{
	private static final long serialVersionUID = 1L;
	DisplayInfo displayInfo = new DisplayInfo();
	private DropDown dropDown = new DropDown(displayInfo);
	private MissionGui missionGui = new MissionGui();
	private JButton selection;
	private JButton missions;

	private JPanel startPanel;

	/**
	 * Constructor for MainMenu class which contains the sizing and GUI panel
	 * for the main menu of the project.
	 */
	public MainMenu()
	{
		// box title
		super("SHIELD main menu");

		final int WINDOW_WIDTH = 300;
		final int WINDOW_HEIGHT = 100;

		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// close pop-up
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel implementation
		startPanel = new JPanel(new GridLayout(3, 1));
		displayPanel();
		add(startPanel);

	}

	/**
	 * displayPanel() holds the button selection menu which will take you to
	 * the DropDown class's GUI.
	 * 
	 * Mission Menu button is also displayed which will take you to the
	 * MissionGUI
	 * class's GUI.
	 */
	public void displayPanel()
	{
		selection = new JButton(new AbstractAction("Selection Menu")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// remove this GUI
				setVisible(false);

				// redirect to the new GUI
				dropDown.setVisible(true);

			}

		});
		missions = new JButton(new AbstractAction("Mission Menu")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// remove this GUI
				setVisible(false);

				// redirect to the new GUI
				missionGui.setVisible(true);

			}

		});

		// add to panel
		startPanel.add(selection);
		startPanel.add(missions);

	}

}
