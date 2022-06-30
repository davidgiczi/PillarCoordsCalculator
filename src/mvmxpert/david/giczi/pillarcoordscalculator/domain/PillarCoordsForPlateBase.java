package mvmxpert.david.giczi.pillarcoordscalculator.domain;

import java.util.ArrayList;
import java.util.List;
import javax.management.InvalidAttributeValueException;

public class PillarCoordsForPlateBase {

	private Point pillarCenterPoint;
	private Point axisDirectionPoint;
	private double horizontalSizeOfHole;
	private double verticalSizeOfHole;
	private double horizontalDistanceFromTheSideOfHole;
	private double verticalDistanceFromTheSideOfHole;
	private double rotation = 0;
	private double angleValueBetweenMainPath = 0;
	private double angularMinuteValueBetweenMainPath = 0;
	private double angularSecondValueBetweenMainPath = 0;
	private double radRotation;
	private List<Point> pillarPoints;
	private double azimuth;
	
	
	public PillarCoordsForPlateBase(Point pillarCenterPoint, Point axisDirectionPoint) throws InvalidAttributeValueException {
		this.pillarCenterPoint = pillarCenterPoint;
		this.axisDirectionPoint = axisDirectionPoint;
		AzimuthAndDistance azimuthAndDistance = new AzimuthAndDistance(pillarCenterPoint, axisDirectionPoint);
		this.azimuth = azimuthAndDistance.calcAzimuth();
		if(azimuth == Double.NaN) {
			throw new InvalidAttributeValueException();
		}
	}


	public Point getPillarCenterPoint() {
		return pillarCenterPoint;
	}


	public void setPillarCenterPoint(Point pillarCenterPoint) {
		this.pillarCenterPoint = pillarCenterPoint;
	}


	public Point getAxisDirectionPoint() {
		return axisDirectionPoint;
	}


	public void setAxisDirectionPoint(Point axisDirectionPoint) {
		this.axisDirectionPoint = axisDirectionPoint;
	}


	public double getHorizontalSizeOfHole() {
		return horizontalSizeOfHole;
	}


	public void setHorizontalSizeOfHole(double horizontalSizeOfHole) {
		this.horizontalSizeOfHole = horizontalSizeOfHole;
	}


	public double getVerticalSizeOfHole() {
		return verticalSizeOfHole;
	}


	public void setVerticalSizeOfHole(double verticalSizeOfHole) {
		this.verticalSizeOfHole = verticalSizeOfHole;
	}


	public double getHorizontalDistanceFromTheSideOfHole() {
		return horizontalDistanceFromTheSideOfHole;
	}


	public void setHorizontalDistanceFromTheSideOfHole(double horizontalDistanceFromTheSideOfHole) {
		this.horizontalDistanceFromTheSideOfHole = horizontalDistanceFromTheSideOfHole;
	}


	public double getVerticalDistanceFromTheSideOfHole() {
		return verticalDistanceFromTheSideOfHole;
	}


	public void setVerticalDistanceFromTheSideOfHole(double verticalDistanceFromTheSideOfHole) {
		this.verticalDistanceFromTheSideOfHole = verticalDistanceFromTheSideOfHole;
	}


	public double getRotation() {
		return rotation;
	}


	public void setRotation(double rotation) {
		this.rotation = rotation;
	}


	public double getAngleValueBetweenMainPath() {
		return angleValueBetweenMainPath;
	}


	public void setAngleValueBetweenMainPath(double angleValueBetweenMainPath) {
		this.angleValueBetweenMainPath = angleValueBetweenMainPath;
	}


	public double getAngularMinuteValueBetweenMainPath() {
		return angularMinuteValueBetweenMainPath;
	}


	public void setAngularMinuteValueBetweenMainPath(double angularMinuteValueBetweenMainPath) {
		this.angularMinuteValueBetweenMainPath = angularMinuteValueBetweenMainPath;
	}


	public double getAngularSecondValueBetweenMainPath() {
		return angularSecondValueBetweenMainPath;
	}


	public void setAngularSecondValueBetweenMainPath(double angularSecondValueBetweenMainPath) {
		this.angularSecondValueBetweenMainPath = angularSecondValueBetweenMainPath;
	}
	
	public List<Point> getPillarPoints() {
		return pillarPoints;
	}
	

	public double getRadRotation() {
		return radRotation;
	}


	public void calculatePillarPoints() {
		this.pillarPoints = new ArrayList<>();
		pillarPoints.add(pillarCenterPoint);
		calculatePointsOfTheHole();
		calculateAxisPoints();
		calcRadRotation();
		rotatePillarCoords();
	}
	
	private void calculatePointsOfTheHole() {
		PolarPoint slave1 = new PolarPoint(pillarCenterPoint, 
				horizontalSizeOfHole / 2, azimuth, null);
		PolarPoint slave2 = new PolarPoint(pillarCenterPoint, 
				horizontalSizeOfHole / 2, azimuth + Math.PI, null);
		PolarPoint point1 = new PolarPoint(slave1.calcPolarPoint(), 
				verticalSizeOfHole / 2, azimuth -  Math.PI / 2, pillarCenterPoint.getPointID() + "_1");
		PolarPoint point2 = new PolarPoint(slave1.calcPolarPoint(), 
				verticalSizeOfHole / 2, azimuth + Math.PI / 2, pillarCenterPoint.getPointID() + "_2");
		PolarPoint point3 = new PolarPoint(slave2.calcPolarPoint(), 
				verticalSizeOfHole / 2, azimuth + Math.PI / 2, pillarCenterPoint.getPointID() + "_3");
		PolarPoint point4 = new PolarPoint(slave2.calcPolarPoint(), 
				verticalSizeOfHole / 2, azimuth - Math.PI / 2, pillarCenterPoint.getPointID() + "_4");
		pillarPoints.add(point1.calcPolarPoint());
		pillarPoints.add(point2.calcPolarPoint());
		pillarPoints.add(point3.calcPolarPoint());
		pillarPoints.add(point4.calcPolarPoint());
	}
	
	private void calculateAxisPoints() {
		PolarPoint point5 = new PolarPoint(pillarCenterPoint, 
				verticalSizeOfHole / 2 + verticalDistanceFromTheSideOfHole, 
				azimuth - Math.PI / 2, pillarCenterPoint.getPointID() + "_5");
		PolarPoint point6 = new PolarPoint(pillarCenterPoint, 
				horizontalSizeOfHole / 2 + horizontalDistanceFromTheSideOfHole, 
				azimuth, pillarCenterPoint.getPointID() + "_6");
		PolarPoint point7 = new PolarPoint(pillarCenterPoint, 
				verticalSizeOfHole / 2 + verticalDistanceFromTheSideOfHole, 
				azimuth + Math.PI / 2, pillarCenterPoint.getPointID() + "_7");
		PolarPoint point8 = new PolarPoint(pillarCenterPoint, 
				horizontalSizeOfHole / 2 + horizontalDistanceFromTheSideOfHole, 
				azimuth + Math.PI, pillarCenterPoint.getPointID() + "_8");
		pillarPoints.add(point5.calcPolarPoint());
		pillarPoints.add(point6.calcPolarPoint());
		pillarPoints.add(point7.calcPolarPoint());
		pillarPoints.add(point8.calcPolarPoint());
	}
	
	private void calcRadRotation() {
		
		 if(angleValueBetweenMainPath != 0 || 
					angularMinuteValueBetweenMainPath != 0 || 
							angularSecondValueBetweenMainPath != 0) {
				
			radRotation = Math.toRadians((180 - (angleValueBetweenMainPath + 
								angularMinuteValueBetweenMainPath / 60 + 
								angularSecondValueBetweenMainPath / 3600)) / 2);
			return;
		}
		 
		 radRotation = Math.toRadians(rotation);
	}
	
	private void rotatePillarCoords() {
		
		for (int i = 1; i < pillarPoints.size(); i++) {
			double rotated_x = (pillarPoints.get(i).getX_coord() - pillarPoints.get(0).getX_coord()) * Math.cos(radRotation) - 
						(pillarPoints.get(i).getY_coord() - pillarPoints.get(0).getY_coord()) * Math.sin(radRotation);
			double rotated_y = (pillarPoints.get(i).getX_coord() - pillarPoints.get(0).getX_coord()) * Math.sin(radRotation) +
						(pillarPoints.get(i).getY_coord() - pillarPoints.get(0).getY_coord()) * Math.cos(radRotation);
			pillarPoints.get(i)
			.setX_coord(Math.round((pillarPoints.get(0).getX_coord() + rotated_x) * 1000.0) / 1000.0);
			pillarPoints.get(i)
			.setY_coord(Math.round((pillarPoints.get(0).getY_coord() + rotated_y) * 1000.0) / 1000.0);
	}
}


}
