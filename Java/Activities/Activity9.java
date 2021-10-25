package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        ArrayList<String> arrList = new ArrayList<String>();
        //Adding objects to Array List 
        arrList.add("Apple");
        arrList.add("Mango");
        arrList.add("Orange");
        //Adding object at specific index
        arrList.add(1, "Papaya");
        arrList.add(3, "Grapes");
        
        System.out.println("Print All the Objects:");
        
        for(String fruit:arrList){
            System.out.println(fruit);
        }
        
        System.out.println("3rd element in the list is: " + arrList.get(2));
        System.out.println("Is Chicku is in list: " + arrList.contains("Chicku"));
        System.out.println("Size of ArrayList: " + arrList.size());
        
        arrList.remove("Papaya");
        
        System.out.println("New Size of ArrayList: " + arrList.size());
	}

}
