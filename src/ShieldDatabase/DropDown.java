package ShieldDatabase;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DropDown extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Avenger avenger;
	private DisplayInfo displayInfo;
	private JPanel startPanel;
	private JComboBox dropDownMenu;
	private JButton select;
	private JButton mainMenu;
	public String index = "Thor";

	/**
	 * Constructor which constains all components for the GUI as well as
	 * the combo box.
	 * 
	 * @param instance for removing null pointer exception on setSuperPerson
	 */
	public DropDown(DisplayInfo instance)
	{
		super("Heroes and Villians");

		displayInfo = instance;

		// window size
		final int WINDOW_WIDTH = 400;
		final int WINDOW_HEIGHT = 100;

		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startPanel = new JPanel(new BorderLayout(5, 3));

		String[] heroVillianNames = { "Thor", "Captain America", "Hulk",
				"Iron Man" };
		dropDownMenu = new JComboBox(heroVillianNames);

		createPanel();

		addMain();
		add(startPanel);

	}

	/**
	 * createPanel() is used to add the select button and its use of
	 * selecting from the drop down menu,
	 * as well as placing the drop down menu JComboBox into the GUI.
	 */

	private void createPanel()
	{

		select = new JButton(new AbstractAction("select")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// takes selection made from drop down
				index = (String) dropDownMenu.getSelectedItem();
				try
				{
					// sends selection to avenger class
					avenger.setSuperPerson(index);

					// sends selection to displayInfo
					displayInfo.indexUpdater(index);
				}
				catch (IOException e1)
				{

					e1.printStackTrace();
				}
				displayInfo.setVisible(true);

			}

		});

		// adds all method components to the GUI
		startPanel.add(dropDownMenu, BorderLayout.EAST);

		startPanel.add(select, BorderLayout.CENTER);

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

				// closes the DropDown GUI
				setVisible(false);

			}

		});

		// adds main menu
		startPanel.add(mainMenu, BorderLayout.WEST);
	}

	/**
	 * satisfy the requirement for implementing action listener no use case
	 */

	public void actionPerformed(ActionEvent e)
	{
		// System.out.println(index);
	}

}
