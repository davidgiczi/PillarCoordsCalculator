package mvmxpert.david.giczi.pillarcoordscalculator.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HomeWindow {

	
	private JFrame homeFrame;
	private Color textColor = new Color(112,128,144);
	
	public HomeWindow() {
		
		homeFrame = new JFrame("Nagyfesz�lts�g� t�vvezet�k oszlopok kit�z�se");
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setSize(500, 800);
		homeFrame.setLocationRelativeTo(null);
		setMenu();
		addImage();
		homeFrame.setResizable(false);
		homeFrame.setVisible(true);
	}
	
	private void setMenu() {
		JMenu menu1 = new JMenu("Kit�z�si m�retek sz�m�t�sa");
		menu1.setForeground(textColor);
		JMenu menu2 = new JMenu("Kit�z�tt m�retek ellen�rz�se");
		menu2.setForeground(textColor);
		JMenu menu3 = new JMenu("�j projekt l�trehoz�sa");
		menu3.setForeground(textColor);
		JMenuBar menuBar = new JMenuBar();
		JMenuItem item11 = new JMenuItem("S�lyalap pontjainak sz�m�t�sa");
		item11.setForeground(textColor);
		JMenuItem item12 = new JMenuItem("Lemezalap pontjainak sz�m�t�sa");
		item12.setForeground(textColor);
		menuBar.add(menu1);
		menu1.add(item11);
		menu1.add(item12);
		menuBar.add(menu2);
		menuBar.add(menu3);
		homeFrame.setJMenuBar(menuBar);
	}
	
	private void addImage() {
		homeFrame.add(new JLabel(new ImageIcon("./img/pillars1.jpg")));
	}
	
 public static void main(String[] args) {
	new HomeWindow();
}
	
}
