/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

/**
 * Thực thi HTTP POST METHOD lên server
 * @param {[type]} url         [Đường dẫn đến phương thức]
 * @param {[type]} data        [Dữ liệu truyền lên]
 * @param {[type]} onCompleted [Khi hoàn thành]
 * @param {[type]} onSuccess   [Khi thành công]
 * @param {[type]} onFail     [Khi lỗi]
 */
var VPostFn = function(url, data, onSuccess, onFail,  onCompleted){
	var jqxhr = $.post( window.baseUrl + url, data, function(response) {
		if(onSuccess){
                    onSuccess(response);
		}
	})
	.fail(function() {
            if(onFail){
                onFail();
            }
	})
	.always(function() {
            if(onCompleted){
                onCompleted();
            }
	});
	return jqxhr;
};

/**
 * Thực thi HTTP GET METHOD lên server
 * @param {[type]} url         [Đường dẫn đến phương thức]
 * @param {[type]} data        [Dữ liệu truyền lên]
 * @param {[type]} onCompleted [Khi hoàn thành]
 * @param {[type]} onSuccess   [Khi thành công]
 * @param {[type]} onFail     [Khi lỗi]
 */
var VGetFn = function(url, data, onSuccess, onFail, onCompleted){
	var jqxhr = $.get( window.baseUrl + url, data, function(response) {
            if(onSuccess){
                onSuccess(response);
            }
	})
	.fail(function() {
            if(onFail){
                onFail();
            }
	})
	.always(function() {
            if(onCompleted){
                onCompleted();
            }
	});
	return jqxhr;
};