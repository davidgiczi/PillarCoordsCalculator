package mvmxpert.david.giczi.pillarcoordscalculator.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import mvmxpert.david.giczi.pillarcoordscalculator.controller.PillarCoordsCalculatorController;
import mvmxpert.david.giczi.pillarcoordscalculator.listeners.CreateProjectListener;
import mvmxpert.david.giczi.pillarcoordscalculator.listeners.CreateSteakoutWindowListener;

public class HomeWindow {

	private JFrame homeFrame;
	private Color textColor = new Color(112,128,144);
	public JMenu steakoutMenu;
	public JMenu controlSteakoutMenu;
	
	public HomeWindow() {
		
		homeFrame = new JFrame("Nagyfesz�lts�g� t�vvezet�k oszlop alapj�nak kit�z�se");
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setSize(550, 800);
		homeFrame.setLocationRelativeTo(null);
		addMenu();
		addImage();
		homeFrame.setResizable(false);
		homeFrame.setVisible(true);
	}
	
	private void addMenu() {
		JMenu menu1 = new JMenu("Projekt beolvas�sa/l�trehoz�sa");
		menu1.setForeground(textColor);
		menu1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu1.addMenuListener(new CreateProjectListener());
		steakoutMenu = new JMenu("Alap adatainak megad�sa");
		steakoutMenu.setForeground(textColor);
		steakoutMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		steakoutMenu.setEnabled(false);
		controlSteakoutMenu = new JMenu("Kit�z�tt pontok ellen�rz�se");
		controlSteakoutMenu.setForeground(textColor);
		controlSteakoutMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		controlSteakoutMenu.addMenuListener(new CreateSteakoutWindowListener());
		controlSteakoutMenu.setEnabled(false);
		JMenuBar menuBar = new JMenuBar();
		JMenuItem item21 = new JMenuItem("S�lyalap pontjainak sz�m�t�sa");
		item21.setForeground(textColor);
		item21.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PillarCoordsCalculatorController.getWeightBaseInputWindow();
			}
		});
		JMenuItem item22 = new JMenuItem("Lemezalap pontjainak sz�m�t�sa");
		item22.setForeground(textColor);
		item22.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PillarCoordsCalculatorController.getPlateBaseInputWindow();
			}
		});
		menuBar.add(menu1);
		menuBar.add(steakoutMenu);
		steakoutMenu.add(item21);
		steakoutMenu.add(item22);
		menuBar.add(controlSteakoutMenu);
		homeFrame.setJMenuBar(menuBar);
	}
	
	private void addImage() {
		try {
			byte[] imageSource = this.getClass().getResourceAsStream("/img/pillars1.jpg").readAllBytes();
			homeFrame.add(new JLabel(new ImageIcon(imageSource)));
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
		
}
