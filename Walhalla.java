import java.util.*;
class Walhalla
{
    int sod(long k)//to find some of digits
    {
        int sum=0;
        while(k>0)
        {
            sum=sum+(int)k%10;
            k/=10;
        }
        return sum;
    }

    int nod(long k)//to find no. of digits
    {
        int c=0;
        while(k>0)
        {
            c++;
            k/=10;
        }
        return c;
    }

    boolean imei(long k)
    {
        int sum=0;
        for(int i =1;i<=15;i++)
        {
            int temp=0;
            if(i%2==0)
            {
                temp=sod((k%10)*2);
            }
            else
            {
                temp=(int)k%10;
            }
            sum+=temp;
            k=k/10;
        }
        if(k%10==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean isbn(long k)
    {
        long res=0;
        int c=1;
        if(nod(k)==10)
        {
            while(k>0)
            {
                res=res+((k%10)*c);
                k=k/10;
                c++;
            }
            if(res%11==0)
            {
                return true;
            }
            else
            { 
                return false;
            }
        }
        else if(nod(k)==13)
        {
            while(k>0)
            {
                if(c%2==0)
                {
                    res = res+(k%10)*3;
                }
                else
                {
                    res = res+(k%10);
                }
            }
            if(res%10==0)
            {
                return true;
            }
            else
            { 
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    void apple(String a)
    {
        int counter =1;
        if(a.length()==12)
        {
            char b=a.charAt(0);
            String c=a.substring(0,2);
            char d=a.charAt(3);
            char e=a.charAt(4);
            if(b=='F'||b=='E'||c=="FC"||c=="XA"||c=="XB"||c=="QP"||c=="G8"||c=="RN"||c=="CK"||c=="VM"||c=="SG"||c=="MB"||c=="PT"||c=="CY"||c=="EE"
            ||c=="QT"||c=="UV"||c=="FK"||c=="F1"||c=="F2"||c=="W8"||c=="DL"||c=="DM"||c=="DN"||c=="YM"||c=="7J"||c=="1C"||c=="4H"||c=="WQ"
            ||c=="F7"||c=="C0"||c=="C3"||c=="C7"||c=="RM")
            {
                counter++;
            }
            if(d=='E'||d=='I'||d=='O'||d=='U')
            {
            }
            else
            {
                counter++;
            }
            if(e=='E'||e=='I'||e=='O'||e=='U'||e=='0')
            {
            }
            else
            {
                counter++;
            }        

            if(counter==3)
            {
                System.out.println("Your Serial Code is Valid.");
            }
            else
            {  
                System.out.println("Your Serial Code is Invalid.");
            }
        }
    }

    boolean visa(long n)
    {
        int d=nod(n);//no. of digits
        if(d==13|| d==16)
        {
            n=n/(long)Math.pow(10,d-1);//first digit
            if(n==4)
                return true;
            else 
                return false;
        }
        else
            return false;
    }

    boolean mastercard(long n)
    {
        int d=nod(n);//no. of digits
        if(d==16)
        {
            n=n/(long)Math.pow(10,d-1);//first digit
            if(n==5)
                return true;
            else 
                return false;
        }
        else
            return false;
    }

    boolean american(long n)
    {
        int f=0;int s=0;
        int d=nod(n);//no. of digits
        if(d==15)
        {
            n=n/(long)Math.pow(10,d-2);//first 2 digits
            s=(int)n%10;//second digit
            f=(int)n/10;//first digit
            if(f==3)
            {
                if(s==4 || s==7)
                    return true;
                else 
                    return false;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    boolean discover(long n)
    {
        int d=nod(n);//no. of digits
        if(d==16)
        {
            n=n/(long)Math.pow(10,d-1);//first digit
            if(n==6)
                return true;
            else 
                return false;
        }
        else
            return false;
    }

    boolean diners(long n)
    {
        int f=0;int s=0;
        int d=nod(n);//no. of digits
        if(d==14)
        {
            n=n/(long)Math.pow(10,d-2);//first two digits
            s=(int)n%10;//second digit
            f=(int)n/10;//first digit
            if(f==3)
            {
                if(s==0 || s==6 || s==8)
                    return true;
                else 
                    return false;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public static void main(String args[])
    {
        Walhalla ob=new Walhalla();
        Scanner sc=new Scanner(System.in);
        boolean res;
        System.out.println("Enter your choice to check for the validity of the following:\n1.IMEI Number \n2.ISBN Number \n3.Apple Serial Number \n4.VISA Card Number \n5.Mastercard Number \n6.American Express Card Number \n7.Discover Card Number \n8.Diners Club Card Number");
        int choice=sc.nextInt();
        switch(choice)//to handle cases according to user choice
        {
            case 1:
            System.out.println("Enter your IMEI number:");
            long n1=sc.nextLong();
            res=ob.imei(n1);
            if(res==true)
            {
                System.out.println("Your number is a valid IMEI number.");
            }
            else 
            {
                System.out.println("Your number is an invalid IMEI number.");
            }
            break;

            case 2:
            System.out.println("Enter your ISBN number:");
            long n2=sc.nextLong();
            res=ob.isbn(n2);
            if(res==true)
            {
                System.out.println("Your number is a valid ISBN number.");
            }
            else 
            {
                System.out.println("Your number is an invalid ISBN number.");
            }
            break;

            case 3:
            System.out.println("Enter your Apple Serial code:");
            String s=sc.next();
            ob.apple(s);
            break;
            
            case 4:
            System.out.println("Enter your VISA Card number:");
            long n3=sc.nextLong();
            res=ob.visa(n3);
            if(res==true)
            {
                System.out.println("Your number is a valid VISA Card number.");
            }
            else 
            {
                System.out.println("Your number is an invalid VISA Card number.");
            }
            break;
            
            case 5:
            System.out.println("Enter your Mastercard number:");
            long n4=sc.nextLong();
            res=ob.mastercard(n4);
            if(res==true)
            {
                System.out.println("Your number is a valid Mastercard number.");
            }
            else 
            {
                System.out.println("Your number is an invalid Mastercard number.");
            }
            break;
            
            case 6:
            System.out.println("Enter your American Express Card number:");
            long n5=sc.nextLong();
            res=ob.american(n5);
            if(res==true)
            {
                System.out.println("Your number is a valid American Express Card number.");
            }
            else 
            {
                System.out.println("Your number is an invalid American Express Card number.");
            }
            break;
            
            case 7:
            System.out.println("Enter your Discover Card number:");
            long n6=sc.nextLong();
            res=ob.discover(n6);
            if(res==true)
            {
                System.out.println("Your number is a valid Discover Card number.");
            }
            else 
            {
                System.out.println("Your number is an invalid Discover Card number.");
            }
            break;

            case 8:
            System.out.println("Enter your Diners Club Card number:");
            long n7=sc.nextLong();
            res=ob.diners(n7);
            if(res==true)
            {
                System.out.println("Your number is a valid Diners Club Card number.");
            }
            else 
            {
                System.out.println("Your number is an invalid Diners Club Card number.");
            }
            break;
    
            default:
            System.out.println("Invalid Input.");
        }
    }
}
    