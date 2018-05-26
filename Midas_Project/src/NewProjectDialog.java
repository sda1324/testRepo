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

public class NewProjectDialog extends JDialog {
	//Project project = new Project();

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the dialog.
	 */
	public NewProjectDialog(MainFrame mainframe) {
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
			JTextPane textPane2 = new JTextPane();
			textPane2.setText("Height :");
			contentPanel.add(textPane2);
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1);
			textField_1.setText("600");
			textField_1.setColumns(10);
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
						int height=Integer.parseInt(textField_1.getText());
						mainframe.project.setWidth(width);
						mainframe.project.setHeight(height);
						System.out.println(mainframe.panel_1.getWidth());
						mainframe.project.setBasic_x((mainframe.panel_1.getWidth()-width)/2);
						mainframe.project.setBasic_y((mainframe.panel_1.getHeight()-height)/2);
						mainframe.panel_1.drawOutline();
						
						Door door = new Door();

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
