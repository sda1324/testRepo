import java.awt.Component;
import java.awt.Shape;
import java.util.ArrayList;

public class Room {
	int first_x;
	int first_y;
	int second_x;
	int second_y;
	int width;
	int height;
	Wall east;
	Wall west;
	Wall north;
	Wall south;
	ArrayList<Door> doorArray = new ArrayList<Door>();

	public Room(int x, int y, int width, int height)
	{
		first_x = x;
		first_y = y;
		this.width = width;
		this.height = height;
	}
	public void SetAdditionalDoor(int x, int y, int width, int height, int vector) {
		Door door = new Door(0, 0, 20, 0, this);
		switch (vector) {

		case 0:
			door.setDir(1);
			door.SetJPanelSize(x, y, width, height);
			break;
		case 1:
			door.setDir(0);
			door.SetJPanelSize(x + width, y, width, height);
			break;
		case 2:
			door.setDir(1);
			door.SetJPanelSize(x, y + height, width, height);
			break;
		case 3:
			door.setDir(0);
			door.SetJPanelSize(x, y, width, height);
			break;
		}
		doorArray.add(door);
		MainFrame.getInstance().panel_1.add(door.panel);
		door.panel.setVisible(true);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
	}
	public void RemoveRoom()
	{
		east.RemoveWindow(null);
		MainFrame.getInstance().panel_1.remove(east.panel);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
		west.RemoveWindow(null);
		MainFrame.getInstance().panel_1.remove(west.panel);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
		south.RemoveWindow(null);
		MainFrame.getInstance().panel_1.remove(south.panel);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
		north.RemoveWindow(null);
		MainFrame.getInstance().panel_1.remove(north.panel);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
		
		for(Door d : doorArray)
		{
			MainFrame.getInstance().panel_1.remove(d.panel);
		}
		ArrayList<Shape> tempArray = MainFrame.getInstance().panel_1.shapeArray;
		for(int i =0; i<tempArray.size();++i)
		{
			if(tempArray.get(i).getBounds().getX() == first_x && tempArray.get(i).getBounds().getY() == first_y
					&& tempArray.get(i).getBounds().getWidth() == width && tempArray.get(i).getBounds().getHeight() == height)
			{
				tempArray.remove(i);
			}
		}
		MainFrame.getInstance().project.RemoveRoom(this);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
	}
	public void RemoveDoor(Door door) {
		if (doorArray.size() != 1) {
			for ( int i = 0; i<doorArray.size();++i) {
				if (doorArray.get(i) == door) {
					MainFrame.getInstance().panel_1.remove(door.panel);
					doorArray.remove(i);
					MainFrame.getInstance().panel_1.revalidate();
					MainFrame.getInstance().panel_1.repaint();
					break;
				}
			}
		}
	}
	public void SetDefaultDoor(int x0, int y0, int x1, int y1) {
		Door door = new Door(0, 0, 20, 0, this);
		door.setDir(1);
		door.SetJPanelSize(x0, y0, x1, y1);
		doorArray.add(door);
	}

	public ArrayList<Door> GetDoorList() {
		return doorArray;
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
	public Wall getEast() {
		return east;
	}
	public void setEast(Wall east) {
		this.east = east;
	}
	public Wall getWest() {
		return west;
	}
	public void setWest(Wall west) {
		this.west = west;
	}
	public Wall getNorth() {
		return north;
	}
	public void setNorth(Wall north) {
		this.north = north;
	}
	public Wall getSouth() {
		return south;
	}
	public void setSouth(Wall south) {
		this.south = south;
	}
	public ArrayList<Door> getDoorArray() {
		return doorArray;
	}
	public void setDoorArray(ArrayList<Door> doorArray) {
		this.doorArray = doorArray;
	}

}
