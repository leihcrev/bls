document.write('<div id="toc" class="toc-container"></div>');
(function() {
  document.addEventListener("DOMContentLoaded", function() {
    var blogWidget = document.querySelector(".widget.Blog");
    if (blogWidget == null || typeof blogWidget === "undefined") {
      return;
    }
    var rootItem = scanBlog(blogWidget);
    if (rootItem == null || rootItem.children == null || rootItem.children.length == 0) {
      return;
    }
    if (rootItem.children.length == 1) {
      rootItem = rootItem.children[0];
      if (rootItem.children != null && rootItem.children.length == 1) {
        rootItem = rootItem.children[0];
      }
      if (rootItem.children == null || rootItem.children.length == 0) {
        return;
      }
    }
    var elemRootList = document.createElement("ul");
    rootItem.children.forEach(function(item) {
      addToCItem(elemRootList, item);
    });
    var toc = document.getElementById("toc");
    toc.insertAdjacentElement('afterbegin', elemRootList);
    toc.style.display = 'table';
  });
  function scanBlog(blogWidget) {
    var targetTag = [ "h2", "h3", "h2", "h3", "h4" ];
    var targetClass = [ "date-header", "post-title entry-title", "", "", "" ];
    var tocItemIndex = 0;
    var scanHeading = function(level, heading, parentItem) {
      var targetTagName = targetTag[level];
      var targetClassName = targetClass[level];
      var nextLevel = level + 1;
      var newId = "toc_headline_" + (++tocItemIndex);
      var newItem = {
        text : heading.innerText,
        children : [],
        level : nextLevel,
        id : newId
      };
      parentItem.children.push(newItem);
      heading.id = newId;
      var nextLevelTagName = nextLevel < targetTag.length ? targetTag[nextLevel] : "";
      if (nextLevelTagName == "") {
        return;
      }
      var nextLevelClassName = nextLevel < targetClass.length ? targetClass[nextLevel] : "";
      for (var h = heading.nextElementSibling; h != null && typeof h !== "undefined"; h = h.nextElementSibling) {
        if (h.tagName.toLowerCase() == targetTagName && h.className == targetClassName) {
          break;
        }
        if (h.tagName.toLowerCase() == nextLevelTagName && h.className == nextLevelClassName) {
          scanHeading(nextLevel, h, newItem);
        } else {
          var headings = h.getElementsByTagName(nextLevelTagName);
          for (var i = 0; i < headings.length; i++) {
            if (headings[i].className == nextLevelClassName) {
              scanHeading(nextLevel, headings[i], newItem);
            }
          }
        }
      }
    };
    var rootItem = {
      text : "",
      children : [],
      level : 0,
      id : null
    };
    var headings = blogWidget.getElementsByTagName(targetTag[0]);
    for (var i = 0; i < headings.length; i++) {
      if (headings[i].className == targetClass[0]) {
        scanHeading(0, headings[i], rootItem, "");
      }
    }
    return rootItem;
  }
  function addToCItem(elemParentList, item) {
    var elemLI = document.createElement("li");
    var elemA = document.createElement("a");
    elemA.href = "#" + item.id;
    elemA.classList.add("toc-text");
    elemA.classList.add("toc-level-" + item.level);
    elemA.innerText = item.text;
    elemLI.appendChild(elemA);
    elemParentList.appendChild(elemLI);
    if (item.children.length > 0) {
      var elemSubList = document.createElement("ul");
      elemLI.appendChild(elemSubList);
      item.children.forEach(function(child) {
        addToCItem(elemSubList, child);
      });
    }
  }
})();
