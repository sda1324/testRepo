import javax.swing.JPanel;

public class Window {
	int first_x;
	int first_y;
	int second_x;
	int second_y;
	JPanel panel;

	public Window() {
	}

	public Window(int first_x, int first_y, int second_x, int second_y) {
		this.first_x = first_x;
		this.first_y = first_y;
		this.second_x = second_x;
		this.second_y = second_y;
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
	
}
