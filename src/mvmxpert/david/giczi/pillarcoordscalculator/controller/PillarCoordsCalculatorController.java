package mvmxpert.david.giczi.pillarcoordscalculator.controller;

import java.util.List;
import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.InputDataValidator;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForPlateBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PillarCoordsForWeightBase;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.SteakoutControl;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.view.HomeWindow;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PlateBaseDisplayer;
import mvmxpert.david.giczi.pillarcoordscalculator.view.PlateBaseInputWindow;
import mvmxpert.david.giczi.pillarcoordscalculator.view.WeightBaseDisplayer;
import mvmxpert.david.giczi.pillarcoordscalculator.view.WeightBaseInputWindow;

public class PillarCoordsCalculatorController {

	public static String PROJECT_NAME;
	private static PillarCoordsForPlateBase plateBaseCoordsCalculator;
	private static PillarCoordsForWeightBase weightBaseCoordsCalculator;
	private static SteakoutControl steakoutControl;
	private static HomeWindow homeWindow;
	private static WeightBaseInputWindow weightBaseInputWindow;
	private static PlateBaseInputWindow plateBaseInputWindow;
	
	
	public PillarCoordsCalculatorController() {
		homeWindow = new HomeWindow();
	}
	
	public static void setProjectName() {
		
		String projectName = 
				JOptionPane.showInputDialog(null, "Add meg a projekt nevét:", "A projekt nevének megadása", JOptionPane.DEFAULT_OPTION);
		
		if( projectName == null ) {
		}
		else if( InputDataValidator.isValidProjectName(projectName) ) {
			PillarCoordsCalculatorController.PROJECT_NAME = projectName;
			FileProcess.setFolder();
			if(FileProcess.FOLDER_PATH != null) {
			homeWindow.steakoutMenu.setEnabled(true);
			if( FileProcess.isProjectFileExist() ) {
				getInfoMessage("\"" + PillarCoordsCalculatorController.PROJECT_NAME + "\"" + " projekt",
						"Létezõ " + getBaseType() +" projekt.");
			}
		}
	}
		else {
			getInfoMessage("Projekt név megadása", "A projekt neve legalább 3 karakter hosszúságú és betûvel kezdõdõ lehet.");
		}
		
	}
	
	public static void getPlateBaseInputWindow() {
		plateBaseInputWindow = new PlateBaseInputWindow(PillarCoordsCalculatorController.PROJECT_NAME);
		setProjectFileData();
	}
	
	public static void getWeightBaseInputWindow() {
		weightBaseInputWindow = new WeightBaseInputWindow(PillarCoordsCalculatorController.PROJECT_NAME);
		setProjectFileData();
	}
	
	public static void clickButtonOnPlateBaseInputWindow() {
	
		String centerID = plateBaseInputWindow.centerIdField.getText();
		String directionID = plateBaseInputWindow.directionIdField.getText();
		
		if( !InputDataValidator.isValidID(centerID) || !InputDataValidator.isValidID(directionID) ) {
			getInfoMessage("Az oszlopok nevének megadása",
					"Az oszlopok neve/száma legalább egy karakter hosszúságú legyen.");
			return;
		}
	
	try {
		double centerX = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.x_centerField.getText().replace(',' , '.'));
		double centerY = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.y_centerField.getText().replace(',', '.'));
		Point center = new Point(centerID, centerX, centerY);
		double directionX = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.x_directionField.getText().replace(',', '.'));
		double directionY = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.y_directionField.getText().replace(',', '.'));
		Point direction = new Point(directionID, directionX, directionY);
		plateBaseCoordsCalculator = new PillarCoordsForPlateBase(center, direction);
		double horizontalSizeOfHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.horizontalSizeOfHoleField.getText().replace(',', '.'));
		plateBaseCoordsCalculator.setHorizontalSizeOfHole(horizontalSizeOfHole);
		double verticalSizeOfHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.verticalSizeOfHoleField.getText().replace(',', '.'));
		plateBaseCoordsCalculator.setVerticalSizeOfHole(verticalSizeOfHole);
		double horizontalDistanceFromHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.horizontalDistanceFromHoleSideField.getText().replace(',', '.'));
		plateBaseCoordsCalculator.setHorizontalDistanceFromTheSideOfHole(horizontalDistanceFromHole);
		double verticalDistanceFromHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.verticalDistanceFromHoleSideField.getText().replace(',', '.'));
		plateBaseCoordsCalculator.setVerticalDistanceFromTheSideOfHole(verticalDistanceFromHole);
		double rotationAngle = InputDataValidator.isValidAngleValue(plateBaseInputWindow.rotateAngularField.getText());
		plateBaseCoordsCalculator.setAngleValueBetweenMainPath(rotationAngle);
		double rotationMin = InputDataValidator.isValidAngleValue(plateBaseInputWindow.rotateAngularMinField.getText());
		plateBaseCoordsCalculator.setAngularMinuteValueBetweenMainPath(rotationMin);
		double rotationSec = InputDataValidator.isValidAngleValue(plateBaseInputWindow.rotateAngularSecField.getText());
		plateBaseCoordsCalculator.setAngularSecondValueBetweenMainPath(rotationSec);
		plateBaseCoordsCalculator.calculatePillarPoints();
		
		if( FileProcess.isProjectFileExist() ) {
			
			if( getWarningMessage("\"" + PillarCoordsCalculatorController.PROJECT_NAME + ".pcc\"", 
						"Létezõ " + getBaseType() + " projekt fájl, biztos, hogy felülírod?" ) == 2 ) {
				setProjectName();
		}
			FileProcess.saveProjectFileForPlatetBase
			(centerID, centerX, centerY, 
			 directionID, directionX, directionY, 
			 horizontalSizeOfHole, verticalSizeOfHole, 
			 horizontalDistanceFromHole, verticalDistanceFromHole, 
			 rotationAngle, rotationSec, rotationMin);
			 saveCoordFileForPlateBase();
			 plateBaseInputWindow.inputFrameForPlateBase.setVisible(false);
			 new PlateBaseDisplayer(plateBaseCoordsCalculator.getPillarPoints(), 
					   plateBaseCoordsCalculator.getAxisDirectionPoint(),
					   plateBaseCoordsCalculator.getRadRotation(),
					   PillarCoordsCalculatorController.PROJECT_NAME);
		
	}
 
	} catch (NumberFormatException e) {
		getInfoMessage("Bemeneti adatok megadása",
				"Minden üres adatmezõ kitöltése szükséges.");
	} catch (InvalidAttributeValueException e) {
		getInfoMessage("Bemeneti adatok megadása", "Az oszlopok megadott koordinátái alapján irányszög nem számítható.");
	}	
}
	
	public static void clickButtonOnWeightBaseInputWindow() {
		
		String centerID = weightBaseInputWindow.centerIdField.getText();
		String directionID = weightBaseInputWindow.directionIdField.getText();
		
		if( !InputDataValidator.isValidID(centerID) || !InputDataValidator.isValidID(directionID) ) {
			getInfoMessage("Az oszlopok nevének megadása",
					"Az oszlopok neve/száma legalább egy karakter hosszúságú legyen.");
			return;
		}
	
	try {
		double centerX = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.x_centerField.getText().replace(',' , '.'));
		double centerY = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.y_centerField.getText().replace(',', '.'));
		Point center = new Point(centerID, centerX, centerY);
		double directionX = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.x_directionField.getText().replace(',', '.'));
		double directionY = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.y_directionField.getText().replace(',', '.'));
		Point direction = new Point(directionID, directionX, directionY);
		weightBaseCoordsCalculator = new PillarCoordsForWeightBase(center, direction);
		double distanceOnTheAxis = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.directionSizeField.getText().replace(',', '.'));
		weightBaseCoordsCalculator.setDistanceOnTheAxis(distanceOnTheAxis);
		double horizontalDistanceBetweenPillarLegs = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.horizontalSizeForPillarLegField.getText().replace(',', '.'));
		weightBaseCoordsCalculator.setHorizontalDistanceBetweenPillarLegs(horizontalDistanceBetweenPillarLegs);
		double verticalDistanceBetweenPillarLegs = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.verticalSizeForPillarLegField.getText().replace(',', '.'));
		weightBaseCoordsCalculator.setVerticalDistanceBetweenPillarLegs(verticalDistanceBetweenPillarLegs);
		double horizontalSizeOfHoleOfPillarLeg = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.horizontalSizeForHoleField.getText().replace(',', '.'));
		weightBaseCoordsCalculator.setHorizontalSizeOfHoleOfPillarLeg(horizontalSizeOfHoleOfPillarLeg);
		double verticalSizeOfHoleOfPillarLeg = InputDataValidator
				.isValidInputNumberValue(weightBaseInputWindow.verticalSizeForHoleField.getText().replace(',', '.'));
		weightBaseCoordsCalculator.setVerticalSizeOfHoleOfPillarLeg(verticalSizeOfHoleOfPillarLeg);
		double rotationAngle = InputDataValidator.isValidAngleValue(weightBaseInputWindow.rotateAngularField.getText());
		weightBaseCoordsCalculator.setAngleValueBetweenMainPath(rotationAngle);
		double rotationMin = InputDataValidator.isValidAngleValue(weightBaseInputWindow.rotateAngularMinField.getText());
		weightBaseCoordsCalculator.setAngularMinuteValueBetweenMainPath(rotationMin);
		double rotationSec = InputDataValidator.isValidAngleValue(weightBaseInputWindow.rotateAngularSecField.getText());
		weightBaseCoordsCalculator.setAngularSecondValueBetweenMainPath(rotationSec);
		weightBaseCoordsCalculator.calculatePillarPoints();
		
		if( FileProcess.isProjectFileExist()) { 
		
			if(getWarningMessage("\"" + PillarCoordsCalculatorController.PROJECT_NAME + ".pcc\"", 
						"Létezõ " + getBaseType() + " projekt fájl, biztos, hogy felülírod?" ) == 2 ) {
				setProjectName();
		}
			
			FileProcess.saveProjectFileForWeightBase
			(centerID, centerX, centerY, 
			 directionID, directionX, directionY, 
			 distanceOnTheAxis, 
			 horizontalDistanceBetweenPillarLegs, 
			 verticalDistanceBetweenPillarLegs, 
			 horizontalSizeOfHoleOfPillarLeg, 
			 verticalSizeOfHoleOfPillarLeg, 
			 rotationAngle, rotationSec, rotationMin);
			 saveCoordFileForWeightBase();
			 weightBaseInputWindow.inputFrameForWeightBase.setVisible(false);
			 new WeightBaseDisplayer(weightBaseCoordsCalculator.getPillarPoints(), 
					   weightBaseCoordsCalculator.getAxisDirectionPoint(),
					   weightBaseCoordsCalculator.getRadRotation(),
					   PillarCoordsCalculatorController.PROJECT_NAME);
			
	}
	 	 
	} catch (NumberFormatException e) {
		getInfoMessage("Bemeneti adatok megadása",
				"Minden üres adatmezõ kitöltése szükséges.");
	} catch (InvalidAttributeValueException e) {
		getInfoMessage("Bemeneti adatok megadása", "Az oszlopok megadott koordinátái alapján irányszög nem számítható.");
	}			
}	
	private static void getInfoMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static int getWarningMessage(String title, String message) {
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	private static String getBaseType() {
		String baseType = "#WeightBase".equals(FileProcess.getProjectFileData().get(0)) ? "súlyalap" : 
			"#PlateBase".equals(FileProcess.getProjectFileData().get(0)) ? "lemezalap" : "";
		return baseType;
	}
	
	private static void saveCoordFileForPlateBase() {
		
		if( plateBaseInputWindow.all.isSelected() ) {
			FileProcess.saveDataForKML(plateBaseCoordsCalculator.getPillarCenterPoint());
			FileProcess.saveDataForRTK(plateBaseCoordsCalculator.getPillarPoints());
			FileProcess.saveDataForTPS(plateBaseCoordsCalculator.getPillarPoints());
			FileProcess.saveDataForMS(plateBaseCoordsCalculator.getPillarPoints(), 
								plateBaseCoordsCalculator.getAxisDirectionPoint());
		}
		if( plateBaseInputWindow.kml.isSelected() ) {
			FileProcess.saveDataForKML(plateBaseCoordsCalculator.getPillarCenterPoint());
		}
		if( plateBaseInputWindow.rtk.isSelected() ) {
			FileProcess.saveDataForRTK(plateBaseCoordsCalculator.getPillarPoints());
		}
		if( plateBaseInputWindow.tps.isSelected() ) {
			FileProcess.saveDataForTPS(plateBaseCoordsCalculator.getPillarPoints());
		}
		if( plateBaseInputWindow.ms.isSelected() ) {
			FileProcess.saveDataForMS(plateBaseCoordsCalculator.getPillarPoints(),
								plateBaseCoordsCalculator.getAxisDirectionPoint());
		}
	}
	
	private static void saveCoordFileForWeightBase() {
		
		if( weightBaseInputWindow.all.isSelected() ) {
			FileProcess.saveDataForKML(weightBaseCoordsCalculator.getPillarCenterPoint());
			FileProcess.saveDataForRTK(weightBaseCoordsCalculator.getPillarPoints());
			FileProcess.saveDataForTPS(weightBaseCoordsCalculator.getPillarPoints());
			FileProcess.saveDataForMS(weightBaseCoordsCalculator.getPillarPoints(), 
								weightBaseCoordsCalculator.getAxisDirectionPoint());
		}
		if( weightBaseInputWindow.kml.isSelected() ) {
			FileProcess.saveDataForKML(weightBaseCoordsCalculator.getPillarCenterPoint());
		}
		if( weightBaseInputWindow.rtk.isSelected() ) {
			FileProcess.saveDataForRTK(weightBaseCoordsCalculator.getPillarPoints());
		}
		if( weightBaseInputWindow.tps.isSelected() ) {
			FileProcess.saveDataForTPS(weightBaseCoordsCalculator.getPillarPoints());
		}
		if( weightBaseInputWindow.ms.isSelected() ) {
			FileProcess.saveDataForMS(weightBaseCoordsCalculator.getPillarPoints(),
								weightBaseCoordsCalculator.getAxisDirectionPoint());
		}
	}
	
	private static void setProjectFileData() {
		
		List<String> projectFileData = FileProcess.getProjectFileData();
	
		if( !projectFileData.isEmpty() && "#PlateBase".equals(projectFileData.get(0)) ) {
			
			plateBaseInputWindow.centerIdField.setText(projectFileData.get(1));
			plateBaseInputWindow.x_centerField.setText(projectFileData.get(2));
			plateBaseInputWindow.y_centerField.setText(projectFileData.get(3));
			plateBaseInputWindow.directionIdField.setText(projectFileData.get(4));
			plateBaseInputWindow.x_directionField.setText(projectFileData.get(5));
			plateBaseInputWindow.y_directionField.setText(projectFileData.get(6));
			plateBaseInputWindow.horizontalSizeOfHoleField.setText(projectFileData.get(7));
			plateBaseInputWindow.verticalSizeOfHoleField.setText(projectFileData.get(8));
			plateBaseInputWindow.horizontalDistanceFromHoleSideField.setText(projectFileData.get(9));
			plateBaseInputWindow.verticalDistanceFromHoleSideField.setText(projectFileData.get(10));
			plateBaseInputWindow.rotateAngularField
			.setText(projectFileData.get(11).substring(0, projectFileData.get(11).indexOf('.')));
			plateBaseInputWindow.rotateAngularMinField
			.setText(projectFileData.get(12).substring(0, projectFileData.get(12).indexOf('.')));
			plateBaseInputWindow.rotateAngularSecField
			.setText(projectFileData.get(13).substring(0, projectFileData.get(13).indexOf('.')));
		
		}
		else if( !projectFileData.isEmpty() && "#WeightBase".equals(projectFileData.get(0)) ) {
			
			weightBaseInputWindow.centerIdField.setText(projectFileData.get(1));
			weightBaseInputWindow.x_centerField.setText(projectFileData.get(2));
			weightBaseInputWindow.y_centerField.setText(projectFileData.get(3));
			weightBaseInputWindow.directionIdField.setText(projectFileData.get(4));
			weightBaseInputWindow.x_directionField.setText(projectFileData.get(5));
			weightBaseInputWindow.y_directionField.setText(projectFileData.get(6));
			weightBaseInputWindow.directionSizeField.setText(projectFileData.get(7));
			weightBaseInputWindow.horizontalSizeForPillarLegField.setText(projectFileData.get(8));
			weightBaseInputWindow.verticalSizeForPillarLegField.setText(projectFileData.get(9));
			weightBaseInputWindow.horizontalSizeForHoleField.setText(projectFileData.get(10));
			weightBaseInputWindow.verticalSizeForHoleField.setText(projectFileData.get(11));
			weightBaseInputWindow.rotateAngularField
			.setText(projectFileData.get(12).substring(0, projectFileData.get(12).indexOf('.')));
			weightBaseInputWindow.rotateAngularMinField
			.setText(projectFileData.get(13).substring(0, projectFileData.get(13).indexOf('.')));
			weightBaseInputWindow.rotateAngularSecField
			.setText(projectFileData.get(14).substring(0, projectFileData.get(14).indexOf('.')));
		}
	}
	
}
