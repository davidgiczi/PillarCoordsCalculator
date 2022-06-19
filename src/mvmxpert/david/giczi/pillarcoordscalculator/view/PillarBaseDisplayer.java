package mvmxpert.david.giczi.pillarcoordscalculator.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;

public class PillarBaseDisplayer extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	private List<Point> pillarBasePoints;
	private List<Point> transformedPillarBasePoints;
	private double displayerCenterX;
	private double displayerCenterY;
	private final static int SCALE = 30;

	public PillarBaseDisplayer(List<Point> pillarBasePoints, String projectName) {
		 	super(projectName);
		 	this.pillarBasePoints = pillarBasePoints;
		 	getDisplayerCenterCoords();
		 	transformPillarCoordsForDisplayer();
		 	setExtendedState(JFrame.MAXIMIZED_BOTH);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setBackground(Color.WHITE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	}
	
	private void transformPillarCoordsForDisplayer(){
		transformedPillarBasePoints = new ArrayList<>();
		double X = pillarBasePoints.get(0).getX_coord();
		double Y = pillarBasePoints.get(0).getY_coord();
		for (Point pillarBasePoint : pillarBasePoints) {
			Point point = new Point(pillarBasePoint.getPointID(), 
			displayerCenterX + Math.round((pillarBasePoint.getX_coord() - X) * 1000.0) / SCALE,
			displayerCenterY -	Math.round((pillarBasePoint.getY_coord() - Y) * 1000.0) / SCALE);
			transformedPillarBasePoints.add(point);
		}
	}
	
	private void getDisplayerCenterCoords() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    displayerCenterX = ((dimension.getWidth() - this.getWidth()) / 2);
	    displayerCenterY = ((dimension.getHeight() - this.getHeight()) / 2);
	}
	
	private void drawPlateBase(Graphics g) {
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(Color.BLUE);
	        g2d.setStroke(new BasicStroke(2));
	        g2d.draw(new Line2D.Double(
	        			transformedPillarBasePoints.get(1).getX_coord(), 
	        			transformedPillarBasePoints.get(1).getY_coord(),
	        			transformedPillarBasePoints.get(2).getX_coord(),
	        			transformedPillarBasePoints.get(2).getY_coord()));
	        g2d.draw(new Line2D.Double(
	        			transformedPillarBasePoints.get(2).getX_coord(), 
	        			transformedPillarBasePoints.get(2).getY_coord(),
	        			transformedPillarBasePoints.get(3).getX_coord(),
	        			transformedPillarBasePoints.get(3).getY_coord()));
	        g2d.draw(new Line2D.Double(
					   	transformedPillarBasePoints.get(3).getX_coord(), 
					   	transformedPillarBasePoints.get(3).getY_coord(),
					   	transformedPillarBasePoints.get(4).getX_coord(),
					   	transformedPillarBasePoints.get(4).getY_coord()));
	        g2d.draw(new Line2D.Double(
				   		transformedPillarBasePoints.get(4).getX_coord(), 
				   		transformedPillarBasePoints.get(4).getY_coord(),
				   		transformedPillarBasePoints.get(1).getX_coord(),
				   		transformedPillarBasePoints.get(1).getY_coord()));
	        g2d.setColor(Color.RED);
	        float[] dashingPattern1 = {10f, 10f};
	        Stroke stroke = new BasicStroke(2f, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
	        g2d.setStroke(stroke);
	        g2d.draw(new Line2D.Double(
	        			transformedPillarBasePoints.get(5).getX_coord(), 
					   	transformedPillarBasePoints.get(5).getY_coord(),
					   	transformedPillarBasePoints.get(7).getX_coord(),
					   	transformedPillarBasePoints.get(7).getY_coord()));
	        g2d.draw(new Line2D.Double(
	        			transformedPillarBasePoints.get(6).getX_coord(), 
	        			transformedPillarBasePoints.get(6).getY_coord(),
	        			transformedPillarBasePoints.get(8).getX_coord(),
	        			transformedPillarBasePoints.get(8).getY_coord()));
	        g2d.setStroke(new BasicStroke(2));
//	        g2d.draw(new Line2D.Double(
//        				transformedPillarBasePoints.get(6).getX_coord(), 
//        				transformedPillarBasePoints.get(6).getY_coord(),
//        				transformedPillarBasePoints.get(6).getX_coord() - 20,
//        				transformedPillarBasePoints.get(6).getY_coord() - 20));
//	        g2d.draw(new Line2D.Double(
//        				transformedPillarBasePoints.get(6).getX_coord(), 
//        				transformedPillarBasePoints.get(6).getY_coord(),
//        				transformedPillarBasePoints.get(6).getX_coord() - 20,
//        				transformedPillarBasePoints.get(6).getY_coord() + 20));
	        
	    }
	 
	 	private void writeText(Graphics g) {
	 		Graphics2D g2d = (Graphics2D) g;
	 		g2d.setColor(Color.BLACK);
	 		g2d.setFont(new Font("Arial",Font.BOLD, 16));
	 		for (int i = 0; i < pillarBasePoints.size(); i++) {
	 			g2d.drawString(pillarBasePoints.get(i).getPointID(),
						(float)	transformedPillarBasePoints.get(i).getX_coord() + 15, (float) transformedPillarBasePoints.get(i).getY_coord() + 10);
				g2d.drawString(String.valueOf(pillarBasePoints.get(i).getX_coord()),
					(float)	transformedPillarBasePoints.get(i).getX_coord() + 15, (float) transformedPillarBasePoints.get(i).getY_coord() + 30);
				g2d.drawString(String.valueOf(pillarBasePoints.get(i).getY_coord()),
						(float)	transformedPillarBasePoints.get(i).getX_coord() + 15, (float) transformedPillarBasePoints.get(i).getY_coord() + 50);
			}
	 	}
	 	
	 	@Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        drawPlateBase(g);
	        writeText(g);
	    }
	
	
	
	
}
