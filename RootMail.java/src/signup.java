import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.json.simple.JSONObject;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.awt.event.ActionEvent;

public class signup {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JPasswordField passwordField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	public int j=0;
	public signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Georgia", Font.PLAIN, 25));
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee_Code");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(353, 87, 191, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 45));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(353, 11, 232, 72);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(32, 128, 181, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(658, 87, 122, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(353, 128, 181, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Company's Code");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(32, 189, 181, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(32, 237, 181, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(32, 309, 122, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		passwordField.setBounds(32, 357, 181, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(32, 83, 122, 38);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_3.setBounds(658, 131, 181, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("@company.com");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(211, 125, 132, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("State");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(353, 193, 111, 30);
		frame.getContentPane().add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.addItem("Himachal Pradesh");
		comboBox.addItem("Punjab");
		comboBox.addItem("Haryana");
		comboBox.addItem("Jammu and Kashmir");
		comboBox.addItem("Delhi");
		comboBox.addItem("Gujarat");
		comboBox.addItem("Rajasthan");
		comboBox.addItem("Goa");
		comboBox.addItem("Maharashtra");
		comboBox.addItem("Madhya Pradesh");
		comboBox.addItem("Uttar Pradesh");
		comboBox.addItem("Bihar");
		comboBox.addItem("Jharkhand");
		comboBox.addItem("Nagaland");
		comboBox.addItem("Assam");
		comboBox.addItem("West Bengal");
		comboBox.addItem("Arunachal Pradesh");
		comboBox.addItem("Tripura");
		comboBox.addItem("Mizoram");
		comboBox.addItem("Manipur");
		comboBox.addItem("Meghalaya");
		comboBox.addItem("Chattisgarh");
		comboBox.addItem("Odisha");
		comboBox.addItem("Telangana");
		comboBox.addItem("Andhra Pradesh");
		comboBox.addItem("Karnataka");
		comboBox.addItem("Tamil Nadu");
		comboBox.addItem("Kerela");
		comboBox.addItem("Uttrakhand");
		
		comboBox.setBounds(353, 240, 181, 25);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("Phone Number");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_8.setBounds(658, 201, 162, 30);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Confirm Password\r\n");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_9.setBounds(353, 308, 181, 33);
		frame.getContentPane().add(lblNewLabel_9);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField_1.setBounds(353, 357, 181, 30);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("Check\r\n");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(139, 87, 74, 28);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Post");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_10.setBounds(658, 309, 142, 30);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setBounds(658, 357, 181, 30);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  String email=textField.getText().toString();
			  String  emp_code=textField_1.getText().toString();
			  String name=textField_3.getText().toString();
			  String comp_code=textField_2.getText().toString();
			  String number=textField_5.getText().toString();
			  String state=(String) comboBox.getSelectedItem();
			  String password=new String(passwordField.getPassword());
			  String cpassword=new String(passwordField_1.getPassword());
			  String post=textField_4.getText().toString();
			  if(email.equals("")||post.equals("")||password.equals("")||state.equals("")||comp_code.equals("")||name.equals("")||emp_code.equals("")||number.equals(""))
			  {
					JOptionPane.showMessageDialog(frame, "Please Fill The Empty Fields");
			  }
			  else
			  {
				  if(password.equals(cpassword))
				  {
					  if(comp_code.equals("0110"))
					  {
					  background_signup obj=new background_signup(email,emp_code,name,comp_code,state,number,password,post) ;
					  obj.start();
					  frame.setVisible(false);
					  }
					  else
						  JOptionPane.showMessageDialog(frame, "Company's Code Don't Match");
				  }
				  else if(password.length()<8)
				  {
					  JOptionPane.showMessageDialog(frame, "Password Length Too Short");
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(frame, "Password Don't Match");
				  }
			  }
			  
			}});
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 33));
		btnNewButton_1.setBounds(311, 423, 232, 64);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_5.setBounds(658, 242, 181, 25);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		frame.setBounds(100, 100, 894, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
class background_signup extends Thread
{
	InputStream inputStream=null;
	URL url=null;
	 String json="";
	 String password="",name="",email="",post="";
	 String compcode="",number="",state="",empcode="";
	 background_signup(String e,String ec,String n,String cc,String st,String nb,String pass,String po)
	 {
		 email=e;
		 empcode=ec;
		 name=n;
		 compcode=cc;
		 state=st;
		 number=nb;
		 password=pass;
		 
		 post=po;
	 }
	public void run()
	{
		try {
			url=new URL("http://127.0.0.1:8888/signup");
		} 
		catch (MalformedURLException e1) {
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
                student1.put("name", name);
                student1.put("password", password);
                student1.put("email", email);
                student1.put("post", post);
                student1.put("state", state);
                student1.put("empcode", empcode);
                student1.put("compcode", compcode);
                student1.put("phone", number);
                
                writer.write(String.valueOf(student1));
                writer.close();
                
             if (httpURLConnection.getResponseCode() == 200) {
                 System.out.println("Getting proper response code");
                 inputStream = httpURLConnection.getInputStream();
                 json = readFromStream(inputStream);
                if(json.equals("{\"a\":\"1\"}"))
        		{
        	Login j=new Login();
        	j.frame.setVisible(true);
        	
        		}
        else
        {
        	System.out.println("Data not properly inserted");
        }
               
             }
             else
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

