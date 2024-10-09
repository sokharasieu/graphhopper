package com.graphhopper.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PointListTest {

    /*
     * Test for Reverse method for 2D PointLists
     * 
     * Ensures that the method reverses the order of the points in the PointList object
     */
    @Test
    public void testReverse2D() {
        //Arrange
        PointList pointList = new PointList();
        pointList.add(10, 2);
        pointList.add(3, 40);
        pointList.add(50, 6);

        //Act
        pointList.reverse();

        //Assert
        assertEquals(50, pointList.getLat(0), 1e-6);
        assertEquals(6, pointList.getLon(0), 1e-6);
        assertEquals(3, pointList.getLat(1), 1e-6);
        assertEquals(40, pointList.getLon(1), 1e-6);
        assertEquals(10, pointList.getLat(2), 1e-6);
        assertEquals(2, pointList.getLon(2), 1e-6);
    }

    /*
     * Test for the add(PointList points) method
     * 
     * Ensures that the method appends a list of points to another already existing PointList object
     */
    @Test
    public void testAddPointListPoints(){
        //Arrange
        PointList pointList = new PointList();
        PointList pointList2 = new PointList();
        pointList.add(10, 2);
        pointList.add(3, 40);
        pointList.add(50, 6);
        pointList2.add(60, 5);
        pointList2.add(4, 30);
        pointList2.add(20, 1);

        //Act
        pointList.add(pointList2);

        //Assert
        assertEquals(10, pointList.getLat(0), 1e-6);
        assertEquals(2, pointList.getLon(0), 1e-6);
        assertEquals(3, pointList.getLat(1), 1e-6);
        assertEquals(40, pointList.getLon(1), 1e-6);
        assertEquals(50, pointList.getLat(2), 1e-6);
        assertEquals(6, pointList.getLon(2), 1e-6);
        assertEquals(60, pointList.getLat(3), 1e-6);
        assertEquals(5, pointList.getLon(3), 1e-6);
        assertEquals(4, pointList.getLat(4), 1e-6);
        assertEquals(30, pointList.getLon(4), 1e-6);
        assertEquals(20, pointList.getLat(5), 1e-6);
        assertEquals(1, pointList.getLon(5), 1e-6);
        assertEquals(6, pointList.size());
    }


    /*
     * Test for clone method
     * 
     * Checks that the method creates a clone of the PointList object that respects the prescribed characteristics
     */
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void testClone(boolean immutable){
        //Arrange
        PointList pointList = new PointList();
        PointList pointList2;
        pointList.add(10, 2);
        pointList.add(3, 40);
        pointList.add(50, 6);
        pointList.add(7, 80);
        
        if (immutable){
            pointList.makeImmutable();
        }

        //Act
        pointList2 = pointList.clone(false);

        //Assert
        assertEquals(false, pointList2.isImmutable());
        assertEquals(pointList.size(), pointList2.size());
        for(int i = 0; i < pointList.size(); i++){
            assertEquals(pointList.getLat(i), pointList2.getLat(i), 1e-6);
            assertEquals(pointList.getLon(i), pointList2.getLon(i), 1e-6);
        }
    }

    /*
     * Test for the hashCode function
     * 
     * Checks that hashCode produces the same value for two PointList objects iff they are equal as prescribed in the implementation requirements
     */
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void testHashCode(boolean different){
        //Arrange
        PointList pointList = new PointList();
        PointList pointList2;
        pointList.add(10, 2);
        pointList.add(3, 40);
        pointList.add(50, 6);
        pointList.add(7, 80);
        pointList2 = pointList.clone(different);
        boolean equal = pointList.equals(pointList2);

        //Act
        int hash1 = pointList.hashCode();
        int hash2 = pointList2.hashCode();

        //Assert
        assertEquals(equal, hash1 == hash2);
    }


    /*
     * Test for the copy method
     * 
     * Checks that the method creates a PointList object that contains a strict subset of the points from the original PointList object
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void testCopy(int from){
        //Arrange
        PointList pointList = new PointList();
        PointList pointList2;
        pointList.add(10, 2);
        pointList.add(3, 40);
        pointList.add(50, 6);
        pointList.add(7, 80);
        int expectedSize = 3-from;

        //Act
        pointList2 = pointList.copy(from, 3);

        //Assert
        assertEquals(expectedSize, pointList2.size());
        for(int i = 0; i < expectedSize; i++){
            assertEquals(pointList.getLat(i+from), pointList2.getLat(i), 1e-6);
            assertEquals(pointList.getLon(i+from), pointList2.getLon(i), 1e-6);
        }
    }
    
}
