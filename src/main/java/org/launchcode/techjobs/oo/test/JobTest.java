package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
      Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
       Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob1 instanceof Job);
        assertTrue(testJob1.getEmployer() instanceof  Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob1.getName(), "Product tester");
        assertEquals(testJob1.getEmployer().getValue(), "ACME");
        assertEquals(testJob1.getLocation().getValue(), "Desert");
        assertEquals(testJob1.getPositionType().getValue(), "Quality control");
        assertEquals(testJob1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertFalse(testJob1.getId() == testJob2.getId());;
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char endingChar = testJob1.toString().charAt(testJob1.toString().length()-1);
        assertEquals( '\n', testJob1.toString().charAt(0));
        assertEquals('\n', endingChar);
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected= "\nID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";
        assertEquals(testJob1.toString(), expected);
    }



    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob1 = new Job("",  new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected= "\nID: 1\n" +
                "Name: Data not available\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";
        assertEquals(testJob1.toString(), expected);
    }






}



