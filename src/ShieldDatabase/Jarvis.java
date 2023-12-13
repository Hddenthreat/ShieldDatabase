package ShieldDatabase;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Jarvis extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel startPanel;
	private JLabel jarvisLabel;
	private JButton exit, mainMenu;
	private JTextArea winner = new JTextArea();
	

	/**
	 * Jarvis() is the constructor which holds all of the GUI settings and
	 * the jarvis Image.
	 */
	public Jarvis()
	{
		// box title
		super("Winner Winner Chicken Dinner");

		final int WINDOW_WIDTH = 500;
		final int WINDOW_HEIGHT = 500;

		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// close pop-up
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Jarvis image sizing
		ImageIcon jarvisImage = new ImageIcon("jarvis1.jpg");
		Image jarvImage = jarvisImage.getImage();
		Image newJugImage = jarvImage.getScaledInstance(500, 500,
				Image.SCALE_DEFAULT);
		jarvisImage = new ImageIcon(newJugImage);
		jarvisLabel = new JLabel(jarvisImage);

		// panel implementation
		startPanel = new JPanel(new GridLayout(3, 1));
		winnerPanel();
		add(startPanel);

	}

	/**
	 * winnerPanel() adds the exit button for closing the progran upon
	 * completion
	 * it also has the main menu button for returning to the menu.
	 */
	public void winnerPanel()
	{
	

		// end program button
		exit = new JButton(new AbstractAction("Exit")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// ends program
				System.exit(0);

			}

		});

		// return to main menu button
		mainMenu = new JButton(new AbstractAction("Main Menu")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{

				MainMenu menu = new MainMenu();

				// open MainMenu class GUI
				menu.setVisible(true);

				// close the Jarvis GUI
				setVisible(false);

			}

		});

		winner.setText("Mission Completed");

		// add all components to the GUI
		startPanel.add(winner);
		startPanel.add(jarvisLabel);
		startPanel.add(mainMenu);
		startPanel.add(exit);
		

	}
}
