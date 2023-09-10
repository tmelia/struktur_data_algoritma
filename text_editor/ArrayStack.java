#Tisha Melia
#tisha.melia[at]lecturer[dot]unri[dot]ac[dot]id
#10 September 2023
#ASD Programming projects

public class ArrayStack<T> implements Stack<T>{
    public static final int CAPACITY=1000; //kapasitas stack
    private T[] data; //Array untuk menyimpan Stack
    private int index = -1; //Indeks item paling atas
    
    public ArrayStack(){
    data = (T[]) new Object[CAPACITY]; //Constructor
    }
    
    @Override
    public int size() {
        return (index + 1);
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
        //return size() == 0;
    }

    @Override
    public void push(T item) {
        //1. Cek apakah stack penuh  ---> size()== data.length(), Kalau penuh maka "push" gagal
        if(size() == data.length){
            //stack penuh, operasi push gagal
            throw new IllegalStateException("Stack penuh");
        }else{
            //2. Data baru ditaruh di data[index + 1]
            data[index+1] = item;
            //3. Update index menunjuk ke data yang baru
            index++;
        }       
    }

    @Override
    public T top() {
        //Periksa apakah kosong, kalau kosong maka kembalikan null
        if(isEmpty()){
            return null;//stack kosong
        }else {
            //Kalau tidak kosong, kembalikan item teratas
            return data[index];
        }      
    }

    @Override
    public T pop() {
        //1. Perika apakah stack kosong, terjadi error
        if(isEmpty()){
            throw new IllegalStateException("Stack kosong");
        }else{
            T itemToBeReturned = data[index];
            data[index] = null;
            index--;
            return itemToBeReturned;
        }
    }
    
    public void clear(){
        while(!this.isEmpty()){
            this.pop();
        }
    }
}