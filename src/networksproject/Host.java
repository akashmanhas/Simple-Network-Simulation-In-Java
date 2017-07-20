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
class Host{
    String name;
    String ip,mac,dg;
    int port;
    
    Host(String name,String mac,String dg,Switch sw,int port)
    {
        this.name=name;
        this.mac=mac;
        this.dg=dg;
        this.port=port;
        sw.portNo[port]=mac;
        
    }
    
    void ping(Switch swt,Router R,Switch swt2, HTTP h,DNS d,String destAddr,int mode)
    {
        if(mode==0)//ping
        {
            System.out.println("Pinging "+destAddr+" with 32 bit of Data.......");
            swt.sendPacketSwitch(swt,R,swt2, h, d,destAddr,mode);
        }
        if(mode==1)//HTTP
        {
            swt.sendPacketSwitch(swt,R,swt2, h, d,destAddr,mode);
        }
        if(mode==2)//DNS
        {
            swt.sendPacketSwitch(swt,R,swt2, h, d,destAddr,mode);
        }
        
    }
    
    void getDetails()
    {
        System.out.println("DISPLAYING HOST DETAILS");
        System.out.println("Host Name : "+name);
        System.out.println("Host MAC : "+mac);
        System.out.println("Host Default Gateway : "+dg);
        System.out.println("Host IP Address : "+ip);
        System.out.println();
    }
    
}
