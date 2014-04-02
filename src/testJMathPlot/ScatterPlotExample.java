package testJMathPlot;

import javax.swing.JFrame;

import org.math.plot.*;

import test.MaxPointsonaLine;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	
	public String toString() {
		return "Point Coordinate: ("+String.valueOf(x)+", "+String.valueOf(y)+")";
	}
}


public class ScatterPlotExample {
	
	class Line {
		int point1;
		int point2;
		public Line () {
			point1 = -1;
			point2 = -1;
		}
		public Line (int point1, int point2) {
			this.point1 = point1;
			this.point2 = point2;
		}
		
		public String toString() {
			return "Line constructed with point indexes: "+String.valueOf(point1)+", "+String.valueOf(point2);
		}
	}
	
    public int maxPoints(Point[] points) {
        if (points.length<2) return points.length;
        int maxPointsNum = 2;
        
        //plot points
        double[] plotx = new double[points.length];
        double[] ploty = new double[points.length];
        for (int m=0;m<points.length;m++) {
        	plotx[m]=points[m].x;
        	ploty[m]=points[m].y;
        }
        Plot2DPanel plot = new Plot2DPanel();
        plot.addScatterPlot("Points", plotx, ploty);
        JFrame frame = new JFrame("a plot panel");
        frame.setContentPane(plot);
        frame.setVisible(true);
        
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[(4,0),(4,-1),(4,5)]
		//Point [] points = new Point[3];
		//[(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
		Point [] points = new Point[9];
		points[0] = new Point(84,250);
		points[1] = new Point(0,0);
		points[2] = new Point(1,0);
		points[3] = new Point(0,-70);
		points[4] = new Point(0,-70);
		points[5] = new Point(1,-1);
		points[6] = new Point(21,10);
		points[7] = new Point(42,90);
		points[8] = new Point(42,230);
		System.out.println(new ScatterPlotExample().maxPoints(points));
	}
}