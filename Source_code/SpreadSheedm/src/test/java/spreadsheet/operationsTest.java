/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author mgrau
 */
@RunWith(MockitoJUnitRunner.class)
public class operationsTest {
    
    public operationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting Test for operations");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Ending Test for operations");
    }
    
    @Before
    public void setUp() {
        initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testSUM(){
        System.out.println("Test SUM");
 
        //Make sum of two cells
        //Assert.assertEquals(2,);
        //Call getContent
        
        //Check if correct operation
        
    }
    
    @Test
    public void testPRODUCT(){
        System.out.println("Test PRODUCT");
 
        //Make product of two cells
        //Assert.assertEquals(2,);
        //Call getContent
        
        //Check if correct operation
        
    }
    
}