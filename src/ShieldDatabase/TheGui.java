package ShieldDatabase;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TheGui extends JFrame implements ActionListener
{
	// DisplayInfo displayInfo = new DisplayInfo();
	// DropDown dropDown = new DropDown(displayInfo);
	MainMenu mainMenu = new MainMenu();
	private JPanel startPanel;
	private JButton login;
	private JButton CreateUser;
	private JLabel username, password;
	private JTextField user, pass;
	private String enteredUser, enteredPass;
	Hashtable<String, String> userList = new Hashtable<String, String>();
	ActionListener newUser, correct;

	public TheGui()
	{
		// box title
		super("Login Page");

		final int WINDOW_WIDTH = 300;
		final int WINDOW_HEIGHT = 100;

		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// close pop-up
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel implementation
		startPanel = new JPanel(new GridLayout(3, 2));
		createPanel();
		add(startPanel);

		// display the window
		setVisible(true);

	}

	private void createPanel()
	{
		// Setting buttons,labels,and fields
		username = new JLabel("Username");
		user = new JTextField(15);
		password = new JLabel("Password");
		pass = new JTextField(enteredPass);
		// set action event for create new user
		CreateUser = new JButton(new AbstractAction("Create new user")
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				enteredUser = user.getText();
				enteredPass = pass.getText();

				userList.put(enteredUser, enteredPass);

			}

		});
		// set action event for login button
		login = new JButton(new AbstractAction("Login")
		{

			@Override
			public void actionPerformed(ActionEvent e)

			{

				enteredUser = user.getText();
				enteredPass = pass.getText();

				if (userList.containsKey(enteredUser))
				{
					startPanel.remove(username);
					startPanel.remove(password);
					startPanel.remove(user);
					startPanel.remove(pass);

					setVisible(false);
					mainMenu.setVisible(true);

				}

			}

		});

		startPanel.add(username);
		startPanel.add(user);
		startPanel.add(password);
		startPanel.add(pass);
		startPanel.add(login);
		startPanel.add(CreateUser);
		add(startPanel, BorderLayout.CENTER);

		login.addActionListener(this);
		CreateUser.addActionListener(newUser);

	}

	public static void main(String[] args)
	{
		TheGui GUI = new TheGui();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}
}
