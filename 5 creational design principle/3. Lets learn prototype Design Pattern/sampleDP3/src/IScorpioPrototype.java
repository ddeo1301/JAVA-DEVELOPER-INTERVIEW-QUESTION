public interface IScorpioPrototype {
    public IScorpioPrototype clone(); // hme clone() method likhna hi prega as we are implementing using this only
    // clone method mein hi hm logic likh rhe hai how to implement method

    public void setEngine(ScorpioEngine scorpioEngine);// jo bhi diff hai like here engine to hme use setter ke form m likhna prega
    // clone and setter are most important

    public void start();// random method

}
