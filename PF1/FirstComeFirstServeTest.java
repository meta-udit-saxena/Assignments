
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FirstComeFirstServeTest {
	
	@Test
	public void firstComeFirstServeTestTestCase1(){
		
		FirstComeFirstServe object=new FirstComeFirstServe();
		int[] arrival_time={1,5,9,25};
		int[] job_size={12,7,2,5};
		
		int[][] expected={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		int [][] output=object.getWaitingTime(arrival_time, job_size);
		FirstComeFirstServeTest.isArrayEqual1(expected,output);
		
		
		
	}
	
	public static void isArrayEqual1(int expected[][], int output[][]){
		
		assertArrayEquals(expected, output);
		
	}
	//Boundary case value not given
	@Test
	public void firstComeFirstServeTestTestCase2(){
		
		FirstComeFirstServe object=new FirstComeFirstServe();
		int[] arrival_time={};
		int[] job_size={12,7,2,5};
		
		int[][] expected={};
		int [][] output=object.getWaitingTime(arrival_time, job_size);
		FirstComeFirstServeTest.isArrayEqual2(expected,output);
		
		
		
	}
	
	public static void isArrayEqual2(int expected[][], int output[][]){
		
		assertArrayEquals(expected, output);
		
	}
}
