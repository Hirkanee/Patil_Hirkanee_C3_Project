import java.util.*;
class LocalTime{
    String hours, minutes;
    String timezone;
    public LocalTime(String hours, String minutes, String timezone){
        this.hours = hours;
        this.minutes = minutes;
        this.timezone = timezone;
    }

    @Override
    public String toString(){
        return hours + ":" + minutes + " " + timezone;
    }
}

class Restarant{
    private String name, location;
    private LocalTime openingTime, closingTime;
    public Restarant(String name, String location, LocalTime openingTime, LocalTime closingTime){
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    String getName(){ return name;}

    @Override
    public String toString(){
        return "Name: " + this.name + " Location: " + this.location +
                " Opening Time: " + openingTime.toString() + " Closing Time: " + closingTime.toString();
    }
}

class RestarantService{
    private static List<Restarant> restarants = new ArrayList<>();
    public Restarant findRestarantByName(String name){
        for(Restarant restarant : restarants){
            if(restarant.getName().equals(name)) return restarant;
        }

        return null;
    }
    public Restarant addRestarant(String name, String location, LocalTime openingTime, LocalTime closingTime){
        Restarant restarant = new Restarant(name, location, openingTime, closingTime);
        restarants.add(restarant);
        return restarant;
    }

    public List<Restarant> getRestarants(){ return restarants;}
}

public class Main{
    public static void main(String[] args) {
        RestarantService restarantService = new RestarantService();
        restarantService.addRestarant("ABC", "Kolkata", new LocalTime("10","30", "IST"), new LocalTime("20", "00", "IST"));
        restarantService.addRestarant("ASDF", "Mumbai", new LocalTime("09","30", "IST"), new LocalTime("19", "30", "IST"));
        restarantService.addRestarant("QWERTY", "Kolkata", new LocalTime("9","00", "IST"), new LocalTime("17", "45", "IST"));
        System.out.println(restarantService.getRestarants());

        System.out.println(restarantService.findRestarantByName("QWERTY"));
        System.out.println(restarantService.findRestarantByName("QWERT"));
    }
}