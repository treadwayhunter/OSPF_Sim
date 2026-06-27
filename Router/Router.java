package OSPF_Sim.Router;

import OSPF_Sim.Router.Hardware.RouterInterface;

/*
A router has interfaces and a routing table
    Interfaces connect to other interfaces by a link (an edge)

    - interfaces
    - routing table
        - static routes
        - dynamic routes
    - OSPF process
        - Reference bandwidth
    - CLI daemon
*/

public class Router {
    private RouterInterface interface1;
    private RouterInterface interface2;
    
    public Router() {
        this.interface1 = new RouterInterface("TenGigabit1", 10);
        this.interface2 = new RouterInterface("Gigabit1", 1);
    }
}
