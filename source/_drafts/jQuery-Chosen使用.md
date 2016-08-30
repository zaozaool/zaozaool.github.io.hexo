title: jQuery Chosen使用
date: 2016-08-26 09:22:12
categories: [前端]
tags: [jQuery]
---

#Chosen参数列表
以下参数在实例化的时候通过参数设置。
```javascript
$('.my_select_box').chosen({
  disable_search_threshold: 10,
  no_results_text: 'Oops, nothing found!',
  width: '95%'
});
```
| 选项	   					| 默认值	            | 描述          																									|
| :-------------------------|:--------------------- | :-----------------------------------------------------------------------------------------------------------------|
| allow_single_deselect		| false					|设置为 true 时非必选的单选框会显示清除选中项图标																	|
| disable_search	    	| false					|设置为 true 隐藏单选框的搜索框																						|
| disable_search_threshold	| 0						|少于 n 项时隐藏搜索框																								|
| enable_split_word_search	| true					|是否开启分词搜索，默认开启																							|
| inherit_select_classes	| false					|是否继承 select 元素的 class，如果设为 true，Chosen 将把 select 的 class 添加到容器上								|
| max_selected_options	    | Infinity				|最多选择项数，达到最大限制时会触发 chosen:maxselected 事件															|
| no_results_text	        | "No results match"	|没有搜索到匹配项时显示的文字																						|
| placeholder_text_multiple	| "Select Some Options"	|多选框没有选中项时显示的占位文字																					|
| placeholder_text_single	| "Select an Option"	|单选框没有选中项时显示的占位文字																					|
| search_contains			| false					|搜素包含项，默认从第一个字符开始匹配																				|
| single_backstroke_delete	| true					|多选框中使用退格键删除选中项目，如果设为 false，第一次按 delete/backspace 会高亮最好一个选中项目，再按会删除该项	|
| width						| Original select width.|Chosen 生成的选择框宽度，默认为和原 select 宽度保持一致															|
| display_disabled_options	| true					|是否显示禁止选择的项目																								|
| display_selected_options	| true					|多选框是否在下拉列表中显示已经选中的项																				|

#属性



http://www.cnblogs.com/change4now/p/5665128.html