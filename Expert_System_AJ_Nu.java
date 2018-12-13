

import java.util.Scanner;

public class Expert_System_AJ_Nu 
{
    
        public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many of rules : ");
        int x = scan.nextInt();
        int k=0;
        String [] kx,tof;
        kx = new String[x];
        tof = new String[x];
        String [] rw;
        rw = new String[x];
        String [] rx;
        rx = new String[x];
        String [] ry;
        ry = new String[x];
        String [] rz;
        rz = new String[x];
        int n1,n2,n3,n4,n5;
        
        for (int i = 0; i < x; i++) 
        {  
            if(i==0)
            {
                System.out.print("Node "+(i+1)+" : ");  
                kx[i] = scan.nextLine();
            }
            else
                System.out.print("Node "+(i+1)+" : ");
                kx[i] = scan.nextLine(); 
        }
        for (int i = 0; i < x; i++) 
            {
                n1 = kx[i].indexOf("if");
                n2 = kx[i].indexOf("or");
                n3 = kx[i].indexOf("and");
                n4 = kx[i].indexOf("then");
                n5 = kx[i].length();
        
                if(n2<0&&n3<0)//no or & and
                {
                    rw[i] = kx[i].substring(n1+3,n4);
                    rx[i]="";
                    ry[i]="";
                    rz[i] = kx[i].substring(n4+5,n5); 
                }
                else if(n2>0&&n3<0)//have or
                {
                    rw[i] = kx[i].substring(n1+3,n2);
                    rx[i] = kx[i].substring(n2+3,n4);
                    ry[i]="";
                    rz[i] = kx[i].substring(n4+5,n5);
                }
                else if(n2<0&&n3>0)//have and
                {
                    rw[i] = kx[i].substring(n1+3,n3);
                    rx[i]="";
                    ry[i] = kx[i].substring(n3+4,n4);
                    rz[i] = kx[i].substring(n4+5,n5);
                }
                else if(n2>0&&n3>0)//have or & and
                {
                    if(n2<n3)//or มาก่อน and
                    {
                        rw[i] = kx[i].substring(n1+3,n2);
                        rx[i] = kx[i].substring(n2+3,n3);
                        ry[i] = kx[i].substring(n3+4,n4);
                        rz[i] = kx[i].substring(n4+5,n5);
                    }
                    else if(n3<n2)//and มาก่อน or
                    {
                        rw[i] = kx[i].substring(n1+3,n3);
                        rx[i] = kx[i].substring(n3+4,n2);
                        ry[i] = kx[i].substring(n2+3,n4);
                        rz[i] = kx[i].substring(n4+5,n5);
                    } 
                }
                
    if((n2<0&&n3<0)&&i==0)//no or & and first
          {
            node z1 = new node(rw[i],false);
            node z4 = new node(rz[i],false);
            
            System.out.print("Enter "+ z1.name+" truth: ");
            String temp = scan.nextLine();
            z1.truth = temp.equals("true");
            z4.truth = z1.truth;
            
            System.out.println(z4.name + " " + z4.truth);
            }
    else if((n2>0&&n3<0)&&i==0)//have or first
            {
            node z1 = new node(rw[i],false);
            node z2 = new node(rx[i],false);
            node z4 = new node(rz[i],false);
            
            System.out.print("Enter "+ z1.name+" truth: ");
            String temp1 = scan.nextLine();
            z1.truth = temp1.equals("true");
            System.out.print("Enter "+ z2.name+" truth: ");
            String temp2 = scan.nextLine();
            z2.truth = temp2.equals("true");
            
            z4.truth = z1.truth||z2.truth;
            System.out.println(z4.name + " " + z4.truth);
            }
    else if((n2<0&&n3>0)&&i==0)//have and first
            {
            node z1 = new node(rw[i],false);
            node z3 = new node(ry[i],false);
            node z4 = new node(rz[i],false);
            
            System.out.print("Enter "+ z1.name+" truth: ");
            String temp1 = scan.nextLine();
            z1.truth = temp1.equals("true");
            System.out.print("Enter "+ z3.name+" truth: ");
            String temp2 = scan.nextLine();
            z3.truth = temp2.equals("true");
            
            z4.truth = z1.truth&&z3.truth;
            System.out.println(z4.name + " " + z4.truth);
            }
    else if((n2>0&&n3>0)&&i==0)//have or & and first
            {
            if(n2<n3)//or มาก่อน and
                {
                node z1 = new node(rw[i],false);
                node z2 = new node(rx[i],false);
                node z3 = new node(ry[i],false);
                node z4 = new node(rz[i],false);
                
                System.out.print("Enter "+ z1.name+" truth: ");
                String temp1 = scan.nextLine();
                z1.truth = temp1.equals("true");
                System.out.print("Enter "+ z2.name+" truth: ");
                String temp2 = scan.nextLine();
                z2.truth = temp2.equals("true");
                System.out.print("Enter "+ z3.name+" truth: ");
                String temp3 = scan.nextLine();
                z3.truth = temp3.equals("true");
                
                z4.truth = z1.truth||(z2.truth&&z3.truth);
                System.out.println(z4.name + " " + z4.truth);
                }
            if(n2>n3)//and มาก่อน or
                {
                node z1 = new node(rw[i],false);
                node z2 = new node(rx[i],false);
                node z3 = new node(ry[i],false);
                node z4 = new node(rz[i],false);
                
                System.out.print("Enter "+ z1.name+" truth: ");
                String temp1 = scan.nextLine();
                z1.truth = temp1.equals("true");
                System.out.print("Enter "+ z2.name+" truth: ");
                String temp2 = scan.nextLine();
                z2.truth = temp2.equals("true");
                System.out.print("Enter "+ z3.name+" truth: ");
                String temp3 = scan.nextLine();
                z3.truth = temp3.equals("true");
                
                z4.truth = (z1.truth&&z3.truth)||z2.truth;
                System.out.println(z4.name + " " + z4.truth);
                }
            }
                
    if((n2<0&&n3<0)&&i>0)//no or & and
          {
            node z5 = new node(rw[i],false);
            node z8 = new node(rz[i],false);
            
            System.out.print("Enter "+ z5.name+" truth: ");
            String temp = scan.nextLine();
            z5.truth = temp.equals("true");
            
            z8.truth = z5.truth;
            System.out.println(z8.name + " " + z8.truth);
            }
    else if((n2>0&&n3<0)&&i>0)//have or
            {
            node z5 = new node(rw[i],false);
            node z6 = new node(rx[i],false);
            node z8 = new node(rz[i],false);
            
            System.out.print("Enter "+ z5.name+" truth: ");
            String temp1 = scan.nextLine();
            z5.truth = temp1.equals("true");
            System.out.print("Enter "+ z6.name+" truth: ");
            String temp2 = scan.nextLine();
            z6.truth = temp2.equals("true");
            
            z8.truth = z5.truth||z6.truth;
            System.out.println(z8.name + " " + z8.truth);
            }
    else if((n2<0&&n3>0)&&i>0)//have and
            {
            node z5 = new node(rw[i],false);
            node z7 = new node(ry[i],false);
            node z8 = new node(rz[i],false);
            
            System.out.print("Enter "+ z5.name+" truth: ");
            String temp1 = scan.nextLine();
            z5.truth = temp1.equals("true");
            System.out.print("Enter "+ z7.name+" truth: ");
            String temp2 = scan.nextLine();
            z7.truth = temp2.equals("true");
            
            z8.truth = z5.truth&&z7.truth;
            System.out.println(z8.name + " " + z8.truth);
            }        
    else if((n2>0&&n3>0)&&i>0)//have or & and
            {
            if(n2<n3)//or มาก่อน and
                {
                node z5 = new node(rw[i],false);
                node z6 = new node(rx[i],false);
                node z7 = new node(ry[i],false);
                node z8 = new node(rz[i],false);
                
                System.out.print("Enter "+ z5.name+" truth: ");
                String temp1 = scan.nextLine();
                z5.truth = temp1.equals("true");
                System.out.print("Enter "+ z6.name+" truth: ");
                String temp2 = scan.nextLine();
                z6.truth = temp2.equals("true");
                System.out.print("Enter "+ z7.name+" truth: ");
                String temp3 = scan.nextLine();
                z7.truth = temp3.equals("true");
                
                z8.truth = z5.truth||(z6.truth&&z7.truth);
                System.out.println(z8.name + " " + z8.truth);
                }
            if(n2>n3)//and มาก่อน or
                {
                node z5 = new node(rw[i],false);
                node z6 = new node(rx[i],false);
                node z7 = new node(ry[i],false);
                node z8 = new node(rz[i],false);
                
                System.out.print("Enter "+ z5.name+" truth: ");
                String temp1 = scan.nextLine();
                z5.truth = temp1.equals("true");
                System.out.print("Enter "+ z7.name+" truth: ");
                String temp2 = scan.nextLine();
                z7.truth = temp2.equals("true");
                System.out.print("Enter "+ z6.name+" truth: ");
                String temp3 = scan.nextLine();
                z6.truth = temp3.equals("true");
                
                z8.truth = (z5.truth&&z7.truth)||z6.truth;
                System.out.println(z8.name + " " + z8.truth);
                }
            }
        }
    }
}

class node
{
  public String name;
  public boolean truth;
  public node link = null;
  public node(String name,boolean truth)
    {
    this.name = name;
    this.truth = truth;
  }
}