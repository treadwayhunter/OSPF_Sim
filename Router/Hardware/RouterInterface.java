package OSPF_Sim.Router.Hardware;

import OSPF_Sim.IPv4.IPv4Network;
import OSPF_Sim.Router.Router;

/**
    A router interface has a lot more going on
    Let's assume they're ethernet
    - bandwidth
    - physical status up/down/shutdown
    - protocol status up/down
    - OSPF enabled
        - which area?
        - all will be point-to-point by default
    - interface will have an IP address????
 */

/*
    Some important things to note
        - capableBandwidth > determined by hardware
        - actualBandwidth > determined by lowest of connected RouterInterface
*/

public class RouterInterface {
    enum PhysicalStatus {
        UP,
        DOWN,
        SHUTDOWN
    }

    enum ProtocolStatus {
        UP,
        DOWN
    }
    
    private IPv4Network network;  // optional
    private String interfaceName; // mandatory on construction
    private int capableBandwidth; // mandatory on construction, in Gigabits, i.e. 1 = 1G, 10 = 10G, 25 = 25G
    private int actualBandwidth;  // generated when connected to another interface
    private PhysicalStatus physicalStatus;
    private ProtocolStatus protocolStatus;

    public RouterInterface(String interfaceName, int capableBandwidth) {
        this.interfaceName = interfaceName;
        this.capableBandwidth = capableBandwidth;
    }

    public void setNetwork(IPv4Network newNetwork) {
        this.network = newNetwork;
    }

    public IPv4Network getNetwork() {
        return network;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public int getCapableBandwidth() {
        return capableBandwidth;
    }

    public int getActualBandwidth() {
        return actualBandwidth;
    }
    
    public PhysicalStatus getPhysicalStatus() {
        return physicalStatus;
    }

    public ProtocolStatus geProtocolStatus() {
        return protocolStatus;
    }
    
}
