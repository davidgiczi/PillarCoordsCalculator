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
import mvmxpert.david.giczi.pillarcoordscalculator.domain.SteakoutCoords;

public class WeightBaseDisplayer extends JFrame {

	private static final long serialVersionUID = 1L;

	private List<Point> pillarBasePoints;
	private List<Point> transformedPillarBasePoints;
	private List<SteakoutCoords> controlledCoords;
	private double displayerCenterX;
	private double displayerCenterY;
	private Point directionDisplayerPoint;
	private double rotation = 0;
	private static final double SCALE = 2 * 22.5;
	
	public void setControlledCoords(List<SteakoutCoords> controlledCoords) {
		this.controlledCoords = controlledCoords;
	}

	public WeightBaseDisplayer(List<Point> pillarBasePoints, Point directionPoint, double rotation, String projectName) {
		super(projectName);
		this.pillarBasePoints = pillarBasePoints;
		this.rotation = rotation;
		getDisplayerCenterCoords();
	 	this.directionDisplayerPoint = new Point(directionPoint.getPointID(), 
	 			displayerCenterX + Math.round((directionPoint.getX_coord() - pillarBasePoints.get(0).getX_coord()) * 1000.0) / SCALE,
	 			displayerCenterY - Math.round((directionPoint.getY_coord() - pillarBasePoints.get(0).getY_coord()) * 1000.0) / SCALE);
		transformPillarCoordsForDisplayer();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void transformPillarCoordsForDisplayer() {
		transformedPillarBasePoints = new ArrayList<>();
		double X = pillarBasePoints.get(0).getX_coord();
		double Y = pillarBasePoints.get(0).getY_coord();
		for (Point pillarBasePoint : pillarBasePoints) {
			Point point = new Point(pillarBasePoint.getPointID(),
					displayerCenterX + Math.round((pillarBasePoint.getX_coord() - X) * 1000.0) / SCALE,
					displayerCenterY - Math.round((pillarBasePoint.getY_coord() - Y) * 1000.0) / SCALE);
			transformedPillarBasePoints.add(point);
		}
	}

	private void getDisplayerCenterCoords() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		displayerCenterX = ((dimension.getWidth() - this.getWidth()) / 2);
		displayerCenterY = ((dimension.getHeight() - this.getHeight()) / 2);
	}

	private void drawBase(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(9).getX_coord(),
				transformedPillarBasePoints.get(9).getY_coord(), transformedPillarBasePoints.get(10).getX_coord(),
				transformedPillarBasePoints.get(10).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(10).getX_coord(),
				transformedPillarBasePoints.get(10).getY_coord(), transformedPillarBasePoints.get(11).getX_coord(),
				transformedPillarBasePoints.get(11).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(11).getX_coord(),
				transformedPillarBasePoints.get(11).getY_coord(), transformedPillarBasePoints.get(12).getX_coord(),
				transformedPillarBasePoints.get(12).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(12).getX_coord(),
				transformedPillarBasePoints.get(12).getY_coord(), transformedPillarBasePoints.get(9).getX_coord(),
				transformedPillarBasePoints.get(9).getY_coord()));

		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(13).getX_coord(),
				transformedPillarBasePoints.get(13).getY_coord(), transformedPillarBasePoints.get(14).getX_coord(),
				transformedPillarBasePoints.get(14).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(14).getX_coord(),
				transformedPillarBasePoints.get(14).getY_coord(), transformedPillarBasePoints.get(15).getX_coord(),
				transformedPillarBasePoints.get(15).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(15).getX_coord(),
				transformedPillarBasePoints.get(15).getY_coord(), transformedPillarBasePoints.get(16).getX_coord(),
				transformedPillarBasePoints.get(16).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(16).getX_coord(),
				transformedPillarBasePoints.get(16).getY_coord(), transformedPillarBasePoints.get(13).getX_coord(),
				transformedPillarBasePoints.get(13).getY_coord()));
		
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(17).getX_coord(),
				transformedPillarBasePoints.get(17).getY_coord(), transformedPillarBasePoints.get(18).getX_coord(),
				transformedPillarBasePoints.get(18).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(18).getX_coord(),
				transformedPillarBasePoints.get(18).getY_coord(), transformedPillarBasePoints.get(19).getX_coord(),
				transformedPillarBasePoints.get(19).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(19).getX_coord(),
				transformedPillarBasePoints.get(19).getY_coord(), transformedPillarBasePoints.get(20).getX_coord(),
				transformedPillarBasePoints.get(20).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(20).getX_coord(),
				transformedPillarBasePoints.get(20).getY_coord(), transformedPillarBasePoints.get(17).getX_coord(),
				transformedPillarBasePoints.get(17).getY_coord()));
		
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(21).getX_coord(),
				transformedPillarBasePoints.get(21).getY_coord(), transformedPillarBasePoints.get(22).getX_coord(),
				transformedPillarBasePoints.get(22).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(22).getX_coord(),
				transformedPillarBasePoints.get(22).getY_coord(), transformedPillarBasePoints.get(23).getX_coord(),
				transformedPillarBasePoints.get(23).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(23).getX_coord(),
				transformedPillarBasePoints.get(23).getY_coord(), transformedPillarBasePoints.get(24).getX_coord(),
				transformedPillarBasePoints.get(24).getY_coord()));
		g2d.draw(new Line2D.Double(transformedPillarBasePoints.get(24).getX_coord(),
				transformedPillarBasePoints.get(24).getY_coord(), transformedPillarBasePoints.get(21).getX_coord(),
				transformedPillarBasePoints.get(21).getY_coord()));
		
	        g2d.setColor(Color.RED);
	        float[] dashingPattern1 = {10f, 10f};
	        Stroke stroke = new BasicStroke(2f, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
	        g2d.setStroke(stroke);
	        g2d.draw(new Line2D.Double(
	        			transformedPillarBasePoints.get(1).getX_coord(), 
					   	transformedPillarBasePoints.get(1).getY_coord(),
					   	transformedPillarBasePoints.get(3).getX_coord(),
					   	transformedPillarBasePoints.get(3).getY_coord()));
	        g2d.draw(new Line2D.Double(
	        			transformedPillarBasePoints.get(2).getX_coord(), 
	        			transformedPillarBasePoints.get(2).getY_coord(),
	        			transformedPillarBasePoints.get(4).getX_coord(),
	        			transformedPillarBasePoints.get(4).getY_coord()));
	        g2d.setStroke(new BasicStroke(2));
	        g2d.setColor(Color.MAGENTA);
	            
	        if( rotation == 0) {
		        AzimuthAndDistance azimuth = new AzimuthAndDistance(transformedPillarBasePoints.get(1), transformedPillarBasePoints.get(3));
		        PolarPoint polarPoint1 = new PolarPoint(transformedPillarBasePoints.get(1), 100,
		        		azimuth.calcAzimuth() + Math.PI, "baseLine");
		        PolarPoint polarPoint2 = new PolarPoint(polarPoint1.calcPolarPoint(), 30,
		        		azimuth.calcAzimuth() + Math.PI / 4, "arrow");
		        PolarPoint polarPoint3 = new PolarPoint(polarPoint1.calcPolarPoint(), 30,
		        		azimuth.calcAzimuth() - Math.PI / 4, "arrow");
		        g2d.draw(new Line2D.Double(
	        			transformedPillarBasePoints.get(1).getX_coord(),
	        			transformedPillarBasePoints.get(1).getY_coord(),
	    				polarPoint1.calcPolarPoint().getX_coord(), 
	    				polarPoint1.calcPolarPoint().getY_coord()));
		        g2d.draw(new Line2D.Double(
		        			polarPoint1.calcPolarPoint().getX_coord(),
		        			polarPoint1.calcPolarPoint().getY_coord(),
	        				polarPoint2.calcPolarPoint().getX_coord(), 
	        				polarPoint2.calcPolarPoint().getY_coord()));
		        g2d.draw(new Line2D.Double(
		        			polarPoint1.calcPolarPoint().getX_coord(),
		        			polarPoint1.calcPolarPoint().getY_coord(),
	        				polarPoint3.calcPolarPoint().getX_coord(), 
	        				polarPoint3.calcPolarPoint().getY_coord()));
		  }
		        else {
		        	
		        AzimuthAndDistance azimuthAndDistance = new AzimuthAndDistance(transformedPillarBasePoints.get(0), directionDisplayerPoint);
		  	    PolarPoint polarPoint = 
		  	        		new PolarPoint(transformedPillarBasePoints.get(0), 300, 
		  	        				azimuthAndDistance.calcAzimuth(), "baseLine");
		  	    PolarPoint polarPoint1 = new PolarPoint(polarPoint.calcPolarPoint(), 30,
		        		azimuthAndDistance.calcAzimuth() - 3 * Math.PI / 4, "arrow");
		        PolarPoint polarPoint2 = new PolarPoint(polarPoint.calcPolarPoint(), 30,
		        		azimuthAndDistance.calcAzimuth() + 3 * Math.PI / 4, "arrow");
		  	    g2d.draw(new Line2D.Double(
		  	    		transformedPillarBasePoints.get(0).getX_coord(),
		  	    		transformedPillarBasePoints.get(0).getY_coord(),
	      				polarPoint.calcPolarPoint().getX_coord(), 
	      				polarPoint.calcPolarPoint().getY_coord()));
		  	   g2d.draw(new Line2D.Double(
		  			   polarPoint.calcPolarPoint().getX_coord(), 
		  			   polarPoint.calcPolarPoint().getY_coord(),
		  			   polarPoint1.calcPolarPoint().getX_coord(), 
		  			   polarPoint1.calcPolarPoint().getY_coord()));
		  	   g2d.draw(new Line2D.Double(
		  			   polarPoint.calcPolarPoint().getX_coord(), 
		  			   polarPoint.calcPolarPoint().getY_coord(),
		  			   polarPoint2.calcPolarPoint().getX_coord(), 
		  			   polarPoint2.calcPolarPoint().getY_coord()));
		        }
	      //Scale
	        g2d.setColor(Color.BLACK);
	        g2d.draw(new Line2D.Double(displayerCenterX + 300.0, displayerCenterY + 300.0,
	        						   displayerCenterX + 322.5, displayerCenterY + 300.0));
	        g2d.draw(new Line2D.Double(displayerCenterX + 300.0, displayerCenterY + 295.5,
					   displayerCenterX + 300.0, displayerCenterY + 304.5));
	        g2d.draw(new Line2D.Double(displayerCenterX + 322.5, displayerCenterY + 295.5,
					   displayerCenterX + 322.5, displayerCenterY + 304.5));
	}
	
	private void writeCoords(Graphics g) {
		float X = 100f;
		float Y = 80f;
		Graphics2D g2d = (Graphics2D) g;
 		g2d.setFont(new Font("Arial",Font.BOLD, 16));
 		for (Point pillarBasePoint : pillarBasePoints) {
 			g2d.setColor(Color.BLACK);
 			g2d.drawString(pillarBasePoint.getPointID(), X, Y);
 			X += 80f;
 			g2d.setColor(Color.RED);
 			g2d.drawString(String.valueOf(pillarBasePoint.getX_coord()), X, Y);
 			X += 110f;
			g2d.drawString(String.valueOf(pillarBasePoint.getY_coord()), X, Y);
			X = 100f;
			Y += 30f;
		}
		
	}

	private void writeCoordDifference(Graphics g) {
		float X = 100f;
		float Y = 80f;
		Graphics2D g2d = (Graphics2D) g;
 		g2d.setFont(new Font("Arial",Font.BOLD, 16));
 		for (SteakoutCoords steakoutedCoord : controlledCoords) {
 			g2d.setColor(Color.BLACK);
 			g2d.drawString(steakoutedCoord.getPointID(), X, Y);
 			X += 80f;
 			g2d.setColor(Color.RED);
 			g2d.drawString(steakoutedCoord.getDeltaX(), X, Y);
 			X += 110f;
			g2d.drawString(steakoutedCoord.getDeltaY(), X, Y);
			X = 100f;
			Y += 30f;
		}
		
	}
	
	private void writeText(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.MAGENTA);
			AzimuthAndDistance azimuthAndDistance = new AzimuthAndDistance(transformedPillarBasePoints.get(0), directionDisplayerPoint);
 	  	    PolarPoint polarPoint = 
 	  	        		new PolarPoint(transformedPillarBasePoints.get(0), 300, 
 	  	        				azimuthAndDistance.calcAzimuth(), "baseLine");
	 		if( rotation == 0) {
	 			g2d.drawString(directionDisplayerPoint.getPointID(), (float) polarPoint.calcPolarPoint().getX_coord(),
	 					(float) (polarPoint.calcPolarPoint().getY_coord() + 50));
	 		}
	 		else {
	 	  	    g2d.drawString(directionDisplayerPoint.getPointID(), (float) polarPoint.calcPolarPoint().getX_coord(), 
	 	  		(float) (polarPoint.calcPolarPoint().getY_coord() + 50));
	 		}
			
	 	g2d.setColor(Color.BLACK);
		g2d.drawString("1m", (float) (displayerCenterX + 300), (float) (displayerCenterY + 290));
		g2d.drawString("M= 1:200", (float) (displayerCenterX + 300), (float) (displayerCenterY + 260));
		
		g2d.drawString(pillarBasePoints.get(0).getPointID(),
				(float) (transformedPillarBasePoints.get(0).getX_coord()),
				(float) (transformedPillarBasePoints.get(0).getY_coord() - 10));
		for(int i = 1; i < 5; i++) {
			g2d.drawString(pillarBasePoints.get(i).getPointID(),
					(float) (transformedPillarBasePoints.get(i).getX_coord() + 10),
					(float) (transformedPillarBasePoints.get(i).getY_coord() + 10));
		}
		
		g2d.drawString(pillarBasePoints.get(5).getPointID(),
					(float) (transformedPillarBasePoints.get(5).getX_coord() + 10),
					(float) (transformedPillarBasePoints.get(5).getY_coord() + 20));
		g2d.drawString(pillarBasePoints.get(6).getPointID(),
				(float) (transformedPillarBasePoints.get(6).getX_coord() - 20),
				(float) (transformedPillarBasePoints.get(6).getY_coord() - 10));
		g2d.drawString(pillarBasePoints.get(7).getPointID(),
				(float) (transformedPillarBasePoints.get(7).getX_coord() + 10),
				(float) (transformedPillarBasePoints.get(7).getY_coord() - 20));
		g2d.drawString(pillarBasePoints.get(8).getPointID(),
				(float) (transformedPillarBasePoints.get(8).getX_coord() + 10),
				(float) (transformedPillarBasePoints.get(8).getY_coord() - 20));
		
		DecimalFormat df = new DecimalFormat("###.###");
		AzimuthAndDistance distance1 = new AzimuthAndDistance(pillarBasePoints.get(0), pillarBasePoints.get(1));
		AzimuthAndDistance distance2 = new AzimuthAndDistance(pillarBasePoints.get(0), pillarBasePoints.get(2));
		AzimuthAndDistance tr01 = new AzimuthAndDistance(transformedPillarBasePoints.get(0), transformedPillarBasePoints.get(1));
		g2d.rotate(distance2.calcAzimuth() + Math.PI,
				transformedPillarBasePoints.get(0).getX_coord(), transformedPillarBasePoints.get(0).getY_coord());
		g2d.drawString(df.format(distance1.calcDistance()) + "m", 
			(float)	(transformedPillarBasePoints.get(0).getX_coord() + tr01.calcDistance() / 2), 
			(float) (transformedPillarBasePoints.get(0).getY_coord() - 10));
		g2d.rotate( 3 * Math.PI / 2,
				transformedPillarBasePoints.get(0).getX_coord(), transformedPillarBasePoints.get(0).getY_coord());
		g2d.drawString(df.format(distance2.calcDistance()) + "m", 
				(float)	(transformedPillarBasePoints.get(0).getX_coord() + tr01.calcDistance() / 2), 
				(float) (transformedPillarBasePoints.get(0).getY_coord() - 10));
	}
	
	private void drawBaseWithSize(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		double horizontalHoleSize = 
				new AzimuthAndDistance(transformedPillarBasePoints.get(10), transformedPillarBasePoints.get(11)).calcDistance();
		double verticalHoleSize = 
				new AzimuthAndDistance(transformedPillarBasePoints.get(9), transformedPillarBasePoints.get(10)).calcDistance();
		double horizontalPath = 
				new AzimuthAndDistance(transformedPillarBasePoints.get(5), transformedPillarBasePoints.get(7)).calcDistance();
		double verticalPath = 
				new AzimuthAndDistance(transformedPillarBasePoints.get(6), transformedPillarBasePoints.get(8)).calcDistance();
		double horizontalDistance = horizontalPath - horizontalHoleSize;
		double verticalDistance = verticalPath - verticalHoleSize;
		g2d.setColor(Color.RED);
        float[] dashingPattern = {10f, 10f};
        Stroke stroke = new BasicStroke(2f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 1.0f, dashingPattern, 2.0f);
        g2d.setStroke(stroke);
        double x = 1300;
        double y = 300;
		g2d.draw(new Line2D.Double(x, y, x + verticalPath /2, y));
		g2d.draw(new Line2D.Double(x, y, x - verticalPath / 2, y));
		g2d.draw(new Line2D.Double(x, y, x, y - horizontalPath / 2));
		g2d.draw(new Line2D.Double(x, y, x, y + horizontalPath / 2));
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2)); //left-up hole
		g2d.draw(new Line2D.Double(x - verticalPath / 2 + verticalHoleSize, y - horizontalPath / 2 + horizontalHoleSize,
				x - verticalPath / 2 + verticalHoleSize, y - horizontalPath / 2));
		g2d.draw(new Line2D.Double(x - verticalPath / 2 + verticalHoleSize, y - horizontalPath / 2,
				x - verticalPath / 2, y - horizontalPath / 2));
		g2d.draw(new Line2D.Double(x - verticalPath / 2, y - horizontalPath / 2,
				x - verticalPath / 2, y - horizontalPath / 2 + horizontalHoleSize));
		g2d.draw(new Line2D.Double(x - verticalPath / 2, y - horizontalPath / 2 + horizontalHoleSize,
				x - verticalPath / 2 + verticalHoleSize, y - horizontalPath / 2 + horizontalHoleSize));
		
		g2d.setColor(Color.BLACK);
		g2d.drawString(pillarBasePoints.get(20).getPointID(), (int) (x - verticalPath / 2 + verticalHoleSize - 20), 
															(int) (y - horizontalPath / 2 + horizontalHoleSize + 15));
		g2d.drawString(pillarBasePoints.get(17).getPointID(), (int) (x - verticalPath / 2 + verticalHoleSize - 20), 
				(int) (y - horizontalPath / 2 - 5));
		g2d.drawString(pillarBasePoints.get(19).getPointID(), (int) (x - verticalPath / 2 - 20), 
															(int) (y - horizontalPath / 2 + horizontalHoleSize + 15));
		g2d.drawString(pillarBasePoints.get(18).getPointID(), (int) (x - verticalPath / 2 - 20), 
				(int) (y - horizontalPath / 2 - 5));
		
		//right-up hole
		g2d.setColor(Color.BLUE);
		g2d.draw(new Line2D.Double(x + verticalPath / 2 - verticalHoleSize, y - horizontalPath / 2 + horizontalHoleSize,
				x + verticalPath / 2 - verticalHoleSize, y - horizontalPath / 2));
		g2d.draw(new Line2D.Double(x + verticalPath / 2 - verticalHoleSize, y - horizontalPath / 2,
				x + verticalPath / 2, y - horizontalPath / 2));
		g2d.draw(new Line2D.Double(x + verticalPath / 2, y - horizontalPath / 2,
				x + verticalPath / 2, y - horizontalPath / 2 + horizontalHoleSize));
		g2d.draw(new Line2D.Double(x + verticalPath / 2, y - horizontalPath / 2 + horizontalHoleSize,
				x + verticalPath / 2 - verticalHoleSize, y - horizontalPath / 2 + horizontalHoleSize));
		
		g2d.setColor(Color.BLACK);
		g2d.drawString(pillarBasePoints.get(16).getPointID(), (int) (x + verticalPath / 2 - verticalHoleSize - 20), 
															(int) (y - horizontalPath / 2 + horizontalHoleSize + 15));
		g2d.drawString(pillarBasePoints.get(13).getPointID(), (int) (x + verticalPath / 2 - 20), 
				(int) (y - horizontalPath / 2 + horizontalHoleSize + 15));
		g2d.drawString(pillarBasePoints.get(14).getPointID(), (int) (x + verticalPath / 2 - 20), 
															(int) (y - horizontalPath / 2 - 5));
		g2d.drawString(pillarBasePoints.get(15).getPointID(), (int) (x + verticalPath / 2 - verticalHoleSize - 20), 
				(int) (y - horizontalPath / 2 - 5));
		
		//left-down hole
		g2d.setColor(Color.BLUE);
		g2d.draw(new Line2D.Double(x + verticalPath / 2 - verticalHoleSize, y + horizontalPath / 2 - horizontalHoleSize,
				x + verticalPath / 2 - verticalHoleSize, y + horizontalPath / 2));
		g2d.draw(new Line2D.Double(x + verticalPath / 2 - verticalHoleSize, y + horizontalPath / 2,
				x + verticalPath / 2, y + horizontalPath / 2));
		g2d.draw(new Line2D.Double(x + verticalPath / 2, y + horizontalPath / 2,
				x + verticalPath / 2, y + horizontalPath / 2 - horizontalHoleSize));
		g2d.draw(new Line2D.Double(x + verticalPath / 2, y + horizontalPath / 2 - horizontalHoleSize,
				x + verticalPath / 2 - verticalHoleSize, y + horizontalPath / 2 - horizontalHoleSize));
		
		g2d.setColor(Color.BLACK);
		g2d.drawString(pillarBasePoints.get(24).getPointID(), (int) (x - verticalPath / 2 + verticalHoleSize - 20), 
															(int) (y + horizontalPath / 2 - horizontalHoleSize - 5));
		g2d.drawString(pillarBasePoints.get(23).getPointID(), (int) (x - verticalPath / 2 + verticalHoleSize - 20), 
				(int) (y + horizontalPath / 2 + 15));
		g2d.drawString(pillarBasePoints.get(21).getPointID(), (int) (x - verticalPath / 2 - 20), 
															(int) (y + horizontalPath / 2 - horizontalHoleSize - 5));
		g2d.drawString(pillarBasePoints.get(22).getPointID(), (int) (x - verticalPath / 2 - 20), 
				(int) (y + horizontalPath / 2 + 15));
		
		//right-down hole
		g2d.setColor(Color.BLUE);
		g2d.draw(new Line2D.Double(x - verticalPath / 2 + verticalHoleSize, y + horizontalPath / 2 - horizontalHoleSize,
				x - verticalPath / 2 + verticalHoleSize, y + horizontalPath / 2));
		g2d.draw(new Line2D.Double(x - verticalPath / 2 + verticalHoleSize, y + horizontalPath / 2,
				x - verticalPath / 2, y + horizontalPath / 2));
		g2d.draw(new Line2D.Double(x - verticalPath / 2, y + horizontalPath / 2,
				x - verticalPath / 2, y + horizontalPath / 2 - horizontalHoleSize));
		g2d.draw(new Line2D.Double(x - verticalPath / 2, y + horizontalPath / 2 - horizontalHoleSize,
				x - verticalPath / 2 + verticalHoleSize, y + horizontalPath / 2 - horizontalHoleSize));
		
		g2d.setColor(Color.BLACK);
		g2d.drawString(pillarBasePoints.get(11).getPointID(), (int) (x + verticalPath / 2 - verticalHoleSize - 20), 
															(int) (y + horizontalPath / 2 - horizontalHoleSize - 5));
		g2d.drawString(pillarBasePoints.get(12).getPointID(), (int) (x + verticalPath / 2 - 20), 
				(int) (y + horizontalPath / 2 - horizontalHoleSize  - 5));
		g2d.drawString(pillarBasePoints.get(9).getPointID(), (int) (x + verticalPath / 2 - 20), 
															(int) (y + horizontalPath / 2 + 15));
		g2d.drawString(pillarBasePoints.get(10).getPointID(), (int) (x + verticalPath / 2 - verticalHoleSize - 20), 
				(int) (y + horizontalPath / 2 + 15));
		
		g2d.draw(new Line2D.Double(x - verticalDistance / 2, y - horizontalPath / 2 - 40, 
				x + verticalDistance / 2, y - horizontalPath / 2 - 40));
		g2d.draw(new Line2D.Double(x - verticalDistance / 2, y - horizontalPath / 2 - 45, 
				x - verticalDistance / 2, y - horizontalPath / 2 - 35));
		g2d.draw(new Line2D.Double(x + verticalDistance / 2, y - horizontalPath / 2 - 45, 
				x + verticalDistance / 2, y - horizontalPath / 2 - 35));
		g2d.draw(new Line2D.Double(x - verticalPath / 2 - 40, y - horizontalDistance / 2,
				x - verticalPath / 2 - 40, y + horizontalDistance / 2));
		g2d.draw(new Line2D.Double(x - verticalPath / 2 - 45, y - horizontalDistance / 2,
				x - verticalPath / 2 - 35, y - horizontalDistance / 2));
		g2d.draw(new Line2D.Double(x - verticalPath / 2 - 45, y + horizontalDistance / 2,
				x - verticalPath / 2 - 35, y + horizontalDistance / 2));
	
		DecimalFormat df = new DecimalFormat("###.###");
		AzimuthAndDistance verticalHoleDistance = new AzimuthAndDistance(pillarBasePoints.get(9), pillarBasePoints.get(10));
		AzimuthAndDistance verticalPathDistance =
				new AzimuthAndDistance(pillarBasePoints.get(6), pillarBasePoints.get(8));
		double verticalSize = verticalPathDistance.calcDistance() - verticalHoleDistance.calcDistance();
		g2d.drawString(df.format(verticalSize) + "m", (int) (x - 20), (int) (y - horizontalPath / 2) - 50);
		AzimuthAndDistance horizontalHoleDistance =
				new AzimuthAndDistance(pillarBasePoints.get(10), pillarBasePoints.get(11));
		AzimuthAndDistance horizontalPathDistance =
				new AzimuthAndDistance(pillarBasePoints.get(5), pillarBasePoints.get(7));
		double horizontalSize = horizontalPathDistance.calcDistance() - horizontalHoleDistance.calcDistance();
		g2d.drawString(df.format(horizontalSize) + "m", (int) (x - verticalPath / 2) - 100, (int) y);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawBase(g);
		if( controlledCoords.isEmpty() ) {
			writeCoords(g);	
		}
		else {
			writeCoordDifference(g);
		}
		drawBaseWithSize(g);
		writeText(g);
	}
}
