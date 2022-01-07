package src;

import src.TileT;
import src.Direction;
/**
 * Author: Rashad Ahmed Bhuiyan
 * Revised: 2021-04-12
 * 
 * Description: Testing class for TileT module.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class TestTileT
{
    private TileT basic;
    private TileT basic2;
    
    @Before
    public void setUp()
    {
        basic = new TileT();
        basic2 = new TileT(2);
    }
    
    @Test
    public void testGetValue1()
    {
        assertEquals(basic.getValue(), 0);
    }
    
    @Test
    public void testGetValue2()
    {
        assertEquals(basic2.getValue(), 2);
    }
    
    @Test
    public void testGetColour1()
    {
        assertEquals(basic.getValue(), 0);
    }
    
    @Test
    public void testGetColour2()
    {
        assertEquals(basic2.getValue(), 2);
    }
    
    @Test
    public void testSetValue1()
    {
        basic.setValue(4);
        assertEquals(basic.getValue(), 4);
        basic.setValue(0);
        assertEquals(basic.getValue(), 0);
    }
    
    @Test
    public void testSetValue2()
    {
        basic2.setValue(16);
        assertEquals(basic2.getValue(), 16);
        basic2.setValue(2);
        assertEquals(basic2.getValue(), 2);
    }
    
    @Test
    public void testSetColour1()
    {
        basic.setValue(4);
        assertEquals(basic.getValue(), 4);
        basic.setValue(0);
        assertEquals(basic.getValue(), 0);
    }
    
    @Test
    public void testSetColour2()
    {
        basic2.setValue(16);
        assertEquals(basic2.getValue(), 16);
        basic2.setValue(2);
        assertEquals(basic2.getValue(), 2);
    }
    
    @Test
    public void testToString()
    {
        assertTrue(basic.toString().equals("0"));
    }
        
    @After
    public void tearDown()
    {
        basic = null;
        basic2 = null;
    }
}
