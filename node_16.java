import java.util.Scanner;
public class node_16 {
    int nomor,no;
    String nama;

    node_16 prev, next;

    node_16(node_16 prev, int nomor, String nama, node_16 next){
        this.prev = prev;
        this.nomor = nomor;
        this.nama = nama;
        this.next = next;
    }
}
class pembeli {
    node_16 head;
    int size;

    public pembeli(){
        head = null;
        size = 1;    
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addLast(int nomor, String nama, int no){
        if (isEmpty()){
            head  = new node_16(null, nomor, nama, null);
        }else{
            node_16 current = head;
            while (current.next != null){
                current = current.next;
            }
            node_16 newNode = new node_16(current, nomor, nama,null);
            current.next = newNode;
            size++;
        }
    }
    public void removeFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("Linked List Masih kosong, tidak dapat dihapus!");
        }else if (size == 1){
            removeLast();
        }else{
            System.out.println(head.nama+"Sudah Divaksin");
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    public void removeLast() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked list masih kosong, tidak dapat dihapus!");
        }else if (head.next == null){
            System.out.println(head.nama+"Sudah Divaksin");
            head = null;
            size--;
            return;
        }
        node_16 current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }
    public void print(){
        System.out.println("+++++++++++++++++++++++++");
        System.out.println(" Daftar Antrian Resto Royal Delish ");
        System.out.println("+++++++++++++++++++++++++"); 
        System.out.println("| No\t| Nama Customer"+"\t\t| No HP\t\t");
        if(!isEmpty()){
            node_16 tmp = head;
            while (tmp != null){
                System.out.print("| "+tmp.nomor+"\t| "+tmp.nama+" "+"\t|\n");
                tmp = tmp.next;
            }
            System.out.println("\nSisa Antrian "+size);
        }else{
            System.out.println("Linked List Kosong");
        }
    }
}
class node_16Main {
    public static void menu(){
        System.out.println("MENU");
        System.out.println(" 1. Tambah Antrian\n 2. Cetak Antrian\n 3. Hapus Antrian\n 4. Laporan Pengurutan by nama\n 5. Hitung Total Pendapatan\n 6. Keluar");
        System.out.println("-----------------------------------");
    }
    public static void main(String[] args)throws Exception  {
        System.out.println("======= Quiz 2 PRAKTIKUM ASD TI - 1G dan TI - 1F =======");
        System.out.println("dibuat oleh : Muhammad Endar Darmawan");
        System.out.println("NIM         : 2141720160");
        System.out.println("Absen       : 16");
        System.out.println("========================================================");
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
        Scanner sa = new Scanner(System.in);
    
        pembeli dll = new pembeli();
    
        int pilih;
        do{
            menu();
            System.out.print("Pilih(1-5) : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch(pilih){
                case 1:
                    System.out.println("--------------------------");
                    System.out.println("Masukkan Data Pembeli");
                    System.out.println("--------------------------");
                    System.out.print("Nomor Antrian\t: ");
                    int nim = sd.nextInt();
                    System.out.print("Nama Customer\t: ");
                    String nama = sc.nextLine();
                    System.out.print("Nomor HP\t: ");
                    int no = sa.nextInt();
                    dll.addLast(nim, nama, no);
                    sc.nextLine();
                break;
            
                case 2:
                    dll.removeFirst();
                    dll.print();
                break;
            
                case 3:
                    dll.print();
                break;
                case 4:

                break;
                case 5:

                break;
                case 6:
                    System.exit(0);
                break;
            
            } 
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6);
        sc.close();
        sd.close();
        sa.close();
    }
}