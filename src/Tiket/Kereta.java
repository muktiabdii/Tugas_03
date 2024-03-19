package Tiket;

public class Kereta {
    private String namaKereta;
    private int tiketSisa;    
    private Ticket tiket;


    // Constructor kereta komuter
    public Kereta(){
        this.namaKereta = "komuter";
        this.tiketSisa = 1000;
        this.tiket = new Ticket();
    }


    // Constructor kereta KAJJ
    public Kereta(String namaKereta, int tiketSisa){
        this.namaKereta = namaKereta;
        this.tiketSisa = tiketSisa;
        this.tiket = new Ticket(namaKereta, tiketSisa);
    }


    // Method untuk menambah pesanan tiket 
    // Khusus kereta komuter
    public void tambahTiket(String namaPenumpang){
       String[] nama = new String[tiket.getNamaPenumpang().length + 1];     // Index array ditambah 1 setiap method dipanggil
       System.arraycopy(tiket.getNamaPenumpang(), 0, nama, 0, tiket.getNamaPenumpang().length);     // Untuk mengcopy index array sebelumnya ke array saat ini
       nama[tiket.getNamaPenumpang().length] = namaPenumpang;
       tiket.setNamaPenumpang(nama);

       // Output bahwa tiket berhasil dipesan
       System.out.println("==================================================");
       System.out.println("Tiket berhasil dipesan");     
    }


    // Method untuk menambah pesanan tiket
    // Khusus kereta KAJJ
    public void tambahTiket(String namaPenumpang, String a, String t){
        if(tiket.getNamaPenumpang().length < tiketSisa){
            String[] nama = new String[tiket.getNamaPenumpang().length + 1];    //
            String[] asal = new String[tiket.getAsal().length + 1];             // Index array nama, asal, tujuan ditambah 1 setiap method dipanggil
            String[] tujuan = new String[tiket.getTujuan().length + 1];         // 

            System.arraycopy(tiket.getNamaPenumpang(), 0, nama, 0, tiket.getNamaPenumpang().length);       // Untuk mengcopy index array sebelumnya
            System.arraycopy(tiket.getAsal(), 0, asal, 0, tiket.getAsal().length);                         // ke array saat ini
            System.arraycopy(tiket.getTujuan(), 0, tujuan, 0, tiket.getTujuan().length);                   // 

            nama[tiket.getNamaPenumpang().length] = namaPenumpang;
            asal[tiket.getAsal().length] = a;
            tujuan[tiket.getTujuan().length] = t;

            tiket.setNamaPenumpang(nama);
            tiket.setAsal(asal);
            tiket.setTujuan(tujuan);

            // Output bahwa tiket berhasil dipesan
            if(tiket.getNamaPenumpang().length < 30){
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + (tiketSisa - tiket.getNamaPenumpang().length));
            }      
            
        // Output bahwa tiket gagal dipesan karena sudah habis
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya"); 
        }       
    }


    // Method untuk menampilkan daftar penumpang 
    public void tampilkanTiket(){
        System.out.println("==================================================");
        System.out.println("Daftar penumpang kereta api " + this.namaKereta + ": ");
        System.out.println("----------------------------");

        for(int i = 0; i < tiket.getNamaPenumpang().length; i++){
            if(this.namaKereta.equals("komuter")){
                System.out.println("Nama: " + this.tiket.getNamaPenumpang()[i]);
                
            } else {
                System.out.println("Nama: " + this.tiket.getNamaPenumpang()[i]);
                System.out.println("Asal: " + this.tiket.getAsal()[i]);
                System.out.println("Tujuan: " + this.tiket.getTujuan()[i]);
                System.out.println("----------------------------");
            }
        }
    }
    
}