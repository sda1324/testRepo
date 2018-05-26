import java.awt.Image;

import javax.swing.ImageIcon;

import javafx.scene.paint.Color;

public class Furniture {

	private int width;
	private int height;
	private String name;
	private Color color;
	private ImageIcon imageicon;
	
	public Furniture (int width, int height, String name) {
		this.width = width;
		this.height = height;
		this.name = name;
	}
	
	public ImageIcon getImage() {
		this.imageicon = imageicon;  
		Image originImg = this.imageicon.getImage(); 
		Image changedImg= originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH );
		ImageIcon icon = new ImageIcon(changedImg);
		return icon;
	}
	
	public void setImage(ImageIcon imageicon)
	{
		this.imageicon = imageicon;
	}
	public Color getColor()
	{
		return color;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public float getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public float getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
}
