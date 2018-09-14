package com.liuxuhui.groovy.closure
/**
 * @author liuxuhui
 * 闭包的使用
 * 定义：闭包，英文名叫Closure，是一种数据类型，代表了一段可执行的代码；闭包是一段代码，所以需要用花括号括起来，->这个箭头很关键，前面表示参数定义，后面表示代码
 * （注：当然没有参数的时候，可以不用箭头->）
 * 定义格式如下：
 * def xxx = {parameters -> code} 或者
 * def xxx = {code}   //无参数，纯code时，不需要->符合
 */
def aClosure = {
    String name, int age ->
        println("My name is " + name + ",I'm " + age + " years")
}
aClosure.call("李雷", 12)
aClosure("韩梅梅", 11)