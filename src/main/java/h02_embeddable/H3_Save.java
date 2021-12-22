package h02_embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class H3_Save {

	public static void main(String[] args) {
		
		//Tabloya eklenecek verileri(record, kayit) olustrumamzi gerekiyor.
		        H2_Dersler ders1= new H2_Dersler("MUZIK","MAT");
		        H2_Dersler ders2 = new H2_Dersler("BEDEN","FEN");
		        
				H1_Ogrenci ogrenci1 = new H1_Ogrenci(101, "Ahmet  Balta", 100,ders1);
				H1_Ogrenci ogrenci2 = new H1_Ogrenci(102, "Ahmet Kan", 90,ders2);
				
				//Veri tabani baglanti ayarlarini hibernate gostermeliyiz.
				Configuration con = new Configuration().
						configure("hibernate.cfg.xml").
						addAnnotatedClass(H1_Ogrenci.class);
				
				
				//con objesinden bir oturum grubu olusturudk
				SessionFactory sf = con.buildSessionFactory();
				
				//Oturum grubundan bir oturum grubu baslattik.
				Session session = sf.openSession();
				
				//Acilan session icerisnde islemlere baslayabilmek icin Transaction aciyoruz.
				Transaction tx = session.beginTransaction();
				
				//Veritabanina kayitlarin eklenmsei
				session.save(ogrenci1);
				session.save(ogrenci2);
				
				//Ilsemlerin veritabanina aktarilmasi
				tx.commit();
				
				//Oturumlarin kapatilmasi
				sf.close();
				session.close();
				
				
						}	

}
