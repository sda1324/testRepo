import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Shape;
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
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			clicked_x = e.getX();
			clicked_y = e.getY();
			int width = pnt_x - clicked_x;
			int height = pnt_y - clicked_y;
			System.out.println(width + " " + height);
			/*
			JPanel north = new JPanel();
			JPanel south = new JPanel();
			JPanel west = new JPanel();
			JPanel east = new JPanel();
			*/
			Room newRoom;
			if(width < 0) {
				width = -width;
				if(height < 0) {
					height = -height;
					 Shape s = new Rectangle2D.Float(pnt_x, pnt_y, width, height);
				     MainFrame.getInstance().panel_1.shapeArray.add(s);
					newRoom = new Room(pnt_x, pnt_y, width, height);
					newRoom.north = new Wall(pnt_x, pnt_y, width, 1,0, newRoom);
					newRoom.north.addMouseListener(new MouseOverListener(newRoom.north.panel));
					newRoom.north.JPanelSize();
					newRoom.south = new Wall(pnt_x, clicked_y, width, 1,2, newRoom);
					newRoom.south.addMouseListener(new MouseOverListener(newRoom.south.panel));
					newRoom.south.JPanelSize();
					newRoom.west = new Wall(pnt_x, pnt_y, 1, height,3, newRoom);
					newRoom.west.addMouseListener(new MouseOverListener(newRoom.west.panel));
					newRoom.west.JPanelSize();
					newRoom.east = new Wall(clicked_x, pnt_y, 1, height,1, newRoom);
					newRoom.east.addMouseListener(new MouseOverListener(newRoom.east.panel));
					newRoom.east.JPanelSize();
					newRoom.SetDefaultDoor(pnt_x, pnt_y, width, height);
					}
				else {		
					 Shape s = new Rectangle2D.Float(pnt_x, clicked_y, width, height);
				     MainFrame.getInstance().panel_1.shapeArray.add(s);
					newRoom = new Room(pnt_x, clicked_y, width, height);
					newRoom.north = new Wall(pnt_x, clicked_y, width, 1,0, newRoom);
					newRoom.north.addMouseListener(new MouseOverListener(newRoom.north.panel));
					newRoom.north.JPanelSize();
					newRoom.south = new Wall(pnt_x, pnt_y, width, 1,2, newRoom);
					newRoom.south.addMouseListener(new MouseOverListener(newRoom.south.panel));
					newRoom.south.JPanelSize();
					newRoom.west = new Wall(pnt_x, clicked_y, 1, height,3, newRoom);
					newRoom.west.addMouseListener(new MouseOverListener(newRoom.west.panel));
					newRoom.west.JPanelSize();
					newRoom.east = new Wall(clicked_x, clicked_y, 1, height,1, newRoom);
					newRoom.east.addMouseListener(new MouseOverListener(newRoom.east.panel));
					newRoom.east.JPanelSize();
					newRoom.SetDefaultDoor(pnt_x, clicked_y, width, height);
					
				}
			}
			else {
				if(height < 0) {
					height = -height;
					 Shape s = new Rectangle2D.Float(clicked_x, pnt_y, width, height);
				     MainFrame.getInstance().panel_1.shapeArray.add(s);
					newRoom = new Room(clicked_x, pnt_y, width, height);
					newRoom.north = new Wall(clicked_x, pnt_y, width, 1,0, newRoom);
					newRoom.north.addMouseListener(new MouseOverListener(newRoom.north.panel));
					newRoom.north.JPanelSize();
					newRoom.south = new Wall(clicked_x, clicked_y, width, 1,2, newRoom);
					newRoom.south.addMouseListener(new MouseOverListener(newRoom.south.panel));
					newRoom.south.JPanelSize();
					newRoom.west = new Wall(clicked_x, pnt_y, 1, height,3, newRoom);
					newRoom.west.addMouseListener(new MouseOverListener(newRoom.west.panel));
					newRoom.west.JPanelSize();
					newRoom.east = new Wall(pnt_x, pnt_y, 1, height,1, newRoom);
					newRoom.east.addMouseListener(new MouseOverListener(newRoom.east.panel));
					newRoom.east.JPanelSize();
					newRoom.SetDefaultDoor(clicked_x, pnt_y, width, height);
				}
				else {
					 Shape s = new Rectangle2D.Float(clicked_x, clicked_y, width, height);
				     MainFrame.getInstance().panel_1.shapeArray.add(s);
					newRoom = new Room(clicked_x, clicked_y, width, height);
					newRoom.north = new Wall(clicked_x, clicked_y, width, 1,0, newRoom);
					newRoom.north.addMouseListener(new MouseOverListener(newRoom.north.panel));
					newRoom.north.JPanelSize();
					newRoom.south = new Wall(clicked_x, pnt_y, width, 1,2, newRoom);
					newRoom.south.addMouseListener(new MouseOverListener(newRoom.south.panel));
					newRoom.south.JPanelSize();
					newRoom.west = new Wall(clicked_x, clicked_y, 1, height,3, newRoom);
					newRoom.west.addMouseListener(new MouseOverListener(newRoom.west.panel));
					newRoom.west.JPanelSize();
					newRoom.east = new Wall(pnt_x, clicked_y, 1, height,1, newRoom);
					newRoom.east.addMouseListener(new MouseOverListener(newRoom.east.panel));
					newRoom.east.JPanelSize();
					newRoom.SetDefaultDoor(clicked_x, clicked_y, width, height);
						
				}
			}
			
			main.panel_1.add(newRoom.north.panel);
			main.panel_1.add(newRoom.south.panel);
			main.panel_1.add(newRoom.west.panel);
			main.panel_1.add(newRoom.east.panel);
			newRoom.north.panel.setVisible(true);
			newRoom.south.panel.setVisible(true);
			newRoom.east.panel.setVisible(true);
			newRoom.west.panel.setVisible(true);
			MainFrame.getInstance().project.SetRoom(newRoom);
			for(Door d : newRoom.GetDoorList())
			{
				main.panel_1.add(d.panel);
				d.panel.setVisible(true);
			}
			main.panel_1.removeMouseListener(this);
			main.panel_1.repaint();
			
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
	ActionListener removeFurniture = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Furniture furniture = (Furniture) source;
			furniture.RemoveFurniture();
		}
	};
	public JPopupMenu GetPopup() {
		return popup;
	}
	public void show(int x, int y, int xX, int yY, int xXX, int yYY) {
		pnt_x = xX;
		pnt_y = yY;
		popup.show(main, x, y);
	}
	public void SetItem(String className) {
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
			//popup.add(item = new JMenuItem("Edit Room"));
			//item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Door"));
			item.addActionListener(makeDoor);
			popup.add(item = new JMenuItem("Add Window"));
			item.addActionListener(makeWindow);
			popup.add(item = new JMenuItem("Remove Room"));
			item.addActionListener(removeRoom);
			break;
		case "Furniture":
			popup.add(item = new JMenuItem("Remove Furniture"));
			item.addActionListener(removeFurniture);
			popup.add(item = new JMenuItem("move Furniture"));
			item.addActionListener(menuListener);//Do This
			break;
		case "Window":
			popup.add(item = new JMenuItem("Resize Window"));
			item.addActionListener(menuListener);//Do This
			popup.add(item = new JMenuItem("Remove Window"));
			item.addActionListener(removeWindow);
			popup.add(item = new JMenuItem("move Window"));
			item.addActionListener(moveWindow);//Do This
			break;
		case "Door":
			popup.add(item = new JMenuItem("Resize Door"));
			item.addActionListener(menuListener);//Do This
			popup.add(item = new JMenuItem("Remove Door"));
			item.addActionListener(removeDoor);
			popup.add(item = new JMenuItem("move Door"));
			item.addActionListener(menuListener);//Do This
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
