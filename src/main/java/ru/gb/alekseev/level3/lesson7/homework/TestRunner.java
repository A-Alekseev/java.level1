package ru.gb.alekseev.level3.lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {
    public static void main(String[] args) {
        try {
            start(CalculatorTest.class);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

    }

    public static void start(String testerClassName) throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        start(Class.forName(testerClassName));
    }

    public static void start(Class testerClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Method beforeSuitMethod = FindSingleAnnotatedMethod(testerClass, BeforeSuit.class);
        Method afterSuitMethod = FindSingleAnnotatedMethod(testerClass, AfterSuit.class);

        Object testerInstance = testerClass.getConstructor().newInstance();
        if(testerInstance == null)
            throw new RuntimeException("Can't create object " + testerClass.getName());

        if (beforeSuitMethod != null){
            beforeSuitMethod.invoke(testerInstance);
        }

        List<Method> testMethods = new ArrayList<Method>(Arrays.stream(testerClass.getMethods())
            .filter(method -> method.getAnnotation(Test.class) != null)
            .toList());

        Collections.sort(testMethods, (m1, m2) -> Integer.compare(
                m1.getAnnotation(Test.class).value(),
                m2.getAnnotation(Test.class).value()));

        for (Method method : testMethods) {
            System.out.print("Executing test " + method.getName() + " ... ");
            try {
                method.invoke(testerInstance);
                System.out.println("OK");
            }
            catch (Exception exception){
                System.out.println("Error");
                System.out.println(exception);
            }
        }

        if (afterSuitMethod != null){
            afterSuitMethod.invoke(testerInstance);
        }
    }

    private static Method FindSingleAnnotatedMethod(Class testerClass, Class annotationClass) {
        List<Method> methods = Arrays.stream(testerClass.getMethods())
                .filter(method -> method.getAnnotation(annotationClass) != null)
                .toList();

        if (methods.size() < 1)
            return null;

        if (methods.size() > 1)
            throw new RuntimeException("Class " + testerClass.getName() + " must contain only one method annotated " + annotationClass.getName());

        return methods.get(0);
    }
}
