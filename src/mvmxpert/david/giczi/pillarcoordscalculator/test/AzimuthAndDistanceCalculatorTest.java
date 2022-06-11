package mvmxpert.david.giczi.pillarcoordscalculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.AzimuthAndDistanceCalculator;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;

public class AzimuthAndDistanceCalculatorTest {

	
	private AzimuthAndDistanceCalculator calculator;
	

	@Test
	public void distanceCalculatorTest1(){
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 10, 10), new Point("B", 10, 100));
		assertEquals(90.0, calculator.calcDistanceBetweenTheTwoPoints());
	}
	
	@Test
	public void distanceCalculatorTest2(){
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 10.56, 10.52), new Point("B", 3.98, 100.45));
		assertEquals(90.1704014630078, calculator.calcDistanceBetweenTheTwoPoints());
	}
	
	@Test
	public void distanceCalculatorTest3(){
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 100.725, 10.5258), new Point("B", 13.9876, 100.459));
		assertEquals(124.94541616642044, calculator.calcDistanceBetweenTheTwoPoints());
	}
	
	@Test
	public void distanceCalculatorTest4(){
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 10.25, 10.5), new Point("B", 10.25, 10.5));
		assertEquals(0.0, calculator.calcDistanceBetweenTheTwoPoints());
	}
	
	@Test
	public void azimuthCalculatorTest1() {
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 10, 10),new Point("B", 10, 20));
		assertEquals(0.0, calculator.calcAzimuthFromPointAToPointB());
	}
	
	@Test
	public void azimuthCalculatorTest2() {
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 10, 10),new Point("B", 20, 20));
		assertEquals(Math.PI / 4, calculator.calcAzimuthFromPointAToPointB());
	}
	
	@Test
	public void azimuthCalculatorTest3() {
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 10, 20),new Point("B", 10, 10));
		assertEquals(Math.PI, calculator.calcAzimuthFromPointAToPointB());
	}
	
	@Test
	public void azimuthCalculatorTest4() {
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 20, 10),new Point("B", 10, 10));
		assertEquals(Double.NaN, calculator.calcAzimuthFromPointAToPointB());
	}
	
	@Test
	public void azimuthCalculatorTest5() {
		calculator = new AzimuthAndDistanceCalculator(new Point("A", 20, 10),new Point("B", 10, 20));
		assertEquals(7 * Math.PI / 4, calculator.calcAzimuthFromPointAToPointB());
	}
	
}
