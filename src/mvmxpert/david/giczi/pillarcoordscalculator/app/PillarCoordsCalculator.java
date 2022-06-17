package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForWeightBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;

public class PillarCoordsCalculator {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
		
		Point center = new Point("1", 100, 100);
		Point direction = new Point("2", 200, 100);
		PillarCoordsForWeightBase pillarCoords = new PillarCoordsForWeightBase(center, direction);
		pillarCoords.setDistanceOnTheAxis(10);
		pillarCoords.setHorizontalDistanceBetweenPillarLegs(5);
		pillarCoords.setVerticalDistanceBetweenPillarLegs(5);
		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(1);
		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(1);
		pillarCoords.calculatePillarPoints();
		FileProcess file = new FileProcess("RotateTest");
		file.saveDataForKML(pillarCoords.getPillarPoints().get(0));
		file.saveDataForRTK(pillarCoords.getPillarPoints());
		file.saveDataForTPS(pillarCoords.getPillarPoints());
	}
	
}
