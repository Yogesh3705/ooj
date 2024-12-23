package calDistance;

public class Distance {

    private int feet;
    private int inches;


    public Distance(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
        normalize();
    }


    private void normalize() {
        if (inches >= 12) {
            feet += inches / 12;
            inches = inches % 12;
        }
    }


    public void setDistance(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
        normalize();
    }


    public void display() {
        System.out.println(feet + " feet, " + inches + " inches");
    }

    public Distance add(Distance other) {
        int totalFeet = this.feet + other.feet;
        int totalInches = this.inches + other.inches;
        Distance result = new Distance(totalFeet, totalInches);
        return result;
    }

    public Distance compare(Distance other) {
        int thisTotalInches = this.feet * 12 + this.inches;
        int otherTotalInches = other.feet * 12 + other.inches;

        if (thisTotalInches >= otherTotalInches) {
            return this;
        } else {
            return other;
        }
    }

}
