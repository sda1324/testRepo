import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static MainFrame instance;
	public static MainFrame getInstance()
	{
		return instance;
	}
	private JPanel contentPane;
	private JTable table;
	MyPanel panel_1;
	Project project = new Project();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
					instance = frame;
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		NewProjectDialog dialog = new NewProjectDialog(this);
		JButton btnNewButton = new JButton("�깉 �봽濡쒖젥�듃");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�봽濡쒖젥�듃 ���옣");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("�봽濡쒖젥�듃 遺덈윭�삤湲�");
		panel.add(btnNewButton_2);
		
		table = new JTable();
		panel.add(table);
		
		panel_1 = new MyPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
	}
	
	class MyPanel extends JPanel {
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Shape s : shapeArray)
			g2.draw(s);
	}
	
	public void drawOutline() { //媛��옣�옄由� 踰쎈㈃ 洹몃━�뒗 �븿�닔
		Shape s = new Rectangle2D.Float(project.basic_x, project.basic_y, project.width, project.height);
		shapeArray.clear();
		shapeArray.add(s);
		repaint();
	}
}
}


