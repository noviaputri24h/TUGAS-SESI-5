import java.util.ArrayList;
import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        String[][] buah = {
        {"apel","35000"},// 0
        {"jeruk","50000"},// 1
        {"mangga","25000"},// 2
        {"duku","15000"},// 3
        {"semangka","20000"}// 4
        };
        ArrayList<String[]> keranjang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        boolean belilagi = true;

        do{
            System.out.println("Menu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukan pilihan:");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.print("Pilih buah (0-4):");
                int indexBuah = scanner.nextInt();

               if (indexBuah >= 0 && indexBuah < buah.length){
                  System.out.print("Masukan jumlah :");
                  int jumlah = scanner.nextInt();
                  int harga = Integer.parseInt(buah[indexBuah][1]);
                  int subtotal = harga * jumlah;

                  keranjang.add(new String[]{
                  buah [indexBuah][0],
                  String.valueOf(jumlah),
                  String.valueOf(harga),
                  String.valueOf(subtotal)
               });
               System.out.print("input lagi ya? (y/n):");
               char lanjut = scanner.next().charAt(0);
               if (lanjut == 'n'|| lanjut == 'N'){
                belilagi = false;
                }
               }else {

                System.out.println("Buah tidak valid!");
            }
    
        } else if (pilihan == 2) {
            tampilkanStruk(keranjang);
    
        }
    
    } while (pilihan !=3 && belilagi);
    
    scanner.close();
    System.out.println("Terima kasih sudah berbelanja!");
    
     } 
     
     private static void tampilkanStruk(ArrayList<String[]> keranjang) {
        System.out.println("Daftar Belanja:");
        System.out.println("================================");
        System.out.printf("%-3s %-10s %-7s %-10s %-10s\n", "No.", "Nama Buah", "Jumlah", "Harga", "subtotal");
        
        int total = 0;
        for (int i=0; i<keranjang.size(); i++){
            String[] item = keranjang.get(i);
            int subtotal = Integer.parseInt(item[3]);
            total += subtotal;
    
            System.out.printf("%-3d %-10s %-7s %-10s %-10s\n", item[0], item [1], item[2], item[3]);
         }
         int discount = (int) (total * 0.15);
         int totalBayar = total - discount;
    
         System.out.println("================================");
         System.out.println("Total:" +total );
         System.out.println("Discount(15%):" + discount);
         System.out.println("Total Bayar:" + totalBayar);
    
      }
    
    }
    
        
    

