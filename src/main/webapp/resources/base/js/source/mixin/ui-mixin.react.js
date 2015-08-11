/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
var TipsyMixin = {
    initializeTipsy: function() {
        $('a').tipsy();
    },

    componentDidMount: function() {
        this.initializeTipsy();
    }
};


