package mvmxpert.david.giczi.pillarcoordscalculator.domain;

import java.util.List;


public class SteakoutControl {

	
	private List<Point> pillarCoords;
	private Enum typeOfpointID;
	private String typeOfpointIDValue;
	private String delimiter;
	
	
	public SteakoutControl(List<Point> pillarCoords, Enum typeOfpointID, String typeOfpointIDValue, String delimiter) {
		this.pillarCoords = pillarCoords;
		this.typeOfpointID = typeOfpointID;
		this.typeOfpointIDValue = typeOfpointIDValue;
		this.delimiter = delimiter;
	}
	
	
	
	
}
