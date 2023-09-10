

public interface Stack<T> {
    /**
     * Memeriksa ukuran Stack saat ini
     * @return ukuran Stack
     */
    int size();  
    
    /**
     * Memeriksa apakah stack kosong atau tidak
     * @return true apabila kosong
     */
    boolean isEmpty();
    
    /**
     * Memasukkan item ke Stack
     * @param item item yang dimasukkan
     */
    void push(T item);
    
    /**
     * Melihat item paling atas di stack
     * @return item paling atas di stack
     */
    T top();
    
    /**
     * Mengeluarkan item paling atas di stack 
     * @return item paling atas di stack
     */
    T pop();
}
