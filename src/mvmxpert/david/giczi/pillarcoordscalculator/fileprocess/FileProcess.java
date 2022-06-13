package mvmxpert.david.giczi.pillarcoordscalculator.fileprocess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;

public class FileProcess {
	
	private String projectName;
	
	public FileProcess(String projectName) {
		this.projectName = projectName;
	}

	private static String FILE_PATH = "C:/Users/User/Documents/docs/MVMXPert/_FOR_PILLAR";
	
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
	
}
