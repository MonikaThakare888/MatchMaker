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
		System.out.println(" Enter your Full Name : ");
		String fullName = sc.nextLine();
		int age;
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
		System.out.println(" Enter your Gender : ");
		String gender = sc.next();
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
		String hobbies = "";
		while (!hobbies.equals("Exit")){
			System.out.println("Please Enter Hobbies or Enter Exit : ");
			Scanner scan = new Scanner(System.in);
			hobbies = scan.nextLine();
			if(hobbies.contains(" ")) { System.out.println("Please Enter correct Hobbies"); }
			else { hobbiesList.add(hobbies);}
		}
		System.out.println(" Enter your Partners preferred Gender : ");
		String preferredGender = sc.next();
		System.out.println("Please Enter your partners preferred professions from following profession list [ Engineer, Doctor, Lawyer, CA, Teacher, Farmer, BusinessPerson, Marketing ]");
		String preferredProfessions = " ";
		ArrayList<String> preferredProfessionsList = new ArrayList<>();
		while (!preferredProfessions.equals("Exit")){
            System.out.println(" Enter your  Partners preferred professions or Enter Exit : ");
			preferredProfessions = sc.next();
			preferredProfessionsList.add(preferredProfessions);
			while (!professionsList.contains(preferredProfessions)&& !preferredProfessions.equals("Exit")){
				System.out.println("Please Enter correct Profession");
				preferredProfessions = sc.next();}
		}
		System.out.println(" Enter your Partners preferred age-range : ");
		int  preferredAgeRangeFrom = sc.nextInt();
		System.out.print(" to ");
		int preferredAgeRangeTo = sc.nextInt();

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