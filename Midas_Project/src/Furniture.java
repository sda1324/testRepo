import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Furniture {

	private float width;
	private float height;
	private String name;
	private Color color;
	private Image image;
	
	public void SetImage(Image image)
	{
		this.image = image;
	}
	public Image GetImage()
	{
		return image;
	}
	public Color GetColor()
	{
		return color;
	}
	public void SetColor(Color color)
	{
		this.color = color;
	}
	public String GetName()
	{
		return name;
	}
	public void SetName(String name)
	{
		this.name = name;
	}
	public float GetWidth()
	{
		return width;
	}
	public void SetWidth(float width)
	{
		this.width = width;
	}
	public float GetHeight()
	{
		return height;
	}
	public void SetHeight(float height)
	{
		this.height = height;
	}
}
