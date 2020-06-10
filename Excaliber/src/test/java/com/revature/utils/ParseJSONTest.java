package com.revature.utils;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.revature.utils.ParseJSON.*;
import static org.junit.jupiter.api.Assertions.*;

import com.revature.utils.ParseJSON;

class ParseJSONTest {


    @Test
    public void testReadDataFromFileTrue(){
        // file is there should return true
        String fileName = "data.json";
        assertTrue(readDataFromFile(fileName));
    }


    @Test
    public void testReadDataFromFileFalse(){
        // should return false because file is not there
        String fileName = "noFile.json";

        assertThrows(NullPointerException.class,
                ()->{
                    assertFalse(readDataFromFile(fileName)); // throws NullPointerException
                });

    }

    @Test
    public void testSetBatchDataNull(){
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNull(setBatchData());
    }

    @Test
    public void testSetBatchDataAssertionError(){
        assertThrows(AssertionError.class,
                ()->{
                    assertNull(setBatchData()); // throws AssertionError because file is not set
                });
    }

}
