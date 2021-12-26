package h05_crudProje;

public class Main {

	public static void main(String[] args) {
		
		//Crud islmeleri icin gerekli olan classdan nesnenin turetilmesi
		CrudMetotlar metot = new CrudMetotlar();
		
		//Tum crud islemelri session factory metodu olusturan metodu calistir.
		metot.sessionFactoryOlustur();
		
		//Veri tabanina yeni personller ekel 
//		metot.personelEkle("Ahmet", "Yilmaz", 5500);
//		metot.personelEkle("Mustafa", "Baki", 7200);
//		metot.personelEkle("Can", "Ali", 4450);
		
		
		metot.idIlePersonelSil(2L);
		metot.idIlePersonelSil(3L);
		
		metot.tumPersoneliListele();
		metot.idIlePersonelListele(2L);
		metot.idIleMaasGuncelle(1L, 7500);
		metot.tumPersoneliListele();
		
	}

}
