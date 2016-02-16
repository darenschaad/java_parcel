import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest {


  @Test
  public void newVolume_passParameters_returnVolume() {
  Parcel testParcel = new Parcel(12.0, 12.0, 12.0, 3.0);
  assertEquals(1.0,testParcel.Volume(),0);
  }
  @Test
  public void newCost_passParameters_returnCost() {
  Parcel testParcel = new Parcel(12.0, 12.0, 12.0, 3.0);
  assertEquals("11.50",testParcel.Cost());
  }
  @Test
  public void newCost1_passParameters_returnCost() {
  Parcel testParcel = new Parcel(12343.0, 12.0, 12.0, 11.0);
  assertEquals("105.50",testParcel.Cost());
  }

}
