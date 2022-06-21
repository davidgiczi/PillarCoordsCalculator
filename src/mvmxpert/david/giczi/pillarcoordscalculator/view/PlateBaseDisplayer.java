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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.AzimuthAndDistance;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.Point;
import mvmxpert.david.giczi.pillarcoordscalculator.domain.PolarPoint;

public class PlateBaseDisplayer extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	private List<Point> pillarBasePoints;
	private List<Point> transformedPillarBasePoints;
	private double displayerCenterX;
	private double displayerCenterY;
	private String directionPointId;

	public PlateBaseDisplayer(List<Point> pillarBasePoints, String projectName) {
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
		
	public String getDirectionPointId() {
		return directionPointId;
	}



	public void setDirectionPointId(String directionPointId) {
		this.directionPointId = directionPointId;
	}



	private void transformPillarCoordsForDisplayer(){
		transformedPillarBasePoints = new ArrayList<>();
		double X = pillarBasePoints.get(0).getX_coord();
		double Y = pillarBasePoints.get(0).getY_coord();
		for (Point pillarBasePoint : pillarBasePoints) {
			Point point = new Point(pillarBasePoint.getPointID(), 
			displayerCenterX + Math.round((pillarBasePoint.getX_coord() - X) * 1000.0) / (2 * 22.5),
			displayerCenterY -	Math.round((pillarBasePoint.getY_coord() - Y) * 1000.0) / (2 * 22.5));
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
	        g2d.setColor(Color.BLACK);
	        AzimuthAndDistance azimuth = new AzimuthAndDistance(transformedPillarBasePoints.get(6), transformedPillarBasePoints.get(8));
	        PolarPoint polarPoint1 = new PolarPoint(transformedPillarBasePoints.get(6), 30,
	        		azimuth.calcAzimuthFromPointAToPointB() + Math.PI / 4, null);
	        g2d.draw(new Line2D.Double(
	        			polarPoint1.calcPolarPoint().getX_coord(),
	        			polarPoint1.calcPolarPoint().getY_coord(),
        				transformedPillarBasePoints.get(6).getX_coord(), 
        				transformedPillarBasePoints.get(6).getY_coord()));
	        PolarPoint polarPoint2 = new PolarPoint(transformedPillarBasePoints.get(6), 30,
	        		azimuth.calcAzimuthFromPointAToPointB() - Math.PI / 4, null);
	        g2d.draw(new Line2D.Double(
	        			polarPoint2.calcPolarPoint().getX_coord(),
	        			polarPoint2.calcPolarPoint().getY_coord(),
        				transformedPillarBasePoints.get(6).getX_coord(), 
        				transformedPillarBasePoints.get(6).getY_coord()));
	        PolarPoint polarPoint3 = new PolarPoint(transformedPillarBasePoints.get(6), 40,
	        		azimuth.calcAzimuthFromPointAToPointB(), null);
	        g2d.draw(new Line2D.Double(
	        			polarPoint3.calcPolarPoint().getX_coord(),
	        			polarPoint3.calcPolarPoint().getY_coord(),
        				transformedPillarBasePoints.get(6).getX_coord(), 
        				transformedPillarBasePoints.get(6).getY_coord()));
	      //Scale
	        g2d.draw(new Line2D.Double(displayerCenterX + 300.0, displayerCenterY + 300.0,
	        						   displayerCenterX + 322.5, displayerCenterY + 300.0));
	        g2d.draw(new Line2D.Double(displayerCenterX + 300.0, displayerCenterY + 295.5,
					   displayerCenterX + 300.0, displayerCenterY + 304.5));
	        g2d.draw(new Line2D.Double(displayerCenterX + 322.5, displayerCenterY + 295.5,
					   displayerCenterX + 322.5, displayerCenterY + 304.5));
	    }
	 
	 	private void writeText(Graphics g) {
	 		Graphics2D g2d = (Graphics2D) g;
	 		
	 		g2d.setFont(new Font("Arial",Font.BOLD, 16));
	 		for (int i = 0; i < pillarBasePoints.size(); i++) {
	 			g2d.setColor(Color.BLACK);
	 			g2d.drawString(pillarBasePoints.get(i).getPointID(),
						(float)	transformedPillarBasePoints.get(i).getX_coord() + 15, (float) transformedPillarBasePoints.get(i).getY_coord() + 20);
	 			g2d.setColor(Color.RED);
				g2d.drawString(String.valueOf(pillarBasePoints.get(i).getX_coord()),
					(float)	transformedPillarBasePoints.get(i).getX_coord() + 15, (float) transformedPillarBasePoints.get(i).getY_coord() + 40);
				g2d.drawString(String.valueOf(pillarBasePoints.get(i).getY_coord()),
						(float)	transformedPillarBasePoints.get(i).getX_coord() + 15, (float) transformedPillarBasePoints.get(i).getY_coord() + 60);
			}
	 		g2d.setColor(Color.BLACK);
	 		g2d.drawString(directionPointId, (float) transformedPillarBasePoints.get(6).getX_coord(), 
	 				(float) transformedPillarBasePoints.get(6).getY_coord() - 40);
	 		g2d.drawString("1m", (float) displayerCenterX + 300, (float) displayerCenterY + 290);
	 		g2d.drawString("M= 1:200", (float) displayerCenterX + 300, (float) displayerCenterY + 350);
	 		
	 		AzimuthAndDistance base14 = new AzimuthAndDistance(pillarBasePoints.get(1), pillarBasePoints.get(4));
	 		AzimuthAndDistance tr14 = new AzimuthAndDistance(transformedPillarBasePoints.get(1), transformedPillarBasePoints.get(4));
	 		AzimuthAndDistance tr34 = new AzimuthAndDistance(transformedPillarBasePoints.get(3), transformedPillarBasePoints.get(4));
	 		DecimalFormat df = new DecimalFormat("###.###");
	        g2d.rotate(base14.calcAzimuthFromPointAToPointB() + Math.PI / 2,
	        		(float) transformedPillarBasePoints.get(0).getX_coord(),
	        		(float) transformedPillarBasePoints.get(0).getY_coord());
	 		g2d.drawString(df.format(base14.calcDistanceBetweenTheTwoPoints()) + "m",
	 				(float) transformedPillarBasePoints.get(0).getX_coord() + 10,
	 				(float) (transformedPillarBasePoints.get(0).getY_coord() - (tr34.calcDistanceBetweenTheTwoPoints() + 10) / 2));
	 		AzimuthAndDistance base68 = new AzimuthAndDistance(pillarBasePoints.get(6), pillarBasePoints.get(8));
	 		g2d.drawString(df.format((base68.calcDistanceBetweenTheTwoPoints() - base14.calcDistanceBetweenTheTwoPoints()) / 2) + "m",
	 				(float) (transformedPillarBasePoints.get(0).getX_coord() - (tr14.calcDistanceBetweenTheTwoPoints() + 100) / 2),
	 				(float) transformedPillarBasePoints.get(0).getY_coord() - 10);
	 		
	 		AzimuthAndDistance base34 = new AzimuthAndDistance(pillarBasePoints.get(3), pillarBasePoints.get(4));
	 		g2d.rotate(- Math.PI / 2,
	        		(float) transformedPillarBasePoints.get(0).getX_coord(),
	        		(float) transformedPillarBasePoints.get(0).getY_coord());
	 		g2d.drawString(df.format(base34.calcDistanceBetweenTheTwoPoints()) + "m",
	 				(float) transformedPillarBasePoints.get(0).getX_coord() + 10,
	 				(float) (transformedPillarBasePoints.get(0).getY_coord() + (tr14.calcDistanceBetweenTheTwoPoints() - 10) / 2));
	 		AzimuthAndDistance base57 = new AzimuthAndDistance(pillarBasePoints.get(5), pillarBasePoints.get(7));
	 		g2d.drawString(df.format((base57.calcDistanceBetweenTheTwoPoints() - base34.calcDistanceBetweenTheTwoPoints()) / 2) + "m",
	 				(float) (transformedPillarBasePoints.get(0).getX_coord() - (tr34.calcDistanceBetweenTheTwoPoints() + 100) / 2),
	 				(float) transformedPillarBasePoints.get(0).getY_coord() - 10);
	 	}
	 	
	 	@Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        drawPlateBase(g);
	        writeText(g);
	    }
	
	
	
	
}
