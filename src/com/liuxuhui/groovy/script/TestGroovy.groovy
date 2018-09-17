package com.liuxuhui.groovy.script

/**
 * 脚本到底是什么？
 * Java中，我们最熟悉的是类，要做的事情必须写到类里；而Groovy可以像写脚本一样，把要做的事情写在xxx.groovy中，
 * 通过groovy xxx.groovy直接执行这个脚本，这是什么原因呢？众所周知Groovy是基于Java的，原来Groovy会先把xxx.groovy中的内容转换成一个Java类。
 * 比如：要把此TestGroovy.groovy转换成Java类：
 * 命令行进入所在包的目录下，执行 groovyc -d classes TestGroovy.groovy
 * groovyc是Groovy的编译命令，-d classes用于将编译得到的class文件拷贝到classes文件夹下。
 * 由TestGroovy.class文件可以看出：
 * 1.TestGroovy.groovy被转换成了一个TestGroovy类，它从script派生
 * 2.每一个脚本都会生成一个 static void main函数；当我们执行groovy TestGroovy.groovy的时候，其实就是用Java去执行这个main函数
 * 3.脚本中所有的代码都会放到run函数中。
 * 4.如果脚本中定义了函数，则函数会被定义在TestGroovy类中。
 *
 *
 * 脚本的变量作用域：
 * 函数printy被定义成TestGroovy类的成员函数，而def z = 2,是在run中创建的；所以从代码上看好像是在整个脚本中定义的，但实际上函数printy反问不了z。
 * 那么如何才能反问定义的变量呢，添加注解 @groovy.transform.Field，这样就可以彻底的是test的成员变量了。
 */
@groovy.transform.Field
def y = 1
def z = 2
def printy() {
    println("y===" + y)
}
printy()