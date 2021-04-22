package com.matchmaker.api;

import java.util.*;
import java.util.HashMap;

public class Database {

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<User> initialValidUserList = new ArrayList<>();
    static Map<String, ArrayList<String>> districtMap = new HashMap<>();

    public static void updateDatabase(User user) {
        initializeDatabase();
        userList.add(user);
    }

    public static
    void initializeDatabase() {
        User babitaShinde = new User("Babita Shinde", 28,"F","Doctor","Nagpur", new ArrayList<>(List.of("Playing", "Singing", "Dancing","Trekking")), "M", new ArrayList<>(List.of("Engineer", "Doctor", "Lawyer", "CA", "Teacher", "Farmer", "BusinessPerson", "Marketing")),26,35);
        User ishaJadhav = new User("Isha Jadhav", 26,"F","Engineer","Yavatmal", new ArrayList<>(List.of("Playing", "Singing","Travelling")), "M", new ArrayList<>(List.of("Engineer", "Doctor", "Lawyer", "CA", "Teacher")),26,35);
        User UnnatiPande = new User("Unnati Pande",30,"F","CA","Wardha", new ArrayList<>(List.of("Playing")), "M", new ArrayList<>(List.of("CA", "Teacher", "Farmer", "BusinessPerson", "Marketing")),30,35);
        User vaishnaviNagmote = new User("Vaishnavi Nagmote",32,"F","Lawyer","Nanded", new ArrayList<>(List.of("Playing","Trekking","swimming")), "M", new ArrayList<>(List.of("CA", "Teacher", "Farmer", "BusinessPerson", "Marketing")),30,40);
        User shraddhaKadu = new User("Shraddha Kadu",35,"F","Farmer","Washim", new ArrayList<>(List.of("Playing","Travelling","Trekking")), "M", new ArrayList<>(List.of("CA", "Teacher", "Farmer", "BusinessPerson", "Marketing")),30,40);

        User abhishekDeshmukh = new User("Abhishek Deshmukh", 27,"M","Farmer","Amravati", new ArrayList<>(List.of("Playing")), "F", new ArrayList<>(List.of("Doctor", "Engineer","CA", "Teacher", "Farmer", "BusinessPerson", "Marketing")), 26,35);
        User nileshYadav = new User("Nilesh Yadav", 25,"M","Engineer","Yavatmal", new ArrayList<>(List.of("Playing", "Singing", "Dancing","Travelling")), "F", new ArrayList<>(List.of("Doctor", "Engineer", "Lawyer", "CA", "Teacher", "Farmer")), 26,35);
        User ujwalPrasad = new User("Ujwal Prasad", 28,"M","Lawyer","Akola", new ArrayList<>(List.of("Playing", "Singing","Trekking")), "F", new ArrayList<>(List.of("Doctor", "Engineer","CA", "Teacher", "Farmer", "BusinessPerson", "Marketing")), 26,35);
        User vitthalKamat = new User("Vitthal Kamat", 33,"M","Marketing","Nanded", new ArrayList<>(List.of("Playing", "Singing","Travelling")), "F", new ArrayList<>(List.of("Doctor", "Engineer", "CA", "Teacher", "Farmer")), 26,35);
        User harshalButale = new User("Harshal Butale", 29,"M","BusinessPerson","Buldhana", new ArrayList<>(List.of("Playing", "Singing","Travelling")), "F", new ArrayList<>(List.of("Doctor", "Engineer", "BusinessPerson", "Marketing")), 26,35);

        userList.add(babitaShinde);
        userList.add(ishaJadhav);
        userList.add(UnnatiPande);
        userList.add(vaishnaviNagmote);
        userList.add(shraddhaKadu);

        userList.add(abhishekDeshmukh);
        userList.add(nileshYadav);
        userList.add(ujwalPrasad);
        userList.add(vitthalKamat);
        userList.add(harshalButale);

        districtMap.put("Amravati", new ArrayList<>(List.of("Amravati", "Yavatmal", "Akola", "Wardha", "Washim")));
        districtMap.put("Yavatmal", new ArrayList<>(List.of("Yavatmal", "Amravati", "Nanded", "Wardha", "Washim")));
        districtMap.put("Akola", new ArrayList<>(List.of("Akola", "Amravati", "Buldhana","Washim")));
        districtMap.put("Wardha", new ArrayList<>(List.of("Wardha", "Yavatmal", "Amravati", "Nagpur")));
        districtMap.put("Nagpur", new ArrayList<>(List.of( "Nagpur", "Wardha")));
        districtMap.put("Washim", new ArrayList<>(List.of("Washim", "Yavatmal", "Akola", "Amravati", "Nanded")));
        districtMap.put("Buldhana", new ArrayList<>(List.of("Buldhana", "Yavatmal", "Akola", "Wardha", "Washim")));
        districtMap.put("Nanded", new ArrayList<>(List.of("Nanded", "Yavatmal", "Akola", "Wardha", "Washim")));
    }
    public static ArrayList<MatchingPoints> findMatchingUser(User user) {
        for (Object element : userList) {
            User eligibleUser = (User) element;
            if (user.preferredGender.equals(eligibleUser.gender) && eligibleUser.age >= user.preferredAgeRangeFrom && eligibleUser.age <= user.preferredAgeRangeTo) {
                initialValidUserList.add(eligibleUser);
            }
        }
        return calculatePoints(initialValidUserList, user);
    }

    public static ArrayList<MatchingPoints> calculatePoints(ArrayList<User> initialValidUserList, User user){
        ArrayList<MatchingPoints> matchingPointsList = new ArrayList<>();
        Iterator itr = initialValidUserList.iterator();
        Iterator it = districtMap.entrySet().iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            User eligibleUser = (User) element;
            int hobbiesCount = 0; int professionsCount = 0; int districtCount = 0;
            for(int i = 0 ; i< user.getHobbies().size() - 1 ; i++){
                if(eligibleUser.getHobbies().contains(user.getHobbies().get(i))){
                    hobbiesCount++;
                }
            }
            if(eligibleUser.getPreferredProfessions().contains(user.profession) && user.getPreferredProfessions().contains(eligibleUser.profession)){
                professionsCount++;
            }
            String district = user.getDistrict();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                ArrayList<String> valueList = (ArrayList<String>) pair.getValue();
                if(pair.getKey().equals(district) && valueList.contains(eligibleUser.getDistrict())){
                    districtCount++;
                }
            }
            MatchingPoints matchingUser = new MatchingPoints(eligibleUser,hobbiesCount*4,professionsCount*6,districtCount*12,(hobbiesCount*4) + (professionsCount*6) + (districtCount*12));
            if(matchingUser.totalPoints>=15){
                matchingPointsList.add(matchingUser);}
        }
        return matchingPointsList;
    }

}