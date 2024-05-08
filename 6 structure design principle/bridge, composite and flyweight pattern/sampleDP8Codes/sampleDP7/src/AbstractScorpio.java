public abstract class AbstractScorpio {
    //BRIDGE
    AbstractScorpioImpl scorpioImpl; // composition k ander hm implementation ka ek object apne pass rkh lete hai

    public AbstractScorpio(AbstractScorpioImpl sc) { // composition ko refer krne k lye create kr lnge
        this.scorpioImpl = sc; // reference copy krwa dunga
    }


    abstract boolean isRightHanded();
    abstract void printSafetyReq();
}
