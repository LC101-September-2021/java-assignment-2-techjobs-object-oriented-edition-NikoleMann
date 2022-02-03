package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string1 = "Product tester";
        String string2 = "ACME";
        String string3 = "Desert";
        String string4 = "Quality control";
        String string5 = "Persistence";

        assertTrue(job1.getName() == string1);
        assertTrue(job1.getEmployer().getValue() == string2);
        assertTrue(job1.getLocation().getValue() == string3);
        assertTrue(job1.getPositionType().getValue() == string4);
        assertTrue(job1.getCoreCompetency().getValue() == string5);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void toStringBeginsAndEndsWithBlankLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string1 = "\n" +
                "ID: " + job1.getId() + " \n"  +
                "Name: " + job1.getName() + " \n" +
                "Employer: " + job1.getEmployer().getValue() + " \n" +
                "Location: " + job1.getLocation().getValue() + " \n" +
                "Position Type: " + job1.getPositionType().getValue() + " \n" +
                "Core Competency: " + job1.getCoreCompetency().getValue() + " \n" +
                "\n";
        //does char 1 = last char -- can give false positive
        //is last char and first char a n/?
        //string.endsWith("\n") and string.startsWith("\n")
        assertTrue(string1.endsWith("\n"));
        assertTrue(string1.startsWith("\n"));
    }

    @Test
    public void toStringPrintsStoredData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string1 = "\n" +
                "ID: " + job.getId() + "\n"  +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer().getValue() + "\n" +
                "Location: " + job.getLocation().getValue() + "\n" +
                "Position Type: " + job.getPositionType().getValue() + "\n" +
                "Core Competency: " + job.getCoreCompetency().getValue() + "\n";
        assertEquals(string1, job.toString());
    }

    @Test
    public void toStringHandlesMissingName() {
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string1 = "\n" +
                "ID: " + job1.getId() + "\n"  +
                "Name: " + "Data not available." + "\n" +
                "Employer: " + job1.getEmployer().getValue() + "\n" +
                "Location: " + job1.getLocation().getValue() + "\n" +
                "Position Type: " + job1.getPositionType().getValue() + "\n" +
                "Core Competency: " + job1.getCoreCompetency().getValue() + "\n";
        assertEquals(string1, job1.toString());
    }

    @Test
    public void toStringHandlesMissingEmployer() {
        Job job = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string1 = "\n" +
                "ID: " + job.getId() + "\n"  +
                "Name: " + job.getName() + "\n" +
                "Employer: " + "Data not available." + "\n" +
                "Location: " + job.getLocation().getValue() + "\n" +
                "Position Type: " + job.getPositionType().getValue() + "\n" +
                "Core Competency: " + job.getCoreCompetency().getValue() + "\n";
        assertEquals(string1, job.toString());
    }

    @Test
    public void toStringHandlesMissingLocation() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string1 = "\n" +
                "ID: " + job.getId() + "\n"  +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer().getValue() + "\n" +
                "Location: " + "Data not available." + "\n" +
                "Position Type: " + job.getPositionType().getValue() + "\n" +
                "Core Competency: " + job.getCoreCompetency().getValue() + "\n";
        assertEquals(string1, job.toString());
    }

    @Test
    public void toStringHandlesMissingPositionType() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String string1 = "\n" +
                "ID: " + job.getId() + "\n"  +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer().getValue() + "\n" +
                "Location: " + job.getLocation().getValue() + "\n" +
                "Position Type: " + "Data not available." + "\n" +
                "Core Competency: " + job.getCoreCompetency().getValue() + "\n";
        assertEquals(string1, job.toString());
    }

    @Test
    public void toStringHandlesMissingCoreCompetencies() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        String string1 = "\n" +
                "ID: " + job.getId() + "\n"  +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer().getValue() + "\n" +
                "Location: " + job.getLocation().getValue() + "\n" +
                "Position Type: " + job.getPositionType().getValue() + "\n" +
                "Core Competency: " + "Data not available." + "\n";
        assertEquals(string1, job.toString());
    }
}
