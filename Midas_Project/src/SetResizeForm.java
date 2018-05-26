import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class SetResizeForm extends JDialog {
	//Project project = new Project();

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the dialog.
	 */
	public SetResizeForm(Object object, int o_int) {
		setBounds(500, 350, 200, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JTextPane textPane = new JTextPane();
			textPane.setText("Width :");
			contentPanel.add(textPane);
		}
		{
			textField = new JTextField();
			textField.setText("400");
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int width=Integer.parseInt(textField.getText());
						//int height=Integer.parseInt(textField_1.getText());

						//여기다가 추가해야함
						
						if(o_int == 0)
						{
							Window w = (Window) object;
							w.SetResizeJPanel(width);
						}
						else if(o_int == 1)
						{
							Door d = (Door)object;
							d.SetResizeJPanel(width);
						}
						//mainframe.panel_1.drawDoor(door);
						
			            dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
			            dispose();
					}
				});

	            setModal(false);
	            this.dispose();
			}
		}
	}
	
	
}
