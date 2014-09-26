package dev.foursix.test.uncategorized;
import java.awt.Point;


public class MovingPoint {
	private Point currentPoint = new Point();
	private double distanceMoved = 0.0;
	
	//	�̷��� �Ӽ��� �ٲ� �� �ִ� �޼ҵ带 Mutator ��� �Ѵ�
	//	Mutator �� ���� setXXX �� ����� ���Ѵ�.
	public void move(int dx, int dy) {
		distanceMoved += Math.sqrt(dx * dx + dy * dy);
		currentPoint.translate(dx, dy);
	}
	
	//	�̷��� �Ӽ��� �˾Ƴ��� �޼ҵ带 Accessor ��� �Ѵ�
	//	Accessor �� ���� getXXX �� ����� ���Ѵ�.
	public Point getCurrentPoint() {
		return currentPoint;
	}
	
	//	�� �ϳ��� Accessor
//	public double getDistanceMoved() {
//		return distanceMoved;
	public Point getDistanceMoved() {
		return new Point(currentPoint);
	}
	
	public void showInformation() {
		System.out.println("currentPoint = (" + currentPoint.x + "," + currentPoint.y + ") distanceMoved = " + distanceMoved);
	}

}
