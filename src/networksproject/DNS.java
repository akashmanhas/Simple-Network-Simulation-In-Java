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
class DNS{
    String ip;
    String domainName="www.google.com";
    String ipAddress="6.6.6.2";
    DNS()
    {
        ip="5.5.5.2";
    }
    String getIp()
    {
        return ip;
    }
    
    void dnsRequest(String dn)
    {
        System.out.println("Searching DNS Server for Requested Domain : "+dn);
    }
}
