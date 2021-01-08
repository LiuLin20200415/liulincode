import java.util.Arrays;

public class Test {
        private int[] elem;
        private int usedSize;

        public Test() {
            this.elem = new int[10];
        }

        public Test(int capacity) {
            this.elem = new int[capacity];
        }

        public void display() {
            for (int i = 0; i < this.usedSize; i++) {
                System.out.println(elem[i] + " ");
            }
            System.out.println();
        }

        public boolean full() {
            if (this.usedSize == this.elem.length) {
                return true;
            }
            return false;
        }

        public void resize() {
            this.elem = Arrays .copyOf(this.elem, 2 * this.elem.length);
        }

        public void add(int pos, int data) {
            if (full()) {
                System.out.println("顺序表满了！");
            }
            if (pos < 0 || pos > this.usedSize) {
                System.out.println("输入位置不合法！");
            }
            for (int i = this.usedSize - 1; i >= pos; i--) {
                elem[i + 1] = elem[i];
            }
            elem[pos] = data;
            this.usedSize++;
        }

        public int contains(int sign) {
            for (int i = 0; i < this.usedSize; i++) {
                if (elem[i] == sign) {
                    System.out.println("有");
                    return 1;
                }
            }
            System.out.println("没有");
            return -1;
        }

        public int search(int sign) {
            for (int i = 0; i < this.usedSize; i++) {
                if (elem[i] == sign) {
                    System.out.println("有");
                    return i;
                }
            }
            System.out.println("没有");
            return -1;
        }

        public int getPos(int pos) {
            if (pos < 0 || pos > this.usedSize) {
                System.out.println("输入位置不合法！");
            }
            return elem[pos];
        }

        public void setPos(int pos, int value) {
            if (pos < 0 || pos > this.usedSize) {
                System.out.println("输入位置不合法！");
            }
            elem[pos] = value;
        }

        public void delect(int key) {
            int index = -1;
            for (int i = 0; i < this.usedSize; i++) {
                if (elem[i] == key) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("没有找到！");
            }
            for (int i = index; i < this.usedSize; i++) {
                elem[i] = elem[i + 1];
            }
            this.usedSize--;
        }

        public int size() {
            return this.usedSize;
        }

        public void clear() {
            this.usedSize = 0;
        }
    }
public class TestDome {
        public static void main(String[] args) {
            Test myArrayList = new Test();
            myArrayList.add(0, 1);
            myArrayList.add(1, 1);
            myArrayList.add(2, 1);
            myArrayList.add(3, 1);
            myArrayList.add(4, 1);
            myArrayList.add(5, 1);
            myArrayList.add(6, 1);
            myArrayList.add(7, 1);
            myArrayList.add(8, 1);
            myArrayList.add(9, 1);
            myArrayList.display();
        }
    }

