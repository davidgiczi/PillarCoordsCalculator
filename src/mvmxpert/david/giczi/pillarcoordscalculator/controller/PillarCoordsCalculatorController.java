package mvmxpert.david.giczi.pillarcoordscalculator.controller;

import java.util.ArrayList;

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

	private static String projectName;
	private static PillarCoordsForPlateBase plateBaseCoordsCalculator;
	private static PillarCoordsForWeightBase weightBaseCoordsCalculator;
	private static SteakoutControl steakoutControl;
	private static HomeWindow homeWindow;
	private static WeightBaseInputWindow weightBaseInputWindow;
	private static PlateBaseInputWindow plateBaseInputWindow;
	private static PlateBaseDisplayer plateBaseDisplayer;
	private static WeightBaseDisplayer weightBaseDisplayer;
	
	
	public PillarCoordsCalculatorController() {
		homeWindow = new HomeWindow();
	}
	
	public static void setProjectName() {
		
		String projectName = JOptionPane.showInputDialog(null, "Add meg a projekt nevét:", "A projekt nevének megadása", JOptionPane.DEFAULT_OPTION);
		
		if( projectName == null ) {
		}
		else if( InputDataValidator.isValidProjectName(projectName) ) {
			PillarCoordsCalculatorController.projectName = projectName;
			FileProcess.setFolder();
			if(FileProcess.FOLDER_PATH != null) {
			homeWindow.steakoutMenu.setEnabled(true);
			}
		}
		else {
			getInfoMessage("Projekt név megadása", "A projekt neve legalább 3 karakter hosszúságú és betûvel kezdõdõ lehet.");
		}
		
	}
	
	public static void getPlateBaseInputWindow() {
		plateBaseInputWindow = new PlateBaseInputWindow(PillarCoordsCalculatorController.projectName);
	}
	
	public static void getWeightBaseInputWindow() {
		weightBaseInputWindow = new WeightBaseInputWindow(PillarCoordsCalculatorController.projectName);
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
		PillarCoordsForPlateBase plateBaseCoords = new PillarCoordsForPlateBase(center, direction);
		double horizontalSizeOfHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.horizontalSizeOfHoleField.getText().replace(',', '.'));
		plateBaseCoords.setHorizontalSizeOfHole(horizontalSizeOfHole);
		double verticalSizeOfHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.verticalSizeOfHoleField.getText().replace(',', '.'));
		plateBaseCoords.setVerticalSizeOfHole(verticalSizeOfHole);
		double horizontalDistanceFromHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.horizontalDistanceFromHoleSideField.getText().replace(',', '.'));
		plateBaseCoords.setHorizontalDistanceFromTheSideOfHole(horizontalDistanceFromHole);
		double verticalDistanceFromHole = InputDataValidator
				.isValidInputNumberValue(plateBaseInputWindow.verticalDistanceFromHoleSideField.getText().replace(',', '.'));
		plateBaseCoords.setVerticalDistanceFromTheSideOfHole(verticalDistanceFromHole);
		double rotationAngle = InputDataValidator.isValidAngleValue(plateBaseInputWindow.rotateAngularField.getText());
		plateBaseCoords.setAngleValueBetweenMainPath(rotationAngle);
		double rotationMin = InputDataValidator.isValidAngleValue(plateBaseInputWindow.rotateAngularMinField.getText());
		plateBaseCoords.setAngularMinuteValueBetweenMainPath(rotationMin);
		double rotationSec = InputDataValidator.isValidAngleValue(plateBaseInputWindow.rotateAngularSecField.getText());
		plateBaseCoords.setAngularSecondValueBetweenMainPath(rotationSec);
		plateBaseCoords.calculatePillarPoints();
		plateBaseDisplayer = new PlateBaseDisplayer(plateBaseCoords.getPillarPoints(), 
				   plateBaseCoords.getAxisDirectionPoint(),
				   plateBaseCoords.getRadRotation(),
				   PillarCoordsCalculatorController.projectName);
		plateBaseDisplayer.setControlledCoords(new ArrayList<>());
		
		
	} catch (NumberFormatException e) {
		
		getInfoMessage("Bemeneti adatok megadása",
				"Minden üres adatmezõ kitöltése szükséges és a megadott adatok csak nem negatív számok lehetnek.");
	} catch (InvalidAttributeValueException e) {
		getInfoMessage("Bemeneti adatok megadása", "Az oszlopok megadott koordinátái alapján irányszög nem számítható.");
	}	

	}
	
	public static void clickButtonOnWeightBaseInputWindow() {
		
	}
	
	
	
	private static void getInfoMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
