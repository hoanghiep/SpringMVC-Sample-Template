/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

/**
 * Component chứa toàn bộ các hiển thị về validate dữ liệu
 * Ví dụ như muốn hiển thị email nhập có đúng ko? Trường nào đó có cần nhập ko
 */

var ValidatorMixin = {

    errors : [],
    
    // Nếu có lỗi thì đưa vào danh sách lỗi
    // Nếu bớt 1 lỗi thì bỏ đi khỏi danh sách
    callbackError : function(key, hasNoError){
        var _errors = this.errors;
        if(hasNoError){
            if(_errors.indexOf(key) >= 0){
                var  index = _errors.indexOf(key);
                _errors.splice(index, 1);
            }
        }
        else{
            if(_errors.indexOf(key) < 0){
                _errors.push(key);
            }
        }
        this.errors = _errors;
    },

    basicValidation : function(){
        // Thực hiện các validate bổ sung
        // Nếu ko có validate bổ sung thì ko cần viết hàm này cũng được
        return this.errors.length == 0;
    }

};