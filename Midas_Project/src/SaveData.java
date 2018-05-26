import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SaveData {
	
	public void save(Project p) {
/*
		String s=null;
		for(Furniture f : p.furniture_list)
		{
			s+=f.getX() +" " +f.getY()+" "+f.getWidth()+" "+f.getHeight()+" "+f.getColor()+" "+f.getImage()+"&";
		}
*/		
		JSONObject projectInfo = new JSONObject();
		projectInfo.put("width", p.getWidth());
		projectInfo.put("height", p.getWidth());
		projectInfo.put("basic_x", p.getBasic_x());
		projectInfo.put("basic_y", p.getBasic_y());
		
		//Furniture
		JSONArray furnitureList = new JSONArray(); 
		
		System.out.println(p.furniture_list.size());
		for(Furniture f :p.getFurniture_list()) {
			JSONObject furnitureObject = new JSONObject(); 
			furnitureObject.put("imageUrl", f.getURL() );
			furnitureObject.put("width", f.getWidth() );
			furnitureObject.put("height", f.getHeight());
			furnitureObject.put("name", f.getName());
			furnitureObject.put("x", f.getX());
			furnitureObject.put("y", f.getY());
			furnitureList.add(furnitureObject);
			MainFrame.getInstance().panel_1.remove(f.panel);
		}
		projectInfo.put("furniture_list", furnitureList);
		
		// Room
		JSONArray roomList = new JSONArray();
		for (Room r : p.getRoom_list()) {
			JSONObject roomObject = new JSONObject(); 
			roomObject.put("first_x", r.getFirst_x());
			roomObject.put("first_y", r.getFirst_y());
			roomObject.put("second_x", r.getSecond_x());
			roomObject.put("second_y", r.getSecond_y());
			roomObject.put("width", r.getWidth());
			roomObject.put("height", r.getHeight());
			{
				JSONObject eastObject = new JSONObject();
				eastObject.put("vector", r.east.getVector());
				eastObject.put("x", r.east.getX());
				eastObject.put("y", r.east.getY());
				eastObject.put("width", r.east.getWidth());
				eastObject.put("height", r.east.getHeight());
				{
					JSONArray windowList = new JSONArray();
					for(Window w : r.getEast().getWindowArray()) {
						JSONObject windowObject = new JSONObject();
						windowObject.put("x", w.getX());
						windowObject.put("y", w.getY());
						windowObject.put("width", w.getWidth());
						windowObject.put("height", w.getHeight());
						windowObject.put("dir", w.getDir());
						windowObject.put("x0", w.getX0());
						windowObject.put("y0", w.getY0());
						windowList.add(windowObject);
					}
					eastObject.put("windowArray", windowList);
				}
				roomObject.put("east", eastObject);
			}
			{
				JSONObject westObject = new JSONObject();
				westObject.put("vector", r.west.getVector());
				westObject.put("x", r.west.getX());
				westObject.put("y", r.west.getY());
				westObject.put("width", r.west.getWidth());
				westObject.put("height", r.west.getHeight());
				{
					JSONArray windowList = new JSONArray();
					for(Window w : r.getWest().getWindowArray()) {
						JSONObject windowObject = new JSONObject();
						windowObject.put("x", w.getX());
						windowObject.put("y", w.getY());
						windowObject.put("width", w.getWidth());
						windowObject.put("height", w.getHeight());
						windowObject.put("dir", w.getDir());
						windowObject.put("x0", w.getX0());
						windowObject.put("y0", w.getY0());
						windowList.add(windowObject);
					}
					westObject.put("windowArray", windowList);
				}
				roomObject.put("west", westObject);
			}
			{
				JSONObject northObject = new JSONObject();
				northObject.put("vector", r.north.getVector());
				northObject.put("x", r.north.getX());
				northObject.put("y", r.north.getY());
				northObject.put("width", r.north.getWidth());
				northObject.put("height", r.north.getHeight());
				{
					JSONArray windowList = new JSONArray();
					for(Window w : r.getNorth().getWindowArray()) {
						JSONObject windowObject = new JSONObject();
						windowObject.put("x", w.getX());
						windowObject.put("y", w.getY());
						windowObject.put("width", w.getWidth());
						windowObject.put("height", w.getHeight());
						windowObject.put("dir", w.getDir());
						windowObject.put("x0", w.getX0());
						windowObject.put("y0", w.getY0());
						windowList.add(windowObject);
					}
					northObject.put("windowArray", windowList);
				}
				roomObject.put("north", northObject);
			}
			{
				JSONObject southObject = new JSONObject();
				southObject.put("vector", r.south.getVector());
				southObject.put("x", r.south.getX());
				southObject.put("y", r.south.getY());
				southObject.put("width", r.south.getWidth());
				southObject.put("height", r.south.getHeight());
				{
					JSONArray windowList = new JSONArray();
					for(Window w : r.getSouth().getWindowArray()) {
						JSONObject windowObject = new JSONObject();
						windowObject.put("x", w.getX());
						windowObject.put("y", w.getY());
						windowObject.put("width", w.getWidth());
						windowObject.put("height", w.getHeight());
						windowObject.put("dir", w.getDir());
						windowObject.put("x0", w.getX0());
						windowObject.put("y0", w.getY0());
						windowList.add(windowObject);
					}
					southObject.put("windowArray", windowList);
				}
				roomObject.put("south", southObject);
			}
			roomList.add(roomObject);
		}
		projectInfo.put("room_list", roomList);
		
		
		System.out.println(projectInfo.toString());
		MainFrame.getInstance().panel_1.repaint();
		
		/*
		JSONObject roomList = new JSONObject(); 
		for(Room r : p.getRoom_list()) {
			roomList.put("first_x", r.getFirst_x());
			roomList.put("first_y", r.getFirst_y());
			roomList.put("second_x", r.getSecond_x());
			roomList.put("second_y", r.getSecond_y());
		}
		projectInfo.put("furnitureList", furnitureList);
		*/
		
		try { 
			FileWriter file = new FileWriter("src/text/save.json"); 
			file.write(projectInfo.toJSONString()); 
			file.flush(); file.close(); 
		} catch (IOException e) { e.printStackTrace(); } 
		System.out.print(projectInfo);
		


	}
	public Project getData() {
		Project p = new Project();
		JSONParser parser = new JSONParser(); 
		try { 
			Object obj = parser.parse(new FileReader("src/text/save.json"));
			JSONObject jsonObject = (JSONObject) obj; 
			p.width = Integer.parseInt(jsonObject.get("width").toString());
			p.height = Integer.parseInt(jsonObject.get("height").toString());
			p.basic_x = Integer.parseInt(jsonObject.get("basic_x").toString());
			p.basic_y = Integer.parseInt(jsonObject.get("basic_y").toString());


			//furniture
			JSONArray JSONfurnitureList = (JSONArray) jsonObject.get("furniture_list");
			for(int i=0;i<JSONfurnitureList.size();i++) {
				JSONObject j = (JSONObject) JSONfurnitureList.get(i);
				Furniture f = new Furniture();
				f.setURL(j.get("imageUrl").toString());
				f.setWidth(Integer.parseInt(j.get("width").toString()));
				f.setHeight(Integer.parseInt(j.get("height").toString()));
				f.setName((String)j.get("name"));
				f.setImage((ImageIcon) j.get("imageicon"));
				f.setX(Integer.parseInt(j.get("x").toString()));
				f.setY(Integer.parseInt(j.get("y").toString()));
				
				p.furniture_list.add(f);
			}
			
			//Room
			JSONArray JSONRoomList = (JSONArray) jsonObject.get("room_list");
			for(int i=0;i<JSONRoomList.size();i++) {
				JSONObject j = (JSONObject) JSONRoomList.get(i);
				Room r = new Room(Integer.parseInt(j.get("first_x").toString()), Integer.parseInt(j.get("first_y").toString()), 
						Integer.parseInt(j.get("width").toString()), Integer.parseInt(j.get("height").toString()));
				r.setSecond_x(Integer.parseInt(j.get("second_x").toString()));
				r.setSecond_y(Integer.parseInt(j.get("second_y").toString()));
				
				JSONObject east = (JSONObject) j.get("east");
				r.east.vector = Integer.parseInt(east.get("vector").toString());
				r.east.x = Integer.parseInt(east.get("x").toString());
				r.east.y = Integer.parseInt(east.get("y").toString());
				r.east.width = Integer.parseInt(east.get("width").toString());
				r.east.height = Integer.parseInt(east.get("height").toString());
				JSONArray windowList = (JSONArray) east.get("windowArray");
				for(int  k=0; k<windowList.size(); k++) {
					JSONObject jw = (JSONObject) windowList.get(k);
					Window w = new Window();
					w.setX(Integer.parseInt(jw.get("x").toString()));
					w.setY(Integer.parseInt(jw.get("y").toString()));
					w.setWidth(Integer.parseInt(jw.get("width").toString()));
					w.setHeight(Integer.parseInt(jw.get("height").toString()));
					w.setDir(Integer.parseInt(jw.get("dir").toString()));
					w.setX0(Integer.parseInt(jw.get("x0").toString()));
					w.setY0(Integer.parseInt(jw.get("y0").toString()));
					r.east.windowArray.add(w);
				}
				//r.east.windowArray = windowList;
				
				JSONObject west = (JSONObject) j.get("west");
				r.west.vector = Integer.parseInt(west.get("vector").toString());
				r.west.x = Integer.parseInt(west.get("x").toString());
				r.west.y = Integer.parseInt(west.get("y").toString());
				r.west.width = Integer.parseInt(west.get("width").toString());
				r.west.height = Integer.parseInt(west.get("height").toString());
				JSONArray westwindowList = (JSONArray) west.get("windowArray");
				for(int  k=0; k<westwindowList.size(); k++) {
					JSONObject jw = (JSONObject) westwindowList.get(k);
					Window w = new Window();
					w.setX(Integer.parseInt(jw.get("x").toString()));
					w.setY(Integer.parseInt(jw.get("y").toString()));
					w.setWidth(Integer.parseInt(jw.get("width").toString()));
					w.setHeight(Integer.parseInt(jw.get("height").toString()));
					w.setDir(Integer.parseInt(jw.get("dir").toString()));
					w.setX0(Integer.parseInt(jw.get("x0").toString()));
					w.setY0(Integer.parseInt(jw.get("y0").toString()));
					r.west.windowArray.add(w);
				}
				//r.west.windowArray = westwindowList;
				
				JSONObject north = (JSONObject) j.get("north");
				r.north.vector = Integer.parseInt(north.get("vector").toString());
				r.north.x = Integer.parseInt(north.get("x").toString());
				r.north.y = Integer.parseInt(north.get("y").toString());
				r.north.width = Integer.parseInt(north.get("width").toString());
				r.north.height = Integer.parseInt(north.get("height").toString());
				JSONArray northwindowList = (JSONArray) north.get("windowArray");
				for(int  k=0; k<northwindowList.size(); k++) {
					JSONObject jw = (JSONObject) northwindowList.get(k);
					Window w = new Window();
					w.setX(Integer.parseInt(jw.get("x").toString()));
					w.setY(Integer.parseInt(jw.get("y").toString()));
					w.setWidth(Integer.parseInt(jw.get("width").toString()));
					w.setHeight(Integer.parseInt(jw.get("height").toString()));
					w.setDir(Integer.parseInt(jw.get("dir").toString()));
					w.setX0(Integer.parseInt(jw.get("x0").toString()));
					w.setY0(Integer.parseInt(jw.get("y0").toString()));
					r.north.windowArray.add(w);
				}
				//r.north.windowArray = northwindowList;
				
				JSONObject south = (JSONObject) j.get("south");
				r.south.vector = Integer.parseInt(south.get("vector").toString());
				r.south.x = Integer.parseInt(south.get("x").toString());
				r.south.y = Integer.parseInt(south.get("y").toString());
				r.south.width = Integer.parseInt(south.get("width").toString());
				r.south.height = Integer.parseInt(south.get("height").toString());
				JSONArray southwindowList = (JSONArray) south.get("windowArray");
				for(int  k=0; k<southwindowList.size(); k++) {
					JSONObject jw = (JSONObject) southwindowList.get(k);
					Window w = new Window();
					w.setX(Integer.parseInt(jw.get("x").toString()));
					w.setY(Integer.parseInt(jw.get("y").toString()));
					w.setWidth(Integer.parseInt(jw.get("width").toString()));
					w.setHeight(Integer.parseInt(jw.get("height").toString()));
					w.setDir(Integer.parseInt(jw.get("dir").toString()));
					w.setX0(Integer.parseInt(jw.get("x0").toString()));
					w.setY0(Integer.parseInt(jw.get("y0").toString()));
					r.south.windowArray.add(w);
				}
				//r.west.windowArray = southwindowList;
				
				JSONArray jsondoorList = (JSONArray) j.get("door_list");
				for(int k=0;k<jsondoorList.size();k++) {
					JSONObject doorList = (JSONObject) jsondoorList.get(i);
					Door d = new Door();
					d.setX(Integer.parseInt(doorList.get("x").toString()));
					d.setY(Integer.parseInt(doorList.get("y").toString()));
					d.width = Integer.parseInt(doorList.get("width").toString());
					d.height = Integer.parseInt(doorList.get("height").toString());
					d.x0 = Integer.parseInt(doorList.get("x0").toString());
					d.y0 = Integer.parseInt(doorList.get("y0").toString());
					d.dir = Integer.parseInt(doorList.get("dir").toString());
					r.doorArray.add(d);
				}
				//r.doorArray= jsondoorList;
				
				p.room_list.add(r);
			}
			
		} catch (FileNotFoundException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); 
		} catch (ParseException e) { e.printStackTrace(); 
		}
		return p;
	}
}

