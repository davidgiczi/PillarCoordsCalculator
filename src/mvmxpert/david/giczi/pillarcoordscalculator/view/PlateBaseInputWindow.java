package mvmxpert.david.giczi.pillarcoordscalculator.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mvmxpert.david.giczi.pillarcoordscalculator.controller.PillarCoordsCalculatorController;

public class PlateBaseInputWindow {

	public JFrame inputFrameForPlateBase;
	private Color color = new Color(112,128,144);
	private Font font1 = new Font("Arial", Font.PLAIN, 16);
	private Font font2 = new Font("Arial", Font.BOLD, 13);
	public JTextField centerIdField;
	public JTextField y_centerField;
	public JTextField x_centerField;
	public JTextField directionIdField;
	public JTextField y_directionField;
	public JTextField x_directionField;
	public JTextField horizontalSizeOfHoleField;
	public JTextField verticalSizeOfHoleField;
	public JTextField horizontalDistanceFromHoleSideField;
	public JTextField verticalDistanceFromHoleSideField;
	public JTextField rotateAngularField;
	public JTextField rotateAngularMinField;
	public JTextField rotateAngularSecField;
	public JCheckBox tps;
	public JCheckBox rtk;
	public JCheckBox kml;
	public JCheckBox ms;
	public JCheckBox all;
	
	public PlateBaseInputWindow(String projectName) {
	
		inputFrameForPlateBase = new JFrame(projectName);
		inputFrameForPlateBase.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		inputFrameForPlateBase.setSize(400, 800);
		inputFrameForPlateBase.setLocationRelativeTo(null);
		inputFrameForPlateBase.setLocation(
				(int) (inputFrameForPlateBase.getLocation().getX() - 100), 
				(int) inputFrameForPlateBase.getLocation().getY());
		inputFrameForPlateBase.setLayout(new FlowLayout());
		setPillarPointsData();
		setPillarSizeData();
		setOutputData();
		addOkButton();
		inputFrameForPlateBase.setResizable(false);
		inputFrameForPlateBase.setVisible(true);
	}
	
	private void setPillarPointsData() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(Box.createVerticalStrut(10));
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(380, 260));
		panel.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createEtchedBorder(),
						"Az oszlop hely adatainak megad�sa", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		
		JLabel titleForCenter = new JLabel("Az oszlop k�z�ppontj�nak megad�sa");
		titleForCenter.setFont(font2);
		panel.add(Box.createHorizontalStrut(60));
		panel.add(titleForCenter);
		
		JLabel centerIDLabel = new JLabel("Az oszlop sz�ma:");
		centerIDLabel.setFont(font2);
		centerIdField = new JTextField(15);
		centerIdField.setFont(font2);
		centerIdField.setForeground(color);
		panel.add(centerIDLabel);
		panel.add(Box.createHorizontalStrut(3));
		panel.add(centerIdField);
		
		JLabel centerYText = new JLabel("Y koordin�ta:");
		centerYText.setFont(font2);
		panel.add(centerYText);
		panel.add(Box.createHorizontalStrut(30));
		x_centerField = new JTextField(15);
		x_centerField.setFont(font2);
		x_centerField.setForeground(color);
		panel.add(x_centerField);
		panel.add(new JLabel("m"));
		
		JLabel centerXText = new JLabel("X koordin�ta:");
		centerXText.setFont(font2);
		panel.add(centerXText);
		panel.add(Box.createHorizontalStrut(30));
		y_centerField = new JTextField(15);
		y_centerField.setFont(font2);
		y_centerField.setForeground(color);
		panel.add(y_centerField);
		panel.add(new JLabel("m"));
		
		panel.add(Box.createVerticalStrut(30));
		JLabel titleForDirection = new JLabel("Az el�z�/k�vetkez� oszlop koordin�t�inak megad�sa");
		titleForDirection.setFont(font2);
		panel.add(titleForDirection);
		
		JLabel directionIDLabel = new JLabel("Az oszlop sz�ma:");
		directionIDLabel.setFont(font2);
		directionIdField = new JTextField(15);
		directionIdField.setFont(font2);
		directionIdField.setForeground(color);
		panel.add(directionIDLabel);
		panel.add(Box.createHorizontalStrut(3));
		panel.add(directionIdField);
		
		panel.add(Box.createVerticalStrut(30));
		JLabel directionYText = new JLabel("Y koordin�ta:");
		directionYText.setFont(font2);
		panel.add(directionYText);
		panel.add(Box.createHorizontalStrut(30));
		x_directionField = new JTextField(15);
		x_directionField.setFont(font2);
		x_directionField.setForeground(color);
		panel.add(x_directionField);
		panel.add(new JLabel("m"));
		
		JLabel directionXText = new JLabel("X koordin�ta:");
		directionXText.setFont(font2);
		panel.add(directionXText);
		panel.add(Box.createHorizontalStrut(30));
		y_directionField = new JTextField(15);
		y_directionField.setFont(font2);
		y_directionField.setForeground(color);
		panel.add(y_directionField);
		panel.add(new JLabel("m"));
		
		inputFrameForPlateBase.add(panel);

	}
	
	private void setPillarSizeData() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(Box.createVerticalStrut(10));
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(380, 300));
		panel.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createEtchedBorder(),
						"Az alap geomteriai adatainak megad�sa", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		
		JLabel horizontalSizeForHoleText = new JLabel("Az alap g�dr�nek m�rete a nyomvonallal p�rhuzamosan");
		horizontalSizeForHoleText.setFont(font2);
		panel.add(Box.createHorizontalStrut(60));
		panel.add(horizontalSizeForHoleText);
		
		panel.add(Box.createHorizontalStrut(120));
		horizontalSizeOfHoleField = new JTextField(15);
		horizontalSizeOfHoleField.setFont(font2);
		horizontalSizeOfHoleField.setForeground(color);
		panel.add(horizontalSizeOfHoleField);
		panel.add(new JLabel("m"));
		
		JLabel verticalSizeForHoleText = new JLabel("Az alap g�dr�nek m�rete a nyomvonalra mer�legesen");
		verticalSizeForHoleText.setFont(font2);
		panel.add(Box.createHorizontalStrut(60));
		panel.add(verticalSizeForHoleText);
		
		panel.add(Box.createHorizontalStrut(120));
		verticalSizeOfHoleField = new JTextField(15);
		verticalSizeOfHoleField.setFont(font2);
		verticalSizeOfHoleField.setForeground(color);
		panel.add(verticalSizeOfHoleField);
		panel.add(new JLabel("m"));
		
			
		JLabel titleForHorizontalDistanceFromHole = new JLabel("A g�d�rt�l vett t�vols�g a nyomvonallal p�rhuzamosan");
		titleForHorizontalDistanceFromHole.setFont(font2);
		panel.add(Box.createHorizontalStrut(60));
		panel.add(titleForHorizontalDistanceFromHole);
		
		panel.add(Box.createHorizontalStrut(120));
		horizontalDistanceFromHoleSideField = new JTextField(15);
		horizontalDistanceFromHoleSideField.setFont(font2);
		horizontalDistanceFromHoleSideField.setForeground(color);
		panel.add(horizontalDistanceFromHoleSideField);
		panel.add(new JLabel("m"));
		
		JLabel titleForVerticalSizeForPillarLeg = new JLabel("A g�d�rt�l vett t�vols�g a nyomvonalra mer�legesen");
		titleForVerticalSizeForPillarLeg.setFont(font2);
		panel.add(Box.createHorizontalStrut(60));
		panel.add(titleForVerticalSizeForPillarLeg);
		
		panel.add(Box.createHorizontalStrut(120));
		verticalDistanceFromHoleSideField = new JTextField(15);
		verticalDistanceFromHoleSideField.setFont(font2);
		verticalDistanceFromHoleSideField.setForeground(color);
		panel.add(verticalDistanceFromHoleSideField);
		panel.add(new JLabel("m"));
		
		JLabel angularText = new JLabel("A nyomvonal �ltal bez�rt jobb oldali sz�g");
		angularText.setFont(font2);
		panel.add(Box.createHorizontalStrut(60));
		panel.add(angularText);
		
		panel.add(Box.createHorizontalStrut(45));
		rotateAngularField = new JTextField(5);
		rotateAngularField.setForeground(color);
		rotateAngularField.setText("180");
		rotateAngularMinField = new JTextField(5);
		rotateAngularMinField.setForeground(color);
		rotateAngularMinField.setText("0");
		rotateAngularSecField = new JTextField(5);
		rotateAngularSecField.setForeground(color);
		rotateAngularSecField.setText("0");
		rotateAngularField.setFont(font2);
		rotateAngularMinField.setFont(font2);
		rotateAngularSecField.setFont(font2);
		panel.add(rotateAngularField);
		panel.add(new JLabel("fok"));
		panel.add(rotateAngularMinField);
		panel.add(new JLabel("perc"));
		panel.add(rotateAngularSecField);
		panel.add(new JLabel("mperc"));
		
		inputFrameForPlateBase.add(panel);
	}
	
	private void setOutputData() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(Box.createVerticalStrut(30));
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(380, 130));
		panel.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createEtchedBorder(),
						"Kimeneti f�jlok megad�sa", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		tps = new JCheckBox("M�r��llom�s form�tumban");
		tps.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tps.setBackground(Color.WHITE);
		tps.setFont(font2);
		tps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				all.setSelected(false);
				
			}
		});
		panel.add(tps);
		rtk = new JCheckBox("GPS form�tumban");
		rtk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rtk.setBackground(Color.WHITE);
		rtk.setFont(font2);
		rtk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				all.setSelected(false);
				
			}
		});
		panel.add(rtk);
		panel.add(Box.createHorizontalStrut(30));
		kml = new JCheckBox("KML form�tumban");
		kml.setCursor(new Cursor(Cursor.HAND_CURSOR));
		kml.setBackground(Color.WHITE);
		kml.setFont(font2);
		kml.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				all.setSelected(false);
				
			}
		});
		panel.add(kml);
		ms = new JCheckBox("Microstation form�tumban");
		ms.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ms.setBackground(Color.WHITE);
		ms.setFont(font2);
		ms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				all.setSelected(false);
				
			}
		});
		panel.add(ms);
		panel.add(Box.createHorizontalStrut(100));
		all = new JCheckBox("Mindegyik form�tumban", true);
		all.setCursor(new Cursor(Cursor.HAND_CURSOR));
		all.setBackground(Color.WHITE);
		all.setFont(font2);
		all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tps.setSelected(false);
				rtk.setSelected(false);
				kml.setSelected(false);
				ms.setSelected(false);
			}
		});
		panel.add(all);
		inputFrameForPlateBase.add(panel);
	}
	
	private void addOkButton() {
		JPanel panel = new JPanel();
		JButton ok = new JButton("Sz�mol");
		ok.setFont(font2);
		ok.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PillarCoordsCalculatorController.clickButtonOnPlateBaseInputWindow();
			}
		});
		panel.add(ok);
		inputFrameForPlateBase.add(panel);
	}
	
}
