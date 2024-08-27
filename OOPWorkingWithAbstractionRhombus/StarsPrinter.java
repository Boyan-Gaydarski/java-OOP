package OOPWorkingWithAbstractionRhombus;

public class StarsPrinter {

    private int size;

    public StarsPrinter(int size) {
        this.size = size;
    }
    private void printTop() {
        for (int i = 1; i <= size; i++) {
            printStringNumberOfTimes(size - i, " ");
            printStringNumberOfTimes(i, "* ");
            System.out.println();
        }
    }

    private void printBottom() {
        int rowsCount = size - 1;
        for (int i = 1; i <= rowsCount; i++) {
            printStringNumberOfTimes(i, " ");
            printStringNumberOfTimes(rowsCount - (i - 1), "* ");
            System.out.println();
        }
    }

    private void printStringNumberOfTimes(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.print(str);
        }
    }

    public void printEntireFigure() {
        printTop();
        printBottom();
    }
}
