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
> 变量定义：List变量有[]定义，其元素可以是任何对象   
  变量存取：可以直接通过索引进行存取，不用担心越界；如果索引越界，List会自己给索引添加元素。  
  注：assert关键字，翻译为断言，用于测试时判断假设的数据是否正确）     
  ```
  def aList = [1, "李雷", false]
  println("aList=" + aList.toString())
  assert aList[6] == null
  aList[10] = 10 //设置第11个元素为10，其它未赋值的索引自动填充null值
  println("aList.size=" + aList.size())
  println("aList=" + aList.toString())  
  
  运行结果：
  aList=[1, 李雷, false]
  aList.size=11
  aList=[1, 李雷, false, null, null, null, null, null, null, null, 10]
```
- Map：键-值表，其底层对应Java中的LinkedHashMap。  
> 变量定义：Map变量由[:]定义，冒号的左边是Key，右边是Value；key必须是字符串，Value可以是任何对象。Key可以用''或""包起来，也可以不用引号包起来。（为了代码的清晰，个人建议用引号）  
  变量存取：存值：aMap.newKey = "新元素"     取值：aMap.keyName 
  ```
  def aMap = ["key1":1, key2:"韩梅梅"] //key不用引号包括的时候，会被默认处理成字符串"key2"
  println("aMap:" + aMap.toString())
  println("取值：" + aMap.key1)
  aMap.key3 = false
  println("存值：" + aMap.toString())
  //如果Key不适用引号包起来，也会带来一点混淆，当Key和一个变量命名一致时，Key会是哪个？如下：
  def key1 = "who"
  def bMap = [key1:"Key是key1还是who？"]
  def cMap = [(key1):"Key是key1还是who？"] //当Key想用一个变量的值时，需用（）包括
  println("bMap:" + bMap.toString())
  println("cMap:" + cMap.toString())
  
  输出结果：
  cMap:[key1:1, key2:韩梅梅]
  取值：1
  存值：[key1:1, key2:韩梅梅, key3:false]
  bMap:[key1:Key是key1还是who？]
  cMap:[who:Key是key1还是who？]
  ```
- Range：范围，它是List的一种拓展；主要用于整型的一个范围值。取值是不能数组越界
> 变量定义：Range类型变量由begin值+..+end值表示，如果不想包含最后一个元素，则begin值+..<+end值表示    
  变量的取值：aRange.get(索引)，（第一个值和最后一个可以用以下的方式；起始值：aRange.from，最后一个值：aRange.to）  
  ```
  def aRange = 1..5
  println("aRange:begin=" + aRange.from + ",end=" + aRange.to + ",size=" + aRange.size())
  println("aRange:" + aRange.last())
  def bRange = 1..<5
  println("bRange:begin=" + bRange.from + ",end=" + bRange.to + ",size=" + bRange.size())
  
  运行结果：
  aRange:begin=1,end=5,size=5
  aRange:5
  bRange:begin=1,end=4,size=4
  ```
## 闭包   
- 定义：闭包，英文名叫Closure，是一种数据类型，代表了一段可执行的代码；闭包是一段代码，所以需要用花括号括起来，->这个箭头很关键，前面表示参数定义，后面表示代码   
（注：当然没有参数的时候，可以不用箭头->）  
>定义格式如下：  
def xxx = {parameters -> code} 或者   
def xxx = {code}   //无参数，纯code时，不需要->符合
```
def aClosure = {
    String name, int age ->
        println("My name is " + name + ",I'm " + age + " years")
        //最后一句是返回值，也可以使用return，和Groovy中的普通函数一样
}
//闭包的调用
aClosure.call("李雷", 12) 
 
运行结果：  
My name is 李雷,I'm 12 years
```  
- 闭包的调用  
> 闭包对象.call(参数) 或者  
  闭包对象(参数)
  ```
  aClosure.call("李雷", 12)
  aClosure("韩梅梅", 11)
  
  运行结果：
  My name is 李雷,I'm 12 years
  My name is 韩梅梅,I'm 11 years
  ```