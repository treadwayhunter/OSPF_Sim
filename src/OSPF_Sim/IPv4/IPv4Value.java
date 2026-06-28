package OSPF_Sim.IPv4;

public abstract class IPv4Value {
    protected int value;

    enum Bitwise {
        AND,
        OR,
        XOR,
        NOT
    }

    protected int stringToValue(String value) {
        String[] tempValue = value.split("\\.");

        if (tempValue.length != 4) {
            throw new IllegalArgumentException("Unrecognized IPv4 Value format " + value);
        }

        int octet1 = Integer.parseInt(tempValue[0]);
        octetCheck(octet1);
        octet1 <<= 24;
        int octet2 = Integer.parseInt(tempValue[1]);
        octetCheck(octet2);
        octet2 <<= 16;
        int octet3 = Integer.parseInt(tempValue[2]);
        octetCheck(octet3);
        octet3 <<= 8;
        int octet4 = Integer.parseInt(tempValue[3]);
        octetCheck(octet4);

        return octet1 | octet2 | octet3 | octet4;
    }

    private void octetCheck(int octet) {
        if (octet < 0 || octet > 255) 
            throw new IllegalArgumentException("IPv4Value value octets must be between 0-255 inclusive."); 
    }

    public int getValue() {
        return this.value;
    }


    // TODO this needs rework. IPv4Value is forced to NetAddress.
    public static IPv4Value compareValue(IPv4Value value1, IPv4Value value2, Bitwise oper) {
        if(oper == Bitwise.AND) return new NetAddress(value1.getValue() & value2.getValue());
        if(oper == Bitwise.OR) return new NetAddress(value1.getValue() | value2.getValue());
        if(oper == Bitwise.XOR) return new NetAddress(value1.getValue() ^ value2.getValue());
        if(oper == Bitwise.NOT) throw new IllegalArgumentException("Bitwise.NOT not currently supported.");

        throw new IllegalArgumentException("Something broke.");
    }

    @Override
    public String toString() {
        int tempAddr = this.value;

      
        int octet4 = tempAddr & 0xff;
        tempAddr >>= 8;
        int octet3 = tempAddr & 0xff;
        tempAddr >>= 8;
        int octet2 = tempAddr & 0xff;
        tempAddr >>= 8;
        int octet1 = tempAddr & 0xff;

        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }
}
