package OSPF_Sim;

import OSPF_Sim.IPv4.IPv4Value;
import OSPF_Sim.IPv4.NetAddress;
import OSPF_Sim.IPv4.NetMask;

public class Main {
    public static void main(String[] args) {
        IPv4Value addr = new NetAddress("192.168.10.10");
        System.out.println(addr);

        IPv4Value mask = new NetMask("999.999.999.999");
        System.out.println(mask);

        IPv4Value netid = new NetAddress(addr.getValue() & mask.getValue());
        System.out.println(netid);
    }
}
