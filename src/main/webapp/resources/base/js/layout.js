/*
 * Render lại giao diện tùy theo thiết bị đang xem
 * Tạo bởi hiepth6 - 27/11/2014
 */

/**
 * 
 * @param {type} param
 */
$(document).ready(function () {
    $outline_panel = $('#outline-panel');
    $details_panel = $('#details-panel');
    $activity_panel = $('#activity-panel');
    $nav_panel = $('#nav-panel');

    $layout_menu_button = $('.layout-menu-button');
    $layout_details_button = $('.layout-details-button');
    $layout_close_button = $('.layout-close-button');
    
    $details = $('#details');
    $(window).resize(function () {
        
    });
    
    
    
    $(window).trigger('resize');
});