package com.liuxuhui.groovy.container
/**
 * @author liuxuhui
 * 容器类的用法
 */
/**
 * List类：
 * 变量定义：List变量有[]定义，其元素可以是任何对象
 * 变量存取：可以直接通过索引进行存取，不用担心越界；如果索引越界，List会自己给索引添加元素。
 * （注：assert关键字，翻译为断言，用于测试时判断假设的数据是否正确）
 */
def aList = [1, "李雷", false]
println("aList=" + aList.toString())
assert aList[6] == null
aList[10] = 10 //设置第11个元素为10，其它未赋值的索引自动填充null值
println("aList.size=" + aList.size())
println("aList=" + aList.toString())

/**
 * Map类：
 * 变量定义：Map变量由[:]定义，冒号的左边是Key，右边是Value；key必须是字符串，Value可以是任何对象。Key可以用
 *         ''或""包起来，也可以不用引号包起来。（为了代码的清晰，个人建议用引号）
 * 变量存取：
 *         存值：aMap.newKey = "新元素"     取值：aMap.keyName
 */
def aMap = ["key1":1, key2:"韩梅梅"] //key不用引号包括的时候，会被默认处理成字符串"key2"
println(aMap.toString())
println("取值：" + aMap.key1)
aMap.key3 = false
println("存值：" + aMap.toString())
//如果Key不适用引号包起来，也会带来一点混淆，当Key和一个变量命名一致时，Key会是哪个？如下：
def key1 = "who"
def bMap = [key1:"Key是key1还是who？"]
def cMap = [(key1):"Key是key1还是who？"] //当Key想用一个变量的值时，需用（）包括
println(bMap.toString())
println(cMap.toString())

/**
 * Range类：Range是Groovy对List的一种扩展；主要用于整型的一个范围值。取值是不能数组越界
 * 变量定义：Range类型变量由begin值+..+end值表示，如果不想包含最后一个元素，则begin值+..<+end值表示
 * 变量的取值：aRange.get(索引)，（第一个值和最后一个可以用以下的方式；起始值：aRange.from，最后一个值：aRange.to）
 */
def aRange = 1..5
println("aRange:begin=" + aRange.from + ",end=" + aRange.to + ",size=" + aRange.size())
println("aRange:" + aRange.last())
def bRange = 1..<5
println("bRange:begin=" + bRange.from + ",end=" + bRange.to + ",size=" + bRange.size())