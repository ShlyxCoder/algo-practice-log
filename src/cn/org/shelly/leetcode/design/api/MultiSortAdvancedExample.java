package cn.org.shelly.leetcode.design.api;

import java.util.*;

public class MultiSortAdvancedExample {

    static class Person implements Comparable<Person> {
        private String name;
        private int age;
        private double salary;

        public Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return String.format("%s(age=%d,salary=%.2f)", name, age, salary);
        }

        /**
         * 自然排序：默认按 age 升序
         * 面试可说明：这里也可以改成按姓名或工资等其他字段
         */
        @Override
        public int compareTo(Person o) {
            // 多种比较方法展示：
            // 1️⃣ 不安全：直接减法（可能溢出）
            // return this.age - o.age;

            // 2️⃣ 安全：Integer.compare
            return Integer.compare(this.age, o.age);

            // 3️⃣ Double.compare（适用于 double 字段）
            // return Double.compare(this.salary, o.salary);

            // 4️⃣ String.compareTo（按字典序比较字符串）
            // return this.name.compareTo(o.name);

            // 5️⃣ 安全 null 比较（避免 NullPointerException）
            // return Comparator.nullsFirst(String::compareTo).compare(this.name, o.name);
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
            new Person("Alice", 30, 5000),
            new Person("Bob", 25, 7000),
            new Person("Charlie", 30, 6000),
            new Person("David", 25, 5500)
        ));

        System.out.println("原始列表:");
        people.forEach(System.out::println);

        // 1️⃣ 自然排序（Comparable）
        List<Person> byNatural = new ArrayList<>(people);
        Collections.sort(byNatural);
        System.out.println("\n自然排序（按年龄升序，安全 Integer.compare）:");
        byNatural.forEach(System.out::println);

        // 2️⃣ Comparator 按姓名排序（支持 null 安全）
        List<Person> byName = new ArrayList<>(people);
        byName.sort(Comparator.nullsFirst(Comparator.comparing(Person::getName)));
        System.out.println("\n按姓名排序（null 安全）:");
        byName.forEach(System.out::println);

        // 3️⃣ Lambda 临时排序：按工资降序
        List<Person> bySalaryDesc = new ArrayList<>(people);
        bySalaryDesc.sort((p1, p2) -> Double.compare(p2.getSalary(), p1.getSalary()));
        System.out.println("\n按工资降序排序:");
        bySalaryDesc.forEach(System.out::println);

        // 4️⃣ 链式排序：年龄升序 -> 工资降序 -> 姓名升序
        List<Person> chainSort = new ArrayList<>(people);
        chainSort.sort(
            Comparator.comparing(Person::getAge)
                      .thenComparing(Comparator.comparing(Person::getSalary).reversed())
                      .thenComparing(Comparator.nullsFirst(Comparator.comparing(Person::getName)))
        );
        System.out.println("\n链式排序（年龄升序+工资降序+姓名升序，null 安全）:");
        chainSort.forEach(System.out::println);

        // 5️⃣ TreeSet 使用 Comparator 自动排序和去重
        TreeSet<Person> treeSet = new TreeSet<>(
            Comparator.comparing(Person::getAge)
                      .thenComparing(Comparator.comparing(Person::getSalary).reversed())
                      .thenComparing(Comparator.nullsFirst(Comparator.comparing(Person::getName)))
        );
        treeSet.addAll(people);
        System.out.println("\nTreeSet 排序（自动排序+去重）:");
        treeSet.forEach(System.out::println);
    }
}
