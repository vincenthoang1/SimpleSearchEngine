class Holder {
    private Object value;

    public void set(Object value) {
        this.value = value;
    }

    public Object get() {
        return value;
    }
}

class Main {
    public static void main(String... args) {
        final int x = 256;
        Holder holder = new Holder();
        holder.set(x);

        // correct the line to make the code compile
        Integer value = (Integer) holder.get();

        // do not change
        System.out.println(value);
    }
}