package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.launchcode.techjobs.oo.Job;
import static org.junit.Assert.*;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;

import javax.xml.namespace.QName;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Employer acme;
    Location desert;
    PositionType qualityControl;
    CoreCompetency persistence;
    Job job1;
    Job job2;
    Job job3;

@Before
public void init(){

        job1 = new Job("Product tester", acme = new Employer("ACME"), desert = new Location("Desert"), qualityControl = new PositionType("Quality control"), persistence = new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", acme = new Employer("ACME"), desert = new Location("Desert"), qualityControl = new PositionType("Quality control"), persistence = new CoreCompetency("Persistence"));
        job3 = new Job("Product tester", acme = new Employer("ACME"), desert = new Location("Desert"), qualityControl = new PositionType("Quality control"), persistence = new CoreCompetency(""));
}

    @Test
   public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        assertEquals("Product tester", job1.getName().toString());
        assertEquals("ACME", job1.getEmployer().toString());
        assertEquals("Desert", job1.getLocation().toString());
        assertEquals("Quality control", job1.getPositionType().toString());
        assertEquals("Persistence", job1.getCoreCompetency().toString());
        assertTrue(job1 instanceof Job);
        assertTrue(acme instanceof Employer);
        assertTrue(desert instanceof Location);
        assertTrue(qualityControl instanceof PositionType);
        assertTrue(persistence instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertNotEquals(job1, job2);
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine(){
    String job = job1.toString();
    Character line = '\n';
    assertTrue(job.charAt(0) == line);
    assertTrue(job.charAt(job.length()-1) == line);


    }
//test above tests for correct formatting totally
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String expected = "\nID: _______" + job1.getId() + "_______\n" +
                "Name: _______Product tester_______\n" +
                "Employer: _______ACME_______\n" +
                "Location: _______Desert_______\n" +
                "Position Type: _______Quality control_______\n" +
                "Core Competency: _______Persistence_______\n";
        assertEquals(expected, job1.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        String expected = "\nID: _______" + job3.getId() + "_______\n" +
                "Name: _______Product tester_______\n" +
                "Employer: _______ACME_______\n" +
                "Location: _______Desert_______\n" +
                "Position Type: _______Quality control_______\n" +
                "Core Competency: _______Data not available_______\n";
        assertEquals(expected, job3.toString());
    }



}
