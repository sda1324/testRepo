import javax.swing.JPanel;
import java.awt.Color;

public class Door {
	JPanel panel = new JPanel();
	int x;
	int y;
	int width;
	int height;
	int project_x0;
	int project_y0;
	int x0;
	int y0;
	int dir; // 1: horizon , 2: vertical
	Room room;
	public Door() {
	}
	public Door(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public Door(int x, int y, int width, int height, Room room) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.room = room;
	}
	public void RemoveDoor()
	{
		room.RemoveDoor(this);
	}
	public void SetJPanelSize(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		panel.setBackground(Color.YELLOW);
		if (dir == 1) {

			panel.setBounds(x0+x, y0+y-3, width, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0+x-3, y0+y,6, width);
			panel.addMouseListener(new MouseOverListener(this));
		}
	}
	public void SetJPanelMove(int x2, int y2) {

		panel.setBackground(Color.YELLOW);
		if (dir == 1) {

			panel.setBounds(x0+x+x2-320, y0+y-3, width, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0+x-3, y0+y+y2-26,6, width);
			panel.addMouseListener(new MouseOverListener(this));
		}
	}
	public void SetResizeJPanel(int width) {
		panel.setBackground(Color.YELLOW);
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
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public int getProject_x0() {
		return project_x0;
	}
	public void setProject_x0(int project_x0) {
		this.project_x0 = project_x0;
	}
	public int getProject_y0() {
		return project_y0;
	}
	public void setProject_y0(int project_y0) {
		this.project_y0 = project_y0;
	}
	public int getX0() {
		return x0;
	}
	public void setX0(int x0) {
		this.x0 = x0;
	}
	public int getY0() {
		return y0;
	}
	public void setY0(int y0) {
		this.y0 = y0;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
}
