package com.matchmaker.api;

import java.util.*;

public class ApiApplication {
	public static void main(String[] args) {
		List<String> distictList = new ArrayList<>(Arrays.asList("Amravati", "Yavatmal", "Akola", "Wardha", "Nagpur", "Washim", "Buldhana", "Nanded"));
		List<String> professionsList = new ArrayList<>(Arrays.asList("Engineer", "Doctor", "Lawyer", "CA", "Teacher", "Farmer", "BusinessPerson", "Marketing"));

		System.out.println("Welcome to MatchMaker!");
		System.out.println("------------------------------------------------");
		System.out.println("Plese Enter following details for registration : ");
		Scanner sc = new Scanner(System.in);
		String fullName = "";int age = 0;int preferredAgeRangeTo ;String gender ;
		String hobbies = "";String preferredProfessions = " ";String preferredGender ;int  preferredAgeRangeFrom ;
        while (true){
            System.out.println("Enter your Full Name :  ");
            fullName = sc.nextLine();
            boolean b = isNumeric(fullName);
            if(b){
                System.out.println("Please Enter correct Name");
            }
            else { break;
            }
        }
		while (true){
			System.out.println(" Enter your Age in years  : ");
			String ageInString = sc.next();
			boolean b = isNumeric(ageInString);
			if(b){
				age = Integer.parseInt(ageInString);
				break;
			}
			else { System.out.println("Please Enter correct age");
			}
		}
        while (true){
            System.out.println("Enter your Gender Male/Female: ");
            gender = sc.next();
            boolean b = isNumeric(gender);
            if(b){
                System.out.println("Please Enter correct Gender");
            }
            else {
                while (!(gender.equals("Male") || gender.equals("Female"))){
                    System.out.println("Please Enter correct Gender Male/Female: ");
                    gender = sc.next();
                }
                break;
            }
        }
		System.out.println(" Enter your Profession : ");
		String profession = sc.next();
		while (!professionsList.contains(profession)){
			System.out.println("Please Enter correct Profession");
		    profession = sc.next();
		}
		System.out.println("Please Enter your District from District list [ Amravati, Yavatmal, Akola, Wardha, Nagpur, Washim, Buldhana, Nanded ]" );
		String district = sc.next();
		while(!distictList.contains(district)){
			System.out.println("Please Enter correct Distict");
		    district = sc.next();
		}
		ArrayList<String> hobbiesList = new ArrayList<>();
		while (!hobbies.equals("Exit")){
			System.out.println("Please Enter Hobbies or Enter Exit : ");
			Scanner scan = new Scanner(System.in);
			hobbies = scan.nextLine();
			if(hobbies.contains(" ")) { System.out.println("Please Enter correct Hobbies"); }
			else { hobbiesList.add(hobbies);}
		}
        while (true){
            System.out.println("Enter your Partners preferred Gender Male/Female: ");
            preferredGender = sc.next();
            boolean i = isNumeric(preferredGender);
            if(i){
                System.out.println("Please Enter correct Gender Male/Female:");
            }
            else {
                while (!(preferredGender.equals("Male") || preferredGender.equals("Female"))){
                    System.out.println("Please Enter correct Gender Male/Female: ");
                    preferredGender = sc.next();
                }
                break;
            }
        }
		System.out.println("Please Enter your partners preferred professions from following profession list [ Engineer, Doctor, Lawyer, CA, Teacher, Farmer, BusinessPerson, Marketing ]");
		ArrayList<String> preferredProfessionsList = new ArrayList<>();
		while (!preferredProfessions.equals("Exit")){
            System.out.println(" Enter your  Partners preferred professions or Enter Exit : ");
			preferredProfessions = sc.next();
			preferredProfessionsList.add(preferredProfessions);
			while (!professionsList.contains(preferredProfessions)&& !preferredProfessions.equals("Exit")){
				System.out.println("Please Enter correct Profession");
				preferredProfessions = sc.next();}
		}
        while (true){
            System.out.println(" Enter your Partners preferred age-range : ");
            String noInString = sc.next();
            boolean b = isNumeric(noInString);
            if(b){
                preferredAgeRangeFrom = Integer.parseInt(noInString);
                break;
            }
            else { System.out.println("Please Enter correct number");
            }
        }
		System.out.print(" to ");
        while (true){
            String noInString = sc.next();
            boolean b = isNumeric(noInString);
            if(b){
                preferredAgeRangeTo = Integer.parseInt(noInString);
                break;
            }
            else { System.out.println("Please Enter correct number");
            }
        }
		User user = new User(fullName, age, gender, profession, district, hobbiesList, preferredGender, preferredProfessionsList, preferredAgeRangeFrom, preferredAgeRangeTo );
		Database.updateDatabase(user);
		ArrayList<MatchingPoints> matchingPointsList = Database.findMatchingUser(user);
		if(matchingPointsList.size()==0){
			System.out.println(" Sorry...There are no matching profiles");
			System.exit(0);
		}
		System.out.println("********** Matching profiles ************");
		for (Object element : matchingPointsList) {
			MatchingPoints matchingPoints = (MatchingPoints) element;
			System.out.println(" Name -   " + matchingPoints.user.fullName + ", Matching Points " + matchingPoints.getTotalPoints());
		}
	}
	public static boolean isNumeric(String age) {
		if (age == null) {
			return false;
		}
		try {
			Integer d = Integer.parseInt(age);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}