package mvmxpert.david.giczi.pillarcoordscalculator.fileprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;

public class FileProcess {
	
	private static String projectName;
	public static String FILE_PATH = "C:/Users/User/Documents/docs/MVMXPert/_FOR_PILLAR";
	
	
	public FileProcess(String projectName) {
		FileProcess.projectName= projectName;
	}
	
	
	public void saveDataForKML(Point pillarCenter) {
		
		File file = new File(FILE_PATH + "/" + projectName + "_KML.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(file, true))) {
			
				writer.write(pillarCenter.writePointForKML());
				writer.newLine();
		
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file cannot be created.");
			e.printStackTrace();
		}
	}
	
	public void saveDataForRTK(List<Point> points) {
		
		File file = new File(FILE_PATH + "/" + projectName + "_RTK.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(file, true))) {
			
			for (Point point : points) {
				writer.write(point.writePointForRTK());
				writer.newLine();
			}
					
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file cannot be created.");
			e.printStackTrace();
		}
	}
	
	public void saveDataForTPS(List<Point> points) {
		
		File file = new File(FILE_PATH + "/" + projectName + "_TPS.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(file, true))) {
			
			for (Point point : points) {
				writer.write(point.writePointForTPS());
				writer.newLine();
			}
					
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file cannot be created.");
			e.printStackTrace();
		}
	}
	
	public void saveDataForMS(List<Point> points) {
		
		File file = new File(FILE_PATH + "/" + projectName + "_MS.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(file, true))) {
			
			for (Point point : points) {
				writer.write(point.writePointForMS());
				writer.newLine();
			}
					
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file cannot be created.");
			e.printStackTrace();
		}
	}
	
	public static void saveSteakoutPoint(String pointData) {
		
		File file = new File(FILE_PATH + "/" + projectName + "_kit.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(file, true))) {
			
				writer.write(pointData);
				writer.newLine();
					
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file cannot be created.");
			e.printStackTrace();
		}
		
	}
	
	public static List<String> getSteakoutPointsData(){
		
		List<String> pointData = new ArrayList<>();
		File file = new File(FILE_PATH);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			pointData.add(reader.readLine());
			
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file not found.");
			e.printStackTrace();
		}
		
		return pointData;
	}
	
}
