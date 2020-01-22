

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.json.simple.JSONObject;



import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JRadioButton;
import java.awt.Label;

public class sent_window {

	public JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public String own_id="";
	static public int sent_check=0;
	public sent_window() {
		initialize();
	}

	private void initialize() {
		JTextPane textPane = new JTextPane();
		JTextArea textArea = new JTextArea();
		ButtonGroup bg=new ButtonGroup();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().setBackground(new Color(23,32,42));
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setLocationRelativeTo(null);
		frame.setBounds(450, 190, 565, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(113, 11, 436, 31);
		 textField.addFocusListener(new FocusListener() {

	            @Override
	            public void focusGained(FocusEvent e) {
	            
	            }
	            @Override
	            public void focusLost(FocusEvent e) {
	          
	            }
	        });
		

		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Send With File");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 314, 167, 27);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				  String charset = "UTF-8";
				String e_code=textField.getText().toString();
				String Sub=textPane.getText().toString();
				String desc=textArea.getText().toString();
				
				if(e_code.equals("")||Sub.equals("")||desc.equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Fill Empty Fields");
				}
				else
				{
				try
				{
					String option=bg.getSelection().getActionCommand();
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("."));
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.showOpenDialog(null);
				File selectedPfile = chooser.getSelectedFile();
				System.out.println(selectedPfile.getPath());
				String requestURL="http://127.0.0.1:8888/send";
				
			            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
			            multipart.addHeaderField("User-Agent", "CodeJava");
			            Login o=new Login();
		                String own_code=o.username;
		                multipart.addFormField("own_code", own_code);
		                multipart.addFormField("e_code", e_code);
		                multipart.addFormField("subject",Sub);
		                multipart.addFormField("desc", desc);
		                multipart.addFormField("radio",option);
			            multipart.addFilePart("fileUpload", selectedPfile);
			            List<String> response = multipart.finish();
			             
			            System.out.println("SERVER REPLIED:");
			             
			            for (String line : response) {
			                System.out.println(line);
			            }
						
				}
				catch(Exception es)
				{
					System.out.println(es.getMessage());
				}
			}
				frame.setVisible(false);
				JOptionPane.showMessageDialog(frame, "Email Send Successfully");
			}
			
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send Without File");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String e_code=textField.getText().toString();
				String Sub=textPane.getText().toString();
				String desc=textArea.getText().toString();
				
				if(e_code.equals("")||Sub.equals("")||desc.equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Fill Empty Fields");
				}
				else
				{
					String option=bg.getSelection().getActionCommand();
					background_sign obj=new background_sign(e_code,Sub,desc,option);
					obj.start();
					try {
						obj.join();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(sent_check==1)
						frame.setVisible(false);
					
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(372, 314, 167, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textArea.setBounds(10, 95, 539, 172);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPane.setBounds(113, 53, 436, 31);
		frame.getContentPane().add(textPane);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Urgent To Reply");
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setActionCommand("Reply");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBackground(new Color(23,32,42));
		rdbtnNewRadioButton.setBounds(10, 274, 138, 33);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Only To Read");
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setActionCommand("Read");
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(214, 274, 138, 33);
		rdbtnNewRadioButton_1.setBackground(new Color(23,32,42));
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("File Away");
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_2.setActionCommand("File");
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(431, 274, 112, 33);
		rdbtnNewRadioButton_2.setBackground(new Color(23,32,42));
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton);
		
		Label label = new Label("Emp_Code");
		label.setBounds(10, 11, 103, 31);
		label.setForeground(Color.white);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Subject");
		label_1.setBounds(10, 53, 97, 31);
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.getContentPane().add(label_1);
	}
}

class background_sign extends Thread
{
	InputStream inputStream=null;
	URL url=null;
	 String json="";
	 String emp="",tit="",desc="",rad="",own_code;
	background_sign(String e,String ec,String n,String radio)
	 {
		emp=e;
		tit=ec;
		desc=n;
		rad=radio;
	 }
	public void run()
	{
		try {
			url=new URL("http://127.0.0.1:8888/send");
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
                Login o=new Login();
                own_code=o.username;
                student1.put("own_code", own_code);
                student1.put("e_code", emp);
                student1.put("subject", tit);
                student1.put("desc", desc);
                student1.put("radio", rad);
                writer.write(String.valueOf(student1));
                writer.close();
                
             if (httpURLConnection.getResponseCode() == 200) {
                 System.out.println("Getting proper response code");
                 inputStream = httpURLConnection.getInputStream();
                 json = readFromStream(inputStream);
                 System.out.println(json);
                 if(json.equals("{\"Inserted\":\"ok\"}"))
                 {
                	sent_window obj=new sent_window();
                	obj.sent_check=1;
               
                 }
                 else
                 {
                	 
                	 JOptionPane.showMessageDialog(o.frame, "Error In Sending Mail");
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

