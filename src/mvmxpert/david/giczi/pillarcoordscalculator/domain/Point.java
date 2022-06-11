package mvmxpert.david.giczi.pillarcoordscalculator.domain;

public class Point {

	private String pointID;
	private double x_coord;
	private double y_coord;
	
	
	public Point(String pointID, double x_coord, double y_coord) {

		this.pointID = pointID;
		this.x_coord = x_coord;
		this.y_coord = y_coord;
	}


	public String getPointID() {
		return pointID;
	}


	public double getX_coord() {
		return x_coord;
	}


	public double getY_coord() {
		return y_coord;
	}


	@Override
	public String toString() {
		return "Point [pointID=" + pointID + ", x_coord=" + x_coord + ", y_coord=" + y_coord + "]";
	}
	
}
