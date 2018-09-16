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
  示例：
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
  示例：
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
  示例：
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
- 定义：闭包，英文名叫Closure，是一种数据类型，代表了一段可执行的代码；闭包是一段代码，所以需要用花括号括起来，->这个箭头很关键，前面表示参数定义，后面表示代码。   
（注：没有定义参数的时候，可以不用箭头->。此时，如果没有使用->,则闭包隐含一个参数it，和this的作用类型；如果使用->,则表示该闭包没有参数，给该闭包传参时，会报错）

>定义格式如下：  
def xxx = {parameters -> code} 或者   
def xxx = {code}   //无参数，纯code时，不需要->符号    
```
示例：
def aClosure = {
    String name, int age ->
        println("My name is " + name + ",I'm " + age + " years")
        //最后一句是返回值，也可以使用return，和Groovy中的普通函数一样
}
//闭包的调用
aClosure.call("李雷", 12) 
 
运行结果：  
My name is 李雷,I'm 12 years

//如果没有使用->,则闭包隐含一个参数it，和this的作用类型
def bClosure = {
    println("bClosure：My name is $it")
}
//等同于：
def cClosure = {it ->
    println("cClosure：My name is $it")
}
bClosure.call("小明")
cClosure.call("小红")
//没有定义参数时，且使用->，表示该闭包没有参数，不能给该闭包传参
def dClosure = { ->
    println("Hello")
}
dClosure.call()
运行结果：
bClosure：My name is 小明
cClosure：My name is 小红
dClosure：Hello
```  
- 闭包的调用  
> 闭包对象.call(参数) 或者  
  闭包对象(参数)
  ```
  示例：
  aClosure.call("李雷", 12)
  aClosure("韩梅梅", 11)
  
  运行结果：
  My name is 李雷,I'm 12 years
  My name is 韩梅梅,I'm 11 years
  ```  
- 闭包省略圆括号
> Groovy中，当函数的最后一个参数是闭包的话，可以省略圆括号  
注意：这个特点非常关键，因为在以后的Gradle中经常会出现如下的代码：  
```
 task hello {
     doLast {
         println "hello"
     }
 }
 完整的代码应该是这样的：
 task hello {
     doLast（{
         println "hello"
     }）
 }
```
```
示例：
//public static <T> List<T>each(List<T> self, Closure closure)
//此函数表示针对List的每一个元素都会调用closure做一些处理；在使用这个each函数的时候，我们传递一个怎样的Closure进去呢？如下：

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

运行结果：
12345吉米true
12345吉米true
testClosure：My name is 舒淇,I'm 18 years
I am in closure
testClosure：My name is 舒淇,I'm 18 years
I am in closure
```   
- 如何确定Closure的参数  
>  对于List的each函数所需要的Closure,它的参数是什么？有多少个参数，返回值是什么？   
   所以，Closure虽然方便，但是它一定会和使用它的上下文有极强的关联；要不，类似回调这样的东西，我们无从知道调用者需要传递什么参数给Closure。   
   如何解决？只能通过查询API文档了解上下文语义。   
   例如：对Map的findAll而言，Closure可以有两个参数，findAll会将Key和Value分别传进去，如果Closure返回true，表示该元素是自己想要的，返回
   false表示该元素不是自己要找的。