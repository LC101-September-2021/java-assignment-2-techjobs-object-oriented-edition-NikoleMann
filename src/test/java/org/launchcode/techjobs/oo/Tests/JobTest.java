package org.launchcode.techjobs.oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs.oo.*;

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

}
