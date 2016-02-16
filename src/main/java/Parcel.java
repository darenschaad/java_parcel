public class Parcel {
  private double mLength;
  private double mWidth;
  private double mHeight;
  private double mWeight;


  public Parcel(double length, double width, double height, double weight) {
    mLength = length;
    mWidth = width;
    mHeight = height;
    mWeight = weight;
  }

  public double Volume() {
    double volume = mLength/12.0 * mWidth/12.0 * mHeight/12.0;
    return volume;
  }

  public double WeightCost() {
    double weightCost = 0.5 * mWeight;
    return weightCost;
  }

  public double VolumeCost() {
    double volumeCost = 0.0;
    if (Volume() < 1) {
      volumeCost = 0.0;
    }
    else if (Volume() >= 1 && Volume() < 4){
      volumeCost = 10.0;
    }
    else if (Volume() >= 4 && Volume() < 10){
      volumeCost = 20.0;
    }
    else if (Volume() >= 10 && Volume() < 40){
      volumeCost = 40.0;
    }
    else {
      volumeCost = 100.00;
    }
    return volumeCost;
  }



  public String Cost(){
    double totalCost = VolumeCost() + WeightCost();
    return String.format("%.2f", totalCost);
  }

}
