package perimeter_quiz;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        for (Point currPt : s.getPoints())
        {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double peri = getPerimeter(s);
        int count = getNumPoints(s);
        double avg = peri/count;
        return avg;
    }

    public double getLargestSide(Shape s) {
        
        double max =-1;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            
            
            if (currDist>max)
            {
            max = currDist;
            }
            
            prevPt = currPt;
            
            
        }
        
        return max;
    }

    public double getLargestX(Shape s) {
         double maxX = -9999;
        for(Point currpt : s.getPoints())
        {
        int curr = currpt.getX();
        if(curr>maxX)
        {
        maxX = curr;
        }
        }
        
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double maxP=-9999;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>maxP)
            {
            maxP = length;
            }
            
        }
        
        return maxP;
    }

    public String getFileWithLargestPerimeter() {
        double maxP=-9999;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>maxP)
            {
            maxP = length;
            temp = f; 
            
            }
        }
          // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        double avg = getAverageLength(s);
        double max = getLargestSide(s);
        double maxX = getLargestX(s);
        System.out.println("Perimeter = " + length);
        System.out.println("Points = " + points);
        System.out.println("Average Length = " + avg);
        System.out.println("max side length = " + max);
        System.out.println("max x is = " + maxX);
        
    }
    
    public void testPerimeterMultipleFiles() {
        double maxp = getLargestPerimeterMultipleFiles();
        System.out.println("max Perimeter in  ultiple files is = " + maxp);
    }

    public void testFileWithLargestPerimeter() {
        String filename = getFileWithLargestPerimeter();
        System.out.println("File name is = " + filename);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
       
    }
}
