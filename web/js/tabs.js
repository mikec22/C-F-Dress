  var tabOne = document.getElementById("tab-nav-1");
  var tabTwo = document.getElementById("tab-nav-2");
  var tabThree = document.getElementById("tab-nav-3");

  tabOne.addEventListener("click", navigation);
  tabTwo.addEventListener("click", navigation);
  tabThree.addEventListener("click", navigation);

  function navigation() { 
    
    var getTab = this.attributes["data-tab"].value; 
    var tab = document.getElementById(getTab); 
    

    var allTab = document.getElementsByClassName("tab-item");
    var allTabNav = document.getElementsByClassName("nav");
    
    for(var i = 0; i < allTab.length; i++){
      allTab[i].classList.add("hide");
    }

    for(var i = 0; i < allTabNav.length; i++){
      allTabNav[i].classList.add("default");
    }
    
    if(tab.classList.contains("hide")){
      tab.classList.remove("hide");
    } else {
      tab.classList.add("hide");
    }
    
    if(this.classList.contains("default")){
      this.classList.remove("default");
    } 
  }

