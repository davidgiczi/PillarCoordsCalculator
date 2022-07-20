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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mvmxpert.david.giczi.pillarcoordscalculator.domain.InputDataValidator;
import mvmxpert.david.giczi.pillarcoordscalculator.fileprocess.FileProcess;

public class SteakoutControlWindow {

	public JFrame steakoutControlFrame;
	private Color color = new Color(112,128,144);
	private Font font1 = new Font("Arial", Font.PLAIN, 16);
	private Font font2 = new Font("Arial", Font.BOLD, 13);
	private String prePostFixVale;
	
	
	public SteakoutControlWindow(String projectName) {
		
		steakoutControlFrame = new JFrame(projectName);
		steakoutControlFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
						"Kit�z�si f�jl nev�nek/hely�nek megad�sa", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		panel.add(Box.createHorizontalStrut(130));
		JTextField stkFileNameField = new JTextField(32);
		JTextField stkFilePlaceField = new JTextField(32);
		JButton browse = new JButton("Tall�z�s");
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
		JLabel stkFileNameTextLabel = new JLabel("A f�jl neve:");
		stkFileNameTextLabel.setFont(font2);
		panel.add(stkFileNameTextLabel);
		stkFileNameField.setFont(font2);
		stkFileNameField.setForeground(color);
		stkFileNameField.setEditable(false);
		stkFilePlaceField.setFont(font2);
		stkFilePlaceField.setForeground(color);
		stkFilePlaceField.setEditable(false);
		panel.add(stkFileNameField);
		JLabel stkFilePlaceTextLabel = new JLabel("A f�jl helye:");
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
						"Kit�z�si f�jl lek�rdez�si adatainak be�ll�t�sa", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		JLabel prePostFixText = new JLabel("A kit�z�si f�jlban l�v� pontok azonos�t�ja:");
		prePostFixText.setFont(font2);
		panel.add(prePostFixText);
		panel.add(Box.createVerticalStrut(80));
		String[] prePostFixType = {"pontsz�m", "el�tag", "ut�tag"};
		JComboBox<String> prePostFixCombo = new JComboBox<>(prePostFixType);
		JTextField prePostFixValueField = new JTextField(32);
		JLabel prePostFixValueText = new JLabel();
		prePostFixCombo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		prePostFixCombo.addActionListener(new ActionListener() {

				
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = prePostFixCombo.getSelectedItem().toString();
				
				if( !"pontsz�m".equals(selectedValue) ) {
				prePostFixVale = 
						JOptionPane.showInputDialog(null, "Add meg az " + selectedValue + " �rt�k�t:",
								"Az " + selectedValue +  " �rt�k�nek megad�sa", JOptionPane.DEFAULT_OPTION);
				
					if(prePostFixVale != null && InputDataValidator.isValidPrePostFixValue(prePostFixVale)) {
					prePostFixValueText.setText("A pontsz�m " + selectedValue + " �rt�ke:");
					prePostFixValueField.setText(prePostFixVale);
					}
					else if(prePostFixVale != null && !InputDataValidator.isValidPrePostFixValue(prePostFixVale)) {
					JOptionPane.showMessageDialog(null, "Az " + selectedValue + " �rt�ke legal�bb egy, nem �res karakter lehet." , 
							"Az " + selectedValue  + " �rt�knek megad�sa", JOptionPane.INFORMATION_MESSAGE);
					}
			}
				else {
					prePostFixValueText.setText(null);
					prePostFixValueField.setText(null);
				}
		}
		});
		panel.add(prePostFixCombo);
		prePostFixValueText.setFont(font2);
		panel.add(prePostFixValueText);
		prePostFixValueField.setFont(font2);
		prePostFixValueField.setForeground(color);
		prePostFixValueField.setEditable(false);
		panel.add(prePostFixValueField);
		JLabel demiliterText = new JLabel("A kit�z�si f�jlban l�v� elv�laszt� karakter:");
		demiliterText.setFont(font2);
		panel.add(demiliterText);
		panel.add(Box.createVerticalStrut(80));
		String[] demiliterValues = {",", ";", "space"};
		JComboBox<String> demiliterCombo = new JComboBox<>(demiliterValues);
		prePostFixCombo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(demiliterCombo);
		
		steakoutControlFrame.add(panel);
	}
	
	
	private void setOutputData() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(380, 240));
		panel.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createEtchedBorder(),
						"Kimeneti f�jl ment�se", TitledBorder.CENTER, TitledBorder.TOP, font1, color));
		panel.add(Box.createVerticalStrut(80));
		JLabel saveFileLabel = new JLabel("Az ellen�rz�s eredm�ny�nek f�jlba ment�se?");
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

}
