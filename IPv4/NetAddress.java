package OSPF_Sim.IPv4;

public class NetAddress {
    private int addr;

    enum Bitwise {
        AND,
        OR,
        XOR,
        NOT
    }

    public NetAddress(int addr) {
        this.addr = addr; // some kind of type check, it needs to be a 32 bit integer
    }

    public NetAddress(String addr) {
        String[] tempAddr = addr.split("\\.");

        if (tempAddr.length != 4) {
            throw new IllegalArgumentException("Unrecognized IPv4 Address format " + addr);
        }

        int octet1 = Integer.parseInt(tempAddr[0]) << 24;
        int octet2 = Integer.parseInt(tempAddr[1]) << 16;
        int octet3 = Integer.parseInt(tempAddr[2]) << 8;
        int octet4 = Integer.parseInt(tempAddr[3]);

        this.addr = octet1 | octet2 | octet3 | octet4;
    }

    public int getAddr() {
        return this.addr;
    }

    public static NetAddress compareAddress(NetAddress addr1, NetAddress addr2, Bitwise oper) {

        if(oper == Bitwise.AND) return new NetAddress(addr1.getAddr() & addr2.getAddr());
        if(oper == Bitwise.OR) return new NetAddress(addr1.getAddr() | addr2.getAddr());
        if(oper == Bitwise.XOR) return new NetAddress(addr1.getAddr() ^ addr2.getAddr());
        if(oper == Bitwise.NOT) throw new IllegalArgumentException("Bitwise.NOT not currently supported.");

        return null;
    }

    @Override
    public String toString() {
        int tempAddr = this.addr;

        String addrStr = "";
        int octet4 = tempAddr & 0xff;
        tempAddr >>= 8;
        int octet3 = tempAddr & 0xff;
        tempAddr >>= 8;
        int octet2 = tempAddr & 0xff;
        tempAddr >>= 8;
        int octet1 = tempAddr & 0xff;

        addrStr = octet1 + "." + octet2 + "." + octet3 + "." + octet4;

        return addrStr;
    }
}
