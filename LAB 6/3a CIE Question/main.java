import calDistance.Distance;

class main{
    public static void main(String[] args) {
        Distance dist1 = new Distance(5, 8);
        Distance dist2 = new Distance(3, 10);

        System.out.println("Distance 1:");
        dist1.display();

        System.out.println("Distance 2:");
        dist2.display();


        Distance resultDist = dist1.add(dist2);
        System.out.println("Sum of Distance 1 and Distance 2:");
        resultDist.display();

        Distance largerDist = dist1.compare(dist2);
        System.out.println("Larger Distance:");
        largerDist.display();
    }
}