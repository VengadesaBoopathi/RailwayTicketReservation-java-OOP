// a

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <conio.h>
// #include <Windows.h>

// #include <stdlib.h>

// #include <conio.h>
using namespace std;
    class login
    {
       public:
       
       string username,password,name,gender;
       void regist()
       {
       ofstream file("loginDetails.txt",ios::app);
       cout<<"enter your username   "<<endl;
       cin>>username;
       cout<<"enter your pssword\n";
       cin>>password;
       cout<<"enter your name\n";
       cin>>name;
       cout<<"enter your gender\n";
       cin>>gender;
       file<<username<<" "<<password<<"\n";
       file.close();
       }
    int loginDetails()
       {
        string username1,password1;
        string username12,password12;

        cout<<"enter your username   "<<endl;
        cin>>username1;
        cout<<"enter your pssword\n";
        cin>>password1;
        ifstream file("loginDetails.txt");
        while(file>>username12>>password12)
        {
            if(username1==username12&&password1==password12)
            {
                return 1;
                break;
            }
        }
                return 0;
       }
    };
    
    string username="venki",password="1234";
class admin
{ 
    public:    
    int adminlogin()
       {
        string username1,password1;
        cout<<"enter your adminid   "<<endl;
        cin>>username1;
        cout<<"enter your password\n";
        cin>>password1;
        ifstream file("adminloginDetails.txt");
        if(username==username1&&password==password1)
            {
                return 1;
            }
            else{
                return 0;
            }
        }
       void addtrain()
       { 
            struct Traindetails{
                string train_name, origin_station, destination_station,train_number,  departure_time, arrival_time,  number_of_available_seats;
            };
            ofstream trainfile("trinfromMe.txt",ios::app);
            Traindetails o;
            cout<<"enter the train_name,\n";
            cin>>o.train_name;
            cout<<"enter the origin_station\n";
            cin>>o.origin_station;
            cout<<"enter the destination_station\n";
            cin>>o.destination_station;
            cout<<"enter the train_number \n";
            cin>>o.train_number;
            cout<<"enter the departure_time,\n";
            cin>>o.departure_time; 
            cout<<"enter the arrival_time, \n";
            cin>>o.arrival_time;
            cout<<"enter the number_of_available_seats\n";
            cin>>o.number_of_available_seats;
            trainfile<<o.origin_station<<" "<<o.destination_station<<" "<<o.train_number<<" "<<o.departure_time<<" "<<o.arrival_time<<" "<<o.train_name<<" ";
        }
};
class Train
{
    public:
    void Train1()
    { 
            // ofstream file2("train.txt",ios::out | ios::binary);
            struct date
            {
                int clss1,clss2,clss3;
                string  origin,destination;
            };
            
            string name,age;
            int clss,n;
            date obj;
            cout<<"FROM\n";                
            cin>>obj.origin;
            cout<<"TO\n";
            cin>>obj.destination;
            cout<<"enter how many passengers?\n";
            cin>>n;
            for(int i=0;i<n;i++)
            {
                string name;
                cout<<"enter passenger no: "<<i+1<< " name\n";
                cin>>name;
                cout<<"enter  age\n";
                cin>>age;
                cout<<"enter clss type\n";
                cin>>clss;
                if((clss==1)||(clss==2))
                {
                    (clss==1)?obj.clss1++:obj.clss2++;
                }
                else{
                    obj.clss3++;
                }
            }
            int i=1;
            string origin_station,destination_station,train_number,departure_time,arrival_time,train_name;
            ifstream file4("trinfromMe.txt");
                while(file4>>origin_station>>destination_station>>train_number>>departure_time>>arrival_time>>train_name)
                {
                    if(obj.origin==origin_station&&obj.destination==destination_station)
                    {
                        cout<<"AVAILABLE TRAIN  NO:"<<i<<"\n";
                        cout<<"TRAIN_NAME-----TRAIN_NUMBER-----ORIGIN_STATION-----DESTINATION_STATION-----DEPARTURE_TIME-----ARRIVAL_TIME\n";
                        cout<<train_name<<"-----"<<train_number<<"-----"<<origin_station<<"-----"<<destination_station<<"-----"<<departure_time<<"-----"<<arrival_time<<
                        i++;
                    }
                }
    }
    
};
int main()
{ 
    int choice,choice1=1,c,c1,v;
    getch();
    system("cls");
    cout<<"PRESS 1 FOR USER PORTAL\n     2 FOR ADMIN PORTAL ";
    cin>>choice;


        if(choice ==1)
            {
                while(1)
                {
                    system("cls");
                    cout<<"ENTER \n1FOR USER LOGIN \n0 FOR EXIT \n ";
                    cin>>choice1;
                    switch(choice1)                                                 
                            {
                                case 1:
                                {
                                  system("cls");
                                    login obj1;
                                    int x;
                                    x=obj1.loginDetails();
                                    if(x==1)
                                    {
                                        cout<<"login success\n";
                                        system("cls");
                                        cout<<"PRESS 1 TO  ENTER TRAIN DETILS ELSE IT WILL EXIT!";
                                        cin>>v;
                                        if(v==1)
                                        {
                                            Train obj;

                                            obj.Train1();
                                        }
                                        else{
                                            break;
                                        }
                                    }
                                    else{
                                        cout<<"LOGIN DETAILS NOT FOUND \n";
                                        cout<<"PRESS 1 TO  SIGN IN ELSE IT WILL EXIT !";
                                        cin>>v;
                                        if(v==1)
                                        {
                                            login obj;
                                            obj.regist();
                                            cout<<"login gin";
                                        }
                                        else{
                                            break;
                                        }
                                    }
                                }
                            case 0:
                                {
                                   exit(1);
                                }         
                        }
                }
            }

        else
            {
                while(1)
                { 
                    cout<<"1 FOR   FOR ADMIN LOGIN   \n0 FOR EXIT\n";
                    cin>>c;
                    switch(c)
                        {
                            case 1:
                                {
                                  system("cls");
                                    admin obj1;
                                    int x;
                                    x= obj1.adminlogin();
                                    if(x==1)
                                    {
                                        cout<<"login success\n";
                                        system("cls");
                                        cout<<"PRESS 1 TO  ADD TRAIN DETILS\nPRESS 2 TO REMOVE TRAIN DETAILS \nELSE IT WILL EXIT!";
                                        cin>>v;
                                        if(v==1)
                                        {
                                            admin obj1;
                                            obj1.addtrain();
                                        }
                                        else if(v==2)
                                        {
                                            //
                                        }
                                        else{
                                            break;
                                        }
                                    }
                                    else{
                                        cout<<"LOGIN DETAILS NOT FOUND \n";
                                        cout<<"TRY ONCE";
                                    }
                                }
                            case 0:
                                {
                                    exit(1);
                                }            
                        }
                }
            }
}            
