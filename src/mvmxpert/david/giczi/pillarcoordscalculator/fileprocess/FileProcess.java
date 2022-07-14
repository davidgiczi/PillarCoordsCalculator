package mvmxpert.david.giczi.pillarcoordscalculator.fileprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;

public class FileProcess {
	
	public static String projectName;
	public static String FOLDER_PATH;
	private static String FILE_PATH;
	
		
	public static void saveDataForKML(Point pillarCenter) {
		
		if(FOLDER_PATH == null) {
			return;
		}

		File file = new File(FOLDER_PATH + "/" + projectName + "_KML.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(file, true))) {
			
				writer.write(pillarCenter.writePointForKML());
				writer.newLine();
		
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file cannot be created.");
			e.printStackTrace();
		}
	}
	
	public static void saveDataForRTK(List<Point> points) {
		
		if(FOLDER_PATH == null) {
			return;
		}
		
		File file = new File(FOLDER_PATH + "/" + projectName + "_RTK.txt");
		
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
	
	public static void saveDataForTPS(List<Point> points) {
		
		if(FOLDER_PATH == null) {
			return;
		}
		
		File file = new File(FOLDER_PATH + "/" + projectName + "_TPS.txt");
		
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
	
	public static void saveDataForMS(List<Point> points) {
		
		if(FOLDER_PATH == null) {
			return;
		}
		
		File file = new File(FOLDER_PATH + "/" + projectName + "_MS.txt");
		
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
		
		if(FOLDER_PATH == null) {
			return;
		}
		
		File file = new File(FOLDER_PATH + "/" + projectName + "_kit.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(file, true))) {
			
				writer.write(pointData);
				writer.newLine();
					
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file cannot be created.");
			e.printStackTrace();
		}
		
	}
	
	public static List<String> getSteakoutedPointData(){
		
		List<String> pointData = new ArrayList<>();
		
		if(FILE_PATH == null) {
			return pointData;
		}
		File file = new File(FILE_PATH);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			String row = reader.readLine();
			while(row != null) { 
			pointData.add(row);
			row = reader.readLine();
			}
			
		} catch (IOException e) {
			System.out.println( "\'"+ file.getName() + "\' file not found.");
			e.printStackTrace();
		}
		
		return pointData;
	}
	
	public static void setFolder() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Válassz mentési mappát a projektnek.");
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			FOLDER_PATH = selectedFile.getAbsolutePath();
		}
	}
	
	public static void setSteakoutFile() {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Válassz kitûzési fájlt.");
			jfc.setAcceptAllFileFilterUsed(false);
			if( FOLDER_PATH != null) {
			jfc.setCurrentDirectory(new File(FOLDER_PATH));
			}
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt fájlok", "txt");
			jfc.addChoosableFileFilter(filter);
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				FILE_PATH = selectedFile.getAbsolutePath();
		}
			
	
	}
}
