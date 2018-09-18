package com.liuxuhui.groovy.io

/**
 * @author liuxhui
 * @date 2.18.09.17
 * 读文件：def aFile = new File(文件路径)，在Groovy中就是这么简单
 * 文件I/O操作
 */
def readFile = new File("/Users/liuxuhui/groovyproject/GroovyDemo/.gitignore")
//读取文件的每一行内容
readFile.eachLine {
    println(it)
}
//使用闭包操作inputStream，在Gradle里也会经常看到，操作inputStream后不用close,Groovy会自动替你close
readFile.withInputStream {
    StringBuilder stringBuilder = new StringBuilder()
    String line
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(it))
    while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line + "\n")
    }
    println("BufferedReader:\n" + stringBuilder.toString())
}
//readFile.bytes 文件内容一次性读出，等同getBytes()
println("bytes:\n" + new String(readFile.bytes))

//写文件
def targetFile = new File("./output.txt")
targetFile.withOutputStream {out ->
    readFile.withInputStream { input ->
        //copy文件
        out << input
        //重命名
        targetFile.renameTo(new File("./newname.txt"))
    }
}
