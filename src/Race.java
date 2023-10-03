import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Race {
     private final Random random = new Random();
     static Scanner scanner = new Scanner(System.in);
     private final int meters = random.nextInt(0,1000);
     private boolean winner;
     static int index = 1;
     private static final ArrayList<Car> participants = new ArrayList<>();

    public void addCar(){
        String name;

        do{
        System.out.print("¿What is the name of your the car number " + index + "? \n");
        name = scanner.nextLine();
        }while(name == "");
        Car newCar = new Car(name);
        participants.add(newCar);
        index++;
    }

    public void showInfoRace(){
        System.out.printf("Participants: " + participants + "\n");
        System.out.printf("Long of race: " + meters + "meters" + "\n\n");
    }

    public void startRace() {
        Random random = new Random();
        try {
            while(!winner){
                for (Car i:participants){
                    i.metersTraveled += random.nextInt(1,50);
                    System.out.printf("Car " + i.carModel + " there are traveled " + i.metersTraveled + " meters " + "\n");
                    Thread.sleep(1000);
                    if(i.metersTraveled >= meters){
                        winner = true;
                    }
                }
            }
        }catch (InterruptedException in){
            System.out.println(in.getMessage());
        }
    }

    public void checkPodium(){
        ArrayList<Car> podium = new ArrayList<>();

        while (!participants.isEmpty()){
            Car aux = participants.get(0);
            for(Car i:participants){
                if (i.metersTraveled > aux.metersTraveled){
                    aux = i;
                }
            }
            podium.add(aux);
            participants.remove(aux);
        }
        System.out.print("\n______________PODIUM__________________\n");
        for (int i = 1; i<=3;i++){
            System.out.print(i + "º"+" Position "  + podium.get(i-1) + "\n");
        }
    }

    public static int numberOfCars(){
        boolean correct = false;
        int nCars = 0;
        while(!correct){
            try{
                System.out.print("How many cars participate in the race?\n");
                nCars = scanner.nextInt();
                scanner.nextLine();
                if(nCars>=3){
                    correct = true;
                }else{
                    System.out.println("The racer need almost 3 racers");
                }
            }catch (Exception e){
                System.out.println("Something was wrong, enter a correct value\n");
                scanner.nextLine();
            }
        }
        return nCars;
    }

    public void inscription(){
        int nCars = numberOfCars();
        while(participants.size() < nCars){
            addCar();
        }
    }

    public boolean again(){
        boolean again = false;
        boolean correct = false;

        while (!correct){
            try{
                System.out.println("\nWould do you like to do race again?");
                System.out.println("1 - YES");
                System.out.println("2 - NO");
                int i = scanner.nextInt();
                if (i == 1){
                    again = true;
                }
                correct = true;
            }catch (Exception e){
                System.out.println("Something was wrong, enter a correct value\n");
                scanner.nextLine();
            }
        }
        return again;
    }

}

