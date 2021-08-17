package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.launchcode.techjobs.oo.*;


import static org.junit.Assert.*;

import javax.xml.namespace.QName;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job job1, job2, job3, job4, job5;


@Before
public void init(){
    job1 = new Job();
    job2 = new Job();
    job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));

}

    @Test
   public void testSettingJobId(){

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        assertEquals("Product tester", job3.getName().toString());
        assertEquals("ACME", job3.getEmployer().toString());
        assertEquals("Desert", job3.getLocation().toString());
        assertEquals("Quality control", job3.getPositionType().toString());
        assertEquals("Persistence", job3.getCoreCompetency().toString());
        assertTrue(job3 instanceof Job);
//        assertTrue(acme instanceof Employer);
//        assertTrue(desert instanceof Location);
//        assertTrue(qualityControl instanceof PositionType);
//        assertTrue(persistence instanceof CoreCompetency);
    }
//
    @Test
    public void testJobsForEquality(){
        assertNotEquals(job3, job4);
    }
//
//
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
    String job = job3.toString();
    Character line = '\n';
    assertTrue(job.charAt(0) == line);
    assertTrue(job.charAt(job.length()-1) == line);

    }
////test above tests for correct formatting totally
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String expected = "\nID: _______" + job3.getId() + "_______\n" +
                "Name: _______Product tester_______\n" +
                "Employer: _______ACME_______\n" +
                "Location: _______Desert_______\n" +
                "Position Type: _______Quality control_______\n" +
                "Core Competency: _______Persistence_______\n";
        assertEquals(expected, job3.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        String expected = "\nID: _______" + job5.getId() + "_______\n" +
                "Name: _______Product tester_______\n" +
                "Employer: _______ACME_______\n" +
                "Location: _______Desert_______\n" +
                "Position Type: _______Quality control_______\n" +
                "Core Competency: _______Data not available_______\n";
        assertEquals(expected, job5.toString());
    }



}
