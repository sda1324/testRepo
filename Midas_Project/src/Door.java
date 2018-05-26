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
	int dir; // 1: horizon , 2: vertical

	public Door() {
	}

	public Door(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void SetJPanelSize(int x0, int y0, int x1, int y1) {
		panel.setBackground(Color.YELLOW);
		if (dir == 1) {

			panel.setBounds(x0+x, y0+y-3, 30, 6);
			panel.addMouseListener(new MouseOverListener(this));
		} else {
			panel.setBounds(x0+x-3, y0+y,6, 30);
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
}
