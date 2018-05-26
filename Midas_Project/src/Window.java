import java.awt.Color;

import javax.swing.JPanel;

public class Window {
	int first_x;
	int first_y;
	int second_x;
	int second_y;
	JPanel panel = new JPanel();
	int dir;
	
	public Window() {
	}

	public Window(int first_x, int first_y, int second_x, int second_y) {
		this.first_x = first_x;
		this.first_y = first_y;
		this.second_x = second_x;
		this.second_y = second_y;
	}
	public void SetJPanelSize(int x0, int y0, int x1, int y1) {
		panel.setBackground(Color.BLUE);
		if (dir == 1) {
			panel.setBounds(x0+first_x, y0+first_y-3, 30, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0+first_x-3, y0+first_y,6, 30);
			panel.addMouseListener(new MouseOverListener(this));
		}
	}

	public int getFirst_x() {
		return first_x;
	}
	public void SetDir(int dir)
	{
		this.dir = dir;
	}
	public int GetDir()
	{
		return dir;
	}
	public void setFirst_x(int first_x) {
		this.first_x = first_x;
	}
	public int getFirst_y() {
		return first_y;
	}
	public void setFirst_y(int first_y) {
		this.first_y = first_y;
	}
	public int getSecond_x() {
		return second_x;
	}
	public void setSecond_x(int second_x) {
		this.second_x = second_x;
	}
	public int getSecond_y() {
		return second_y;
	}
	public void setSecond_y(int second_y) {
		this.second_y = second_y;
	}
	
}
