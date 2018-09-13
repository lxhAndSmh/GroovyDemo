# Groovy

## Groovy的基本语法  
- Groovy的注释标记和Java一样，支持//或者/**/  
- Groovy语句可以不用分号结尾  
- Groovy支持动态类型，即定义变量、函数或函数传参的时候可以不指定其类型；在Groovy中，变量和方法的定义可以使用关键字def（注：定义变量时，def不是必须的，但是为了代码的清晰，还是建议使用关键字def；定义函数时，无类型的函数定义，必须使用def关键字，如果指定了函数的返回类型，则可以不添加def关键字）  
> def x = 1   //可以不适用分号结尾    
def y = "hello" 
def int z = 2  //也可以直接指定变量的类型  
def test（arg1, arg2）{  //可以不指定参数类型和返回值类型（注：无类型的函数定义，必须使用def关键字）
  last_line  //函数返回值：Groovy的函数里，可以不适用return来设置函数的返回值。如果不使用return语句的话，则函数里的最后一行代码的执行结果会被设置成本函数的返回值
}     
//如果指定了函数的返回类型，则可以不添加def关键字（注：同Java一样，如果指定了返回值的类型，函数中则必须返回正确的数据类型，否则运行时会报错）   
String getName（）{  
  returen "Tom"  
}  
- Groovy对字符串的支持  
> 单引号''中的内容严格对应Java中的String，不对$符号进行转义  
println 'I am $ dollar'  //则输出I am $ dollar     
双引号""的内容则和脚本语言的处理有点像，如果字符中有$号，则它会用$表达式先求值  
def x = 1  
println  "I am $ dollar"   //则输出I am 1 dollar     
三个引号'''xxx'''中的字符串支持随意换行  
def x = '''beign  
    Line 1  
    Line 2  
    End '''  
- Groovy中函数调用的时候可以不加括号。
> 比如：println("hello")  等同于 println "hello"  
注：除了Groovy API或者Gradle API中比较常用的函数，如println，建议还是带括号。（因为代码清晰，同时还不易出错，如果函数getName()不带括号，Groovy可能会误认为getName是一个变量）     
- 关键字assert：翻译为断言，用于测试时判断假设的数据是否正确。  
> 例如：定义x值为1，测试x是否等于2  
def x = 1
assert x == 2   
运行结果返回：  
![图片描述](http://m.qpic.cn/psb?/V111UDVL31oS4Y/sto5KWIBri0Jsn40**vJuVaK5N*jdJd1jdDLA.UhC18!/b/dFMBAAAAAAAA&bo=8ABhAAAAAAADB7M!&rf=viewer_4)

## 基本数据类型  
作为动态语言，Groovy中的所有事物都是对象，所以int、boolean这些Java中的基本数据类型，在Groovy中对应的是它们的包装数据类型Integer、Boolean等。   
## 容器类   
Groovy的容器类只有三种：  
- List：链表，其底层对应Java中的List接口，一般用ArrayList作为真正的实现类  
- Map：键-值表，其底层对应Java中的LinkedHashMap。   
- Range：范围，它是List的一种拓展
