import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.simple.JSONObject;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login implements Runnable{

	public JFrame frame;
	
	private JTextField textField;
	private final Action action = new SwingAction();
	private JPasswordField passwordField;
	final ImageIcon imageIcon = new ImageIcon("textbar.png");
	public String id="";
	static public String username="";
	static public int check=0;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	public Login() throws IOException{
		initialize();
	}
	public Login(int size)
	{
		
	}

	private void initialize() throws IOException {
		check=0;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBounds(250, 100, 891, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new  Color(33, 47, 61));
		panel.setBounds(0, 0, 441, 450);
		BufferedImage image = ImageIO.read(new File("mail.png"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		lblNewLabel.setBounds(33, 58, 378, 293);
		Border border = BorderFactory.createLineBorder(Color.black);
		lblNewLabel.setBorder(border);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new  Color(33, 47, 61));
		panel_1.setBounds(424, 0, 461, 450);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(40, 55, 71));
		panel_2.setBounds(10, 37, 427, 368);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 29));
		lblNewLabel_1.setBounds(165, 11, 158, 39);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Code");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(48, 48, 164, 29);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField()
				{
			   Image image = imageIcon.getImage();
		         {
		            setOpaque(false);
		         }
		         public void paintComponent (Graphics g) {
		            g.drawImage(image, 0, 0, this);
		            setForeground(new Color(255,255,255));
		            super.paintComponent(g);
		         }
				};
				textField.addKeyListener(new KeyAdapter() {
				    public void keyTyped(KeyEvent e) { 
				        if (textField.getText().length() >= 25 ) // limit textfield to 3 characters
				            e.consume(); 
				    }  
				});
		textField.setForeground(new Color(0,0,0));
		textField.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField.setBackground(null);
		textField.setBorder(null);
		textField.setBounds(48, 88, 336, 42);
		textField.setOpaque(false);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(48, 171, 107, 29);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String user=textField.getText().toString();
				String password=new String(passwordField.getPassword());
				if(user.equals("")||password.equals(""))
				JOptionPane.showMessageDialog(frame, "Please Fill The Empty Fields");
				else
				{
					username=user;
    background b1=new background(user,password);
     b1.start();
     if(check==1)
    	 frame.setVisible(false);
			}
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setBounds(277, 299, 107, 39);
		btnNewButton.setFocusPainted(false);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup obj=new signup();
				obj.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_1.setBounds(48, 299, 107, 39);
		btnNewButton_1.setFocusPainted(false);
		panel_2.add(btnNewButton_1);
		
		passwordField = new JPasswordField()
				{
			 Image image = imageIcon.getImage();
	         {
	            setOpaque(false);
	         }
	         public void paintComponent (Graphics g) {
	            g.drawImage(image, 0, 0, this);
	            setForeground(Color.WHITE);
	            super.paintComponent(g);
	         }
				};
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 20));
		passwordField.setBounds(48, 211, 334, 42);
		passwordField.setBorder(null);
		passwordField.setBackground(null);
		passwordField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (passwordField.getText().length() >= 25 ) // limit textfield to 3 characters
		            e.consume(); 
		    }  
		});
		panel_2.add(passwordField);
		
	}
	public void close_frame()
	{
		frame.setVisible(false);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Log In");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	@Override
	public void run() {
	
	}
}
class background extends Thread
{
	InputStream inputStream=null;
	URL url=null;
	 String json="";
	 String pass="",user="";
	 background()
	 {
		 
	 }
	 background(String u,String p)
	 {
		 user=u;
		 pass=p;
	 }
	public void run()
	{
		try {
			url=new URL("http://127.0.0.1:8888/login");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		HttpURLConnection httpURLConnection = null;
		try
		{
			 httpURLConnection = (HttpURLConnection) url.openConnection();
             httpURLConnection.setReadTimeout(10000);
             httpURLConnection.setRequestMethod("POST");
             httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
             httpURLConnection.setConnectTimeout(15000);
             httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
             httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.connect();
                OutputStreamWriter writer=new OutputStreamWriter(httpURLConnection.getOutputStream(),"UTF-8");
                JSONObject student1 = new JSONObject();
                student1.put("username", user);
                student1.put("password", pass);
                writer.write(String.valueOf(student1));
                writer.close();
                
             if (httpURLConnection.getResponseCode() == 200) {
                 System.out.println("Getting proper response code");
                inputStream = httpURLConnection.getInputStream();
                 json = readFromStream(inputStream);
                 System.out.println(json);
                 if(json.equals("{\"status\":true,\"message\":\"successfully authenticated\"}"))
                 {
                	 Mail obj=new Mail();
                	 obj.frame.setVisible(true);
                	 Login o=new Login();
                	 o.check=1;
                	 
                 }
                 else
                 {
                	 Login o=new Login();
                	 JOptionPane.showMessageDialog(o.frame, "Email Or Password Do Not Match");
                		
                 }
             } else
             {
                System.out.println("Error");
             }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		 finally {
             if (httpURLConnection != null) {
                 httpURLConnection.disconnect();
             }
             if (inputStream != null) {
                 try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
         }
	}
	private String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
}
