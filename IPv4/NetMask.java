package OSPF_Sim.IPv4;

public class NetMask extends NetAddress {

    public NetMask(int mask) {
        super(mask);
        //TODO Auto-generated constructor stub
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
