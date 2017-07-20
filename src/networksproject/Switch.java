/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksproject;

/**
 *
 * @author Akash
 */
class Switch{
    String name;
    String Rintrface;
    String Rip;
    String portNo[]=new String[6];
    int count=2;
    
       
    int getCount()
    {
        return count;
    }   
    void incCount()
    {
        count=count+1;
    }
    
    Switch(String name,String Rintrface,String Rip){
        this.name=name;
        this.Rintrface=Rintrface;
        this.Rip=Rip;
    }
    
    void sendPacketSwitch(Switch swt,Router R,Switch swt2,HTTP h,DNS d, String destAddress,int mode)
    {
        if(mode==0)//ping
        {
            int flag=0;
            int i=0;
            while(swt.portNo[i]!=null)
            {

               if(swt.portNo[i].equals(destAddress))
               {
                   System.out.println("Ping to "+swt.portNo[i]+" Successful.....");
                   flag=1;
                   break;
               }
               i++;
            }

            if(flag==0)
            {
                R.sendPacketRouter(swt,R,swt2,h,d,destAddress,swt.Rintrface,mode);
            }
        }
        if(mode==1)//HTTP
        {
            R.sendPacketRouter(swt,R,swt2,h,d,destAddress,swt.Rintrface,mode);
        }
        if(mode==2)//DNS
        {
            R.sendPacketRouter(swt,R,swt2,h,d,destAddress,swt.Rintrface,mode);
        }
    }
    
    void getDetails()
    {
        System.out.println("DISPLAYING SWITCH DETAILS");
        System.out.println("Switch Name : "+name);
        System.out.println("Switch Router Interface Connected : "+Rintrface);
        System.out.println("Switch Router IP Connected : "+Rip);
        System.out.println("Switch PORT[0] IP : "+portNo[0]);
        System.out.println("Switch PORT[1] IP : "+portNo[1]);
        System.out.println("Switch PORT[2] IP : "+portNo[2]);
        System.out.println("Switch PORT[3] IP : "+portNo[3]);
        System.out.println("Switch PORT[4] IP : "+portNo[4]);
        System.out.println();
    }
    
}
