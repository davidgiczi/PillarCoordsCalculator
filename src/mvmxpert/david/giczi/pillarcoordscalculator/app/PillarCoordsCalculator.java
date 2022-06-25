package mvmxpert.david.giczi.pillarcoordscalculator.app;

import javax.management.InvalidAttributeValueException;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForPlateBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForWeightBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.SteakoutControl;
import mvmxpert.david.giczi.pillarcoordscalculator.enums.PointID;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PlateBaseDisplayer;
import mvmxpert.david.giczi.pillarcoordscalculator.view.WeightBaseDisplayer;

public class PillarCoordsCalculator {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
		
		Point center = new Point("43", 636057.220, 132220.455);
		Point direction = new Point("44", 636140.474, 131932.424);
		PillarCoordsForWeightBase pillarCoords = new PillarCoordsForWeightBase(center, direction);
		pillarCoords.setDistanceOnTheAxis(10);
		pillarCoords.setHorizontalDistanceBetweenPillarLegs(2.88);
		pillarCoords.setVerticalDistanceBetweenPillarLegs(4.26);
		pillarCoords.setHorizontalSizeOfHoleOfPillarLeg(2);
		pillarCoords.setVerticalSizeOfHoleOfPillarLeg(2);
		pillarCoords.calculatePillarPoints();
		new WeightBaseDisplayer(pillarCoords.getPillarPoints(),
								pillarCoords.getAxisDirectionPoint(),
								pillarCoords.getRadRotation(),
								"Paks 43. oszlop");
		SteakoutControl steakout = new SteakoutControl(pillarCoords.getPillarPoints(), PointID.PREFIX, "KIT-", ";");
		new FileProcess("Paks_43_oszlop");
		steakout.controlSteakoutForWeightBase();
		
		 
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
