package src;

import src.TestTileT;
import src.TestGridT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * @Author: Rashad Ahmed Bhuiyan - bhuiyr2
 * @Date: 2021-04-12
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestTileT.class,
   TestGridT.class
})

public class AllTests
{
}
