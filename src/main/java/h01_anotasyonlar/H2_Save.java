package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H2_Save {

	public static void main(String[] args) {
		
		//Tabloya eklenecek verileri(record, kayit) olustrumamzi gerekiyor.
		
		H1_Ogrenci ogrenci1 = new H1_Ogrenci(101, "Canan Can", 99);
		H1_Ogrenci ogrenci2 = new H1_Ogrenci(102, "Ahmet Yilmaz", 90);
		
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
