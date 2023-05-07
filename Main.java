import java.util.*;

public class Main {

    public static void book_ticket(passenger p)
    {
        if(ticketbooker.avail_Waiting_list==0)
        {
            System.out.println("no tickets available");
        }

        ticketbooker tb =new ticketbooker();

        if((p.berth_preference.equals("l")&&ticketbooker.avail_Lower_berth>0)||
           (p.berth_preference.equals("u")&&ticketbooker.avail_Upper_berth>0)||
           (p.berth_preference.equals("m")&&ticketbooker.avail_Middle_berth>0))
        {
            System.out.println("prefered berth available");

            if(p.berth_preference.equals("l"))
            {
                System.out.println("lower birth given\n");
                ticketbooker.avail_Lower_berth--;
                
                int position=ticketbooker.lower_berth_position.get(0);
                tb.bookticket(p,p.berth_preference,position);
                ticketbooker.lower_berth_position.remove(0);
            }
            else if(p.berth_preference.equals("u"))
            {
                System.out.println("upper birth given\n");
                ticketbooker.avail_Upper_berth--;

                int position=ticketbooker.upper_berth_position.get(0);
                tb.bookticket(p,p.berth_preference,position);
                ticketbooker.upper_berth_position.remove(0);
            }
            else if(p.berth_preference.equals("m"))
            {
                System.out.println("middle birth given\n");
                ticketbooker.avail_Middle_berth--;

                int position=ticketbooker.middle_berth_position.get(0);
                tb.bookticket(p,p.berth_preference,position);
                ticketbooker.middle_berth_position.remove(0);
            }                        
        }
        else if(ticketbooker.avail_Lower_berth>0)
            {
            System.out.println("preffered tickets not available\n ");
            System.out.println("lower birth given\n");

            ticketbooker.avail_Lower_berth--;
            int position=ticketbooker.lower_berth_position.get(0);
            tb.bookticket(p,"l",position);
            ticketbooker.lower_berth_position.remove(0);
        }
        else if(ticketbooker.avail_Upper_berth>0)
        {
            System.out.println("preffered tickets not available\n");
            System.out.println("upper berth given\n");

            ticketbooker.avail_Upper_berth--;
            int position=ticketbooker.upper_berth_position.get(0);
            tb.bookticket(p,"u",position);
            ticketbooker.upper_berth_position.remove(0);
        }
        else if(ticketbooker.avail_Middle_berth>0)
        {
            System.out.println("preffered tickets not available\n");
            System.out.println("middle berth given\n");

            ticketbooker.avail_Middle_berth--;
            int position=ticketbooker.middle_berth_position.get(0);
            tb.bookticket(p,"m",position);
            ticketbooker.middle_berth_position.remove(0);
        }
        else if(ticketbooker.avail_Rac_berth>0)
        {
            System.out.println("preffered tickets not  available\n");
            System.out.println("Rac ticket given\n");

            ticketbooker.avail_Rac_berth--;
            int position=ticketbooker.rac_position.get(0);
            tb.racticket(p,"rac",position);
            ticketbooker.rac_position.remove(0);
        }
        else if(ticketbooker.avail_Waiting_list>0)
        {
            System.out.println("prefered ticket not available\n");
            System.out.println("added to waiting list\n");

            ticketbooker.avail_Waiting_list--;
            int position=ticketbooker.waiting_list_Position.get(0);
            tb.waitingticket(p,"w",position);
            ticketbooker.waiting_list_Position.remove(0);
        }
    }
    public static void cancel_Ticket(int id1)
        {
            if(!ticketbooker.passengers.containsKey(id1))
            {
                System.out.println("id not found");
            }
                else{
                    ticketbooker booker1=new ticketbooker();
                    booker1.cancelTicket(id1);
                }
        }
    

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.print("\t\t1.Book Ticket\n");
            System.out.print("\t\t2.Cancel Ticket\n");
            System.out.print("\t\t3.Print available tickets\n");
            System.out.print("\t\t4.Print passenger details\n");
            System.out.print("\t\t5.Exit\n");
            int choice = in.nextInt();
            switch (choice) {

                case 1: 
                {
                    System.out.println("Enter passenger name, age , gender and berth preference (L, M, U)");
                    String name=in.next();
                    int age=in.nextInt();
                    String gender =in.next();
                    String berth_preference=in.next();
                    passenger p =new passenger(name,age,gender,berth_preference);
                    book_ticket(p);
                    break;
                }

                case 2:
                {
                    System.out.println("enter passenger id to cancel");
                    int id=in.nextInt();
                    cancel_Ticket(id);
                    break;
                }

                case 3:
                {                   
                    System.out.println("\t-----------AVAIL LOWER BERTH  \t-- "+ticketbooker.avail_Lower_berth);
                    System.out.println("\t-----------AVAIL UPPER BERTH  \t-- "+ticketbooker.avail_Upper_berth);
                    System.out.println("\t-----------AVAIL MIDDELE BERTH\t-- "+ticketbooker.avail_Middle_berth);
                    System.out.println("\t-----------AVAIL RAC BERTH    \t-- "+ticketbooker.avail_Rac_berth);
                    System.out.println("\t-----------AVAIL WAITING LIST \t-- "+ticketbooker.avail_Waiting_list);
                    break;
                }

                case 4:
                {
                    ticketbooker.printPassengerDetails();
                    break;
                }

                case 5: 
                {
                    loop = false;
                    break;
                }
                default: 
                {
                    System.out.println("Invalid choice!");
                    break;
                }
            }
        }
        in.close();
    }
}


class ticketbooker
{
    static int avail_Lower_berth=1;
    static int avail_Upper_berth=1;
    static int avail_Middle_berth=1;
    static int avail_Rac_berth=1;
    static int avail_Waiting_list=1;

    static Queue<Integer> Waiting_list=new LinkedList<>();
    static Queue<Integer> Rac_berth=   new LinkedList<>();
    static List <Integer> ticketlist=  new ArrayList <>();

    static List<Integer> lower_berth_position  = new ArrayList<>(Arrays.asList(1));
    static List<Integer> middle_berth_position = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upper_berth_position  = new ArrayList<>(Arrays.asList(1));
    static List<Integer> rac_position          = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waiting_list_Position = new ArrayList<>(Arrays.asList(1));

    static Map<Integer,passenger>passengers =new HashMap<>();

    public void bookticket(passenger p,String berth_preference,int position)
    {
        p.alloted=berth_preference;
        p.number=position;
        passengers.put(p.passenger_id,p);
        ticketlist.add(p.passenger_id);
        System.out.println("successfully booked the ticket "+p.number+p.alloted);
    }
    public void racticket(passenger p,String rac,int position)
    {
        p.alloted=rac;
        p.number=position;
        passengers.put(p.passenger_id,p);
        Rac_berth.add(p.passenger_id);
        System.out.println("you got "+p.number+p.alloted);
    }
    public void waitingticket(passenger p,String waitinginfo,int position)
    {
        p.alloted=waitinginfo;
        p.number=position;
        passengers.put(p.passenger_id,p);
        Waiting_list.add(p.passenger_id);
        System.out.println("you got "+p.number+p.alloted);
    }
    public static void printPassengerDetails()
    {
        for(passenger p:passengers.values())
        {
            System.out.println("\n\t-----------passenger--details------------------------------------\n");
            System.out.println("\t-----------passenger id    \t"+p.passenger_id+"\t-----------");
            System.out.println("\t-----------passenger name  \t"+p.name+"\t-----------");
            System.out.println("\t-----------passenger gender\t"+p.gender+"\t-----------");
            System.out.println("\t-----------passenger age   \t"+p.age+"\t-----------");
            System.out.println("\t-----------alloted berth   \t"+p.number+p.alloted+"\t-----------");
        }
    }

    public void cancelTicket(int id)
    {
        passenger p =passengers.get(id);
        passengers.remove(Integer.valueOf(id));
        ticketlist.remove(Integer.valueOf(id));

        if(p.alloted.equals("l"))
        {
            avail_Lower_berth++;
            lower_berth_position.add(p.number);
        }
        else if(p.alloted.equals("u"))
        {
            avail_Upper_berth++;
            upper_berth_position.add(p.number);
        }
        else if(p.alloted.equals("m"))
        {
            avail_Middle_berth++;
            middle_berth_position.add(p.number);
        }

        System.out.println("TICKET CANCELLED SUCCESSFULLY!");

        if(Rac_berth.size()>0)
        {
            passenger p1=passengers.get(Rac_berth.poll());
            rac_position.add(p1.number);
            Rac_berth.remove(Integer.valueOf(p1.passenger_id));
            avail_Rac_berth++;

            if(Waiting_list.size()>0)
            {
                passenger p2=passengers.get(Waiting_list.poll());
                waiting_list_Position.add(p2.number);
                Waiting_list.remove(Integer.valueOf(p2.passenger_id));

                p2.number=rac_position.get(0);
                p2.alloted="rac";
                rac_position.remove(0);
                Rac_berth.add(p2.passenger_id);

                avail_Waiting_list++;
                avail_Rac_berth--;
            }
            Main.book_ticket(p1);
        }
    }
}


class passenger
{
    static int id=1;
    String name;
    String gender;
    int age;
    int passenger_id;
    String berth_preference;
    String alloted;
    int number;
    passenger(String name,int age,String gender,String berth_preference)
    { 
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.berth_preference=berth_preference;
        this.passenger_id=id++;
        alloted="";
        number=-1;
    }
}