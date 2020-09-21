import java.util.Scanner;
public class TrainTicket{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the starting station: ");
        int startingStation = sc.nextInt();
        System.out.println("Please input the ending station: ");
        int endingStation = sc.nextInt();
        int numberOfStops = (endingStation - startingStation);
        if (numberOfStops < 0.0) {
            numberOfStops= numberOfStops * -1;
        }
        System.out.println("Please input the hour of passage: ");
        int hourOfPassage = sc.nextInt();
        double transferCost;
        if (peakHours(hourOfPassage)) {
        transferCost = numberOfStops * 1.50;
        } else {
        transferCost = numberOfStops * 1.10;
        }
        double costOfFare;
        costOfFare = (riverPeakCost(startingStation,endingStation,hourOfPassage) + transferCost);
        String typeOfPassage = "";
        if (peakHours(hourOfPassage)) { 
            typeOfPassage = ("PEAK HOURS");
        } else if (!peakHours(hourOfPassage)){
            typeOfPassage = ("NORMAL HOURS");
        }    
        
    
   
    
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nTrain Line: 12011.18315.6515");
        System.out.println("Passage during " + typeOfPassage);
        System.out.println("Starting Station: " + stations(startingStation));
        System.out.println("Ending Station: " + stations(endingStation));
        System.out.printf("Fare for passage: $%.2f" , costOfFare);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -");
     
}
    public static String stations(int stationNum){
        String stationString;
        switch (stationNum) {
            case 1: stationString = "West Gardens";
                break;
            case 2: stationString = "Foggy Landing";
                break;
            case 3: stationString = "Kensington Palace";
                break;
            case 4: stationString = "Twin Pines";
                break;
            case 5: stationString = "Elm Hall";
                break;
            case 6: stationString = "Madison Point";
                break;
            case 7: stationString = "Art Museum";
                break; 
            default: stationString = "Invalid Station Entered: " + stationNum;
                break;
    }       return stationString;

    
}       
    public static boolean riverCross(int startingStation, int endingStation) {
        boolean riverCross;
        if (endingStation > 2 && startingStation < 3){
            return true;
            } else {
            return false;
    }
    }
    public static double riverPeakCost(int startingStation, int endingStation, int hourOfPassage) {
        double riverPeakCost = 0;
    if(peakHours(hourOfPassage) && riverCross(startingStation,endingStation)) {
        riverPeakCost = 1.30;
    } else if (!peakHours(hourOfPassage) && riverCross(startingStation,endingStation)) {
        riverPeakCost = 1.00;
    } else if (peakHours(hourOfPassage) && !riverCross(startingStation,endingStation)) {
        riverPeakCost = 0.00;
    } return riverPeakCost;
    }
    

    public static boolean peakHours(int hourOfPassage) {
        return (hourOfPassage>=8 && hourOfPassage<11) || (hourOfPassage >= 16 && hourOfPassage<19);
    } 
}
   



                         



