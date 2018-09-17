package com.liuxuhui.groovy
//如果该脚本和被导入的类在同一个包中，不需要import导入
import com.liuxuhui.groovy.script.TestModel

println "hello groovy"
def x = 1
println "I have $x dollar"

/**
 * 脚本中import其它类。（如果该脚本和被导入的类在同一个包中，不需要import导入）
 *
 * 脚本类和脚本的区别：
 * 脚本类：和Java类似，如果类、变量和函数没有声明public/private等访问权限，默认是public
 * 脚本：Groovy可以像写脚本一样，把要做的事情写在xxx.groovy文件中，可以通过groovy xxx.groovy执行这个脚本。
 * 本文件HelloGroovy.groovy即为脚本，TestModel.groovy为脚本类
 *
 * 调用TestModel类的函数。
 */
TestModel testModel = new TestModel("李白", 28);
testModel.print()