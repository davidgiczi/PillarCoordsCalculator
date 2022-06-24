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

	public String savePoint() {
		return pointID + 
				" " + XcoordForDesignPoint + " " + YcoordForDesignPoint + 
						 " " + XcoordForSteakoutPoint + " " + YcoordForSteakoutPoint +
						 " " + (XcoordForDesignPoint - XcoordForSteakoutPoint) + 
						 " " + (YcoordForDesignPoint - YcoordForSteakoutPoint);
	}
	
}
 