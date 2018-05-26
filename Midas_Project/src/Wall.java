import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Wall extends JPanel{

	int vector;
	int first_x;
	int first_y;
	int second_x;
	int second_y;
	Room room;
	Window window;
	ArrayList<Window> windowArray = new ArrayList<Window>();
	JPanel panel = new JPanel();
	public Wall(int fX, int fY, int sX, int sY, int vector, Room room)
	{
		first_x = fX;
		first_y = fY;
		second_x = sX;
		second_y = sY;
		this.vector = vector;
		this.room = room;
	}
	public void SetDefaultWindow()
	{
		Window door = new Window(0,0,20,0);
	}
	public int getVector() {
		return vector;
	}
	public void setVector(int vector) {
		this.vector = vector;
	}

	public int getFirst_x() {
		return first_x;
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
	public void JPanelSize()
	{
		panel.setBackground(Color.BLACK);
		switch(vector)
		{
		case 0:
			panel.setBounds(first_x, first_y, second_x - first_x, 1);
			//panel.setSize(second_x - first_x, 10);
			//panel.setLocation(first_x, first_y);
			panel.addMouseListener(new MouseOverListener(this));
			break;
		case 1:
			panel.setBounds(first_x, first_y, 1,second_y - first_y);
			//panel.setSize(10,second_y - first_y);
			//panel.setLocation(first_x, first_y);
			panel.addMouseListener(new MouseOverListener(this));
			break;
		case 2:
			panel.setBounds(second_x, second_y, first_x - second_x, 1);
			panel.addMouseListener(new MouseOverListener(this));
			//panel.setLocation(second_x, second_y);
			break;
		case 3:
			panel.setBounds(second_x, second_y, 1, first_y - second_y);
			panel.addMouseListener(new MouseOverListener(this));
			//panel.setSize(10, first_y - second_y);
			//panel.setLocation(second_x, second_y);
			break;
		}
	}
}
