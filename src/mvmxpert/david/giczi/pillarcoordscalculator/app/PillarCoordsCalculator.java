package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoords;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;

public class PillarCoordsCalculator {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
		Point center = new Point("58", 659249.8588, 246111.5408);
		Point direction = new Point("57", 659430.3941, 246392.9943);
		PillarCoords pillarCoords = new PillarCoords(center, direction);
		pillarCoords.setDistanceOnTheAxis(10);
		pillarCoords.setHorizontalDistanceBetweenPillarLegs(7);
		pillarCoords.setVerticalDistanceBetweenPillarLegs(7);
		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(4);
		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(4);
		pillarCoords.calculatePillarPoints();
		FileProcess file = new FileProcess("Csomor_58_oszlop_kit");
		file.saveDataForKML(pillarCoords.getPillarPoints().get(0));
		file.saveDataForRTK(pillarCoords.getPillarPoints());
		file.saveDataForTPS(pillarCoords.getPillarPoints());
	}
	
}
