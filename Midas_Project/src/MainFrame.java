import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static MainFrame instance;

	public static MainFrame getInstance() {
		return instance;
	}

	private JPanel contentPane;
	MyPanel panel_1;
	Project project = new Project();

	private char cmd = 'N';
	ImageIcon originIcon;
	Image originImg;
	Image changedImg;
	ImageIcon icon;
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

		
		Panel panel_2 = new Panel();
		panel.add("south",panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		originIcon = new ImageIcon("src/icon/tv.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH );
		icon = new ImageIcon(changedImg);
		JButton btn_tv = new JButton(icon);
		btn_tv.setName("tv");
		btn_tv.addActionListener(new MyListener());
		panel_2.add(btn_tv);
		
		originIcon = new ImageIcon("src/icon/washing_machine.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(100, 120, Image.SCALE_SMOOTH );
		icon = new ImageIcon(changedImg);
		JButton btn_wm = new JButton(icon);
		btn_wm.setName("washing machine");
		btn_wm.addActionListener(new MyListener());
		panel_2.add(btn_wm);
		
		originIcon = new ImageIcon("src/icon/chair.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH );
		icon = new ImageIcon(changedImg);
		JButton btn_chair = new JButton(icon);
		btn_chair.setName("chair");
		btn_chair.addActionListener(new MyListener());
		panel_2.add(btn_chair);
		
		originIcon = new ImageIcon("src/icon/refrigerator.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH );
		icon = new ImageIcon(changedImg);
		JButton btn_ref = new JButton(icon);
		btn_ref.setName("refrigerator");
		btn_ref.addActionListener(new MyListener());
		panel_2.add(btn_ref);
		
		originIcon = new ImageIcon("src/icon/sofa.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH );
		icon = new ImageIcon(changedImg);
		JButton btn_sofa = new JButton(icon);
		btn_sofa.setName("sofa");
		btn_sofa.addActionListener(new MyListener());
		panel_2.add(btn_sofa);
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

		
		panel_1 = new MyPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
	}

	class MyPanel extends JPanel {

		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		

		public void drawOutline() { // 가장자리 벽면 그리는 함수
			panel_1.setLayout(null);
			int x0 = project.basic_x;
			int x1 = project.basic_x + project.width;
			int y0 = project.basic_y;
			int y1 = project.basic_y + project.height;
			Shape s = new Rectangle2D.Float(project.basic_x, project.basic_y, project.width, project.height);
			
			shapeArray.clear();
			shapeArray.add(s);
			
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
			
			mainRoom.SetDefaultDoor(x0, y0, x1, y1);
			for(Door d : mainRoom.GetDoorList())
			{
				panel_1.add(d.panel);
				d.panel.setVisible(true);
			}

			panel_1.revalidate();
			panel_1.repaint();
		}
	}
	
	private class MyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getName()=="tv") {
				cmd = 'T';// tv
			} else if (b.getName()=="washing machine") {
				cmd = 'W';// washing machine
			} else if (b.getName()=="chair") {
				cmd = 'C';// chair
			} else if (b.getName()=="refrigerator") {
				cmd = 'R';// refrigerator
				System.out.println("TT");
			} else if (b.getName()=="sofa") {
				cmd = 'S';// sofa
				System.out.println("T");
			}
		}

	}
}
