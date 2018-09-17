package com.liuxuhui.groovy.script
/**
 * 脚本类：和Java类似，如果类、变量和函数没有声明public/private等访问权限，默认是public
 * 脚本：Groovy可以像写脚本一样，把要做的事情写在xxx.groovy文件中，可以通过groovy xxx.groovy执行这个脚本。
 * @author liuxuhui
 * @date 2018.9.17
 */
class TestModel {
    def name
    def age

    TestModel(name, age) {
        this.name = name
        this.age = age
    }

    def print() {
        println("My name is " + name + " ，i am " + age + " years。")
    }
}