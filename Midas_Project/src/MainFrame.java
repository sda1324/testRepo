import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import javafx.scene.image.Image;

public class MainFrame extends JFrame {

	private static MainFrame instance;

	public static MainFrame getInstance() {
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

		JButton btnNewButton = new JButton("New Project");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save Project");
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Open Project");

		panel.add(btnNewButton_2);

		table = new JTable();
		panel.add(table);

		panel_1 = new MyPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
	}

	class MyPanel extends JPanel {
		// ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		/*
		 * public void paintComponent(Graphics g) { super.paintComponent(g); Graphics2D
		 * g2 = (Graphics2D) g; for (Shape s : shapeArray) g2.draw(s);
		 * 
		 * }
		 */

		public void drawOutline() { // 가장자리 벽면 그리는 함수
			panel_1.setLayout(null);
			int x0 = project.basic_x;
			int x1 = project.basic_x + project.width;
			int y0 = project.basic_y;
			int y1 = project.basic_y + project.height;

			Room mainRoom = new Room();
			mainRoom.north = new Wall(x0, y0, x1, y0, 0, mainRoom);
			mainRoom.north.JPanelSize();
			mainRoom.north.addMouseListener(new MouseOverListener(mainRoom.north.panel));
			panel_1.add(mainRoom.north.panel);
			mainRoom.north.panel.setVisible(true);

			mainRoom.east = new Wall(x1, y0, x1, y1, 1, mainRoom);
			mainRoom.east.addMouseListener(new MouseOverListener(mainRoom.east.panel));
			mainRoom.east.JPanelSize();
			panel_1.add(mainRoom.east.panel);
			mainRoom.east.panel.setVisible(true);

			mainRoom.south = new Wall(x1, y1, x0, y1, 2, mainRoom);
			mainRoom.south.addMouseListener(new MouseOverListener(mainRoom.south.panel));
			mainRoom.south.JPanelSize();
			panel_1.add(mainRoom.south.panel);
			mainRoom.south.panel.setVisible(true);

			mainRoom.west = new Wall(x0, y1, x0, y0, 3, mainRoom);
			mainRoom.west.addMouseListener(new MouseOverListener(mainRoom.west.panel));
			mainRoom.west.JPanelSize();
			panel_1.add(mainRoom.west.panel);
			mainRoom.west.panel.setVisible(true);
			panel_1.revalidate();
			panel_1.repaint();
		}
	}
}
