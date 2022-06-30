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
				"\t" + String.valueOf(XcoordForDesignPoint).replace('.', ',') + 
				"\t" + String.valueOf(YcoordForDesignPoint).replace('.', ',') + 
				"\t" + String.valueOf(XcoordForSteakoutPoint).replace('.', ',') +
				"\t" + String.valueOf(YcoordForSteakoutPoint).replace('.', ',') +
			    "\t" + String.valueOf(Math.round((XcoordForDesignPoint - XcoordForSteakoutPoint) * 1000.0) / 1000.0).replace('.', ',') + 
				"\t" + String.valueOf(Math.round((YcoordForDesignPoint - YcoordForSteakoutPoint) * 1000.0) / 1000.0).replace('.', ',');
	}
	
	public String getPointID() {
		return pointID;
	}

	public String getDeltaX() {
		return String.valueOf(Math.round((XcoordForDesignPoint - XcoordForSteakoutPoint) * 1000.0) / 1000.0);
	}
	
	public String getDeltaY() {
		return String.valueOf(Math.round((YcoordForDesignPoint - YcoordForSteakoutPoint) * 1000.0) / 1000.0);
	}
	
}
 