package OSPF_Sim.IPv4;

public class NetAddress extends IPv4Value {
    
    public NetAddress(int addr) {
        this.value = addr;
    }

    public NetAddress(String addr) {
        this.value = stringToValue(addr);
    }
}
