import java.util.*;

public class Main1
{
    static HashMap<Integer,passenger> passengers=new HashMap<>();
    static HashMap<Integer,Integer> flight = new HashMap<>();
    static int ticketprice=5000;

    public  static void book_ticket(passenger p)
    {        
        passengers.put(p.id,p);
        if(!flight.containsKey(p.flight_id)){ 
            System.out.println("Flight id not found");
        }
        else
        {
            int current_no_of_seats=flight.get(p.flight_id);
            if(current_no_of_seats>=p.no_of_seats)
                {
                    System.out.println("ticket available");
                    int remaining_seats=current_no_of_seats-p.no_of_seats;
                    flight.put(p.flight_id,remaining_seats);
                    int price = pricing(p.no_of_seats);
                    System.out.println("ticket booked successfully");
                    System.out.println("Price :\t" +price+"\n");
                }
            else
                {
                    System.out.println("tickets_not_available\n");
                }
        }
    }

    public static void cancel_Ticket(int id)
    {
        if(!passengers.containsKey(id)){
            System.out.println("invalid passenger id");
        }   
        else
        {      
            passenger passenger_to_cancel=passengers.get(id);
            int current_no_of_seats=flight.get(passenger_to_cancel.flight_id);

            int seats=current_no_of_seats+passenger_to_cancel.no_of_seats;
            flight.put(passenger_to_cancel.flight_id,seats);
            passengers.remove(id);
            ticketprice-=200;
            System.out.println("ticket cancelled successfully");
        }
    }
    public static void print(){

        System.out.println("flight details\n");
            for(Map.Entry<Integer,Integer> e:flight.entrySet())
            {
                System.out.println("flight id\t\t"+e.getKey());
                System.out.println("no of passengers\t"+e.getValue());
                System.out.println();
            }

        System.out.println("passenger details\n");
            for(Map.Entry<Integer,passenger> e:passengers.entrySet())
            {
                int key=e.getKey();
                System.out.println("passenger_id\t"+key);
                passenger p=passengers.get(key);
                System.out.println("name\t\t"+p.name);
                System.out.println("flight_id\t"+p.flight_id);
                System.out.println("no_of_seats\t"+p.no_of_seats);
                System.out.println();
            }                  
    }
        
    public static int pricing(int seats){        
        int price=ticketprice*seats;
        ticketprice=ticketprice+200;
        return price;
    }

    public static void main(String[] args)
    {
        for(int i=1;i<=2;i++)
            {
                flight.put(i,50);
            }
        Scanner in = new Scanner(System.in);
        boolean loop=true;
        while(loop)
        {
        System.out.println("Press 1 to Booking");
        System.out.println("Press 2 to Cancel");        
        System.out.println("Press 3 to Print flight details");        
        System.out.println("Press 4 to Exit");
        int choice= in.nextInt();
            switch(choice)
            { 
                case 1:
                {
                    System.out.println("enter your name");
                    String name= in.next();
                    System.out.println("enter your flight choice");
                    int flight_id=in.nextInt();
                    System.out.println("enter total no of seats you need");
                    int no_of_seats=in.nextInt();
                    passenger p=new passenger(name,flight_id,no_of_seats);
                    book_ticket(p);
                    break;
                }
                case 2:
                {
                    System.out.println("enter the id to cancel ");
                    int id_to_cancel=in.nextInt();
                    cancel_Ticket(id_to_cancel);
                    break;
                }
                case 3:
                {                           
                    print();                                                                                       
                    break;          
                }
                case 4:
                {
                    loop=false;
                    break;
                }
            }
        }
    }
}
class passenger
{
    static int passenger_id=1;
    String name;
    int flight_id;
    int no_of_seats;
    int id;
    passenger(String name,int flight_id,int no_of_seats)
    {
        this.name=name;
        this.flight_id=flight_id;
        this.no_of_seats=no_of_seats;
        this.id=passenger_id++;
    }
}