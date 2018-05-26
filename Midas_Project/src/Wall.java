import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Wall extends JPanel {

	int vector;
	int x;
	int y;
	int width;
	int height;
	Room room;
	Window window;
	ArrayList<Window> windowArray = new ArrayList<Window>();
	JPanel panel = new JPanel();

	public Wall(int fX, int fY, int width, int height, int vector, Room room) {
		x = fX;
		y = fY;
		this.width = width;
		this.height = height;
		this.vector = vector;
		this.room = room;
	}

	public void RemoveRoom() {
		room.RemoveRoom();
	}

	public void RemoveWindow(Window window) {

		if (window == null) {
			for (int i = 0; i < windowArray.size(); ++i) {
				MainFrame.getInstance().panel_1.remove(windowArray.get(i).panel);
				windowArray.remove(i);
				MainFrame.getInstance().panel_1.revalidate();
				MainFrame.getInstance().panel_1.repaint();
			}
		} 
		else {
			if (windowArray.size() != 0) {
				for (int i = 0; i < windowArray.size(); ++i) {
					if (windowArray.get(i) == window) {
						MainFrame.getInstance().panel_1.remove(window.panel);
						windowArray.remove(i);
						MainFrame.getInstance().panel_1.revalidate();
						MainFrame.getInstance().panel_1.repaint();
						break;
					}
				}
			}
		}
	}

	public void SetAdditionalDoor() {
		room.SetAdditionalDoor(x, y, width, height, vector);
	}

	public void SetDefaultWindow() {
		window = new Window(0, 0, 20, 0, this);
		switch (vector) {
		case 0:
			window.SetDir(1);
			window.SetJPanelSize(x, y, width, height, this);
			break;
		case 1:
			window.SetDir(0);
			window.SetJPanelSize(x + width, y, width, height, this);
			break;
		case 2:
			window.SetDir(1);
			window.SetJPanelSize(x, y + height, width, height, this);
			break;
		case 3:
			window.SetDir(0);
			window.SetJPanelSize(x, y, width, height, this);
			break;
		}
		windowArray.add(window);
		MainFrame.getInstance().panel_1.add(window.panel);
		window.panel.setVisible(true);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
	}

	public int getVector() {
		return vector;
	}

	public void setVector(int vector) {
		this.vector = vector;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void JPanelSize() {
		panel.setBackground(Color.BLACK);
		switch (vector) {
		case 0:
			panel.setBounds(x, y, width + 1, 2);
			panel.addMouseListener(new MouseOverListener(this));
			break;
		case 1:
			panel.setBounds(x + width - 1, y, 2, height + 1);

			panel.addMouseListener(new MouseOverListener(this));
			break;
		case 2:
			panel.setBounds(x, y + height - 1, width + 1, 2);
			panel.addMouseListener(new MouseOverListener(this));

			break;
		case 3:
			panel.setBounds(x, y, 2, height + 1);
			panel.addMouseListener(new MouseOverListener(this));

			break;
		}
	}
}
