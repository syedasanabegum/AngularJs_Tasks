/* Program 2:
 Copy text file to another text file
*/
import java.io.*;
public class content_copy{
	public static void main(String[] args)
		throws IOException
	{

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {

			fis = new FileInputStream(
				"C:\\Users\\HP\\Desktop\\XIT\\task4_prg\\input.txt");
			fos = new FileOutputStream(
				"C:\\Users\\HP\\Desktop\\XIT\\task4_prg\\output.txt");

			int c;

			while ((c = fis.read()) != -1) {
				fos.write(c);
			}

			System.out.println(
				"copied the file successfully");
		}

		finally {

			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}
}
