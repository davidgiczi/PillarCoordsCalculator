package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForPlateBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PillarBaseDisplayer;

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
		
		Point center = new Point("T1", 730910.9748, 107338.4341);
		Point direction = new Point("T2", 730977.3214, 107203.9048);
		PillarCoordsForPlateBase pillarCoords = new PillarCoordsForPlateBase(center, direction);
		pillarCoords.setHorizontalSizeOfHole(11.8);
		pillarCoords.setVerticalSizeOfHole(11.8);
		pillarCoords.setHorizontalDistanceFromTheSideOfHole(6);
		pillarCoords.setVerticalDistanceFromTheSideOfHole(6);
		pillarCoords.calculatePillarPoints();
		FileProcess file = new FileProcess("T1");		
		file.saveDataForKML(pillarCoords.getPillarPoints().get(0));
		file.saveDataForRTK(pillarCoords.getPillarPoints());
		new PillarBaseDisplayer(pillarCoords.getPillarPoints(), "Feto T1 Pillar");
	}
	
}
