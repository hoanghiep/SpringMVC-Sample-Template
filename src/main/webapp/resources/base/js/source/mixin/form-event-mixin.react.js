/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

var FormInputEventMixin = {
    /**
     * Thay đổi input
     * @param  {[type]} event [description]
     * @return {[type]}       [description]
     */
    inputTextOnChangeHandler : function(event){
        if(this.formDataName == null){
            console.error('Chưa cấu hình tên đối tượng chứa dữ liệu của form ví dụ: doctype, department,... Hãy vào Component và thêm code ví dụ formDataName : "doctype",');
            return;
        }
        var _formData = this.state[this.formDataName];
        _formData[event.target.getAttribute('name')] = event.target.value;
        var newState = {};
        newState[this.formDataName] = _formData;
        this.setState(newState);
    },

    /**
     * Thay đổi checkbox
     * @param  {[type]} event [description]
     * @return {[type]}       [description]
     */
    checkboxOnChangeHandler : function(event){
        if(this.formDataName == null){
            console.error('Chưa cấu hình tên đối tượng chứa dữ liệu của form ví dụ: doctype, department,... Hãy vào Component và thêm code ví dụ formDataName : "doctype",');
            return;
        }
        var _formData = this.state[this.formDataName];
        _formData[event.target.getAttribute('name')] = event.target.checked ? 1 : 0;
        var newState = {};
        newState[this.formDataName] = _formData;
        this.setState(newState);
    },

    /**
     * Lấy ra giá trị đã chọn của thẻ select
     * @param  {[type]} event [description]
     * @return {[type]}       [description]
     */
    selectOnChangeHandler : function(event){
        if(this.formDataName == null){
            alert('Chưa cấu hình tên đối tượng chứa dữ liệu của form ví dụ: doctype, department,... Hãy vào Component và thêm code ví dụ formDataName : "doctype",');
            return;
        }
        var _formData = this.state[this.formDataName];
        _formData[event.target.getAttribute('name')] = event.target.value;
        _formData[event.target.getAttribute("data-other-name")] = event.target.options[event.target.selectedIndex].innerHTML;//this.options[this.selectedIndex].innerHTML
        var newState = {};
        newState[this.formDataName] = _formData;
        this.setState(newState);
    },
    
    datePickerOnChangeHandler : function(name, value){
        if(this.formDataName == null){
            alert('Chưa cấu hình tên đối tượng chứa dữ liệu của form ví dụ: doctype, department,... Hãy vào Component và thêm code ví dụ formDataName : "doctype",');
            return;
        }
        var _formData = this.state[this.formDataName];
        var date = new Date(value);
        var dateStr =  (date.getDate() < 10 ? "0" + date.getDate() : date.getDate()) + "/" + (date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : (date.getMonth() + 1)) + "/" + (date.getYear() + 1900);
        _formData[name] = date;
        _formData["temp_" + name] = dateStr;
        var newState = {};
        newState[this.formDataName] = _formData;
        this.setState(newState);
    }
};