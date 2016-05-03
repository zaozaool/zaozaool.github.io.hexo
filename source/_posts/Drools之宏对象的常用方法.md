title: Drools之宏对象的常用方法
date: 2016-04-25 08:04:24
categories: [后端]
tags: [Java, Drools]
---
#insert、update、retract
<style>table{border-collapse:collapse;border-spacing:0;border-left:1px solid#888;border-top:1px solid#888;background:#efefef}th,td{border-right:1px solid#888;border-bottom:1px solid#888;padding:5px 15px}th{font-weight:700;background:#ccc}</style><table><tr><th width="15%">方法名称</th><th width="15%">用法格式</th><th>含义</th></tr><tr><td>getWorkingMemory()</td><td>drools.getWorkingMemory()</td><td>获取当前的WorkingMemory对象</td></tr><tr><td>halt()</td><td>drools.halt()</td><td>在当前规则执行完成后，不再执行其它未执行的规则。</td></tr><tr><td>getRule()</td><td>drools.getRule()</td><td>得到当前的规则对象</td></tr><tr><td>insert(new Object)</td><td>drools.insert(new Object)</td><td>向当前的WorkingMemory当中插入指定的对象，功能与宏函数insert相同。</td></tr><tr><td>update(new Object)</td><td>drools.update(new Object)</td><td>更新当前的WorkingMemory中指定的对象，功能与宏函数update相同。</td></tr><tr><td>update(FactHandle Object)</td><td>drools.update(FactHandle Object)</td><td>更新当前的WorkingMemory中指定的对象，功能与宏函数update相同。</td></tr><tr><td>retract(new Object)</td><td>drools.retract(new Object)</td><td>从当前的WorkingMemory中删除指定的对象，功能与宏函数retract相同。</td></tr></table>
<!--more-->
#modify
```shell
modify(fact-expression){
    <修改Fact属性的表达式>[,<修改Fact属性的表达式>*] 
}

modify($customer){    
    setId("super man"),    
    setAge(30)      
}
```

#kcontext