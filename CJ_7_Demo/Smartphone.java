package CJ_7_Demo;

public class Smartphone implements Phone, Camera {
    @Override
    public void makeCall() {
        System.out.println("Making a call from the smartphone.");
    }

    @Override
    public void takePicture() {
        System.out.println("Taking a picture with the smartphone.");
    }
}
