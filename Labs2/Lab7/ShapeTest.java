import java.util.*;
import java.awt.*;

public class ShapeTest
{
	public static void main(String[] args)
	{
	//	Shape s = new Shape(0, 0, Color.red);
		Color testColor = new Color(10, 20, 30);
		Circle testCircle = new Circle(0, 0, testColor, 5);
		Rectangle testRect = new Rectangle(0, 0, testColor, 2, 3);
		Triangle testTri = new Triangle(0, 0,testColor, 5);
		System.out.println(testCircle);
		System.out.println(testRect);
		System.out.println(testTri);
		testCircle.scale(5.0);
		testRect.scale(5.0);
		testTri.scale(5.0);
		System.out.println(testCircle);
		System.out.println(testRect);
		System.out.println(testTri);
		System.out.println(testCircle.area());
		System.out.println(testRect.area());
		System.out.println(testTri.area());
	}
}
