package lab8;
import java.nio.*;
import java.util.Arrays;
/*Aarya chaudhary
Roll No : 1*/
public class IntBufferExample {
	public static void main(String[] args) {
		 // Allocate an IntBuffer of size 10
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i);
        }
        int[] data = buffer.array();
        IntBuffer buffer1 = IntBuffer.wrap(data);
        boolean areEqual = Arrays.equals(buffer.array(), buffer1.array());
        System.out.println("Are the initial and final IntBuffers equal? " + areEqual);
	}
}
