/**
 * Lấy thông tin user đang đăng nhập từ viewstate
 * @returns {JSON.parse.j|Array|Object}
 */

var currentUser = null;

var CurrentUser = function(){
	if(currentUser == null){
    	var user = Base64.decode(htmlDecode(window.viewState));
    	currentUser =  JSON.parse(user);
	}
	return currentUser;
};