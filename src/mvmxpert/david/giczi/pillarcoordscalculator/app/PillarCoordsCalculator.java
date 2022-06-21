package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForPlateBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PlateBaseDisplayer;

public class PillarCoordsCalculator {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
		
//		Point center = new Point("1", 100, 100);
//		Point direction = new Point("2", 200, 100);
//		PillarCoordsForWeightBase pillarCoords = new PillarCoordsForWeightBase(center, direction);
//		pillarCoords.setDistanceOnTheAxis(10);
//		pillarCoords.setHorizontalDistanceBetweenPillarLegs(5);
//		pillarCoords.setVerticalDistanceBetweenPillarLegs(5);
//		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(1);
//		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(1);
//		pillarCoords.calculatePillarPoints();
//		FileProcess file = new FileProcess("RotateTest");
//		file.saveDataForKML(pillarCoords.getPillarPoints().get(0));
//		file.saveDataForRTK(pillarCoords.getPillarPoints());
//		file.saveDataForTPS(pillarCoords.getPillarPoints());
		
		Point center = new Point("T2",730977.3214, 107203.9048);
		Point direction = new Point("T3", 730998.3140, 107025.1332);
		PillarCoordsForPlateBase pillarCoords = new PillarCoordsForPlateBase(center, direction);
		pillarCoords.setHorizontalSizeOfHole(20.5);
		pillarCoords.setVerticalSizeOfHole(20.5);
		pillarCoords.setHorizontalDistanceFromTheSideOfHole(10);
		pillarCoords.setVerticalDistanceFromTheSideOfHole(10);
		pillarCoords.calculatePillarPoints();
		PlateBaseDisplayer plateBase = new PlateBaseDisplayer(pillarCoords.getPillarPoints(), "Feto T2 Pillar");
		plateBase.setDirectionPointId(direction.getPointID());
	}
	
}
