package mvmxpert.david.giczi.pillarcoordscalculator.domain;

public class SteakoutCoords {

	
	private String pointID;
	private double XcoordForDesignPoint;
	private double YcoordForDesignPoint;
	private double XcoordForSteakoutPoint;
	private double YcoordForSteakoutPoint;
	

	public SteakoutCoords(String pointID, double xcoordForDesignPoint, double ycoordForDesignPoint,
			double xcoordForSteakoutPoint, double ycoordForSteakoutPoint) {
		this.pointID = pointID;
		XcoordForDesignPoint = xcoordForDesignPoint;
		YcoordForDesignPoint = ycoordForDesignPoint;
		XcoordForSteakoutPoint = xcoordForSteakoutPoint;
		YcoordForSteakoutPoint = ycoordForSteakoutPoint;
	}

	public String getSteakoutedPointData() {
		return pointID + 
				" " + String.valueOf(XcoordForDesignPoint).replace('.', ',') + 
				" " + String.valueOf(YcoordForDesignPoint).replace('.', ',') + 
				" " + String.valueOf(XcoordForSteakoutPoint).replace('.', ',') +
				" " + String.valueOf(YcoordForSteakoutPoint).replace('.', ',') +
			    " " + String.valueOf(Math.round((XcoordForDesignPoint - XcoordForSteakoutPoint) * 1000.0) / 1000.0).replace('.', ',') + 
				" " + String.valueOf(Math.round((YcoordForDesignPoint - YcoordForSteakoutPoint) * 1000.0) / 1000.0).replace('.', ',');
	}
	
	
}
 