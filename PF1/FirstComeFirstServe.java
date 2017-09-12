/**
 * Simulate FCFS (First come First Server) scheduler of a machine
 * @author Udit Saxena
 * version 1.0
 */
public class FirstComeFirstServe {
/**
 * 
 * @param arrivalTime
 * @param jobSize
 * @return 2d array
 */
	public int[][] getWaitingTime(int[] arrivalTime,int[] jobSize){
		if(arrivalTime.length==0||jobSize.length==0)
		{
			int[][] a = {};
			return a;
		}
		int [][] output=new int[arrivalTime.length][5]; //array store final 2D array
		output[0][3]=arrivalTime[0]; // store first job arrival time to job start at
		
		// sequence of job
		for(int i=0;i<arrivalTime.length;i++)
			{
			 output[i][0]=i+1;
			}
		
		//job arrived time
		for(int i=0;i<arrivalTime.length;i++){
			output[i][1]=arrivalTime[i];
			}
		
		//job start time
		for(int i=1;i<arrivalTime.length;i++){
			output[i][3]=Math.max(output[i-1][3]+jobSize[i-1],arrivalTime[i]);
			
		}
		
		//job wait time
		for(int i=0;i<arrivalTime.length;i++){
			
			output[i][2]=output[i][3]-output[i][1];
		}
		
		//job finished at
		for(int i=0;i<arrivalTime.length;i++)
			output[i][4]=output[i][3]+jobSize[i]-1;
		
	
		return output; //return 2D array
		
	}
	
}
