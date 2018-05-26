import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PopupMenuWindow extends JPanel {
	private JPopupMenu popup;
	MainFrame main;
	Object source;
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
		}
	};
	public JPopupMenu GetPopup() {
		return popup;
	}
	public void show(int x, int y) {
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
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Window"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Remove Room"));
			item.addActionListener(menuListener);
			break;
		case "Point":
			popup.add(item = new JMenuItem("Edit Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Add Room"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Remove Room"));
			item.addActionListener(menuListener);
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
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("move Window"));
			item.addActionListener(menuListener);
			break;
		case "Door":
			popup.add(item = new JMenuItem("Resize Door"));
			item.addActionListener(menuListener);
			popup.add(item = new JMenuItem("Remove Door"));
			item.addActionListener(menuListener);
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