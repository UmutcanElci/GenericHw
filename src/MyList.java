public class MyList<T> {
    //List oluşturma List<T> list = new ArrayList<T>();
    //Dizi boyutu
    int dimension;
    //Dizi
    T arr[];
    //Eğer değişiklik olursa kullanılacak dizi
    T tempArr[];
    //Dizinin asıl boyutu
    int actualDimension = 0;

    public void setArr() {
        this.arr = (T[]) new Object[this.dimension];
    }

    public void increasedArr(){
        this.tempArr = (T[]) new Object[this.dimension];
        for (int i = 0 ; i<actualDimension;i++){
            this.tempArr[i] = this.arr[i];
        }
        //Biz verileri sadece başka bir diziye atıp artırıp geri çekiyoruz
        this.arr = this.tempArr;
    }

    public MyList(int dimension) {
        this.dimension = dimension;
        this.setArr();
    }
    public MyList(){
        this.dimension = 10;
        this.setArr();
    }

    public int getActualDimension() {
        return actualDimension;
    }

    public int getDimension() {
        return dimension;
    }
    public int size(){
        int count =0;
        for (int i = 0; i<this.dimension;i++){
            if (arr[i] != null){
                count++;
            }
            this.actualDimension = count;
        }
        return count;
    }

    public void add(T data){
        if (this.actualDimension<this.dimension){
            arr[actualDimension] =data;
            this.size();
        }else {
            this.dimension = this.dimension*2;
            this.increasedArr();
            this.add(data);
        }
    }

    public T get(int index){
        T x = this.arr[index];
        return x;
    }

    public void remove(int index){

    }
    public void moveRemovedArr(int index){
        T[] arrHold = this.arr;
        this.arr[index] = null;

        for (int i = 0; i<arrHold.length-1;i++){
            if (index == 0){
                this.arr[i] = arrHold[i+1];
            }else if(index != 0 && i<index){
                this.arr[i] = arrHold[i];
            }else  if(index != 0 && i>index){
                this.arr[i] = arrHold[i+1];
            }
        }
    }

    public void set(int index, T data){
        this.arr[index] = data;
    }

    @Override
    public String toString(){
        for (T i:arr){
            if (i != null){
                System.out.println(i+ " ");
            }
        }
        return "";
    }


    public int indexOf(T data){
        for (int i = 0 ; i<this.arr.length;i++){
            if (data == this.arr[i]){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int lastIndex =0;
        for (int i = 0; i<this.arr.length; i++){
            if (data == this.arr[i]){
                lastIndex = i;

            }

        }
        return lastIndex;
    }

    public boolean isEmpty(){
        if (this.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean contains(T data){
        for (int i = 0; i<this.arr.length; i++){
            if (data == arr[i]){
                return true;
            }
        }
        return false;
    }

}
