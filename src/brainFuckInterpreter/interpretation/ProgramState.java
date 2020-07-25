package brainFuckInterpreter.interpretation;

import java.util.Scanner;

public class ProgramState {
    private final Scanner scanner = new Scanner(System.in);
    private final byte[] cells = new byte[4000];
    private int cellPointer;

    public byte valueAtCellPointer() {
        return cells[cellPointer];
    }

    public void incrementCellAtCellPointer() {
        cells[cellPointer]++;
    }

    public void decrementCellAtCellPointer() {
        cells[cellPointer]--;
    }

    public void incrementCellPointer() {
        cellPointer++;
    }

    public void decrementCellPointer() {
        cellPointer--;
    }

    public void printCurrentCell() {
        System.out.print((char) cells[cellPointer]);
    }

    public void readIntoCell() {
        cells[cellPointer] = scanner.nextByte();
    }
}
