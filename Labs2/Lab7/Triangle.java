
import java.awt.*;

public class Triangle extends Shape {
  // Instance variable
  private int size;

  // Constructor
  public Triangle(int x, int y, Color color, int size)
  {
    super(x, y, color);
    this.size = size;
  }

  // Instance methods
  public void draw(Graphics g) {
    g.setColor(getColor());
    int height = getHeight();
    int[] xCoordinates = {getX(), getX() + size / 2, getX() + size};
    int[] yCoordinates = {getY() + height, getY(), getY() + height};
    g.fillPolygon(xCoordinates, yCoordinates, 3);
  }

  public int getHeight() {
    return (int) (Math.sqrt((3.0 * size * size) / 4));
  }

  public int getWidth() {
    return size;
  }
	public void scale(double factor)
	{
		size = (int)(factor*size);
	}
	public double area()
	{
		double area = ((1.732/4) * (size*size));
		return area;
	}
	public String toString()
	{
		return super.toString() + "\nSide: " + this.getWidth();
	}
}
