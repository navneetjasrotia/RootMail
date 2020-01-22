import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import java.awt.Component;
import java.awt.Label;

public class my_panel extends JPanel implements ListCellRenderer<myList>{

	/**
	 * Create the panel.
	 */
	Label label_1 = new Label("");
	Label label_3 = new Label("");
	public my_panel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(220, 5, 10, 10);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 5, 430, 170);
		add(panel_1);
		panel_1.setLayout(null);
		
		Label label = new Label("From:-");
		label.setBounds(10, 22, 107, 39);
		panel_1.add(label);
		
	
		label_1.setBounds(74, 22, 346, 39);
		panel_1.add(label_1);
		
		Label label_2 = new Label("Title:-");
		label_2.setBounds(10, 90, 73, 49);
		panel_1.add(label_2);
		
	
		label_3.setBounds(74, 90, 346, 49);
		panel_1.add(label_3);

	}

	

	@Override
	public Component getListCellRendererComponent(JList<? extends myList> list, myList e, int index,
			boolean isSelected, boolean cellHasFocus) {
	
			label_1.setText(e.m);
			label_3.setText(e.t);
			System.out.println(e.m+"--"+e.t);
	return this;
	}
}
