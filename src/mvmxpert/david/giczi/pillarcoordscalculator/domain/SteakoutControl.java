package mvmxpert.david.giczi.pillarcoordscalculator.domain;

import java.util.ArrayList;
import java.util.List;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.enums.PointID;

public class SteakoutControl {

	private List<mvmxpert.david.giczi.pillarcoordscalculator.domain.Point> designedPillarCoords;
	private Enum<PointID> pointID;
	private String pointIDValue;
	private String delimiter;
	private List<SteakoutCoords> controlledCoords;
	private int NUMBER_OF_STEAKOUTED_POINTS_FOR_WEIGHT_BASE = 25;
	private int NUMBER_OF_STEAKOUTED_POINTS_FOR_PLATE_BASE = 9;
	
	public SteakoutControl(List<Point>
	designedPillarCoords, PointID pointID, String pointIDValue, String delimiter) {
		this.designedPillarCoords = designedPillarCoords;
		this.pointID = pointID;
		this.pointIDValue = pointIDValue;
		this.delimiter = delimiter;
	}
	
	public void controlSteakoutForWeightBase() {
		controlledCoords = new ArrayList<>();
		for(int i = 0; i < NUMBER_OF_STEAKOUTED_POINTS_FOR_WEIGHT_BASE; i++) {
			controlledCoords.add(null);
		}
		List<String> steakoutedPointData = FileProcess.getSteakoutedPointData();
		for (String controlData : steakoutedPointData) { 
			String[] data = controlData.split(delimiter);
			for(int i = 0; i < designedPillarCoords.size(); i++) {
				if(getPointIdentifier(designedPillarCoords.get(i).getPointID()).equals(data[0])) {
					SteakoutCoords controlPoint = 
							new SteakoutCoords(designedPillarCoords.get(i).getPointID(), 
									designedPillarCoords.get(i).getX_coord(),
									designedPillarCoords.get(i).getY_coord(), 
									Double.parseDouble(data[1]),
									Double.parseDouble(data[2]));
					FileProcess.saveSteakoutPoint(controlPoint.getSteakoutedPointData());
					controlledCoords.set(i, controlPoint);
				}
			}
		}
	}
	
	public void controlSteakoutForPlateBase() {
		controlledCoords = new ArrayList<>();
		for(int i = 0; i < NUMBER_OF_STEAKOUTED_POINTS_FOR_PLATE_BASE; i++) {
			controlledCoords.add(null);
		}
		List<String> steakoutedPointData = FileProcess.getSteakoutedPointData();
		for (String controlData : steakoutedPointData) { 
			String[] data = controlData.split(delimiter);
			for(int i = 0; i < designedPillarCoords.size(); i++) {
				if(getPointIdentifier(designedPillarCoords.get(i).getPointID()).equals(data[0])) {
					SteakoutCoords controlPoint = 
							new SteakoutCoords(designedPillarCoords.get(i).getPointID(), 
									designedPillarCoords.get(i).getX_coord(),
									designedPillarCoords.get(i).getY_coord(), 
									Double.parseDouble(data[1]),
									Double.parseDouble(data[2]));
					FileProcess.saveSteakoutPoint(controlPoint.getSteakoutedPointData());
					controlledCoords.set(i, controlPoint);
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
