import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.scene.paint.Color;

public class SaveData {
	
	public void save(Project p) {
		JSONObject projectInfo = new JSONObject();
		
		projectInfo.put("width", p.getWidth());
		projectInfo.put("height", p.getWidth());
		
		projectInfo.put("basic_x", p.getBasic_x());
		projectInfo.put("basic_y", p.getBasic_y());
		
		JSONObject furnitureObject = new JSONObject(); 
		JSONArray furnitureList = new JSONArray(); 
		
		for(Furniture f : p.getFurniture_list()) {
			furnitureObject.put("width", f.getWidth() );
			furnitureObject.put("height", f.getHeight());
			furnitureObject.put("name", f.getName());
			furnitureObject.put("color", f.getColor());
			furnitureObject.put("imageicon", f.getImage());
			furnitureObject.put("x", f.getX());
			furnitureObject.put("y", f.getY());
			furnitureList.add(furnitureObject);
		}
		projectInfo.put("furnitureList", furnitureList);
		
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

			JSONArray JSONfurnitureList = (JSONArray) jsonObject.get("furnitureList");
			for(int i=0;i<JSONfurnitureList.size();i++) {
				JSONObject j = (JSONObject) JSONfurnitureList.get(i);
				Furniture f = new Furniture();
				f.setWidth(Integer.parseInt(j.get("width").toString()));
				f.setHeight(Integer.parseInt(j.get("height").toString()));
				f.setName((String)j.get("name"));
				f.setColor((Color) j.get("color"));
				f.setImage((ImageIcon) j.get("imageicon"));
				f.setX(Integer.parseInt(j.get("x").toString()));
				f.setY(Integer.parseInt(j.get("y").toString()));
				
			}
			
		} catch (FileNotFoundException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); 
		} catch (ParseException e) { e.printStackTrace(); 
		}
			

		return p;
	}
}

