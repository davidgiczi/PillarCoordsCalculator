package mvmxpert.david.giczi.pillarcoordscalculator.listeners;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import mvmxpert.david.giczi.pillarcoordscalculator.controller.PillarCoordsCalculatorController;

public class CreateSteakoutWindowListener implements MenuListener {

	@Override
	public void menuSelected(MenuEvent e) {
		PillarCoordsCalculatorController.getSteakoutControlWindow();
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
