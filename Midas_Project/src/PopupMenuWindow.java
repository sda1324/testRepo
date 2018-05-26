import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PopupMenuWindow extends JPanel {
	private JPopupMenu popup;
	MainFrame main;
	Object source;
	int pnt_x;
	int pnt_y;
	int clicked_x;
	int clicked_y;
	JPanel p;
	public PopupMenuWindow(Object t) {
		popup = new JPopupMenu();
		source = t;
		this.main = MainFrame.getInstance();
	}
	ActionListener menuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Popup menu item [" + e.getActionCommand() + "] was pressed.");
			switch(e.getActionCommand()) {
			case "Add Room":

				System.out.println(pnt_x + " " + pnt_y);
				main.panel_1.addMouseListener(new AddRoomListener());
				break;
			default:
				break;
			}
			
		}
	};
	class AddRoomListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			clicked_x = e.getXOnScreen()-main.getBounds().x;
			clicked_y = e.getYOnScreen()-main.getBounds().y;
			int width = pnt_x - clicked_x;
			int height = pnt_y - clicked_y;
			System.out.println(width + " " + height);
			JPanel north = new JPanel();
			JPanel south = new JPanel();
			JPanel west = new JPanel();
			JPanel east = new JPanel();
			if(width < 0) {
				width = -width;
				if(height < 0) {
					height = -height;
					north.setBounds(pnt_x, pnt_y, width, 1);
					south.setBounds(pnt_x, clicked_y, width, 1);
					west.setBounds(pnt_x, pnt_y, 1, height);
					east.setBounds(clicked_x, pnt_y, 1, height);
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, pnt_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, clicked_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, pnt_y, 1, height));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, pnt_y, 1, height));
					
					
				}
				else {
					north.setBounds(pnt_x, clicked_y, width, 1);
					south.setBounds(clicked_x, clicked_y, width, 1);
					west.setBounds(pnt_x, clicked_y, 1, height);
					east.setBounds(clicked_x, clicked_y, 1, height);
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, pnt_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, clicked_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, pnt_y, 1, height));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, pnt_y, 1, height));
					
				}
			}
			else {
				if(height < 0) {
					height = -height;
					north.setBounds(clicked_x, pnt_y, width, 1);
					south.setBounds(clicked_x, clicked_y, width, 1);
					west.setBounds(clicked_x, pnt_y, 1, height);
					east.setBounds(pnt_x, pnt_y, 1, height);
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, pnt_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, clicked_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, pnt_y, 1, height));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, pnt_y, 1, height));
				}
				else {
					north.setBounds(clicked_x, clicked_y, width, 1);
					south.setBounds(clicked_x, pnt_y, width, 1);
					west.setBounds(clicked_x, clicked_y, 1, height);
					east.setBounds(pnt_x, clicked_y, 1, height);
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, clicked_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, pnt_y, width, 1));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(clicked_x, clicked_y, 1, height));
					main.panel_1.shapeArray.add(new Rectangle2D.Float(pnt_x, clicked_y, 1, height));
					
				}
				north.setBackground(Color.BLACK);
				south.setBackground(Color.BLACK);
				west.setBackground(Color.BLACK);
				east.setBackground(Color.BLACK);
				main.panel_1.add(north);
				main.panel_1.add(south);
				main.panel_1.add(west);
				main.panel_1.add(east);
				north.setVisible(true);
				south.setVisible(true);
				west.setVisible(true);
				east.setVisible(true);
				main.panel_1.addMouseMotionListener(null);
				main.panel_1.repaint();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class AddRoomMotionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	ActionListener makeWindow = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Wall wall = (Wall) source;
			wall.SetDefaultWindow();
		}
	};
	ActionListener moveWindow = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Window window = (Window)source;
			window.EditPosition();

		}
	};
	ActionListener removeWindow = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Window window = (Window)source;
			window.RemoveWindow();
		}
	};
	ActionListener removeRoom = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Wall wall = (Wall)source;
			wall.RemoveRoom();
		}
	};
	ActionListener makeDoor = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Wall wall = (Wall) source;
			wall.SetAdditionalDoor();
		}
	};
	ActionListener removeDoor = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Door door = (Door) source;
			door.RemoveDoor();
		}
	};
	public JPopupMenu GetPopup() {
		return popup;
	}
	public void show(int x, int y) {
		pnt_x = x;
		pnt_y = y;
		popup.show(main, x, y);
	}
	public void SetItem(String className) {
		// 0: blank
		// 1: wall
		// 2: point
		// 3: furniture
		//4: window
		//5: door
		JMenuItem item;
		switch (className) {
		case "Blank":
			popup.add(item = new JMenuItem("Add Furniture"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Save File"));
			item.addActionListener(menuListener);
			break;
		case "Wall":
			popup.add(item = new JMenuItem("Edit Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Door"));
			item.addActionListener(makeDoor);
			popup.add(item = new JMenuItem("Add Window"));
			item.addActionListener(makeWindow);
			popup.add(item = new JMenuItem("Remove Room"));
			item.addActionListener(removeRoom);
			break;
		case "Point":
			popup.add(item = new JMenuItem("Edit Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Remove Room"));
			item.addActionListener(removeRoom);
			break;
		case "Furniture":
			popup.add(item = new JMenuItem("Resize Furniture"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Remove Furniture"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("move Furniture"));
			item.addActionListener(menuListener);
			break;
		case "Window":
			popup.add(item = new JMenuItem("Resize Window"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Remove Window"));
			item.addActionListener(removeWindow);
			popup.add(item = new JMenuItem("move Window"));
			item.addActionListener(moveWindow);
			break;
		case "Door":
			popup.add(item = new JMenuItem("Resize Door"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Remove Door"));
			item.addActionListener(removeDoor);
			popup.add(item = new JMenuItem("move Door"));
			item.addActionListener(menuListener);
			break;
			
		default:
			popup.add(item = new JMenuItem("Add Furniture"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Save File"));
			item.addActionListener(menuListener);
			break;
		
		}
	}
}
