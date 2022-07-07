package mvmxpert.david.giczi.pillarcoordscalculator.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import mvmxpert.david.giczi.pillarcoordscalculator.controller.PillarCoordsCalculatorController;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;
import mvmxpert.david.giczi.pillarcoordscalculator.view.HomeWindow;


public class CreateProjectListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		String projectName = HomeWindow.setProjectName();
		
		if(projectName == null){
			return;
		}
		else if(projectName.length() > 2) {
			PillarCoordsCalculatorController.PROJECT_NAME = projectName;
			FileProcess.setFolder();	
		}
		else {
			JOptionPane.showMessageDialog(null,
					"A projekt neve legalább 3 karakter hosszú lehet.", 
					"Projekt név", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	



}
