package com.liuxuhui.groovy.closure
/**
 * @author liuxuhui
 * 闭包的使用
 * 定义：闭包，英文名叫Closure，是一种数据类型，代表了一段可执行的代码；闭包是一段代码，所以需要用花括号括起来，->这个箭头很关键，前面表示参数定义，后面表示代码
 * （注：没有定义参数的时候，可以不用箭头->。此时，如果没有使用->,则闭包隐含一个参数it，和this的作用类型；如果使用->,则表示该闭包没有参数，给该闭包传参时，会报错）
 * 定义格式如下：
 * def xxx = {parameters -> code} 或者
 * def xxx = {code}   //无参数，纯code时，不需要->符合
 * 省略圆括号：在Groovy中，很多类都定义了一些函数，这些函数最后一个参数都是闭包，调用该函数时，可以省略圆括号
 */

/**
 * 定义：
 */
def aClosure = {
    String name, int age ->
        println("aClosure：My name is " + name + ",I'm " + age + " years")
}
/**
 * 闭包的调用
 */
aClosure.call("李雷", 12)
aClosure("韩梅梅", 11)

/**
 * 如果没有使用->,则闭包隐含一个参数it，和this的作用类型
 */
def bClosure = {
    println("bClosure：My name is $it")
}
//等同于：
def cClosure = {it ->
    println("cClosure：My name is $it")
}
bClosure.call("小明")
cClosure.call("小红")
/**
 * 没有定义参数时，且使用->，表示该闭包没有参数，不能给该闭包传参
 */
def dClosure = { ->
    println("dClosure：Hello")
}
dClosure.call()

/**
 * 省略圆括号:
 * public static <T> List<T>each(List<T> self, Closure closure)
 * 此函数表示针对List的每一个元素都会调用closure做一些处理；在使用这个each函数的时候，我们传递一个怎样的Closure进去呢？如下：
 *
 * 注意：这个特点非常关键，因为在以后的Gradle中经常会出现如下的代码：
 * task hello {
 *     doLast {
 *         println "hello"
 *     }
 * }
 *
 * 完整的代码应该是这样的：
 * task hello {
 *     doLast（{
 *         println "hello"
 *     }）
 * }
 *
 * 如何确定Closure的参数：
 * 对于List的each函数所需要的Closure,它的参数是什么？有多少个参数，返回值是什么？
 * 所以，Closure虽然方便，但是它一定会和使用它的上下文有极强的关联；要不，类似回调这样的东西，我们无从知道调用者需要传递什么参数给Closure。
 * 如何解决？只能通过查询API文档了解上下文语义。
 * 例如：对Map的findAll而言，Closure可以有两个参数，findAll会将Key和Value分别传进去，如果Closure返回true，表示该元素是自己想要的，返回
 * false表示该元素不是自己要找的。
 */
def aList = [1,2,3,4,5,"吉米",true]
aList.each{ //调用each的圆括号不见了，原来，Groovy中，当函数的最后一个参数是闭包的话，可以省略圆括号
    print(it)
}
println()
//等同于：
aList.each({
    print(it)
})
println()
//例2:
def testClosure(String name, int age, Closure closure) {
    println("testClosure：My name is " + name + ",I'm " + age + " years")
    closure.call()
}
//省略圆括号时，感觉println("I am in closure")立即会被调用一样，更简洁直接
testClosure("舒淇", 18, {println("I am in closure")})
//等同于：带括号时，会感觉只是把Closure对象传了进去，至于带对象有没有被调用就不知道了
testClosure("舒淇", 18, ({println("I am in closure")}))