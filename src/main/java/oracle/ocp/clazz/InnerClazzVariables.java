package oracle.ocp.clazz;

public class InnerClazzVariables {
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println(x);            // 30
                System.out.println(this.x);            // 30
                System.out.println(B.this.x);     // 20
                System.out.println(InnerClazzVariables.this.x);     // 10
            }
        }
    }

    public static void main(String[] args) {
        InnerClazzVariables innerClazzVariables = new InnerClazzVariables();
        InnerClazzVariables.B b = innerClazzVariables.new B();
        InnerClazzVariables.B.C c = b.new C();
        c.allTheX();
    }
}
