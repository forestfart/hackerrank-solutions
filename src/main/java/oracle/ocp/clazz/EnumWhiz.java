package oracle.ocp.clazz;

enum EnumWhiz {
    LOSS(0),
    WIN(2),
    TIE(1);

    private int i;

    EnumWhiz(int i) {
        this.i = i;
    }

    public int getPoints(int x) {
        return i;
    }

    public static void main(String[] args) {
        System.out.println(EnumWhiz.LOSS.ordinal());
        System.out.println(EnumWhiz.WIN.ordinal());
        System.out.println(EnumWhiz.TIE.ordinal());
    }

}
