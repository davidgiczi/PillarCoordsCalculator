package mvmxpert.david.giczi.pillarcoordscalculator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mvmxpert.david.giczi.pillarcoordscalculator.controller.PillarCoordsCalculatorController;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;

public class SteakoutControlWindow {

	private JFrame steakoutControlFrame;
	public JFrame inputFrameForPlateBase;
	private Color color = new Color(112,128,144);
	private Font font1 = new Font("Arial", Font.PLAIN, 16);
	private Font font2 = new Font("Arial", Font.BOLD, 13);
	
	
	public SteakoutControlWindow(String projectName) {
		
		steakoutControlFrame = new JFrame(projectName);
		steakoutControlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		steakoutControlFrame.setSize(400, 800);
		steakoutControlFrame.setLocationRelativeTo(null);
		steakoutControlFrame.setLocation(
				(int)(steakoutControlFrame.getLocation().getX() - 100),
				(int) steakoutControlFrame.getLocation().getY());
		steakoutControlFrame.setLayout(new FlowLayout());
		setSteakoutFileData();
		setSteakoutFileContentType();
		setOutputData();
		addOkButton();
		steakoutControlFrame.setResizable(false);
		steakoutControlFrame.setVisible(true);
	}
	

	private void setSteakoutFileData() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(380, 230));
		panel.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createEtchedBorder(),
						"Kitûzési fájl nevének/helyének megadása", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		panel.add(Box.createHorizontalStrut(130));
		JTextField stkFileNameField = new JTextField(32);
		JTextField stkFilePlaceField = new JTextField(32);
		JButton browse = new JButton("Tallózás");
		browse.setFont(font2);
		browse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(browse);
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileProcess.setSteakoutFile();
				stkFileNameField.setText(FileProcess.STK_FILE_NAME);
				stkFilePlaceField.setText(FileProcess.STK_FILE_PATH);
			}
		});
		panel.add(Box.createHorizontalStrut(100));
		JLabel stkFileNameTextLabel = new JLabel("A fájl neve:");
		stkFileNameTextLabel.setFont(font2);
		panel.add(stkFileNameTextLabel);
		stkFileNameField.setFont(font2);
		stkFileNameField.setForeground(color);
		stkFileNameField.setEditable(false);
		stkFilePlaceField.setFont(font2);
		stkFilePlaceField.setForeground(color);
		stkFilePlaceField.setEditable(false);
		panel.add(stkFileNameField);
		JLabel stkFilePlaceTextLabel = new JLabel("A fájl helye:");
		stkFilePlaceTextLabel.setFont(font2);
		panel.add(stkFilePlaceTextLabel);
		panel.add(stkFilePlaceField);
		
		steakoutControlFrame.add(panel);

	}
	
	private void setSteakoutFileContentType() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(380, 230));
		panel.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createEtchedBorder(),
						"Kitûzési fájl lekérdezési adatainak beállítása", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		panel.add(Box.createHorizontalStrut(130));
		steakoutControlFrame.add(panel);
	}
	
	
	private void setOutputData() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(380, 240));
		panel.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createEtchedBorder(),
						"Kimeneti fájl mentése", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		
		panel.add(Box.createVerticalStrut(80));
		
		JLabel saveFileLabel = new JLabel("Eredmények fájlba mentése?");
		saveFileLabel.setFont(font2);
		panel.add(saveFileLabel);
		panel.add(Box.createHorizontalStrut(400));
		ButtonGroup group = new ButtonGroup();
		JRadioButton yes = new JRadioButton("Igen", true);
		yes.setBackground(Color.WHITE);
		panel.add(yes);
		JRadioButton no = new JRadioButton("Nem");
		no.setBackground(Color.WHITE);
		group.add(yes);
		group.add(no);
		panel.add(no);
		
		steakoutControlFrame.add(panel);
	}
	
	private void addOkButton() {
		
		JPanel panel = new JPanel();
		JButton ok = new JButton("Ok");
		ok.setFont(font2);
		ok.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(ok);
		steakoutControlFrame.add(panel);
		
	}

	public static void main(String[] args) {
		new SteakoutControlWindow("Testing");
	}
	

}
