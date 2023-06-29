import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= finalLimit; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not reached! It is "+i);
                assertTrue(lab.thresholdExceeds(i));
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(i));
            }
        }
    }
    @Test
    public void thresholdReachedTest(){
        //given
        LogginLab lab = new LogginLab();
        Integer limit = 6;
        lab.setThreshold(limit);
        Integer overLimit = 9;
        //when
        Integer threshold = lab.getThreshold();
        //then
        Assert.assertTrue(lab.thresholdReached(overLimit));
    }

    @Test
    public void thresholdReachedTest2(){
        //given
        LogginLab lab = new LogginLab();
        Integer limit = 6;
        lab.setThreshold(limit);
        Integer overLimit = 3;
        //when
        Integer threshold = lab.getThreshold();
        //then
        Assert.assertFalse(lab.thresholdReached(overLimit));
    }

}