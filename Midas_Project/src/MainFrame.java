import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	Furniture f_tv;
	Furniture f_ref;
	Furniture f_wm;
	Furniture f_chair;
	Furniture f_sofa;
	
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
		
		f_tv = new Furniture(100, 100, "tv");
		f_tv.setImage(new ImageIcon("src/icon/tv.png"));
		JButton btn_tv = new JButton(f_tv.getImage());
		btn_tv.setName(f_tv.getName());
		btn_tv.addActionListener(new MyListener());
		panel_2.add(btn_tv);
		
		f_wm = new Furniture(100, 120, "washing machine");
		f_wm.setImage(new ImageIcon("src/icon/washing_machine.png"));
		JButton btn_wm = new JButton(f_wm.getImage());
		btn_wm.setName("washing machine");
		btn_wm.addActionListener(new MyListener());
		panel_2.add(btn_wm);
		
		f_chair = new Furniture(100, 100, "chair");
		f_chair.setImage(new ImageIcon("src/icon/chair.png"));
		JButton btn_chair = new JButton(f_chair.getImage());
		btn_chair.setName("chair");
		btn_chair.addActionListener(new MyListener());
		panel_2.add(btn_chair);
		
		f_ref = new Furniture(100, 100, "tv");
		f_ref.setImage(new ImageIcon("src/icon/refrigerator.png"));
		JButton btn_ref = new JButton(f_ref.getImage());
		btn_ref.setName("refrigerator");
		btn_ref.addActionListener(new MyListener());
		panel_2.add(btn_ref);
		
		f_sofa = new Furniture(100,100,"sofa");
		f_sofa.setImage(new ImageIcon("src/icon/sofa.png"));
		JButton btn_sofa = new JButton(f_sofa.getImage());
		btn_sofa.setName("sofa");
		btn_sofa.addActionListener(new MyListener());
		panel_2.add(btn_sofa);
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

		
		panel_1 = new MyPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
	}

	class MyPanel extends JPanel {
		public MyPanel() {
			addMouseListener(new MyMouseListener());
		}

		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		ArrayList<Furniture> furnitureArray = new ArrayList<Furniture>();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			for (Shape s : shapeArray)
				g2.draw(s);
			for(Furniture f : furnitureArray) 
				g.drawImage(f.getImage().getImage(), f.getX(), f.getY(), null);
		}
		
		/*
		public void drawOutline() { //draw only outer line
			Shape s = new Rectangle2D.Float(project.basic_x, project.basic_y, project.width, project.height);
			shapeArray.clear();
			shapeArray.add(s);
			repaint();
		}
		*/
		
		/*
		public void drawDoor(Door door) { //draw only outer line
			Shape s;
			if(door.dir == 1)
				s = new Rectangle2D.Float(project.basic_x+door.first_x, project.basic_y+door.first_y-3, 30, 6);
			else
				s = new Rectangle2D.Float(project.basic_x+door.first_x-3, project.basic_y+door.first_y, 6, 30);
			shapeArray.add(s);
			repaint();
		}*/
		
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
		class MyMouseListener implements MouseListener {

			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				drawFurniture(e);
			}
		}
		
		boolean containXY(int x, int y) {
			int fixedWidth = 100;
			int fixedHeight = 100;
				
			if (shapeArray != null) {
				for (Shape s : shapeArray) {
					if (s instanceof Rectangle2D.Float) {
						Rectangle2D.Float r = (Rectangle2D.Float) s;
						for (int i = 0; i <= 50; i++) {
							if ((r.x <= x + i && x + i <= r.x + fixedWidth) && (r.y <= y + i && y + i <= r.y+ fixedHeight))
								return true;
						}
					} else if (s instanceof Line2D.Float) {
						Line2D.Float l = (Line2D.Float) s;
						for (int i = 0; i <= 50; i++) {
							if ((l.x1 <= x + i && x + i <= l.x2)&& (l.y1 <= y + i && y + i <= l.y2))
								return true;
						}
					} else if (s instanceof Ellipse2D.Float) {
						Ellipse2D.Float e = (Ellipse2D.Float) s;
						for (int i = 0; i <= 50; i++) {
							if ((e.x <= x + i && x + i <= e.x + fixedWidth)
									&& (e.y <= y + i && y + i <= e.y+ fixedHeight))
								return true;
						}
					}
				}
			}
			return false;
		}
		
		void drawFurniture(MouseEvent e) {
			Furniture f;
			switch (cmd) {
				case 'T': {
					f = new Furniture(f_tv.getWidth(), f_tv.getHeight(), f_tv.getName());
					f.setImage(f_tv.getImage());
					f.setX(e.getX());
					f.setY(e.getY());
					
					// 겹치는 경우 처리
					if (containXY(e.getX(), e.getY())) {
						break;
					}
	
					// 겹치지 않는다면 Furniture 배열에 추가
					furnitureArray.add(f);
					repaint();
					cmd = 'N';// 재초기화. 즉 다시 버튼을 눌러야 효과 적용
					break;
				}
				case 'W': {
					f = new Furniture(f_wm.getWidth(), f_wm.getHeight(), f_wm.getName());
					f.setImage(f_wm.getImage());
					f.setX(e.getX());
					f.setY(e.getY());
					
					// 겹치는 경우 처리
					if (containXY(e.getX(), e.getY())) {
						break;
					}
	
					// 겹치지 않는다면 furniture 배열에 추가
					furnitureArray.add(f);
					repaint();
					cmd = 'N';// 재초기화. 즉 다시 버튼을 눌러야 효과 적용
					break;
				}
				case 'C': {
					f = new Furniture(f_chair.getWidth(), f_chair.getHeight(), f_chair.getName());
					f.setImage(f_chair.getImage());
					f.setX(e.getX());
					f.setY(e.getY());
					
					// 겹치는 경우 처리
					if (containXY(e.getX(), e.getY())) {
						break;
					}
	
					// 겹치지 않는다면 furniture 배열에 추가
					furnitureArray.add(f);
					repaint();
					cmd = 'N';// 재초기화. 즉 다시 버튼을 눌러야 효과 적용
					break;
				}
				case 'R': {
					f = new Furniture(f_ref.getWidth(), f_ref.getHeight(), f_ref.getName());
					f.setImage(f_ref.getImage());
					f.setX(e.getX());
					f.setY(e.getY());
					
					// 겹치는 경우 처리
					if (containXY(e.getX(), e.getY())) {
						break;
					}
	
					// 겹치지 않는다면 furniture 배열에 추가
					furnitureArray.add(f);
					repaint();
					cmd = 'N';// 재초기화. 즉 다시 버튼을 눌러야 효과 적용
					break;
				}
				case 'S': {
					f = new Furniture(f_sofa.getWidth(), f_sofa.getHeight(), f_sofa.getName());
					f.setImage(f_sofa.getImage());
					f.setX(e.getX());
					f.setY(e.getY());
					
					// 겹치는 경우 처리
					if (containXY(e.getX(), e.getY())) {
						break;
					}
	
					// 겹치지 않는다면 furniture 배열에 추가
					furnitureArray.add(f);
					repaint();
					cmd = 'N';// 재초기화. 즉 다시 버튼을 눌러야 효과 적용
					break;
				}
				default: {
					repaint();
					break;
				}
			}

/*
		public void drawDoor(Door door) { //draw only outer line

			Shape s;
			if(door.dir == 1)
				s = new Rectangle2D.Float(project.basic_x+door.first_x, project.basic_y+door.first_y-3, 30, 6);
			else
				s = new Rectangle2D.Float(project.basic_x+door.first_x-3, project.basic_y+door.first_y, 6, 30);
			shapeArray.add(s);
			repaint();
*/
		}
	}
	
	private class MyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getName()=="tv") {
				cmd = 'T';// tv
				System.out.println("tv");
			} else if (b.getName()=="washing machine") {
				cmd = 'W';// washing machine
				System.out.println("wah");
			} else if (b.getName()=="chair") {
				cmd = 'C';// chair
				System.out.println("chair");
			} else if (b.getName()=="refrigerator") {
				cmd = 'R';// refrigerator
				System.out.println("ref");
			} else if (b.getName()=="sofa") {
				cmd = 'S';// sofa
				System.out.println("sofa");
			}
		}
	}
	
}
