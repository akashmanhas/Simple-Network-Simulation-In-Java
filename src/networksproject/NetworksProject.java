/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksproject;

import java.util.Scanner;

/**
 *
 * @author Akash
 */
public class NetworksProject {

   
    public static void main(String[] args) {
        
        Router R=new Router();
        Switch sw=new Switch("Switch1",R.intrfaceNo[0],R.ip[0]);
        
        Host h1=new Host("PC1","A:B:C:D:1:2","1.2.3.1",sw,0);        
        R.DHCP(h1, sw);
        Host h2=new Host("PC2","E:F:G:H:1:2","1.2.3.1",sw,1);        
        R.DHCP(h2, sw);
        Host h3=new Host("PC3","I:J:K:L:1:2","1.2.3.1",sw,2);        
        R.DHCP(h3, sw);
        Host h4=new Host("PC4","M:N:O:P:1:2","1.2.3.1",sw,3);        
        R.DHCP(h4, sw);
        Host h5=new Host("PC5","Q:R:S:T:1:2","1.2.3.1",sw,4);        
        R.DHCP(h5, sw);
        
        Switch sw2=new Switch("Switch2",R.intrfaceNo[1],R.ip[1]);
        Host h6=new Host("PC6","AA:BB:CC:DD:1:2","7.7.7.1",sw2,0);
        R.DHCP(h6, sw2);
        Host h7=new Host("PC7","EE:FF:GG:HH:1:2","7.7.7.1",sw2,1);
        R.DHCP(h7, sw2);
        Host h8=new Host("PC8","II:JJ:KK:LL:1:2","7.7.7.1",sw2,2);
        R.DHCP(h8, sw2);
        Host h9=new Host("PC9","MM:NN:OO:PP:1:2","7.7.7.1",sw2,3);
        R.DHCP(h9, sw2);
        Host h10=new Host("PC10","QQ:RR:SS:TT:1:2","7.7.7.1",sw2,4);
        R.DHCP(h10, sw2);
        
        
        sw.getDetails();
        sw2.getDetails();
        
        HTTP h=new HTTP();
        DNS d=new DNS();

        /* ------------INPUTS FROM LAN 2--------------- */
        
        System.out.println("--------->READING INPUT REQUESTS FROM LAN 2<---------\n");
        
        h6.ping(sw2, R, sw, h,d,"1.2.3.1",0);
        h6.ping(sw2, R, sw, h,d,"7.7.7.1",0);
        h6.ping(sw2, R, sw, h,d,"5.5.5.1",0);
        h6.ping(sw2, R, sw, h,d,"6.6.6.1",0);
        
        h6.ping(sw2, R, sw, h,d,"1.2.3.2",0);
        h6.ping(sw2, R, sw, h,d,"7.7.7.2",0);
        h6.ping(sw2, R, sw, h,d,"5.5.5.2",0);
        h6.ping(sw2, R, sw, h,d,"6.6.6.2",0);
        
        h6.ping(sw2, R, sw, h,d,"6.6.6.1",1);
        h6.ping(sw2, R, sw, h,d,"6.6.6.2",1);
        
        h6.ping(sw2, R, sw, h,d,"www.gogle.com",2);
        h6.ping(sw2, R, sw, h,d,"www.google.com",2);
        
        /* ------------INPUTS FROM LAN 1--------------- */
        
        
        System.out.println("--------->READING INPUT REQUESTS FROM LAN 1<---------\n");
        
        h1.ping(sw, R, sw2, h,d,"1.2.3.1",0);
        h1.ping(sw, R, sw2, h,d,"7.7.7.1",0);
        h1.ping(sw, R, sw2, h,d,"5.5.5.1",0);
        h1.ping(sw, R, sw2, h,d,"6.6.6.1",0);
        
        h1.ping(sw, R, sw2, h,d,"1.2.3.2",0);
        h1.ping(sw, R, sw2, h,d,"7.7.7.2",0);
        h1.ping(sw, R, sw2, h,d,"5.5.5.2",0);
        h1.ping(sw, R, sw2, h,d,"6.6.6.2",0);
        
        h1.ping(sw, R, sw2, h,d,"6.6.6.1",1);
        h1.ping(sw, R, sw2, h,d,"6.6.6.2",1);
        
        h1.ping(sw, R, sw2, h,d,"www.gogle.com",2);
        h1.ping(sw, R, sw2, h,d,"www.google.com",2);
        
        System.out.println("Test");
        h1.ping(sw,R,sw2,h,d,"www.google.com",2);
        
    }
    
}
