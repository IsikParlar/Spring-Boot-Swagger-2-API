//http://localhost:8080/swagger-ui.html#
package tr.edu.medipol.ilerijavauyg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void creatFile(String veri) {


		File f = new File("C:\\Medipol");
		if (f.exists() && f.isFile()) {

			try {
				File file = new File("C:\\Medipol/H5200024.txt");

				if (file.createNewFile()) {
					System.out.println("Dosya Oluşturuldu");
				} else {
					System.out.println("Dosya Zaten Var");
				}
			} catch (IOException e) {
				System.err.println(e);
			}
		} else {


			try {
				File file = new File("C:\\Users/mparl/Desktop/H5200024.txt"); // Users/Kullandığınız kullanıcın adı/Desktop/H5200024.txt

				if (file.createNewFile()) {
					System.out.println("Dosya Oluşturuldu");
				} else {
					System.out.println("Dosya Zaten Var");
				}
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}


	public static void updateFile(String veri) {


		File file = new File("C:\\Medipol/H5200024.txt");

		try {
			FileOutputStream dosya = new FileOutputStream(file);
			dosya.write(veri.getBytes());
			dosya.flush();
			dosya.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
