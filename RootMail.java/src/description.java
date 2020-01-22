import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.JSONObject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class description {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					description window = new description();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public description(int x) {
		initialize(x);
	}
	public description() {
		initialize(1);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int x) {
		frame = new JFrame();
		frame.setBounds(150, 120, 697, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(23, 32, 42  ));
		frame.setLocationRelativeTo(null);
		ArrayList<String> desc=new Data().array;
		System.out.println(desc);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 681, 295);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(desc.get(x));
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblNewLabel.setBounds(21, 11, 656, 201);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Download File");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back1 b=new back1(desc.get(x));
				b.start();
				
			}
		});
		btnNewButton.setBounds(49, 223, 152, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(489, 223, 152, 41);
		panel.add(btnNewButton_1);
		
	}
}
class back1 extends Thread
{
	InputStream inputStream=null;
	URL url=null;
	 String json="";
	 String desc="";
	 back1(String x)
	 {
		 desc=x;
	 }
	
	public void run()
	{
		try {
			url=new URL("http://127.0.0.1:8888/checkfile");
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
                student1.put("username",desc );
                writer.write(String.valueOf(student1));
                writer.close();
                
             if (httpURLConnection.getResponseCode() == 200) {
                 System.out.println("Getting proper response code");
                inputStream = httpURLConnection.getInputStream();
                 json = readFromStream(inputStream);
                 System.out.println(json);
                 if(json.equals("\r\n" + 
                   		"{\"File\":\"Not Present\"}"))
                   {
                  	 Mail obj=new Mail();
                  	 JOptionPane.showMessageDialog(obj.frame, "File Doesn't Exist.");
                   }
                 else
                 {
                	 
                	 String a=json.substring(17,json.length()-2);
System.out.println(a);
                	 InputStream in;
             		try {
             			in = new URL("http://127.0.0.1:8888/"+a).openStream();
             			Files.copy(in, Paths.get("FILES/"+a), StandardCopyOption.REPLACE_EXISTING);
             			 description c=new description();
             			 c.frame.setVisible(false);
             			 JOptionPane.showMessageDialog(c.frame, "File Downloaded.");
             		} catch (IOException e) {
             			// TODO Auto-generated catch block
             			e.printStackTrace();
             		}
                		
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

