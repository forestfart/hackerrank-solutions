package others.reflection;

public class ReflectionFun {
    
    public Integer sum(Integer a, Integer b) {
        return a+b;
    }

    public static void main(String... args) {
        try {
            Class clazz = Class.forName(args[0]);
            Arrays.stream(clazz.getDeclaredMethods()).forEach(System.out::println);

            Class partypes[] = new Class[2];
            partypes[0] = Integer.class;
            partypes[1] = Integer.class;

            Method method = clazz.getMethod("sum", partypes);
            System.out.println(method);

            Object[] argList = new Object[2];
            argList[0] = new Integer(1);
            argList[1] = new Integer(2);
            System.out.println("Result: " + method.invoke(new ReflectionFun(null, null, null, 0), argList));

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
}
