
/**
 * Kelas Tree untuk menyimpan pohon dari kelas simpul
 * @author tisha
 */
public class Tree {

    private Node root; //simpul aakar
    private int numNode; //jumlah simpul di dalam pohon

    /**
     * Konstruktor
     */
    public Tree() {
        root = new Node();
        numNode = 0;
    }

    /**
     * Menambah simpul ke dalam pohon sebagai simpul anak dari simpul parentName
     * @param parentName nama simpul orangtua dari simpul anak yang akan ditambah
     * @param name nama berkas/file untuk simpul anak yang akan ditambah
     * @param diskSize ukuran berkas/file untuk simpul anak yang akan ditambah
     * @return 
     */
    public boolean addNode(String parentName, String name, int diskSize) {
        
        if (numNode == 0) {
            //node pertama, akan jadi root
            this.root.setName(name);
            numNode++;
            return true;
      
        } else {
            //Cari simpul orangtua dari simpul yang akan ditambah
            Node parent = root.findChildNode(parentName);
            if (parent != null) {
                //Ketemu node orang tua
                numNode++;
                //Buat node nya
                Node newNode = new Node(name, diskSize);
                return parent.addChilNode(newNode);
                
            } else { //Simpul orangtua tidak ditemukan
                return false;
                
            }
        }
    }

    /**
     * Getter untuk jumlah simpul
     * @return 
     */
    public int getNumNode() {
        return numNode;
    }
    
    /**
     * Menghitung jumlah bytes dari semua folder/berkas di pohon ini
     * @return 
     */
    public int calculateSize(){
       //Implementasikan method ini
       return 0;
    }
}
