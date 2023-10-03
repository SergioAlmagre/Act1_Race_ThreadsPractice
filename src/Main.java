public class Main {
    public static void main(String[] args){

        boolean again = true;

        while(again){
            Race bestRace = new Race();
            bestRace.inscription();
            bestRace.showInfoRace();
            bestRace.startRace();
            bestRace.checkPodium();
            again = bestRace.again();
        }
    }
}

