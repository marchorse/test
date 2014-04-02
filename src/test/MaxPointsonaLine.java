package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;

import org.math.plot.*;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	
	public String toString() {
		return "Point Coordinate: ("+String.valueOf(x)+", "+String.valueOf(y)+")";
	}
}

public class MaxPointsonaLine {
	
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
        
        //all points are the same.
        boolean flag = true;
        for (int m = 0;m<points.length;m++) {
        	if (!(points[m].x==points[0].x&&points[m].y==points[0].y)) { 
        		flag = false;
        		break;
        	}
        }
        if (flag) return points.length;
        
        int maxPointsNum = 2;
        
        //LineArray
        Line [] lineArray = new Line[points.length*points.length];
        for (int m=0;m<points.length*points.length;m++) {
        	lineArray[m] = new Line();
        }
        
        for (int i=0;i<points.length;i++) {
            for (int j=0;j<points.length;j++) {
                if (j!=i && !(points[i].x==points[j].x && points[i].y==points[j].y)) {
                    int tmpPointsNum = 2;
                    for (int k=0;k<points.length;k++) {
                        if (k!=i && k!=j) {
                        	
                        	//debug information
//                        	System.out.print(i);System.out.print(" ");System.out.print(j);System.out.print(" ");System.out.print(k);
//                        	System.out.println();
//                        	System.out.print(points[i].x);System.out.print(",");System.out.print(points[i].y);System.out.print(";");System.out.print(points[j].x);System.out.print(",");System.out.print(points[j].y);System.out.print(";");System.out.print(points[k].x);System.out.print(",");System.out.print(points[k].y);System.out.print(";");System.out.println();
//                        	System.out.print("("+String.valueOf(points[i].x)+"-"+String.valueOf(points[j].x)+")*"+String.valueOf(points[k].y)+"+("+String.valueOf(points[j].y)+"-"+String.valueOf(points[i].y)+")*"+String.valueOf(points[k].x)+") = ");
//                        	System.out.println((points[i].x-points[j].x)*points[k].y+(points[j].y-points[i].y)*points[k].x);
//                        	System.out.print("("+String.valueOf(points[i].x)+"-"+String.valueOf(points[j].x)+")*"+String.valueOf(points[i].y)+"+("+String.valueOf(points[j].y)+"-"+String.valueOf(points[i].y)+")*"+String.valueOf(points[i].x)+") = ");
//                        	System.out.println((points[i].x-points[j].x)*points[i].y+(points[j].y-points[i].y)*points[i].x);
//                            
                        	//when i and j has the same x and the same y, the equation thinks every other points are on the line!
                        	if (((points[i].x-points[j].x)*points[k].y+(points[j].y-points[i].y)*points[k].x)==
                            		((points[i].x-points[j].x)*points[i].y+(points[j].y-points[i].y)*points[i].x))
                                tmpPointsNum += 1;
                        }
                    }
                    if (tmpPointsNum>maxPointsNum) {
                        maxPointsNum = tmpPointsNum;
                    }
                }
            }
        }
        return maxPointsNum;
    }

	public static void main(String[] args) throws FileNotFoundException {
		//[]
//		Point [] points = new Point[0];
		//[(4,0),(4,-1),(4,5)]
//		Point [] points = new Point[3];
//		points[0] = new Point(4,0);
//		points[1] = new Point(4,-1);
//		points[2] = new Point(4,5);
		//[(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
		
//		Point [] points = new Point[9];
//		points[0] = new Point(84,250);
//		points[1] = new Point(0,0);
//		points[2] = new Point(1,0);
//		points[3] = new Point(0,-70);
//		points[4] = new Point(0,-70);
//		points[5] = new Point(1,-1);
//		points[6] = new Point(21,10);
//		points[7] = new Point(42,90);
//		points[8] = new Point(-42,-230);
		
		//[(1,1),(1,1),(1,1)]
		Point [] points = new Point[3];
		points[0] = new Point(1,1);
		points[1] = new Point(1,1);
		points[2] = new Point(1,1);
		
		//plot points
		if (points.length > 0) {
			double[] plotx = new double[points.length];
			double[] ploty = new double[points.length];
			for (int m=0;m<points.length;m++) {
				plotx[m]=points[m].x;
				ploty[m]=points[m].y;
				System.out.println(points[m]);
			}
			Plot2DPanel plot = new Plot2DPanel();
			plot.addScatterPlot("Points", plotx, ploty);
			JFrame frame = new JFrame("Debug Plot");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 600);
			frame.setContentPane(plot);
			frame.setVisible(true);
		}
        
        MaxPointsonaLine solution = new MaxPointsonaLine();
		
		//PrintStream tmp = System.out;
		//System.setOut(new PrintStream(new FileOutputStream(new File("output.txt"))));
		System.out.println(solution.maxPoints(points));
		//System.setOut(tmp);
		System.out.println("End!");
	}
}
