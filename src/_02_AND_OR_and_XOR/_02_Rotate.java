package _02_AND_OR_and_XOR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Goal: Implement left and right rotate methods.
 * 
 * Inherently Java doesn't have an instruction to perform left or right
 * rotates (though there are rotate functions in the Integer class).
 * 
 * A rotate is when a bit is shifted outside the width of the variable and is
 * placed on the other side. Here is an example of a right rotate on int 7
 * by 1:
 *      00000000 00000000 00000000 00000111   // original value of 7
 *      10000000 00000000 00000000 00000011   // rotate right by 1
 * 
 * Normally when the number 7 is right shifted by 1, the rightmost '1' is
 * discarded and the result looks like this:
 *      00000000 00000000 00000000 00000011   // 7 >> 1 (last '1' is discarded)
 * For a right rotate the number is not discarded and it's placed on the left,
 * the most significant bit (bit 31).
 * 
 * The same goes for a left rotate:
 *      11111111 11111111 11111111 11111000   // original value of -8
 *      11111111 11111111 11111111 11110001   // rotate left by 1
 */
public class _02_Rotate {
    
    int rotateLeft(int value, int rotateAmount) {
    	System.out.println("rotating " + Integer.toBinaryString(value) +" " + rotateAmount + " left");
    	String out=""+Integer.toBinaryString(value);
    	String carry="";
    	for (int i = 0; i < rotateAmount; i++) {
			out=out.substring(1, out.length())+out.substring(0, 1);
		}
        return cbs(out);
    }
    
    int rotateRight(int value, int rotateAmount) {
    	System.out.println("rotating " + Integer.toBinaryString(value) +" " + rotateAmount + " right");
    	String out=""+Integer.toBinaryString(value);
    	String carry="";
    	while(out.length()!=32) {
    		out="0"+out;
    	}
    	for (int i = 0; i < rotateAmount; i++) {
			out=out.substring(out.length()-1, out.length())+out.substring(0, out.length()-1);
		}
        return cbs(out);
    }
    
    
    @Test
    void testRotateLeft() {
        int i = -8;

        int result = rotateLeft(i, 1);
        System.out.println("Left rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-15));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-15, result);
      
        result = rotateLeft(i, 3);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(-57));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-57, result);
    }
    
    @Test
    void testRotateRight() {
        int i = 7;
        //0111
          System.out.println("\nright\n");
        int result = rotateRight(i, 1);
        System.out.println("\nRight rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-2147483645));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-2147483645, result);
        
        result = rotateRight(i, 16);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(458752));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(458752, result);
    }
    
    
    int cbs(String binStr) {
    	int outPut = 0;
    	System.out.println(binStr);
    	if(binStr.substring(0, 1).equals("1")) {
    		System.out.println("negative");
    		for (int i = 1; i < binStr.length(); i++) {
    			outPut+=Math.abs(Character.getNumericValue(binStr.charAt(i))-1)*(Math.pow(2, binStr.length()-1-i));
			}
    		outPut+=1;
    		outPut*=-1;
    	}else {
    		System.out.println("positive");
    		for (int i = binStr.length()-1; i > 0; i--) {
			outPut+=Character.getNumericValue(binStr.charAt(i))*(Math.pow(2, binStr.length()-1-i));
			System.out.println(outPut);
    	}
    	}
    	System.out.println(outPut);
        return outPut;
    }
    
    
}
