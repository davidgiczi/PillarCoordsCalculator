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
		
//		FileProcess.projectName = "Paks-Sándorfalva_20_oszlop_kit";
//		FileProcess.setFolder();
//		Point center = new Point("20", 637171.14, 128910.0);
//		Point direction = new Point("21", 637282.9494, 128524.4136);
//		PillarCoordsForWeightBase pillarCoords = new PillarCoordsForWeightBase(center, direction);
//		pillarCoords.setDistanceOnTheAxis(10);
//		pillarCoords.setHorizontalDistanceBetweenPillarLegs(6.08);
//		pillarCoords.setVerticalDistanceBetweenPillarLegs(7.6);
//		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(4);
//		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(4);
//		pillarCoords.setAngleValueBetweenMainPath(90);
//		pillarCoords.calculatePillarPoints();
//		FileProcess.saveDataForKML(center);
//		FileProcess.saveDataForRTK(pillarCoords.getPillarPoints());
//		FileProcess.saveDataForTPS(pillarCoords.getPillarPoints());
//		FileProcess.saveDataForMS(pillarCoords.getPillarPoints());
//		FileProcess.setSteakoutFile();
//		SteakoutControl stk = new SteakoutControl(pillarCoords.getPillarPoints(), PointID.POSTFIX, "_STK", ";");
//		stk.controlSteakout();
//		WeightBaseDisplayer displayer = new WeightBaseDisplayer(pillarCoords.getPillarPoints(),
//								pillarCoords.getAxisDirectionPoint(),
//								pillarCoords.getRadRotation(),
//								FileProcess.projectName);
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
//		PlateBaseDisplayer displayer = new PlateBaseDisplayer(pillarCoords.getPillarPoints(), 
//									   pillarCoords.getAxisDirectionPoint(),
//									   pillarCoords.getRadRotation(),
//									   "FETO T6-T9 Pillars");
//		displayer.setControlledCoords(stk.getControlledCoords());
	}
	
}
