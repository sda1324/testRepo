import java.awt.Color;
import java.awt.Graphics;
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
		System.out.println(room_list.size());
		for(int i = 0; i<room_list.size();++i)
		{
			if(room_list.get(i) == room)
				room_list.remove(i);
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

	public ArrayList<Furniture> getFurniture_list() {
		return furniture_list;
	}

	public void setFurniture_list(ArrayList<Furniture> furniture_list) {
		this.furniture_list = furniture_list;
	}

	public ArrayList<Room> getRoom_list() {
		return room_list;
	}

	public void setRoom_list(ArrayList<Room> room_list) {
		this.room_list = room_list;
	}

	public ArrayList<Window> getWindow_list() {
		return window_list;
	}

	public void setWindow_list(ArrayList<Window> window_list) {
		this.window_list = window_list;
	}

	public ArrayList<Door> getDoor_list() {
		return door_list;
	}

	public void setDoor_list(ArrayList<Door> door_list) {
		this.door_list = door_list;
	}

	public ArrayList<Shape> getShapeArray() {
		return shapeArray;
	}

	public void setShapeArray(ArrayList<Shape> shapeArray) {
		this.shapeArray = shapeArray;
	}
	
	public void drawAll() {
		MainFrame m = MainFrame.getInstance();
		System.out.println(furniture_list.size());
		for(Furniture f : furniture_list)
		{
			f.setImageLoad();
			f.setJPanel();
			f.panel.setVisible(true);
			f.panel.addMouseListener(new MouseOverListener(f));
			m.panel_1.furnitureArray.add(f);
			
			m.panel_1.add(f.panel);
			m.panel_1.repaint();
		}
		for(Room r : room_list)
		{
			r.east.JPanelSize();
			r.east.addMouseListener(new MouseOverListener(r.east.panel));
			m.panel_1.add(r.east.panel);
			for(Window w : r.east.windowArray)
			{
				w.SetResizeJPanel(w.getWidth());
				w.panel.addMouseListener(new MouseOverListener(w));
				m.panel_1.add(w.panel);
			}
			r.west.JPanelSize();
			r.west.addMouseListener(new MouseOverListener(r.west.panel));
			m.panel_1.add(r.west.panel);
			r.south.JPanelSize();
			r.south.addMouseListener(new MouseOverListener(r.south.panel));
			m.panel_1.add(r.south.panel);
			r.north.JPanelSize();
			r.north.addMouseListener(new MouseOverListener(r.north.panel));
			m.panel_1.add(r.north.panel);
			for(Door d : r.doorArray)
			{
				d.SetResizeJPanel(d.getWidth());
				d.panel.addMouseListener(new MouseOverListener(d));
				m.panel_1.add(d.panel);
			}
		}
		m.panel_1.repaint();
	}
	
}
