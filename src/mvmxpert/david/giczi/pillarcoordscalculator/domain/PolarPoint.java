package mvmxpert.david.giczi.pillarcoordscalculator.domain;


public class PolarPoint {

	private Point pointA;
	private double distance;
	private double azimuth;
	private String newPointID;
	
	
	public PolarPoint(Point pointA, double distance, double azimuth, String newPointID) {
		this.pointA = pointA;
		this.distance = distance;
		this.azimuth = azimuth;
		this.newPointID = newPointID;
	}

	public Point calcPolarPoint() {
		
		double newPointX = pointA.getX_coord() + Math.sin(azimuth) * distance;
		double newPointY = pointA.getY_coord() + Math.cos(azimuth) * distance;
		return new Point(newPointID, 
				Math.round(newPointX * 1000.0) / 1000.0,
				Math.round(newPointY * 1000.0) / 1000.0);
	}

	public Point getPointA() {
		return pointA;
	}


	public double getDistance() {
		return distance;
	}


	public double getAzimuth() {
		return azimuth;
	}

	public String getNewPointID() {
		return newPointID;
	}
	
	
}
