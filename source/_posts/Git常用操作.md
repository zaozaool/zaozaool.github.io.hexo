title: Git常用操作
date: 2016-10-27 11:31:05
categories: [其他]
tags: [Git]
---
#提交
git add -A
git commit -m <message>
git push origin <local_branch>:<remote_branch>

#撤销add未commit的文件
git rm --cached <added_file_to_undo>
git reset .

#删除远程分支和tag
git push origin :<branch_or_tag_name_to_delete>