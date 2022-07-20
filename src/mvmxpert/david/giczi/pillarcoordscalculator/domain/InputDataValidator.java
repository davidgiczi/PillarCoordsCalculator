package mvmxpert.david.giczi.pillarcoordscalculator.domain;


public class InputDataValidator {


	public static boolean isValidProjectName(String projectName) {
	return !projectName.isBlank() && projectName.length() > 2 && !Character.isDigit(projectName.charAt(0));		
	}	
	
	public static boolean isValidPrePostFixValue(String value) {
		return !value.isBlank() && !value.isEmpty();
		}	
	
	public static double isValidInputNumberValue(String inputNumber) throws NumberFormatException {
		
	Double number = Double.parseDouble(inputNumber);
	
	if( 0 >= number ) {
		throw new NumberFormatException();
	}

	return number;
	}
	
	public static int isValidAngleValue(String angleValue) throws NumberFormatException {
		
		int angle = Integer.parseInt(angleValue);
		
		return angle;
	}
	
	public static boolean isValidID(String id) {
		return !id.isBlank() && !id.isEmpty();
	}
}
