package cn.org.shelly.leetcode.design.grammar;// JDK 21：record 解构（结构化模式匹配）示例

record User(String name, int age) {}

public class Demo {
    public static void main(String[] args) {
        Object obj = new User("Tom", 18);

        // 解构：类型判断 + 字段拆解 一步完成
        if (obj instanceof User(String name, int age)) {
            System.out.println(name); // Tom
            System.out.println(age);  // 18
        }
    }
}