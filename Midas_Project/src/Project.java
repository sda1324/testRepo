import java.util.ArrayList;

public class Project {

	int width;
	int height;
	
	//기준이 되는 x, y
	int basic_x; 
	int basic_y;
	
	ArrayList<Room> room_list = new ArrayList<Room>();
	ArrayList<Window> window_list = new ArrayList<Window>();
	ArrayList<Door> door_list = new ArrayList<Door>();
	
	public Project() {
		
	}
	
	public Project(int width, int height) {
		this.width= width;
		this.height = height;
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

	public int getBasic_x() {
		return basic_x;
	}

	public void setBasic_x(int basic_x) {
		this.basic_x = basic_x;
	}

	public int getBasic_y() {
		return basic_y;
	}

	public void setBasic_y(int basic_y) {
		this.basic_y = basic_y;
	}
	
	
}
