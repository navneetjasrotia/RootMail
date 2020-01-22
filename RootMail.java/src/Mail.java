import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
public class Mail 
{
	DefaultListModel dlm;
	static public JList<myList> list=new JList<myList>();
	public JFrame frame;
	private JTextField textField;
	static int i=0;
	
	static int count =0;
    
	/*public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try {
					Mail window = new Mail();
					window.frame.setVisible(true);
					window.first_function();
					i=0;
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}*/
	public Mail() {
		initialize();
		first_function();
	}
	public Mail(ArrayList a,ArrayList b)
	{
		dlm=new DefaultListModel();
		
		for(int i=0;i<b.size();i++)
		{	
			String biz=(String)b.get(i);
		dlm.addElement("From:-  "+a.get(i)+"         "+"Title:-  "+biz.substring(1,biz.length()-1));
		}
		System.out.println(a.size());
		list.setModel(dlm);
	}
	public void mouseEntered(MouseEvent e) {
	    JPanel parent = (JPanel)e.getSource();
	    Border grayBorder = null;
		parent.setBorder(grayBorder);
	    parent.revalidate();
	}
	private void initialize() {
		signup obj=new signup();
		obj.j=9;
		System.out.println(obj.j);
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(23, 32, 42  ));
		frame.setBounds(100, 100, 976, 673);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 55, 70));
		panel.setBounds(0, 0, 206, 634);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(44, 62, 80));
		panel_1.setBounds(10, 34, 186, 75);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("SENT");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		btnNewButton.setBounds(0, 204, 206, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("INBOX");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		btnNewButton_1.setBounds(0, 138, 206, 41);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				first_function();
			}
		});
		
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SAVED");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(0, 266, 206, 41);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("TRASH");
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		btnNewButton_3.setBounds(0, 328, 206, 41);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("COMPOSE");
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setForeground(new Color(255, 0, 0));
		btnNewButton_4.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		btnNewButton_4.setBounds(0, 395, 206, 41);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sent_window o=new sent_window();
				o.frame.setVisible(true);			}
		});
		panel.add(btnNewButton_4);
		list.setVisibleRowCount(15);
		list.setToolTipText("");
		list.setFont(new Font("Georgia", Font.PLAIN, 20));
		list.setCellRenderer(getRenderer());
		list.setLayout(null);
		list.setBackground(new Color(23, 32, 42));
        list.setFixedCellHeight(100);
        list.setBorder(BorderFactory.createTitledBorder(""));
        list.setBackground(new Color(214, 219, 223  ));
         list.addListSelectionListener(new ListSelectionListener()
        {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			count++;
			if(count%2==1) {
	System.out.println(list.getSelectedIndex());
	Object o=list.getSelectedValue();
	String s=(String)o;
	String s1=s.substring(8,20).trim();
	String s2=s.substring(36,s.length()-1).trim();
	System.out.println(s1+"--"+s2);
	System.out.println();
	
	description c=new description(list.getSelectedIndex());
	c.frame.setVisible(true);
			}
		}
        });
        /////////////////////////////////
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(216, 208, 744, 426);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		scrollPane.setRowHeaderView(panel_5);
		panel_5.setLayout(null);
		
		textField = new RoundJTextField(15);
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Georgia", Font.PLAIN, 22));
		textField.setBounds(216, 11, 676, 45);
		textField.setBackground(new Color(224, 255, 255));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("  Search/Filter");
		
		JButton btnNewButton_5 = new JButton("Refresh");
		btnNewButton_5.setBackground(new Color(0, 0, 205));
		btnNewButton_5.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnNewButton_5.setBounds(216, 167, 138, 30);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				first_function();
			}
		});
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete All");
		btnNewButton_6.setBackground(new Color(0, 0, 205));
		btnNewButton_6.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnNewButton_6.setBounds(522, 167, 138, 30);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Saved All");
		btnNewButton_7.setForeground(new Color(0, 0, 0));
		btnNewButton_7.setBackground(new Color(0, 0, 205));
		btnNewButton_7.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnNewButton_7.setBounds(827, 167, 123, 30);
		frame.getContentPane().add(btnNewButton_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(26, 188, 156  ));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(40,55,71));
			}
		});
		panel_2.setBackground(UIManager.getColor("Button.focus"));
		panel_2.setBounds(215, 67, 245, 89);
		panel_2.setBackground(new Color(40,55,71));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Urgent To Reply");
		lblNewLabel.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(10, 11, 235, 67);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(26, 188, 156  ));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(40,55,71));
			}
		});
		panel_3.setBounds(466, 67, 245, 89);
	   panel_3.setBackground(new Color(40,55,71));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Only To Read");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel_1.setBounds(27, 11, 208, 67);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(26, 188, 156  ));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(40,55,71));
			}
		});
		panel_4.setBackground(new Color(40,55,71));
		panel_4.setBounds(717, 67, 243, 89);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(114, 5, 0, 0);
		panel_4.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("File Away");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel_2.setBounds(42, 11, 164, 67);
		panel_4.add(lblNewLabel_2);
		 textField.addFocusListener(new FocusListener() {

	            @Override
	            public void focusGained(FocusEvent e) {
	                textField.setText("  ");
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	               textField.setText("  Search/Filter");
	            
	            }
	           
	        });
		 
		
	}
	private DefaultListCellRenderer getRenderer()
	{
        return new DefaultListCellRenderer()
        {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) 
            {
                JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
                listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
             
                return listCellRendererComponent;
            }
        };
    }
	public void first_function()
	{
		back obj=new back();
		obj.start();
		
	}
	
	
}
class RoundJTextField extends JTextField
{
    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false);
    }
    protected void paintComponent(Graphics g)
    {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g)
    {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
    }
    public boolean contains(int x, int y) 
    {
         if (shape == null || !shape.getBounds().equals(getBounds())) 
         {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         }
         return shape.contains(x, y);
    }
    
    
}
class back extends Thread
{
	InputStream inputStream=null;
	URL url=null;
	 String json="";
	 String own_code="";
	back()
	 {
		
	 }
	public void run()
	{
		try {
			url=new URL("http://127.0.0.1:8888/mail");
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
                writer.write(String.valueOf(student1));
                writer.close();
                
             if (httpURLConnection.getResponseCode() == 200) {
                 System.out.println("Getting proper responsecode");
                 inputStream = httpURLConnection.getInputStream();
                 json = readFromStream(inputStream);
                readJSON(json);            
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
	private void readJSON(String json2) {
		String[] a=json2.split("-");
		ArrayList<String> mail_id=new ArrayList<String>();
		ArrayList<String> title=new ArrayList<String>();
		ArrayList<String> description=new ArrayList<String>();
		for(int i=0;i<a.length;i++)
		{
			if(i==0)
			{
				String[] m=a[i].split(":");
			   for(int j=0;j<m.length;j++)
			   {
				   mail_id.add(m[j]);
			   }
			}
			else if(i==1)
			{
				String[] m=a[i].split(":");
			   for(int j=0;j<m.length;j++)
			   {
				   title.add(m[j]);
			   }
			}
			else
			{
				String[] m=a[i].split(":");
			   for(int j=0;j<m.length;j++)
			   {
				   description.add(m[j]);
			   }
			}
			new Data(description);
		}
		Mail o=new Mail(mail_id,title);
		mail_id.clear();
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




