package utils;

public class Number implements Comparable<Number> {
    public int value;
    public String valueStr;

    public Number(int value) {
        this.value = value;
        this.valueStr = Integer.toString(value);
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(Integer.parseInt(valueStr + o.valueStr), Integer.parseInt(o.valueStr + valueStr)) * -1;
    }
}
