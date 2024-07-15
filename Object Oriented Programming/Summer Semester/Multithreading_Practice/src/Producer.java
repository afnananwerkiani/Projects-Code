import java.awt.image.DataBuffer;

public class Producer implements DataBuffer {
    private int[] array;
    private DataBuffer dataBuffer;
    private int Cube;
    private int Square;
    private int Number;

    @Override
    public int getElem(int number) {
        return number;
    }

    @Override
    public int getElem(int bank, int i) {
        return 0;
    }

    @Override
    public void setElem(int Cube, int Square, int number) {
        this.Cube = Cube;
        this.Square = Square;
        this.Number = Number;
    }
}
