var isMenuCollapsed = shouldMenuBeCollapsed();

this.shouldMenuBeCollapsed = shouldMenuBeCollapsed;
this.canSidebarBeHidden = canSidebarBeHidden;

this.setMenuCollapsed = function (isCollapsed) {
    isMenuCollapsed = isCollapsed;
};

this.isMenuCollapsed = function () {
    return isMenuCollapsed;
};

this.toggleMenuCollapsed = function () {
    isMenuCollapsed = !isMenuCollapsed;
};

function shouldMenuBeCollapsed() {

}

function canSidebarBeHidden() {

}


