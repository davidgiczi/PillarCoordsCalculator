package mvmxpert.david.giczi.pillarcoordscalculator.view;

import java.awt.Color;
import java.awt.Cursor;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import mvmxpert.david.giczi.pillarcoordscalculator.listeners.CreateProjectListener;

public class HomeWindow {

	private JFrame homeFrame;
	private Color textColor = new Color(112,128,144);
	private JMenu menu3;
	
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
		menu1.addMouseListener(new CreateProjectListener());
		JMenu menu2 = new JMenu("Kit�z�si m�retek sz�m�t�sa");
		menu2.setForeground(textColor);
		menu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu2.setEnabled(false);
		menu3 = new JMenu("Kit�z�tt pontok ellen�rz�se");
		menu3.setForeground(textColor);
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu3.setEnabled(false);
		JMenuBar menuBar = new JMenuBar();
		JMenuItem item21 = new JMenuItem("S�lyalap pontjainak sz�m�t�sa");
		item21.setForeground(textColor);
		item21.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JMenuItem item22 = new JMenuItem("Lemezalap pontjainak sz�m�t�sa");
		item22.setForeground(textColor);
		item22.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuBar.add(menu1);
		menuBar.add(menu2);
		menu2.add(item21);
		menu2.add(item22);
		menuBar.add(menu3);
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
	
	public static String getProjectNameWindow() {
	return	JOptionPane.showInputDialog(null, "Add meg a projekt nev�t:");
	}
		
	public static void main(String[] args) {
		new HomeWindow();
	}
}
