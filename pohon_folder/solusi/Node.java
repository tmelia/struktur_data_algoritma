
/**
 * Kelas ini merepresentasikan sebuah simpul, baik berupa folder atau berkas
 * Simpul ini memiliki nama folder/berkas (name), ukuran berkas (diskSize) dan referensi ke simpul anak (children
 * Variabel pembantu yang kita gunakan adalah numChildNode yang menyimpan jumlah simpul anak yang dipunyai
 * @author tisha
 */
public class Node {
    public static final int CAPACITY=1000; //kapasitas array jumlah simpul anak
    private String name = ""; //Nama berkas/folder
    private int diskSize = 0; //Ukuran dari berkas/folder.
    private int numChildNode = 0; //jumlah simpul anak
    private Node[] children; //simpul anak
    
    /**
     * Konstruktor
     */
    public Node(){
        children = new Node[CAPACITY];
    }
    
    /**
     * Konstruktor
     * @param inputName nama file/folder
     * @param inputDiskSize ukuran berkas/folder
     */
    public Node(String inputName, int inputDiskSize){
        this.setName(inputName);
        this.setDiskSize(inputDiskSize);
        children = new Node[CAPACITY];
    }
    
    /**
     * Menambah simpul anak
     * @param child simpul anak yang akan ditambah
     * @return 
     */
    public boolean addChilNode(Node child){
        if(numChildNode < CAPACITY){
            numChildNode++;
            children[ (numChildNode-1) ] = child;            
            return true;
        }else {
            //Penuh, tidak bisa menambah simpul anak lagi
            return false;
        }
    }
    
    /**
     * Menamukan simpul anak dengan nama berkas/folder tertentu
     * @param nodeName
     * @return 
     */
    public Node findChildNode(String nodeName){
        if(nodeName.equals(this.name)){
            //Ketemu simpul yang dicari
            return this;
        }else{
            //Cek simpul anak
            for(int i = 0; i<numChildNode; i++){
                Node node = this.children[i].findChildNode(nodeName);
                if(node != null){
                    return node;
                }
            }
            return null; //Tidak ada simpul yang dicari
        }
    }

    /**
     * Getter untuk simpul anak
     * @return 
     */
    public Node[] getChildren() {
        return children;
    }
       
    /**
     * Getter untuk nama berkas/folder
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Getter untuk ukuran berkas/folder
     * @return 
     */
    public int getDiskSize() {
        return diskSize;
    }

    /**
     * Setter untuk nama berkas/folder
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter untuk ukuran berkas/folder
     * @param diskSize 
     */
    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }
    
    /**
     * Fungsi untuk menghitung ukuran simpul dan simpul-simpul anak di bawahnya
     * @return 
     */
    int calculateSize(){
        //Hitung ukuran disk simpul anak
        int size = 0;
        for(int i = 0; i<numChildNode; i++){
            size += this.children[i].calculateSize();
        }
        size += this.diskSize;
        System.out.println(this.name + ": " + size);
        return size;
    }
}
