title: jQuery新旧版本共存
date: 2016-08-26 09:16:35
categories: [前端]
tags: [jQuery]
---

```javascript
<script src="jquery-1.5.js"></script>
<script src="jquery-1.11.js"></script>
<script>
  // 现在window.$和window.jQuery是1.11版本:
  console.log($().jquery); // => '1.11.0'
  var $jq = jQuery.noConflict(true);
  // 现在window.$和window.jQuery被恢复成1.5版本:
  console.log($().jquery); // => '1.5.0'
  // 可以通过$jq访问1.11版本的jQuery了
</script>
```

