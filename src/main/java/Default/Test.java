package Default;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	
	/*
	 * L1 = 5 1 2 5 3 4 4 2 3 7 2 0 1 1
	 * Expected Out put : 5 1 2 3 4 7 0
	 */
	
	
	public  List<Integer> getUnique(List<Integer> aList) {
		List<Integer> tempList = new ArrayList<Integer>();
		for(int i :aList) {
			if(!tempList.contains(i)) {
				tempList.add(i);
			}
		}
		return tempList;
		
	}
	
	public  void pyramidPattern(int n) 
    {  
		int startIndex = 0;
        for (int i=0; i<n; i++) //outer loop for number of rows(n) { for (int j=n-i; j>1; j--) //inner loop for spaces
            { 
                System.out.print(" "); //print space
            }  
			/*
			 * for (int j=0; j<= i; j++ ) //inner loop for number of columns {
			 * System.out.print("* "); //print star }
			 */
  
            System.out.println(); //ending line after each row
        } 
    
	
	
	public void getStructure(int numberOfRows) {
		int startindex = 0;
		//int currentIndex = 0;
		
		for(int i =1;i<=numberOfRows ; i++) {
			startindex = numberOfRows -i;
			for(int j = 1 ; j<=numberOfRows*2-1  ; j++ ) {
				
				if(j==startindex +1) {
					for(int k = 1 ;k<= i; k++) {
						
							System.out.print("1 ");
						
						}
					
				}
				else if(j==numberOfRows*2-1) {
					System.out.println(" ");	
				}
				else {
					System.out.print(" ");	
				}
				
				
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Test t = new Test();
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(5);
		aList.add(1);
		aList.add(2);
		aList.add(5);
		aList.add(3);
		aList.add(4);
		aList.add(4);
		aList.add(2);
		aList.add(3);
		aList.add(7);
		aList.add(2);
		aList.add(0);
		aList.add(1);
		aList.add(1);
		
	t.getStructure(15);
		
		
	}

	
	
	
	
}
