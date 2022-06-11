package mvmxpert.david.giczi.pillarcoordscalculator.domain;


public class AzimuthAndDistance {
	
	private Point pointA;
	private Point pointB;
	
	public AzimuthAndDistance(Point pointA, Point pointB) {	
		this.pointA = pointA;
		this.pointB = pointB;
	}
	
	public double calcAzimuthFromPointAToPointB() {
		
		double deltaX = pointB.getX_coord() - pointA.getX_coord();
		double deltaY = pointB.getY_coord() - pointA.getY_coord();
		
		if( deltaX >= 0 && deltaY > 0) {
			return Math.atan(deltaX / deltaY);
		}
		else if(deltaX >= 0 &&  0 > deltaY) {
			return Math.PI - Math.atan(deltaX / Math.abs(deltaY));
		}
		else if(0 >= deltaX && 0 > deltaY) {
			return Math.PI + Math.atan(Math.abs(deltaX) / Math.abs(deltaY));
		}
		else if(0 >= deltaX && deltaY > 0) {
			return 2 * Math.PI - Math.atan(Math.abs(deltaX) / deltaY);
		}
		
		return Double.NaN;
	}
	
	public double calcDistanceBetweenTheTwoPoints() {
		return Math.sqrt(Math.pow(pointA.getX_coord() - pointB.getX_coord(), 2)
				+ Math.pow(pointA.getY_coord() - pointB.getY_coord(), 2));
	}

	public Point getPointA() {
		return pointA;
	}

	public Point getPointB() {
		return pointB;
	}
	
	
}
