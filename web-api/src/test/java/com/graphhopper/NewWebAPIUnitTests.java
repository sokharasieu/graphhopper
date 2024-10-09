package com.graphhopper;

import com.github.javafaker.Faker;
import com.graphhopper.util.Helper;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.PointList;
import com.graphhopper.util.shapes.GHPoint;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NewWebAPIUnitTests {

    // GHPoint class tests

    // Test for create method
    // The test makes sure that the method creates the GHPoint object correctly
    @Test
    public void testCreate() {
        // Arrange
        GeometryFactory gf = new GeometryFactory();
        Point jtsPoint = gf.createPoint(new org.locationtech.jts.geom.Coordinate(20.0, 10.0));
        
        // Act
        GHPoint point = GHPoint.create(jtsPoint);

        // Assert
        assertEquals(10.0, point.getLat());
        assertEquals(20.0, point.getLon());
    }

    // PointList class tests

    // Test for add method
    // Test that the method adds a point to the PointList object
    // Test 2d point addition
    @Test
    public void testAdd2DPoint() {
        // Arrange
        PointList pointList = new PointList(10, false);

        // Act
        pointList.add(10.0, 20.0); 

        // Assert
        assertEquals(1, pointList.size());
        assertEquals(10.0, pointList.getLat(0));
        assertEquals(20.0, pointList.getLon(0));
    }

    // Test for add method
    // Test that the method adds a point to the PointList object
    // Tests 3d point addition
    @Test
    public void testAdd3DPoint() {
        // Arrange
        PointList pointList = new PointList(10, true); 
    
        // Act
        pointList.add(10.0, 20.0, 30.0);
    
        // Assert
        assertEquals(1, pointList.size());
        assertEquals(10.0, pointList.getLat(0));
        assertEquals(20.0, pointList.getLon(0));
        assertEquals(30.0, pointList.getEle(0));

        // Verify that the PointList is not empty
        assertFalse(pointList.isEmpty());
        // Add another point and verify the size
        pointList.add(40.0, 50.0, 60.0);
        assertEquals(2, pointList.size());
        assertEquals(40.0, pointList.getLat(1));
        assertEquals(50.0, pointList.getLon(1));
        assertEquals(60.0, pointList.getEle(1));
    }

    // Instruction class tests
    // test setter and getter for instruction distance and time
    // using faker to generate random values

    @Test
    public void testDistanceAndTime() {
        // Arrange
        // faker object
        Faker faker = new Faker();
        Instruction instruction = new Instruction(Instruction.CONTINUE_ON_STREET, "", new PointList());
        double distance = faker.number().randomDouble(2, 0, 1000);
        long time = faker.number().numberBetween(0, 100000);

        // Act
        instruction.setDistance(distance);
        instruction.setTime(time);

        // Assert
        assertEquals(distance, instruction.getDistance());
        assertEquals(time, instruction.getTime());
    }

    // helper class test
    // test for parseList method
    // test that the method parses a string into a list of strings
    @Test
    public void testParseList() {
        // Arrange
        String listStr = "[item1, item2, item3]";

        // Act
        List<String> parsedList = Helper.parseList(listStr);

        // Assert
        assertEquals(List.of("item1", "item2", "item3"), parsedList);
    }
}