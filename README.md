# Simple-Network-Simulation-In-Java
This Project is Java Based Project to Demonstrate the Working of a Local Are Network With 10 Host Connected to a Router Via 2 Switches. The Router is a DHCP enabled  Router and is Connected to a DNS Server and a HTTP Server. All the Hosts are Allowed to Ping any of the Network Resource and can also Make HTTP as well as DNS Request.

In the Main Class NetworksProject, We First Created the Objectof Router Class and Then Creted the Object for Switch Class named sw. The arguments passed to the constructor are Switch Name, Interface of Router at Which it is to be Connected and IP Address of that Interface. Then the Object for Host Class is Created with Host Name, MAC Address, Default Gateway, Switch Connected and Port of Switch at Which it is Connected as Arguments for the Constructor and After that a DHCP Request is Made to the Router and it Dynamically Allocates the IP Addresses to the Hosts. 

The Function Ping Comes with a Key Variable Known as MODE.
if Mode = 0 => PING REQUEST
if Mode = 1 => HTTP REQUEST
if Mode = 2 => DNS REQUEST
