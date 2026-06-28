package OSPF_Sim.IPv4;


public class NetMask extends IPv4Value {

    public NetMask(int mask) {
        if(validMask(mask)) {
            this.value = mask;
        }
        else {
            throw new IllegalArgumentException("Invalid NetMask provided.");
        }
    }

    public NetMask(String mask) {
        int val = stringToValue(mask);
        if (validMask(val)) {
            this.value = val;
        }
        else {
            throw new IllegalArgumentException("Invalid NetMask provided.");
        }
    }
    
    private boolean validMask(int mask) {
        // MASK
        // INVERT MASK
        // INVERT MASK + 1
        // INVERT MASK & INVERT MASK + 1

        int invertedMask = mask ^ 0xffffffff;

        if( ((invertedMask + 1) & (invertedMask)) == 0) {
            return true; // MASK is valid
        }
        
        return false;
    }
}
