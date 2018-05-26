import java.awt.Color;

import javax.swing.JPanel;

public class Window {
	int x;
	int y;
	int width;
	int height;
	JPanel panel = new JPanel();
	int dir;
	Wall wall;

	int x0;
	int y0;
	
	public Window() {

	}

	public Window(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void EditPosition() {
		int w1;
		int w2;
		
		if(dir == 0)
		{
			w1 = wall.getY();
			w2 = wall.getHeight();
		}
		else
		{
			w1 = wall.getX();
			w2 = wall.getWidth();
		}
	}
	public void RemoveWindow()
	{
		wall.RemoveWindow(this);
	}
	public void SetJPanelSize(int x0, int y0, int x1, int y1, Wall wall) {
		panel.setBackground(Color.BLUE);
		this.x0 = x0;
		this.y0 = y0;
		if (dir == 1) {
			panel.setBounds(x0 + x, y0 + y - 3, width, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0 + x - 3, y0 + y, 6, width);
			panel.addMouseListener(new MouseOverListener(this));
		}
		this.wall = wall;
	}
	public void SetResizeJPanel(int width) {
		this.width = width;
		panel.setBackground(Color.BLUE);
		if (dir == 1) {
			panel.setBounds(x0 + x, y0 + y - 3, width, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0 + x - 3, y0 + y, 6, width);
			panel.addMouseListener(new MouseOverListener(this));
		}
	}
	public int getX() {
		return x;
	}

	public void SetDir(int dir) {
		this.dir = dir;
	}

	public int GetDir() {
		return dir;
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

}
