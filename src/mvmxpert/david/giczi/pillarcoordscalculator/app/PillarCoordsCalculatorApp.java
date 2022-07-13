package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;

import mvmxpert.david.giczi.pillarcoordscalculator.controller.PillarCoordsCalculatorController;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForPlateBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForWeightBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.SteakoutControl;
import mvmxpert.david.giczi.pillarcoordscalculator.enumerator.PointID;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PlateBaseDisplayer;
import mvmxpert.david.giczi.pillarcoordscalculator.view.WeightBaseDisplayer;

public class PillarCoordsCalculatorApp {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
		
		new PillarCoordsCalculatorController();
		
	
//
//		FileProcess.projectName = "Paks_43_oszlop";
//		FileProcess.setFolder();
//		Point center = new Point("43", 636057.220, 132220.455);
//		Point direction = new Point("44", 636140.474, 131932.424);
//		PillarCoordsForWeightBase pillarCoords = new PillarCoordsForWeightBase(center, direction);
//		pillarCoords.setDistanceOnTheAxis(7);
//		pillarCoords.setHorizontalDistanceBetweenPillarLegs(4.26);
//		pillarCoords.setVerticalDistanceBetweenPillarLegs(4.88);
//		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(2);
//		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(2);
//		pillarCoords.setAngleValueBetweenMainPath(90);
//		pillarCoords.calculatePillarPoints();
//		FileProcess.setSteakoutFile();
//		SteakoutControl stk = new SteakoutControl(pillarCoords.getPillarPoints(), PointID.POSTFIX, "_STK", ";");
//		stk.controlSteakout();
//		WeightBaseDisplayer displayer = new WeightBaseDisplayer(pillarCoords.getPillarPoints(),
//								pillarCoords.getAxisDirectionPoint(),
//								pillarCoords.getRadRotation(),
//								"Paks 43. oszlop");
//		displayer.setControlledCoords(stk.getControlledCoords());
		
		
//		FileProcess.projectName = "FETO_T6-T9_oszlop";
//		FileProcess.setFolder();
//		Point center = new Point("T9", 731397.828, 105698.180);
//		Point direction = new Point("T10", 731504.144, 105377.336);
//		PillarCoordsForPlateBase pillarCoords = new PillarCoordsForPlateBase(center, direction);
//		pillarCoords.setHorizontalSizeOfHole(9.1);
//		pillarCoords.setVerticalSizeOfHole(9.1);
//		pillarCoords.setHorizontalDistanceFromTheSideOfHole(6);
//		pillarCoords.setVerticalDistanceFromTheSideOfHole(6);
//		//pillarCoords.setAngleValueBetweenMainPath(120);
//		pillarCoords.calculatePillarPoints();
//		FileProcess.setSteakoutFile();
//		SteakoutControl stk = new SteakoutControl(pillarCoords.getPillarPoints(), PointID.POSTFIX, "_STK", ";");
//		stk.controlSteakout();
//		PlateBaseDisplayer displayer =new PlateBaseDisplayer(pillarCoords.getPillarPoints(), 
//									   pillarCoords.getAxisDirectionPoint(),
//									   pillarCoords.getRadRotation(),
//									   "FETO T6-T9 Pillars");
//		displayer.setControlledCoords(stk.getControlledCoords());
	}
	
}
