import java.awt.Shape;
import java.util.ArrayList;

public class Project {

	int width;
	int height;
	
	int basic_x; 
	int basic_y;
	
	ArrayList<Furniture> furniture_list = new ArrayList<Furniture>();
	ArrayList<Room> room_list = new ArrayList<Room>();
	ArrayList<Window> window_list = new ArrayList<Window>();
	ArrayList<Door> door_list = new ArrayList<Door>();
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	
	public Project() {
		
	}
	public void SetRoom(Room room)
	{
		room_list.add(room);
	}
	public void RemoveRoom(Room room)
	{
		for(Room r : room_list)
		{
			if(r == room)
				room_list.remove(r);
		}
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
