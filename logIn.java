import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;


public class logIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
   private JMenuBar menuBar;
	private JMenu function;
	private JMenuItem help,about,quit, REFRESH_INTERVAL_item;
	private JDesktopPane desktop;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn frame = new logIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public logIn() {
		

	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		
		
		//creating the GUI
			contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setSize(1200,700);
		 
		 BufferedImage myImage;
			try {
				myImage = ImageIO.read(new File("/Users/ZethaRia/Desktop/pc/ice3.jpg"));
				this.new ImagePanel(myImage).setOpaque(false);
				this.setContentPane(this.new ImagePanel(myImage));
				
				
				
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		 
		 menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			
			 function = new JMenu("File");
			menuBar.add(function);
			
			JMenuItem quit = new JMenuItem("Exit");
			function.add(quit);
			
			JMenuItem REFRESH_INTERVAL_item = new JMenuItem("Refresh Interval");
			function.add(REFRESH_INTERVAL_item);
			
			JMenu about = new JMenu("About");
			menuBar.add(about);
			
			JMenu help = new JMenu("Help (F1)");
			menuBar.add(help);
			
		
		JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 49, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 240, SpringLayout.WEST, contentPane);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox, -19, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 95, SpringLayout.NORTH, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -10, SpringLayout.EAST, contentPane);
		contentPane.add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLogIn, 23, SpringLayout.SOUTH, passwordField);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLogIn, 240, SpringLayout.WEST, contentPane);
		contentPane.add(btnLogIn);
		
		JLabel lblCharacterSelection = new JLabel("Character Selection :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCharacterSelection, 4, SpringLayout.NORTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCharacterSelection, -8, SpringLayout.WEST, comboBox);
		contentPane.add(lblCharacterSelection);
		
		JLabel lblUsername = new JLabel("Username :");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 27, SpringLayout.EAST, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsername, 101, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblUsername, -222, SpringLayout.EAST, contentPane);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, -6, SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 27, SpringLayout.EAST, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 32, SpringLayout.SOUTH, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblUsername);
		contentPane.add(lblPassword);
		
		
	}
	
	

	class ImagePanel extends JComponent{

	    private Image image;
	    public ImagePanel(Image image){
	    this.image = image;
	    }
	   
	 public void paintComponent(Graphics g){
	    g.drawImage(image, 0, 0, null);
	}
	    }
	
	
	
	private void addListener() {

		//quitting the program
		quit.addActionListener(new MyHandler());
		help.addActionListener(new MyHandler());
		about.addActionListener(new MyHandler());
		REFRESH_INTERVAL_item.addActionListener(new MyHandler());

	}

class MyHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() ==quit){
				System.exit(0);
			}

			if(e.getSource()== about){
				JDialog aboutDialog = new JDialog();
				aboutDialog.setBounds(10,10,300,300);
				aboutDialog.setVisible(true);
			}

			if(e.getSource()== help){
				JDialog helpDialog = new JDialog();	
				helpDialog.setBounds(10,10,300,300);
				helpDialog.setModal(true);
				helpDialog.setLocationRelativeTo(null);
				helpDialog.setVisible(true);
				}

			if(e.getSource()== REFRESH_INTERVAL_item){
				// Open an internal frame when the item is selected :
				JInternalFrame RIframe = new JInternalFrame();	
				RIframe.setBounds(10,10,300,300);
				JPanel panel= (JPanel) RIframe.getContentPane();

				// In the frame, we can select the refresh interval via a combo box : 
				JTextArea text = new JTextArea("Select the refresh interval of the ICE World :"); 
				DefaultComboBoxModel mdc = new DefaultComboBoxModel(); 
				final JComboBox combo = new JComboBox();
				combo.setModel(mdc);
				combo.setBounds(new Rectangle(19, 36, 129, 23)); 

				for(int i=1; i<=10; i++){
				mdc.addElement(""+i); 
				combo.addItem(""+i); 	// adding the elements of the combo			
				}	

				combo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int new_value= (Integer) combo.getSelectedItem();
						StateFetching.setREFRESH_INTERVAL(new_value);
					}
				});


				panel.add(text, BorderLayout.CENTER);
				panel.add(combo, BorderLayout.CENTER);
				RIframe.setVisible(true);
			}	
		}




}
}
