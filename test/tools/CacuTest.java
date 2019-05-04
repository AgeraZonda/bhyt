/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngv.dongg
 */
public class CacuTest {
    
    public CacuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of caculate method, of class Cacu.
     */
    @org.junit.Test
    public void testCaculate() {
        System.out.println("caculate ho tro 0%");
        float salary = 1000000.0F;
        int percent = 0;
        Cacu instance = new Cacu();
        float expResult = 45000.0F;
        float result = instance.caculate(salary, percent);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @org.junit.Test
    public void testCaculate1() {
        System.out.println("caculate ho tro 30%");
        float salary = 1000000.0F;
        int percent = 30;
        Cacu instance = new Cacu();
        float expResult = 31500.0F;
        float result = instance.caculate(salary, percent);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @org.junit.Test
    public void testCaculate2() {
        System.out.println("caculate ho tro 70%");
        float salary = 1000000.0F;
        int percent = 70;
        Cacu instance = new Cacu();
        float expResult = 13500.0F;
        float result = instance.caculate(salary, percent);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @org.junit.Test
    public void testCaculate3() {
        System.out.println("caculate ho tro 100%");
        float salary = 1000000.0F;
        int percent = 100;
        Cacu instance = new Cacu();
        float expResult = 0.0F;
        float result = instance.caculate(salary, percent);
        assertEquals(expResult, result, 0.0); 
    }

    /**
     * Test of caculateForFamily method, of class Cacu.
     */
    @org.junit.Test
    public void testCaculateForFamily() {
        System.out.println("caculateForFamily");
        float salary = 1000000.0F;
        int numberOfMember = 1;
        Cacu instance = new Cacu();
        float[] expResult = {45000.0F};
        
        float[] result = instance.caculateForFamily(salary, numberOfMember);
//        assertArrayEquals(expResult, result);
       
        
    }
    
}
