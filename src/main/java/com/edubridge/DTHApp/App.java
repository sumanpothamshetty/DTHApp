package com.edubridge.DTHApp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.DTHApp.Model1.DTH;
import com.edubridge.DTHApp.DAO.*;
public class App 
{
    public static void main( String[] args )
    {
    	DTHDAO dao= new DTHDAOIMPL();
    	Scanner in =new Scanner(System.in);
    	while(true) {
    		System.out.println("MY DTH APP");
    		System.out.println("--------------");
    		System.out.println("1.ADD DTH");
    		System.out.println("2.VIEW ALL DTHs");
    		System.out.println("3.SEARCH DTHs");
    		System.out.println("4.UPDATE DTH");
    		System.out.println("5.DELETE DTH");
    		System.out.println("6.DELETE ALL DTHs");
    		System.out.println("0. EXIT");
    		System.out.println("PLEASE CHOOSE OPTION:");
    		
    		int option =in.nextInt();
    		switch (option) {
			case 1:
				System.out.println("Please enter DTH dth_name:");
				String dth_name=in.next();
				
				System.out.println("Please enter DTH dth_channel:");
				int dth_channels=in.nextInt();
				
				System.out.println("Please enter DTH dth_price:");
				float dth_price=in.nextFloat();
				
				DTH newDTH=new DTH();
				newDTH.setDth_name(dth_name);
				newDTH.setDth_channels(dth_channels);
				newDTH.setDth_price(dth_price);
				
				int status=dao.addDTH(newDTH);
				if(status>=1) {
					System.out.println("New DTH Saved!!!");
				}else {
					System.out.println("Something is wrong!!!");
				}
				break;
			case 2:
				List<DTH> DTH=dao.getAllDTH();
				if(DTH.size() !=0) {
					for(DTH d : DTH) {
						System.out.println(d.getDth_id()+"\t"+d.getDth_name()+"\t"+d.getDth_channels()
						+"\t"+d.getDth_price());
					}
				}else {
					System.out.println("no DTH found");
				}
				break;
			case 3:
			    System.out.println("Please enter DTH name to search:");
			    String searchName = in.next();
			    DTH searchedDTH= dao.getDTH(searchName);
			    if (searchedDTH != null) {
			        System.out.println(searchedDTH.getDth_id() + "\t" + searchedDTH.getDth_name() + "\t" + searchedDTH.getDth_channels() + "\t" + searchedDTH.getDth_price());
			    } else {
			        System.out.println("DTH not found");
			    }
			    break;
			case 4:
			    System.out.println("Please enter DTH name to update:");
			    String updateDTH_name = in.next();
			    DTH updateDTH = dao.getDTH(updateDTH_name);
			    if (updateDTH != null) {
			    	//System.out.println("please enter new DTH id");
			    	//int newDth_id = in.nextInt();
			        System.out.println("Please enter new DTH name:");
			        String newDth_name = in.next();
			        System.out.println("Please enter new DTH channels:");
			        int newDth_channels= in.nextInt();
			        System.out.println("Please enter new DTH price:");
			        float newDth_price = in.nextLong();
			        
			        updateDTH.setDth_name(newDth_name);
			        updateDTH.setDth_channels(newDth_channels);
			        updateDTH.setDth_price(newDth_price);
			        int status1 = dao.updateDTH(updateDTH);
			        if (status1 >= 1) {
			            System.out.println("DTH updated successfully");
			        } else {
			            System.out.println("Update failed");
			        }
			    } else {
			        System.out.println("DTH not found");
			    }
			    break;
			case 5:
			    System.out.println("Please enter DTH name to delete:");
			    String deleteDth_name = in.next();
			    int status2 = dao.deleteDTH(deleteDth_name);
			    if (status2 >= 1) {
			        System.out.println("DTH deleted successfully");
			    } else {
			        System.out.println("Delete failed");
			    }
			    break;
			case 6:
			    dao.deleteAllDTH();
			    System.out.println("All DTHs deleted");
			    break; 
			case 0:
				System.out.println("Byee!!!");
				System.exit(0);

			default:
				System.out.println("Invalide Option!!!!");
				break;
			}
    	}
    
    }
}
    

