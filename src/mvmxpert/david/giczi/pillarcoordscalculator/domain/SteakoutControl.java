package mvmxpert.david.giczi.pillarcoordscalculator.domain;

import java.util.ArrayList;
import java.util.List;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.enums.Point;


public class SteakoutControl {

	
	private List<Point> designedPillarCoords;
	private Enum typeOfPointID;
	private String typeOfPointIDValue;
	private String delimiter;
	private List<SteakoutCoords> controlledCoords;
	private int NUMBER_OF_STEAKOUTED_POINTS_FOR_WEIGHT_BASE = 25;
	private int NUMBER_OF_STEAKOUTED_POINTS_FOR_PLATE_BASE = 9;
	
	public SteakoutControl(List<Point> designedPillarCoords, Enum typeOfPointID, String typeOfPointIDValue, String delimiter) {
		this.designedPillarCoords = designedPillarCoords;
		this.typeOfPointID = typeOfPointID;
		this.typeOfPointIDValue = typeOfPointIDValue;
		this.delimiter = delimiter;
	}
	
	public void controlSteakoutForWeightBase() {
		controlledCoords = new ArrayList<>();
		for(int i = 0; i < NUMBER_OF_STEAKOUTED_POINTS_FOR_WEIGHT_BASE; i++) {
			controlledCoords.add(null);
		}
		List<String> steakoutedData = FileProcess.getSteakoutPointsData();
		for(int i = 0; i < designedPillarCoords.size(); i++) {
			for(int y = 0; y < steakoutedData.size(); y++) {
				
			}
		}
		
	}
	
	public void controlSteakoutForPlateBase() {
		controlledCoords = new ArrayList<>();
	}
	
//	private String getPointIdentifier(int i) {
//		if(typeOfPointID == Point.POINT_ID) {
//			return String.valueOf(i);
//		}
//		else if(typeOfPointID == Point.PREFIX) {
//			return typeOfPointIDValue + 
//		}
//		else if(typeOfPointID == Point.POSTFIX) {
//			
//		}
//	}
	
}
