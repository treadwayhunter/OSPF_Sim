package OSPF_Sim.IPv4;

public class IPv4Network {
 
    private NetAddress ipaddr;
    private NetAddress netmask;
    

    public IPv4Network(NetAddress ipaddr, NetAddress netmask) {
        this.ipaddr = ipaddr;
        this.netmask = netmask; // TODO this needs to be checked for contiguous 1s
    }

    public NetAddress getIPAddress() {
        return ipaddr;
    }

    public NetAddress getNetMask() {
        return netmask;
    }

    public NetAddress getNetID() {
        return NetAddress.compareAddress(ipaddr, netmask, NetAddress.Bitwise.AND);
    }
}

