package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForPlateBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForWeightBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PlateBaseDisplayer;
import mvmxpert.david.giczi.pillarcoordscalculator.view.WeightBaseDisplayer;

public class PillarCoordsCalculator {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
		
		Point center = new Point("58", 659249.8588, 246111.5408);
		Point direction = new Point("57", 659430.3941, 246392.9943);
		PillarCoordsForWeightBase pillarCoords = new PillarCoordsForWeightBase(center, direction);
		pillarCoords.setDistanceOnTheAxis(10);
		pillarCoords.setHorizontalDistanceBetweenPillarLegs(7);
		pillarCoords.setVerticalDistanceBetweenPillarLegs(7);
		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(4);
		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(4);
		//pillarCoords.setAngleValueBetweenMainPath(160);
		pillarCoords.calculatePillarPoints();
		new WeightBaseDisplayer(pillarCoords.getPillarPoints(),
								pillarCoords.getAxisDirectionPoint(),
								pillarCoords.getRadRotation(),
								"Csömör 58. oszlop");
		
		 
//		Point center = new Point("T11", 731288.2036, 105251.3606);
//		Point direction = new Point("T12", 731077.8079, 105128.6198);
//		PillarCoordsForPlateBase pillarCoords = new PillarCoordsForPlateBase(center, direction);
//		pillarCoords.setHorizontalSizeOfHole(8.6);
//		pillarCoords.setVerticalSizeOfHole(8.6);
//		pillarCoords.setHorizontalDistanceFromTheSideOfHole(6);
//		pillarCoords.setVerticalDistanceFromTheSideOfHole(6);
//		pillarCoords.setAngleValueBetweenMainPath(0);
//		pillarCoords.calculatePillarPoints();
//		new PlateBaseDisplayer(pillarCoords.getPillarPoints(), 
//									   pillarCoords.getAxisDirectionPoint(),
//									   pillarCoords.getRadRotation(),
//									   "FETO T6-T12 Pillars");
//		fileprocess file = new fileprocess("feto t6-t12 oszlopok");
//		file.savedataforkml(pillarcoords.getpillarcenterpoint());
//		file.savedataforms(pillarcoords.getpillarpoints());
//		file.savedataforrtk(pillarcoords.getpillarpoints());
//		file.savedatafortps(pillarcoords.getpillarpoints());
		

	}
	
}
