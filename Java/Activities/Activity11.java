package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
        hMap.put(1, "Red");
        hMap.put(2, "Green");
        hMap.put(3, "Blue");
        hMap.put(4, "White");
        hMap.put(5, "Black");

        System.out.println("The Original map: " + hMap);
        
        // Remove White colour
        hMap.remove(4);
        
        // Map after removing White colour
        System.out.println("After removing White: " + hMap);
        
        // Check if green exists
        if(hMap.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }
        
        System.out.println("Number of pairs in the Map is: " + hMap.size());
	}

}
