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
			y = new_y;
		}
		else
		{
			x = new_x;
		}
		SetJPanelSize(width,y,width,height,this.wall);
	}
	public void RemoveWindow()
	{
		wall.RemoveWindow(this);
	}
	public void SetJPanelMove(int x, int y) {
		panel.setBackground(Color.BLUE);
		if (dir == 1) {
			panel.setBounds(x0+x-320, y0 - 3, width, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0 - 3, y0+y-26, 6, width);
			panel.addMouseListener(new MouseOverListener(this));
		}
	}
	public void SetJPanelSize(int x0, int y0, int x1, int y1, Wall wall) {
		panel.setBackground(Color.BLUE);
		this.x0 = x0;
		this.y0 = y0;
		if (dir == 1) {
			panel.setBounds(x0, y0 - 3, width, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0 - 3, y0, 6, width);
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
