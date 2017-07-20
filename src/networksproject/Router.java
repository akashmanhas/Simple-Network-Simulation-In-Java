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
class Router{
    String name;
    String intrfaceNo[]=new String[4];
    String ip[]=new String[4];
    String subnetMask[]=new String[4];
    String type[]=new String[4];
    
    Router()
    {
        name="Router1";
        
        intrfaceNo[0]="0/0";
        ip[0]="1.2.3.1";
        subnetMask[0]="255.255.255.0";
        type[0]="HOST";
        
        intrfaceNo[1]="1/0";
        ip[1]="7.7.7.1";
        subnetMask[1]="255.255.255.0";
        type[1]="HOST";
        
        intrfaceNo[2]="2/0";
        ip[2]="6.6.6.1";
        subnetMask[2]="255.255.255.0";
        type[2]="HTTP_SERVER";
        
        intrfaceNo[3]="3/0";
        ip[3]="5.5.5.1";
        subnetMask[3]="255.255.255.0";
        type[3]="DNS_SERVER";
    }
    
    void sendPacketRouter(Switch swt,Router R,Switch swt2,HTTP h,DNS d,String destAddress,String intrface,int mode)
    {
        if(mode==0)//ping
        {
            int flag=0;
            for(int i=0;i<4;++i)
            {
                if(R.ip[i].equals(destAddress))
                {
                    System.out.println("Ping to "+R.ip[i]+" Successful.....");
                    flag=1;
                    break;
                }
                if(!R.intrfaceNo[i].equals(intrface))
                {
                    if(type[i]=="HOST")
                    {
                        int j=0;
                        while(swt2.portNo[j]!=null)
                        {
                            if(swt2.portNo[j].equals(destAddress))
                            {
                                System.out.println("Ping to "+swt2.portNo[j]+" Successful.....");
                                flag=1;
                                break;
                            }
                            j++;
                        }
                    }
                    if(type[i]=="HTTP_SERVER")
                    {
                        for(int j=0;j<4;++j)
                        {
                            if(R.type[j].equals("HTTP_SERVER"))
                            {
                                
                                if(R.ip[j].equals(destAddress))
                                {
                                    System.out.println("Ping to "+R.ip[j]+" Successful.....");
                                    flag=1;
                                    break;
                                }else if(h.getIp().equals(destAddress))
                                    {
                                        System.out.println("Ping to "+h.getIp()+" Successful.....");
                                        flag=1;
                                        break;
                                    }
                                
                                                                    
                            }
                        }
                    }
                    if(type[i]=="DNS_SERVER")
                    {
                        for(int j=0;j<4;++j)
                        {
                            if(R.type[j].equals("DNS_SERVER"))
                            {
                                
                                if(R.ip[j].equals(destAddress))
                                {
                                    System.out.println("Ping to "+R.ip[j]+" Successful.....");
                                    flag=1;
                                    break;
                                }else if(d.getIp().equals(destAddress))
                                    {
                                        System.out.println("Ping to "+d.getIp()+" Successful.....");
                                        flag=1;
                                        break;
                                    }
                                
                                                                    
                            }
                        }
                    }
               }
            }
            if(flag==0)
                {
                    System.out.println("Destination Un-Reachable.....\n");
                }
        }
        if(mode==1)
        {
            System.out.println("======> WEB BROWSER <======");
            for(int i=0;i<3;++i)
            {
                if(R.type.equals("HTTP_SERVER"))
                {
                    int index=i;
                    break;
                }
            }
            
            String ipAddr=h.getIp();
            if(ipAddr.equals(destAddress))
            {
                h.httpRequest();
            }else{
                System.out.println("Destination Un-Reachable.....\n");
            }
        }
        if(mode==2)
        {
            d.dnsRequest(destAddress);
            if(d.domainName.equals(destAddress))
            {
                R.sendPacketRouter(swt,R,swt2,h,d,d.ipAddress,swt.Rintrface,1);
            }
            else
            {
                System.out.println("Message From DNS : Destination Un-Reachable.....\n");
            }
        }
    }
    
        
    void DHCP(Host hs, Switch sw)
    {
        System.out.println("Processing DHCP Request By Host : "+hs.name+" ........");
        int lastOctet=sw.getCount();
        String routerInterface=sw.Rintrface;
        String ip=sw.Rip;
        int index=ip.lastIndexOf('.');
        ip=ip.substring(0,index);
        ip=ip+"."+lastOctet;
        hs.ip=ip;
        sw.portNo[hs.port]=hs.ip;
        System.out.println("DHCP Request Successful. New Ip Assigned : "+hs.ip);
        sw.incCount();
        System.out.println();
        
    }
}