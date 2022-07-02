package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForPlateBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForWeightBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.SteakoutControl;
import mvmxpert.david.giczi.pillarcoordscalculator.enumerator.PointID;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PlateBaseDisplayer;
import mvmxpert.david.giczi.pillarcoordscalculator.view.WeightBaseDisplayer;

public class PillarCoordsCalculator {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
//		FileProcess.projectName = "Paks_43_oszlop";
//		FileProcess.setFolder();
		Point center = new Point("43", 636057.220, 132220.455);
		Point direction = new Point("44", 636140.474, 131932.424);
		PillarCoordsForWeightBase pillarCoords = new PillarCoordsForWeightBase(center, direction);
		pillarCoords.setDistanceOnTheAxis(10);
		pillarCoords.setHorizontalDistanceBetweenPillarLegs(7);
		pillarCoords.setVerticalDistanceBetweenPillarLegs(7.5);
		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(4);
		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(4);
		//pillarCoords.setAngleValueBetweenMainPath(90);
		pillarCoords.calculatePillarPoints();
		//FileProcess.setSteakoutFile();
		SteakoutControl stk = new SteakoutControl(pillarCoords.getPillarPoints(), PointID.POSTFIX, "_STK", ";");
		stk.controlSteakout();
		WeightBaseDisplayer displayer = new WeightBaseDisplayer(pillarCoords.getPillarPoints(),
								pillarCoords.getAxisDirectionPoint(),
								pillarCoords.getRadRotation(),
								"Paks 43. oszlop");
		displayer.setControlledCoords(stk.getControlledCoords());
		
		
//		FileProcess.projectName = "FETO_T12-T11_oszlop";
//		FileProcess.setFolder();
//		Point center = new Point("T12", 731077.8079, 105128.6198);
//		Point direction = new Point("T11", 731288.2036, 105251.3606);
//		PillarCoordsForPlateBase pillarCoords = new PillarCoordsForPlateBase(center, direction);
//		pillarCoords.setHorizontalSizeOfHole(8.6);
//		pillarCoords.setVerticalSizeOfHole(8.6);
//		pillarCoords.setHorizontalDistanceFromTheSideOfHole(6);
//		pillarCoords.setVerticalDistanceFromTheSideOfHole(6);
//		pillarCoords.setAngleValueBetweenMainPath(120);
//		pillarCoords.calculatePillarPoints();
//		FileProcess.setSteakoutFile();
//		SteakoutControl stk = new SteakoutControl(pillarCoords.getPillarPoints(), PointID.POSTFIX, "_STK", ";");
//		stk.controlSteakout();
//		PlateBaseDisplayer displayer =new PlateBaseDisplayer(pillarCoords.getPillarPoints(), 
//									   pillarCoords.getAxisDirectionPoint(),
//									   pillarCoords.getRadRotation(),
//									   "FETO T6-T12 Pillars");
//		displayer.setControlledCoords(stk.getControlledCoords());
	}
	
}
