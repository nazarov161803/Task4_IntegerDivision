package com.foxminded.integerDivision.logicForDivision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisonMakerTest {

    DivisonMaker divisonMaker = new DivisonMaker();
 
    @Test
    public void shouldReturnIllegalArgumentExceptionDivisorEqualsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            divisonMaker.makeDivision(78945, 0);
        });
    }
    
    @Test
    public void shouldReturnIllegalArgumentExceptionDividendIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            divisonMaker.makeDivision(-5123, 3);
        });
    }
    
    @Test
    public void shouldReturnIllegalArgumentExceptionDivisorIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            divisonMaker.makeDivision(5123, -3);
        });
    }
    
    @Test
    public void shouldReturnIllegalArgumentExceptionDividendAndDivisorEqualNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            divisonMaker.makeDivision(-78945, -5);
        });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionDivisorMoreThanDividend() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            divisonMaker.makeDivision(78945, 789455);
        });
    }

    @Test
    public void shouldReturnOne() {
        String expected = "_1335|1335" + "\n"+ 
                          " 1335|-" + "\n" +
                          " ----|1" + "\n"+ 
                          "    0";

        String actual = divisonMaker.makeDivision(1335, 1335);
        assertEquals(expected, actual);

    }

    @Test
    public void simpleDivision() {
        String expected = "_78945|4" + "\n" + 
                          " 4    |-----" + "\n" + 
                          " -    |19736" + "\n" + 
                          "_38" + "\n" + 
                          " 36"+ "\n" + 
                          " --" + "\n" + 
                          " _29" + "\n" + 
                          "  28" + "\n" + 
                          "  --" + "\n" + 
                          "  _14" + "\n" + 
                          "   12" + "\n"+
                          "   --" + "\n" + 
                          "   _25" + "\n" + 
                          "    24" + "\n" + 
                          "    --" + "\n" + 
                          "     1";

        String actual = divisonMaker.makeDivision(78945, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void maxIntDivideOnMaxInt() {
        String expected ="_2147483647|2147483647" + "\n" +  
                         " 2147483647|-"+ "\n" + 
                         " ----------|1"+ "\n" +  
                         "          0";
        String actual = divisonMaker.makeDivision(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(expected, actual);
    }
    
    @Test
    public void maxIntDivideOnOne() {
        String expected ="_2147483647|1"+ "\n" + 
                         " 2         |----------"+ "\n" + 
                         " -         |2147483647"+ "\n" + 
                         "_01"+ "\n" + 
                         "  1"+ "\n" + 
                         " --"+ "\n" + 
                         " _04"+ "\n" + 
                         "   4"+ "\n" + 
                         "  --"+ "\n" + 
                         "  _07"+ "\n" + 
                         "    7"+ "\n" + 
                         "   --"+ "\n" + 
                         "   _04"+ "\n" + 
                         "     4"+ "\n" + 
                         "    --"+ "\n" + 
                         "    _08"+ "\n" + 
                         "      8"+ "\n" + 
                         "     --"+ "\n" + 
                         "     _03"+ "\n" + 
                         "       3"+ "\n" + 
                         "      --"+ "\n" + 
                         "      _06"+ "\n" + 
                         "        6"+ "\n" + 
                         "       --"+ "\n" + 
                         "       _04"+ "\n" + 
                         "         4"+ "\n" + 
                         "        --"+ "\n" + 
                         "        _07"+ "\n" + 
                         "          7"+ "\n" + 
                         "         --"+ "\n" + 
                         "          0";
        String actual = divisonMaker.makeDivision(Integer.MAX_VALUE, 1);
        assertEquals(expected, actual);
    }
}