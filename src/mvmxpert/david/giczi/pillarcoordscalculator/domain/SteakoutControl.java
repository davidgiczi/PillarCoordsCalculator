package mvmxpert.david.giczi.pillarcoordscalculator.domain;

import java.util.ArrayList;
import java.util.List;

import mvmxpert.david.giczi.pillarcoordscalculator.enumerator.PointID;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;

public class SteakoutControl {

	private List<Point> designedPillarCoords;
	private Enum<PointID> pointID;
	private String pointIDValue;
	private String delimiter;
	private List<SteakoutCoords> controlledCoords;
	
	public SteakoutControl(List<Point>
	designedPillarCoords, PointID pointID, String pointIDValue, String delimiter) {
		this.designedPillarCoords = designedPillarCoords;
		this.pointID = pointID;
		this.pointIDValue = pointIDValue;
		this.delimiter = delimiter;
	}
	
	public void controlSteakout() {
		controlledCoords = new ArrayList<>();
		List<String> steakoutedPointData = FileProcess.getSteakoutedPointData();
		for (String controlData : steakoutedPointData) { 
			String[] data = controlData.split(delimiter);
			for(Point designedCoords : designedPillarCoords) {
				if(getPointIdentifier(designedCoords.getPointID()).equals(data[0])) {
					SteakoutCoords controlPoint = 
							new SteakoutCoords(designedCoords.getPointID(), 
									designedCoords.getX_coord(),
									designedCoords.getY_coord(), 
									Double.parseDouble(data[1]),
									Double.parseDouble(data[2]));
					FileProcess.saveSteakoutPoint(controlPoint.getSteakoutedPointData());
					controlledCoords.add(controlPoint);
				}
			}
		}
	}
	
	private String getPointIdentifier(String pointNumber) {
		
		String identifier = pointNumber;
		
		if(pointID == PointID.PREFIX) {
		identifier = pointIDValue + identifier;
		}
		else if(pointID == PointID.POSTFIX) {
		identifier = identifier + pointIDValue;
		}
		
		return identifier;
	}
	
}
