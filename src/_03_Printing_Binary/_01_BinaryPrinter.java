package _03_Printing_Binary;

import java.util.Iterator;
import java.util.Scanner;

public class _01_BinaryPrinter {
      /*
     * Complete the methods below so they print the passed in parameter in binary.
     * Do not use the Integer.toBinaryString method!
     * Use the main method to test your methods.
     */
	
	
    public static void printByteBinary(byte b) {
    	for (int i = 0; i < 8; i++) {
int out =b;
        // Shift b seven bits to the right
out=out>>7-i;
        // Use the & operator to "mask" the bit in the one's place
        // This can be done by "anding" (&) it with the value of 1
out=out&0b0000_0001;
        // Print the result using System.out.print (NOT System.out.println
System.out.print(out);
        //Use this method to print the remaining 7 bits of b
    }
    }

    public static void printShortBinary(short s) {
        // Create 2 byte variables
        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte
byte first = (byte) (s>>8);
byte second = (byte) ((s<<8)>>8);
        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
printByteBinary(first);
printByteBinary(second);
    }

    public static void printIntBinary(int i) {
        // Create 2 short variables

        // Use bit shifting and masking (&) to save the first
        // 16 bits of i in one short, and the second 16 bits of
        // i in the other short
    	short first = (short) (i>>16);
    	short second = (short) ((i<<16)>>16);
        // Call printShortBinary twice using the two short variables
        // Make sure they are in the correct order
    	printShortBinary(first);
    	printShortBinary(second);
    }

    public void printLongBinary(long l) {
        // Use the same method as before to complete this method
    }

    public static void main(String[] args) {
    	Boolean printBin = false;
    	String select;
    	
        System.out.println("---Calculator---");
        Scanner scannington = new Scanner(System.in);
        while(true) {
        	String in = scannington.nextLine();
        	select =in.substring(0,1);
        	in = in.substring(1,in.length());
        	
        		if(in.contains("^")) {
        			in = select+in;
        	String[] parts = new String[]{
        			d2b(Integer.parseInt(in.split("\\^")[0])), 
        			d2b(Integer.parseInt(in.split("\\^")[1]))};
        	String out ="";
        	for (int i = 0; i < parts[1].length(); i++) {
				if(parts[0].charAt(i)!=parts[1].charAt(i) &&
						(parts[0].charAt(i)=='1' || parts[1].charAt(i)=='1')) {
					out+="1";
				}else {
					out+="0";
				}
			}
        	
        	printBin=true;
        	in=out;
        	select="";
        		}else if(in.contains("&")) {
        			in = select+in;
        	String[] parts = new String[]{
        			d2b(Integer.parseInt(in.split("\\&")[0])), 
        			d2b(Integer.parseInt(in.split("\\&")[1]))};
        	String out ="";
        	for (int i = 0; i < parts[1].length(); i++) {
				if(parts[0].charAt(i)=='1' && parts[1].charAt(i)=='1'){
					out+="1";
				}else {
					out+="0";
				}
			}
        	
        	printBin=true;
        	in=out;
        	select="";
        		}else if(in.contains("|")) {
        			in = select+in;
        	String[] parts = new String[]{
        			d2b(Integer.parseInt(in.split("\\|")[0])), 
        			d2b(Integer.parseInt(in.split("\\|")[1]))};
        	String out ="";
        	for (int i = 0; i < parts[1].length(); i++) {
				if(parts[0].charAt(i)=='1' || parts[1].charAt(i)=='1'){
					out+="1";
				}else {
					out+="0";
				}
			}
        	
        	printBin=true;
        	in=out;
        	select="";
        		}else if(in.contains(" ")) {
        			in = select+in;
                	String[] parts = new String[]{in.split(" ")[0], in.split(" ")[1]};
                	printByteBinary((byte)Integer.parseInt(parts[0]));
                	System.out.println("");
                	printByteBinary((byte)Integer.parseInt(parts[1]));
                	System.out.println("");
        		}else if(select.equals("b")) {
        			
        			printByteBinary((byte)Integer.parseInt(in));
        			System.out.println("");
        			
        		}else if(in.contains(">")) {
            	in = select+in;
            	String[] parts = new String[]{in.split(">")[0], in.split(">")[1]};
            	String rotate = d2b(Integer.parseInt(parts[0]));
            	for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
        			rotate="0"+rotate.substring(0, rotate.length()-1);
        		}int out = 0;
            	for (int i = rotate.length()-1; i > -1; i--) {
            		out+=Character.getNumericValue(rotate.charAt(i))*(Math.pow(2, rotate.length()-1-i));
            	}System.out.println(out);
            	
            }else if(in.contains("<")) {
            	in = select+in;
            	String[] parts = new String[]{in.split("<")[0], in.split("<")[1]};
            	String rotate = d2b(Integer.parseInt(parts[0]));
            	for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
        			rotate+="0";
        		}int out = 0;
            	for (int i = rotate.length()-1; i > -1; i--) {
            		out+=Character.getNumericValue(rotate.charAt(i))*(Math.pow(2, rotate.length()-1-i));
            	}System.out.println(out);
            }else if(select.equals("0") || select.equals("1")) {
            	printBin=true;
            }else {System.out.println("no operation selected");}
        		if(printBin) {

                	printBin=false;
            			in = select+in;
            		int out = 0;
                	for (int i = in.length()-1; i > -1; i--) {
                		out+=Character.getNumericValue(in.charAt(i))*(Math.pow(2, in.length()-1-i));
                	}
                    System.out.println(out);
                    
                
        		}
        }
    }
    
    public static String d2b(int decimalNum) {
        String binaryStr = "";
        do {
            // 1. Logical right shift by 1
            int quotient = decimalNum >>> 1;

            // 2. Check remainder and add '1' or '0'
            if( decimalNum % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }

            decimalNum = quotient;

            // 3. Repeat until number is 0
        } while( decimalNum != 0 );
        while(binaryStr.length()<8) {
        	binaryStr="0"+binaryStr;
        }
        return binaryStr;
    }
    
}
