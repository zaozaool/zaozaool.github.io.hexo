#!/bin/bash

hexo_root=~/repositories/zaozaool.github.io.hexo
cd $hexo_root

index=0
#拼接json
dateJson="date:{"
tagJson="tag:{"
categoryJson="category:{"

for file in $(ls $hexo_root/source/_posts); do
    echo "分析文件：" $hexo_root/source/_posts/$file
    #cat "$hexo_root/source/_posts/$file" | while read line; do
    while read line; do  
        str=${line:0:5}
        #日期
        if [ "${str}x" = "date:x" ]; then
            #日期字符串
            d=${line#*:}
            d=${d#* } #去掉前面的空格
            d=${d%* } #去掉后面的空格
            dateJson=$dateJson""$index":'"$d"',"
        
        #标签
        elif [ "${str}x" = "tags:x" ]; then
            #标签字符串
            d=${line#*:} #获取所有tag
            d=${d#*[} #去掉前面的[
            d=${d%*]} #去掉后面的]
            tagJson=$tagJson""$index":'"$d"',"
        
        #标签
        elif [ "${str}x" = "categx" ]; then
            #标签字符串
            d=${line#*:} #获取所有tag
            d=${d#*[} #去掉前面的[
            d=${d%*]} #去掉后面的]
            categoryJson=$categoryJson""$index":'"$d"',"
            
        fi
    
    done < "$hexo_root/source/_posts/$file"
    (( index++ ))
done


#将数据写入到data.js
dateJson=$dateJson"$index:'_end'}"
tagJson=$tagJson"$index:'_end'}"
categoryJson=$categoryJson"$index:'_end'}"

json_data_path=$hexo_root/source/json_data

echo "_data={"$dateJson","$tagJson","$categoryJson",size:$index}" > $json_data_path/data.js
echo "分析文件完成"