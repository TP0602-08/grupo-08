package ar.fiuba.tdd.tp1.serialization.json;

public class MoveJson {
    private int number;
    private int[] position = new int[] {-1, -1};
    private String value;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(int[] position) {
        if (position.length == 2) {
            this.position[0] = position[0];
            this.position[1] = position[1];
        }
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumber() {
        return this.number;
    }

    public int[] getPosition() {
        if (this.position.length == 2) {
            return new int[]{this.position[0], this.position[1]};
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
