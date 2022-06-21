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
		//pillarCoords.setAngleValueBetweenMainPath(120);
		pillarCoords.calculatePillarPoints();
		WeightBaseDisplayer weightBase = new WeightBaseDisplayer(pillarCoords.getPillarPoints(), "Cs�m�r 58. oszlop");
		weightBase.setDirectionPointId(direction.getPointID());
		 
//		Point center = new Point("T2",730977.3214, 107203.9048);
//		Point direction = new Point("T3", 730998.3140, 107025.1332);
//		PillarCoordsForPlateBase pillarCoords = new PillarCoordsForPlateBase(center, direction);
//		pillarCoords.setHorizontalSizeOfHole(10.5);
//		pillarCoords.setVerticalSizeOfHole(10.5);
//		pillarCoords.setHorizontalDistanceFromTheSideOfHole(10);
//		pillarCoords.setVerticalDistanceFromTheSideOfHole(10);
//		pillarCoords.calculatePillarPoints();
//		PlateBaseDisplayer plateBase = new PlateBaseDisplayer(pillarCoords.getPillarPoints(), "Feto T2 Pillar");
//		plateBase.setDirectionPointId(direction.getPointID());
	}
	
}
