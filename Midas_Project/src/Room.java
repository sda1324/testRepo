import java.util.ArrayList;

public class Room {
	int first_x;
	int first_y;
	int second_x;
	int second_y;
	Wall east;
	Wall west;
	Wall north;
	Wall south;
	ArrayList<Door> doorArray = new ArrayList<Door>();
	public void SetAdditionalDoor(int x0, int y0, int x1, int y1, int vector)
	{
		Door door = new Door(0,0,20,0);
		switch(vector)
		{
		case 0:
			door.setDir(1);
			door.SetJPanelSize(x0, y0, x1, y1);
			break;
		case 1:
			door.SetJPanelSize(x0, y0, x1, y1);
			break;
		case 2:
			door.setDir(1);
			door.SetJPanelSize(x1, y1, x0, y0);
			break;
		case 3:
			door.SetJPanelSize(x1, y1, x0, y0);
			break;
		}
		doorArray.add(door);
		MainFrame.getInstance().panel_1.add(door.panel);
		door.panel.setVisible(true);
		MainFrame.getInstance().panel_1.revalidate();
		MainFrame.getInstance().panel_1.repaint();
	}
	public void SetDefaultDoor(int x0, int y0, int x1, int y1)
	{
		Door door = new Door(0,0,20,0);

		door.setDir(1);
		door.SetJPanelSize(x0, y0, x1, y1);
		doorArray.add(door);

		
	}
	public ArrayList<Door> GetDoorList()
	{
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
	
}
