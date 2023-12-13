package ShieldDatabase;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DisplayInfo extends JFrame
{
	private static final long serialVersionUID = 1L;
	private boolean clearThor, clearIronMan, clearCaptainAmerica, clearHulk;
	private String newOrigin;
	private JLabel thorLabel, ironManLabel, captainAmericaLabel, hulkLabel;
	private SuperPeople supes;
	private JPanel startPanel;
	private JTextArea readingOrigin = new JTextArea();
	private JButton back;
	String superPerson;

	/**
	 * Display info Constructor contains all GUI sizing and implementation
	 * it also holds all images for the heroes and initializes them.
	 */
	public DisplayInfo()
	{

		// box title
		super("SuperPeople Info");
		final int WINDOW_WIDTH = 600;
		final int WINDOW_HEIGHT = 400;

		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// close pop-up
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// thor image sizing
		ImageIcon thor = new ImageIcon("ThorImage.jpg");
		Image thorImage = thor.getImage();
		Image newThorImage = thorImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		thor = new ImageIcon(newThorImage);
		thorLabel = new JLabel(thor);

		// iron man image sizing
		ImageIcon ironMan = new ImageIcon("download2.jpeg");
		Image ironImage = ironMan.getImage();
		Image newIronImage = ironImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		ironMan = new ImageIcon(newIronImage);
		ironManLabel = new JLabel(ironMan);

		// hulk image
		ImageIcon hulk = new ImageIcon("hulkImage.jpeg");
		Image hulkImage = hulk.getImage();
		Image newHulkImage = hulkImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		hulk = new ImageIcon(newHulkImage);
		hulkLabel = new JLabel(hulk);

		// captain america image sizing
		ImageIcon captainAmerica = new ImageIcon("CaptainAmericaImage.jpeg");
		Image captainImage = captainAmerica.getImage();
		Image newCaptainImage = captainImage.getScaledInstance(200, 200,
				Image.SCALE_DEFAULT);
		captainAmerica = new ImageIcon(newCaptainImage);
		captainAmericaLabel = new JLabel(captainAmerica);
		// panel implementation
		startPanel = new JPanel(new FlowLayout());
		backButton();

		add(startPanel);

	}

	/**
	 * indexUpdater() contains all the file reading for heroes and adding their
	 * images or any other components to the GUI
	 * 
	 * @param newIndex newIndex is the variable used to put the index into
	 *                 superPerson
	 * @throws IOException IO exception is for the Scanner file reading
	 */
	public void indexUpdater(String newIndex) throws IOException
	{
		// index for drop down selection
		superPerson = newIndex;

		// file, superPerson object, and scanner declaration
		File origin;
		supes = new Avenger();
		origin = supes.getOrigin();
		Scanner readOrigin = new Scanner(origin);

		// while loop to read the file
		while (readOrigin.hasNextLine())
		{

			newOrigin = readOrigin.nextLine();

			readingOrigin.setText(readingOrigin.getText() + "\n" + newOrigin);

		}
		readOrigin.close();

		// setting the textArea to add the hero location after file reading
		readingOrigin.setText(
				readingOrigin.getText() + "\n\n" + supes.getLocation());

		// adding each heroes image
		if (superPerson.equals("Thor"))
		{
			clearThor = true;
			startPanel.add(thorLabel, FlowLayout.LEFT);
		}
		if ("Iron Man".equals(superPerson))
		{
			clearIronMan = true;
			startPanel.add(ironManLabel, FlowLayout.LEFT);

		}
		if ("Hulk".equals(superPerson))
		{
			clearHulk = true;
			startPanel.add(hulkLabel, FlowLayout.LEFT);

		}
		if ("Captain America".equals(superPerson))
		{
			clearCaptainAmerica = true;
			startPanel.add(captainAmericaLabel, FlowLayout.LEFT);

		}

		// adding the textArea if not null to avoid exception
		if (readingOrigin != null)
		{
			System.out.println("Success");

			startPanel.add(readingOrigin, FlowLayout.CENTER);
		}

	}

	/**
	 * backButton() adds the back functionality to return to the selection
	 * drop down.
	 */
	public void backButton()
	{
		back = new JButton(new AbstractAction("Back")
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// removing GUI components
				if (clearThor == true)
				{
					startPanel.remove(thorLabel);
				}
				if (clearHulk == true)
				{
					startPanel.remove(hulkLabel);

				}
				if (clearCaptainAmerica == true)
				{
					startPanel.remove(captainAmericaLabel);

				}
				if (clearIronMan == true)
				{
					startPanel.remove(ironManLabel);

				}
				readingOrigin.setText("");
				// removing GUI visibility
				setVisible(false);
			}

		});
		// adding button to panel
		startPanel.add(back);

	}

	public static void main(String[] args)
	{

	}
}
