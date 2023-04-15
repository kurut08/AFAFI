package afafi;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class CharacterSelectionScreen extends JFrame 
{

	private JPanel contentPane;
	
	File characters;

	/**
	 * Create the frame.
	 */
	public CharacterSelectionScreen(String login) 
	{
		characters = new File("data/accounts/"+login+".txt");
		
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 704, 441);
		scrollPane.getViewport().setBackground(new Color(153, 217, 234));
		contentPane.add(scrollPane);
	}
}
