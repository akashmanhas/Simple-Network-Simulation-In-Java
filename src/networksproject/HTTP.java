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
class HTTP{
    String ip;
    HTTP()
    {
        ip="6.6.6.2";
    }
    String getIp()
    {
        return ip;
    }
    
    void httpRequest()
    {
        System.out.println("Displaying Webpage at "+ip+"\n");
    }
}
