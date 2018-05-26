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

	public Window() {

	}

	public Window(int x, int y, int width, int height, Wall w) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.wall = w;
		
	}

	public void EditPosition(int new_x, int new_y) {
		
		if(dir == 0)
		{
			x = new_x;
		}
		else
		{
			y = new_y;
		}
		SetJPanelSize(new_x,new_y,width,height,this.wall);
	}
	public void RemoveWindow()
	{
		wall.RemoveWindow(this);
	}
	public void SetJPanelSize(int x0, int y0, int x1, int y1, Wall wall) {
		panel.setBackground(Color.BLUE);
		if (dir == 1) {
			panel.setBounds(x0 + x, y0 + y - 3, 30, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0 + x - 3, y0 + y, 6, 30);
			panel.addMouseListener(new MouseOverListener(this));
		}
		this.wall = wall;
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
