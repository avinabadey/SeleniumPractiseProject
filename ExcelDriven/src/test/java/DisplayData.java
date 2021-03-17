import java.io.IOException;
import java.util.ArrayList;

public class DisplayData {

	public static void main(String[] args) throws IOException {
		
		DataDriven data = new DataDriven();
		ArrayList arrData = data.getData("Y");
		
		System.out.println(arrData.get(0));
		System.out.println(arrData.get(1));
		System.out.println(arrData.get(2));
		System.out.println(arrData.get(3));
		System.out.println(arrData.get(4));
		System.out.println(arrData.get(5));
	}

}
